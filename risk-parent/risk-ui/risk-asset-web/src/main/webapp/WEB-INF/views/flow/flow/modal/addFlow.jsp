<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addFlowModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增用户</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="addFlowForm" action="${ctx}/flow/flow/save" method="post">
				 <div class="box-body">
				 		<div class="form-group">
							<label for="productId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>productId：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="productId" name="productId" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="productId" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>version：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="version" name="version" value="">
							</div>
						</div>
						<div class="form-group">
				                  <label  class="col-sm-2 control-label">贷款类型</label>
				                  <div class="col-sm-8">
				                  <select name="loanType" class="form-control">
				                    <option value="1">车贷</option>
				                  </select>
				                  </div>
						</div>
						<div class="form-group">
							<label for="file" class="col-sm-2 control-label">BPMN文件：</label>
							<div class="col-sm-8">
								<input type="file" class="form-control" id="file" name="file">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveFlowBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
// 注册验证
var $form=$('#addFlowModal').find('form');
$form.resetForm();
$form.validate({
	file:{
        validators: {
        	file: {
        		extension: 'bpmn',
        		message: '文件必须为bpmn文件'
            }
        }
    },
    name:{
    	validators: {
        	notEmpty: {
        		message: '请填写流程定义名称'
            }
        }
    }
});
// 绑定提交按钮
$("#addFlowModal #saveFlowBtn").off().on('click',function () {
    $form.bootstrapValidator('validate');
    if($form.data('bootstrapValidator').isValid()){
        //提交服务器
        $("#addFlowModal #addFlowForm").btnAjaxSubmit({
            success:function(data){
                $('#addFlowModal').hideModal();
                $table.bootstrapTable('resetPage');
        		$table.bootstrapTable('refresh');
            }
        });
    }
})
});

</script>