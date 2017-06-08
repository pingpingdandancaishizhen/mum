$(function(){
	
	$('input[name="feeConfig.repaymentType"]').bind('click',function(){
		var t = $(this);
		if(t.is(':checked')){
			var hs= false;
			$("#startPays").find('input').each(function(i,v){
				if($(this).val() == t.val()){
					hs =true;
				}
			});
			if(!hs){
				$("#startPays").append('<label  class="label-box-item"> <input type="checkbox"	name="feeConfig.startPay" value="'+t.val()+'" />'+t.parent().text()+'	</label> ');
			}
			hs = false;
			$("#endPays").find('input').each(function(i,v){
				if($(this).val() == t.val()){
					hs =true;
				}
			});
			if(!hs){
				$("#endPays").append('<label  class="label-box-item"> <input type="checkbox"	name="feeConfig.endPay" value="'+t.val()+'" />'+t.parent().text()+'	</label> ');
			}
		}else{
			$("#startPays").find('input').each(function(i,v){
				if($(this).val() == t.val()){
					$(this).parent().remove();
				}
			});
			$("#endPays").find('input').each(function(i,v){
				if($(this).val() == t.val()){
					$(this).parent().remove();
				}
			});
		}
	});
	
	$('input[name="feeConfig.feeCaType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '1'){
			//固定月综合利率
			$('.msscg').hide();
			$('.msscz').show();
		}else{
			$('.msscg').show();
			$('.msscz').hide();
		}
	});
	
	$('input[name="feeConfig.monthlyFeeCal"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '1'){
			 //重新计算 
			var monthlyFeeCheck=$('#fee_month_add_table tr');
			monthlyFeeCheck.each(function(){
				var j = $(this).children().eq(2).text();
				j = parseFloat(j);
				var m = (j / 12).toFixed(2);
				$(this).children().eq(3).text(m);
				var d = (j / 365).toFixed(2) ;
				$(this).children().eq(4).text(d);
			});
		}else if(t.val() == '2'){
			//重新计算 
			var monthlyFeeCheck=$('#fee_month_add_table tr');
			monthlyFeeCheck.each(function(){
				var j = $(this).children().eq(2).text();
				j = parseFloat(j);
				var m =  (j / 12).toFixed(2) ;
				$(this).children().eq(3).text(m);
				var d = (j / 360).toFixed(2) ;
					$(this).children().eq(4).text(d);
			});
		}
	});
	
	$("#fee_month_add").bind('click',function(){
		$("#monthFeeModal").showModal();
		$("#monthFeeForm #term").val('');
		$("#monthFeeForm #yearlyRate").val('');
		$("#monthFeeForm #monthlyRate").val('');
		$("#monthFeeForm #daylyRate").val('');
	});
	$("#fee_day_add").bind('click',function(){
		$("#dayFeeModal").showModal();
		$("#dayFeeForm #termStart").val('');
		$("#dayFeeForm #termEnd").val('');
		$("#dayFeeForm #daylyRate").val('');
	});
	
	$("#monthFeeForm #yearlyRate").bind('keyup',function(){
		var j = $(this).val();
		if(!xiaoshu.test(j) && !/^\d+\.\d{0,2}$/.test(j)){ 
			$(this).val('');
			return;
		}
		j = parseFloat(j);
		var m =  (j / 12 ).toFixed(2) ;
		$("#monthFeeForm #monthlyRate").val(m);
		var con =$('input[name="feeConfig.monthlyFeeCal"]:checked').val();
		if(con == '1'){
			var d = (j / 365).toFixed(2) ;
			$("#monthFeeForm #daylyRate").val(d);
		}else if(con == '2'){
			var d = (j / 360).toFixed(2) ;
			$("#monthFeeForm #daylyRate").val(d);
		}
		
	});
	$("#addMonthFeeBtn").bind('click',function(){
		$("#fee_month_add_table").append('<tr>'+
		'<td style="display:none">'+$("#monthFeeForm #term").val()+'</td>'+
		'<td>'+$("#monthFeeForm #term option:selected").text()+'</td>'+
		'<td>'+$("#monthFeeForm #yearlyRate").val()+'</td>'+
		'<td>'+$("#monthFeeForm #monthlyRate").val()+'</td>'+
		'<td style="display:none">'+$("#monthFeeForm #daylyRate").val()+'</td>'+
		'<td>'+
			'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#monthFeeModal").hideModal();
	});
	
	$("#addDayFeeBtn").bind('click',function(){
		$("#fee_day_add_table").append('<tr>'+
		'<td>'+$("#dayFeeForm #termStart").val()+'</td>'+
		'<td>'+$("#dayFeeForm #termEnd").val()+'</td>'+
		'<td>'+$("#dayFeeForm #daylyRate").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#dayFeeModal").hideModal();
	});
	
	$("#fee_z_month_add").bind('click',function(){
		$("#monthZFeeModal").showModal();
		$("#monthZFeeForm #deptId").val('');
		$("#monthZFeeForm #monthlyZRate").val('');
	});
	$("#fee_z_day_add").bind('click',function(){
		$("#dayZFeeModal").showModal();
		$("#dayZFeeForm #deptId").val('');
		$("#dayZFeeForm #daylyZRate").val('');
	});
	$("#addMonthZFeeBtn").bind('click',function(){
		$("#fee_z_month_add_table").append('<tr>'+
		'<td> <input type="hidden" name="deptId" value="'+$("#monthZFeeForm #deptId").val()+'"/> '+$("#monthZFeeForm #deptId option:selected").text()+'</td>'+
		'<td>'+$("#monthZFeeForm #monthlyZRate").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#monthZFeeModal").hideModal();
	});
	$("#addDayZFeeBtn").bind('click',function(){
		$("#fee_z_day_add_table").append('<tr>'+
		'<td> <input type="hidden" name="deptId" value="'+$("#dayZFeeForm #deptId").val()+'"/> '+$("#dayZFeeForm #deptId option:selected").text()+'</td>'+
		'<td>'+$("#dayZFeeForm #daylyZRate").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#dayZFeeModal").hideModal();
	});
	$("#fee_g_month_add").bind('click',function(){
		$("#monthGFeeModal").showModal();
		$("#monthGFeeForm #monthlyGRate").val('');
	});
	$("#fee_g_day_add").bind('click',function(){
		$("#dayGFeeModal").showModal();
		$("#dayGFeeForm #daylyGRate").val('');
	});
	$("#addMonthGFeeBtn").bind('click',function(){
		$("#fee_g_month_add_table").append('<tr>'+
		'<td>'+$("#monthGFeeForm #monthlyGRate").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#monthGFeeModal").hideModal();
	});
	$("#addDayGFeeBtn").bind('click',function(){
		$("#fee_g_day_add_table").append('<tr>'+
		'<td>'+$("#dayGFeeForm #daylyGRate").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#dayGFeeModal").hideModal();
	});
	
	$("#gps_fee_add").bind('click',function(){
		$("#gpsFeeModal").showModal();
		$("#gpsFeeForm #gpsFee").val('');
	});
	$("#addGpsFeeBtn").bind('click',function(){
		$("#gps_fee_add_table").append('<tr>'+
		'<td>'+$("#gpsFeeForm #gpsFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#gpsFeeModal").hideModal();
	});
	
	$("#gpsser_fee_add").bind('click',function(){
		$("#gpsserFeeModal").showModal();
		$("#gpsserFeeForm #gpsserFee").val('');
	});
	$("#addGpsserFeeBtn").bind('click',function(){
		$("#gpsser_fee_add_table").append('<tr>'+
		'<td>'+$("#gpsserFeeForm #gpsserFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#gpsserFeeModal").hideModal();
	});
	
/*	$("#park_fee_add").bind('click',function(){
		$("#parkFeeModal").showModal();
		$("#parkFeeForm #parkFee").val('');
	});
	$("#addParkFeeBtn").bind('click',function(){
		$("#park_fee_add_table").append('<tr>'+
		'<td>'+$("#parkFeeForm #parkFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#parkFeeModal").hideModal();
	});*/
	
	$("#wyl_fee_add").bind('click',function(){
		$("#wylFeeModal").showModal();
		$("#wylFeeForm #wylFee").val('');
	});
	$("#addWylFeeBtn").bind('click',function(){
		$("#wyl_fee_add_table").append('<tr>'+
		'<td>'+$("#wylFeeForm #wylFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#wylFeeModal").hideModal();
	});
	
	$("#bzjl_fee_add").bind('click',function(){
		$("#bzjlFeeModal").showModal();
		$("#bzjlFeeForm #bzjlFee").val('');
	});
	$("#addBzjlFeeBtn").bind('click',function(){
		$("#bzjl_fee_add_table").append('<tr>'+
		'<td>'+$("#bzjlFeeForm #bzjlFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#bzjlFeeModal").hideModal();
	});
	$("#znjl_fee_add").bind('click',function(){
		$("#znjlFeeModal").showModal();
		$("#znjlFeeForm #znjlFee").val('');
	});
	$("#addZnjlFeeBtn").bind('click',function(){
		$("#znjl_fee_add_table").append('<tr>'+
		'<td>'+$("#znjlFeeForm #znjlFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#znjlFeeModal").hideModal();
	});
	
	$("#savFeeConfigBtn").bind('click',function(){
		var obj = packageValue();
		var r = validateValue(obj);
		if(r.status){
			$.alert(r.message);
			return;
		}
		worf.ajax({
			url : web_root+"/solution/product/feeConfig",
	 		type : 'post',
	 		data : {
	 			productId:$("#productId").val(),
	 			feeConfig:JSON.stringify(obj)
			},
	 		success : function(data) {
	 			if(data.status==1){
	 				$.showPop("配置完成","",2000);
	 				window.setTimeout(function(){
					    tools.closeParentTab()
        			},2000);
	 			}else{
	 				$.showPop(data.message,"",2000);
	 			}
	 		}
		});
	});
	$("#cancelBtn").bind('click',function(){
		tools.closeParentTab()
	});
	if(feeConfig!=null){
		setValue(feeConfig);
	}
});
function removeRow(obj){
	$(obj).parent().parent().remove();
}

function packageValue(){
	var result={};
	//支持的还款方式
	var repaymentTypeCheck=$('input[name="feeConfig.repaymentType"]:checked');
	result.repaymentTypes=[];
	repaymentTypeCheck.each(function(){
		result.repaymentTypes.push({'repaymentType':$(this).val(),'repaymentTypeName':$(this).parent().text().trim(),'supportFirstPay':[]});
	});
	//获取支持的还款方式
	var startPayCheck=$('input[name="feeConfig.startPay"]:checked');
	var endPayCheck=$('input[name="feeConfig.endPay"]:checked');
	//期初还是期末支付首付款
	startPayCheck.each(function(){
		for(var i=0;i<result.repaymentTypes.length;i++){
			if(result.repaymentTypes[i]['repaymentType'] == $(this).val()){
				result.repaymentTypes[i]['supportFirstPay'].push({'payType':'1','payName':'期初支付'});
			}
		}
	});
	endPayCheck.each(function(){
		for(var i=0;i<result.repaymentTypes.length;i++){
			if(result.repaymentTypes[i]['repaymentType'] == $(this).val()){
				result.repaymentTypes[i]['supportFirstPay'].push({'payType':'2','payName':'期末支付'});
			}
		}
	});
	//每期时长
	var eachTimeCheck=$('input[name="feeConfig.eachtimes"]:checked');
	result.eachTimes=[];
	eachTimeCheck.each(function(){
		result.eachTimes.push({'eachTime':$(this).val(),'eachTimeName':$(this).parent().text().trim()});
	});
	var feeCaTypeCheck=$('input[name="feeConfig.feeCaType"]:checked');
	//设置计算方式
	result.feeCaType=feeCaTypeCheck.val();
	//费用关联方
	result.feeRelated=[];
	var feereatedCheck=$('#feerelated tr');
	feereatedCheck.each(function(){
		var f =$(this).find('select[name="partner"]').val();
		var partnerId,partnerRoleId;
		if(f){
			partnerId = f.split('-')[1];
			partnerRoleId =f.split('-')[0];
		}
		result.feeRelated.push({'feeKey':$(this).find('input[name="feeKey"]').val(),'feeName':$.trim($(this).children().eq(1).text()),
			'partnerId':partnerId,'partnerRoleId':partnerRoleId});
	});
	//月利率设置
	result.monthlyFee=[];
	var monthlyFeeCheck=$('#fee_month_add_table tr');
	monthlyFeeCheck.each(function(){
		result.monthlyFee.push({'term':$.trim($(this).children().eq(0).text()),'termText':$.trim($(this).children().eq(1).text()),'yearlyRate':$.trim($(this).children().eq(2).text()),'monthlyRate':$.trim($(this).children().eq(3).text()),'daylyRate':$.trim($(this).children().eq(4).text())});
	});
	if(result.feeCaType =='1'){
		//固定月综合利率
		result.monthlyZHFee=[];
		var monthlyZHFeeCheck=$('#fee_z_month_add_table tr');
		monthlyZHFeeCheck.each(function(){
			result.monthlyZHFee.push({'deptId':$(this).find('input[name="deptId"]').val(),'deptName':$.trim($(this).children().eq(0).text()),'rate':$.trim($(this).children().eq(1).text())});
		});
		result.daylyZHFee=[];
		var daylyZHFeeCheck=$('#fee_z_day_add_table tr');
		daylyZHFeeCheck.each(function(){
			result.daylyZHFee.push({'deptId':$(this).find('input[name="deptId"]').val(),'deptName':$.trim($(this).children().eq(0).text()),'rate':$.trim($(this).children().eq(1).text())});
		});
		
	}else if(result.feeCaType == '2'){
		//固定月管理费
		result.monthlyGLFee=[];
		var monthlyGLFeeCheck=$('#fee_g_month_add_table tr');
		monthlyGLFeeCheck.each(function(){
			result.monthlyGLFee.push($.trim($(this).children().eq(0).text()));
		});
		
		result.daylyGLFee=[];
		var daylyGLFeeCheck=$('#fee_g_day_add_table tr');
		daylyGLFeeCheck.each(function(){
			result.daylyGLFee.push($.trim($(this).children().eq(0).text()));
		});
	}
	//押品安装
	result.gpsFee=[];
	var gpsFeeCheck=$('#gps_fee_add_table tr');
	gpsFeeCheck.each(function(){
		result.gpsFee.push($.trim($(this).children().eq(0).text()));
	});
	result.gpsSerFee=[];
	var gpsSerFeeCheck=$('#gpsser_fee_add_table tr');
	gpsSerFeeCheck.each(function(){
		result.gpsSerFee.push($.trim($(this).children().eq(0).text()));
	});
/*	result.parkFee=[];
	var parkFeeCheck=$('#park_fee_add_table tr');
	parkFeeCheck.each(function(){
		result.parkFee.push($.trim($(this).children().eq(0).text()));
	});*/
	//违约率设置
	var wylFeeCheck=$('#wyl_fee_add_table tr');
	result.wyFee=[];
	wylFeeCheck.each(function(){
		result.wyFee.push($.trim($(this).children().eq(0).text()));
	});
	//保证金率
	var bzjlFeeCheck=$('#bzjl_fee_add_table tr');
	result.bzjFee=[];
	bzjlFeeCheck.each(function(){
		result.bzjFee.push($.trim($(this).children().eq(0).text()));
	});
	var znjlFeeCheck=$('#znjl_fee_add_table tr');
	result.znjFee=[];
	znjlFeeCheck.each(function(){
		result.znjFee.push($.trim($(this).children().eq(0).text()));
	});
	//滞纳金计算方式设置
	result.znjFeeCal=$('input[name="feeConfig.znjFeeCal"]:checked').val();
	//年月日率计算方式设置:
	result.monthlyFeeCal=$('input[name="feeConfig.monthlyFeeCal"]:checked').val();
	result.daylyFee=[];
	var daylyFeeCheck=$('#fee_day_add_table tr');
	daylyFeeCheck.each(function(){
		result.daylyFee.push({'termStart':$.trim($(this).children().eq(0).text()),'termEnd':$.trim($(this).children().eq(1).text()),'daylyRate':$.trim($(this).children().eq(2).text())});
	});
	return result;
}
function setValue(feeConfig){
	for(var i=0;i<feeConfig.repaymentTypes.length;i++){
		var tmp =feeConfig.repaymentTypes[i];
		$('input[name="feeConfig.repaymentType"][value="'+tmp.repaymentType+'"]').prop('checked',true);
		$("#startPays").append('<label class="label-box-item"> <input type="checkbox"	name="feeConfig.startPay" value="'+tmp.repaymentType+'" />'+tmp.repaymentTypeName+'	</label> ');
		$("#endPays").append('<label class="label-box-item"> <input type="checkbox"	name="feeConfig.endPay" value="'+tmp.repaymentType+'" />'+tmp.repaymentTypeName+'	</label> ');
		for(var j=0;j<tmp.supportFirstPay.length;j++){
			var tmpsu = tmp.supportFirstPay[j];
			if(tmpsu.payType=='1'){
				$("#startPays").find('input[name="feeConfig.startPay"][value="'+tmp.repaymentType+'"]').prop('checked',true);
			}else if(tmpsu.payType=='2'){
				$("#endPays").find('input[name="feeConfig.endPay"][value="'+tmp.repaymentType+'"]').prop('checked',true);
			}
		}
	}
	for(var i=0;i<feeConfig.eachTimes.length;i++){
		$('input[name="feeConfig.eachtimes"][value="'+feeConfig.eachTimes[i].eachTime+'"]').prop('checked',true);
	}
	$('input[name="feeConfig.feeCaType"][value="'+feeConfig.feeCaType+'"]').trigger('click');
	$('input[name="feeConfig.znjFeeCal"][value="'+feeConfig.znjFeeCal+'"]').prop('checked',true);
	$('#feerelated tr').each(function(){
		for(var i=0;i<feeConfig.feeRelated.length;i++){
			var tmp =feeConfig.feeRelated[i];
			if($(this).find('input[name="feeKey"]').val() == tmp.feeKey){
				$(this).find('select[name="partner"]').val(tmp.partnerRoleId+'-'+tmp.partnerId);
			}
		}
	});
	for(var i =0;i<feeConfig.monthlyFee.length;i++){
		var tmp = feeConfig.monthlyFee[i];
		$("#fee_month_add_table").append('<tr>'+
				'<td style="display:none">'+tmp.term+'</td>'+
				'<td>'+tmp.termText+'</td>'+
				'<td>'+tmp.yearlyRate+'</td>'+
				'<td>'+tmp.monthlyRate+'</td>'+
				'<td style="display:none">'+tmp.daylyRate+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.daylyFee.length;i++){
		var tmp = feeConfig.daylyFee[i];
		$("#fee_day_add_table").append('<tr>'+
				'<td>'+tmp.termStart+'</td>'+
				'<td>'+tmp.termEnd+'</td>'+
				'<td>'+tmp.daylyRate+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	if(feeConfig.feeCaType == '1'){
		//月综
		for(var i =0;i<feeConfig.monthlyZHFee.length;i++){
			var tmp = feeConfig.monthlyZHFee[i];
			$("#fee_z_month_add_table").append('<tr>'+
					'<td> <input type="hidden" name="deptId" value="'+tmp.deptId+'"/> '+tmp.deptName+'</td>'+
					'<td>'+tmp.rate+'</td>'+
					'<td>'+
					'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
					'</td>'+
					'</tr>');
		}
		
		for(var i =0;i<feeConfig.daylyZHFee.length;i++){
			var tmp = feeConfig.daylyZHFee[i];
			$("#fee_z_day_add_table").append('<tr>'+
					'<td> <input type="hidden" name="deptId" value="'+tmp.deptId+'"/> '+tmp.deptName+'</td>'+
					'<td>'+tmp.rate+'</td>'+
					'<td>'+
					'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
					'</td>'+
					'</tr>');
		}
	}
	if(feeConfig.feeCaType == '2'){
		//月管理
		for(var i =0;i<feeConfig.monthlyGLFee.length;i++){
			var tmp = feeConfig.monthlyGLFee[i];
		$("#fee_g_month_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
		}
		for(var i =0;i<feeConfig.daylyGLFee.length;i++){
			var tmp = feeConfig.daylyGLFee[i];
		$("#fee_g_day_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a " onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
		}
	}
	for(var i =0;i<feeConfig.gpsFee.length;i++){
		var tmp = feeConfig.gpsFee[i];
		$("#gps_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"></i><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.gpsSerFee.length;i++){
		var tmp = feeConfig.gpsSerFee[i];
		$("#gpsser_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
/*	for(var i =0;i<feeConfig.parkFee.length;i++){
		var tmp = feeConfig.parkFee[i];
		$("#park_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}*/
	for(var i =0;i<feeConfig.wyFee.length;i++){
		var tmp = feeConfig.wyFee[i];
		$("#wyl_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class=" btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.bzjFee.length;i++){
		var tmp = feeConfig.bzjFee[i];
		$("#bzjl_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
			'<div class=" btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.znjFee.length;i++){
		var tmp = feeConfig.znjFee[i];
		$("#znjl_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
			'<div class=" btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	$('input[name="feeConfig.monthlyFeeCal"][value="'+feeConfig.monthlyFeeCal+'"]').trigger('click');
}

var xiaoshu=/^\d+(\.\d{1,2})?$/;
var zhengshu=/^\d+$/;
function validateValue(v){
	var r = {status:false,message:''};
	if(v.bzjFee.length==0){
		r.status = true;
		r.message +='请增加保证金配置<br/>';
	}else{
		for(var i=0;i<v.bzjFee.length;i++){
			if(!xiaoshu.test(v.bzjFee[i])){
				r.status = true;
				r.message +='保证金填写数字(允许两位小数)<br/>';
			}
		}
	}
	if(v.wyFee.length==0){
		r.status = true;
		r.message +='请增加违约金率配置<br/>';
	}else{
		for(var i=0;i<v.wyFee.length;i++){
			if(!xiaoshu.test(v.wyFee[i])){
				r.status = true;
				r.message +='违约金率填写数字(允许两位小数)<br/>';
			}
		}
	}
	if(v.znjFee.length==0){
		r.status = true;
		r.message +='请增加滞纳金配置<br/>';
	}else{
		for(var i=0;i<v.znjFee.length;i++){
			if(!xiaoshu.test(v.znjFee[i])){
				r.status = true;
				r.message +='滞纳金填写数字(允许两位小数)<br/>';
			}
		}
	}
	if(v.eachTimes.length==0){
		r.status = true;
		r.message +='请增加每期时长配置<br/>';
	}
	if(!v.feeCaType){
		r.status = true;
		r.message +='请选择月利率综合利率设置<br/>';
	}
	if(v.feeCaType == '1'){
		//判断综合费
		if(v.monthlyZHFee.length == 0 ){
			r.status = true;
			r.message +='请增加月综合利率设置<br/>';
		}else{
			var bumen = false;
			for(var i=0;i<v.monthlyZHFee.length;i++){
				if(!xiaoshu.test(v.monthlyZHFee[i].rate)){
					r.status = true;
					r.message +='月综合费率填写数字(允许两位小数)<br/>';
				}
				if(v.monthlyZHFee[i].deptId == ''){
					bumen = true;
				}
			}
			if(!bumen){
				r.status = true;
				r.message +='月综合费率最少填写一个默认值<br/>';
			}
		}
		
		for(var t in v.repaymentTypes){
			if( v.repaymentTypes[t].repaymentTypeName == "一次性还清" ){
				if(v.daylyZHFee.length == 0 ){
					r.status = true;
					r.message +='请增加日综合利率设置<br/>';
				}else{
					var bumen = false;
					for(var i=0;i<v.daylyZHFee.length;i++){
						if(!xiaoshu.test(v.daylyZHFee[i].rate)){
							r.status = true;
							r.message +='日综合费率填写数字(允许两位小数)<br/>';
						}
						if(v.daylyZHFee[i].deptId == ''){
							bumen = true;
						}
					}
					if(!bumen){
						r.status = true;
						r.message +='日综合费率最少填写一个默认值<br/>';
					}
				}
			}
		}	
			
		
	}else if(v.feeCaType == '2'){
		//月日管理费
		if(v.monthlyGLFee.length==0){
			r.status = true;
			r.message +='请增加月管理费配置<br/>';
		}else{
			for(var i=0;i<v.monthlyGLFee.length;i++){
				if(!xiaoshu.test(v.monthlyGLFee[i])){
					r.status = true;
					r.message +='月管理费用填写数字(允许两位小数)<br/>';
				}
			}
		}
		if(v.daylyGLFee.length==0){
			r.status = true;
			r.message +='请增加日管理费配置<br/>';
		}else{
			for(var i=0;i<v.daylyGLFee.length;i++){
				if(!xiaoshu.test(v.daylyGLFee[i])){
					r.status = true;
					r.message +='日管理费用填写数字(允许两位小数)<br/>';
				}
			}
		}
	}
	if(v.gpsFee.length==0){
		r.status = true;
		r.message +='请增加GPS费用配置<br/>';
	}else{
		for(var i=0;i<v.gpsFee.length;i++){
			if(!xiaoshu.test(v.gpsFee[i])){
				r.status = true;
				r.message +='GPS费用填写数字(允许两位小数)<br/>';
			}
		}
	}
	if(v.gpsSerFee.length==0){
		r.status = true;
		r.message +='请增加GPS服务费用配置<br/>';
	}else{
		for(var i=0;i<v.gpsSerFee.length;i++){
			if(!xiaoshu.test(v.gpsSerFee[i])){
				r.status = true;
				r.message +='GPS服务费用填写数字(允许两位小数)<br/>';
			}
		}
	}
/*	if(v.parkFee.length==0){
		r.status = true;
		r.message +='请增加停车费用配置<br/>';
	}else{
		for(var i=0;i<v.parkFee.length;i++){
			if(!xiaoshu.test(v.parkFee[i])){
				r.status = true;
				r.message +='停车费用填写数字<br/>';
			}
		}
	}*/
	if(v.monthlyFee.length==0){
		r.status = true;
		r.message +='请增加月标配置<br/>';
	}else{
		for(var i=0;i<v.monthlyFee.length;i++){
			if(!xiaoshu.test(v.monthlyFee[i].monthlyRate)||!xiaoshu.test(v.monthlyFee[i].daylyRate)||!xiaoshu.test(v.monthlyFee[i].yearlyRate)){
				r.status = true;
				r.message +='月标配置填写数字(允许两位小数)<br/>';
			}
		}
	}
	for(var t2 in v.repaymentTypes){
		if( v.repaymentTypes[t2].repaymentTypeName == "一次性还清" ){
			if(v.daylyFee.length==0){
				r.status = true;
				r.message +='请增加天标配置<br/>';
			}else{
				for(var i=0;i<v.daylyFee.length;i++){
					if(!zhengshu.test(v.daylyFee[i].termStart)){
						r.status = true;
						r.message +='天标配置开始期限填写数字<br/>';
					}
					if(!zhengshu.test(v.daylyFee[i].termEnd)){
						r.status = true;
						r.message +='天标配置结束期限填写数字<br/>';
					}
					if(!xiaoshu.test(v.daylyFee[i].daylyRate)){
						r.status = true;
						r.message +='天标配置填写数字(允许两位小数)<br/>';
					}
				}
				
			}
		}
	}
	
	if(v.repaymentTypes.length==0){
		r.status = true;
		r.message +='请选择一种还款方式<br/>';
	}else{
		for(var i=0;i<v.repaymentTypes.length;i++){
			if( v.repaymentTypes[i].supportFirstPay.length == 0 ){
				r.status = true;
				r.message +=('请为'+v.repaymentTypes[i].repaymentTypeName+'选择首还款支付方式<br/>');
			}
		}
	}
	if(!v.znjFeeCal){
		r.status = true;
		r.message +='请选择滞纳金计算方式设置<br/>';
	}
	if(!v.monthlyFeeCal){
		r.status = true;
		r.message +='请选择年月日率计算方式设置<br/>';
	}
	if(!r.status){
		//判断日利率期限是否有重叠
		var daylyFee = v.daylyFee;
		var d ={};
		for(var i =0;i<daylyFee.length;i++ ){
			var start = parseInt(daylyFee[i].termStart);
			var end =  parseInt(daylyFee[i].termEnd);
			if(start > end){
				r.status = true;
				r.message +='天标配置结束期限不能大于开始期限<br/>';
			}
			for(var j=start;j<=end;j++){
				if(!d[j]){
					d[j]=true;
				}else{
					r.status = true;
					r.message +='天标配置配置期限有重复<br/>';
					break;
				}
				
			}
			if(r.status){
				break;
			}
		}
	}
	return r;
}
