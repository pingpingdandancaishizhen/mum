function formatTreeDataRoot(treeData){
	var tree = [];
	if(treeData.nodes){
		tree.push({
			id : treeData.id,
			text :treeData.deptName,
			deptShortName :treeData.deptShortName,
			level :treeData.level,
			deptCode :treeData.deptCode,
			parentCode :treeData.parentCode,
			deptType :treeData.deptType,
			deptHead :treeData.deptHead,
			deptPhone :treeData.deptPhone,
			deptAddr :treeData.deptAddr,
			status :treeData.status,
			tags : ["level"+treeData.level],
			// 禁用部门 背景置灰
			backColor : (treeData.status == "1" )? "#bfbfbf" :"",
			nodes : formatTreeDataLeaf(treeData.nodes ,treeData.status)
		});
	} else {
		tree.push({
			id : treeData.id,
			text :treeData.deptName ,
			deptShortName :treeData.deptShortName,
			level :treeData.level,
			deptCode :treeData.deptCode,
			parentCode :treeData.parentCode,
			deptType :treeData.deptType,
			deptHead :treeData.deptHead,
			deptPhone :treeData.deptPhone,
			deptAddr :treeData.deptAddr,
			status :treeData.status,
			// 禁用部门 背景置灰
			backColor : (treeData.status == "1" )? "#bfbfbf" :"",
			tags : ["level"+treeData.level]
		});
	}
	function formatTreeDataLeaf(treeLeaf ,parentStatus) {
		var treeNodes = [];
		for( var i in treeLeaf){
			if(treeLeaf[i].nodes && treeLeaf[i].nodes.length > 0){
				treeNodes.push({
					id : treeLeaf[i].id,
					text :treeLeaf[i].deptName,
					deptShortName :treeLeaf[i].deptShortName,
					level :treeLeaf[i].level,
					deptCode :treeLeaf[i].deptCode,
					parentCode :treeLeaf[i].parentCode,
					deptType :treeLeaf[i].deptType,
					deptHead :treeLeaf[i].deptHead,
					deptPhone :treeLeaf[i].deptPhone,
					deptAddr :treeLeaf[i].deptAddr,
					status :treeLeaf[i].status,
					tags : ["level"+treeLeaf[i].level],
					backColor : (treeLeaf[i].status == "1" )? "#bfbfbf" :"",
					selectable : (parentStatus == "1" )? false :true,
					nodes : formatTreeDataLeaf(treeLeaf[i].nodes ,treeLeaf[i].status)
				});
			} else {
				treeNodes.push({
					id : treeLeaf[i].id,
					text :treeLeaf[i].deptName,
					deptShortName :treeLeaf[i].deptShortName,
					level :treeLeaf[i].level,
					deptCode :treeLeaf[i].deptCode,
					parentCode :treeLeaf[i].parentCode,
					deptType :treeLeaf[i].deptType,
					deptHead :treeLeaf[i].deptHead,
					deptPhone :treeLeaf[i].deptPhone,
					deptAddr :treeLeaf[i].deptAddr,
					status :treeLeaf[i].status,
					backColor : (treeLeaf[i].status == "1" )? "#bfbfbf" :"",
					selectable : (parentStatus == "1" )? false :true,
					tags : ["level"+treeLeaf[i].level]
				});
			}
		}
		return treeNodes;
	}
	return tree;
}

