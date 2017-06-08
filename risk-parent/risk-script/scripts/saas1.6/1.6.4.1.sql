ALTER TABLE `cxfq_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;

ALTER TABLE `cxph_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;

ALTER TABLE `ddk_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;

ALTER TABLE `dsqx_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;

ALTER TABLE `myd_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;

ALTER TABLE `tyz_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;

ALTER TABLE `wdgs_customers`
ADD COLUMN `age`  int(4) NULL COMMENT '年龄' AFTER `gender`,
ADD COLUMN `birthday`  date NULL COMMENT '生日' AFTER `age`,
ADD COLUMN `idCard_vaild`  date NULL COMMENT '身份证有效期' AFTER `birthday`,
ADD COLUMN `job_type`  varchar(4) NULL COMMENT '职业身份' AFTER `dept_name`,
ADD COLUMN `job_title`  varchar(10) NULL COMMENT '职称' AFTER `job`,
ADD COLUMN `credit_report`  varchar(255) NULL COMMENT '征信报告资源id' AFTER `id_card_back`,
ADD COLUMN `resource_id`  varchar(255) NULL COMMENT '社保流水/营业执照资源Id' AFTER `credit_report`;


DROP TABLE IF EXISTS `cxfq_cust_contact`;
CREATE TABLE `cxfq_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cxph_cust_contact`;
CREATE TABLE `cxph_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ddk_cust_contact`;
CREATE TABLE `ddk_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `dsqx_cust_contact`;
CREATE TABLE `dsqx_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `myd_cust_contact`;
CREATE TABLE `myd_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tyz_cust_contact`;
CREATE TABLE `tyz_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wdgs_cust_contact`;
CREATE TABLE `wdgs_cust_contact` (
  `id` varchar(60) NOT NULL,
  `cust_id` varchar(60) NOT NULL COMMENT '客户id',
  `index` int(2) NOT NULL,
  `relation` varchar(4) DEFAULT NULL COMMENT '关系',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `is_know` tinyint(2) DEFAULT NULL COMMENT '是否知情',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `company` varchar(60) DEFAULT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES ('85', '9000', '综合查询', NULL, NULL, 'icon-general-info', '1', '0', '1', '0', '10', '0', '1');
INSERT INTO `risk_system_menu` (`id`, `menu_code`, `menu_name`, `system_type`, `action_url`, `menu_img`, `menu_level`, `is_active`, `is_leaf`, `parent_code`, `display_order`, `menu_type`, `system_id`) VALUES ('86', '90000001', '综合查询', NULL, '/generalinfo/loadGeneralInfoManager', 'icon-assert-manager', '2', '0', '1', '9000', '1', '0', '1');

INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`) SELECT id,'85',now() FROM `risk_corp`;
INSERT INTO `risk_corp_menu_rel` (`corp_id`, `menu_id`, `create_time`) SELECT id,'86',now() FROM `risk_corp`;

INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) SELECT id,'85',now() FROM risk_corp_role WHERE is_admin=1;
INSERT INTO `risk_corp_role_menu_rel` (`role_id`, `menu_id`, `create_time`) SELECT id,'86',now() FROM risk_corp_role WHERE is_admin=1;

INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) VALUES ('136', '显示设置', 'generalinfo:viewset', '86', '0', '2017-05-03 17:04:42');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) VALUES ('137', '查询', 'generalinfo:search', '86', '0', '2017-05-03 17:05:28');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) VALUES ('138', '导出EXCEL', 'generalinfo:export', '86', '0', '2017-05-03 17:05:47');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) VALUES ('139', '日志', 'generalinfo:log', '86', '0', '2017-05-03 17:06:17');
INSERT INTO `risk_system_func` (`id`, `func_name`, `func_code`, `menu_id`, `is_active`, `create_time`) VALUES ('140', '查看', 'generalinfo:view', '86', '0', '2017-05-03 17:06:47');

INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) SELECT id,'136',now() FROM risk_corp_role WHERE is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) SELECT id,'137',now() FROM risk_corp_role WHERE is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) SELECT id,'138',now() FROM risk_corp_role WHERE is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) SELECT id,'139',now() FROM risk_corp_role WHERE is_admin=1;
INSERT INTO `risk_corp_role_func_rel` (`role_id`, `func_id`, `create_time`) SELECT id,'140',now() FROM risk_corp_role WHERE is_admin=1;

INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) SELECT REPLACE(UUID(),'-',''),id,'136',now() FROM `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) SELECT REPLACE(UUID(),'-',''),id,'137',now() FROM `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) SELECT REPLACE(UUID(),'-',''),id,'138',now() FROM `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) SELECT REPLACE(UUID(),'-',''),id,'139',now() FROM `risk_corp`;
INSERT INTO `risk_corp_func_rel` (`id`, `corp_id`, `func_id`, `create_time`) SELECT REPLACE(UUID(),'-',''),id,'140',now() FROM `risk_corp`;

INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) VALUES ('162', '导出excel', '/generalinfo/exportAllList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) VALUES ('163', '加载综合查询页面', '/generalinfo/loadGeneralInfoManager');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) VALUES ('164', '查询最新订单数据', '/generalinfo/queryNewList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) VALUES ('165', '查询历史订单数据', '/generalinfo/queryExtList');
INSERT INTO `risk_system_url` (`url_id`, `url_name`, `action_url`) VALUES ('166', '获取查询条件', '/generalinfo/getBpMetaNodesByProduct');

INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('137', '163');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('137', '164');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('137', '165');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('137', '166');
INSERT INTO `risk_system_func_url_rel` (`func_id`, `url_id`) VALUES ('138', '162');



UPDATE `risk_system_menu` SET display_order = (display_order + 1) where display_order > 3;

UPDATE `risk_system_menu` SET display_order = 4 where menu_code = '9000';


ALTER TABLE `cxfq_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

ALTER TABLE `cxph_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

ALTER TABLE `ddk_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

ALTER TABLE `dsqx_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

ALTER TABLE `myd_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

ALTER TABLE `tyz_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

ALTER TABLE `wdgs_customers`
MODIFY COLUMN `name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL AFTER `type`;

