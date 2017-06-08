function roledelete(row){
	var content = '确定要删除该角色吗？';
	$.confirm({
	    title: '',
	    content: content,
	    confirm: function(){
	    	worf.ajax({
	    		url : web_root+'/system/role/deleteRole',
	    		type : 'post',
	    		data : {'roleId':row.id},
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