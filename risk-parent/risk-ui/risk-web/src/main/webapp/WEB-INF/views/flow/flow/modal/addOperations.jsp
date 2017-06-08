<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addOperationsModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增操作</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="addOperationsForm" action="${ctx}/flow/forms/saveOperations" method="post">
				 <div class="box-body">
				 		<div class="form-group">
				 			<input  type="hidden" name="bpDefId" id="bpDefId"/>
							<label for="operKey" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>operKey：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="operKey" name="operKey" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="operName" class="col-sm-2 control-label">operName：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="operName" name="operName" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="operDesc" class="col-sm-2 control-label">operDesc：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="operDesc" name="operDesc" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="binding" class="col-sm-2 control-label">binding：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="binding" name="binding" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="operType" class="col-sm-2 control-label">operType：</label>
							<div class="col-sm-8">
								<select class="form-control" id="operType" name="operType">
									<option value="-1">回退</option>
									<option value="1">通过</option>
									<option value="2">拒绝</option>
									<option value="0">保存</option>
									<option value="3">其他</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="isBasic" class="col-sm-2 control-label">isBasic：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="isBasic" name="isBasic" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="preCondition" class="col-sm-2 control-label">preCondition：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="preCondition" name="preCondition" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="postCondition" class="col-sm-2 control-label">postCondition：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="postCondition" name="postCondition" value="">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveOperationsBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
// 注册验证
var $form=$('#addOperationsModal').find('form');
$form.resetForm();
$form.validate({
	name:{
        validators: {
        	notEmpty: {
        		message: '请填写字段类型名称'
            }
        }
    }
});
// 绑定提交按钮
$("#addOperationsModal #saveOperationsBtn").off().on('click',function () {
    $form.bootstrapValidator('validate');
    if($form.data('bootstrapValidator').isValid()){
        //提交服务器
        $("#addOperationsModal #addOperationsForm").btnAjaxSubmit({
            success:function(data){
                $('#addOperationsModal').hideModal();
                $("#operations_table").bootstrapTable('resetPage');
                $("#operations_table").bootstrapTable('refresh');
            }
        });
    }
})
});

</script>