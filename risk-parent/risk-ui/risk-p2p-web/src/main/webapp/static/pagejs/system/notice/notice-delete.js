$(function () { 
	
	$("#delete_notice_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择发布公告");
		} else {
			var node = selected[0];
			if(node.status == "1" ){
				$.alert("请先下架再进行删除操作");
				return;
			}
			$.confirm({
				title: '',
			    content: '是否确定删除?',
			    confirm: function(){
			    	worf.ajax({
						url : ctx + '/system/notice/deleteNotice',
				 		type : 'post',
				 		data : {
							id : 	node.id
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
	
});