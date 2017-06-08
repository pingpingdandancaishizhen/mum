window.operateEvents = {
		'click #o_form' : function(e, value, row) {
			showRelateForm(row);
		},
		'click #o_query_form' : function(e, value, row) {
			showRelateQueryForm(row);
		}
};