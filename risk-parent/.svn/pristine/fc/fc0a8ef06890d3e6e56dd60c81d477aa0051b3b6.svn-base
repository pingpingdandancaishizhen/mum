$("#loanTime").datepicker({
	format: 'yyyy-mm-dd',
	autoclose:true,
	todayBtn:'linked',
	todayHighlight:true,
	language:'zh-CN',
},function () {
	$("#loanTime").trigger('change');
});

$(function(){
	var $form=$('#loanPlanRecordForm').find('form');

	$form.validate({
		loanAmount:{
			validators: {
				notEmpty: {
					message: '请输入放款额'
				},
				callback: { 
					message: '放款额输入错误', 
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
						var leftFee = parseFloat($("#maxloanAmount").val());
						leftFee = (leftFee < 0 )? 0 :leftFee;
						if ( parseFloat(value) > leftFee ) {
							return { 
								valid: false, 
								message: '放款额请勿超过应放款额' 
							};
						}
						return true; 
					} 
				}
			}
		},
		loanPlatform: {
			validators: {
				notEmpty: {
					message: '请输入放款平台'
				}
			}
		},
		loanLender: {
			validators: {
				notEmpty: {
					message: '请输入放款人'
				}
			}
		},
		loanTime:{
			trigger:'change',
			validators: {
				notEmpty: {
					message: '请选择放款时间'
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
		var $saveCustomerBtn=$('#saveLoanRecordBtn');
		$saveCustomerBtn.button('loading');
		$form.btnAjaxSubmit({
			success:function(data){
				if(data.status == 1){
					$.showPop(data.message,"",2000);
					window.setTimeout(function(){
						var url=tools.getCurrentIFrameUrl();
						var refreshUrl="/loanManager/loadAllLoanPage";
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
	$("#loanPlanRecordForm #saveLoanRecordBtn").off().on('click',function(){
		var bootstrapValidator=$form.data('bootstrapValidator');
		bootstrapValidator.validate();
	});
	
	$("#cancelBtn").bind("click",function(){
		var url=tools.getCurrentIFrameUrl();
		tools.closeParentTab(url)
	});
});
//注册验证
