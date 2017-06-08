-- 增加企业配置的权限 start
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) 
VALUES ('20', '10000007', '企业配置', NULL, '/system/corp/loadCorpManager', 'fa fa-circle-thin', '2', '0', '1', '1000', '7', '0');

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('75', '企业配置修改', 'corp:modify', '20', '0', '2017-02-16 09:29:17');

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('86', '上传公司LOGO', '/system/corp/uploadCorpLogo');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('87', '修改公司配置', '/system/corp/updateCorp');

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('75', '86');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('75', '87');


INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'20',now() from `risk_corp`;

INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'75',now() from `risk_corp`;

INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'75',now() from risk_corp_role where is_admin=1;


INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'20',now() from risk_corp_role where is_admin=1;

-- 增加企业配置的权限 end

-- 增加部分产品配置功能权限 start
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('83', '产品修改基本信息', 'product:modify', '9', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('88', '修改产品基本信息配置', '/solution/product/modifyProduct');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('83', '88');
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'83',now() from `risk_corp`;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'83',now() from risk_corp_role where is_admin=1;


INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('84', '产品费用配置', 'product:feeconfig', '9', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('89', '费用配置跳转', '/solution/product/loadProductFeeConfig');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('90', '修改费用配置', '/solution/product/feeConfig');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('84', '89');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('84', '90');
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'84',now() from `risk_corp`;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'84',now() from risk_corp_role where is_admin=1;


INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('85', '产品参与方配置', 'product:partnerconfig', '9', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('91', '参与方配置跳转', '/system/partner/loadProductPartnerConfig');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('92', '修改参与方配置', '/system/partner/saveProductConfig');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('93', '查询参与方配置', '/system/partner/queryConfigByProduct');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('85', '91');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('85', '92');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('85', '93');
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'85',now() from `risk_corp`;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'85',now() from risk_corp_role where is_admin=1;
-- 增加部分产品配置功能权限 end
-- 增加审核管理模块start
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) 
VALUES ('23', '7000', '审核管理', NULL, NULL, 'fa  fa-user-times', '1', '0', '0', '0', '8', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) 
VALUES ('24', '70000001', '审核查询', NULL, '/loanaudit/loadAllAuditManager', 'fa fa-circle-thin', '2', '0', '1', '7000', '1', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) 
VALUES ('25', '70000002', '我的审核', NULL, '/loanaudit/loadMyAuditManager', 'fa fa-circle-thin', '2', '0', '1', '7000', '2', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) 
VALUES ('26', '70000003', '日审核查询', NULL, '/loanaudit/loadDayAuditManager', 'fa fa-circle-thin', '2', '0', '1', '7000', '3', '0');

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('86', '审核查询', 'auditall:list', '24', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('87', '日志', 'auditall:log', '24', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('88', '我的审核', 'auditmy:list', '25', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('89', '日志', 'auditmy:log', '25', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('90', '日审核查询', 'auditday:list', '26', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('91', '查看明细', 'auditday:detail', '26', '0', '2017-02-16 09:29:17');

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('94', '审核查询', '/loanaudit/queryAllAuditManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('95', '审核历史查询', '/loanaudit/queryAllHistoryAuditManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('96', '我的审核查询', '/loanaudit/queryMyAuditManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('97', '日审核查询', '/loanaudit/queryDayAuditManager');

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('86', '94');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('86', '95');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('87', '61');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('87', '60');

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('88', '96');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('89', '61');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('89', '60');

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('90', '97');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('91', '94');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('91', '95');


INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'23',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'24',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'25',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'26',now() from `risk_corp`;

INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'86',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'87',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'88',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'89',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'90',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'91',now() from `risk_corp`;

INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'86',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'87',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'88',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'89',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'90',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'91',now() from risk_corp_role where is_admin=1;


INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'23',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'24',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'25',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'26',now() from risk_corp_role where is_admin=1;
-- 增加审核管理模块end

-- 增加参与方配置权限 start
delete from risk_system_menu where id in ('18','19');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`)
VALUES('18', '10000006', '参与方', NULL, '/system/partner/loadPartnerManager', 'fa fa-circle-thin', '2', '0', '1', '1000', '6', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`)
VALUES('19', '50000001', '合同模板', NULL, '/contract/template/loadTemplateManager', 'fa fa-circle-thin', '2', '0', '1', '5000', '1', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`)
VALUES('29', '50000002', '合同查询', NULL, '/contract/manager/loadContractManager', 'fa fa-circle-thin', '2', '0', '1', '5000', '2', '0');

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('76', '增加合同参与方', 'partner:add', '18', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('77', '修改合参与方', 'partner:edit', '18', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('78', '删除合同参与方', 'partner:delete', '18', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('79', '查看合同参与方', 'partner:view', '18', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('82', '查询合同参与方', 'partner:search', '18', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('92', '新增合同模板', 'temp:add', '19', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('93', '编辑合同模板', 'temp:edit', '19', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('94', '查看合同模板', 'temp:view', '19', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('95', '停用合同模板', 'temp:disable', '19', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('96', '配置合同模板', 'temp:config', '19', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('97', '办理中的合同', 'contract:processing', '29', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('98', '已归档的合同', 'contract:processed', '29', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('99', '日志', 'contract:log', '29', '0', '2017-02-16 09:29:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('100', '查看合同', 'contract:view', '29', '0', '2017-02-16 09:29:17');

INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'76',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'77',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'78',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'79',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'82',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'92',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'93',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'94',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'95',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'96',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'97',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'98',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'99',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'100',now() from `risk_corp`;

INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'76',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'77',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'78',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'79',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'82',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'92',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'93',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'94',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'95',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'96',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'97',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'98',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'99',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'100',now() from risk_corp_role where is_admin=1;

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('98', '删除参与方', '/system/partner/deletePartner');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('99', '获取参与方', '/system/partner/getPartner');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('100', '加载参与方初始页', '/system/partner/loadPartnerManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('101', '加载参与方产品配置页面', '/system/partner/loadProductPartnerConfig');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('102', '查询参与方列表数据', '/system/partner/queryAllPartnerList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('103', '获取参与方角色', '/system/partner/queryAllRoles');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('104', '获取已选择字段关联', '/system/partner/queryConfigByProduct');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('105', ' 查询参与方已选的角色', '/system/partner/getRoleList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('106', '根据产品获取参与方', '/system/partner/queryPartnerByProduct');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('107', '查询参与方类别列表', '/system/partner/queryPartnerRoleList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('108', '保存参与方', '/system/partner/savePartner');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('109', '保存产品关联', '/system/partner/saveProductConfig');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('111', '停用模板', '/system/template/disableTemplate');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('112', '获取模板字段', '/system/template/getTempFields');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('113', '获取合同模板', '/system/template/getTemplate');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('114', '获取查看合同模板页面数据', '/system/template/getTemplateView');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('115', '加载合同模板初始页', '/system/template/loadTemplateManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('116', '获取所有参与方', '/system/template/queryAllPartner');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('117', '查询合同模板列表数据', '/system/template/queryList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('118', '保存合同模板', '/system/template/saveTemplate');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('119', '保存字段配置', '/system/template/saveTemplateConfig');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('120', '生成合同', '/system/resource/generate');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('121', '获取合同资源', '/system/resource/queryContractByBpId');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('122', '加载合同查询页', '/system/manager/loadContractManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('123', '获取合同文件列表', '/system/manager/queryContractsByBp');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('124', '查询已归档的合同', '/system/manager/queryProcessedList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('125', '查询办理中的合同', '/system/manager/queryProcessingList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('141', '检查是否已经存在合同名', '/system/template/checkNameExist');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('142', '校验已存在的参与方名称', '/system/partner/checkNameExist');

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('76', '103');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('76', '108');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('77', '99');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('77', '103');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('77', '105');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('77', '108');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('78', '98');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('79', '99');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('82', '102');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('92', '106');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('92', '118');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('93', '106');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('93', '113');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('93', '118');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('94', '106');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('94', '114');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('95', '111');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('96', '112');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('96', '119');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('97', '125');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('98', '124');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('100', '123');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('92', '141');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('93', '141');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('76', '142');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('77', '142');

INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'17',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'18',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'19',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'29',now() from `risk_corp`;

INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'17',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'18',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'19',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'29',now() from risk_corp_role where is_admin=1;

-- 增加参与方配置权限 end


-- 放款菜单 start
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) VALUES 
('28', '80000001', '还款查询', NULL, '/repayment/loadRepaymentPage', 'fa fa-credit-card-alt', '2', '0', '1', '8000', '1', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) VALUES 
('27', '8000', '还款管理', NULL, NULL, 'fa fa-credit-card-alt', '1', '0', '0', '0', '8', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) VALUES 
('22', '60000001', '放款查询', NULL, '/loanManager/loadAllLoanPage', 'fa fa-credit-card-alt', '2', '0', '1', '6000', '1', '0');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`) VALUES 
('21', '6000', '放款管理', NULL, NULL, 'fa fa-credit-card-alt', '1', '0', '0', '0', '6', '0');
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'28',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'27',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'22',now() from `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`)
select id,'21',now() from `risk_corp`;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'28',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'27',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'22',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) 
select id,'21',now() from risk_corp_role where is_admin=1;



INSERT INTO risk_system_func VALUES ( '101', '放款查询', 'loanfk:select',
		(SELECT id FROM risk_system_menu WHERE action_url = '/loanManager/loadAllLoanPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '102', '放款计划', 'loanfk:plan',
		(SELECT id FROM risk_system_menu WHERE action_url = '/loanManager/loadAllLoanPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '103', '放款录入', 'loanfk:record',
		(SELECT id FROM risk_system_menu WHERE action_url = '/loanManager/loadAllLoanPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '104', '放款导出', 'loanfk:export',
		(SELECT id FROM risk_system_menu WHERE action_url = '/loanManager/loadAllLoanPage'), 0, NOW() );



INSERT INTO risk_system_func VALUES ( '105', '还款查询', 'loanhk:select',
		(SELECT id FROM risk_system_menu WHERE action_url = '/repayment/loadRepaymentPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '106', '还款计划', 'loanhk:plan',
		(SELECT id FROM risk_system_menu WHERE action_url = '/repayment/loadRepaymentPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '107', '正常还款录入', 'loanhk:record',
		(SELECT id FROM risk_system_menu WHERE action_url = '/repayment/loadRepaymentPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '108', '逾期还款录入', 'loanhk:overdue',
		(SELECT id FROM risk_system_menu WHERE action_url = '/repayment/loadRepaymentPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '109', '提前结清录入', 'loanhk:early',
		(SELECT id FROM risk_system_menu WHERE action_url = '/repayment/loadRepaymentPage'), 0, NOW() );

INSERT INTO risk_system_func VALUES ( '110', '放款导出', 'loanhk:export',
		(SELECT id FROM risk_system_menu WHERE action_url = '/repayment/loadRepaymentPage'), 0, NOW() );


-- INSERT INTO risk_system_url VALUES ('126' , '加载放款查询页面' ,'/loanManager/loadAllLoanPage');

INSERT INTO risk_system_url VALUES ('127' , '加载放款查询列表' ,'/loanManager/queryAllLoan');

INSERT INTO risk_system_url VALUES ('128' , '加载放款计划页面' ,'/loanManager/loadLoanPlanPage');

INSERT INTO risk_system_url VALUES ('129' , '加载放款录入页面' ,'/loanManager/loadLoanRecordPage');

INSERT INTO risk_system_url VALUES ('130' , '保存放款录入' ,'/loanManager/saveLoanRecord');

INSERT INTO risk_system_url VALUES ('131' , '放款导出' ,'/loanManager/exportAllLoan');




-- INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanfk:select') ,
-- 	(SELECT url_id FROM risk_system_url WHERE action_url = '/loanManager/loadAllLoanPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanfk:select') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/loanManager/queryAllLoan'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanfk:plan') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/loanManager/loadLoanPlanPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanfk:record') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/loanManager/loadLoanRecordPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanfk:record') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/loanManager/saveLoanRecord'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanfk:export') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/loanManager/exportAllLoan'));



-- INSERT INTO risk_system_url VALUES ('132' , '加载还款查询页面' ,'/repayment/loadRepaymentPage');

INSERT INTO risk_system_url VALUES ('133' , '加载还款查询列表' ,'/repayment/queryRepaymentList');

INSERT INTO risk_system_url VALUES ('134' , '加载还款计划页面' ,'/repayment/loadRepaymentPlanPage');

INSERT INTO risk_system_url VALUES ('135' , '加载正常还款录入页面' ,'/repayment/loadRepaymentRecordPage');

INSERT INTO risk_system_url VALUES ('136' , '保存还款录入' ,'/repayment/saveRepaymentRecord');

INSERT INTO risk_system_url VALUES ('137' , '加载逾期还款录入页面' ,'/repayment/loadOverdueRecordPage');

INSERT INTO risk_system_url VALUES ('138' , '加载提前结清录入页面' ,'/repayment/loadEarlyRecordPage');

INSERT INTO risk_system_url VALUES ('139' , '保存提前结清' ,'/repayment/saveSettlementRecord');

INSERT INTO risk_system_url VALUES ('140' , '还款导出' ,'/repayment/exportAllRepayment');



-- INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:select') ,
-- 	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/loadRepaymentPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:select') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/queryRepaymentList'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:plan') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/loadRepaymentPlanPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:record') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/loadRepaymentRecordPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:record') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/saveRepaymentRecord'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:overdue') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/loadOverdueRecordPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:overdue') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/saveRepaymentRecord'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:early') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/loadEarlyRecordPage'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:early') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/saveSettlementRecord'));

INSERT INTO risk_system_func_url_rel VALUES((SELECT id FROM risk_system_func WHERE func_code = 'loanhk:export') ,
	(SELECT url_id FROM risk_system_url WHERE action_url = '/repayment/exportAllRepayment'));

INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'101',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'102',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'103',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'104',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'105',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'106',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'107',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'108',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'109',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'110',now() from `risk_corp`;

INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'101',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'102',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'103',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'104',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'105',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'106',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'107',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'108',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'109',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'110',now() from risk_corp_role where is_admin=1;
-- 放款菜单 end