INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES 
('30', '1001', '订单管理', NULL, NULL, 'fa fa-object-group', '1', '0', '0', '0', '1', '0', '2');

INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES 
('31', '10010001', '订单查询', NULL, '/order/loadOrderManager', 'fa fa-circle-thin', '2', '0', '1', '1001', '1', '0', '2');

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('111', '订单查询导入excel', 'order:import', '31', '0', SYSDATE()); 

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('143', '打开导入excel页面', '/system/order/batchImport'); 

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('111', '143'); 
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('112', '订单查询编辑', 'order:edit', '31', '0', SYSDATE()); 

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('144', '进入编辑页面', '/system/order/editOrder'); 

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('112', '144'); 

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('113', '订单查询查看', 'order:view', '31', '0', SYSDATE()); 
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('145', '进入查看页面', '/system/order/viewOrder'); 
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('113', '145'); 

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('118', '订单编辑上传附件', 'order:upload', '31', '0', SYSDATE()); 

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('150', '进入查看页面', '/system/order/uploadLoanAttach'); 

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('118', '150'); 




INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES 
('32', '60000002', '日放款查询', NULL, '/loanManager/loadLoanReportPage', 'fa fa-circle-thin', '2', '0', '1', '6000', '2', '0', '1');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES 
('33', '80000002', '日还款查询', NULL, '/repayment/loadRepaymentReportPage', 'fa fa-circle-thin', '2', '0', '1', '8000', '3', '0', '1');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES 
('34', '80000003', '逾期还款查询', NULL, '/repayment/loadOverdueManagePage', 'fa fa-circle-thin', '2', '0', '1', '8000', '2', '0', '1');

INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`) SELECT id, '32', now() from risk_corp;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`) SELECT id, '33', now() from risk_corp;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`) SELECT id, '34', now() from risk_corp;


INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`)  select id,'32',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`)  select id,'33',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`)  select id,'34',now() from risk_corp_role where is_admin=1;


INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('146', '放款报表查询', '/loanManager/queryLoanReport');

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('147', '还款报表查询', '/repayment/queryRepaymentReport');

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('148', '逾期还款查询', '/repayment/queryOverdueList');

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) 
VALUES ('149', '逾期还款导出', '/repayment/exportAllOverdue');


INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('114', '放款报表查询', 'loanfk:report', '32', '0', NOW());
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('115', '还款报表查询', 'loanhk:report', '33', '0', NOW());
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('116', '逾期还款查询', 'overdue:select', '34', '0', NOW());
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) 
VALUES ('117', '逾期还款导出', 'overdue:export', '34', '0', NOW());

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('114', '146');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('115', '147');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('116', '148');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('117', '149');

INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'114',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'115',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'116',now() from `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) 
select REPLACE(UUID(),'-',''),id,'117',now() from `risk_corp`;

INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'114',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'115',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'116',now() from risk_corp_role where is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) 
select id,'117',now() from risk_corp_role where is_admin=1;






