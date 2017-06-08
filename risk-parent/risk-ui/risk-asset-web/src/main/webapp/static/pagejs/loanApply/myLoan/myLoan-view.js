
var $table = $("#myLoan_table");
$(function(){
	$("#myLoan_view_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择要查看的单据");
		}else{
			worf.ajax({
				url : web_root+'/loan/getStartParamView',
				type : 'post',
				data : {
					'bpId':selected[0]['bpId']
				},
				success : function(data) {
					if(data.status==1){
						var name='查看-'+selected[0]['custName']+'的借款';
						var url=web_root+"/pages/form.html?"+$.param(data.data)+"&title="+encodeURI(name);

						tools.addParentTab(url,name);
						
						// 	window.location.href=web_root+"/pages/form.html?"+$.param(data.data)
					}
				}
			});
		}
		
	});
	
	
});
