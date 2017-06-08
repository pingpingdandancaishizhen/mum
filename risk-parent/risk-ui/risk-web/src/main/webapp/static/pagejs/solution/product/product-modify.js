function toModifyProduct(row){
	$('#modifyProductModal').showModal();
	var $form = $('#modifyProductForm');
	$form.find('#id').val(row.id);
	$form.find('#desc').val(row.desc);
	$form.find('#productName').val(row.productName);
	$form.find('#productType').val(row.productType);
	$form.find('#medium').val(row.medium);
	$form.find('#requirements').val(row.requirements);
	
	$form.validate({
		desc: {
			message: '产品定义验证失败',
			validators: {
				notEmpty: {
					message: '请输入产品定义'
				},
				stringLength: {
	                max: 200,
	                message: '最长200个字符'
	            },
			}
		},
		requirements: {
			message: '产品要求验证失败',
			validators: {
				notEmpty: {
					message: '请输入产品要求'
				},
				stringLength: {
	                max: 1000,
	                message: '最长1000个字符'
	            },
			}
		},
		productName: {
			validators: {
				notEmpty: {
					message: '请输入产品名称'
				},
				stringLength: {
	                max: 32,
	                message: '最长32个字符'
				}
			}
		}

	});
	//先注册监听表单验证成功事件==》验证表单
	$form.off().on('success.form.bv',function () {
		//提交服务器
		$form.btnAjaxSubmit({
			success:function(){
				$table.bootstrapTable('refresh');
				$('#modifyProductModal').hideModal();
				$.showPop('修改成功','',1000);
			}
		});
	})
	// 绑定提交按钮
	$("#modifyProductModal #modifyProductBtn").off().on('click',function () {
		var bootstrapValidator=$form.data('bootstrapValidator');
		bootstrapValidator.validate();
	});
}

