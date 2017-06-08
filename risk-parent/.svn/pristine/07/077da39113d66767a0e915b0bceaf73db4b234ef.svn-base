$(function(){
	$("#btn_search").click(function() {
		$table.bootstrapTable('refresh');
	});
});		

window.operateEvents = {
		'click #o_modify' : function(e, value, row) {
			toModifyProduct(row);
		},
		'click #o_fee_config' : function(e, value, row) {
			var href=web_root+'/solution/product/loadProductFeeConfig?productId='+row.id;
			var name=['费用配置',row.productName].join('_');
			tools.addParentTab(href,name)
		},
		'click #o_partner_config' : function(e, value, row) {
			var href=web_root+'/system/partner/loadProductPartnerConfig?productId='+row.id;
			var name=['参与方配置',row.productName].join('_');
			tools.addParentTab(href,name)
		}
		
};
