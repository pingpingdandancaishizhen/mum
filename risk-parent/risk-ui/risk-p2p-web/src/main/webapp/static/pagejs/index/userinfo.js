$(function(){
	 worf.ajax({
	   		url : web_root+'/system/user/getUserInfo',
	   		type : 'post',
	   		data : {},
	   		success : function(data) {
	   			if(data.status == 1){
	   				var user =data.data;
	   				$("#userinfo #userinfoForm #corpName").val(user.corpName);
	   				$("#corpNameSpan").text(user.corpName);
	   				$("#userinfo #userinfoForm #userAccount").val(user.userAccount);
	   				$("#userinfo #userinfoForm #userAccountSpan").text(user.userAccount);
	   				$("#userinfo #userinfoForm #userName").val(user.userName);
	   				$("#userinfo #userinfoForm #userNameSpan").text(user.userName);
	   				$("#userinfo #userinfoForm #deptName").val(user.deptName);
	   				$("#userinfo #userinfoForm #deptNameSpan").text(user.deptName);
	   				$("#userinfo #userinfoForm #roleNames").val(user.roleNames);
	   				$("#userinfo #userinfoForm #roleNamesSpan").text(user.roleNames);
	   				$("#userinfo #userinfoForm #job").val(user.job);
	   				$("#userinfo #userinfoForm #telephone").val(user.telephone);
	   				$("#userinfo #userinfoForm #email").val(user.email);
	   				$("#userinfo #userinfoForm #idcard").val(user.idcard);
	   				$("#userinfo #userinfoForm #desc").val(user.desc);
	   			}else{
	   				$.alert(data.message);
	   			}
	   		}
	 });
	 
	 $('#userinfo #userinfoForm').bootstrapValidator({
		    message: 'This value is not valid',
		    feedbackIcons: {        //提示图标
		        valid: 'glyphicon glyphicon-ok',
		        invalid: 'glyphicon glyphicon-remove',
		        validating: 'glyphicon glyphicon-refresh'
		    },
		    fields: {
		    	userName: {
		            message: '真实姓名验证失败',
		            validators: {
		                notEmpty: {
		                    message: '请输入真实姓名'
		                },
		                regexp: {
		                    regexp: /^[\u4e00-\u9fa5_a-zA-Z]{2,20}$/,
		                    message: '请输入2-20个字符，只支持中文或英文'
		                }
		            }
		        },
		        email: {
		            validators: {
		            	stringLength: {
                        max: 32,
                        message: '最长32个字符'
		            	},
		            	regexp: {
		                    regexp: /^[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?$/,
		                    message: '请输入正确邮箱地址'
		                }
		            }
		        },
		        telephone:{
		        	   validators: {
		        		   notEmpty: {
			                    message: '请输入手机号码'
			                },
		        			regexp: {
			                    regexp: /^1(3|4|5|7|8)\d{9}$/,
			                    message: '请输入手机号码'
			                }
			            }
		        },
		        job:{
		        	validators: {
		        		regexp: {
		                    regexp: /^[A-Za-z\u4e00-\u9fa5]{2,20}$/,
		                    message: '请输入2-20个字符，只支持中文英文'
		                }
		            }
		        },
		        idcard:{
		        	validators: {
		        		callback: {
		        			message:'身份证号有误',
		        			callback : function(value, validator, $field) {
				        			if (value === '') {
										return true;
									}
				        			if(idCarValidate(value)){
				        				return true;
				        			}else{
				        				return false;
				        			}
				        		}
		        		}
		            }
		        },
		        desc:{
		        	validators: {
		        		stringLength: {
		                    min: 0,
		                    max: 100,
		                    message: '请输入0-100个字符'
		                }
		            }
		        }
		    },
		    submitHandler: function (validator, form, submitButton) {
		    
		    }
		}).on('success.form.bv', function(e) {//点击提交之后
	        // Prevent form submission
	        e.preventDefault();
	        // Get the form instance
	        var $form = $(e.target);
	        // Get the BootstrapValidator instance
	        var bv = $form.data('bootstrapValidator');
	        var userinfomodifyb=$('#userinfomodifyb');
	        userinfomodifyb.button('loading');
	        //提交服务器
	        $("#userinfo #userinfoForm").btnAjaxSubmit({
	        	success:function(data){
	        		if(data.status == 1){
	        			bv.resetForm();
	        			$.showPop('修改成功',"",2000);
	        			window.setTimeout(function(){
	        				window.location.reload();
	        			},2000);
	        		}else{
	        			$.alert(data.message);
	        		}
	        		
	        	},
				complete:function () {
					userinfomodifyb.button('reset');
				}
	        });
		});
});