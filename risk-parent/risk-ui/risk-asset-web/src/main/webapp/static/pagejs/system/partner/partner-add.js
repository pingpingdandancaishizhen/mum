var baseValidate=
{
	name: {
        validators: {
        	notEmpty: {
				message: '请输入参与方名称'
			},
			regexp:{
				regexp :/^[\u4e00-\u9fa5a-zA-Z0-9]{0,40}$/,
				message: '请输入0-40个中英文字符'
			},
			remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                url: web_root+'/system/partner/checkNameExist',//验证地址
                message: '参与方名称已存在',//提示消息
                delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                type: 'POST',//请求方式
                threshold:4,//输入多少个字符后才请求服务器
                data: function(validator) {
                    return {
                    	id: $("#addContractPartnerModal").find("#id").val(),
                        name: $("#addContractPartnerModal").find("#name").val(),
                    };
                }
            }
        }
    },
	code: {
        
    },
    phone: {
        validators: {
            notEmpty: {
                message: '请输入联系电话'
            },
 	        regexp: {
				regexp: /((^0{0,1}1[0-9]{10}$)|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
				message: '请输入正确的电话号码'
			},
			stringLength: {
				min: 0,
				max: 13,
				message: '请输入0-13个字符'
			}
        }
    },
    type : {
    	validators : {
    		notEmpty: {
                message: '请选择参与方类别'
            }
    	}
    },
    email: {
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
    address : {
	    trigger:'change',
    	validators : {
    		notEmpty: {
                message: '请选择通讯地址'
            }
    	}
    },
    addrDetail : {
    	validators : {
    		notEmpty: {
                message: '请输入详细地址'
            }
    	}
    },
    sealResource : {
	    trigger:'change',
    	validators : {
    		notEmpty: {
                message: '请上传公章文件'
            }
    	}
    },
    roleIds:{
    	validators: {
    		choice:{
    			min:1,message:'请至少选择一个参与方类型'
    		}
        }
    }
};
var validate;

//身份证号校验
idValid = {
    notEmpty: {
        message: '请输入身份证号'
    },
    callback: {
    	message: '身份证校验不通过',
    	callback: function(value) {
    		if($.trim(value) == ""){
    			return true;
    		}
    		var flag = IdentityCodeValid(value)
    		return flag;
    	}
    }
}

var corpCodeVald = 
{
	notEmpty: {
        message: '请输入机构代码'
    },
    regexp : {
    	regexp: /^[A-Z0-9]{8}-[A-Z0-9]{1}$/,
    	message: '机构代码校验不通过'
    }
};

var areaData;

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

$(function(){
	var BASE_URL='/static/assets/plugins/webuploader'; 
	var sealPick='#pick-seal';
	var signPick='#pick-sign';
	var webuploaderArr={};
	
	var fileState={
			loading:'<i class="fa fa-spinner fa-spin"></i>',
			success:'',
			error:'<i class="fa fa-close fileError"></i>'
	};
	
	var fileValidate={
		maxSize:1024*1024*10,
		extensions:'jpg,jpeg,png',
		mimeTypes: 'image/jpg,image/jpeg,image/png',
		message:'只能上传图片文件'
	}
	
	var $form=$('#addContractPartnerModal').find('form');
	
    $("#add_partner_btn").bind("click",function(){
    	validate = $.extend({},baseValidate);
    	$("#address").citypicker('destroy');
		$("#addContractPartnerModal").showModal();
	    $("#addContractPartnerModal").find('.modal-title').html('新增参与方');
	    $form.resetForm();
	    var domArr=[sealPick];
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
				    $(hiddenFileInput.eq(0)).val(res.data.resourceId).trigger('change');

				    $(hiddenFileInput.eq(1)).val(file.name);
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
			    hiddenFileInput.val('').trigger('change');
			    //删除显示的文件名和状态
			    fileNoteDiv.empty();
			    uploadFileNameDiv.empty()

		    })
	    });
		//手动重置模态框非input控件
		resetModal();
		$.when(
			initRoles(function(data){
				var roleHtml = [];
				$.each(data.data,function(i,role){
 					var htm = '<label id="lb_'+role.id+'" class="label-box-item">'+
		 					'<input id="ip_'+role.id+'" type="checkbox" name="roleIds" value="'+role.id+'">'+role.name+
		 					'</label>';
 					roleHtml.push(htm);
 				});
				$("#roleDiv").html(roleHtml.join(''));
			}),
			initArea(function(data){
				$('#address').citypicker({simple:true,data:data.data});
			})
		).done(function(){
			validate.code.validators = $.extend({},corpCodeVald);
			$form.validate(validate);
			
			// 先注册监听表单验证成功事件==》验证表单
			$form.off().on('success.form.bv',function () {
	            //提交服务器
	            $("#addContractPartnerModal #addContractPartnerForm").btnAjaxSubmit({
	                success:function(data){
	                    $table.bootstrapTable('refresh');
	                    $form.data('bootstrapValidator').resetForm();
	                    $form.resetForm();
	                    $('#addContractPartnerModal').hideModal();
	                    $.showPop('保存参与者成功');
	                }
	            });
	        });
	        
	        // 绑定提交按钮
	        $("#addContractPartnerModal #savePartnerBtn").off().on('click',function () {
	            var bootstrapValidator=$form.data('bootstrapValidator');
	            bootstrapValidator.validate();

	        });
	        
	        //绑定参与方类型点击事件
			$("#ip_3").change(function(){
				if($(this).is(':checked')){
					$("#coopDeptDiv").show();
					validate.coopDept = {validators: {notEmpty: {message: '请选择产品'}}};
				}else {
					$("#coopDeptDiv").hide();
					delete validate.coopDept;
				}
				$form.data('bootstrapValidator').destroy();
				formvalidateSet($form,$table);
			});
		});
	});
    
    $("#edit_partner_btn").bind("click",function(){
    	validate = $.extend({},baseValidate);
    	var selected = $table.bootstrapTable('getSelections');
    	$("#address").citypicker('destroy');
    	$form.resetForm();
    	//手动重置模态框非input控件
    	resetModal();
    	
		if(selected.length === 0 ){
			$.alert("请先选择合同参与方");
		} else {
			$("#addContractPartnerModal").showModal();
			$("#addContractPartnerModal").find('.modal-title').html('修改参与方');
			$.when(
				initRoles(function(data){
					var roleHtml = [];
					$.each(data.data,function(i,role){
	 					var htm = '<label id="lb_'+role.id+'" class="label-box-item">'+
			 					'<input id="ip_'+role.id+'" type="checkbox" name="roleIds" value="'+role.id+'">'+role.name+
			 					'</label>';
	 					roleHtml.push(htm);
	 				});
					$("#roleDiv").html(roleHtml.join(''));
				})
			).done(function(){
				var domArr=[sealPick];
				worf.ajax({
					url : web_root+'/system/partner/getPartner',
					type : 'get',
					data : {
						'partnerId':selected[0].id
					},
					success : function(data) {
						var sealContent = '<div title="'+ data.data.sealName+'" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'+ data.data.sealName+'</span></div>';
		 				var signContent = '<div title="'+ data.data.signName+'" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'+ data.data.signName+'</span></div>';
						if(data.status==1){
							if('1' === data.data.type){
			 					$("#signDiv").show();
			 					$("#signFileDiv").html(signContent);
				 				$("#signNoteDiv").html(fileState.success);
			 					$("#name_sp").text("法人姓名：");
			 					$("#code_sp").text("法人身份证：");
			 					validate.signResource = {validators : {notEmpty: {message: '请上传签名文件'}}};
			 					validate.code.validators = $.extend({},idValid);
			 					validate.name.validators.notEmpty.message = '请输入法人姓名';
			 					validate.name.validators.remote.msssage = '已存在相同的法人姓名';
			 					domArr.push(signPick);
			 				}else{
			 					validate.code.validators = $.extend({},corpCodeVald);
			 					validate.name.validators.notEmpty.message = '请输入企业名称';
			 					validate.name.validators.remote.msssage = '已存在相同的企业名称';
			 				}
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
								uploader.option('formData', {
									bpId: "",
									category :""
								});
								uploader.on('uploadBeforeSend', function (obj, data, headers) {
									$.extend(headers, {
										Accept: "*/*"
									});
								});
								
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
										$(hiddenFileInput.get(0)).val(res.data.resourceId).trigger('change');;
										$(hiddenFileInput.get(1)).val(file.name);
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
									hiddenFileInput.val('').trigger('change');
									//删除显示的文件名和状态
									fileNoteDiv.empty();
									uploadFileNameDiv.empty()

								})
						    });
							
			 				$("#id").val(data.data.id);
			 				$("#status").val(data.data.status);
			 				$("#type").val(data.data.type);
			 				$("#name").val(data.data.name);
			 				$("#code").val(data.data.code);
			 				$("#phone").val(data.data.phone);
			 				$("#email").val(data.data.email);
			 				$("#fax").val(data.data.fax);
			 				$("#address").val(data.data.address);
			 				initArea(function(addrData){
			 					$('#address').citypicker({simple:true,data:addrData.data});
			 				});
			 				$("#addrDetail").val(data.data.addrDetail);
			 				$("#sealName").val(data.data.sealName);
			 				$("#sealResource").val(data.data.sealResource);
			 				$("#signName").val(data.data.signName);
			 				$("#signResource").val(data.data.signResource);
			 				
			 				$("#sealFileDiv").html(sealContent);
			 				$("#sealNoteDiv").html(fileState.success);
			 				$.each(data.data.roles,function(i,role){
			 					$("#lb_"+role.id).addClass("active");
			 					$("#ip_"+role.id).attr("checked","checked");
			 					if('3'===role.id){
			 						$("#coopDeptDiv").show();
			 						$("#coopDept").val(data.data.coopDept);
			 						validate.coopDept = {validators: {notEmpty: {message: '请选择合作门店'}}};
			 					}
			 				});
							$form.validate(validate);
			 			}else{
			 				$.showPop(data.message,"",2000);
			 			}
					}
				});
				
				// 先注册监听表单验证成功事件==》验证表单
				$form.off().on('success.form.bv',function () {
		            //提交服务器
		            $("#addContractPartnerModal #addContractPartnerForm").btnAjaxSubmit({
		                success:function(data){
		                    $table.bootstrapTable('refresh');
		                    $form.data('bootstrapValidator').resetForm();
		                    $form.resetForm();
		                    $('#addContractPartnerModal').hideModal();
		                    $.showPop('保存参与者成功');
		                }
		            });
		        });
		        
		        // 绑定提交按钮
		        $("#addContractPartnerModal #savePartnerBtn").off().on('click',function () {
		            var bootstrapValidator=$form.data('bootstrapValidator');
		            bootstrapValidator.validate();

		        });
		        
		        //绑定参与方类型点击事件
				$("#ip_3").change(function(){
					if($(this).is(':checked')){
						$("#coopDeptDiv").show();
						validate.coopDept = {validators: {notEmpty: {message: '请选择合作门店'}}};
					}else {
						$("#coopDeptDiv").hide();
						delete validate.coopDept;
					}
					$form.data('bootstrapValidator').destroy();
					formvalidateSet($form,$table);
				});
			});
		}
	});

	$("#addContractPartnerModal #savePartnerBtn").bind('click',function(){
		$('#addContractPartnerModal #addContractPartnerForm').submit();
	});

	$("#type").change(function(){
		var curr_val = $(this).val();
		if('1'===curr_val){
			$("#signDiv").show();
			$("#name_sp").text("法人姓名：");
			$("#code_sp").text("法人身份证：");
			
			if(!webuploaderArr[signPick]){
				var domArr=[signPick];
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
							$(hiddenFileInput.get(0)).val(res.data.resourceId).trigger('input');;
							$(hiddenFileInput.get(1)).val(file.name);
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
			}
			validate.signResource = {validators : {notEmpty: {message: '请上传签名文件'}}};
			validate.code.validators = $.extend({},idValid);
			validate.name.validators.notEmpty.message = '请输入法人姓名';
			validate.name.validators.remote.msssage = '已存在相同的法人姓名';
		}else {
			$("#signDiv").hide();
			$("#name_sp").text("参与企业名称：");
			$("#code_sp").text("机构代码：");
			delete validate.signResource;
			validate.code.validators = $.extend({},corpCodeVald);
			validate.name.validators.notEmpty.message = '请输入企业名称';
			validate.name.validators.remote.msssage = '已存在相同的企业名称';
		}
		if($form.data('bootstrapValidator')){
			$form.data('bootstrapValidator').destroy();
		}
		formvalidateSet($form,$table);
	});
});

