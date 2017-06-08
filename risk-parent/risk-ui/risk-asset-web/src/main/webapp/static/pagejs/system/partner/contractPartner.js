function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}

function typeFormatter(value){
	if(value && value == 1){
		return "法人";
	}else if(value && value == 2){
		return "公司";
	}else {
		return "-";
	}
}

function indexFormatter(value, row, index){
	return index+1;
}

function sealResourseFormatter(value, row, index){
	if(row.sealResource){
		return '<a class="sign_view" href="javascript:void(0)" data-resource="'+row.sealResource+'">查看</a>';
	} else {
		return '-';
	}
}

function signResourseFormatter(value, row, index){
	if(row.signResource){
		return '<a class="sign_view" href="javascript:void(0)" data-resource="'+row.signResource+'">查看</a>';
	} else {
		return '-';
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

$table = $("#contractPartner_table");
$(function(){
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#delete_partner_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请先选择参与方");
		} else {
			$.confirm({
				title: '',
			    content: '是否确定删除参与方?',
			    confirm: function(){
			    	worf.ajax({
						url : web_root+"/system/partner/deletePartner",
				 		type : 'post',
				 		data : {
				 			partnerId : selected[0].id
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
});

$(document).on('click','.sign_view',function(){
	$("#viewSignModal").showModal();
	$("#view_img").prop('src',web_root+'/getResourceById?resourceId='+$(this).data("resource"));
});