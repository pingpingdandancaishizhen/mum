function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY-MM-DD')
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
	
	$("#todo_handle_btn").click(function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择要处理的待办");
		}else{
			//弹出产品选择
			$('#selectProductModal #customerId').val(selected[0]['id']);
			//$('#selectProductModal').showModal();
			var name=['待办',selected[0].taskName,selected[0].productName].join('-');
			var param = {
					"productId":selected[0]['productId'],
					"bpDefId":selected[0]['bpDefId'],
					"bpDefKey":selected[0]['bpDefKey'],
					"customerId":selected[0]['customerId'],
					"taskId":selected[0]['taskId'],
					"bpId":selected[0]['bpId'],
					"deptId":selected[0]['deptId'],
					"title":name
			};
			var url=web_root+"/pages/form.html?"+$.param(param);

			tools.addParentTab(url,name)
		}
	});
	
	//绑定产品变更事件，刷新流程节点选项
	$("#productType").change(function(){
		flushMetaNodes($("#productType").val());
	});
	//初始化时单独执行获取流程节点方法
	flushMetaNodes($("#productType").val());

	$("#apply_loan_btn").click(function(){	
		$('#selectProductModal #customerId').val("-1");
		$('#selectProductModal').showModal();	
	});
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

var $customer_table = $("#customer_table");
	
$("#btn_search_customer").click(function() {
	$customer_table.bootstrapTable('refresh');
});

function requestCustomerData(params){
	var params = {
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#customerSearchbar').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#customerSearchbar').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}

$("#selectProductModal #selectProductBtn").off().on('click',function () {
	var selected = $customer_table.bootstrapTable('getSelections');
	if(selected.length > 0 ){
		$('#selectProductModal #customerId').val(selected[0].id);
	}else{
		$('#selectProductModal #customerId').val("-1");
	}
	var customerId = $('#selectProductModal #customerId').val();
	var productId = $('#selectProductModal #productId').val();
	worf.ajax({
		url : web_root+'/loan/getStartParam',
		type : 'post',
		data : {
			'productId':productId,
			'customerId':customerId
		},
		success : function(data) {
			if(data.status==1){
				var name='待办-新增申请-'+$('#selectProductModal').find('option[value="'+productId+'"]').text();
				var url=web_root+"/pages/form.html?"+$.param(data.data)+"&title="+encodeURI(name);
				$('#selectProductModal').hideModal();
				tools.addParentTab(url,name);				
			}
		}
	});
})
$(".userCorpIdSelect").change(function(){
	var uid = $(this).children('option:selected').val();
	$("#uid").val(uid);
	$customer_table.bootstrapTable('refresh');
});
$("#deptId").change(function(){
	var deptId = $(this).children('option:selected').val();
	$(".userCorpIdSelect").hide();
	$(".userCorpIdSelect").attr("name","");
	$("#"+deptId).attr("name","userCorpId");
	$("#"+deptId).show();
	var uid = $("#"+deptId).children('option:selected').val();
	$("#uid").val(uid);
	$customer_table.bootstrapTable('refresh');
});

