$(function(){
	var model = $("#model").val();
	if(model == "view"){
		$("#editOrderForm input").attr("disabled",true);
		$("#editOrderForm select").attr("disabled",true);
		$("#save").hide();
		$("#yx_attach_upload_btn").hide();
		$("#sr_attach_upload_btn").hide();
	}
	
	$(":input").inputmask();
	
	initProduct();
	
	$("select[name='productType']").bind("change",changeProductType);
	
	$("#yearFee").val((parseFloat($("#loanDayRate").val())*12).toFixed(2));
	
	$("input[name='loanDayRate']").bind("keyup",function(){
		var val = $(this).val();
		if(val != ""){
			$("#yearFee").val((parseFloat(val)*12).toFixed(2));
		}else{
			$("#yearFee").val((0).toFixed(2));
		}
	});
	
	var fileValidate={
		maxSize:1024*1024*10,
		extensions:'jpg,jpeg,png',
		mimeTypes: 'image/jpg,image/jpeg,image/png',
		message:'只能上传图片文件'
	}
	
	var domArr = ["#pick-custimg_idcard1","#pick-custimg_idcard2"];
	
	initUploadInput(domArr,fileValidate);
	
	// 注册验证
	var $form=$('#editOrderForm').find('form');
	/*$form.validate({
		type:{
			validators: {
				notEmpty: {
					message: '请选择客户类型'
				}
			}
		},
		name: {
			validators: {
				notEmpty: {
					message: '请输入客户姓名'
				},
				regexp:{
					regexp :/^[\u4e00-\u9fa5a-zA-Z]{2,20}$/,
					message: '请输入2-20个中英文个字符'
				}
			}
		},
		gender: {
			trigger:'change',
			validators: {

				notEmpty: {
					message: '请选择性别'
				}
			}
		},
		licenseNum: {
			validators: {
				notEmpty: {
					message: '请输入证件号码'
				},
				callback: {
					message: '身份证校验不通过',
					callback: function(value, validator) {
						if($.trim(value) == ""){
							return true;
						}
						var flag = IdentityCodeValid(value)
						if(flag){
							$("#gender").val(chooseGender($("#licenseNum").val())).trigger('change');
						}
						return flag;
					}
				},
				remote: {
					url: web_root+'/system/customer/checkCustomerExist',//验证地址
					message: '身份证号已存在或被添加黑名单',//提示消息
					delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
					type: 'POST',//请求方式
					threshold: 15,//输入多少个字符后才请求服务器
					data: function(validator) {
						return {
							"licenseNum" : validator.getFieldValue("licenseNum"),
							"id" : validator.getFieldValue("id")
						};
					}
				}
			}
		},
		childCount:{
			validators: {
				between: {
					min: 0,
					max: 100,
					message: '请输入0-100的数字'
				}
			}
		},
		supportNum:{
			validators: {
				between: {
					min: 0,
					max: 100,
					message: '请输入0-100的数字'
				}
			}
		},
		houseSpending:{
			validators: {
				between: {
					min: 0,
					max: 1000000,
					message: '请输入0-1,000,000的数字'
				}
			}
		},
		mobile: {
			trigger:'input',
			validators: {

				notEmpty: {
					message: '请输入手机号码'
				},
				regexp: {
					regexp: /^1(3|4|5|7|8)\d{9}$/,
					message: '请输入正确的手机号码'
				}
			}
		},
		mobile2: {
			validators: {
				regexp: {
					regexp: /^1(3|4|5|7|8)\d{9}$/,
					message: '请输入正确的手机号码'
				}
			}
		},
		email : {
			validators: {
				emailAddress : {
					message: '请输入正确邮箱地址'
				},
				stringLength: {
					min: 0,
					max: 32,
					message: '请输入0-32个字符'
				}
			}
		},
		qq : {
			validators: {
				regexp: {
					regexp: /^\d{5,15}$/,
					message: '请输入正确的QQ号码'
				}
			}
		},
		wechat : {
			validators: {
				regexp: {
					regexp: /^[a-zA-Z]{1}[-_a-zA-Z0-9]{5,19}$/,
					message: '请输入正确的微信号码'
				}
			}
		},
		phone: {
			validators: {
				regexp: {
					regexp: /((^0{0,1}1[0-9]{10}$)|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
					message: '请输入正确的座机号'
				},
				stringLength: {
					min: 0,
					max: 13,
					message: '请输入0-13个字符'
				}
			}
		},
		companyName: {
			validators: {
				stringLength: {
					min: 0,
					max: 40,
					message: '请输入0-40个字符'
				}
			}
		},
		deptName: {
			validators: {
				stringLength: {
					min: 0,
					max: 15,
					message: '请输入0-15个字符'
				}
			}
		},
		salaryDate: {
			validators: {
				between: {
					min: 0,
					max: 31,
					message: '请输入0-31的数字'
				}
			}
		},
		salary: {
			validators: {
				regexp: {
					regexp: /^((([1-9]\d{0,5})(\.\d{1,2}|\.{0}))|([1][0]{6})(\.[0]{1,2})?)$/,
					message: '请输入正确的金额'
				}
			}
		},
		companyPhone :{
			validators: {
				regexp: {
					regexp: /((^0{0,1}1[0-9]{10}$)|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
					message: '请输入正确的座机号'
				},
				stringLength: {
					min: 0,
					max: 13,
					message: '请输入0-13个字符'
				}
			}
		},
		idCardFront: {
			trigger:'input',
			validators: {
				notEmpty: {
					message: '身份证照正面图片不能为空'
				}
			}
		},
		idCardBack: {
			trigger:'input',
			validators: {
				notEmpty: {
					message: '身份证照反面图片不能为空'
				}
			}
		},
	});*/
	
	$("#save").bind('click', function(e) {//点击提交之后
		var data = {};
		var inputs = $("#editOrderForm input");
		var selects = $("#editOrderForm select");
		var label;
		for(var i = 0;i<inputs.length;i++){
			label = $("#editOrderForm label[for='"+inputs.eq(i).attr("name")+"']");
			if(label.attr("class") == "require" && inputs.eq(i).val() == "")
				return alert("请填写"+label.html());
			data[inputs.eq(i).attr("name")] = inputs.eq(i).val();
		}
		
		for(var i = 0;i<selects.length;i++){
			label = $("#editOrderForm label[for='"+selects.eq(i).attr("name")+"']");
			if(label.attr("class") == "require" && selects.eq(i).val() == "")
				return alert("请选择"+label.html());
			data[selects.eq(i).attr("name")] = selects.eq(i).val();
		}
		
		worf.ajax({
			url : web_root+'/order/saveOrder',
			type : 'post',
			data: data,
			success : function(data) {
				if(data.status == 1){
					$.showPop("保存成功！","",2000);
					window.setTimeout(function(){
				        var url=tools.getCurrentIFrameUrl();
				        var refreshUrl="/order/loadOrderManager";
				        tools.closeParentTab(url,refreshUrl)
        			},2000);
				}else{
					$.showPop(data.message,"",2000);
				}
			}
		});
		
        /*// Prevent form submission
        e.preventDefault();alert(1);
        // Get the form instance
        var $form = $(e.target);
        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');
        //提交服务器
		var $modifyCustomerBtn=$('#save');
		$modifyCustomerBtn.button('loading');
		$form.btnAjaxSubmit({
        	success:function(data){
        		if(data.status == 1){
        			$.showPop(data.message,"",2000);
        			window.setTimeout(function(){
				        var url=tools.getCurrentIFrameUrl();
				        var refreshUrl="/system/customer/loadCustomerManager";
				        tools.closeParentTab(url,refreshUrl)
        			},2000);
        		}else{
        			$.showPop(data.message,"",2000);
        		}
        	},
			complete:function () {
				$modifyCustomerBtn.button('reset');
			}
        });*/
	});
	
	var fileValidate2={
			maxSize:1024*1024*10,
			extensions:'jpg,jpeg,png,doc,pdf',
			mimeTypes: 'image/jpg,image/jpeg,image/png,application/msword,application/pdf',
			message:'只能上传图片和*.doc、*.pdf文件'
		}
	
	var domArr2 = ["#pick-custincome_ssOrAf1","#pick-custincome_bs","#pick-custincome_cr"];
		
	initUploadInput(domArr2,fileValidate2);
		if(model == "edit"){
		worf.ajax({
			url : web_root+'/district/info',
			type : 'get',
			success : function(data) {
				$('#editOrderForm #schoolAddrJoin').citypicker({simple:true,data:data.data});
				$('#editOrderForm #houseHoldAddrJoin').citypicker({simple:true,data:data.data});
				$('#editOrderForm #companyAddrJoin').citypicker({simple:true,data:data.data});
				$('#editOrderForm #receiversBankAddr').citypicker({simple:true,data:data.data,disc:['省份','城市'],level:['province','city']});
				$('#editOrderForm #repaymentBankAddr').citypicker({simple:true,data:data.data,disc:['省份','城市'],level:['province','city']});
				
			}
		});
	}

});

