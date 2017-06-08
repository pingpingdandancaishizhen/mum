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
	$("#btn_reset_todo").on("click",function(){
		$("#searchbar").find('form')[0].reset();
		$("#searchbar").find("form input[type='hidden']").val('');
	});
	$("#todo_handle_btn").on("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length == 0 ){
			$.alert("请选择要处理的待办");
		
		}	else if(selected.length > 1){
			$.alert("只能选择一条待办处理");
		}else{
			//弹出产品选择
			$('#selectProductModal #customerId').val(selected[0]['id']);
			$('#selectProductModal').showModal();
			var name=['待办',selected[0].taskName,selected[0].productName].join('-')
			var param = {
					"productId":selected[0]['productId'],
					"bpDefId":selected[0]['bpDefId'],
					"bpDefKey":selected[0]['bpDefKey'],
					"taskId":selected[0]['taskId'],
					"bpId":selected[0]['bpId'],
					"deptId":selected[0]['deptId'],
					"loanInfoId":selected[0]['loanInfoId'],
					"productType":selected[0]['productType'],
					"model":"handle",
					'title':name
			};
			var url=web_root+"/pages/from-p2p.html?"+$.param(param);
			tools.addParentTab(url,name,true)
		}
	});
	$("#todo_cancle_btn").off().on("click",function() {
		 var $this=$(this);
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length ===0 ){
			$.alert("请选择要作废的待办");
		}else{
			var can = true;
			var ids = [];
			$.each(selected,function(i,v){
				if(v.aproveStatus !='1' && v.aproveStatus !='11'){
					can = false;
				}else{
					ids.push(v.loanInfoId);
				}
			});
			if (!can) {
				$.alert("请选择新增或者退回的订单");
				return;
			}
			
			 $this.button('loading')
				$.confirm({
		      	    title:'',
			      content: '是否确定要将所选订单作废吗？',
			      confirm: function(){
			    	  worf.ajax({
							url : web_root+'/order/cancle',
							type : 'post',
							data : {
								"ids":ids
							},
							dataType : "json",
							success : function(data) {
								if(data.status==1){
									$.showPop("作废成功","",1000);
									$("#todo_table").bootstrapTable('refresh');
								}else{
									$.showPop(data.message,"",1000);
								}
							},
						      complete:function () {
							      $this.button('reset');
						      }
						});
			      },
			      cancel:function () {
				      $this.button('reset')
			      }
		      });
		}
	});
	
	
	$table.on("check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table check-some.bs.table uncheck-some.bs.table",function(){
		var selected = $table.bootstrapTable('getSelections');
		//校验是否可以批量提交
		var canhandle=true;
		var cancancle=true;
		if(selected.length !=1 ){
			canhandle = false;
		} 
		if(selected.length ===0 ){
			cancancle=false;
		}else{
			$.each(selected,function(i,v){
				if(v.aproveStatus !='1' && v.aproveStatus !='11'){
					cancancle = false;
				} 
			});
		}
		if(!canhandle){
			$("#todo_handle_btn").addClass("disabled");
			$("#todo_handle_btn").prop("disabled",true);
		}else{
			$("#todo_handle_btn").removeClass("disabled");
			$("#todo_handle_btn").prop("disabled",false);
		}
		if(!cancancle){
			$("#todo_cancle_btn").addClass("disabled");
			$("#todo_cancle_btn").prop("disabled",true);
		}else{
			$("#todo_cancle_btn").removeClass("disabled");
			$("#todo_cancle_btn").prop("disabled",false);
		}
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