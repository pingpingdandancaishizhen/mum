
var $table = $("#p2pAsset_table");
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
	

	
	$("#add_btn").bind("click",function() {
		tools.addParentTab("/asset/addAssetPage","新增资产方");
	});

	
	$("#btn_search").bind("click",function() {
		$table.bootstrapTable('refresh');
	});
	$("#btn_reset").bind("click",function() {
		$("#createTimeFrom").val('');
		$("#createTimeTo").val('');
		$('#reservationtime').val("");
		$("input[name='corpName']").val("");
		$("select[name='assetType']").val("");
	});
	
	$("#edit_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择资产方");
		} else {
			var url=web_root+"/asset/editAssetPage?id="+selected[0].id;
			var name='修改-'+selected[0].corpAbbreviation+'-资产方';
			tools.addParentTab(url,name);
		}
	});
	
	
	$("#configure_product_all_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择资产方");
		} else {
			var url=web_root+"/asset/loadProductManager?assetId="+selected[0].id;
			var name='新增产品-'+selected[0].corpAbbreviation;
			tools.addParentTab(url,name);
		}
	});
	
	$("#edit_product_all_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');
		if(selected.length === 0 ){
			$.alert("请选择资产方");
		} else {
			worf.ajax({
				url : web_root+'/asset/checkAssetProduct',
				type : 'post',
				data : {
					assetId : 	selected[0].id
				},
				success : function(data) {
					if(data.data!=null && data.data.length>0){
						var url=web_root+"/asset/loadProductEdit?assetId="+selected[0].id;
						var name='修改产品-'+selected[0].corpAbbreviation;
						tools.addParentTab(url,name);
					}else{
						$.alert("该资产方尚未添加产品");
					}
				}
			});
			
			
			
		}
	});
	
});	


function timeFormatter(value){
	if(value && value != ''){
		return tools.formatDate(value,'YYYY/MM/DD HH:mm:ss')
	}
}


