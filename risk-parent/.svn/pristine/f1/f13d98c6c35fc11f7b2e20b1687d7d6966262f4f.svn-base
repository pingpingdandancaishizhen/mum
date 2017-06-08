$(function(){
	$("#view_partner_btn").bind("click",function(){
    	var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请先选择合同参与方");
		} else {
			$("#viewContractPartnerModal").showModal();
		    worf.ajax({
				url : web_root+'/system/partner/getPartner',
				type : 'get',
				data : {
					'partnerId':selected[0].id
				},
				success : function(data) {
					if(data.status==1){
		 				$("#type_view").val(data.data.type);
		 				$("#name_view").html(data.data.name);
		 				$("#code_view").html(data.data.code);
		 				$("#phone_view").html(data.data.phone);
		 				$("#email_view").html(data.data.email);
		 				$("#fax_view").html(data.data.fax);
		 				$("#address_view").html(data.data.address+'/'+data.data.addrDetail);
		 				$("#sealResource_view").html('<a class="sign_view" href="javascript:void(0)" data-resource="'+data.data.sealResource+'">查看'+data.data.sealName+'</a>');
		 				$("#signResource_view").html('<a class="sign_view" href="javascript:void(0)" data-resource="'+data.data.signResource+'">查看'+data.data.signName+'</a>');
		 				var roleContent = [];
		 				$.each(data.data.roles,function(i,role){
		 					roleContent.push('<label class="btn btn-white active">'+role.name+'</label>');
		 					if('3'==role.id){
		 						$("#coopDeptDiv").show();
		 						$("#coopDept").val(data.data.coopDept);
		 					}
		 				});
		 				$("#roles_view").html(roleContent.join(''));
		 				if(1 == data.data.type){
		 					$("#signDiv_view").show();
		 				}
		 			}else{
		 				$.showPop(data.message,"",2000);
		 			}
				}
			});
		}
	});

	$("#addContractPartnerModal #savePartnerBtn").bind('click',function(){
		$('#addContractPartnerModal #addContractPartnerForm').submit();
	});
});
