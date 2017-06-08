function acitiviDeploy(row){
	$.confirm({
	    title: '',
	    content: "确定部署该流程吗？",
	    confirm: function(){
	    	worf.ajax({
	    		url : web_root+'/solution/p2pworkflow/deploy',
	    		type : 'post',
	    		data : {bpDefId:row.bpDefId},
	    		success : function(data) {
	    			if(data.status==1){
	    				$.alert('部署成功');
	    				$table.bootstrapTable('refresh');
	    			}else{
	    				$.alert(data.message);
	    			}
	    		},
	    		error : function(){
	    		}
	    	});
	    },
	});
}