
$(function(){
	
	var $form=$('#repaymentRecordForm').find('form');

	$form.validate({
		settlementDate:{
			validators: {
				notEmpty: {
					message: '请输入实际还款时间'
				}
			}
		},
		settlementReason: {
			trigger:'change',
			validators: {
				notEmpty: {
					message: '请选择结清原因'
				}
			}
		},
		settlementPrinciple: {
			validators: {
				notEmpty: {
					message: '请输入剩余本金'
				},
				regexp: {
					regexp: /^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		},
		settlementInterest:{
			validators: {
				notEmpty: {
					message: '请输入剩余利息(本期已产生的)'
				},
				regexp: {
					regexp: /^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		},
		settlementManageFee:{
			validators: {
				notEmpty: {
					message: '请输入剩余管理费'
				},
				regexp: {
					regexp: /^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		},
		settlementPenalty:{
			validators: {
				notEmpty: {
					message: '请输入提前还款罚息(违约金)'
				},
				regexp: {
					regexp: /^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		},
		towingFee:{
			validators: {
				notEmpty: {
					message: '请输入拖车费'
				},
				regexp: {
					regexp: /^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		},
		parkingFee:{
			validators: {
				notEmpty: {
					message: '请输入停车费'
				},
				regexp: {
					regexp: /^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		}
	});

	$form.off().on('success.form.bv', function(e) {
		// Prevent form submission
		e.preventDefault();
		// Get the form instance
		var $form = $(e.target);
		// Get the BootstrapValidator instance
		var bv = $form.data('bootstrapValidator');
		//提交服务器
		var $saveCustomerBtn=$('#saveRepaymentRecordBtn');
		$saveCustomerBtn.button('loading');
		$form.btnAjaxSubmit({
			success:function(data){
				if(data.status == 1){
					$.showPop(data.message,"",2000);
					window.setTimeout(function(){
						var url=tools.getCurrentIFrameUrl();
						var refreshUrl="/repayment/loadRepaymentPage";
						tools.closeParentTab(url,refreshUrl)
					},2000);
				}else{
					$.showPop(data.message,"",2000);
				}
			},
			complete:function () {
				$saveCustomerBtn.button('reset');
			}
		});
	});
	$("#saveRepaymentRecordBtn").off().on('click',function(){
		var bootstrapValidator=$form.data('bootstrapValidator');
		bootstrapValidator.validate();
	});
});
//注册验证
