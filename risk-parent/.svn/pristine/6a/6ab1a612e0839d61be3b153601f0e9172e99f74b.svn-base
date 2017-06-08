$(function () { 
	var $addNoticeModal = $("#addNoticeModal");
	
	$("#add_notice_btn").on("click",function(){
		$addNoticeModal.showModal("show");
		var $form=$('#addNoticeForm').find('form');
		$form.resetForm();
		$form.validate({
			artContent:{
				validators: {
					notEmpty: {
						message: '公告内容不能为空'
					},
					 stringLength: {
                         min: 2,
                         max: 100,
                         message: '请输入2-100个字符'
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
						$addNoticeModal.hideModal("hide");
					}else{
						$.showPop(data.message,"",2000);
					}

				}
			});
		});
		$("#addNoticeModal #saveNoticeBtn").off().on("click",function(){
			var bootstrapValidator=$form.data('bootstrapValidator');
			bootstrapValidator.validate();
		});
	});

});