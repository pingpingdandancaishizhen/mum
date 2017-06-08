var $table = $("#customer_table");
 	


$(function(){
	$("#btn_search").click(function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#remove_blacklist_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择客户");
		} else {
			$.confirm({
				title: '移除黑名单',
				content: '确认将该客户从黑名单中移除吗？',
				confirm: function(){
					worf.ajax({
						url : web_root+"/system/customer/removeBlackList",
						type : 'post',
						data : {
							licenseNum : 	selected[0].licenseNum
						},
						success : function(data) {
							if(data.status==1){
								$table.bootstrapTable('refresh');
								$.showPop(data.message,"",2000);
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
	
	$("#customer_log_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择客户");
		} else {
			var $customerLogModal = $("#customerLogModal");
			licenseNum = selected[0].licenseNum;
			operTypes = "4,5";
			$custlog_table.bootstrapTable('refresh');
			$customerLogModal.modal("show");
		}
	});
	
	$("#customer_detail_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择客户");
		} else {
			window.location.href = web_root+"/system/customer/customerDetailPage?licenseNum="+selected[0].licenseNum;
		}
	});
});

function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}