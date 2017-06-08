function showModifyModal(row) {
    $('#modifyRoleModal').showModal();
    $.when(worf.getAllFuncMenu(function (data) {
        $("#modifyRoleModal #menus").empty();
        var htm = createTableHtml(data.data);
        //绑定事件
        $("#modifyRoleModal #menus").append(htm);
        //一级被点击
        $("#modifyRoleModal #menus input[data-type=firmenu]").off().on('click', function () {
            //选中所有二级，再选中所有二级下的三级
            var menuid = $(this).val();
            if ($(this).is(":checked")) {
                $("#modifyRoleModal #menus input[data-type=secmenu][data-parentMenu=" + menuid + "]").prop("checked", true).trigger('change');
                $("#modifyRoleModal #menus input[data-type=secmenu][data-parentMenu=" + menuid + "]").each(function (i, value) {
                    $("#modifyRoleModal #menus input[data-type=func][data-parentMenu=" + $(this).val() + "]").prop("checked", true).trigger('change');
                });

            } else {
                $("#modifyRoleModal #menus input[data-type=secmenu][data-parentMenu=" + menuid + "]").prop("checked", false).trigger('change');
                $("#modifyRoleModal #menus input[data-type=secmenu][data-parentMenu=" + menuid + "]").each(function (i, value) {
                    $("#modifyRoleModal #menus input[data-type=func][data-parentMenu=" + $(this).val() + "]").prop("checked", false).trigger('change');
                });
            }
        });
        //二级被点击
        $("#modifyRoleModal #menus input[data-type=secmenu]").off().on('click', function () {
            //选中所有二级，再选中所有二级下的三级
            var menuid = $(this).val();
            if ($(this).is(":checked")) {
                $("#modifyRoleModal #menus input[data-type=func][data-parentMenu=" + $(this).val() + "]").prop("checked", true).trigger('change');
                $("#modifyRoleModal #menus input[data-type=firmenu][value=" + $(this).attr("data-parentMenu") + "]").prop("checked", true).trigger('change');
            } else {
                $("#modifyRoleModal #menus input[data-type=func][data-parentMenu=" + $(this).val() + "]").prop("checked", false).trigger('change');
                //如果二级全部被关，那么
                if ($("#modifyRoleModal #menus input[data-type=secmenu][data-parentMenu=" + $(this).attr("data-parentMenu") + "]:checked").size() == 0) {
                    //关闭一级
                    $("#modifyRoleModal #menus input[data-type=firmenu][value=" + $(this).attr("data-parentMenu") + "]").prop("checked", false).trigger('change');
                }
            }
        });
        //三级被点击
        $("#modifyRoleModal #menus input[data-type=func]").off().on('click', function () {
            //选中所有二级，再选中所有二级下的三级
            var menuid = $(this).attr("data-parentMenu");
            if ($(this).is(":checked")) {
                var sec = $("#modifyRoleModal #menus input[data-type=secmenu][value=" + menuid + "]");
                sec.prop("checked", true).trigger('change');
                //如果一级没选中，选中一级
                $("#modifyRoleModal #menus input[data-type=firmenu][value=" + sec.attr("data-parentMenu") + "]").prop("checked", true).trigger('change');
            } else {
                //如果三级全部被关，那么
                if ($("#modifyRoleModal #menus input[data-type=func][data-parentMenu=" + menuid + "]:checked").size() == 0) {
                    //关闭二级
                    var sec = $("#modifyRoleModal #menus input[data-type=secmenu][value=" + menuid + "]");
                    sec.prop("checked", false).trigger('change');
                    //如果二级全部被关，关闭一级
                    if ($("#modifyRoleModal #menus input[data-type=secmenu][data-parentMenu=" + sec.attr("data-parentMenu") + "]:checked").size() == 0) {
                        //关闭一级
                        $("#modifyRoleModal #menus input[data-type=firmenu][value=" + sec.attr("data-parentMenu") + "]").prop("checked", false).trigger('change');
                    }
                }
            }
        });

    }), getModifyRole(row), getFuncMenuByRole(row)).done(function (v1, v2, v3) {
        //查询角色信息，拥有的角色后操作
        var modifyRole = v2[0];
        // console.log(v2, v3)
        if (modifyRole.status == 1) {
            var role = modifyRole.data;
            $("#modifyRoleModal #id").val(row.id);
            $("#modifyRoleModal #roleName").val(role.roleName);
            $("#modifyRoleModal #desc").val(role.desc == null ? '' : role.desc);
        }
        //查询角色拥有的菜单 后操作
        var funcMenuByRoleData = v3[0];
        if (funcMenuByRoleData.status == 1) {
            var menus = funcMenuByRoleData.data;
            $.each(menus, function (i, value) {
                $("#modifyRoleModal input[name=menuId][value=" + value.id + "]").prop("checked", true).trigger('change');
                var funcs = value.funcList;
                $.each(funcs, function (i, valued) {
                    $("#modifyRoleModal input[name=funcId][value=" + valued.id + "]").prop("checked", true).trigger('change');
                });
            });
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
            },
            funcId: {
	            trigger: 'change',
                validators: {

                    choice: {
                        min: 1,
                        max: $("#modifyRoleModal #menus input[data-type=func]").length,
                        message: '至少选择一项权限'
                    }
                }
            }

        })
// 先注册监听表单验证成功事件==》验证表单
        $form.off().on('success.form.bv', function () {
            //提交服务器封装MENUID 和 roleid
            var menuIds = [];
            var funcIds = [];
            $("#modifyRoleModal input[name=menuId]:checked").each(function () {
                menuIds.push($(this).val());
            });
            $("#modifyRoleModal input[name=funcId]:checked").each(function () {
                funcIds.push($(this).val());
            });
            $("#modifyRoleModal #menuStr").val(menuIds.join(","));
            $("#modifyRoleModal #funcStr").val(funcIds.join(","));
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
        url: web_root + '/system/role/queryFuncMenuByRole',
        type: 'post',
        data: {roleId: row.id},
        success: function (data) {
        }
    });
}
//查询角色信息，拥有的角色
function getModifyRole(row) {
    return worf.ajax({
        url: web_root + '/system/role/queryModifyRole',
        type: 'post',
        data: {roleId: row.id},
        success: function (data) {
        }
    })
}
