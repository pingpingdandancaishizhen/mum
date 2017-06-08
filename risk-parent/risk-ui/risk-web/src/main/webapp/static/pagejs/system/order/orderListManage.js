
var $table = $("#p2pOrder_table");
$(function(){	
	
	$('.table').on('change','tbody .bs-checkbox input',function(){
		if($table.find("tbody input:checked").length!=1){
			$("#edit_btn").addClass("disabled");
			$("#view_btn").addClass("disabled");
		}else{
			$("#edit_btn").removeClass("disabled");
			$("#view_btn").removeClass("disabled");
		}
		
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
		$("#createTimeFrom").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#createTimeTo").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});
	$reservationtime.on('cancel.daterangepicker',function () {
		$(this).val('');
		$("#createTimeFrom").val('');
		$("#createTimeTo").val('');
	});
	$reservationtime.on('apply.daterangepicker',function (el,daterangepicker) {
		var start=daterangepicker.startDate;
		var end=daterangepicker.endDate;
		$("#createTimeFrom").val(start.format('YYYY-MM-DD HH:mm:ss'));
		$("#createTimeTo").val(end.format('YYYY-MM-DD HH:mm:ss'));
	});

	$('#reservationtime').val("");
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	$("#btn_reset").bind("click",function() {
		$("#createTimeFrom").val('');
		$("#createTimeTo").val('');
	});
	$("#edit_btn").bind("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if($table.find("input:checked").length == 1){
			worf.ajax({
				url : web_root+'/order/editOrder',
				type : 'post',
				data : {
					'id':selected[0].id,
					'productCode':selected[0].productCode
				},
				success : function(data) { 
					if(data.status==1){
						var url=web_root+"/pages/from-p2p.html?"+$.param(data.data);
						var name=$table.find("input:checked").parent().next().next().html()+"-编辑信息";
						tools.addParentTab(url,name);
						
						// 	window.location.href=web_root+"/pages/form.html?"+$.param(data.data)
					}
				}
			});
			//var url=web_root+"/pages/form.html?"+$.param(data.data);
			//tools.addParentTab("/order/editOrder?model=edit&id="+$table.find("input:checked").parent().next().find("i").html(),$table.find("input:checked").parent().next().next().html()+"-编辑信息");
		}
		
	});
	
	/*$("#edit_btn").bind("mouseenter",function() {
		if($table.find("input:checked").length == 1){
			$("#edit_btn").removeClass("disabled");
			
		}else{
			$("#edit_btn").addClass("disabled");
			$.alert("请选择一条订单！");
		}
		
	});*/
	
	$("#view_btn").bind("click",function() {
		var selected = $table.bootstrapTable('getSelections');
		if($table.find("input:checked").length == 1){
			worf.ajax({
				url : web_root+'/order/editOrder',
				type : 'post',
				data : {
					'id':selected[0].id,
					'productCode':selected[0].productCode,
					'model':"view",
				},
				success : function(data) {
					if(data.status==1){
						var url=web_root+"/pages/from-p2p.html?"+$.param(data.data);
						var name=selected[0].customerName+"-查看信息";
						tools.addParentTab(url,name);
						
						// 	window.location.href=web_root+"/pages/form.html?"+$.param(data.data)
					}
				}
			});
		}
		
		/*if($table.find("input:checked").length == 1){
			tools.addParentTab("/order/editOrder?model=view&id="+$table.find("input:checked").parent().next().find("i").html(),$table.find("input:checked").parent().next().next().html()+"-查看信息");
		}*/
	});
	
	/*$("#view_btn").bind("mouseenter",function() {
		if($table.find("input:checked").length == 1){
			$("#view_btn").removeClass("disabled");
		}else{
			$("#view_btn").addClass("disabled");
			$.alert("请选择一条订单!");
		}
	});*/
	
	$("#submit_all_btn").bind("click",function() {
		 var ids = new Array();
		 var isValid = false;//校验订单状态是否有非“新增订单”的
		 var invalidIds = "";
		 $table.find("input:checked").each(function(){
			 if($(this).attr("name") == "btSelectAll")
				 return true;
			
			 if($(this).parent().parent().attr("name")!="subCustomer"){
				 //第一级订单
				 id = $(this).parent().next().find("i").html().trim();
			 }else{
				 id = $(this).parent().parent().attr("data-pid").trim();
			 }
			 if($(this).parent().parent().children('td').eq(13).html().trim()!='新增订单'){
				 isValid = true;
				
			 }
			 var flag = false;
			 for(var i=0;i<ids.length;i++){
				 if(ids[i]==id){
					 flag = true;
					 break;
				 } 
			 }
			 if(!flag){
				 invalidIds += id+","; 
				ids.push(parseInt(id)); 
			 }
			 console.log("id="+id);	
		  });
		 if(isValid){
			 var mes = invalidIds.substring(0,invalidIds.length-1);
			 $.alert("订单号为"+mes+"的订单都已提交过,不允许批量提交" );
			 return;
		 }
		 if(ids.length == 0)
			 return $.alert("请选择订单！");
		 console.log("ids="+ids);
		 
		 worf.ajax({
				url : web_root+'/order/batchSubmit',
				type : 'post',
				data : {
					"ids":ids
				},
				dataType : "json",
				success : function(data) {
					if(data.status==1){
						var str = "批量提交成功！ \n成功提交"+data.data.subCount+"条 \n失败"+data.data.err.length+"条 \n";
						for(var i = 0;i<data.data.err.length;i++){
							str += "订单号："+data.data.err[i].info.id+",失败原因："+data.data.err[i].err+" \n";
						}
						alert(str);
						window.location.reload();
					}else{
						$.showPop(data.message,"",1000);
					}
				}
			});
		
	});
});	



