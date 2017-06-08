<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="relateFormModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">关联表单</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="relateFormForm" action="${ctx}/flow/node/relateForm" method="post">
				 <div class="box-body">
				 		<div class="form-group">
				 			<input  type="hidden" name="bpDefId" id="bpDefId"/>
				 			<input  type="hidden" name="nodeId" id="nodeId"/>
							<label for="name" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>forms：</label>
							<div class="col-sm-8">
								<select id="formKey" name="formKey" class="form-control">
								</select>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveRelateBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
// 注册验证
var $form=$('#relateFormModal').find('form');
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
$("#relateFormModal #saveRelateBtn").off().on('click',function () {
    $form.bootstrapValidator('validate');
    if($form.data('bootstrapValidator').isValid()){
        //提交服务器
        $("#relateFormModal #relateFormForm").btnAjaxSubmit({
            success:function(data){
                $('#relateFormModal').hideModal();
                $("#node_table").bootstrapTable('resetPage');
                $("#node_table").bootstrapTable('refresh');
            }
        });
    }
})
});

</script>