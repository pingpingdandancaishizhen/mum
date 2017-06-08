$(function(){
	$("#add_user_btn").click(function(){
		$('#addCorpUserModal').showModal();
        //获取公司所有角色
        $.when(
    		worf.getAllRole(function (data) {
	            var roleHtml=[];
	            $.each(data.data,function(i,value){
	                var htm = '<label class="label-box-item">'+
	                    '<input type="checkbox" name="roleId" value="'+value.id+'" /> '+value.roleName+
	                    '</label>';
	                roleHtml.push(htm);
	            });
	            $("#addCorpUserModal #roles").html(roleHtml.join(''));
	        }),worf.getAllDataRole(function (data) {
	            var roleHtml=[];
	            $.each(data.data,function(i,value){
	                var htm = '<label class="label-box-item">'+
	                    '<input type="checkbox" name="dataRoleId" value="'+value.id+'" /> '+value.roleName+
	                    '</label>';
	                roleHtml.push(htm);
	            });
	            $("#addCorpUserModal #dataRoles").html(roleHtml.join(''));
	        })
        ).done(function () {
            // 注册验证
            var $form=$('#addCorpUserModal').find('form');
            $form.resetForm();
            $form.validate({
                userAccount:{
                    validators: {
                        notEmpty: {
                            message: '请输入登录名'
                        },regexp:{
                            regexp :/^[a-zA-Z0-9_\-\.]{2,20}$/i,
                            message: '请输入2-20英文字符或数字'
                        },remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            url: web_root+'/system/user/checkAccountExist',//验证地址
                            message: '登录名已存在',//提示消息
                            delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                            type: 'POST',//请求方式
                            threshold:4,//输入多少个字符后才请求服务器
                            data: function(validator) {
                                return {
                                    account: $("#addCorpUserModal").find("#userAccount").val()
                                };
                            }
                        }
                    }
                },
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
                            message: '请输入2-20个字符,只支持中文英文'
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
                },
                roleId:{
                    validators:{
                        choice:{
                            min:1,message:'请选择最少一个角色'
                        }
                    }
                },
                dataRoleId:{
                    validators:{
                        choice:{
                            min:1,message:'请选择最少一个数据角色'
                        }
                    }
                },
                password:{
                    validators: {
                        regexp: {
                            regexp:/^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\(\)])+$)([^(0-9a-zA-Z)]|[\(\)]|[a-zA-Z]|[0-9]){6,20}$/,
                            message: '请输入6-20位字母/数字/符号的任意组合'
                        }
                    }
                },
                deptName:{
                    trigger: 'change',
                    validators: {
                        notEmpty: {
                            message: '请选择部门'
                        }
                    }
                }
            });
            // 先注册监听表单验证成功事件==》验证表单
            $form.off().on('success.form.bv',function () {
                //提交服务器
                $("#addCorpUserModal #addCorpUserForm").btnAjaxSubmit({
                    success:function(data){
                        $table.bootstrapTable('refresh');
                        $('#addCorpUserModal').hideModal();
                        $.showPop('新增员工成功');
                    }
                });
            });
            // 绑定提交按钮
            $("#addCorpUserModal #saveCorpUserBtn").off().on('click',function () {
                var bootstrapValidator=$form.data('bootstrapValidator');
                bootstrapValidator.validate();

            })
            $("#addCorpUserModal #deptName").off('click').on("click",function(){
                $("#deptModal").showModal();
            });
            
            $("#addCorpUserModal #deptName").on("change",function(){
            	var deptId = $("#addCorpUserModal #deptId").val();
            	worf.ajax({
        			url : web_root+'/system/user/loadNodeSelect?deptId='+deptId,
        			type : 'get',
        			aysc:false,
        			success : function(data) {
        				var htm =createTableHtml(data.data);
        				$("#addCorpUserModal #metaNodes").empty();
        				$("#addCorpUserModal #metaNodes").append(htm);
        			}
        		});
            });
            
            function createTableHtml(data){
        		var html = "";
        		//获取流程中 节点 创建二级选项
        		function createNodeHtml(nodes ,productName){
        			var nodeshtm = '';
        			$.each(nodes,function(i,value){
        				nodeshtm += '<label class="label-box-item">'+
        				'<input type="checkbox" name="nodes" value="'+value.bpDefId+';'+value.nodeId+'" /> <span>'+
        				value.nodeName+'</span></label>';
        			});
        			nodeshtm += "</br>";
        			return nodeshtm;
        		}
        		//取出流程作为一级
        		$.each(data,function(i,value){
        			var first = value.productName+"</br>";
        			first += createNodeHtml(value.bpMetaNodes,value.productName);
        			html += first;
        		});
        		return html;
        	}
        });
	});

});