function showMoreOrder(obj,idCard,excludeId){
	if($(obj).hasClass("fa-plus-square-o")){
		var _tdP=$(obj).parent().parent();
		
		$.post({
			url : web_root+'/order/loadAllLoanByCustomer',
			type : 'post',
			dataType:'json',
			async:true,
			cache :false,
			data : {
				'idCard':idCard,
				'excludeId':excludeId
			},
			success : function(data) {
				if(data.status==1){
					var _obj=data.data.data
					var _subOrder="";
					$.each(_obj, function (n, map) { 
			             /* _subOrder +="<tr data-index='"+map.id+"' name='subCustomer' class='' onclick='checkSelectBox(this)' cusid='"+map.idCard+"'><td class='bs-checkbox '><input data-index='"+map.id+"' name='id' onclick='checkSelectBox1(this)' type='checkbox'></td>"
			              			+"<td style=''>&nbsp;&nbsp;&nbsp;<i class='fa fa-fw'>"+map.id+"</i></td>"
			              			+"<td style=''>"+map.customerName+"</td>"
			              			+"<td style=''>"+map.gender+"</td><td style=''>"+map.idCard+"</td>"
			              			+"<td style=''>"+map.mobilePhone+"</td><td style=''>"+map.customerType+"</td><td style=''>"+map.productName+"</td><td style=''>"+map.createTime+"</td>"
			              			+"<td style=''>"+map.loanMoney+"</td><td style=''>"+map.loanPeriod+"</td><td style=''>"+map.repayType+"</td>"
			              			+"<td style=''>"+map.loanHandleType+"</td>"
			              			+"<td style=''>"+map.aproveStatus+"</td><td style=''>"+map.corporation+"</td>"
			              			+"<td style=''>"+map.importWay+"</td>"
			              			+"<td style=''>"+map.createUser+"</td></tr>";*/
						
						 _subOrder +="<tr data-pid='"+excludeId+"' data-index='"+map.id+"' name='subCustomer' onclick='checkSelectBox(this)' class=''  cusid='"+map.idCard+"'><td class='bs-checkbox '><input data-index='"+map.id+"' name='id' onclick='checkSelectBox1(this)' type='checkbox'></td>"
	              			+"<td style=''>&nbsp;&nbsp;&nbsp;<i class='fa fa-fw'>"+map.id+"</i></td>"
	              			+"<td style=''>"+map.customerName+"</td>"
	              			+"<td style=''>"+map.gender+"</td><td style=''>"+map.idCard+"</td>"
	              			+"<td style=''>"+map.mobilePhone+"</td><td style=''>"+map.customerType+"</td><td style=''>"+map.productName+"</td><td style=''>"+map.createTime+"</td>"
	              			+"<td style=''>"+map.loanMoney+"</td><td style=''>"+map.loanPeriod+"</td><td style=''>"+map.repayType+"</td>"
	              			+"<td style=''>"+map.loanHandleType+"</td>"
	              			+"<td style=''>"+map.aproveStatus+"</td><td style=''>"+map.corporation+"</td>"
	              			+"<td style=''>"+map.importWay+"</td>"
	              			+"<td style=''>"+map.createUser+"</td></tr>";
			              
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
			if($(this).attr("cusid")==idCard){
				$(this).remove();
			}
		});
	}
}

function checkSelectBox(obj){
	
	if($(obj).find("td input").prop("checked")){
		$(obj).removeClass("selected");
		$(obj).find("td input").prop("checked",false);
	}else{
		$(obj).addClass("selected");
		$(obj).find("td input").prop("checked",true);
	}
//	$(obj).siblings("tr").removeClass("selected");
//	$(obj).siblings("tr").find("td input").prop("checked",false);
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

$table.on('click-row.bs.table', function (e, row, element) 
{
//	$(element).siblings("tr").removeClass("selected");
//	$(element).siblings("tr").find("td input").prop("checked",false);
});

$table.on('check.bs.table', function (e, row, element) 
{
//	$(element).parent().parent().siblings("tr").removeClass("selected");
//	$(element).parent().parent().siblings("tr").find("td input").prop("checked",false);
});

$table.on('check-all.bs.table', function (rows) {
	$("td input").prop("checked",true);
});
$table.on('uncheck-all.bs.table', function (rows) {
	$("td input").prop("checked",false);
});

