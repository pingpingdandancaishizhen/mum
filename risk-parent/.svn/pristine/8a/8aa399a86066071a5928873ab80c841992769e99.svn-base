var validate = {
 	product:{
		validators: {
   			notEmpty: {
      			message: '请选择产品'
    		}   
		}
	},
	templateName: {
        validators: {
            notEmpty: {
                message: '请输入合同名'
            },
            stringLength: {
				min: 0,
				max: 40,
				message: '请输入0-40个字'
			},remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                url: web_root+'/contract/template/checkNameExist',//验证地址
                message: '合同名称已存在',//提示消息
                delay :  1000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                type: 'POST',//请求方式
                threshold:4,//输入多少个字符后才请求服务器
                data: function(validator) {
                    return {
                    	id: $("#addContractTemplateModal").find("#id").val(),
                        tempName: $("#addContractTemplateModal").find("#templateName").val(),
                        product: $("#addContractTemplateModal").find("#product").val(),
                    };
                }
            }
        }
    },
    fileResource: {
	    trigger:'input',
        validators: {
            notEmpty: {
                message: '请上传模板文件'
            }
        }
    }
};

$(function(){
	var tempUploader;
	var BASE_URL='/static/assets/plugins/webuploader'; 
	var tempPick='#pick-temp';
	var webuploaderArr={};
	
	var fileState={
		loading:'<i class="fa fa-spinner fa-spin"></i>',
		success:'',
		error:'<i class="fa fa-close fileError"></i>'
	};
	
	var fileValidate={
		maxSize:1024*1024*10,
		extensions:'pdf',
		mimeTypes: 'application/pdf',
		message:'只能上传PDF文件'
	}
	
	$form=$('#addContractTemplateModal').find('form');
	
	var domArr = [tempPick];
	
	$("#add_temp_btn").bind("click",function(){
		 $("#addContractTemplateModal").showModal();
		$("#addContractTemplateModal").find('modal-title').html('新增合同模板');
		 $form.resetForm();
		 //初始化非输入框类型的控件
		 resetModal();
         
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
					$(hiddenFileInput.get(0)).val(res.data.resourceId).trigger('input');
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
		
         $form.validate(validate);
         
         // 先注册监听表单验证成功事件==》验证表单
		$form.off().on('success.form.bv',function () {
 	        //提交服务器
 	        $("#addContractTemplateModal #addContractTemplateForm").btnAjaxSubmit({
 	            success:function(data){
 	                $table.bootstrapTable('refresh');
 	                $form.data('bootstrapValidator').resetForm();
 	                $form.resetForm();
 	                $('#addContractTemplateModal').hideModal();
 	                $.showPop('保存合同模板成功');
 	            }
 	        });
 	    });
	 });
	
	$("#modify_temp_btn").bind("click",function(){
		var selected = $table.bootstrapTable('getSelections');

		if(selected.length === 0 ){
			$.alert("请先选择合同模板");
		} else {
			$("#addContractTemplateModal").showModal();
			$("#addContractTemplateModal").find('.modal-title').html('编辑合同模板');
			$form.resetForm();
			//初始化非输入框类型的控件
			resetModal();
			 
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
						$(hiddenFileInput.get(0)).val(res.data.resourceId).trigger('input');
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
			//内容回填
			$.when(
				getTempInfo(selected[0].id,function(data){
					$("#id").val(data.data.id);
	 				$("#status").val(data.data.status);
	 				$("#product").val(data.data.product);
	 				$("#templateName").val(data.data.templateName);
	 				$("#fileResource").val(data.data.fileResource);
	 				$("#fileName").val(data.data.fileName);
	 				$("#templateDesc").val(data.data.templateDesc);
	 				var content = '<div title="'+ data.data.fileName+'" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'+ data.data.fileName+'</span></div>';
	 				$(".uploadFileName").html(content);
	 				$(".fileNote").html(fileState.success);
	 				if(data.data.mainFlag === '1'){
	 					$("#mainFlag").prop('checked',true);
	 				}
				})
			).done(function(){
				$.when(
					flushPartner(function(data){
						var roleHtml='';
						$.each(data.data.roleList,function(i,role){
							var partnerArr = [];
							$.each(role.partnerList,function(i,partner){
								var _html = '<label id="lb_role_'+role.id+'_'+partner.id+'" class="label-box-item lb_cla_'+role.id+'">'+
									'<input type="checkbox" id="ip_role_'+role.id+'_'+partner.id+'" class="ip_cla_'+role.id+'" name="partnerIds" onchange="javascript:checkedChange(\''+role.id+'\',\''+partner.id+'\');"  value="'+role.id+'_'+partner.id+'"/>'+partner.name+
									'</label>';
								partnerArr.push(_html);
							});
							roleHtml+='<div class="input-group">';
							roleHtml+='<label class="label-head " >'+role.name+':'+'</label>';
							roleHtml+='<div class="label-box col-sm-12">';
							roleHtml+=partnerArr.join('');
							roleHtml+='</div></div>'
						});
						$("#partner").html(roleHtml);
				        $.each(data.data.selects,function(i,select){
				    	   $("#lb_role_"+select.role+'_'+select.id).addClass("active");
				    	   $("#ip_role_"+select.role+'_'+select.id).attr('checked',true);
				        });
					})
				).done(function(){

					// $form.formValidation('updateOption','partnerIds','choice',json).formValidation('revalidateField', 'partnerIds');
					validate.partnerIds= {container:$('#partner'),validators: {choice: {min:1,message:'请选择最少一个参与方'}}};
					$form.validate(validate);
			        // 先注册监听表单验证成功事件==》验证表单
					$form.off().on('success.form.bv',function () {
				        //提交服务器
				        $("#addContractTemplateModal #addContractTemplateForm").btnAjaxSubmit({
				            success:function(data){
				                $table.bootstrapTable('refresh');
				                $form.data('bootstrapValidator').resetForm();
				                $form.resetForm();
				                $('#addContractTemplateModal').hideModal();
				                $.showPop('保存合同模板成功');
				            }
				        });
				    });
				})
			});
		}
	});
	
	$("#addContractTemplateModal #saveTemplateBtn").bind("click",function(){
		 $('#addContractTemplateModal #addContractTemplateForm').submit();
	});
	
	$("#product").change(function(){
		$form.data('bootstrapValidator').destroy();
		if($(this).val()){
			validate.partnerIds = {container:$('#partner'),validators: {choice: {min:1,message:'请选择最少一个参与方'}}};
		}else{
			delete validate.partnerIds;
		}
		$.when(
			flushPartner(function(data){
				var roleHtml='';
		        $.each(data.data.roleList,function(i,role){
		        	var partnerArr = [];
		        	$.each(role.partnerList,function(i,partner){
					var _html = '<label id="lb_role_'+role.id+'_'+partner.id+'" class="label-box-item lb_cla_'+role.id+'">'+
						'<input type="checkbox" id="ip_role_'+role.id+'_'+partner.id+'" class="ip_cla_'+role.id+'" name="partnerIds" onchange="javascript:checkedChange(\''+role.id+'\',\''+partner.id+'\');"  value="'+role.id+'_'+partner.id+'"/>'+partner.name+
					'</label>';
						partnerArr.push(_html);
					});
			        roleHtml+='<div class="input-group">';
			        roleHtml+='<label class="label-head " >'+role.name+':'+'</label>';
			        roleHtml+='<div class="label-box col-sm-12">';
		        	roleHtml+=partnerArr.join('');
			        roleHtml+='</div></div>'
		        });
				$("#partner").html(roleHtml);
			    $.each(data.data.selects,function(i,select){
		    	   $("#lb_role_"+select.role+'_'+select.id).addClass("active");
		    	   $("#ip_role_"+select.role+'_'+select.id).attr('checked',true);
			    });
			})
		).done(function(){
			formvalidateSet($form,$table);
		})
	});
})

