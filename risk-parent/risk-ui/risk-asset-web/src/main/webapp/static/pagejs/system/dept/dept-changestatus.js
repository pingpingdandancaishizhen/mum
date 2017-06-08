$(function () {
	var $table = $('#dept_table');
	$("#enable_dept_btn").on("click",function(){
		var node = $table.bootstrapTable('getSelections');
		if(node.length === 1 && node[0].status == "0"){
			$.alert("该部门已处于启用状态,请勿重复操作");
			return ;
		} else {
			changeDeptStatus(0);
		}
	});
	
	$("#disable_dept_btn").on("click",function(){
		var node = $table.bootstrapTable('getSelections');
		if(node.length === 1 && node[0].status == "1"){
			$.alert("该部门已处于停用状态,请勿重复操作");
			return ;
		} else {
			changeDeptStatus(1);
		}
	});
	
	$("#delete_dept_btn").on("click",function(){
		var node = $table.bootstrapTable('getSelections');
		if(node.length === 1 && node[0].status != "1"){
			$.alert("删除部门必须先停用！");
			return ;
		} else {
			changeDeptStatus(2);
		}
	});
	
	function changeDeptStatus(status){
		var node = $table.bootstrapTable('getSelections');
		if(node.length === 1 ){
			worf.ajax({
		 		url : ctx + '/system/dept/changeDeptStatus',
		 		type : 'post',
		 		data : {
					id : 	node[0].id,
					status : status
				},
		 		success : function(data) {
		 			if(data.status==1){
		 				$.showPop(data.message,"",2000);
					    $table.bootstrapTable('refresh')
		 			}else{
		 				$.showPop(data.message,"",2000);
		 			}
		 		},
		 		error : function(){
		 		}
		 	});
		} else {
			$.alert("请先选择公司");
		}
	}
});