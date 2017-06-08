var $table = $("#customer_table");
 	
$("#btn_search").click(function() {
	$table.bootstrapTable('refresh');
});

$("#add_customer_btn").bind("click",function(){
	var url=web_root+"/system/customer/addCustomerPage";
	var name='新增客户';
	tools.addParentTab(url,name);
});

$("#customer_log_btn").bind("click",function(){
	var selected = $table.bootstrapTable('getSelections');
	if(selected.length === 0 ){
		$.alert("请选择客户");
	} else {
		var $customerLogModal = $("#customerLogModal");
		cid = selected[0].id;
		licenseNum = null;
		operTypes = null;
		$custlog_table.bootstrapTable('refresh');
		$customerLogModal.modal("show");
	}
});

$("#customer_detail_btn").bind("click",function(){
	var selected = $table.bootstrapTable('getSelections');
	if(selected.length === 0 ){
		$.alert("请选择客户");
	} else {
		var url=web_root+"/system/customer/customerDetailPage?id="+selected[0].id;
		var name='查看-'+selected[0].name+'客户资料';
		tools.addParentTab(url,name);
	}
});


$("#modify_customer_btn").bind("click",function(){
	var selected = $table.bootstrapTable('getSelections');
	if(selected.length === 0 ){
		$.alert("请选择修改客户");
	} else {
		var url=web_root+"/system/customer/editCustomerPage?id="+selected[0].id;
		var name='修改-'+selected[0].name+'客户资料';
		tools.addParentTab(url,name);
	}
});



$("#delete_customer_btn").bind("click",function(){
	var selected = $table.bootstrapTable('getSelections');
	if(selected.length === 0 ){
		$.alert("请选择删除客户");
	} else {
		$.confirm({
			title: '',
		    content: '是否确定删除?',
		    confirm: function(){
		    	worf.ajax({
					url : web_root+"/system/customer/deleteCustomer",
			 		type : 'post',
			 		data : {
						id : 	selected[0].id
					},
			 		success : function(data) {
			 			if(data.status==1){
			 				$.showPop(data.message,"",2000);
			 	 			$table.bootstrapTable('refresh');
			 			}else{
			 				$.showPop(data.message,"",2000);
			 			}
			 		},
			 		error : function(){
			 		}
				});
		    }
		});
	}
});

function timeFormatter(value){
	if(value && value != ''){
		// return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}

$("#apply_loan_btn").bind("click",function(){
	var selected = $table.bootstrapTable('getSelections');
	if(selected.length === 0 ){
		$.alert("请选择申请贷款的客户");
	}else{
		//弹出产品选择
		$('#selectProductModal #customerId').val(selected[0]['id']);
		$('#selectProductModal').showModal();
	}
	
});