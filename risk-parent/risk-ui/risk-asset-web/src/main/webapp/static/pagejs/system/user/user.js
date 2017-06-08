$(function(){
	$("#btn_search").click(function() {
		$table.bootstrapTable('refresh');
	});
});		

window.operateEvents = {
		'click #o_view' : function(e, value, row) {
			toViewUser(row);
		},
		'click #o_modify' : function(e, value, row) {
			toModifyUser(row);
		},
		'click #o_status' : function(e, value, row) {
			alertStatus(row);
		},
		'click #o_delete' : function(e, value, row) {
			deleteuser(row);
		},
		'click #o_password' : function(e,value,row){
			toResetpassword(row);
		}
		
};
