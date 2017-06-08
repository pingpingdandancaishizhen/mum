function removeRow(obj){
	$(obj).parent().parent().remove();
}

$(function(){
	$("#productType").bind('change',function(){
		$("#productName option:gt(0)").remove();
		for(var i in names){
			if(names[i].typeId == $(this).val() ){
				$("#productName option:eq(0)").after("<option value='"+ names[i].id+"'>"+names[i].name +"</option>");
			}
		}
	});
	
	$("#wyl_fee_add").bind('click',function(){
		$("#wylFeeModal").showModal();
		$("#wylFeeForm #wylStart").val('');
		$("#wylFeeForm #wylEnd").val('');
		$("#wylFeeForm #wylFee").val('');
	});
	
	
	
	
	$("#addWylFeeBtn").bind('click',function(){
		$("#wyl_fee_add_table").append(
		'<tr>'+
		'<td>'+$("#wylFeeForm #wylStart").val()+'</td>'+
		'<td>'+$("#wylFeeForm #wylEnd").val()+'</td>'+
		'<td>'+$("#wylFeeForm #wylFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#wylFeeModal").hideModal();
	});
	
	$('input[name="feeConfig.znjCalType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$('#znjCalAmountType').hide();
			$('#znjCalTermType').show();
		} else {
			$('#znjCalTermType').hide();
			$('#znjCalAmountType').show();
		}
	});
	
	$("#znjl_fee_add").bind('click',function(){
		$("#znjlFeeModal").showModal();
		$("#znjlFeeForm #znjlStart").val('');
		$("#znjlFeeForm #znjlEnd").val('');
		$("#znjlFeeForm #znjlFee").val('');
	});
	$("#addZnjlFeeBtn").bind('click',function(){
		$("#znjl_fee_add_table").append('<tr>'+
		'<td>'+$("#znjlFeeForm #znjlStart").val()+'</td>'+
		'<td>'+$("#znjlFeeForm #znjlEnd").val()+'</td>'+
		'<td>'+$("#znjlFeeForm #znjlFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#znjlFeeModal").hideModal();
	});
	
	
	$('input[name="feeConfig.bzjType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$('#bzjCalType').hide();
		} else {
			$('#bzjCalType').show();
		}
	});
	
	$("#bzjl_fee_add").bind('click',function(){
		$("#bzjlFeeModal").showModal();
		$("#bzjlFeeForm #bzjlStart").val('');
		$("#bzjlFeeForm #bzjlEnd").val('');
		$("#bzjlFeeForm #bzjlFee").val('');
	});
	$("#addBzjlFeeBtn").bind('click',function(){
		$("#bzjl_fee_add_table").append('<tr>'+
		'<td>'+$("#bzjlFeeForm #bzjlStart").val()+'</td>'+
		'<td>'+$("#bzjlFeeForm #bzjlEnd").val()+'</td>'+
		'<td>'+$("#bzjlFeeForm #bzjlFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#bzjlFeeModal").hideModal();
	});
	
	$('input[name="feeConfig.otherType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$('#otherCalType').hide();
		} else {
			$('#otherCalType').show();
		}
	});
	
	$("#other_fee_add").bind('click',function(){
		$("#otherFeeModal").showModal();
		$("#otherFeeForm #otherStart").val('');
		$("#otherFeeForm #otherEnd").val('');
		$("#otherFeeForm #otherFee").val('');
	});
	$("#addOtherFeeBtn").bind('click',function(){
		$("#other_fee_add_table").append('<tr>'+
		'<td>'+$("#otherFeeForm #otherStart").val()+'</td>'+
		'<td>'+$("#otherFeeForm #otherEnd").val()+'</td>'+
		'<td>'+$("#otherFeeForm #otherFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#otherFeeModal").hideModal();
	});
	
	$('input[name="feeConfig.gpsType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$('#gpsCalType').hide();
		} else {
			$('#gpsCalType').show();
		}
	});
	
	
	$('input[name="feeConfig.repaymentType"]').bind('click',function(){
		var flag = false;
		$('.repaymentType:checked').each(function(){
			if($(this).val()==3){
				flag = true;
			}
		});
		if((flag && $(this).is(':checked') && $(this).val()==3) || (flag && $('.repaymentType:checked').length==1)){
			$("#nomal-repayment").hide();
			$("#lump-sum-repayment").show();
		}else{
			$("#nomal-repayment").show();
			$("#lump-sum-repayment").hide();
		}
		
		var $fmt = $("#fee_month_add_table");
		var $fdt = $("#fee_day_add_table");
		var $zft = $("#znjl_fee_add_term_table");
		
		if($(this).val()==3 && $(this).is(':checked')){
			$('input[name="feeConfig.lumpSumTerm"]').prop("checked",true);
			$fmt.append('<tr id="fmt_1-60">'+
					'<td>1-60天</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
			'</tr>');
			
			
			$fdt.append('<tr id="fdt_1-60">'+
					'<td>1-60天</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
			'</tr>');
			
			$zft.append('<tr id="zft_1-60">'+
					'<td>1-60天</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
			'</tr>');
		}
		
		if($(this).val()==3 && (!$(this).is(':checked'))){
			$('input[name="feeConfig.lumpSumTerm"]').prop("checked",false);
			$fmt.find("#fmt_1-60").remove();
			$fdt.find("#fdt_1-60").remove();
			$zft.find("#zft_1-60").remove();
		}
		
		
		/*if(($('.repaymentType:checked').length==1 && 
				$('.repaymentType:checked')[0].value==3)
				|| $('.repaymentType:checked').length==1){
			
			$("#nomal-repayment").hide();
			$("#lump-sum-repayment").show();
			
		}else{
			$("#nomal-repayment").show();
			$("#lump-sum-repayment").hide();
		}*/
		
		
	});
	$('input[name="feeConfig.term"]').bind('click',function(){
		var $fmt = $("#fee_month_add_table");
		var $fdt = $("#fee_day_add_table");
		var $zft = $("#znjl_fee_add_term_table");
		var t = $(this);
		if(t.is(':checked')){
				if($fmt.find("tr").size() == 0 ){
					$fmt.append('<tr id="fmt_'+t.val()+'">'+
							'<td>'+t.val()+'个月</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$fmt.find("tr:last").after('<tr id="fmt_'+t.val()+'">'+
							'<td>'+t.val()+'个月</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
				
				if($fdt.find("tr").size() == 0 ){
					$fdt.append('<tr id="fdt_'+t.val()+'">'+
							'<td>'+t.val()+'个月</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$fdt.find("tr:last").after('<tr id="fdt_'+t.val()+'">'+
							'<td>'+t.val()+'个月</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
				
				if($zft.find("tr").size() == 0 ){
					$zft.append('<tr id="zft_'+t.val()+'">'+
							'<td>'+t.val()+'个月</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$zft.find("tr:last").after('<tr id="zft_'+t.val()+'">'+
							'<td>'+t.val()+'个月</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
		} else {
			$fmt.find("#fmt_"+t.val()).remove();
			$fdt.find("#fdt_"+t.val()).remove();
			$zft.find("#zft_"+t.val()).remove();
		}
	});
	
	
	
	$('input[name="feeConfig.lumpSumTerm"]').bind('click',function(){
		var $fmt = $("#fee_month_add_table");
		var $fdt = $("#fee_day_add_table");
		var $zft = $("#znjl_fee_add_term_table");
		var t = $(this);
		if(t.is(':checked')){
				if($fmt.find("tr").size() == 0 ){
					$fmt.append('<tr id="fmt_1-60">'+
							'<td>1-60天</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$fmt.find("tr:last").after('<tr id="fmt_1-60">'+
							'<td>1-60天</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
				
				if($fdt.find("tr").size() == 0 ){
					$fdt.append('<tr id="fdt_1-60">'+
							'<td>1-60天</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$fdt.find("tr:last").after('<tr id="fdt_1-60">'+
							'<td>1-60天</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
				
				if($zft.find("tr").size() == 0 ){
					$zft.append('<tr id="zft_1-60">'+
							'<td>1-60天</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$zft.find("tr:last").after('<tr id="zft_1-60">'+
							'<td>1-60天</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
		} else {
			$fmt.find("#fmt_1-60").remove();
			$fdt.find("#fdt_1-60").remove();
			$zft.find("#zft_1-60").remove();
		}
	});
	
	$("#savFeeConfigBtn").bind('click',function(){
		var obj = packageValue();
		var r = validateValue(obj);
		if(r.status){
			$.alert(r.message);
			return;
		}
		worf.ajax({
			url : web_root+"/asset/saveProduct",
	 		type : 'post',
	 		data : {
	 			assetId : $("#assetId").val(),
	 			productName:$("#productName").val(),
	 			productType:$("#productType").val(),
	 			productCode:$("#productCode").val(),
	 			desc:$("#desc").val(),
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
});

function packageValue(){
	var result={};
	//一次性还款
	 
	if($("#lumpSumRepayment").is(":checked")){
		result.lumpSumRepayment = 1;
	}else{
		result.lumpSumRepayment = 2;
	}
	// 一次性还款期限
	var lumpTermCheck=$('input[name="feeConfig.lumpSumTerm"]:checked');
	result.lumpSumTerms=[];
	lumpTermCheck.each(function(){
		result.lumpSumTerms.push({
			'term':$(this).val(),
			'termName':$(this).parent().text().trim()
		});
	});
	
	//支持的还款方式
	var repaymentTypeCheck=$('input[name="feeConfig.repaymentType"]:checked');
	result.repaymentTypes=[];
	repaymentTypeCheck.each(function(){
		result.repaymentTypes.push({
			'repaymentType' : $(this).val(),
			'repaymentTypeName' : $(this).parent().text().trim()
		});
	});
	// 借款期限
	var termCheck=$('input[name="feeConfig.term"]:checked');
	result.terms=[];
	termCheck.each(function(){
		result.terms.push({
			'term':$(this).val(),
			'termName':$(this).parent().text().trim()
		});
	});
	//第一期本息扣除方式
	result.firstIssueType = $('input[name="feeConfig.firstIssueType"]:checked').val(); 
	//借款人实收金额
	result.loanType = $('input[name="feeConfig.loanType"]:checked').val(); 
	
	var autoTypeCheck=$('input[name="feeConfig.autoType"]:checked');
	//支持的自动流程
	var autoTypeCheckArr=[];
	autoTypeCheck.each(function(){
		autoTypeCheckArr.push(
			$(this).val()
		);
	});
	result.autoTypeCheck = autoTypeCheckArr.join(",");
	
	//月利率设置
	result.monthlyFee=[];
	var monthlyFeeCheck=$('#fee_month_add_table tr');
	monthlyFeeCheck.each(function(){
		result.monthlyFee.push({
			'termText':$.trim($(this).children().eq(0).text()),
			'monthlyRate':$.trim($(this).children().eq(1).find("input").val()),
			'monthlyGLRate':$.trim($(this).children().eq(2).find("input").val())
		});
	});
	
	//日利率设置
	result.daylyFee=[];
	var daylyFeeCheck=$('#fee_day_add_table tr');
	daylyFeeCheck.each(function(){
		if($.trim($(this).children().eq(1).find("input").val())!="" || 
				$.trim($(this).children().eq(2).find("input").val()) !=""){
			result.daylyFee.push({
				'termText':$.trim($(this).children().eq(0).text()),
				'daylyRate':$.trim($(this).children().eq(1).find("input").val()),
				'daylyGLRate':$.trim($(this).children().eq(2).find("input").val())
			});
		}
	});
	
	//违约率设置
	var wylFeeCheck=$('#wyl_fee_add_table tr');
	result.wyFee=[];
	wylFeeCheck.each(function(){
		result.wyFee.push({
			"wylStart" : $.trim($(this).children().eq(0).text()),
			"wylEnd" : $.trim($(this).children().eq(1).text()),
			"wylFee" : $.trim($(this).children().eq(2).text())
		});
	});
	
	
	result.znjCalType = $('input[name="feeConfig.znjCalType"]:checked').val();
	if(result.znjCalType == "1"){
		var znlFeeCheck=$('#znjl_fee_add_table tr');
		result.znFee=[];
		znlFeeCheck.each(function(){
			result.znFee.push({
				"znlStart" : $.trim($(this).children().eq(0).text()),
				"znlEnd" : $.trim($(this).children().eq(1).text()),
				"znlFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}else if(result.znjCalType == "2"){
		var znlFeeCheck=$('#znjl_fee_add_term_table tr');
		result.znFee=[];
		znlFeeCheck.each(function(){
			result.znFee.push({
				"termText" : $.trim($(this).children().eq(0).text()),
				"znlRate" : $.trim($(this).children().eq(1).find("input").val())
			});
		});
	}
	
	result.bzjType = $('input[name="feeConfig.bzjType"]:checked').val();
	if(result.bzjType == "1"){
		var bzlFeeCheck=$('#bzjl_fee_add_table tr');
		result.bzjFee=[];
		bzlFeeCheck.each(function(){
			result.bzjFee.push({
				"bzjStart" : $.trim($(this).children().eq(0).text()),
				"bzjEnd" : $.trim($(this).children().eq(1).text()),
				"bzjFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}
	
	result.otherType = $('input[name="feeConfig.otherType"]:checked').val();
	if(result.otherType == "1"){
		var otherFeeCheck=$('#other_fee_add_table tr');
		result.otherFee=[];
		otherFeeCheck.each(function(){
			result.otherFee.push({
				"otherStart" : $.trim($(this).children().eq(0).text()),
				"otherEnd" : $.trim($(this).children().eq(1).text()),
				"otherFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}

	result.gpsType = $('input[name="feeConfig.gpsType"]:checked').val();
	if(result.gpsType == "1"){
		result.gpsFirstFee = $('input[name="feeConfig.gpsFirstFee"]').val();
		result.gpsFee = $('input[name="feeConfig.gpsFee"]').val();
		result.gpsServiceFee = $('input[name="feeConfig.gpsServiceFee"]').val();
	}
	
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


function validateValue(v){
	var xiaoshu  = /^\d+(\.\d{1,2})?$/;
	var zhengshu = /^\d+$/;
	var productName_pattern =  /^[\u4e00-\u9fa5a-zA-Z]{2,20}$/;
	var r = {
		status:false,
		message:''
	};
	
	if($("#productType").val()==""){
		r.status = true;
		r.message +='请选择贷款介质<br/>';
	}
	if($("#productName").val().trim()==""){
		r.status = true;
		r.message +='请输入产品名称<br/>';
	}else if(!productName_pattern.test($("#productName").val().trim())){
		r.status = true;
		r.message +='产品名称请输入2-20个中英文个字符<br/>';	
	}
	if($("#productCode").val()==""){
		r.status = true;
		r.message +='请输入产品代码<br/>';
	} else if(!/^[A-Z]+$/.test($("#productCode").val())){
		r.status = true;
		r.message +='产品代码请输入大写字母<br/>';
	}
	
	if(v.repaymentTypes.length==0){
		r.status = true;
		r.message +='请选择借款人还款方式<br/>';
	}
	
	if(v.terms.length==0){
		r.status = true;
		r.message +='请选择借款期限<br/>';
	}
	
	for(var i=0;i<v.monthlyFee.length;i++){
		if(v.monthlyFee[i].monthlyRate == "" || v.monthlyFee[i].monthlyGLRate == ""){
			r.status = true;
			if(-1==r.message.indexOf('请增加月利率/月管理费率')){
				r.message +='请增加月利率/月管理费率<br/>';
			}
			break;
		} else {
			if(!xiaoshu.test(v.monthlyFee[i].monthlyRate)){
				r.status = true;
				if(-1==r.message.indexOf('月利率填写数字(允许两位小数)')){
					r.message +='月利率填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.monthlyFee[i].monthlyGLRate)){
				r.status = true;
				if(-1==r.message.indexOf('月管理费率填写数字(允许两位小数)')){
					r.message +='月管理费率填写数字(允许两位小数)<br/>';
				}
			}
		}
	}
	if(v.daylyFee.length!=0  && v.daylyFee.length!=v.monthlyFee.length){
		r.status = true;
		if(-1==r.message.indexOf('请完整配置日利率和日管理费率')){
			r.message +='请完整配置日利率和日管理费率<br/>';
		}
	}
	
	if(v.daylyFee.length==v.monthlyFee.length){
		for(var i=0;i<v.daylyFee.length;i++){
			if(v.daylyFee[i].daylyRate == "" || v.daylyFee[i].daylyGLRate == ""){
				r.status = true;
				if(-1==r.message.indexOf('请同时配置日利率和日管理费率')){
					r.message +='请同时配置日利率和日管理费率<br/>';
				}
				break;
			} else {
				if(!xiaoshu.test(v.daylyFee[i].daylyRate)){
					r.status = true;
					if(-1==r.message.indexOf('日利率填写数字(允许两位小数)')){
						r.message +='日利率填写数字(允许两位小数)<br/>';
					}
				}
				if(!xiaoshu.test(v.daylyFee[i].daylyGLRate)){
					r.status = true;
					if(-1==r.message.indexOf('日管理费率填写数字(允许两位小数)')){
						r.message +='日管理费率填写数字(允许两位小数)<br/>';
					}
					
				}
			}
		}
	}
	
	
	if(v.wyFee.length==0){
		r.status = true;
		if(-1==r.message.indexOf('请增加违约金率配置')){
			r.message += '请增加违约金率配置<br/>';
		}
		
	}else{
		for(var i=0;i<v.wyFee.length;i++){
			if(!xiaoshu.test(v.wyFee[i].wylStart)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额从(元)填写数字(允许两位小数)')){
				r.message +='借款金额从(元)填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.wyFee[i].wylEnd)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额到(元)填写数字(允许两位小数)')){
				r.message +='借款金额到(元)填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.wyFee[i].wylFee)){
				r.status = true;
				if(-1==r.message.indexOf('违约金率填写数字(允许两位小数)')){
				r.message +='违约金率填写数字(允许两位小数)<br/>';
				}
			}
		}
	}
	
	if(v.znFee.length==0){
		r.status = true;
		if(-1==r.message.indexOf('请增加滞纳金配置')){
		r.message +='请增加滞纳金配置<br/>';
		}
	}else{
		if(v.znjCalType == "1"){
			for(var i=0;i<v.znFee.length;i++){
				if(!xiaoshu.test(v.znFee[i].znlStart)){
					r.status = true;
					if(-1==r.message.indexOf('借款金额从(元)填写数字(允许两位小数)')){
					r.message +='借款金额从(元)填写数字(允许两位小数)<br/>';
					}
				}
				if(!xiaoshu.test(v.znFee[i].znlEnd)){
					r.status = true;
					if(-1==r.message.indexOf('借款金额到(元)填写数字(允许两位小数)')){
					r.message +='借款金额到(元)填写数字(允许两位小数)<br/>';
					}
				}
				if(!xiaoshu.test(v.znFee[i].znlFee)){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率填写数字(允许两位小数)')){
					r.message +='滞纳金率填写数字(允许两位小数)<br/>';
					}
				}
			}
		} else if (v.znjCalType == "2") {
			for(var i=0;i<v.znFee.length;i++){
				if(!xiaoshu.test(v.znFee[i].znlRate)){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率填写数字(允许两位小数)')){
					r.message +='滞纳金率填写数字(允许两位小数)<br/>';
					}
				}
			}
		}
	}
	
	if(v.bzjType =="1" && v.bzjFee.length == 0){
		r.status = true;
		if(-1==r.message.indexOf('请增加保证金配置')){
		r.message +='请增加保证金配置<br/>';
		}
	}else if(v.bzjType =="1" && v.bzjFee.length > 0){
		for(var i=0;i<v.bzjFee.length;i++){
			if(!xiaoshu.test(v.bzjFee[i].bzjStart)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额从(元)填写数字(允许两位小数)')){
				r.message +='借款金额从(元)填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.bzjFee[i].bzjEnd)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额到(元)填写数字(允许两位小数)')){
				r.message +='借款金额到(元)填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.bzjFee[i].bzjFee)){
				r.status = true;
				if(-1==r.message.indexOf('保证金率填写数字(允许两位小数)')){
				r.message +='保证金率填写数字(允许两位小数)<br/>';
				}
			}
		}
	}
	
	if(v.otherType == "1" && v.otherFee.length == 0){
		r.status = true;
		if(-1==r.message.indexOf('请增加其他费用配置')){
		r.message +='请增加其他费用配置<br/>';
		}
	}else if (v.otherType == "1" && v.otherFee.length > 0){
		for(var i=0;i<v.otherFee.length;i++){
			if(!xiaoshu.test(v.otherFee[i].otherStart)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额从(元)填写数字(允许两位小数)')){
				r.message +='借款金额从(元)填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.otherFee[i].otherEnd)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额到(元)填写数字(允许两位小数)')){
				r.message +='借款金额到(元)填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.otherFee[i].otherFee)){
				r.status = true;
				if(-1==r.message.indexOf('其他费用填写数字(允许两位小数)')){
				r.message +='其他费用填写数字(允许两位小数)<br/>';
				}
			}
		}
	}
	
	if(v.gpsType == "1"){
		if(v.gpsFirstFee == ""){
			r.status = true;
			if(-1==r.message.indexOf('请增加GPS初次安装费配置')){
			r.message +='请增加GPS初次安装费配置<br/>';
			}
		} else if(!xiaoshu.test(v.gpsFirstFee)){
			r.status = true;
			if(-1==r.message.indexOf('GPS初次安装费填写数字(允许两位小数)')){
			r.message +='GPS初次安装费填写数字(允许两位小数)<br/>';
			}
		}
		if(v.gpsFee == ""){
			r.status = true;
			if(-1==r.message.indexOf('请增加GPS安装费用配置')){
			r.message +='请增加GPS安装费用配置<br/>';
			}
		} else if(!xiaoshu.test(v.gpsFee)){
			r.status = true;
			if(-1==r.message.indexOf('GPS安装费填写数字(允许两位小数)')){
			r.message +='GPS安装费填写数字(允许两位小数)<br/>';
			}
		}
		if(v.gpsServiceFee == ""){
			r.status = true;
			if(-1==r.message.indexOf('请增加GPS服务费配置')){
			r.message +='请增加GPS服务费配置<br/>';
			}
		} else if(!xiaoshu.test(v.gpsServiceFee)){
			r.status = true;
			if(-1==r.message.indexOf('GPS服务费填写数字(允许两位小数)')){
			r.message +='GPS服务费填写数字(允许两位小数)<br/>';
			}
		}
	}
	
	
	if(!r.status){
		var d ={};
		if(v.bzjType =="1" ){
			var bzjFee = v.bzjFee;
			for(var i =0;i<bzjFee.length;i++ ){
				var start = parseInt(bzjFee[i].bzjStart);
				var end =  parseInt(bzjFee[i].bzjEnd);
				if(start > end){
					r.status = true;
					if(-1==r.message.indexOf('保证金配置借款金额到(元)不能大于借款金额从(元)')){
					r.message +='保证金配置借款金额到(元)不能大于借款金额从(元)<br/>';
					}
				}
				for(var j=start;j<=end;j++){
					if(!d[j]){
						d[j]=true;
					}else{
						r.status = true;
						if(-1==r.message.indexOf('保证金配置借款金额有重复')){
						r.message +='保证金配置借款金额有重复<br/>';
						}
						break;
					}
					
				}
				if(r.status){
					break;
				}
			}
		}
		
		var wyFee = v.wyFee;
		d ={};
		for(var i =0;i<wyFee.length;i++ ){
			var start = parseInt(wyFee[i].wylStart);
			var end =  parseInt(wyFee[i].wylEnd);
			if(start > end){
				r.status = true;
				if(-1==r.message.indexOf('违约金率配置借款金额到(元)不能大于借款金额从(元)')){
				r.message +='违约金率配置借款金额到(元)不能大于借款金额从(元)<br/>';
				}
			}
			for(var j=start;j<=end;j++){
				if(!d[j]){
					d[j]=true;
				}else{
					r.status = true;
					if(-1==r.message.indexOf('违约金率配置借款金额有重复')){
					r.message +='违约金率配置借款金额有重复<br/>';
					}
					break;
				}
				
			}
			if(r.status){
				break;
			}
		}
		
		var znFee = v.znFee;
		d ={};
		for(var i =0;i<znFee.length;i++ ){
			var start = parseInt(znFee[i].znlStart);
			var end =  parseInt(znFee[i].znlEnd);
			if(start > end){
				r.status = true;
				if(-1==r.message.indexOf('滞纳金率配置借款金额到(元)不能大于借款金额从(元)')){
				r.message +='滞纳金率配置借款金额到(元)不能大于借款金额从(元)<br/>';
				}
			}
			for(var j=start;j<=end;j++){
				if(!d[j]){
					d[j]=true;
				}else{
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率配置借款金额有重复')){
					r.message +='滞纳金率配置借款金额有重复<br/>';
					}
					break;
				}
				
			}
			if(r.status){
				break;
			}
		}
		//判断日利率期限是否有重叠
		if(v.otherType =="1" ){
			var otherFee = v.otherFee;
			d ={};
			for(var i =0;i<otherFee.length;i++ ){
				var start = parseInt(otherFee[i].otherStart);
				var end =  parseInt(otherFee[i].otherEnd);
				if(start > end){
					r.status = true;
					if(-1==r.message.indexOf('其他费用配置借款金额到(元)不能大于借款金额从(元)')){
					r.message +='其他费用配置借款金额到(元)不能大于借款金额从(元)<br/>';
					}
				}
				for(var j=start;j<=end;j++){
					if(!d[j]){
						d[j]=true;
					}else{
						r.status = true;
						if(-1==r.message.indexOf('其他费用配置借款金额有重复')){
						r.message +='其他费用配置借款金额有重复<br/>';
						}
						break;
					}
					
				}
				if(r.status){
					break;
				}
			}
		}
	}
	return r;
}
