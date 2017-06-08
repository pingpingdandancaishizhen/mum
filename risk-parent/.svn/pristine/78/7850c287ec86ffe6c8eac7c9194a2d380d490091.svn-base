$("#selectProductModal #selectProductBtn").off().on('click',function () {
	//查询是否有正在进行的单子
/*	worf.ajax({
		url : web_root+'/loan/hasLoan',
		type : 'post',
		data : {
			'productId':$('#selectProductModal #productId').val(),
			'customerId':$('#selectProductModal #customerId').val()
		},
		success : function(data) {
			if(data.status==1){
				//如果有贷款
				if(data.data){
					$.alert('该客户同类型产品已经有借款申请单');
				}else{*/
					worf.ajax({
						url : web_root+'/loan/getStartParam',
						type : 'post',
						data : {
							'productId':$('#selectProductModal #productId').val(),
							'customerId':$('#selectProductModal #customerId').val()
						},
						success : function(data) {
							if(data.status==1){
								var url=web_root+"/pages/form.html?"+$.param(data.data);
								var name='申请借款';
								$('#selectProductModal').hideModal();
								tools.addParentTab(url,name);
								
								// 	window.location.href=web_root+"/pages/form.html?"+$.param(data.data)
							}
						}
					});
				/*}
			}
		}
	});*/
	//跳转页面
	//window.location.href=web_root+'/system/customer/loadApplyLoan?productId='+$("#selectProductModal #productId").val();
})