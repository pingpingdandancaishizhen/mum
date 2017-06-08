function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}

$(function(){
	$("#btn_search_processing1").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	//绑定产品变更事件，刷新流程节点选项
	$("#productType_processing").change(function(){
		flushMetaNodes_processing($("#productType_processing").val());
	});
	//初始化时单独执行获取流程节点方法
	flushMetaNodes_processing($("#productType_processing").val());
});

function requestData1(params) {
	var params = {
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#searchbar1').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#searchbar1').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

function flushMetaNodes_processing(product){
	worf.ajax({
		url : web_root+'/contract/manager/getBpMetaNodesByProduct',
   		type : 'get',
   		data : {
   			product:product
   		},
   		success : function(data) {
   			var options = [];
   			options.push('<option value="">请选择</option>');
   			if(data.data && data.data.length > 0){
   				$.each(data.data,function(i,node){
   					options.push('<option value="'+node.nodeKey+'">'+node.nodeName+'</option>');
   				});
   			}
   			$("#currentTaskKey_processing").html(options.join(""));
   		}
	});
}