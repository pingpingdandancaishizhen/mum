function timeFormatter(value){
	if(value && value != ''){
		return new Date(value).toLocaleDateString();
	}
}

var $table = $("#allLoan_table");

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
	$("#startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$reservationtime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#startDate").val('');
	$("#endDate").val('');
});
$reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});


function clearTime(){
	$('#reservationtime').val("");
	$("#startDate").val("");
	$("#endDate").val("");
}

$(function(){

	$("#btn_reset").bind("click",function() {
		$("#startDate").val("");
		$("#endDate").val("");
	});
	
	$('#reservationtime').val("");
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#allLoan_plan_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择放款记录");
		}else{
			var url= tools.www_root()+"/loanManager/loadLoanPlanPage?bpId="+selected[0].bpId;
			var name='放款计划'
			tools.addParentTab(url,name)
		}
	});
	
	$("#allLoan_record_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择放款记录");
		} else if(selected[0].loanStatus == '放款完成' ){
			$.alert("当前放款已录入");
		} else {
			var url= tools.www_root()+"/loanManager/loadLoanRecordPage?bpId="+selected[0].bpId;
			var name='放款录入'
			tools.addParentTab(url,name)
		}
	});
	
	$("#allLoan_export_btn").on("click",function() {
		window.location.href = web_root+"/loanManager/exportAllLoan?"+$("#searchForm").serialize();
	});

});