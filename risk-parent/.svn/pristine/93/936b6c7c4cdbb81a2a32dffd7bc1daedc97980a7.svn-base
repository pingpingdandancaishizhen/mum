function deleteuser(row){
	$.confirm({
	    title: '',
	    content: "确定要删除该员工吗？",
	    confirm: function(){
	    	worf.ajax({
	    		url : web_root+'/system/user/deleteUser',
	    		type : 'post',
	    		data : {id:row.id},
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