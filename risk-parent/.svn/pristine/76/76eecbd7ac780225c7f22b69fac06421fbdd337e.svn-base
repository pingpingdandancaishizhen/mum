$(function () { 
	var $modifyNoticeModal = $("#modifyNoticeModal");
	
	$("#edit_notice_btn").on("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择发布公告");
			return;
		} else {
			var node = selected[0];
			$modifyNoticeModal.showModal("show");
			$modifyNoticeModal.find("#artContent").html(node.artContent);
			$modifyNoticeModal.find("#typeId").val(node.typeId);
			$modifyNoticeModal.find("#id").val(node.id);
		}
		var $form=$('#modifyNoticeForm').find('form');
		$form.validate({
			artContent:{
				validators: {
					notEmpty: {
						message: '公告内容不能为空'
					}
				}
			},
			typeId: {
				validators: {
					notEmpty: {
						message: '请选择公告类型'
					}
				}
			}
		});
		$form.off('success.form.bv').on('success.form.bv',function () {
			//提交服务器
			$form.btnAjaxSubmit({
				success:function(data){
					if(data.status == 1){
						$.showPop(data.message,"",2000);
						$table.bootstrapTable('refresh');
						/*$("#addNoticeModal #addNoticeForm").resetForm();
						 bv.resetForm();*/
						$modifyNoticeModal.hideModal("hide");
					}else{
						$.showPop(data.message,"",2000);
					}

				}
			});
		});
		$("#modifyNoticeModal #saveNoticeBtn").off().on("click",function(){
			var bootstrapValidator=$form.data('bootstrapValidator');
			bootstrapValidator.validate();
		});
	});

});