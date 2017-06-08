var $BP_Operlog_table = $("#BP_Operlog_table");
var $BP_Reviewlog_table = $("#BP_Reviewlog_table");

var bpId = null;
function requestOperLogData(params) {
	var params = {
		bpId : 	bpId?bpId:"",
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#operLog #searchLogbar').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#operLog #searchLogbar').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

function requestReviewLogData(params) {
	var params = {
		bpId : 	bpId?bpId:"",
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#reviewLog #searchLogbar').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#reviewLog #searchLogbar').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

$(function(){
	/*var $table = $("#myLoan_table");*/
	$('#operLog #reservationtime,#reviewLog #reservationtime').val("");
	
	$("#myLoan_log_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择借款单");
		} else {
			var $BPLogModal = $("#BPLogModal");
			bpId = selected[0].bpId;
			$BP_Operlog_table.bootstrapTable('refresh');
			$BP_Reviewlog_table.bootstrapTable('refresh');
			$BPLogModal.modal("show");
		}
	});
	$("#myLoan_log_btn1").bind("click",function(){
		var selected = $table1.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择借款单");
		} else {
			var $BPLogModal = $("#BPLogModal");
			bpId = selected[0].bpId;
			$BP_Operlog_table.bootstrapTable('refresh');
			$BP_Reviewlog_table.bootstrapTable('refresh');
			$BPLogModal.modal("show");
		}
	});
	
	$("#operLog #btn_log_search").click(function() {
		$BP_Operlog_table.bootstrapTable('refresh');
	});
	
	$("#reviewLog #btn_log_search").click(function() {
		$BP_Reviewlog_table.bootstrapTable('refresh');
	});
});

//双选时间插件使用方法
var $operLog_reservationtime=$('#operLog #reservationtime');
$operLog_reservationtime.daterangepicker({
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
	$("#operLog #start").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#operLog #end").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$operLog_reservationtime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#operLog #start").val('');
	$("#operLog #end").val('');
});
$operLog_reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#operLog #start").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#operLog #end").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
//双选时间插件使用方法
var $reviewLog_reservationtime=$('#reviewLog #reservationtime');
$reviewLog_reservationtime.daterangepicker({
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
	$("#reviewLog #start").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#reviewLog #end").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$reviewLog_reservationtime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#reviewLog #start").val('');
	$("#reviewLog #end").val('');
});
$reviewLog_reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#reviewLog #start").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#reviewLog #end").val(end.format('YYYY-MM-DD HH:mm:ss'));
});

$("#operLog #btn_reset,#reviewLog #btn_reset").bind("click",function(){
	$(this).parent().parent().find("#start").val("");
	$(this).parent().parent().find("#end").val("");
});


function contentFormatter(value ,row ,index){
	return "状态由【" + row.pretask + "】变为【"+ row.curtask + "】 \n审核意见：【" + row.logOperType + "】 \n意见原因：【" +(row.reason == null ? "": row.reason)+"】";
}
