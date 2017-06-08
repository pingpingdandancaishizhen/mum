var $table = $("#generalinfo_table");

//申请时间
var $applytime=$('#applytime');
$applytime.daterangepicker({
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
	$("#applyStartDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#applyEndDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$applytime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#applyStartDate").val('');
	$("#applyEndDate").val('');
});
$applytime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#applyStartDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#applyEndDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});

//放款时间
var $lendtime=$('#lendtime');
$lendtime.daterangepicker({
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
	$("#lendStartDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#lendEndDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$lendtime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#lendStartDate").val('');
	$("#lendEndDate").val('');
});
$lendtime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#lendStartDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#lendEndDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});

//满标时间
var $tendertime=$('#tendertime');
$tendertime.daterangepicker({
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
	$("#tenderStartDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#tenderEndDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});
$tendertime.on('cancel.daterangepicker',function () {
	$(this).val('');
	$("#tenderStartDate").val('');
	$("#tenderEndDate").val('');
});
$tendertime.on('apply.daterangepicker',function (el,daterangepicker) {
	var start=daterangepicker.startDate;
	var end=daterangepicker.endDate;
	$("#tenderStartDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
	$("#tenderEndDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
});

function clearTime(){
	$('#applytime').val("");
	$("#applyStartDate").val("");
	$("#applyEndDate").val("");
	$('#lendtime').val("");
	$("#lendStartDate").val("");
	$("#lendEndDate").val("");
	$('#tendertime').val("");
	$("#tenderStartDate").val("");
	$("#tenderEndDate").val("");
}

$(function(){
	clearTime();
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#btn_reset").bind("click",function() {
		$("#searchForm").resetForm();
	});
	
	$("#btn_export").on("click",function() {
		window.location.href = web_root+'/generalinfo/exportAllList?'+$("#searchForm").serialize();
	});
	
	$("[name='showcolumn']").each(function(){
		if(!$(this).prop("checked")){
			$table.bootstrapTable('hideColumn',$(this).val());
		}
	});
	
	$("#colConfigBtn").on("click",function(){
		var $input_checked=$("input[name='showcolumn']:checked");
		$input_checked.each(function(){
			$table.bootstrapTable('showColumn',$(this).val());
		});
		$("input[name='showcolumn']:not(:checked)").each(function(){
			$table.bootstrapTable('hideColumn',$(this).val());
		});
		var length=$input_checked.length;
		$('#generalinfo_table').css({width:length*150})
//		$("[name='showcolumnall']").click(function(){
//			if($(this).prop("checked")){
//				$("[name='showcolumn']").prop("checked",true);
//				$("[name='showcolumn']").each(function(){
//					$table.bootstrapTable('showColumn',$(this).val());
//				});
//			}else{
//				$("[name='showcolumn']").prop("checked",false);
//				$("[name='showcolumn']").each(function(){
//					$table.bootstrapTable('hideColumn',$(this).val());
//				});
//			}
//		});
//		$("[name='showcolumn']").click(function(){
//			if($(this).prop("checked")){
//				$table.bootstrapTable('showColumn',$(this).val());
//			}else{
//				$table.bootstrapTable('hideColumn',$(this).val());
//			}
//			var b = $("input[name='showcolumn']").length;
//			var a = $("input[name='showcolumn']:checked").length;
//			if(a==b){
//				$("[name='showcolumnall']").prop("checked",true);
//			 }else{
//				 $("[name='showcolumnall']").prop("checked",false);
//			 }
//		});
		
//		$("[name='showsearchall']").click(function(){
//			if($(this).prop("checked")){
//				$("[name='showsearch']").prop("checked",true);
//				$("[name='showsearch']").each(function(){
//					$("#"+$(this).val()).show();
//				});
//			}else{
//				$("[name='showsearch']").prop("checked",false);
//				$("[name='showsearch']").each(function(){
//					$("#"+$(this).val()).hide();
//					resetContainers($(this).val());
//				});
//			}
//		});
		/*$("input[name='showsearch']").each(function(){
			if($(this).prop("checked")){
				$("#"+$(this).val()).show();
			}else{
				$("#"+$(this).val()).hide();
				resetContainers($(this).val());
			}
//			var b = $("input[name='showsearch']").length;
//			var a = $("input[name='showsearch']:checked").length;
//			if(a==b){
//				$("[name='showsearchall']").prop("checked",true);
//			 }else{
//				 $("[name='showsearchall']").prop("checked",false);
//			 }
		});*/
		var $ConfigModal = $("#ConfigModal");
		$ConfigModal.modal("hide");
	});
	
	$("#btn_viewconfig").on("click",function(){
		var $ConfigModal = $("#ConfigModal");
		$ConfigModal.modal("show");
		
		$("[name='showcolumnall']").click(function(){
			if($(this).prop("checked")){
				$("[name='showcolumn']").prop("checked",true);
//				$("[name='showcolumn']").each(function(){
//					$table.bootstrapTable('showColumn',$(this).val());
//				});
			}else{
				$("[name='showcolumn']").prop("checked",false);
//				$("[name='showcolumn']").each(function(){
//					$table.bootstrapTable('hideColumn',$(this).val());
//				});
			}
		});
		$("[name='showcolumn']").click(function(){
//			if($(this).prop("checked")){
//				$table.bootstrapTable('showColumn',$(this).val());
//			}else{
//				$table.bootstrapTable('hideColumn',$(this).val());
//			}
			var b = $("input[name='showcolumn']").length;
			var a = $("input[name='showcolumn']:checked").length;
			if(a==b){
				$("[name='showcolumnall']").prop("checked",true);
			 }else{
				 $("[name='showcolumnall']").prop("checked",false);
			 }
		});
		
		$("[name='showsearchall']").click(function(){
			if($(this).prop("checked")){
				$("[name='showsearch']").prop("checked",true);
//				$("[name='showsearch']").each(function(){
//					$("#"+$(this).val()).show();
//				});
			}else{
				$("[name='showsearch']").prop("checked",false);
//				$("[name='showsearch']").each(function(){
//					$("#"+$(this).val()).hide();
//					resetContainers($(this).val());
//				});
			}
		});
		$("[name='showsearch']").click(function(){
//			if($(this).prop("checked")){
//				$("#"+$(this).val()).show();
//			}else{
//				$("#"+$(this).val()).hide();
//				resetContainers($(this).val());
//			}
			var b = $("input[name='showsearch']").length;
			var a = $("input[name='showsearch']:checked").length;
			if(a==b){
				$("[name='showsearchall']").prop("checked",true);
			 }else{
				 $("[name='showsearchall']").prop("checked",false);
			 }
		});
	});
	
	$("#btn_view").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择要查看的单据");
		}else{
			worf.ajax({
				url : web_root+'/loan/getStartParamView',
				type : 'post',
				data : {
					'bpId':selected[0]['bpId']
				},
				success : function(data) {
					if(data.status==1){
						var name='查看-'+selected[0]['custName']+'的借款';
						var url=web_root+"/pages/form.html?"+$.param(data.data)+'&title='+encodeURI(name);
						tools.addParentTab(url,name);
					}
				}
			});
		}
	});
	
	//绑定产品变更事件，刷新流程节点选项
	$("#productType").change(function(){
		flushMetaNodes($("#productType").val());
	});
	
	//初始化时单独执行获取流程节点方法
	flushMetaNodes($("#productType").val());
	//展开搜索box
	$('.searchBox-tools').on('click',function () {
		var _span=$(this).find('span');
		if(_span.hasClass('fa-angle-double-down')){
			_span.addClass('fa-angle-double-up').removeClass('fa-angle-double-down');
			$('#searchForm').stop().animate({height:"294px"});
		}else{
			_span.addClass('fa-angle-double-down').removeClass('fa-angle-double-up');
			$('#searchForm').stop().animate({height:"135px"});
		}

	})
});

