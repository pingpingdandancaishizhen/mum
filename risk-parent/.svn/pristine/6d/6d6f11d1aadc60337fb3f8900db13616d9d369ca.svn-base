function roledelete(row){
	var content = '确定要删除该角色吗？';
	$.confirm({
	    title: '',
	    content: content,
	    confirm: function(){
	    	worf.ajax({
	    		url : web_root+'/system/dataRole/deleteRole',
	    		type : 'post',
	    		data : {'roleId':row.id},
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
	    },
	});
}