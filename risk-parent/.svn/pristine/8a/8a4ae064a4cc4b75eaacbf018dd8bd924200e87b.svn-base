$(function () { 
	
	$("#disable_notice_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择发布公告");
		} else {
			var node = selected[0];
			if(node.status == "0" ){
				$.alert("该公告尚未发布,无法进行下架操作");
				return;
			}
			if(node.status == "2" ){
				$.alert("该公告已下架,请勿重复操作");
				return;
			}
			$.confirm({
				title: '',
			    content: '是否确定下架?',
			    confirm: function(){
			    	worf.ajax({
						url : ctx + '/system/notice/disableNotice',
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