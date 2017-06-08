function rolechangestatus(row){
	var content,status;
	if(row.status == '0'){
		content = '确定要停用该角色吗？';
		status=1;
	}else if(row.status == '1'){
		content = '确定要启用该角色吗？';
		status=0;
	}
	$.confirm({
	    title: '',
	    content: content,
	    confirm: function(){
	    	worf.ajax({
	    		url : web_root+'/system/role/changeStatus',
	    		type : 'post',
	    		data : {'roleId':row.id,'status':status},
	    		success : function(data) {
	    			if(data.status==1){
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