function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY-MM-DD')
	}
}

function dateFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY-MM-DD')
	}
}

function indexFormatter(value, row, index){
	return index+1;
}

function showMoreOrder(obj,custId){
	var queryData = $("#searchForm").serialize();
	var _tdP=$(obj).parent().parent();
	var startIndex = _tdP.get(0).rowIndex;
	if($(obj).hasClass("fa-plus-square-o")){
		worf.ajax({
			url : web_root+'/generalinfo/queryExtList',
	   		type : 'post',
	   		data : queryData+'&custId='+custId,
	   		success : function(data) {
	   			if(data.status==1){
					var _obj=data.data
					if(_obj.length>0){
						$.each(_obj, function (n, bean) { 
							$table.bootstrapTable('insertRow',{
								index : startIndex+n,
								row : {
									bpId : bean.bpId,
									plusIcon : '&nbsp;&nbsp;&nbsp;&nbsp;'+bean.bpNo,
									orderSource : bean.orderSource,
									loanPlatform : bean.loanPlatform,
									product : bean.product,
									custName: bean.custName,
									contractNo: bean.contractNo,
									custLicenseNo: bean.custLicenseNo,
									custType: bean.custType,
									applyDate: bean.applyDate,
									applyAmount: bean.applyAmount,
									applyPeriodStr: bean.applyPeriodStr,
									applyRepaymentMethodStr: bean.applyRepaymentMethodStr,
									loanApprovalAmount: bean.loanApprovalAmount,
									approvalPeriodStr: bean.approvalPeriodStr,
									loanApprovalBzjAmount: bean.loanApprovalBzjAmount,
									contractAmount: bean.contractAmount,
									approvalRepaymentTypeStr: bean.approvalRepaymentTypeStr,
									carNo: bean.carNo,
									owenStore: bean.owenStore,
									orderStatus: bean.orderStatus,
									lendDate: bean.lendDate,
									repayStatus: bean.repayStatus,
									repayedTerm: bean.repayedTerm,
									custid : custId,
									bpNo : bean.bpNo
								}
							}); 
						});
					}else{
						$.showPop("无历史订单","",1000);
					}
				}else{
					$.showPop(data.message,"",1000);
				}
	   		}
		});
		$(obj).removeClass("fa-plus-square-o").addClass("fa-minus-square-o");
		var iconClass = $table.bootstrapTable('getOptions').data[startIndex-1].plusIcon;
		$table.bootstrapTable('getOptions').data[startIndex-1].plusIcon = iconClass.replace('plus','minus');
	}else{
		$(obj).removeClass("fa-minus-square-o").addClass("fa-plus-square-o");
		var iconClass = $table.bootstrapTable('getOptions').data[startIndex-1].plusIcon;
		$table.bootstrapTable('getOptions').data[startIndex-1].plusIcon = iconClass.replace('minus','plus');
		var bps=[];
		$.each($table.bootstrapTable('getOptions').data,function (n, bean) { 
			if(bean.custid == custId){
				bps.push(bean.bpNo);
			}
		});
		$.each(bps,function (n, bp) {
			$table.bootstrapTable('removeByUniqueId',bp);
		});
	}
}

