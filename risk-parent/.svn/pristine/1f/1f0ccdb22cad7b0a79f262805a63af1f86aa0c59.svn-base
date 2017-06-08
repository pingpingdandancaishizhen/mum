function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY-MM-DD')
	}
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

$(function(){
	$("#startDate").val(moment().startOf('day').format('YYYY-MM-DD HH:mm:ss'))
	$("#endDate").val(moment().endOf('day').format('YYYY-MM-DD HH:mm:ss'))
	getDayAudit();
	$("#btn_search").on("click",function() {
		//查询 拼装数据表格
		if($("#reservationtime").val() == ''){
			$.alert('请选择起止时间');
			return;
		}
		getDayAudit();

	});
});
function getDayAudit() {
	var $dayAuditTable=$("#day_audit_table");
	worf.ajax({
		url : web_root+'/loanaudit/queryDayAuditManager',
		type : 'post',
		data : {
			startDate:$("#startDate").val(),
			endDate:$("#endDate").val()
		},
		beforeSend:function () {
			$('.fixed-table-loading').show()
		},
		success : function(data) {
			if(data.data&&data.data.length>0||!$.isEmptyObject(data.data)){
				packageData(data.data);
			}else{
				$dayAuditTable.html('<tr class="no-records-found"><td colspan="4" align="center">没有找到匹配的记录</td></tr>')
			}
		},
		error:function () {
			$dayAuditTable.html('<tr class="no-records-found"><td colspan="4" align="center">没有找到匹配的记录</td></tr>');
		},
		complete:function () {
			$('.fixed-table-loading').hide()
		}
	});
}
function packageData(data){
	var tableHtmlArr=[];
	for(var tmp in data){
		var rows = data[tmp];
		for(var i=0;i<rows.length;i++){
			if(i == 0){
				tableHtmlArr.push('<tr><td rowspan="'+rows.length+'">'+rows[i].days+'</td><td>'+gettodo(rows[i])+'</td><td>'
						+getdone(rows[i]) +'</td><td>'+getduration(rows[i])+'</td></tr>');
			}else{
				tableHtmlArr.push('<tr><td>'+gettodo(rows[i])+'</td><td>'
						+getdone(rows[i]) +'</td><td>'+getduration(rows[i])+'</td></tr>');
			}
		}
		
	}
	$("#day_audit_table").html(tableHtmlArr.join(''));
}
function gettodo(r){
	return r.nodeName+'：'+r.todo+'笔';
}
function getdone(r){
	return  r.nodeName+'：通过'+r.pass+'笔,回退'+r.back+'笔,拒绝'+r.reject+'笔';
}
function getduration(r){
	return r.nodeName+'：'+r.duration.toFixed(1)+'分钟/笔';
}