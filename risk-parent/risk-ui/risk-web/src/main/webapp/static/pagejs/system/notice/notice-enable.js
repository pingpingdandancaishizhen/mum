$(function () { 
	
	$("#enable_notice_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		console.info(selected);
		if(selected.length === 0 ){
			$.alert("请选择发布公告");
		} else {
			var node = selected[0];
			if(node.status == "1" ){
				$.alert("该公告已发布,请勿重复操作");
				return;
			}
			worf.ajax({
				url : ctx + '/system/notice/enableNotice',
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
	
});