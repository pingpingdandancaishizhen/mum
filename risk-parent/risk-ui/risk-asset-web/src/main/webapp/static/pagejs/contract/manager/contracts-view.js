$(function(){
	$("#view_contract").bind("click",function() {
		$table = $("#processed_table");
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择合同");
		}else{
			$('#viewContractsModal').showModal();
			$('#cust_name_view').html(selected[0].custName);
			$('#contract_no_view').html(selected[0].bpNo);
			worf.ajax({
				url : web_root+"/contract/manager/queryContractsByBp",
		 		type : 'get',
		 		data : {
		 			bpId : selected[0].bpId
				},
		 		success : function(data) {
		 			if(data.status==1){
		 				var tableHtml='<thead><tr><th>ID</th><th>合同号</th><th>合同名称</th><th>操作</th></tr></thead>';
		 				var resourceHtml = [];
		 				$.each(data.data,function(i,resource){
		 					var htm = '<tr>'+
		 								'<td>'+(i+1)+'</td>'+
		 								'<td>'+resource.contractNo+'</td>'+
		 								'<td>'+resource.contractName+'</td>'+
		 								'<td><a href="'+web_root+'/getResourceById?resourceId='+resource.resource+'" target="_blank">查看</a>'+
		 							'</tr>';
		 					resourceHtml.push(htm);
		 				})
					    tableHtml+='<tbody>'+resourceHtml.join('')+'</tbody>'
		 				$("#contracts_table").html(tableHtml);
		 			}else{
		 				$.showPop(data.message,"",2000);
		 			}
		 		}
			});
		}
	});
});