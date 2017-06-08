function IdentityCodeValid(code) { 
    var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
    var tip = "";
    var pass= true;
    
    if(!code || !/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}$)/i.test(code)){
        tip = "身份证号格式错误";
        pass = false;
    }
    
   else if(!city[code.substr(0,2)]){
        tip = "地址编码错误";
        pass = false;
    }
    else{
        //18位身份证需要验证最后一位校验位
        if(code.length == 18){
            code = code.split('');
            //∑(ai×Wi)(mod 11)
            //加权因子
            var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
            //校验位
            var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
            var sum = 0;
            var ai = 0;
            var wi = 0;
            for (var i = 0; i < 17; i++)
            {
                ai = code[i];
                wi = factor[i];
                sum += ai * wi;
            }
            var last = parity[sum % 11];
            if(parity[sum % 11] != code[17]){
                tip = "校验位错误";
                pass =false;
            }
        }
    }
    return pass;
}

function chooseGender(value){
	var gender = "";
	if(value.length == 18){
		gender = value.charAt(16);
	} else {
		gender = value.charAt(value.length - 1);
	}
	gender = parseInt(gender) % 2;
	return gender;
};



$(function(){
	var BASE_URL=web_root+'/static/assets/plugins/webuploader';
	var frontPick='#pick-custimg_idcard1';
	var backPick='#pick-custimg_idcard2'; 
	var frontFile = null;
	var backFile = null;
	var webuploaderArr={};
	var fileState={
		loading:'<i class="fa fa-spinner fa-spin"></i>',
		success:'',
		error:'<i class="fa fa-close fileError"></i>',
	};
	var fileValidate={
		maxSize:1024*1024*10,
		extensions:'jpg,jpeg,png',
		mimeTypes: 'image/jpg,image/jpeg,image/png',
		message:'只能上传图片文件'
	}
	//加载webuploader插件
	var domArr=[frontPick,backPick]
	domArr.forEach(function (v) {
		webuploaderArr[v]={};
		var uploader=WebUploader.create({
			auto:true,
			swf:BASE_URL+'/Uploader.swf',
			pick:{
				id:v,
				label:'<i class="glyphicon glyphicon-folder-open"></i><span>选择文件</span>'
			},
			server: web_root+'/fileUpload',
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
		// uploader.on('uploadBeforeSend ', setHeader);
		uploader.on( 'fileQueued', function( file ) {
			webuploaderArr[v].file=file;
			var content = '<div title="'+ file.name+'" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'+ file.name+'</span></div>';
			uploadFileNameDiv.html(content);
			fileNoteDiv.html('')
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
				hiddenFileInput.val(res.data.resourceId).trigger('input')
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
					var size=WebUploader.formatSize(fileValidate.maxSize, ['B', 'KB', 'MB'])
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

	$("#houseTime,#entryTime,#comeTime").datepicker({
		format: 'yyyy-mm-dd',
		autoclose:true,
		todayBtn:'linked',
		todayHighlight:true,
		language:'zh-CN',
	});

	$("#industry").positionSelect({
		maxCount : 1,
		containerId: "positionDiv",
		industryId: "industry",
		className: "big-window",
		nameId: "job"
	},function (industry,job) {
		$('#industry').val(industry).trigger('change');
		$('#job').val(job).trigger('change');
	});
	
	$("#cancelBtn").bind("click",function(){
		var url=tools.getCurrentIFrameUrl();
		debugger
		tools.closeParentTab(url)
	});
	
	worf.ajax({
		url : web_root+'/district/info',
		type : 'get',
		success : function(data) {
			$('#addCustomerForm #registAddr').citypicker({simple:true,data:data.data});
			$('#addCustomerForm #liveAddr').citypicker({simple:true,data:data.data});
			$('#addCustomerForm #companyAddr').citypicker({simple:true,data:data.data});
		}
	});
	// 注册验证
	var $form=$('#addCustomerForm').find('form');
	$form.validate({
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
							"licenseNum" : validator.getFieldValue("licenseNum")
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
				},
				integer:{
					message: '请输入整数'
				}
			}
		},
		supportNum:{
			validators: {
				between: {
					min: 0,
					max: 100,
					message: '请输入0-100的数字'
				},
				integer:{
					message: '请输入整数'
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
				stringLength: {
					min: 0,
					max: 32,
					message: '请输入0-32个字符'
				},
            	regexp: {
                    regexp: /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/,
                    message: '请输入正确邮箱地址'
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
				},
				integer:{
					message: '请输入整数'
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
	});

	$form.off().on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();
        // Get the form instance
        var $form = $(e.target);
        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');
        //提交服务器
		var $saveCustomerBtn=$('#saveCustomerBtn');
		$saveCustomerBtn.button('loading');
		$form.ajaxSubmit({
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
				$saveCustomerBtn.button('reset');
			}
        });
	});
	$("#addCustomerForm #saveCustomerBtn").off().on('click',function(){
		var bootstrapValidator=$form.data('bootstrapValidator');
		bootstrapValidator.validate();
	});
});