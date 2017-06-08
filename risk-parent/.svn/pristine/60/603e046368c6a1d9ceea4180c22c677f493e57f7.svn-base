<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addFormsModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增表单</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="addFormsForm" action="${ctx}/flow/forms/saveForms" method="post">
				 <div class="box-body">
				 		<div class="form-group">
				 			<input  type="hidden" name="bpDefId" id="bpDefId"/>
							<label for="formKey" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>formKey：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="formKey" name="formKey" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="formName" class="col-sm-2 control-label">formName：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="formName" name="formName" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="formDesc" class="col-sm-2 control-label">formDesc：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="formDesc" name="formDesc" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="operations" class="col-sm-2 control-label">operations：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="operations" name="operations" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="layout" class="col-sm-2 control-label">layout：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="layout" name="layout" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="isOutside" class="col-sm-2 control-label">isOutside：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="isOutside" name="isOutside" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="formHtml" class="col-sm-2 control-label">formHtml：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="formHtml" name="formHtml" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="checkRules" class="col-sm-2 control-label">checkRules：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="checkRules" name="checkRules" value="">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveFormsBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
// 注册验证
var $form=$('#addFormsModal').find('form');
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
$("#addFormsModal #saveFormsBtn").off().on('click',function () {
    $form.bootstrapValidator('validate');
    if($form.data('bootstrapValidator').isValid()){
        //提交服务器
        $("#addFormsModal #addFormsForm").btnAjaxSubmit({
            success:function(data){
                $('#addFormsModal').hideModal();
                $("#forms_table").bootstrapTable('resetPage');
                $("#forms_table").bootstrapTable('refresh');
            }
        });
    }
})
});

</script>