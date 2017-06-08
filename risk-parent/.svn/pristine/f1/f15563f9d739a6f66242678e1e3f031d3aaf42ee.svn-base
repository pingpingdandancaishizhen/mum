function alertStatus(row){
	var content,status;
	if(row.status == '0'){
		content = '确定要停用该员工吗？';
		status=1;
	}else if(row.status == '1'){
		content = '确定要启用该员工吗？';
		status=0;
	}
	$.confirm({
	    title: '',
	    content: content,
	    confirm: function(){
	    	worf.ajax({
	    		url : web_root+'/system/user/changeStatus',
	    		type : 'post',
	    		data : {'id':row.id,'status':status},
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
