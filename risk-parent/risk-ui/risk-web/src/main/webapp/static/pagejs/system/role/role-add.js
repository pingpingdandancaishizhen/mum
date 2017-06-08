$(function(){
	$("#add_role_btn").click(function(){
		$('#addRoleModal').showModal();
		//获取公司所有角色
		$.when(worf.getAllFuncMenu(function (data) {
			$("#addRoleModal #menus").empty();
			var htm =createTableHtml(data.data);
			$("#addRoleModal #menus").append(htm);
			// $("#addRoleModal #menus input").iBoxCheck()
			//绑定事件
			//一级被点击
			$("#addRoleModal #menus input[data-type=firmenu]").off().on('click',function(){
				//选中所有二级，再选中所有二级下的三级
				var menuid = $(this).val();
				if($(this).is(":checked")){
					$("#addRoleModal #menus input[data-type=secmenu][data-parentMenu="+menuid+"]").prop("checked",true).trigger('change');
					$("#addRoleModal #menus input[data-type=secmenu][data-parentMenu="+menuid+"]").each(function(i,value){
						$("#addRoleModal #menus input[data-type=func][data-parentMenu="+$(this).val()+"]").prop("checked",true).trigger('change');
					});
				}else{
					$("#addRoleModal #menus input[data-type=secmenu][data-parentMenu="+menuid+"]").prop("checked",false).trigger('change');
					$("#addRoleModal #menus input[data-type=secmenu][data-parentMenu="+menuid+"]").each(function(i,value){
						$("#addRoleModal #menus input[data-type=func][data-parentMenu="+$(this).val()+"]").prop("checked",false).trigger('change');
					});
				}
			});
			//二级被点击
			$("#addRoleModal #menus input[data-type=secmenu]").off().on('click',function(){
				//选中所有二级，再选中所有二级下的三级
				var menuid = $(this).val();
				if($(this).is(":checked")){
					$("#addRoleModal #menus input[data-type=func][data-parentMenu="+$(this).val()+"]").prop("checked",true).trigger('change');
					$("#addRoleModal #menus input[data-type=firmenu][value="+$(this).attr("data-parentMenu")+"]").prop("checked",true).trigger('change');
				}else{
					$("#addRoleModal #menus input[data-type=func][data-parentMenu="+$(this).val()+"]").prop("checked",false).trigger('change');
					//如果二级全部被关，那么
					if($("#addRoleModal #menus input[data-type=secmenu][data-parentMenu="+$(this).attr("data-parentMenu")+"]:checked").size() == 0){
						//关闭一级
						$("#addRoleModal #menus input[data-type=firmenu][value="+$(this).attr("data-parentMenu")+"]").prop("checked",false).trigger('change');
					}
				}
			});
			//三级被点击
			$("#addRoleModal #menus input[data-type=func]").off().on('click',function(){
				//选中所有二级，再选中所有二级下的三级
				var menuid = $(this).attr("data-parentMenu");
				if($(this).is(":checked")){
					var sec = $("#addRoleModal #menus input[data-type=secmenu][value="+menuid+"]");
					sec.prop("checked",true).trigger('change');
					//如果一级没选中，选中一级
					$("#addRoleModal #menus input[data-type=firmenu][value="+sec.attr("data-parentMenu")+"]").prop("checked",true).trigger('change');
				}else{
					//如果三级全部被关，那么
					if($("#addRoleModal #menus input[data-type=func][data-parentMenu="+menuid+"]:checked").size() == 0){
						//关闭二级
						var sec = $("#addRoleModal #menus input[data-type=secmenu][value="+menuid+"]");
						sec.prop("checked",false).trigger('change');
						//如果二级全部被关，关闭一级
						if($("#addRoleModal #menus input[data-type=secmenu][data-parentMenu="+sec.attr("data-parentMenu")+"]:checked").size() == 0){
							//关闭一级
							$("#addRoleModal #menus input[data-type=firmenu][value="+sec.attr("data-parentMenu")+"]").prop("checked",false).trigger('change');
						}
					}
				}
			});

		})).done(function () {
			// 注册验证
			var $form=$('#addRoleModal').find('form');
			$form.resetForm();
			$form.validate({
				roleName:{
					validators: {
						notEmpty: {
							message: '请输入角色名'
						},regexp:{
							regexp :/^[\u4e00-\u9fa5a-zA-Z]{2,20}$/,
							message: '请输入2-20个中英文个字符'
						}
					}
				},
				desc: {
					message: '角色描述校验失败',
					validators: {
						stringLength: {
							min: 0,
							max: 60,
							message: '请输入0-60个字符'
						}
					}
				},
				funcId:{
					trigger:'change',
					validators: {

						choice:{
							min:1,
							max:$("#addRoleModal #menus input[data-type=func]").length,
							message:'至少选择一项权限'
						}
					}
				}

			})
			// 先注册监听表单验证成功事件==》验证表单
			$form.off().on('success.form.bv',function () {
				//提交服务器封装MENUID 和 roleid
				var menuIds = [];var funcIds=[];
				$("#addRoleModal input[name=menuId]:checked").each(function(){
					menuIds.push($(this).val());
				});
				$("#addRoleModal input[name=funcId]:checked").each(function(){
					funcIds.push($(this).val());
				});
				$("#addRoleModal #menuStr").val(menuIds.join(","));
				$("#addRoleModal #funcStr").val(funcIds.join(","));
				$form.btnAjaxSubmit({
					success:function () {
						$table.bootstrapTable('refresh');
						$('#addRoleModal').hideModal();
						worf.clearAllRole();
						$.showPop('新增角色成功');
					}
				});
			});
			$("#addRoleModal #saveRoleBtn").off().on('click',function(){
				var bootstrapValidator=$form.data('bootstrapValidator');
				bootstrapValidator.validate();
			});
		})
	});
});

