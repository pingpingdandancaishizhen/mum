<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addFieldsModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增字段</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="addFieldsForm" action="${ctx}/flow/forms/saveFields" method="post">
				 <div class="box-body">
				 		<div class="form-group">
				 			<input  type="hidden" name="bpDefId" id="bpDefId"/>
							<label for="category" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>category：</label>
							<div class="col-sm-8">
								<select name="category" class="form-control" id="category">
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="fieldKey" class="col-sm-2 control-label">fieldKey：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="fieldKey" name="fieldKey" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="fieldName" class="col-sm-2 control-label">fieldName：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="fieldName" name="fieldName" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="fieldDesc" class="col-sm-2 control-label">fieldDesc：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="fieldDesc" name="fieldDesc" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="datatype" class="col-sm-2 control-label">datatype：</label>
							<div class="col-sm-8">
								<select class="form-control" id="datatype" name="datatype">
									<option value="int">整数</option>
									<option value="string">字符串</option>
									<option value="boolean">布尔值</option>
									<option value="double">小数</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="fieldTable" class="col-sm-2 control-label">fieldTable：</label>
							<div class="col-sm-8">
								<select class="form-control" id="fieldTable" name="fieldTable">
									<option value="bp_attr">bp_attr</option>
									<option value="bp_big_attrs">bp_big_attrs</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="isAttr" class="col-sm-2 control-label">isAttr：</label>
							<div class="col-sm-8">
								<select class="form-control" id="isAttr" name="isAttr">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="checkRule" class="col-sm-2 control-label">checkRule：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="checkRule" name="checkRule" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="dataProvider" class="col-sm-2 control-label">dataProvider：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="dataProvider" name="dataProvider" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="defaultOrder" class="col-sm-2 control-label">defaultOrder：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="defaultOrder" name="defaultOrder" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="defaultValue" class="col-sm-2 control-label">defaultValue：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="defaultValue" name="defaultValue" value="">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveFieldsBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
// 注册验证
var $form=$('#addFieldsModal').find('form');
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
$("#addFieldsModal #saveFieldsBtn").off().on('click',function () {
    $form.bootstrapValidator('validate');
    if($form.data('bootstrapValidator').isValid()){
        //提交服务器
        $("#addFieldsModal #addFieldsForm").btnAjaxSubmit({
            success:function(data){
                $('#addFieldsModal').hideModal();
                $("#fields_table").bootstrapTable('resetPage');
                $("#fields_table").bootstrapTable('refresh');
            }
        });
    }
})
});

</script>