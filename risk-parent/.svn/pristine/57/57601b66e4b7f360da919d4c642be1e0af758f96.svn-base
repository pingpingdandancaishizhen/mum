var $table = $("#p2pOrder_table");

function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'yyyy-MM-dd hh:mm:ss')
	}
}

function showAllOrder(value ,row ,index){
	if(value=='need')
	return "<i class='showmoreorder fa fa-fw fa-plus-square-o' style='cursor:pointer' >"+row.id+"</i>";
	else if(value=='needd')
		return "<i class='showmoreorder fa fa-fw fa-minus-square-o' style='cursor:pointer' >"+row.id+"</i>";
	else
    return "&nbsp;&nbsp;&nbsp;"+row.id;
}
window.operateEvents = { 
		'click .showmoreorder' : function(e, value, row ,index) {
			var t  = $(this);
			 if(t.hasClass("fa-plus-square-o")){
				 t.removeClass("fa-plus-square-o").addClass("fa-minus-square-o");
				 //获取数据
				 getMoreData(row,t,false,index);
			 }else{
				 t.removeClass("fa-minus-square-o").addClass("fa-plus-square-o");
				 //删除上次加载的数据
				 getMoreData(row,t,true,index);
			 }
		}
};
function getMoreData(row,obj,remove,index){
	if(remove){
		$("#p2pOrder_table").bootstrapTable('uncheckAll');
		$("#p2pOrder_table").bootstrapTable('checkBy',{field: 'idCard',values:[row.idCard]});
		$("#p2pOrder_table").bootstrapTable('uncheck',index);
		$.each($("#p2pOrder_table").bootstrapTable('getSelections'),function(i,v){
			$("#p2pOrder_table").bootstrapTable('removeByUniqueId', v.id );
		});
		$("#p2pOrder_table").bootstrapTable('updateCell', {index: index, field: 'plusIdIcon',value:'need'});
		return;
	}
	 worf.ajax({
			url : web_root+'/order/loadAllLoanByCustomer',
			type : 'post',
			data : {
				'eIdCard':row.idCard,
				'excludeId':row.id,
				'productType':$("#searchForm").find("select[name='productType']").val(),
				'id':$("#searchForm").find("input[name='id']").val(),
				'customerName':$("#searchForm").find("input[name='customerName']").val(),
				'idCard':$("#searchForm").find("input[name='idCard']").val(),
				'aproveStatus':$("#searchForm").find("select[name='aproveStatus']").val(),
				'createTimeFrom':$("#searchForm").find("#createTimeFrom").val(),
				'createTimeTo':$("#searchForm").find("#createTimeTo").val(),
				'loanHandleType':$("#searchForm").find("select[name='loanHandleType']").val(),
				'loanSource':$("#searchForm").find("input[name='loanSource']").val(),
				'customerType':$("#searchForm").find("select[name='customerType']").val(),
				'loancarLicensePlate':$("#searchForm").find("input[name='loancarLicensePlate']").val(),
				'housePropertyNumber':$("#searchForm").find("input[name='housePropertyNumber']").val()
				
			},
			dataType : "json",
			success : function(data) {
				if(data.status==1){
					if(data.data.length == 0){
						$.showPop("没有记录","",1000);
						return;
					}
					$.each(data.data,function(i,v){
						$("#p2pOrder_table").bootstrapTable('insertRow', {index: index+1+i, row: v});
					});
					$("#p2pOrder_table").bootstrapTable('updateCell', {index: index, field: 'plusIdIcon',value:'needd'});
				}else{
					$.showPop(data.message,"",1000);
				}
			}
		});
};

$(function(){	
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
		$("#p2pOrder_table").bootstrapTable('refresh');
	});
	$("#btn_reset_order").bind("click",function() {
		$("#searchbar").find('form')[0].reset();
		$("#searchbar").find("form input[type='hidden']").val('');
	});
	$("#edit_btn").bind("click",function() {
		var selected = $("#p2pOrder_table").bootstrapTable('getSelections');
		if(selected.length == 1){
			worf.ajax({
				url : web_root+'/order/getFormParam',
				type : 'post',
				data : {
					'bpId':selected[0].bpId,
					'productId':selected[0].productCode,
					'model':"edit",
					'loanInfoId':selected[0].id
				},
				success : function(data) { 
					if(data.status==1){
						var name = "编辑订单-"+ selected[0].productName;
						data.title=name;
						var url=web_root+"/pages/from-p2p.html?"+$.param(data.data);
						tools.addParentTab(url,name,true);
					}
				}
			});
		}else{
			$.showPop("请选中一行数据","",1000);
		}
		
	});
	
	
	$("#view_btn").bind("click",function() {
		var selected = $("#p2pOrder_table").bootstrapTable('getSelections');
		if(selected.length == 1){
			toView(selected[0]);
		}else{
			$.showPop("请选中一行数据","",1000);
		}
		
	});
	
	
	$("#submit_all_btn").off().on("click",function() {
		  var $this=$(this);
		var selected = $("#p2pOrder_table").bootstrapTable('getSelections');
		if(selected.length == 0){
			$.showPop("请选中至少一行数据","",1000);
		}else{
			var can = true;
			var ids = [];
			$.each(selected,function(i,v){
				if(v.aproveStatus !='1' && v.aproveStatus !='11'){
					can = false;
				}else{
					ids.push(v.id);
				}
			});
			if (!can) {
				$.showPop("新增或退回订单状态才能提交","",1000);
				return;}
			 $this.button('loading')
			$.confirm({
	      	    title:'',
		      content: '是否确定批量提交？',
		      confirm: function(){
		    	  worf.ajax({
						url : web_root+'/order/batchSubmit',
						type : 'post',
						data : {
							"ids":ids
						},
						dataType : "json",
						success : function(data) {
							if(data.status==1){
								$.showPop("批量提交成功","",1000);
								$("#p2pOrder_table").bootstrapTable('refresh');
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
	$("#p2pOrder_table").on("dbl-click-row.bs.table",function(a,b,c,d){
		toView(b);
	}).on("check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table check-some.bs.table uncheck-some.bs.table",function(){
		var selected = $("#p2pOrder_table").bootstrapTable('getSelections');
		//校验是否可以批量提交
		var can=true;
		if(selected.length ==0){
			can =false;
		}else{
			$.each(selected,function(i,v){
				if(v.aproveStatus !='1' && v.aproveStatus !='11'){
					can = false;
				}
			});
		}
		if(!can){
			$("#submit_all_btn").addClass("disabled");
			$("#submit_all_btn").prop("disabled",true);
		}else{
			$("#submit_all_btn").removeClass("disabled");
			$("#submit_all_btn").prop("disabled",false);
		}
	})
});	
function toView(row){
	worf.ajax({
		url : web_root+'/order/getFormParam',
		type : 'post',
		data : {
			'bpId':row.bpId,
			'productId':row.productCode,
			'model':"view",
			'loanInfoId':row.id
		},
		success : function(data) {
			if(data.status==1){
				var url=web_root+"/pages/from-p2p.html?"+$.param(data.data);
				var name = "查看订单-"+ row.productName;
				tools.addParentTab(url,name);
			}
		}
	});
}