function flushMetaNodes(product){
	worf.ajax({
		url : web_root+'/generalinfo/getBpMetaNodesByProduct',
   		type : 'get',
   		data : {
   			product:product
   		},
   		success : function(data) {
   			var options = [];
   			options.push('<option value="">请选择</option>');
   			if(data.data.nodeList && data.data.nodeList.length > 0){
   				$.each(data.data.nodeList,function(i,node){
   					options.push('<option value="'+node.nodeKey+'">'+node.nodeName+'</option>');
   				});
   			}
   			$("#currTaskKey").html(options.join(""));
   			
   			options = [];	
   			options.push('<option value="">请选择</option>');
   			if(data.data.partnerList && data.data.partnerList.length > 0){
   				$.each(data.data.partnerList,function(i,partner){
   					options.push('<option value="'+partner.id+'">'+partner.name+'</option>');
   				});
   			}
   			$("#loanPlatform").html(options.join(""));
   			
   			options = [];
   			options.push('<option value="">请选择</option>');
   			if(data.data.paridList && data.data.paridList.length > 0){
   				$.each(data.data.paridList,function(i,parid){
   					options.push('<option value="'+parid.term+'">'+parid.termText+'</option>');
   				});
   			}
   			$("#approveLine").html(options.join(""));
   		}
	});
}

function resetContainers(divId){
	// 清空文本框
	  $("#"+divId).find('input').each(function(){
	  	$(this).val("");
	  });
	  // 复位下拉菜单
	  $("#"+divId).find('select').each(function(){
	  	$(this).find('option:first-child').prop('selected','selected');
	  });
}