
$(function(){
//	var startDate = new Date($("#repaymentTime").parent().siblings(":eq(1)").html());
//	$("#repaymentTime").datepicker({
//		format: 'yyyy-mm-dd',
//		autoclose:true,
//		todayBtn:'linked',
//		todayHighlight:true,
//		language:'zh-CN',
//		startDate:startDate,
//	},function(ev){
//		$("#overdueCount").val((new Date(ev).getTime() - new Date($("#repaymentTime").parent().siblings(":eq(1)").html()).getTime())/24/3600000);
//		console.info((new Date(ev).getTime() - new Date($("#repaymentTime").parent().siblings(":eq(1)").html()).getTime())/24/3600000);
//	});

	
	var $form=$('#repaymentRecordForm').find('form');

	
	
	$form.validate({
		repaymentTime:{
			validators: {
				notEmpty: {
					message: '请输入实际还款时间'
				}
			}
		},
		repaymentPrinciple: {
			validators: {
				notEmpty: {
					message: '请输入实还月本金'
				},
				callback: { 
					message: '还款本金输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var leftFee = parseFloat($("#principle").val());
						leftFee = (leftFee < 0 )? 0 :leftFee;
						if ( parseFloat(value) > leftFee ) {
							return { 
								valid: false, 
								message: '还款本金请勿超过应还值' 
							};
						}
						return true; 
					} 
				}
			}
		},
		repaymentInterest: {
			validators: {
				notEmpty: {
					message: '请输入实还月利息'
				},
				callback: { 
					message: '还款利息输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var leftFee = parseFloat($("#interest").val());
						leftFee = (leftFee < 0 )? 0 :leftFee;
						if ( parseFloat(value) > leftFee ) {
							return { 
								valid: false, 
								message: '还款利息请勿超过应还值' 
							};
						}
						return true; 
					} 
				}
			}
		},
		repaymentManageFee:{
			validators: {
				notEmpty: {
					message: '请输入实还月管理费'
				},
				callback: { 
					message: '还款管理费输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var leftFee = parseFloat($("#manageFee").val());
						leftFee = (leftFee < 0 )? 0 :leftFee;
						if ( parseFloat(value) > leftFee ) {
							return { 
								valid: false, 
								message: '还款管理费请勿超过应还值' 
							};
						}
						return true; 
					} 
				}
			}
		},
		repaymentExtraFee:{
			validators: {
				notEmpty: {
					message: '请输入实还GPS服务费'
				},
				callback: { 
					message: '还款GPS服务费输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var leftFee = parseFloat($("#extraFee").val());
						leftFee = (leftFee < 0 )? 0 :leftFee;
						if ( parseFloat(value) > leftFee ) {
							return { 
								valid: false, 
								message: '还款GPS服务费请勿超过应还值' 
							};
						}
						return true; 
					} 
				}
			}
		},
		repaymentExtraFee2:{
			validators: {
				notEmpty: {
					message: '请输入实还停车费'
				},
				callback: { 
					message: '还款停车费输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var leftFee = parseFloat($("#extraFee2").val());
						leftFee = (leftFee < 0 )? 0 :leftFee;
						if ( parseFloat(value) > leftFee ) {
							return { 
								valid: false, 
								message: '还款停车费请勿超过应还值' 
							};
						}
						return true; 
					} 
				}
			}
		},
		overdueFee:{
//			trigger:'change',
			validators: {
				notEmpty: {
					message: '请输入逾期滞纳金'
				},
				callback: { 
					message: '逾期滞纳金输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var maxOverdueFee = parseFloat($("#maxOverdueFee").val()).toFixed(2);
						var overdueDerate = ($("#overdueDerate").val() == "" ? 0 : parseFloat($("#overdueDerate").val()));
						maxOverdueFee = (maxOverdueFee < 0 )? 0 :maxOverdueFee;
						if ( parseFloat(value) + overdueDerate > maxOverdueFee ) {
							return { 
								valid: false, 
								message: '罚息减免与罚息之和不能超过应缴金额' 
							};
						}
						if(validator.isValidField("overdueDerate") === false){
							validator.revalidateField("overdueDerate");
						}
						return true; 
					} 
				}
			}
		},
		overdueDerate:{
//			trigger:'change',
			validators: {
				notEmpty: {
					message: '请输入罚息减免'
				},
				callback: { 
					message: '罚息减免输入错误', 
					callback: function(value, validator, $field) { 
						if (value === '') { 
							return true; 
						} 
						if ( !/^([1-9]\d{0,9}(\.\d{0,2})?)$|^(0(\.\d{0,2})?)$/.test(value) ){
							return { 
								valid: false, 
								message: '金额输入错误' 
							};
						}
						var maxOverdueFee = parseFloat($("#maxOverdueFee").val()).toFixed(2);
						var overdueFee = ($("#overdueFee").val() == "" ? 0 : parseFloat($("#overdueFee").val()));
						maxOverdueFee = (maxOverdueFee < 0 )? 0 :maxOverdueFee;
						if ( parseFloat(value) + overdueFee > maxOverdueFee ) {
							return { 
								valid: false, 
								message: '罚息减免与罚息之和不能超过应缴金额' 
							};
						}
						if(validator.isValidField("overdueFee") === false){
							validator.revalidateField("overdueFee");
						}
						return true; 
					} 
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
