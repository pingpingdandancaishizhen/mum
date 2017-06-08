function showRelateForm(row){
	//获取所有FORM
	$('#relateFormModal').showModal();
	$('#relateFormModal #formKey').empty();
	$('#relateFormModal #bpDefId').val('');
	$('#relateFormModal #nodeId').val('');
	worf.ajax({
		url : web_root+'/solution/workflow/getFormByBpDefId',
		type : 'post',
		data : {bpDefId:row.bpDefId},
		success : function(data) {
			var forms = data.data;
			$.each(forms,function(i,value){
				$('#relateFormModal #formKey').append('<option value="'+value.formKey+'">'+value.formName+'</option>');
				$('#relateFormModal #bpDefId').val(row.bpDefId);
				$('#relateFormModal #nodeId').val(row.nodeId);
				$('#relateFormModal #formKey').val(row.formKey);
			});
		}
	});
	var $form=$('#relateFormModal').find('form');
    $form.resetForm();
    $form.validate({
 	   formKey:{
            validators: {
                notEmpty: {
                    message: '请选择表单'
                }
            }
        }
    });
    // 先注册监听表单验证成功事件==》验证表单
	$form.off().on('success.form.bv',function () {
        //提交服务器
        $("#relateFormModal #relateFormForm").btnAjaxSubmit({
            success:function(data){
                $table.bootstrapTable('refresh');
                $('#relateFormModal').hideModal();
                $.showPop('关联表单成功');
            }
        });
    });
    // 绑定提交按钮
    $("#relateFormModal #relateFormBtn").off().on('click',function () {
        var bootstrapValidator=$form.data('bootstrapValidator');
        bootstrapValidator.validate();

    })
}
 