
-- ----------------------------
-- Records of rjs_role
-- ----------------------------
INSERT INTO `rjs_role` VALUES ('1', '系统管理员', '系统管理员', '0', null, null);

-- ----------------------------
-- Records of rjs_role_func_rel
-- ----------------------------
INSERT INTO `rjs_role_func_rel` VALUES ('1', '1', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '3', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '9', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '24', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '51', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '61', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '62', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '63', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '65', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '66', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '67', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '68', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '69', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '70', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '71', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '73', null);
INSERT INTO `rjs_role_func_rel` VALUES ('1', '75', null);

-- ----------------------------
-- Records of rjs_role_menu_rel
-- ----------------------------
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '1', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '2', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '3', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '4', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '6', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '7', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '12', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '13', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '15', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '16', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '17', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '18', null);
INSERT INTO `rjs_role_menu_rel` VALUES ('1', '19', null);

-- ----------------------------
-- Records of rjs_system_func
-- ----------------------------
INSERT INTO `rjs_system_func` VALUES ('1', '工会banner查看', 'labourBanner:load', '19', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('3', 'XX11查看', 'activity:load', '3', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('9', 'XX12查看', 'clubActivity:load', '4', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('24', 'XX21查看', 'photo:load', '7', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('51', 'XX31查看', 'perspectives:load', '13', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('61', '用户查看', 'user:load', '16', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('62', '用户新增', 'user:add', '16', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('63', '用户更新', 'user:modify', '16', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('64', '启用/禁用', 'user:active', '16', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('65', '角色查看', 'role:load', '17', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('66', '角色新增', 'role:add', '17', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('67', '用户删除', 'user:delete', '16', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('68', '启用/禁用', 'role:active', '17', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('69', '角色修改', 'role:modify', '17', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('70', '权限查看', 'func:load', '18', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('71', '权限修改', 'func:save', '18', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('72', '用户详情', 'user:detail', '16', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('73', '文化banner查看', 'cultureBanner:load', '19', '0', CURRENT_TIMESTAMP());
INSERT INTO `rjs_system_func` VALUES ('75', '公益banner查看', 'pubwealBanner:load', '19', '0', CURRENT_TIMESTAMP());

-- ----------------------------
-- Records of rjs_system_func_url_rel
-- ----------------------------
INSERT INTO `rjs_system_func_url_rel` VALUES ('1', '12');
INSERT INTO `rjs_system_func_url_rel` VALUES ('3', '13');
INSERT INTO `rjs_system_func_url_rel` VALUES ('9', '14');
INSERT INTO `rjs_system_func_url_rel` VALUES ('24', '15');
INSERT INTO `rjs_system_func_url_rel` VALUES ('51', '16');
INSERT INTO `rjs_system_func_url_rel` VALUES ('61', '10');
INSERT INTO `rjs_system_func_url_rel` VALUES ('62', '11');
INSERT INTO `rjs_system_func_url_rel` VALUES ('64', '18');
INSERT INTO `rjs_system_func_url_rel` VALUES ('65', '17');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '1');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '2');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '3');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '4');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '5');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '6');
INSERT INTO `rjs_system_func_url_rel` VALUES ('70', '7');
INSERT INTO `rjs_system_func_url_rel` VALUES ('71', '8');
INSERT INTO `rjs_system_func_url_rel` VALUES ('72', '9');
INSERT INTO `rjs_system_func_url_rel` VALUES ('73', '12');
INSERT INTO `rjs_system_func_url_rel` VALUES ('75', '12');

-- ----------------------------
-- Records of rjs_system_menu
-- ----------------------------
INSERT INTO `rjs_system_menu` VALUES ('1', '001', 'XX0管理', '0', '', null, '1', '0', '0', null, '1');
INSERT INTO `rjs_system_menu` VALUES ('2', '002', 'XX1管理', '0', null, null, '1', '0', '0', null, '2');
INSERT INTO `rjs_system_menu` VALUES ('3', '002001', 'XX11管理', '0', '/web/func1', null, '2', '0', '1', '002', '1');
INSERT INTO `rjs_system_menu` VALUES ('4', '002002', 'XX12管理', '0', '/web/func2', null, '2', '0', '1', '002', '2');
INSERT INTO `rjs_system_menu` VALUES ('6', '003', 'XX2管理', '0', null, null, '1', '0', '0', null, '3');
INSERT INTO `rjs_system_menu` VALUES ('7', '003001', 'XX21管理', '0', '/web/func3', null, '2', '0', '1', '003', '1');
INSERT INTO `rjs_system_menu` VALUES ('12', '004', 'XX3管理', '0', null, null, '1', '0', '0', null, '4');
INSERT INTO `rjs_system_menu` VALUES ('13', '004001', 'XX31管理', '0', '/web/func4', null, '2', '0', '1', '004', '1');
INSERT INTO `rjs_system_menu` VALUES ('15', '005', '用户管理', '0', null, null, '1', '0', '0', null, '5');
INSERT INTO `rjs_system_menu` VALUES ('16', '005001', '人员管理', '0', '/web/user/toUserManagePage', null, '2', '0', '1', '005', '1');
INSERT INTO `rjs_system_menu` VALUES ('17', '005002', '用户角色管理', '0', '/web/role/toRoleManagePage', null, '2', '0', '1', '005', '2');
INSERT INTO `rjs_system_menu` VALUES ('18', '005003', '权限管理', '0', '/web/func/loadFuncPage', null, '2', '0', '1', '005', '3');
INSERT INTO `rjs_system_menu` VALUES ('19', '001001', 'XX01管理', '0', '/web/func0', null, '2', '0', '1', '001', '1');

-- ----------------------------
-- Records of rjs_system_url
-- ----------------------------
INSERT INTO `rjs_system_url` VALUES ('1', '权限管理查看角色', '/web/func/loadFuncPage');
INSERT INTO `rjs_system_url` VALUES ('2', '查询角色', '/web/role/queryRole');
INSERT INTO `rjs_system_url` VALUES ('3', '加载权限树1', '/web/func/queryUserTree');
INSERT INTO `rjs_system_url` VALUES ('4', '加载权限树2', '/web/func/queryLabourTree');
INSERT INTO `rjs_system_url` VALUES ('5', '加载权限树3', '/web/func/queryCultureTree');
INSERT INTO `rjs_system_url` VALUES ('6', '加载权限树4', '/web/func/queryPubwealTree');
INSERT INTO `rjs_system_url` VALUES ('7', '查询角色权限', '/web/func/queryRoleFun');
INSERT INTO `rjs_system_url` VALUES ('8', '修改角色权限', '/web/func/saveRoleFunc');
INSERT INTO `rjs_system_url` VALUES ('9', '用户详情查看', '/web/user/toDetailPage');
INSERT INTO `rjs_system_url` VALUES ('10', '用户列表查看', '/web/user/queryUserList');
INSERT INTO `rjs_system_url` VALUES ('11', '新增用户', '/web/user/addUser');
INSERT INTO `rjs_system_url` VALUES ('12', '待实现页面', '/web/func0');
INSERT INTO `rjs_system_url` VALUES ('13', '待实现页面', '/web/func1');
INSERT INTO `rjs_system_url` VALUES ('14', '待实现页面', '/web/func2');
INSERT INTO `rjs_system_url` VALUES ('15', '待实现页面', '/web/func3');
INSERT INTO `rjs_system_url` VALUES ('16', '待实现页面', '/web/func4');
INSERT INTO `rjs_system_url` VALUES ('17', '查询角色列表', '/web/role/queryRoleList');
INSERT INTO `rjs_system_url` VALUES ('18', '修改角色状态', '/web/user/updateUserStatus');

-- ----------------------------
-- Records of rjs_user_role_rel
-- ----------------------------
INSERT INTO `rjs_user_role_rel` VALUES ('001', '1', '1', null);
INSERT INTO `rjs_user_role_rel` VALUES ('20160728105119699467', '3', '1', CURRENT_TIMESTAMP());


-- ----------------------------
-- Records of rjs_users
-- ----------------------------
INSERT INTO `rjs_users` VALUES ('001', '超级管理员', 'admin', 'A94D5CD0079CFC8DB030E1107DE1ADDD1903A01B', '325', '研发部', null, null, '1', null, null);
INSERT INTO `rjs_users` VALUES ('20160728105119699467', '测试员1', 'RJS000002', 'A94D5CD0079CFC8DB030E1107DE1ADDD1903A01B', null, '研发部', '工程师', null, '1', 'testEmployee', null);
