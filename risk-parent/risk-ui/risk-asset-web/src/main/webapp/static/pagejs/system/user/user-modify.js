
function toModifyUser(row){
	$('#modifyCorpUserModal').showModal();
	$.when(
		worf.getAllRole(function (data) {
		$("#modifyCorpUserModal #roles").empty();
		$.each(data.data,function(i,value){
			var htm = '<label class="label-box-item">'+
				'<input type="checkbox" name="roleId" value="'+value.id+'" /> '+value.roleName+
				'</label>';
			$("#modifyCorpUserModal #roles").append(htm);

		});
	})
	,worf.getAllDataRole(function (data) {
	            var roleHtml=[];
	            $.each(data.data,function(i,value){
	                var htm = '<label class="label-box-item">'+
	                    '<input type="checkbox" name="dataRoleId" value="'+value.id+'" /> '+value.roleName+
	                    '</label>';
	                roleHtml.push(htm);
	            });
	            $("#modifyCorpUserModal #dataRoles").html(roleHtml.join(''));
	        })
	,getUserDetail(row)).done(function (v1,vdr,v2) {
		var data=v2[0];
		if(data.status==1){
			var user = data.data;
			$('#modifyCorpUserModal #id').val(user.id);
			$('#modifyCorpUserModal #userAccount').val(user.userAccount);
			$('#modifyCorpUserModal #userName').val(user.userName);
			$('#modifyCorpUserModal #email').val(user.email);
			$('#modifyCorpUserModal #desc').val(user.desc);
			$('#modifyCorpUserModal #idcard').val(user.idcard);
			$('#modifyCorpUserModal #telephone').val(user.telephone);
			$('#modifyCorpUserModal #job').val(user.job);
			$('#modifyCorpUserModal #deptId').val(user.deptId);
			$('#modifyCorpUserModal #deptName').val(user.deptName);
			$.each(user.roleIds,function(i,value){
				$("#modifyCorpUserModal #roles input[value='"+value+"']").prop("checked",true).parent().addClass('active');
			});
			$.each(user.dataRoleIds,function(i,value){
				// console.info(value);
				$("#modifyCorpUserModal #dataRoles input[value='"+value+"']").prop("checked",true).parent().addClass('active');
			});
			
		}
		var $form=$('#modifyCorpUserModal').find('form');
		$form.validate({
			userAccount:{
				validators: {
					notEmpty: {
						message: '请输入登录名'
					},regexp:{
						regexp :/^[a-zA-Z0-9_\-\.]{2,20}$/i,
						message: '请输入2-20个字符'
					},remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
						url: web_root+'/system/user/checkAccountExist',//验证地址
						message: '登录名已存在',//提示消息
						delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type: 'POST',//请求方式
						threshold:4,//输入多少个字符后才请求服务器
						data: function(validator) {
							return {
								account: $("#modifyCorpUserModal").find("#userAccount").val(),
								id:$("#modifyCorpUserModal").find("#id").val()
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
			deptName:{
				trigger:"change",
				validators: {
					notEmpty: {
						message: '请选择部门'
					}
				}
			}


		});
		//先注册监听表单验证成功事件==》验证表单
		$form.off().on('success.form.bv',function () {
			//提交服务器
			$form.btnAjaxSubmit({
				success:function(){
					$table.bootstrapTable('refresh');
					$('#modifyCorpUserModal').hideModal();
					$.showPop('修改成功','',1000);
					worf.clearAllRole();
				}
			});
		})
		// 绑定提交按钮
		$("#modifyCorpUserModal #modifyCorpUserBtn").off().on('click',function () {
			var bootstrapValidator=$form.data('bootstrapValidator');
			bootstrapValidator.validate();
		});
		$("#modifyCorpUserModal #deptName").off().on("click",function(){
			$("#deptModal").showModal();
		});
		
		$("#modifyCorpUserModal #deptName").on("change",function(){
        	var deptId = $("#modifyCorpUserModal #deptId").val();
        	initMetaNodesSelector(deptId);
        });
        
		function initMetaNodesSelector(deptId,fn){
			var deptId = $("#modifyCorpUserModal #deptId").val();
        	worf.ajax({
    			url : web_root+'/system/user/loadNodeSelect?deptId='+deptId,
    			type : 'get',
    			aysc:false,
    			success : function(data) {
    				var htm =createTableHtml(data.data);
    				$("#modifyCorpUserModal #metaNodes").empty();
    				$("#modifyCorpUserModal #metaNodes").append(htm);
    				if(fn){
    					fn();
    				}
    			}
    		});
		}
		
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
        
        initMetaNodesSelector(deptId,function(){
        	worf.ajax({
    			url : web_root+'/system/user/queryUserMetaNode?userId='+$("#modifyCorpUserModal #id").val(),
    			type : 'get',
    			aysc : false,
    			success : function(data) {
    				$.each(data.data,function(i,val){
						$("#modifyCorpUserModal input[name='nodes'][value='"+ val.bpDefId + ";"+val.nodeId +"']").attr("checked",true).prop("checked",true);
					});
    			}
    		});
        });
	});
}

//获取修改员工的详情
function getUserDetail(row) {
	return worf.ajax({
		url : web_root+'/system/user/getUserById',
		type : 'post',
		data : {userId:row.id},
		success : function(data) {
		}
	});
}