function formvalidateSet(form,table){
	form.validate(validate);
	// 先注册监听表单验证成功事件==》验证表单
    form.on('success.form.bv',function () {
        //提交服务器
        $("#addContractPartnerModal #addContractPartnerForm").btnAjaxSubmit({
            success:function(data){
                table.bootstrapTable('refresh');
                form.data('bootstrapValidator').resetForm();
                form.resetForm();
                $('#addContractPartnerModal').hideModal();
                $.showPop('保存参与者成功');
            }
        });
    });
}

function initRoles(callback){
	return worf.ajax({
		url : web_root+'/system/partner/queryAllRoles',
		type : 'get',
		data : {
		},
		success : function(data) {
			if(data.status==1){
				callback&&callback(data);
			}else{
 				$.showPop(data.message,"",2000);
 			}
		}
	});
}

function initArea(callback){
	if(areaData){
		return callback&&callback(areaData);
	}else{
		return worf.ajax({
			url : web_root+'/district/info',
			type : 'get',
			success : function(data) {
				areaData = data;
				callback&&callback(data);
			}
		});
	}
}

function resetModal(){
	$("input:hidden").val('');
	$(".uploadFileName").html('');
    $(".fileNote").html('');
	$("#coopDeptDiv").hide();
	$("#coopDept").val('');
	$("#signDiv").hide();
	$("#sealFileDiv").html('');
	$("#sealNoteDiv").html('');
	$("#name_sp").text("参与企业名称：");
	$("#code_sp").text("机构代码：");
}