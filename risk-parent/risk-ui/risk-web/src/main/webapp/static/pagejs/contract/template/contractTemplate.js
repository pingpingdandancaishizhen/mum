function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}

function indexFormatter(value, row, index){
	return index+1;
}

function checkBoxFormatter(value, row, index){
	if(row.status === 0){
		return '<input data-index="'+index+'" name="id" type="checkbox" disabled="disabled">';
	}else{
		return '<input data-index="'+index+'" name="id" type="checkbox">';
	}
}

function contractViewFormatter(value, row, index){
	if(row.fileResource){
		return '<a href="'+web_root+'/getResourceById?resourceId='+row.fileResource+'" target="_blank">查看</a>';
	} else {
		return '-';
	}
}

function clearTime(){
	$('#createTime').val("");
	$("#startTime").val("");
	$("#endTime").val("");
}

function statusFormatter(value){
	if(value && value == 1){
		return "正常";
	}else {
		return "停用";
	}
}
//双选时间插件使用方法
var $createTime=$('#createTime');
$createTime.daterangepicker({
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
	$("#startTime").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#endTime").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$createTime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#startTime").val('');
	$("#endTime").val('');
});
$createTime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#startTime").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#endTime").val(end.format('YYYY-MM-DD HH:mm:ss'));
});

var $table = $("#contractTemplate_table");
$(function(){
	 clearTime();
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#disable_temp_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请先选择合同模板");
		} else {
			$.confirm({
				title: '',
			    content: '是否确定停用合同模板?',
			    confirm: function(){
			    	worf.ajax({
						url : web_root+"/contract/template/disableTemplate",
				 		type : 'post',
				 		data : {
				 			tmpId : 	selected[0].id
						},
				 		success : function(data) {
				 			if(data.status==1){
				 				$.showPop(data.message,"",2000);
				 	 			$table.bootstrapTable('refresh');
				 			}else{
				 				$.showPop(data.message,"",2000);
				 			}
				 		},
				 		error : function(){
				 		}
					});
			    }
			});
		}
	});
	
	$('#btn_reset').bind('click',function(){
		$('#reservationtime').val("");
		$("#startTime").val("");
		$("#endTime").val("");
	});
})
