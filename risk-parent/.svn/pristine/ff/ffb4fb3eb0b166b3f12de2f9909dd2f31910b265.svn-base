var $table = $("#customer_table");
 	


$(function(){
	$("#btn_search").click(function() {

		$table.bootstrapTable('refresh');
	});
	
	$("#customer_detail_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择客户");
		} else {
			var url=web_root+"/system/customer/customerDetailPage?from="+ window.location.href.split(web_root)[1]+"&licenseNum="+selected[0].licenseNum;
			var name='查看-'+selected[0].name+'客户资料';
			tools.addParentTab(url,name);
		}
	});
	
	$("#add_blacklist_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择客户");
		} else {
			$.confirm({
				title: '',
				content: '是否确定加入黑名单?',
				confirm: function(){
					worf.ajax({
						url : web_root+"/system/customer/addBlackList",
						type : 'post',
						data : {
							licenseNum : 	selected[0].licenseNum
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
	
	$("#customer_log_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择客户");
		} else {
			var $customerLogModal = $("#customerLogModal");
			licenseNum = selected[0].licenseNum;
			$custlog_table.bootstrapTable('refresh');
			$customerLogModal.modal("show");
		}
	});
});

function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}