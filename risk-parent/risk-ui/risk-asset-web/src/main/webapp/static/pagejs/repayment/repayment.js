function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}

var $table = $("#repayment_table");

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

function unRepaymentFormatter(value ,row ,index){
	var result = parseFloat(row.debitAmount - value).toFixed(2);
//	return result < 0 ? 0: result ;
	return result ;
}


$(function(){
	$('#reservationtime').val("");
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#btn_reset").bind("click",function() {
		$("#startDate").val("");
		$("#endDate").val("");
	});
	
	$("#repayment_plan_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择还款记录");
		}else{
			var url= tools.www_root()+"/repayment/loadRepaymentPlanPage?bpId="+selected[0].bpId;
			var name='还款计划'
			tools.addParentTab(url,name)
		}
	});
	
	$("#repayment_record_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择放款记录");
			return;
		}if(selected[0].statusCode === 1 ){
			$.alert("请先操作逾期还款");
			return;
		}if(selected[0].statusCode === 2 ){
			$.alert("当前还款已提前结清");
			return;
		}if(selected[0].statusCode === 3 ){
			$.alert("当前还款已还清");
			return;
		}else{
			var url= tools.www_root()+"/repayment/loadRepaymentRecordPage?bpId="+selected[0].bpId;
			var name='正常还款录入'
			tools.addParentTab(url,name)
		}
	});
	
	$("#early_record_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择放款记录");
			return;
		}if(selected[0].statusCode === 1 ){
			$.alert("请先操作逾期还款");
			return;
		}if(selected[0].statusCode === 2 ){
			$.alert("当前还款已提前结清");
			return;
		}if(selected[0].statusCode === 3 ){
			$.alert("当前还款已还清");
			return;
		}if(selected[0].loanApprovalRepayment == '一次性还清'){
			$.alert("一次性还款不能提前结清");
			return;
		}else{
			worf.ajax({
				url : web_root+"/repayment/checkEarlyRecord",
		 		type : 'get',
		 		data : {
		 			bpId : selected[0].bpId
				},
		 		success : function(data) {
		 			if(data.status==1){
		 				var url= tools.www_root()+"/repayment/loadEarlyRecordPage?bpId="+selected[0].bpId;
					    var name='提前结清录入';
					    tools.addParentTab(url,name)
		 			}else{
		 				$.showPop(data.message,"",2000);
		 			}
		 		}
			});
		}
	});
	
	
	$("#overdue_record_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择放款记录");
			return;
		}if(selected[0].statusCode === 0 ){
			$.alert("无逾期请操作正常还款");
			return;
		}if(selected[0].statusCode === 2 ){
			$.alert("当前还款已提前结清");
			return;
		}if(selected[0].statusCode === 3 ){
			$.alert("当前还款已还清");
			return;
		}else{
			var url= tools.www_root()+"/repayment/loadOverdueRecordPage?bpId="+selected[0].bpId;
			var name='逾期还款录入'
			tools.addParentTab(url,name)
		}
	});
	
	$("#repayment_export_btn").on("click",function() {
		window.location.href = web_root+"/repayment/exportAllRepayment?"+$("#searchForm").serialize();
	});
	
});