function initProduct(){
	var productObj = $("select[name='productCode'] option:selected");
	$("select[name='productType'] option[value='"+productObj.attr("productType")+"']").attr("selected","selected");
	$("select[name='productCode'] option[productType!='"+productObj.attr("productType")+"']").hide();
	$("select[name='productCode'] option[value='']").show();
}

function changeProductType(){
	var productType = $("select[name='productType'] option:selected");
	$("select[name='productCode'] option[productType!='"+productType.attr("value")+"']").hide();
	$("select[name='productCode'] option[value='']").show();
	$("select[name='productCode'] option").removeAttr("selected");
	$("select[name='productCode'] option[value='']").attr("selected","selected");
	$("select[name='productCode'] option[productType='"+productType.attr("value")+"']").show();
}

function initUploadInput(domArr,fileValidate){
	var tempUploader;
	var BASE_URL='/static/assets/plugins/webuploader'; 
	var webuploaderArr={};
	var fileState={
			loading:'<i class="fa fa-spinner fa-spin"></i>',
			success:'<i class="fa fa-check fileSuccess"></i>',
			error:'<i class="fa fa-close fileError"></i>',
		};
	domArr.forEach(function (v) {
		webuploaderArr[v]={};
		var uploader=WebUploader.create({
			auto:true,
			swf:BASE_URL+'/Uploader.swf',
			pick:{
				id:v,
				label:'<i class="glyphicon glyphicon-folder-open"></i><span>选择文件</span>'
			},
			server: web_root+'/order/uploadLoanAttach',
			fileSingleSizeLimit: fileValidate.maxSize,
			accept:{
				extensions: fileValidate.extensions,
				mimeTypes:fileValidate.mimeTypes
			},
			duplicate: true
		});
		webuploaderArr[v].uploader=uploader;
		var parentDiv=$(v).parents('.uploadFileDiv');
		var fileNoteDiv=parentDiv.find('.fileNote');
		var uploadFileNameDiv=parentDiv.find('.uploadFileName');
		var hiddenFileInput=parentDiv.find('.hiddenInput');
		var uploadFileBtn=parentDiv.find('.uploadFileBtn');
		var deleteFileBtn=parentDiv.find('.deleteFileBtn');
		uploader.on('uploadBeforeSend', function (obj, data, headers) {
			$.extend(headers, {
				Accept: "*/*"
			});
		});
		uploader.option('formData', {
			bpId: "",
			category :""
		});
		uploader.on( 'fileQueued', function( file ) {
			webuploaderArr[v].file=file;
			var content = '<div title="'+ file.name+'" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'+ file.name+'</span></div>';
			uploadFileNameDiv.html(content);
		});
		//监听上传状态
		uploader.on('all',function (type) {
			if ( type === 'startUpload' ) {
				fileNoteDiv.html(fileState.loading);
			}
		});
		//监听上传成功
		uploader.on('uploadSuccess',function (file,res) {
			if(res.status==1){
				fileNoteDiv.html(fileState.success);
				hiddenFileInput.val(res.data.resourceId).trigger('input');
			}else{
				fileNoteDiv.html(fileState.error);

			}
		});
		//监听上传失败
		uploader.on('uploadError',function (file,res) {
			fileNoteDiv.html(fileState.error);
		});
		//监听validate不通过是的错误提示
		uploader.on('error', function (type) {
			switch (type) {
				case 'Q_TYPE_DENIED':
					$.alert(fileValidate.message);
					break;
				case 'F_EXCEED_SIZE':
					var size=WebUploader.formatSize(fileValidate.maxSize, ['B', 'KB', 'MB']);
					$.alert('上传的文件大小超过' + size);
					break;
			}
		})
		// 监听上传按钮
		uploadFileBtn.off().on('click',function () {
			if(!webuploaderArr[v].file) {
				$.showPop("请先选择文件","",2000);
				return;
			}
			uploader.option('formData', {
				bpId: "",
				category :""
			});
			uploader.upload(webuploaderArr[v].file.id);
		})
		deleteFileBtn.off().on('click',function () {
			webuploaderArr[v].file&&uploader.removeFile(webuploaderArr[v].file,true);
			webuploaderArr[v].file='';
			hiddenFileInput.val('').trigger('input');
			//删除显示的文件名和状态
			fileNoteDiv.empty();
			uploadFileNameDiv.empty()

		})
	});
}

function removeAttach(_attachId){
	$.post({
		url : web_root+'/order/removeAttach',
		type : 'post',
		dataType:'json',
		async:true,
		cache :false,
		data : {
			'attachId':_attachId
		},
		success : function(data) {
			if(data.status==1){
				$.showPop(data.message,"",1000);
				window.location.reload();
			}else{
				$.showPop(data.message,"",1000);
			}
		},
		error : function(){
			$.showPop('网络错误','',1000);
		},
	});
}