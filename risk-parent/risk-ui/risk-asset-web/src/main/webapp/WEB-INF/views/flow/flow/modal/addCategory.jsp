<%@ page contentType="text/html;charset=UTF-8"%>
<div class="modal" id="addCategoryModal" tabindex="-1" role="dialog" aria-expanded="true">
	<div class="modal-dialog modal-lg">
	<div class="modal-content">
		<div class="modal-header">
					<button class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">新增用户</h4>
		</div>
		<div class="modal-body">
			<div class="panel-body">
				<form onsubmit="return false;"  class="form-horizontal" id="addCategoryForm" action="${ctx}/flow/forms/saveCategory" method="post">
				 <div class="box-body">
				 		<div class="form-group">
				 			<input  type="hidden" name="bpDefId" id="bpDefId"/>
							<label for="categoryKey" class="col-sm-2 control-label"><span style="color: #FF0000;">*</span>categoryKey：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="categoryKey" name="categoryKey" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="categoryDesc" class="col-sm-2 control-label">categoryDesc：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="name" name="name" value="">
							</div>
						</div>
						<div class="form-group">
							<label for="categoryDesc" class="col-sm-2 control-label">categoryDesc：</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="categoryDesc" name="categoryDesc" value="">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="modal-footer">
			<div  class="btn btn-primary btn-primary-lg" id="saveCategoryBtn" data-loading-text="确定中...">确定</div>
			<div  class="btn btn-cancel btn-primary-lg" data-dismiss="modal">取消</div>
		</div>
	</div>
	</div>
</div>
<script type="text/javascript">
$(function(){
// 注册验证
var $form=$('#addCategoryModal').find('form');
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
$("#addCategoryModal #saveCategoryBtn").off().on('click',function () {
    $form.bootstrapValidator('validate');
    if($form.data('bootstrapValidator').isValid()){
        //提交服务器
        $("#addCategoryModal #addCategoryForm").btnAjaxSubmit({
            success:function(data){
                $('#addCategoryModal').hideModal();
                $("#category_table").bootstrapTable('resetPage');
                $("#category_table").bootstrapTable('refresh');
            }
        });
    }
})
});

</script>