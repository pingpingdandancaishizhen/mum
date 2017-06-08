
var $custlog_table = $("#custlog_table");

var licenseNum = null;
var operTypes = null;
var cid = null;

function requestLogData(params) {
	var params = {
			cid : 	cid?cid:"",
		licenseNum : licenseNum?licenseNum:"",
		operTypes : operTypes?operTypes:"",
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#searchLogbar').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#searchLogbar').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

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
	$("#customerLogModal #startTime").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#customerLogModal #endTime").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$reservationtime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#customerLogModal #startTime").val('');
	$("#customerLogModal #endTime").val('');
});
$reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#customerLogModal #startTime").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#customerLogModal #endTime").val(end.format('YYYY-MM-DD HH:mm:ss'));
});


function clearTime(){
	$('#reservationtime').val("");
	$("#startTime").val("");
	$("#endTime").val("");
}


$(function(){
	$('#reservationtime').val("");
	
	$("#btn_log_search").click(function() {
		$custlog_table.bootstrapTable('refresh');
	});
});