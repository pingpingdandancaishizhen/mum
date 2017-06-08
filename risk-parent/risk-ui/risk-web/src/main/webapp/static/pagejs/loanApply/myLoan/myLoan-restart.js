
var $table = $("#myLoan_table");
$(function(){

	$("#myLoan_restart_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择要启用的单据");
		}else{
			if(selected[0]['bpStatus'] != '5'){
				$.alert("拒绝的单据才能启用");
				return;
			}else{
				$.confirm({
				    title: '',
				    content: "确定要重新启用该单据吗？",
				    confirm: function(){
						worf.ajax({
							url : web_root+'/loanApply/restart',
							type : 'post',
							data : {
								'bpId':selected[0]['bpId']
							},
							success : function(data) {
								if(data.status == 1){
									$.alert("启用成功");
								}else{
									$.alert(data.message);
								}
								$table.bootstrapTable('refresh');
							}
						});
				    },
				});
			}
		}
		
	});
});
