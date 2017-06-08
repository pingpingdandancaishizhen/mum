function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}
var $table = $("#todo_table");
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
	$('#reservationtime').val("");
	$("#btn_search").on("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#todo_handle_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择要处理的待办");
		}else{
			//弹出产品选择
			$('#selectProductModal #customerId').val(selected[0]['id']);
			$('#selectProductModal').showModal();
			var param = {
					"productId":selected[0]['productId'],
					"bpDefId":selected[0]['bpDefId'],
					"bpDefKey":selected[0]['bpDefKey'],
					"customerId":selected[0]['customerId'],
					"taskId":selected[0]['taskId'],
					"bpId":selected[0]['bpId'],
					"deptId":selected[0]['deptId']
			};
			var url=web_root+"/pages/form.html?"+$.param(param);
			var name='待办-'+selected[0].custName+selected[0].taskName;
			tools.addParentTab(url,name)
		}
	});
	
	//绑定产品变更事件，刷新流程节点选项
	$("#productType").change(function(){
		flushMetaNodes($("#productType").val());
	});
	//初始化时单独执行获取流程节点方法
	flushMetaNodes($("#productType").val());
});

function flushMetaNodes(product){
	worf.ajax({
		url : web_root+'/index/getBpMetaNodesByProduct',
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
   			$("#currentTaskKey").html(options.join(""));
   		}
	});
}