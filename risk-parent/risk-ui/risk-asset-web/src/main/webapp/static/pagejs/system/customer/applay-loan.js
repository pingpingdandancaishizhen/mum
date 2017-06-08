$("#selectProductModal #selectProductBtn").off().on('click',function () {
	var customerId = $('#selectProductModal #customerId').val();
	var productId = $('#selectProductModal #productId').val();
	if(customerId != '-1'){
		worf.ajax({
			url : web_root+'/loan/getStartParam',
			type : 'post',
			data : {
				'productId':productId,
				'customerId':customerId
			},
			success : function(data) {
				if(data.status==1){
					var name='待办-新增申请-'+$('#selectProductModal').find('option[value="'+productId+'"]').text();
					var url=web_root+"/pages/form.html?"+$.param(data.data)+"&title="+encodeURI(name);
					$('#selectProductModal').hideModal();
					tools.addParentTab(url,name);
				}
			}
		});
	}else{
		$('#selectCustomerModal').showModal();
		var userCorpId = $("select[name='userCorpId']").val();
		$("#uid").val(userCorpId);
		$customer_table.bootstrapTable('refresh');
	}
})