function formvalidateSet(form,table){
	form.validate(validate);
	// 先注册监听表单验证成功事件==》验证表单
    form.on('success.form.bv',function () {
        //提交服务器
        $("#addContractTemplateModal #addContractTemplateForm").btnAjaxSubmit({
            success:function(data){
                table.bootstrapTable('refresh');
                form.data('bootstrapValidator').resetForm();
                form.resetForm();
                $('#addContractTemplateModal').hideModal();
                $.showPop('保存合同模板成功');
            }
        });
    });
}

function flushPartner(callback){
	var product = $("#product").val();
	var tempId = $("#id").val();
	return worf.ajax({
		url : web_root+"/system/partner/queryPartnerByProduct",
 		type : 'get',
 		data : {
 			productId : product,
 			tempId : tempId
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

function checkedChange(partnerId,roleId){
	if($("#ip_role_"+partnerId+"_"+roleId).is(':checked')){
		$.each($(".ip_cla_"+partnerId),function(i,input){
			if('ip_role_'+partnerId+'_'+roleId!=input.id){
				input.checked = false;
			}
		});
		$.each($(".lb_cla_"+partnerId),function(i,lable){
			if('lb_role_'+partnerId+'_'+roleId!=lable.id){
				$(lable).removeClass("active");
			}
		});
	}
}

function getTempInfo(tempId,callback){
	return worf.ajax({
		url : web_root+"/contract/template/getTemplate",
 		type : 'get',
 		data : {
 			tempId : tempId
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
function resetModal(){
	$("#partner").html('');
	 $("#mainFlag").attr('checked',false);
    $("input:hidden").val('');
    $(".uploadFileName").html('');
    $(".fileNote").html('');
}


