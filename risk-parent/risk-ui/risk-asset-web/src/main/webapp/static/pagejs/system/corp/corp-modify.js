$(function() {

	worf.ajax({
		url : web_root + '/district/info',
		type : 'get',
		success : function(data) {
			$('#corpForm #address').citypicker({
				simple : true,
				data : data.data
			});
		}
	});
	var BASE_URL = web_root + '/static/assets/plugins/webuploader';
	var logoPick = '#pick-logo';
	var frontFile = null;
	var webuploaderArr = {};
	var fileState = {
		loading : '<i class="fa fa-spinner fa-spin"></i>',
		success : '<i class="fa fa-check fileSuccess"></i>',
		error : '<i class="fa fa-close fileError"></i>',
	};
	var fileValidate = {
		maxSize : 1024 * 1024 * 5,
		extensions : 'jpg,jpeg,png,gif',
		mimeTypes : 'image/jpg,image/jpeg,image/png,image/gif',
		message : '只能上传图片文件'
	}

	var domArr = [ logoPick ]
	domArr
			.forEach(function(v) {
				webuploaderArr[v] = {};
				var uploader = WebUploader.create({
							auto:true,
							swf : BASE_URL + '/Uploader.swf',
							pick : {
								id : v,
								label : '<i class="glyphicon glyphicon-folder-open"></i><span>选择文件</span>'
							},
							server : web_root + '/system/corp/uploadCorpLogo',
							fileSingleSizeLimit : fileValidate.maxSize,
							accept : {
								extensions : fileValidate.extensions,
								mimeTypes : fileValidate.mimeTypes
							},
							duplicate : true
						});
				webuploaderArr[v].uploader = uploader;
				var parentDiv = $(v).parents('.uploadFileDiv');
				var fileNoteDiv = parentDiv.find('.fileNote');
				var uploadFileNameDiv = parentDiv.find('.uploadFileName');
				var hiddenFileInput = parentDiv.find('.hiddenInput');
				var uploadFileBtn = parentDiv.find('.uploadFileBtn');
				var deleteFileBtn = parentDiv.find('.deleteFileBtn');
				var setHeader = function(object, data, headers) {
					headers['Access-Control-Allow-Origin'] = '*';
					headers['Access-Control-Request-Headers'] = 'content-type';
					headers['Access-Control-Request-Method'] = 'POST';
				}
				uploader.on('uploadBeforeSend', function(obj, data, headers) {
					$.extend(headers, {
						Accept : "*/*"
					});
				});
				// uploader.on('uploadBeforeSend ', setHeader);
				uploader
						.on(
								'fileQueued',
								function(file) {
									webuploaderArr[v].file = file;
									var content = '<div title="'
											+ file.name
											+ '" class="file-caption-name"><i class="glyphicon glyphicon-file"></i> <span>'
											+ file.name + '</span></div>';
									uploadFileNameDiv.html(content);
									fileNoteDiv.html('')
								});
				// 监听上传状态
				uploader.on('all', function(type) {
					if (type === 'startUpload') {
						fileNoteDiv.html(fileState.loading);
					}
				});
				// 监听上传成功
				uploader.on('uploadSuccess', function(file, res) {
					if (res.status == 1) {
						fileNoteDiv.html(fileState.success);
						hiddenFileInput.val(res.data).trigger(
								'input')
					} else {
						fileNoteDiv.html(fileState.error);

					}
				});
				// 监听上传失败
				uploader.on('uploadError', function(file, res) {
					fileNoteDiv.html(fileState.error);
				});
				// 监听validate不通过是的错误提示
				uploader.on('error', function(type) {
					switch (type) {
					case 'Q_TYPE_DENIED':
						$.alert(fileValidate.message);
						break;
					case 'F_EXCEED_SIZE':
						var size = WebUploader.formatSize(fileValidate.maxSize,
								[ 'B', 'KB', 'MB' ])
						$.alert('上传的文件大小超过' + size);
						break;
					}
				})
				// 监听上传按钮
				uploadFileBtn.off().on('click', function() {
					if (!webuploaderArr[v].file) {
						$.showPop("请先选择文件", "", 2000);
						return;
					}
					uploader.option('formData', {
					});
					uploader.upload(webuploaderArr[v].file.id);
				})
				deleteFileBtn.off().on(
						'click',
						function() {
							webuploaderArr[v].file
									&& uploader.removeFile(
											webuploaderArr[v].file, true);
							webuploaderArr[v].file = '';
							hiddenFileInput.val('').trigger('input');
							// 删除显示的文件名和状态
							fileNoteDiv.empty();
							uploadFileNameDiv.empty()

						})
			});

	var $form=$('#corpForm');
	$form.bootstrapValidator({
		  message: 'This value is not valid',
		    feedbackIcons: {        //提示图标
		        valid: 'glyphicon glyphicon-ok',
		        invalid: 'glyphicon glyphicon-remove',
		        validating: 'glyphicon glyphicon-refresh'
		    },
		    fields: {
		corpName: {
			validators: {
				notEmpty: {
					message: '请输入企业全称'
				},
				stringLength: {
					min: 2,
					max: 200,
					message: '请输入2-100个字符'
				}
			}
		},
		simpleName: {
			validators: {
				notEmpty: {
					message: '请输入企业简称'
				},
				stringLength: {
					min: 2,
					max: 20,
					message: '请输入2-20个字符'
				}
			}
		},
		linkPhone: {
			validators: {
				regexp: {
					regexp: /((^0{0,1}1[0-9]{10}$)|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/,
					message: '请输入正确的座机号'
				}
			}
		} 
		    }
	}).on('success.form.bv', function(e) {//点击提交之后
        // Prevent form submission
        e.preventDefault();
        // Get the form instance
        var $form = $(e.target);
        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');
        //提交服务器
		var modifyCorpInfo=$('#modifyCorpInfo');
		modifyCorpInfo.button('loading');
		$form.btnAjaxSubmit({
        	success:function(data){
        		if(data.status == 1){
        			bv.resetForm();
        			$.showPop('修改成功',"",2000);
        			window.setTimeout(function(){
        				window.location.reload();
        			},2000);
        		}else{
        			$.showPop(data.message,"",2000);
        		}
        	},
			complete:function () {
				modifyCorpInfo.button('reset');
			}
        });
	});
});