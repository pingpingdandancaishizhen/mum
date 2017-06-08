function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}
function custNameFormatter(value ,row ,index){
	var from = window.location.href.replace(window.location.origin+web_root,"");
	return "<a class='view-customer' href='"+web_root +"/system/customer/customerDetailPage?from="+ from +"&id="+ row.customerId+"'>"+value+"</a>"; 
}

var $table = $("#all_audit_table");
var $table1 = $("#history_audit_table");


function clearTime(){
	$('#reservationtime').val("");
	$("#startDate").val("");
	$("#endDate").val("");
}

$(function(){

	$table.on('click','.view-customer',function (e) {
		e.preventDefault();
		var href=$(this).attr('href');
		var name=$(this).text()+'资料';
		tools.addParentTab(href,name);
	})
	$table1.on('click','.view-customer',function (e) {
		e.preventDefault();
		var href=$(this).attr('href');
		var name=$(this).text()+'资料';
		tools.addParentTab(href,name);
	})
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#btn_search1").bind("click",function() {
		$table1.bootstrapTable('refresh');
	});
	$("#btn_reset").bind("click",function() {
		 $("#searchbar").find('form')[0].reset();
		 $("#searchbar").find("form input[type='hidden']").val('');
	});
	
	$("#btn_reset1").bind("click",function() {
		$("#searchbar1").find('form')[0].reset();
		$("#searchbar1").find("form input[type='hidden']").val('');
	});

	//双选时间插件使用方法
	var $reservationtime=$('#reservationtime');
	$reservationtime.daterangepicker({
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
		$("#searchbar #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$reservationtime.on('cancel.daterangepicker',function () {
		$(this).val('');
		$("#searchbar #startDate").val('');
		$("#searchbar #endDate").val('');
	});
	$reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
		var start=daterangepicker.startDate;
		var end=daterangepicker.endDate;
		$("#searchbar #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	//双选时间插件使用方法
	var $reservationtime1=$('#reservationtime1');
	$reservationtime1.daterangepicker({
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
		$("#searchbar1 #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar1 #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$reservationtime1.on('cancel.daterangepicker',function () {
		$(this).val('');
		$("#searchbar1 #startDate").val('');
		$("#searchbar1 #endDate").val('');
	});
	$reservationtime1.on('apply.daterangepicker',function (el,daterangepicker) {
		var start=daterangepicker.startDate;
		var end=daterangepicker.endDate;
		$("#searchbar1 #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar1 #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$('#reservationtime').val("");
	$('#reservationtime1').val("");
	
	//绑定产品变更事件，刷新流程节点选项
	$("#productType_all").change(function(){
		flushAllLoanMetaNodes($("#productType_all").val());
	});
	$("#productType_hist").change(function(){
		flushHistLoanMetaNodes($("#productType_hist").val());
	});
	//初始化时单独执行获取流程节点方法
	flushAllLoanMetaNodes($("#productType_all").val());
	flushHistLoanMetaNodes($("#productType_hist").val());
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
function flushAllLoanMetaNodes(product){
	worf.ajax({
		url : web_root+'/loanaudit/getBpMetaNodesByProduct',
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
   			$("#currentTaskKey_all").html(options.join(""));
   		}
	});
}
function flushHistLoanMetaNodes(product){
	worf.ajax({
		url : web_root+'/loanaudit/getBpMetaNodesByProduct',
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
   			$("#currentTaskKey_hist").html(options.join(""));
   		}
	});
}