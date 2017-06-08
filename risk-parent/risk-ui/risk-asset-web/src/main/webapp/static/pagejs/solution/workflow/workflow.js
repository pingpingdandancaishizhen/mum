$(function(){
	$("#btn_search").click(function() {
		$table.bootstrapTable('refresh');
	});
});		

window.operateEvents = {
		'click #o_manager' : function(e, value, row) {
			toNodeAssign(row);
		},
		'click #o_form' : function(e, value, row) {
			toNodeForm(row);
		},
		'click #o_deploy' : function(e, value, row) {
			acitiviDeploy(row);
		}
};
