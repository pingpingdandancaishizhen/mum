$(function(){
	$table.on("check.bs.table",function(e,row){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length > 0 ){
			var node = selected[0];
			$("#delete_notice_btn,#disable_notice_btn,#enable_notice_btn").removeClass("disabled");
			$("#delete_notice_btn,#disable_notice_btn,#enable_notice_btn").prop("disabled",false);
			if(node.status == "1" ){
				//不可删除和发布
				$("#delete_notice_btn,#enable_notice_btn").addClass("disabled");
				$("#delete_notice_btn,#enable_notice_btn").prop("disabled",true);
			}
			if(node.status == "0" || node.status == "2"){
				$("#disable_notice_btn").addClass("disabled");
				$("#disable_notice_btn").prop("disabled",true);
			}
		}
	});
});