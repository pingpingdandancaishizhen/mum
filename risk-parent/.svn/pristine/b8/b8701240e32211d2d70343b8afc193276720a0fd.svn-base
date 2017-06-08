$(function(){
	worf.ajax({
		url : web_root+'/system/partner/queryConfigByProduct',
		type : 'get',
		data : {
			'productId':$("#productId").val()
		},
		success : function(data) {
			if(data.status==1){
				$.each(data.data,function(i,rel){
					$("#lb_role_"+rel.roleId+"_"+rel.partnerId).addClass("active");
					$("#ip_role_"+rel.roleId+"_"+rel.partnerId).attr('checked',true);
				});
 			}else{
 				$.showPop(data.message,"",2000);
 			}
		}
	});
	
	// 注册验证
	var $form=$('#productConfigForm').find('form');
	$form.validate(proConfigOptions);

	$form.off().on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();
        // Get the form instance
        var $form = $(e.target);
        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');
        //提交服务器
		var $saveCustomerBtn=$('#saveConfigBtn');
		$saveCustomerBtn.button('loading');
		var submitData={}
		var hiddenInput=$form.find('input:hidden');
		var checkedInput=$form.find('input:checked');
		$.each(hiddenInput,function (key, item) {
			var hInput=hiddenInput.eq(key);
			var name=hInput.attr('name');
			submitData[name]=hInput.val();
		});
		var roleIds=[];
		$.each(checkedInput,function (key, item) {
			var cInput=checkedInput.eq(key);
			var value=cInput.val();
			roleIds.push(value);
		});
		submitData.roleList=roleIds.join(',');

		worf.ajax({
			url:'/system/partner/saveProductConfig',
			method:'post',
			data:submitData,
			beforeSend:function () {
				$saveCustomerBtn.button('loading')
			},
        	success:function(data){
        		if(data.status == 1){
        			$.showPop(data.message,"",2000);
			        tools.closeParentTab()
        		}else{
        			$.showPop(data.message,"",2000);
        		}
        	},
			complete:function () {
				$saveCustomerBtn.button('reset');
			}
        });
	});

	$("#productConfigForm #saveConfigBtn").bind('click',function(){
		var bootstrapValidator=$form.data('bootstrapValidator');
		bootstrapValidator.validate();
	});
	
	$("#productConfigForm #cancelBtn").bind('click',function(){
		tools.closeParentTab()
	});
});

function partnerChange(roleId,partnerId,milty){
	if($("#ip_role_"+roleId+"_"+partnerId).is(':checked') && !milty){
		$.each($(".ip_cla_"+roleId),function(i,input){
			if('ip_role_'+roleId+"_"+partnerId!=input.id){
				input.checked = false;
			}
		});
		$.each($(".lb_cla_"+roleId),function(i,lable){
			if('lb_role_'+roleId+"_"+partnerId!=lable.id){
				$(lable).removeClass("active");
			}
		});
	}
}