function showModifyModal(row) {
    $('#modifyRoleModal').showModal();
    $.when(worf.getAllDepts(function (data) {
	    	if(data.status==1){
				// tree = $('#modifyRoleModal #depts').treeview({
				// 	 data: formatTreeDataRoot(data.data),
				// 	 levels : 5,
				// 	 multiSelect : true,
				// 	 showTags :true
				//  });
				// $('#modifyRoleModal #depts').on('nodeSelected', function(event, data) {
				// 	var node = $('#modifyRoleModal #depts').treeview("getSelected");
				// 	var depts = [];
				// 	for(var i in node){
				// 		depts.push(node[i].id);
				// 	}
				// 	$("#modifyRoleModal #deptStr").val(depts.join(","));
				// });
				// $('#modifyRoleModal #depts').on('nodeUnselected', function(event, data) {
				// 	var node = $('#modifyRoleModal #depts').treeview("getSelected");
				// 	var depts = [];
				// 	for(var i in node){
				// 		depts.push(node[i].id);
				// 	}
				// 	$("#modifyRoleModal #deptStr").val(depts.join(","));
				// });
			    treeTableHtml('#modifyRoleModal',data.data,function (depts) {
				    $("#modifyRoleModal #deptStr").val(depts.join(","));
			    })
			}else{
				$.alert(data.message);
			}
		}), 
		getModifyRole(row), 
		getFuncMenuByRole(row)
    ).done(function (v1, v2 ,v3) {
        //查询角色信息，拥有的角色后操作
        var modifyRole = v2[0];
        
        if (modifyRole.status == 1) {
            var role = modifyRole.data;
            $("#modifyRoleModal #id").val(row.id);
            $("#modifyRoleModal #roleName").val(role.roleName);
            $("#modifyRoleModal #desc").val(role.desc == null ? '' : role.desc);
            $("#modifyRoleModal input[name=selfOnly]").prop("checked", role.selfOnly == 1).trigger('change');
            $("#modifyRoleModal input[name=deptOnly]").prop("checked", role.deptOnly == 1).trigger('change');
        }
        
        var deptsInfo = v3[0];
        if (deptsInfo.status == 1) {
            var depts = deptsInfo.data;
			var nodeId=[];
            for(var i in depts){
            	var deptCode=depts[i].deptCode
	            var deptId=depts[i].id;
	            nodeId.push(deptId)
	            $('#modifyRoleModal #treeTableHtml').find('label[data-id="'+deptCode+'"] input').prop('checked',true)

            }
	        $('#modifyRoleModal #deptStr').val(nodeId.join(","));
            /*$('#modifyRoleModal #deptStr').val(nodeId.join(","));
            $.each($('#modifyRoleModal #depts').treeview('getEnabled'),function(index,item){
            	for(var i in depts){
            		if(item.id == depts[i].id ){
            			$('#modifyRoleModal #depts').treeview('selectNode', [item,{ silent: true }]);
            		}
            	}
            });*/

        }
        
        // 注册验证
        var $form = $('#modifyRoleModal').find('form');
        $form.validate({
            roleName: {
                validators: {
                    notEmpty: {
                        message: '请输入角色名'
                    }, regexp: {
                        regexp: /^[\u4e00-\u9fa5a-zA-Z]{2,20}$/,
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
            }

        })
// 先注册监听表单验证成功事件==》验证表单
	    $form.off().on('success.form.bv', function () {
        	var depts = $("#modifyRoleModal #deptStr").val();
        	if($("#modifyRoleModal #selfOnly").is(":checked") || $("#modifyRoleModal #deptOnly").is(":checked")){
				// do nothing
			}else {
				if(depts == ""){
					$("#modifyRoleModal #validate_dept").show();
					return;
				} else {
					$("#modifyRoleModal #validate_dept").hide();
				}
			}
			
            //提交服务器封装MENUID 和 roleid
            $form.btnAjaxSubmit({
                success: function () {
                    $table.bootstrapTable('refresh');
                    $('#modifyRoleModal').hideModal();
                    worf.clearAllRole();
                    $.showPop('修改成功');
                }
            });
        });
        $("#modifyRoleModal #modifyRoleBtn").off().on('click', function () {
            var bootstrapValidator = $form.data('bootstrapValidator');
            bootstrapValidator.validate();
        });
    })
}
//查询角色拥有的菜单
function getFuncMenuByRole(row) {
    return worf.ajax({
        url: web_root + '/system/dataRole/queryDeptByDataRole',
        type: 'post',
        data: {roleId: row.id},
        success: function (data) {
        }
    });
}
//查询角色信息，拥有的角色
function getModifyRole(row) {
    return worf.ajax({
        url: web_root + '/system/dataRole/queryModifyDataRole',
        type: 'post',
        data: {roleId: row.id},
        success: function (data) {
        }
    })
}
