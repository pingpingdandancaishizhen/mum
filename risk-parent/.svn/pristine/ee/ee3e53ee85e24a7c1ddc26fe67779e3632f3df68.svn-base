function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}

function custNameFormatter(value ,row ,index){
	var from = window.location.href.replace(window.location.origin+web_root,"");
	return "<a class='view-customer' href='"+web_root +"/system/customer/customerDetailPage?from="+ from +"&id="+ row.customerId+"'>"+value+"</a>"; 
}
//双选时间插件使用方法
var $reservationtime_processed=$('#reservationtime_processed');
$reservationtime_processed.daterangepicker({
	ranges : {
		//'最近1小时': [moment().subtract('hours',1), moment()],
		'今日': [moment().startOf('day'), moment()],
		'昨日': [moment().subtract(1,'days').startOf('day'), moment().subtract(1,'days').endOf('day')],
		'最近7日': [moment().subtract(6,'days'), moment()],
		'最近30日': [moment().subtract(29,'days'), moment()]
	},
	"alwaysShowCalendars": true,
	"opens": "right",
	locale : {
		format : 'YYYY-MM-DD',
		applyLabel : '确定',
		cancelLabel : '取消',
		fromLabel : '起始时间',
		toLabel : '结束时间',
		customRangeLabel : '自定义',
		daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
		monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
			'七月', '八月', '九月', '十月', '十一月', '十二月' ],
		firstDay : 1
	}
}, function (start, end) {
	$("#startDate_processed").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#endDate_processed").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$reservationtime_processed.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#startDate_processed").val('');
	$("#endDate_processed").val('');
});
$reservationtime_processed.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#startDate_processed").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#endDate_processed").val(end.format('YYYY-MM-DD HH:mm:ss'));
});

function clearTime(){
	$('#reservationtime_processed').val("");
	$("#startDate_processed").val("");
	$("#endDate_processed").val("");
}

function requestData2(params) {
	var params = {
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#searchbar2').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#searchbar2').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

$(function(){
	clearTime();
	$("#btn_search_processed").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	//绑定产品变更事件，刷新流程节点选项
	$("#productType_processed").change(function(){
		flushMetaNodes_processed($("#productType_processed").val());
	});
	//初始化时单独执行获取流程节点方法
	flushMetaNodes_processed($("#productType_processed").val());
});

function flushMetaNodes_processed(product){
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
   			$("#currentTaskKey_processed").html(options.join(""));
   		}
	});
}