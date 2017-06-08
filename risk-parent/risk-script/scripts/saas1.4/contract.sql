/*
Navicat MySQL Data Transfer

Source Server         : risk_sit
Source Server Version : 50634
Source Host           : 172.16.88.221:3306
Source Database       : riskdb-dev

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-03-09 08:56:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cxph_contract_field_rel
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_field_rel`;
CREATE TABLE `cxph_contract_field_rel` (
  `temp_id` varchar(60) NOT NULL,
  `temp_field` varchar(128) NOT NULL COMMENT '模板字段名',
  `data_field` varchar(128) DEFAULT NULL COMMENT '数据字段名',
  `partner_role` varchar(60) DEFAULT NULL COMMENT '乙方参与角色',
  `data_source` varchar(60) DEFAULT NULL COMMENT '数据来源',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`temp_id`,`temp_field`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cxph_contract_partner
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_partner`;
CREATE TABLE `cxph_contract_partner` (
  `id` varchar(60) NOT NULL COMMENT 'uuid',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `type` int(1) DEFAULT NULL COMMENT '参与方类别',
  `name` varchar(256) DEFAULT NULL COMMENT '合作方名称',
  `code` varchar(64) DEFAULT NULL COMMENT '身份证号/机构代码',
  `coop_dept` varchar(60) DEFAULT NULL COMMENT '合作机构',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(512) DEFAULT NULL COMMENT '通讯地址',
  `addr_detail` varchar(512) DEFAULT NULL COMMENT '详细地址',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱地址',
  `fax` varchar(256) DEFAULT NULL COMMENT '传真号',
  `del_flag` int(1) DEFAULT '0' COMMENT '是否删除（0-否，1-是）',
  `seal_name` varchar(128) DEFAULT NULL COMMENT '公章文件名',
  `seal_resource` varchar(60) DEFAULT NULL COMMENT '公章资源ID',
  `sign_name` varchar(128) DEFAULT NULL COMMENT '签名文件名',
  `sign_resource` varchar(60) DEFAULT NULL COMMENT '签名资源ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `delete_time` datetime DEFAULT NULL COMMENT '失效日期',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cxph_contract_partner_role
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_partner_role`;
CREATE TABLE `cxph_contract_partner_role` (
  `id` varchar(60) NOT NULL,
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `name` varchar(256) DEFAULT NULL COMMENT '合同方名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `cxph_contract_partner_role` VALUES ('1', '1', '市场方', '2017-02-23 17:46:41');
INSERT INTO `cxph_contract_partner_role` VALUES ('2', '1', '出借人', '2017-02-23 17:46:47');
INSERT INTO `cxph_contract_partner_role` VALUES ('3', '1', '抵押权人', '2017-02-23 17:46:56');
INSERT INTO `cxph_contract_partner_role` VALUES ('4', '1', '担保方', '2017-02-23 17:47:04');
INSERT INTO `cxph_contract_partner_role` VALUES ('5', '1', '受权方', '2017-02-23 17:47:13');
INSERT INTO `cxph_contract_partner_role` VALUES ('6', '1', '资金方', '2017-02-23 17:47:21');
INSERT INTO `cxph_contract_partner_role` VALUES ('7', '1', '风控方', '2017-02-23 17:47:30');

-- ----------------------------
-- Table structure for cxph_contract_partner_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_partner_role_rel`;
CREATE TABLE `cxph_contract_partner_role_rel` (
  `partner_id` varchar(60) NOT NULL,
  `role_id` varchar(60) NOT NULL,
  PRIMARY KEY (`partner_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cxph_contract_resource
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_resource`;
CREATE TABLE `cxph_contract_resource` (
  `id` varchar(60) NOT NULL COMMENT 'ID',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `bp_id` varchar(60) DEFAULT NULL COMMENT '订单ID',
  `temp_id` varchar(60) DEFAULT NULL COMMENT '模板ID',
  `contract_no` varchar(60) DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(1024) DEFAULT NULL COMMENT '合同名称',
  `contract_type` varchar(128) DEFAULT NULL COMMENT '合同类型（借款合同，承诺函，提示函等）',
  `resource` varchar(60) DEFAULT NULL COMMENT '合同资源ID',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（1-办理中；2-已签署）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(60) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cxph_contract_temp_partner_rel
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_temp_partner_rel`;
CREATE TABLE `cxph_contract_temp_partner_rel` (
  `partner_id` varchar(60) NOT NULL COMMENT '签章ID',
  `temp_id` varchar(60) NOT NULL COMMENT '模板ID',
  `role_id` varchar(60) NOT NULL COMMENT '合同参与角色ID',
  PRIMARY KEY (`partner_id`,`temp_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for cxph_contract_template
-- ----------------------------
DROP TABLE IF EXISTS `cxph_contract_template`;
CREATE TABLE `cxph_contract_template` ( 
`id` varchar(60) NOT NULL COMMENT 'uuid', 
`corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID', 
`product` varchar(60) DEFAULT NULL COMMENT '产品', 
`template_name` varchar(128) DEFAULT NULL COMMENT '合同名称', 
`template_desc` varchar(1024) DEFAULT NULL COMMENT '合同模板描述', 
`status` int(2) DEFAULT NULL COMMENT '状态', 
`file_resource` varchar(60) DEFAULT NULL COMMENT '合同模板文件资源ID', 
`file_name` varchar(128) DEFAULT NULL COMMENT '文件名', 
`main_flag` varchar(2) DEFAULT NULL COMMENT '是否为主合同标记（0-否；1-是）', 
`create_time` datetime DEFAULT NULL COMMENT '创建时间', 
`update_time` datetime DEFAULT NULL COMMENT '更新时间', 
`invalid_time` datetime DEFAULT NULL COMMENT '失效时间', 
PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


-- ----------------------------
-- Table structure for cxph_partner_product_rel
-- ----------------------------
DROP TABLE IF EXISTS `cxph_partner_product_rel`;
CREATE TABLE `cxph_partner_product_rel` (
  `partner_id` varchar(60) DEFAULT NULL COMMENT '参与方ID',
  `product_id` varchar(60) DEFAULT NULL COMMENT '产品ID',
  `role_id` varchar(60) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgs_contract_field_rel
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_field_rel`;
CREATE TABLE `wdgs_contract_field_rel` (
  `temp_id` varchar(60) NOT NULL,
  `temp_field` varchar(128) NOT NULL COMMENT '模板字段名',
  `data_field` varchar(128) DEFAULT NULL COMMENT '数据字段名',
  `partner_role` varchar(60) DEFAULT NULL COMMENT '乙方参与角色',
  `data_source` varchar(60) DEFAULT NULL COMMENT '数据来源',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`temp_id`,`temp_field`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgs_contract_partner
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_partner`;
CREATE TABLE `wdgs_contract_partner` (
  `id` varchar(60) NOT NULL COMMENT 'uuid',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `type` int(1) DEFAULT NULL COMMENT '参与方类别',
  `name` varchar(256) DEFAULT NULL COMMENT '合作方名称',
  `code` varchar(64) DEFAULT NULL COMMENT '身份证号/机构代码',
  `coop_dept` varchar(60) DEFAULT NULL COMMENT '合作机构',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(512) DEFAULT NULL COMMENT '通讯地址',
  `addr_detail` varchar(512) DEFAULT NULL COMMENT '详细地址',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱地址',
  `fax` varchar(256) DEFAULT NULL COMMENT '传真号',
  `del_flag` int(1) DEFAULT '0' COMMENT '是否删除（0-否，1-是）',
  `seal_name` varchar(128) DEFAULT NULL COMMENT '公章文件名',
  `seal_resource` varchar(60) DEFAULT NULL COMMENT '公章资源ID',
  `sign_name` varchar(128) DEFAULT NULL COMMENT '签名文件名',
  `sign_resource` varchar(60) DEFAULT NULL COMMENT '签名资源ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `delete_time` datetime DEFAULT NULL COMMENT '失效日期',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgs_contract_partner_role
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_partner_role`;
CREATE TABLE `wdgs_contract_partner_role` (
  `id` varchar(60) NOT NULL,
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `name` varchar(256) DEFAULT NULL COMMENT '合同方名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `wdgs_contract_partner_role` VALUES ('1', '0', '市场方', '2017-02-23 17:46:41');
INSERT INTO `wdgs_contract_partner_role` VALUES ('2', '0', '出借人', '2017-02-23 17:46:47');
INSERT INTO `wdgs_contract_partner_role` VALUES ('3', '0', '抵押权人', '2017-02-23 17:46:56');
INSERT INTO `wdgs_contract_partner_role` VALUES ('4', '0', '担保方', '2017-02-23 17:47:04');
INSERT INTO `wdgs_contract_partner_role` VALUES ('5', '0', '受权方', '2017-02-23 17:47:13');
INSERT INTO `wdgs_contract_partner_role` VALUES ('6', '0', '资金方', '2017-02-23 17:47:21');
INSERT INTO `wdgs_contract_partner_role` VALUES ('7', '0', '风控方', '2017-02-23 17:47:30');

-- ----------------------------
-- Table structure for wdgs_contract_partner_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_partner_role_rel`;
CREATE TABLE `wdgs_contract_partner_role_rel` (
  `partner_id` varchar(60) NOT NULL,
  `role_id` varchar(60) NOT NULL,
  PRIMARY KEY (`partner_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgs_contract_resource
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_resource`;
CREATE TABLE `wdgs_contract_resource` (
  `id` varchar(60) NOT NULL COMMENT 'ID',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `bp_id` varchar(60) DEFAULT NULL COMMENT '订单ID',
  `temp_id` varchar(60) DEFAULT NULL COMMENT '模板ID',
  `contract_no` varchar(60) DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(1024) DEFAULT NULL COMMENT '合同名称',
  `contract_type` varchar(128) DEFAULT NULL COMMENT '合同类型（借款合同，承诺函，提示函等）',
  `resource` varchar(60) DEFAULT NULL COMMENT '合同资源ID',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（1-办理中；2-已签署）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(60) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgs_contract_temp_partner_rel
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_temp_partner_rel`;
CREATE TABLE `wdgs_contract_temp_partner_rel` (
  `partner_id` varchar(60) NOT NULL COMMENT '签章ID',
  `temp_id` varchar(60) NOT NULL COMMENT '模板ID',
  `role_id` varchar(60) NOT NULL COMMENT '合同参与角色ID',
  PRIMARY KEY (`partner_id`,`temp_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for wdgs_contract_template
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_contract_template`;
CREATE TABLE `wdgs_contract_template` ( 
`id` varchar(60) NOT NULL COMMENT 'uuid', 
`corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID', 
`product` varchar(60) DEFAULT NULL COMMENT '产品', 
`template_name` varchar(128) DEFAULT NULL COMMENT '合同名称', 
`template_desc` varchar(1024) DEFAULT NULL COMMENT '合同模板描述', 
`status` int(2) DEFAULT NULL COMMENT '状态', 
`file_resource` varchar(60) DEFAULT NULL COMMENT '合同模板文件资源ID', 
`file_name` varchar(128) DEFAULT NULL COMMENT '文件名', 
`main_flag` varchar(2) DEFAULT NULL COMMENT '是否为主合同标记（0-否；1-是）', 
`create_time` datetime DEFAULT NULL COMMENT '创建时间', 
`update_time` datetime DEFAULT NULL COMMENT '更新时间', 
`invalid_time` datetime DEFAULT NULL COMMENT '失效时间', 
PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


-- ----------------------------
-- Table structure for wdgs_partner_product_rel
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_partner_product_rel`;
CREATE TABLE `wdgs_partner_product_rel` (
  `partner_id` varchar(60) DEFAULT NULL COMMENT '参与方ID',
  `product_id` varchar(60) DEFAULT NULL COMMENT '产品ID',
  `role_id` varchar(60) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for ddk_contract_field_rel
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_field_rel`;
CREATE TABLE `ddk_contract_field_rel` (
  `temp_id` varchar(60) NOT NULL,
  `temp_field` varchar(128) NOT NULL COMMENT '模板字段名',
  `data_field` varchar(128) DEFAULT NULL COMMENT '数据字段名',
  `partner_role` varchar(60) DEFAULT NULL COMMENT '乙方参与角色',
  `data_source` varchar(60) DEFAULT NULL COMMENT '数据来源',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`temp_id`,`temp_field`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddk_contract_partner
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_partner`;
CREATE TABLE `ddk_contract_partner` (
  `id` varchar(60) NOT NULL COMMENT 'uuid',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `type` int(1) DEFAULT NULL COMMENT '参与方类别',
  `name` varchar(256) DEFAULT NULL COMMENT '合作方名称',
  `code` varchar(64) DEFAULT NULL COMMENT '身份证号/机构代码',
  `coop_dept` varchar(60) DEFAULT NULL COMMENT '合作机构',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(512) DEFAULT NULL COMMENT '通讯地址',
  `addr_detail` varchar(512) DEFAULT NULL COMMENT '详细地址',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱地址',
  `fax` varchar(256) DEFAULT NULL COMMENT '传真号',
  `del_flag` int(1) DEFAULT '0' COMMENT '是否删除（0-否，1-是）',
  `seal_name` varchar(128) DEFAULT NULL COMMENT '公章文件名',
  `seal_resource` varchar(60) DEFAULT NULL COMMENT '公章资源ID',
  `sign_name` varchar(128) DEFAULT NULL COMMENT '签名文件名',
  `sign_resource` varchar(60) DEFAULT NULL COMMENT '签名资源ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `delete_time` datetime DEFAULT NULL COMMENT '失效日期',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddk_contract_partner_role
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_partner_role`;
CREATE TABLE `ddk_contract_partner_role` (
  `id` varchar(60) NOT NULL,
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `name` varchar(256) DEFAULT NULL COMMENT '合同方名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `ddk_contract_partner_role` VALUES ('1', '2', '市场方', '2017-02-23 17:46:41');
INSERT INTO `ddk_contract_partner_role` VALUES ('2', '2', '出借人', '2017-02-23 17:46:47');
INSERT INTO `ddk_contract_partner_role` VALUES ('3', '2', '抵押权人', '2017-02-23 17:46:56');
INSERT INTO `ddk_contract_partner_role` VALUES ('4', '2', '担保方', '2017-02-23 17:47:04');
INSERT INTO `ddk_contract_partner_role` VALUES ('5', '2', '受权方', '2017-02-23 17:47:13');
INSERT INTO `ddk_contract_partner_role` VALUES ('6', '2', '资金方', '2017-02-23 17:47:21');
INSERT INTO `ddk_contract_partner_role` VALUES ('7', '2', '风控方', '2017-02-23 17:47:30');

-- ----------------------------
-- Table structure for ddk_contract_partner_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_partner_role_rel`;
CREATE TABLE `ddk_contract_partner_role_rel` (
  `partner_id` varchar(60) NOT NULL,
  `role_id` varchar(60) NOT NULL,
  PRIMARY KEY (`partner_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddk_contract_resource
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_resource`;
CREATE TABLE `ddk_contract_resource` (
  `id` varchar(60) NOT NULL COMMENT 'ID',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `bp_id` varchar(60) DEFAULT NULL COMMENT '订单ID',
  `temp_id` varchar(60) DEFAULT NULL COMMENT '模板ID',
  `contract_no` varchar(60) DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(1024) DEFAULT NULL COMMENT '合同名称',
  `contract_type` varchar(128) DEFAULT NULL COMMENT '合同类型（借款合同，承诺函，提示函等）',
  `resource` varchar(60) DEFAULT NULL COMMENT '合同资源ID',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（1-办理中；2-已签署）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(60) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddk_contract_temp_partner_rel
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_temp_partner_rel`;
CREATE TABLE `ddk_contract_temp_partner_rel` (
  `partner_id` varchar(60) NOT NULL COMMENT '签章ID',
  `temp_id` varchar(60) NOT NULL COMMENT '模板ID',
  `role_id` varchar(60) NOT NULL COMMENT '合同参与角色ID',
  PRIMARY KEY (`partner_id`,`temp_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for ddk_contract_template
-- ----------------------------
DROP TABLE IF EXISTS `ddk_contract_template`;
CREATE TABLE `ddk_contract_template` ( 
`id` varchar(60) NOT NULL COMMENT 'uuid', 
`corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID', 
`product` varchar(60) DEFAULT NULL COMMENT '产品', 
`template_name` varchar(128) DEFAULT NULL COMMENT '合同名称', 
`template_desc` varchar(1024) DEFAULT NULL COMMENT '合同模板描述', 
`status` int(2) DEFAULT NULL COMMENT '状态', 
`file_resource` varchar(60) DEFAULT NULL COMMENT '合同模板文件资源ID', 
`file_name` varchar(128) DEFAULT NULL COMMENT '文件名', 
`main_flag` varchar(2) DEFAULT NULL COMMENT '是否为主合同标记（0-否；1-是）', 
`create_time` datetime DEFAULT NULL COMMENT '创建时间', 
`update_time` datetime DEFAULT NULL COMMENT '更新时间', 
`invalid_time` datetime DEFAULT NULL COMMENT '失效时间', 
PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


-- ----------------------------
-- Table structure for ddk_partner_product_rel
-- ----------------------------
DROP TABLE IF EXISTS `ddk_partner_product_rel`;
CREATE TABLE `ddk_partner_product_rel` (
  `partner_id` varchar(60) DEFAULT NULL COMMENT '参与方ID',
  `product_id` varchar(60) DEFAULT NULL COMMENT '产品ID',
  `role_id` varchar(60) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




-- ----------------------------
-- Table structure for tyz_contract_field_rel
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_field_rel`;
CREATE TABLE `tyz_contract_field_rel` (
  `temp_id` varchar(60) NOT NULL,
  `temp_field` varchar(128) NOT NULL COMMENT '模板字段名',
  `data_field` varchar(128) DEFAULT NULL COMMENT '数据字段名',
  `partner_role` varchar(60) DEFAULT NULL COMMENT '乙方参与角色',
  `data_source` varchar(60) DEFAULT NULL COMMENT '数据来源',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`temp_id`,`temp_field`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tyz_contract_partner
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_partner`;
CREATE TABLE `tyz_contract_partner` (
  `id` varchar(60) NOT NULL COMMENT 'uuid',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `type` int(1) DEFAULT NULL COMMENT '参与方类别',
  `name` varchar(256) DEFAULT NULL COMMENT '合作方名称',
  `code` varchar(64) DEFAULT NULL COMMENT '身份证号/机构代码',
  `coop_dept` varchar(60) DEFAULT NULL COMMENT '合作机构',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(512) DEFAULT NULL COMMENT '通讯地址',
  `addr_detail` varchar(512) DEFAULT NULL COMMENT '详细地址',
  `email` varchar(256) DEFAULT NULL COMMENT '邮箱地址',
  `fax` varchar(256) DEFAULT NULL COMMENT '传真号',
  `del_flag` int(1) DEFAULT '0' COMMENT '是否删除（0-否，1-是）',
  `seal_name` varchar(128) DEFAULT NULL COMMENT '公章文件名',
  `seal_resource` varchar(60) DEFAULT NULL COMMENT '公章资源ID',
  `sign_name` varchar(128) DEFAULT NULL COMMENT '签名文件名',
  `sign_resource` varchar(60) DEFAULT NULL COMMENT '签名资源ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `delete_time` datetime DEFAULT NULL COMMENT '失效日期',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tyz_contract_partner_role
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_partner_role`;
CREATE TABLE `tyz_contract_partner_role` (
  `id` varchar(60) NOT NULL,
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `name` varchar(256) DEFAULT NULL COMMENT '合同方名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tyz_contract_partner_role` VALUES ('1', '3', '市场方', '2017-02-23 17:46:41');
INSERT INTO `tyz_contract_partner_role` VALUES ('2', '3', '出借人', '2017-02-23 17:46:47');
INSERT INTO `tyz_contract_partner_role` VALUES ('3', '3', '抵押权人', '2017-02-23 17:46:56');
INSERT INTO `tyz_contract_partner_role` VALUES ('4', '3', '担保方', '2017-02-23 17:47:04');
INSERT INTO `tyz_contract_partner_role` VALUES ('5', '3', '受权方', '2017-02-23 17:47:13');
INSERT INTO `tyz_contract_partner_role` VALUES ('6', '3', '资金方', '2017-02-23 17:47:21');
INSERT INTO `tyz_contract_partner_role` VALUES ('7', '3', '风控方', '2017-02-23 17:47:30');

-- ----------------------------
-- Table structure for tyz_contract_partner_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_partner_role_rel`;
CREATE TABLE `tyz_contract_partner_role_rel` (
  `partner_id` varchar(60) NOT NULL,
  `role_id` varchar(60) NOT NULL,
  PRIMARY KEY (`partner_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tyz_contract_resource
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_resource`;
CREATE TABLE `tyz_contract_resource` (
  `id` varchar(60) NOT NULL COMMENT 'ID',
  `corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID',
  `bp_id` varchar(60) DEFAULT NULL COMMENT '订单ID',
  `temp_id` varchar(60) DEFAULT NULL COMMENT '模板ID',
  `contract_no` varchar(60) DEFAULT NULL COMMENT '合同编号',
  `contract_name` varchar(1024) DEFAULT NULL COMMENT '合同名称',
  `contract_type` varchar(128) DEFAULT NULL COMMENT '合同类型（借款合同，承诺函，提示函等）',
  `resource` varchar(60) DEFAULT NULL COMMENT '合同资源ID',
  `status` varchar(2) DEFAULT NULL COMMENT '状态（1-办理中；2-已签署）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `creator` varchar(60) DEFAULT NULL COMMENT '创建者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `updater` varchar(60) DEFAULT NULL COMMENT '修改者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tyz_contract_temp_partner_rel
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_temp_partner_rel`;
CREATE TABLE `tyz_contract_temp_partner_rel` (
  `partner_id` varchar(60) NOT NULL COMMENT '签章ID',
  `temp_id` varchar(60) NOT NULL COMMENT '模板ID',
  `role_id` varchar(60) NOT NULL COMMENT '合同参与角色ID',
  PRIMARY KEY (`partner_id`,`temp_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tyz_contract_template
-- ----------------------------
DROP TABLE IF EXISTS `tyz_contract_template`;
CREATE TABLE `tyz_contract_template` ( 
`id` varchar(60) NOT NULL COMMENT 'uuid', 
`corp_id` varchar(60) DEFAULT NULL COMMENT '公司ID', 
`product` varchar(60) DEFAULT NULL COMMENT '产品', 
`template_name` varchar(128) DEFAULT NULL COMMENT '合同名称', 
`template_desc` varchar(1024) DEFAULT NULL COMMENT '合同模板描述', 
`status` int(2) DEFAULT NULL COMMENT '状态', 
`file_resource` varchar(60) DEFAULT NULL COMMENT '合同模板文件资源ID', 
`file_name` varchar(128) DEFAULT NULL COMMENT '文件名', 
`main_flag` varchar(2) DEFAULT NULL COMMENT '是否为主合同标记（0-否；1-是）', 
`create_time` datetime DEFAULT NULL COMMENT '创建时间', 
`update_time` datetime DEFAULT NULL COMMENT '更新时间', 
`invalid_time` datetime DEFAULT NULL COMMENT '失效时间', 
PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 


-- ----------------------------
-- Table structure for tyz_partner_product_rel
-- ----------------------------
DROP TABLE IF EXISTS `tyz_partner_product_rel`;
CREATE TABLE `tyz_partner_product_rel` (
  `partner_id` varchar(60) DEFAULT NULL COMMENT '参与方ID',
  `product_id` varchar(60) DEFAULT NULL COMMENT '产品ID',
  `role_id` varchar(60) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;