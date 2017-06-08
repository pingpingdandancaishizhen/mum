
$(function(){
	var endDate = new Date($("#issueDate").val());
	var eachTimes = $("#eachTimes").val();
	var eachTimesType = eachTimes.substr(0,1);
	var eachTimesCount = parseInt(eachTimes.substr(1));
	
	var startDate = new Date($("#issueDate").val());
	if( eachTimesType == "M" ){
		startDate.setMonth(startDate.getMonth() - eachTimesCount);
	}else if(eachTimesType == "D"){
		startDate.setDate(startDate.getDate() - eachTimesCount);
	} 
	
	$("#repaymentTime").datepicker({
		format: 'yyyy-mm-dd',
		autoclose:true,
		todayBtn:'linked',
		todayHighlight:true,
		language:'zh-CN'
//			,
//		startDate:startDate,
//		endDate:endDate
	});

	$("#cancelBtn").bind("click",function(){
		var url=tools.getCurrentIFrameUrl();
		tools.closeParentTab(url)
	});
	
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
		}
	});

	$form.off().on('success.form.bv', function(e) {
		e.preventDefault();
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
