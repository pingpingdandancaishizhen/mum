var $table = $("#all_installment_table");
function clearTime(){
	$('#reservationtime').val("");
	$("#startDate").val("");
	$("#endDate").val("");
}

$(function(){
	
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	
	$("#btn_reset").bind("click",function() {
		 $("#searchbar").find('form')[0].reset();
		 $("#searchbar").find("form input[type='hidden']").val('');
	});
	
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
		$("#searchbar #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$reservationtime.on('cancel.daterangepicker',function () {
		$(this).val('');
		$("#searchbar #startDate").val('');
		$("#searchbar #endDate").val('');
	});
	$reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
		var start=daterangepicker.startDate;
		var end=daterangepicker.endDate;
		$("#searchbar #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	//双选时间插件使用方法
	var $reservationtime1=$('#reservationtime1');
	$reservationtime1.daterangepicker({
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
		$("#searchbar1 #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar1 #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$reservationtime1.on('cancel.daterangepicker',function () {
		$(this).val('');
		$("#searchbar1 #startDate").val('');
		$("#searchbar1 #endDate").val('');
	});
	$reservationtime1.on('apply.daterangepicker',function (el,daterangepicker) {
		var start=daterangepicker.startDate;
		var end=daterangepicker.endDate;
		$("#searchbar1 #startDate").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#searchbar1 #endDate").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$('#reservationtime').val("");
	$('#reservationtime1').val("");
});
function requestData1(params) {
	var params = {
		paseSize : params.pageSize,
		currentPage : params.pageNumber
	};
	$('#searchbar1').find('input[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	$('#searchbar1').find('select[name]').each(function() {
		params[$(this).attr('name')] = $(this).val();
	});
	return params;
}
//展开历史订单
function showMoreOrder(obj,insuranceId,ownerId){
	if($(obj).hasClass("fa-plus-square-o")){
		var _tdP=$(obj).parent().parent();
		
		$.post({
			url : web_root+'/installment/queryAllInstallmentDetail',
			type : 'post',
			dataType:'json',
			async:true,
			cache :false,
			data : {
				'insuranceId':insuranceId,
				'ownerId':ownerId
			},
			success : function(data) {
				if(data.length>0){
					var _obj=data;
					var _subOrder="";
					$.each(_obj, function (n, map) {
						 _subOrder +="<tr data-pid='"+insuranceId+"' data-index='1"+map.insuranceId+"' name='subInsurance' onclick='checkSelectBox(this)' class='subInsurance'  insuranceId='"+ownerId+"'><td class='bs-checkbox '>"
						 	+"<input data-index='1"+map.insuranceId+"' name='id' onclick='checkSelectBox1(this)' type='checkbox'></td>"
	              			+"<td style=''>"+map.insuranceId+"</td>"
	              			+"<td style=''>"+map.ownerName+"</td>"
	              			+"<td style=''>"+map.ownerIdNoStr+"</td><td style=''>"+map.productName+"</td>"
	              			+"<td style=''>"+map.createTime+"</td><td style=''>"+map.totalPrice+"</td><td style=''>"+map.insurerName+"</td><td style=''>"+map.ciProposalNo+"</td>"
	              			+"<td style=''>"+map.biProposalNo+"</td><td style=''>"+map.bBalance+"</td><td style=''>"+map.amount+"</td>"
	              			+"<td style=''>"+map.loanPeriodsNum+"</td>"
	              			+"<td style=''>"+map.payMethod+"</td><td style=''>"+map.licenseNo+"</td>"
	              			+"<td style=''>"+map.loanProperty+"</td>"
	              			+"<td style=''>"+map.status+"</td>"
	              			+"<td style=''>"+map.orderSource+"</td>"
	              			+"<td style=''>"+map.issuePlat+"</td>"
	              			+"<td style=''>"+map.issueNo+"</td>"
	              			+"<td style=''>"+map.issueStatus+"</td></tr>";
					});
					
					_tdP.after(_subOrder);
				}else{       
					$.showPop(data.message,"",1000);
				}
			
			},
			error : function(){
				$.showPop('网络错误','',1000);
			},
		});
		
		$(obj).removeClass("fa-plus-square-o").addClass("fa-minus-square-o");
	}else{
		$(obj).removeClass("fa-minus-square-o").addClass("fa-plus-square-o");
		$(obj).parent().parent().siblings("tr").each(function(){
			if($(this).attr("insuranceId")==ownerId){
				$(this).remove();
			}
		});
	}
}

var clearCheck = function clearCheck(){
	$("#all_installment_table").find("tr.subInsurance").removeClass("selected");
	$("#all_installment_table").find("tr.subInsurance").find("td input").prop("checked",false);
}

function checkSelectBox1(obj){
	var _obj=$(obj).parent();
	
	if($(obj).prop("checked")){
		$(_obj).removeClass("selected");
		$(obj).prop("checked",false);
	}else{
		$(_obj).addClass("selected");
		$(obj).prop("checked",true);
	}
	/*$(_obj).siblings("tr").removeClass("selected");
	$(_obj).siblings("tr").find("td input").prop("checked",false);*/
}

function checkSelectBox(obj){
	
	if($(obj).find("td input").prop("checked")){
		$(obj).removeClass("selected");
		$(obj).find("td input").prop("checked",false);
	}else{
		$(obj).addClass("selected");
		$(obj).find("td input").prop("checked",true);
	}
	/*$(obj).siblings("tr").removeClass("selected");
	$(obj).siblings("tr").find("td input").prop("checked",false);*/
}