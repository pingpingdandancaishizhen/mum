var $table = $("#channel_table");
 	
$("#btn_search").click(function() {
	$table.bootstrapTable('refresh');
});

$("#btn_add").bind("click",function(){
	var url=web_root+"/channel/edit";
	var name='新增渠道商';
	tools.addParentTab(url,name);
});

$("#btn_modify").bind("click",function(){
	var selected = $table.bootstrapTable('getSelections');
	if(selected.length === 0 ){
		$.alert("请选择修改渠道商");
	} else {
		var url=web_root+"/channel/edit?channelId="+selected[0].channelId;
		var name='修改渠道商';
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
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss');
	}
}