function removeRow(obj){
	$(obj).parent().parent().remove();
}
var $body;
$(function(){
	$body = $("#cfyd-body");
	bodyflushBind();
	return;
	
});

function packageValue(){
	var result={};
	//一次性还款
	 
	if($body.find("#lumpSumRepayment").is(":checked")){
		result.lumpSumRepayment = 1;
	}else{
		result.lumpSumRepayment = 2;
	}
	// 一次性还款期限
	var lumpTermCheck=$body.find('input[name="feeConfig.lumpSumTerm"]:checked');
	result.lumpSumTerms=[];
	lumpTermCheck.each(function(){
		result.lumpSumTerms.push({
			'term':$(this).val(),
			'termName':$(this).parent().text().trim()
		});
	});
	
	//支持的还款方式
	var repaymentTypeCheck=$body.find('input[name="feeConfig.repaymentType"]:checked');
	result.repaymentTypes=[];
	repaymentTypeCheck.each(function(){
		result.repaymentTypes.push({
			'repaymentType' : $(this).val(),
			'repaymentTypeName' : $(this).parent().text().trim()
		});
	});
	// 借款期限
	var termCheck=$body.find('input[name="feeConfig.term"]:checked');
	result.terms=[];
	termCheck.each(function(){
		result.terms.push({
			'term':$(this).val(),
			'termName':$(this).parent().text().trim()
		});
	});
	//第一期本息扣除方式
	result.firstIssueType = $body.find('input[name="feeConfig.firstIssueType"]:checked').val(); 
	//借款人实收金额
	result.loanType = $body.find('input[name="feeConfig.loanType"]:checked').val(); 
	
	var autoTypeCheck=$body.find('input[name="feeConfig.autoType"]:checked');
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
	var monthlyFeeCheck=$body.find('#fee_month_add_table tr');
	monthlyFeeCheck.each(function(){
		result.monthlyFee.push({
			'termText':$.trim($(this).children().eq(0).text()),
			'monthlyRate':$.trim($(this).children().eq(1).find("input").val()),
			'monthlyGLRate':$.trim($(this).children().eq(2).find("input").val())
		});
	});
	
	//日利率设置
	result.daylyFee=[];
	var daylyFeeCheck=$body.find('#fee_day_add_table tr');
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
	var wylFeeCheck=$body.find('#wyl_fee_add_table tr');
	result.wyFee=[];
	wylFeeCheck.each(function(){
		result.wyFee.push({
			"wylStart" : $.trim($(this).children().eq(0).text()),
			"wylEnd" : $.trim($(this).children().eq(1).text()),
			"wylFee" : $.trim($(this).children().eq(2).text())
		});
	});
	
	
	result.znjCalType = $body.find('input[name="feeConfig.znjCalType"]:checked').val();
	if(result.znjCalType == "1"){
		var znlFeeCheck=$body.find('#znjl_fee_add_table tr');
		result.znFee=[];
		znlFeeCheck.each(function(){
			result.znFee.push({
				"znlStart" : $.trim($(this).children().eq(0).text()),
				"znlEnd" : $.trim($(this).children().eq(1).text()),
				"znlFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}else if(result.znjCalType == "2"){
		var znlFeeCheck=$body.find('#znjl_fee_add_term_table tr');
		result.znFee=[];
		znlFeeCheck.each(function(){
			result.znFee.push({
				"termText" : $.trim($(this).children().eq(0).text()),
				"znlRate" : $.trim($(this).children().eq(1).find("input").val())
			});
		});
	}
	
	result.bzjType = $body.find('input[name="feeConfig.bzjType"]:checked').val();
	if(result.bzjType == "1"){
		var bzlFeeCheck=$body.find('#bzjl_fee_add_table tr');
		result.bzjFee=[];
		bzlFeeCheck.each(function(){
			result.bzjFee.push({
				"bzjStart" : $.trim($(this).children().eq(0).text()),
				"bzjEnd" : $.trim($(this).children().eq(1).text()),
				"bzjFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}
	
	result.otherType = $body.find('input[name="feeConfig.otherType"]:checked').val();
	if(result.otherType == "1"){
		var otherFeeCheck=$body.find('#other_fee_add_table tr');
		result.otherFee=[];
		otherFeeCheck.each(function(){
			result.otherFee.push({
				"otherStart" : $.trim($(this).children().eq(0).text()),
				"otherEnd" : $.trim($(this).children().eq(1).text()),
				"otherFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}

	result.gpsType = $body.find('input[name="feeConfig.gpsType"]:checked').val();
	if(result.gpsType == "1"){
		result.gpsFirstFee = $body.find('input[name="feeConfig.gpsFirstFee"]').val();
		result.gpsFee = $body.find('input[name="feeConfig.gpsFee"]').val();
		result.gpsServiceFee = $body.find('input[name="feeConfig.gpsServiceFee"]').val();
	}
	
	return result;
}
/*function setValue(feeConfig){
	debugger
	for(var i=0;i<feeConfig.repaymentTypes.length;i++){
		var tmp =feeConfig.repaymentTypes[i];
		$body.find('input[name="feeConfig.repaymentType"][value="'+tmp.repaymentType+'"]').prop('checked',true);
		$body.find("#startPays").append('<label class="label-box-item"> <input type="checkbox"	name="feeConfig.startPay" value="'+tmp.repaymentType+'" />'+tmp.repaymentTypeName+'	</label> ');
		$body.find("#endPays").append('<label class="label-box-item"> <input type="checkbox"	name="feeConfig.endPay" value="'+tmp.repaymentType+'" />'+tmp.repaymentTypeName+'	</label> ');
		for(var j=0;j<tmp.supportFirstPay.length;j++){
			var tmpsu = tmp.supportFirstPay[j];
			if(tmpsu.payType=='1'){
				$body.find("#startPays").find('input[name="feeConfig.startPay"][value="'+tmp.repaymentType+'"]').prop('checked',true);
			}else if(tmpsu.payType=='2'){
				$body.find("#endPays").find('input[name="feeConfig.endPay"][value="'+tmp.repaymentType+'"]').prop('checked',true);
			}
		}
	}
	for(var i=0;i<feeConfig.eachTimes.length;i++){
		$body.find('input[name="feeConfig.eachtimes"][value="'+feeConfig.eachTimes[i].eachTime+'"]').prop('checked',true);
	}
	$body.find('input[name="feeConfig.feeCaType"][value="'+feeConfig.feeCaType+'"]').trigger('click');
	$body.find('input[name="feeConfig.znjFeeCal"][value="'+feeConfig.znjFeeCal+'"]').prop('checked',true);
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
		$body.find("#fee_month_add_table").append('<tr>'+
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
		$body.find("#fee_day_add_table").append('<tr>'+
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
			$body.find("#fee_z_month_add_table").append('<tr>'+
					'<td> <input type="hidden" name="deptId" value="'+tmp.deptId+'"/> '+tmp.deptName+'</td>'+
					'<td>'+tmp.rate+'</td>'+
					'<td>'+
					'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
					'</td>'+
					'</tr>');
		}
		
		for(var i =0;i<feeConfig.daylyZHFee.length;i++){
			var tmp = feeConfig.daylyZHFee[i];
			$body.find("#fee_z_day_add_table").append('<tr>'+
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
			$body.find("#fee_g_month_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
		}
		for(var i =0;i<feeConfig.daylyGLFee.length;i++){
			var tmp = feeConfig.daylyGLFee[i];
			$body.find("#fee_g_day_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a " onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
		}
	}
	for(var i =0;i<feeConfig.gpsFee.length;i++){
		var tmp = feeConfig.gpsFee[i];
		$body.find("#gps_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"></i><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.gpsSerFee.length;i++){
		var tmp = feeConfig.gpsSerFee[i];
		$body.find("#gpsser_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.wyFee.length;i++){
		var tmp = feeConfig.wyFee[i];
		$body.find("#wyl_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
				'<div class=" btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.bzjFee.length;i++){
		var tmp = feeConfig.bzjFee[i];
		$body.find("#bzjl_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
			'<div class=" btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	for(var i =0;i<feeConfig.znjFee.length;i++){
		var tmp = feeConfig.znjFee[i];
		$body.find("#znjl_fee_add_table").append('<tr>'+
				'<td>'+tmp+'</td>'+
				'<td>'+
			'<div class=" btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
				'</td>'+
				'</tr>');
	}
	$body.find('input[name="feeConfig.monthlyFeeCal"][value="'+feeConfig.monthlyFeeCal+'"]').trigger('click');
}*/


function validateValue(v){
	var xiaoshu  = /^\d+(\.\d{1,2})?$/;
	var xiaoshusanwei  = /^\d+(\.\d{1,3})?$/;
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
	if($body.find("#productName").val().trim()==""){
		r.status = true;
		r.message +='请输入产品名称<br/>';
	}else if(!productName_pattern.test($body.find("#productName").val().trim())){
		r.status = true;
		r.message +='产品名称请输入2-20个字，只支持中文或英文<br/>';	
	}
	if($body.find("#productCode").val()==""){
		r.status = true;
		r.message +='请输入产品代码<br/>';
	} else if(!/^[A-Za-z]+$/.test($body.find("#productCode").val())){
		r.status = true;
		r.message +='产品代码请输入英文字母，不可输入数字、符号<br/>';
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
		if(v.monthlyFee[i].start == "" || v.monthlyFee[i].end == ""){
			r.status = true;
			if(-1==r.message.indexOf('请增加月利率')){
				r.message +='请增加月利率<br/>';
			}
			break;
		} else {
			if(!xiaoshu.test(v.monthlyFee[i].start)){
				r.status = true;
				if(-1==r.message.indexOf('月利率填写数字(允许两位小数)')){
					r.message +='月利率填写数字(允许两位小数)<br/>';
				}
			}
			if(!xiaoshu.test(v.monthlyFee[i].end)){
				r.status = true;
				if(-1==r.message.indexOf('月利率填写数字(允许两位小数)')){
					r.message +='月利率填写数字(允许两位小数)<br/>';
				}
			}
			
			if(xiaoshu.test(v.monthlyFee[i].start) && xiaoshu.test(v.monthlyFee[i].end)
					&& (parseFloat(v.monthlyFee[i].start)>parseFloat(v.monthlyFee[i].end))){
				r.status = true;
				if(-1==r.message.indexOf('月利率百分比数字从不能大于月利率百分比数字到')){
					r.message +='月利率百分比数字从不能大于月利率百分比数字到<br/>';
				}
			}
			
			if((xiaoshu.test(v.monthlyFee[i].start) && parseFloat(v.monthlyFee[i].start)>100) ||
			(xiaoshu.test(v.monthlyFee[i].end) &&  parseFloat(v.monthlyFee[i].end)>100)){
				r.status = true;
				if(-1==r.message.indexOf('月利率只支持100以下的数字')){
					r.message +='月利率只支持100以下的数字<br/>';
				}
			}
		}
	}
	if(v.daylyFee.length!=0  && v.daylyFee.length!=v.monthlyFee.length){
		r.status = true;
		if(-1==r.message.indexOf('请完整配置日利率')){
			r.message +='请完整配置日利率<br/>';
		}
	}
	
	if(v.daylyFee.length==v.monthlyFee.length){
		for(var i=0;i<v.daylyFee.length;i++){
			if(v.daylyFee[i].start == "" || v.daylyFee[i].end == ""){
				r.status = true;
				if(-1==r.message.indexOf('请配置日利率')){
					r.message +='请配置日利率<br/>';
				}
				break;
			} else {
				if(!xiaoshusanwei.test(v.daylyFee[i].start)){
					r.status = true;
					if(-1==r.message.indexOf('日利率填写数字(允许三位小数)')){
						r.message +='日利率填写数字(允许三位小数)<br/>';
					}
				}
				if(!xiaoshusanwei.test(v.daylyFee[i].end)){
					r.status = true;
					if(-1==r.message.indexOf('日利率填写数字(允许三位小数)')){
						r.message +='日利率填写数字(允许三位小数)<br/>';
					}
					
				}
				
				if(xiaoshusanwei.test(v.daylyFee[i].start) && xiaoshusanwei.test(v.daylyFee[i].end)
						&& (parseFloat(v.daylyFee[i].start)>parseFloat(v.daylyFee[i].end))){
					r.status = true;
					if(-1==r.message.indexOf('日利率百分比数字从不能大于日利率百分比数字到')){
						r.message +='日利率百分比数字从不能大于日利率百分比数字到<br/>';
					}
				}
				
				if((xiaoshusanwei.test(v.daylyFee[i].start) && parseFloat(v.daylyFee[i].start)>100) ||
						(xiaoshusanwei.test(v.daylyFee[i].end) &&  parseFloat(v.daylyFee[i].end)>100)){
							r.status = true;
							if(-1==r.message.indexOf('日利率只支持100以下的数字')){
								r.message +='日利率只支持100以下的数字<br/>';
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
			if(!zhengshu.test(v.wyFee[i].wylStart)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额从(元)请填写整数')){
				r.message +='借款金额从(元)请填写整数<br/>';
				}
			}
			if(!zhengshu.test(v.wyFee[i].wylEnd)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额到(元)请填写整数')){
				r.message +='借款金额到(元)请填写整数<br/>';
				}
			}
			
			if(zhengshu.test(v.wyFee[i].wylStart) && zhengshu.test(v.wyFee[i].wylEnd) && 
					parseInt(v.wyFee[i].wylStart)>parseInt(v.wyFee[i].wylEnd)){
				r.status = true;
				if(-1==r.message.indexOf('违约金率从(元)不能大于违约金率到(元)')){
				r.message +='违约金率从(元)不能大于违约金率到(元)<br/>';
				}
			}
			
			
			
			if(!xiaoshu.test(v.wyFee[i].wylFee)){
				r.status = true;
				if(-1==r.message.indexOf('违约金率填写数字(允许两位小数)')){
				r.message +='违约金率填写数字(允许两位小数)<br/>';
				}
			}
			
			if(xiaoshu.test(v.wyFee[i].wylFee) && v.wyFee[i].wylFee>100){
				r.status = true;
				if(-1==r.message.indexOf('违约金率只支持100以下的数字')){
				r.message +='违约金率只支持100以下的数字<br/>';
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
				if(!zhengshu.test(v.znFee[i].znlStart)){
					r.status = true;
					if(-1==r.message.indexOf('借款金额从(元)请填写整数')){
					r.message +='借款金额从(元)请填写整数<br/>';
					}
				}
				if(!zhengshu.test(v.znFee[i].znlEnd)){
					r.status = true;
					if(-1==r.message.indexOf('借款金额到(元)请填写整数')){
					r.message +='借款金额到(元)请填写整数<br/>';
					}
				}
				
				if(zhengshu.test(v.znFee[i].znlStart) && zhengshu.test(v.znFee[i].znlEnd) && 
						parseInt(v.znFee[i].znlStart)>parseInt(v.znFee[i].znlEnd)){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率从(元)不能大于滞纳金率到(元)')){
					r.message +='滞纳金率从(元)不能大于滞纳金率到(元)<br/>';
					}
				}
				
				
				if(!xiaoshu.test(v.znFee[i].znlFee)){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率填写数字(允许两位小数)')){
					r.message +='滞纳金率填写数字(允许两位小数)<br/>';
					}
				}
				
				if(xiaoshu.test(v.znFee[i].znlFee) && v.znFee[i].znlFee>100){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率只支持100以下的数字')){
					r.message +='滞纳金率只支持100以下的数字<br/>';
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
				
				if(xiaoshu.test(v.znFee[i].znlRate) && v.znFee[i].znlRate>=10000){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率只支持10000以下的数字')){
					r.message +='滞纳金率只支持10000以下的数字<br/>';
					}
				}
			}
		}
	}
	
	if(v.bzjType =="1" && v.bzjFee.length > 0){
		for(var i=0;i<v.bzjFee.length;i++){
			if(!zhengshu.test(v.bzjFee[i].bzjStart)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额从(元)请填写整数')){
				r.message +='借款金额从(元)请填写整数<br/>';
				}
			}
			if(!zhengshu.test(v.bzjFee[i].bzjEnd)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额到(元)请填写整数')){
				r.message +='借款金额到(元)请填写整数<br/>';
				}
			}
			
			if(zhengshu.test(v.bzjFee[i].bzjStart) && zhengshu.test(v.bzjFee[i].bzjEnd) && 
					parseInt(v.bzjFee[i].bzjStart)>parseInt(v.bzjFee[i].bzjEnd)){
				r.status = true;
				if(-1==r.message.indexOf('保证金率从(元)不能大于保证金率到(元)')){
				r.message +='保证金率从(元)不能大于保证金率到(元)<br/>';
				}
			}
			
			
			if(!xiaoshu.test(v.bzjFee[i].bzjFee)){
				r.status = true;
				if(-1==r.message.indexOf('保证金率填写数字(允许两位小数)')){
				r.message +='保证金率填写数字(允许两位小数)<br/>';
				}
			}
			
			if(xiaoshu.test(v.bzjFee[i].bzjFee) && v.bzjFee[i].bzjFee>100){
				r.status = true;
				if(-1==r.message.indexOf('保证金率只支持100以下的数字')){
				r.message +='保证金率只支持100以下的数字<br/>';
				}
			}
		}
	}
	
	//咨询费
	if(v.zxfType == "2" || (v.zxfType == "1" && v.zxfee.length == 0)){
		r.status = true;
		if(-1==r.message.indexOf('请增加咨询费配置')){
		r.message +='请增加咨询费配置<br/>';
		}
	}
		
		
	if(v.zxfType =="1" && (!xiaoshu.test(v.zxfee.start))){
		r.status = true;
		if(-1==r.message.indexOf('咨询费填写数字(允许两位小数)')){
		r.message +='咨询费填写数字(允许两位小数)<br/>';
		}
	}
	
	if(v.zxfType =="1" && (!xiaoshu.test(v.zxfee.end))){
		r.status = true;
		if(-1==r.message.indexOf('咨询费填写数字(允许两位小数)')){
		r.message +='咨询费填写数字(允许两位小数)<br/>';
		}
	}
	
	if((v.zxfType =="1" && xiaoshu.test(v.zxfee.start) && v.zxfee.start>100) || 
			(v.zxfType =="1" && xiaoshu.test(v.zxfee.end) && v.zxfee.end>100)){
		r.status = true;
		if(-1==r.message.indexOf('咨询费只支持100以下的数字')){
		r.message +='咨询费只支持100以下的数字<br/>';
		}
	}
	
	
	//停车费
	if(v.parkType =="1" && (!zhengshu.test(v.parkFee.start))){
		r.status = true;
		if(-1==r.message.indexOf('停车费请填写整数')){
		r.message +='停车费请填写整数<br/>';
		}
	}
	
	if(v.parkType =="1" && (!zhengshu.test(v.parkFee.end))){
		r.status = true;
		if(-1==r.message.indexOf('停车费请填写整数')){
		r.message +='停车费请填写整数<br/>';
		}
	}
	
	if((v.parkType =="1" && zhengshu.test(v.parkFee.start) && v.parkFee.start>=10000) || 
			(v.parkType =="1" && zhengshu.test(v.parkFee.end) && v.parkFee.end>=10000)){
		r.status = true;
		if(-1==r.message.indexOf('停车费只支持10000以下的数字')){
		r.message +='停车费只支持10000以下的数字<br/>';
		}
	}
	
	
	
		if (v.otherType == "1" && v.otherFee.length > 0){
		for(var i=0;i<v.otherFee.length;i++){
			if(!zhengshu.test(v.otherFee[i].otherStart)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额从请填写整数')){
				r.message +='借款金额从请填写整数<br/>';
				}
			}
			if(!zhengshu.test(v.otherFee[i].otherEnd)){
				r.status = true;
				if(-1==r.message.indexOf('借款金额到(元)填写数字(允许两位小数)')){
				r.message +='借款金额到(元)填写数字(允许两位小数)<br/>';
				}
			}
			
			if(zhengshu.test(v.otherFee[i].otherStart) && zhengshu.test(v.otherFee[i].otherEnd) && 
					parseInt(v.otherFee[i].otherStart)>parseInt(v.otherFee[i].otherEnd)){
				r.status = true;
				if(-1==r.message.indexOf('其他费用从(元)不能大于其他费用到(元)')){
				r.message +='其他费用从(元)不能大于其他费用到(元)<br/>';
				}
			}
			
			
			if(!xiaoshu.test(v.otherFee[i].otherFee)){
				r.status = true;
				if(-1==r.message.indexOf('其他费用填写数字(允许两位小数)')){
				r.message +='其他费用填写数字(允许两位小数)<br/>';
				}
			}
			
			if(xiaoshu.test(v.otherFee[i].otherFee) && v.otherFee[i].otherFee>=10000){
				r.status = true;
				if(-1==r.message.indexOf('其他费用只支持10000以下的数字')){
				r.message +='其他费用只支持10000以下的数字<br/>';
				}
			}
		}
	}else if(v.otherType == "1" && v.otherFee.length <= 0){
		r.status = true;
		if(-1==r.message.indexOf('请添加其他费用配置或勾选否')){
		r.message +='请添加其他费用配置或勾选否<br/>';
		
		}
	}
		
		
	
	if(v.gpsType == "1"){
		
		if(!zhengshu.test(v.gpsFirstFee.start)){
			r.status = true;
			if(-1==r.message.indexOf('GPS安装费配置请填写整数')){
			r.message +='GPS安装费配置请填写整数<br/>';
			}
		}
		
		if(!zhengshu.test(v.gpsFirstFee.end)){
			r.status = true;
			if(-1==r.message.indexOf('GPS安装费配置请填写整数')){
			r.message +='GPS安装费配置请填写整数<br/>';
			}
		}
		
		if((zhengshu.test(v.gpsFirstFee.start) && v.gpsFirstFee.start>=10000) ||
				(zhengshu.test(v.gpsFirstFee.end) && v.gpsFirstFee.end>=10000)){
			r.status = true;
			if(-1==r.message.indexOf('GPS安装费只支持10000以下的数字')){
			r.message +='GPS安装费只支持10000以下的数字<br/>';
			}
		}
		
		
		if(!zhengshu.test(v.gpsServiceFee.start)){
			r.status = true;
			if(-1==r.message.indexOf('GPS服务费配置请填写整数')){
			r.message +='GPS服务费配置请填写整数<br/>';
			}
		}
		
		if(!zhengshu.test(v.gpsServiceFee.end)){
			r.status = true;
			if(-1==r.message.indexOf('GPS服务费配置请填写整数')){
			r.message +='GPS服务费配置请填写整数<br/>';
			}
		}
		
		if((zhengshu.test(v.gpsServiceFee.start) && v.gpsServiceFee.start>=10000) ||
				(zhengshu.test(v.gpsServiceFee.end) && v.gpsServiceFee.end>=10000)){
			r.status = true;
			if(-1==r.message.indexOf('GPS服务费只支持10000以下的数字')){
			r.message +='GPS服务费只支持10000以下的数字<br/>';
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
				var fee = bzjFee[i].bzjFee;
				if(start > end){
					r.status = true;
					if(-1==r.message.indexOf('保证金配置借款金额从(元)不能大于借款金额到(元)')){
					r.message +='保证金配置借款金额从(元)不能大于借款金额到(元)<br/>';
					}
				}
				
				for(j=0;j<bzjFee.length;j++){
					if(i==j){
						continue;
					}
					var start2 = parseInt(bzjFee[j].bzjStart);
					var end2 =  parseInt(bzjFee[j].bzjEnd);
					var fee2 = bzjFee[i].bzjFee;
					if(start==start2 && end==end2 && fee==fee2){
						r.status = true;
						if(-1==r.message.indexOf('保证金配置有重复')){
							r.message +='保证金配置有重复<br/>';
							}
						break;
					}
					
					
				}
				/*for(var j=start;j<=end;j++){
					if(!d[j]){
						d[j]=true;
					}else{
						r.status = true;
						if(-1==r.message.indexOf('保证金配置借款金额有重复')){
						r.message +='保证金配置借款金额有重复<br/>';
						}
						break;
					}
					
				}*/
				
				
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
			var fee = parseFloat(wyFee[i].wylFee);
			if(start > end){
				r.status = true;
				if(-1==r.message.indexOf('违约金率配置借款金额到(元)不能大于借款金额从(元)')){
				r.message +='违约金率配置借款金额到(元)不能大于借款金额从(元)<br/>';
				}
			}
			for(j=0;j<wyFee.length;j++){
				if(i==j){
					continue;
				}
				var start2 = parseInt(wyFee[j].wylStart);
				var end2 =  parseInt(wyFee[j].wylEnd);
				var fee2 = parseFloat(wyFee[j].wylFee);
				if(start==start2 && end==end2 && fee==fee2){
					r.status = true;
					if(-1==r.message.indexOf('违约金率配置有重复')){
						r.message +='违约金率配置有重复<br/>';
						}
					break;
				}
				
				
			}
			
			/*for(var j=start;j<=end;j++){
				if(!d[j]){
					d[j]=true;
				}else{
					r.status = true;
					if(-1==r.message.indexOf('违约金率配置借款金额有重复')){
					r.message +='违约金率配置借款金额有重复<br/>';
					}
					break;
				}
				
			}*/
			if(r.status){
				break;
			}
		}
		
		var znFee = v.znFee;
		d ={};
		for(var i =0;i<znFee.length;i++ ){
			var start = parseInt(znFee[i].znlStart);
			var end =  parseInt(znFee[i].znlEnd);
			var fee = parseFloat(znFee[i].znlFee);
			if(start > end){
				r.status = true;
				if(-1==r.message.indexOf('滞纳金率配置借款金额到(元)不能大于借款金额从(元)')){
				r.message +='滞纳金率配置借款金额到(元)不能大于借款金额从(元)<br/>';
				}
			}
			
			for(j=0;j<znFee.length;j++){
				if(i==j){
					continue;
				}
				var start2 = parseInt(znFee[j].znlStart);
				var end2 =  parseInt(znFee[j].znlEnd);
				var fee2 = parseFloat(znFee[j].znlFee);
				if(start==start2 && end==end2 && fee==fee2){
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率配置有重复')){
						r.message +='滞纳金率配置有重复<br/>';
						}
					break;
				}
				
				
			}
			
			
			/*for(var j=start;j<=end;j++){
				if(!d[j]){
					d[j]=true;
				}else{
					r.status = true;
					if(-1==r.message.indexOf('滞纳金率配置借款金额有重复')){
					r.message +='滞纳金率配置借款金额有重复<br/>';
					}
					break;
				}
				
			}*/
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
				var fee = parseFloat(otherFee[i].otherFee);
				if(start > end){
					r.status = true;
					if(-1==r.message.indexOf('其他费用配置借款金额到(元)不能大于借款金额从(元)')){
					r.message +='其他费用配置借款金额到(元)不能大于借款金额从(元)<br/>';
					}
				}
				
				for(j=0;j<otherFee.length;j++){
					if(i==j){
						continue;
					}
					var start2 = parseInt(otherFee[j].otherStart);
					var end2 =  parseInt(otherFee[j].otherEnd);
					var fee2 = parseFloat(otherFee[j].otherFee);
					if(start==start2 && end==end2 && fee==fee2){
						r.status = true;
						if(-1==r.message.indexOf('其他费用配置有重复')){
							r.message +='其他费用配置有重复<br/>';
							}
						break;
					}
					
					
				}
				
				
				/*for(var j=start;j<=end;j++){
					if(!d[j]){
						d[j]=true;
					}else{
						r.status = true;
						if(-1==r.message.indexOf('其他费用配置借款金额有重复')){
						r.message +='其他费用配置借款金额有重复<br/>';
						}
						break;
					}
					
				}*/
				if(r.status){
					break;
				}
			}
		}
	}
	
	if(v.zxfType!=2){
		var start = parseFloat(v.zxfee.start);
		var end = parseFloat(v.zxfee.end);
		if(start > end){
			r.status = true;
			if(-1==r.message.indexOf('咨询费配置百分比到不能大于百分比从')){
			r.message +='咨询费配置百分比到不能大于百分比从<br/>';
			}
		}
		
	}
	
	if(v.parkType!=2){
		var start = parseInt(v.parkFee.start);
		var end = parseInt(v.parkFee.end);
		if(start > end){
			r.status = true;
			if(-1==r.message.indexOf('停车费配置按月支付到不能大于按月支付从')){
			r.message +='停车费配置按月支付到不能大于按月支付从<br/>';
			}
		}
		
	}
	
	if(v.gpsType!=2){
		var first_start = parseInt(v.gpsFirstFee.start);
		var first_end = parseInt(v.gpsFirstFee.end);
		if(first_start > first_end){
			r.status = true;
			if(-1==r.message.indexOf('GPS安装费配置初次安装到(元)不能大于初次安装从(元)')){
			r.message +='GPS安装费配置初次安装到(元)不能大于初次安装从(元)<br/>';
			}
		}
		
		var service_start = parseInt(v.gpsServiceFee.start);
		var service_end = parseInt(v.gpsServiceFee.end);
		if(service_start > service_end){
			r.status = true;
			if(-1==r.message.indexOf('GPS服务费配置按月支付到(元)不能大于按月支付从(元)')){
			r.message +='GPS服务费配置按月支付到(元)不能大于按月支付从(元)<br/>';
			}
		}
		
		
	}
	
	
	
	return r;
}



function bodyflushBind(){
	$body.find("#wyl_fee_add").bind('click',function(){
		$("#wylFeeModal").showModal();
		$("#wylFeeForm #wylStart").val('500');
		$("#wylFeeForm #wylEnd").val('1500');
		$("#wylFeeForm #wylFee").val('0');
	});
	

	$body.find('input[name="feeConfig.znjCalType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$body.find('#znjCalAmountType').hide();
			$body.find('#znjCalTermType').show();
			$body.find('#znjl_fee_add').hide();
			
		} else {
			$body.find('#znjCalTermType').hide();
			$body.find('#znjCalAmountType').show();
			$body.find('#znjl_fee_add').show();
		}
	});
	
	$body.find("#znjl_fee_add").bind('click',function(){
		$("#znjlFeeModal").showModal();
		$("#znjlFeeForm #znjlStart").val('500');
		$("#znjlFeeForm #znjlEnd").val('1500');
		$("#znjlFeeForm #znjlFee").val('0');
	});

	
	
	$body.find('input[name="feeConfig.bzjType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$body.find('#bzjCalType').hide();
			$body.find('#bzjl_fee_add').hide();
			
		} else {
			$body.find('#bzjCalType').show();
			$body.find('#bzjl_fee_add').show();
		}
	});
	
	$body.find("#bzjl_fee_add").bind('click',function(){
		$("#bzjlFeeModal").showModal();
		$("#bzjlFeeForm #bzjlStart").val('500');
		$("#bzjlFeeForm #bzjlEnd").val('1500');
		$("#bzjlFeeForm #bzjlFee").val('0');
	});
	
	
	$body.find('input[name="feeConfig.otherType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$body.find('#otherCalType').hide();
			$body.find('#other_fee_add').hide();
		} else {
			$body.find('#otherCalType').show();
			$body.find('#other_fee_add').show();
		}
	});
	
	$body.find("#other_fee_add").bind('click',function(){
		$("#otherFeeModal").showModal();
		$("#otherFeeForm #otherStart").val('500');
		$("#otherFeeForm #otherEnd").val('900');
		$("#otherFeeForm #otherFee").val('20');
	});
	
	
	$body.find('input[name="feeConfig.gpsType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$body.find('#gpsCalType').hide();
		} else {
			$body.find('#gpsCalType').show();
		}
	});
	
	$body.find('input[name="feeConfig.parkType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$body.find('#parkType').hide();
		} else {
			$body.find('#parkType').show();
		}
	});
	
	$body.find('input[name="feeConfig.zxfType"]').bind('click',function(){
		var t = $(this);
		if(t.val() == '2' ){
			$body.find('#zxfee').hide();
		} else {
			$body.find('#zxfee').show();
		}
	});
	
	
	$body.find('input[name="feeConfig.repaymentType"]').bind('click',function(){
		
		
		var $fmt = $body.find("#fee_month_add_table");
		var $fdt = $body.find("#fee_day_add_table");
		var $zft = $body.find("#znjl_fee_add_term_table");
		
		if($(this).is(':checked')){
			$body.find('input[name="feeConfig.lumpSumTerm"]').prop("checked",true);
			/*$fmt.append('<tr id="fmt_1-60">'+
					'<td>1-60天</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
			'</tr>');*/
			$fmt.append('<tr id="fmt_month_'+$(this).val()+'"><td><span>'+$(this).siblings('span').html()+'</span></td><td><div><div class="form-inline"><div class="form-group"><input   type="text" class="form-control"></div><span class="line-span">-</span><div class="form-group"><input   type="text" class="form-control"></div> <span class="line-span">%</span></div></td></tr>');
			$fdt.append('<tr id="fmt_day_'+$(this).val()+'"><td><span>'+$(this).siblings('span').html()+'</span></td><td><div><div class="form-inline"><div class="form-group"><input   type="text" class="form-control"></div><span class="line-span">-</span><div class="form-group"><input   type="text" class="form-control"></div><span class="line-span">%</span></div></td></tr>');
			
			
		}
		
		if(!$(this).is(':checked')){
			$fmt.find("#fmt_month_"+$(this).val()).remove();
			$fdt.find("#fmt_day_"+$(this).val()).remove();
			
		}
		
		
		
	});
	$body.find('input[name="feeConfig.term"]').bind('click',function(){
		var $zft = $body.find("#znjl_fee_add_term_table");
		var t = $(this);
		if(t.is(':checked')){
				if($zft.find("tr").size() == 0 ){
					$zft.append('<tr id="zft_'+t.val()+'">'+
							'<td>'+$(this).siblings('span').html()+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}  else {
					$zft.find("tr:last").after('<tr id="zft_'+t.val()+'">'+
							'<td>'+$(this).siblings('span').html()+'</td>'+
							'<td>'+'<input class="form-control" style="width: 100px" type="text">'+'</td>'+
					'</tr>');
				}
		} else {
			$zft.find("#zft_"+t.val()).remove();
		}
	});
	
	
	
	$body.find('input[name="feeConfig.lumpSumTerm"]').bind('click',function(){
		var $fmt = $body.find("#fee_month_add_table");
		var $fdt = $body.find("#fee_day_add_table");
		var $zft = $body.find("#znjl_fee_add_term_table");
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
	
	
	$("#addWylFeeBtn").bind('click',function(){
		$body.find("#wyl_fee_add_table").append(
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

	
	$("#addZnjlFeeBtn").bind('click',function(){
		$body.find("#znjl_fee_add_table").append('<tr>'+
		'<td>'+$("#znjlFeeForm #znjlStart").val()+'</td>'+
		'<td>'+$("#znjlFeeForm #znjlEnd").val()+'</td>'+
		'<td>'+$("#znjlFeeForm #znjlFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#znjlFeeModal").hideModal();
	});
	
	$("#addBzjlFeeBtn").bind('click',function(){
		$body.find("#bzjl_fee_add_table").append('<tr>'+
		'<td>'+$("#bzjlFeeForm #bzjlStart").val()+'</td>'+
		'<td>'+$("#bzjlFeeForm #bzjlEnd").val()+'</td>'+
		'<td>'+$("#bzjlFeeForm #bzjlFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#bzjlFeeModal").hideModal();
	});
	
	
	$("#addOtherFeeBtn").bind('click',function(){
		$body.find("#other_fee_add_table").append('<tr>'+
		'<td>'+$("#otherFeeForm #otherStart").val()+'</td>'+
		'<td>'+$("#otherFeeForm #otherEnd").val()+'</td>'+
		'<td>'+$("#otherFeeForm #otherFee").val()+'</td>'+
		'<td>'+
		'<div class="btn-a" onclick="removeRow(this)"><span>删除</span></div>'+
		'</td>'+
		'</tr>');
		$("#otherFeeModal").hideModal();
	});
	
	$("#savFeeConfigBtn").bind('click',function(){
		var obj = packValue();
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
	 			productName:$body.find("#productName").val(),
	 			productType:$("#productType").val(),
	 			productCode:$body.find("#productCode").val(),
	 			desc:$body.find("#desc").val(),
	 			feeConfig:JSON.stringify(obj)
			},
	 		success : function(data) {
	 			if(data.status==1){

	 				$.showPop("配置完成","",2000);
	 				window.setTimeout(function(){
				        var url=tools.getCurrentIFrameUrl();
				        var refreshUrl="/asset/loadAssetManager";
        				tools.closeParentTab(url,refreshUrl)
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
	
}


function packValue(){
	var result={};
	
		
	//支持的还款方式
	var repaymentTypeCheck=$body.find('input[name="feeConfig.repaymentType"]:checked');
	result.repaymentTypes=[];
	repaymentTypeCheck.each(function(){
		result.repaymentTypes.push({
			'repaymentType' : $(this).val(),
			'repaymentTypeName' : $(this).parent().text().trim()
		});
	});
	// 借款期限
	var termCheck=$body.find('input[name="feeConfig.term"]:checked');
	result.terms=[];
	termCheck.each(function(){
		result.terms.push({
			'term':$(this).val(),
			'termName':$(this).parent().text().trim()
		});
	});
	//第一期本息扣除方式
	result.firstIssueType = $body.find('input[name="feeConfig.firstIssueType"]:checked').val(); 
	//借款人实收金额
	result.loanType = $body.find('input[name="feeConfig.loanType"]:checked').val(); 
	
	var autoTypeCheck=$body.find('input[name="feeConfig.autoType"]:checked');
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
	var monthlyFeeCheck=$body.find('#fee_month_add_table tr');
	monthlyFeeCheck.each(function(){
		result.monthlyFee.push({
			'start':$.trim($(this).find("input")[0].value),
			'end':$.trim($(this).find("input")[1].value),
			'repaymentType':$.trim($(this).attr("id").substring($(this).attr("id").length-1, $(this).attr("id").length)),
			'repaymentTypeName':$.trim($(this).children().eq(0).find("span")[0].innerHTML)
		});
	});
	
	//日利率设置
	result.daylyFee=[];
	var daylyFeeCheck=$body.find('#fee_day_add_table tr');
	daylyFeeCheck.each(function(){
		if($.trim($(this).children().eq(1).find("input").val())!="" || 
				$.trim($(this).children().eq(2).find("input").val()) !=""){
			result.daylyFee.push({
				'start':$.trim($(this).find("input")[0].value),
				'end':$.trim($(this).find("input")[1].value),
				'repaymentType':$.trim($(this).attr("id").substring($(this).attr("id").length-1, $(this).attr("id").length)),
				'repaymentTypeName':$.trim($(this).children().eq(0).find("span")[0].innerHTML)
			});
		}
	});
	
	//违约率设置
	var wylFeeCheck=$body.find('#wyl_fee_add_table tr');
	result.wyFee=[];
	wylFeeCheck.each(function(){
		result.wyFee.push({
			"wylStart" : $.trim($(this).children().eq(0).text()),
			"wylEnd" : $.trim($(this).children().eq(1).text()),
			"wylFee" : $.trim($(this).children().eq(2).text())
		});
	});
	
	
	result.znjCalType = $body.find('input[name="feeConfig.znjCalType"]:checked').val();
	if(result.znjCalType == "1"){
		var znlFeeCheck=$body.find('#znjl_fee_add_table tr');
		result.znFee=[];
		znlFeeCheck.each(function(){
			result.znFee.push({
				"znlStart" : $.trim($(this).children().eq(0).text()),
				"znlEnd" : $.trim($(this).children().eq(1).text()),
				"znlFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}else if(result.znjCalType == "2"){
		var znlFeeCheck=$body.find('#znjl_fee_add_term_table tr');
		result.znFee=[];
		znlFeeCheck.each(function(){
			result.znFee.push({
				"termVal" : $.trim($(this).attr("id").replace("zft_","")),
				"termText" : $.trim($(this).children().eq(0).text()),
				"znlRate" : $.trim($(this).children().eq(1).find("input").val())
			});
		});
	}
	
	result.bzjType = $body.find('input[name="feeConfig.bzjType"]:checked').val();
	if(result.bzjType == "1"){
		var bzlFeeCheck=$body.find('#bzjl_fee_add_table tr');
		result.bzjFee=[];
		bzlFeeCheck.each(function(){
			result.bzjFee.push({
				"bzjStart" : $.trim($(this).children().eq(0).text()),
				"bzjEnd" : $.trim($(this).children().eq(1).text()),
				"bzjFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}
	
	
	//咨询费
	result.zxfType = $body.find('input[name="feeConfig.zxfType"]:checked').val();
	result.zxfee = {};
	if(result.zxfType == "1"){
		result.zxfee.start=$.trim($("#zxfee").find("input")[0].value);
		result.zxfee.end=$.trim($("#zxfee").find("input")[1].value);
		
	}
	
	result.otherType = $body.find('input[name="feeConfig.otherType"]:checked').val();
	if(result.otherType == "1"){
		var otherFeeCheck=$body.find('#other_fee_add_table tr');
		result.otherFee=[];
		otherFeeCheck.each(function(){
			result.otherFee.push({
				"otherStart" : $.trim($(this).children().eq(0).text()),
				"otherEnd" : $.trim($(this).children().eq(1).text()),
				"otherFee" : $.trim($(this).children().eq(2).text())
			});
		});
	}

	result.gpsType = $body.find('input[name="feeConfig.gpsType"]:checked').val();
	result.gpsFirstFee = {};
	result.gpsServiceFee = {};
	if(result.gpsType == "1"){
		result.gpsFirstFee.start = $body.find('input[name="feeConfig.gpsFirstFee"]')[0].value;
		result.gpsFirstFee.end = $body.find('input[name="feeConfig.gpsFirstFee"]')[1].value;
		result.gpsServiceFee.start = $body.find('input[name="feeConfig.gpsServiceFee"]')[0].value;
		result.gpsServiceFee.end = $body.find('input[name="feeConfig.gpsServiceFee"]')[1].value;
	}
	
	//停车费
	result.parkType = $body.find('input[name="feeConfig.parkType"]:checked').val();
	result.parkFee = {};
	if(result.parkType == "1"){
		result.parkFee.start = $body.find('input[name="feeConfig.parkFee"]')[0].value;
		result.parkFee.end = $body.find('input[name="feeConfig.parkFee"]')[1].value;
	}
	
	return result;
}