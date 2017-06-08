/*
Navicat MySQL Data Transfer

Source Server         : SAAS-dev
Source Server Version : 50634
Source Host           : 172.16.88.221:3306
Source Database       : riskdb-dev

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-03-09 09:26:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cxph_repayment_base
-- ----------------------------
DROP TABLE IF EXISTS `cxph_repayment_base`;
CREATE TABLE `cxph_repayment_base` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) NOT NULL,
  `payed_issue` int(60) NOT NULL DEFAULT '0' COMMENT '已还期次',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还本金',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还利息',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '还款状态:0还款中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cxph_repayment_detail`;
CREATE TABLE `cxph_repayment_detail` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) DEFAULT NULL COMMENT '流程号',
  `issue` int(100) DEFAULT NULL COMMENT '期次',
  `issue_date` date DEFAULT NULL COMMENT '还款日期',
  `interest` decimal(20,2) NOT NULL COMMENT '利息',
  `principle` decimal(20,2) NOT NULL COMMENT '本金',
  `manage_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `payment` decimal(20,2) NOT NULL COMMENT '月供',
  `left_principle` decimal(20,2) NOT NULL COMMENT '剩余本金',
  `is_finish` tinyint(2) NOT NULL COMMENT '是否结束',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(100) NOT NULL COMMENT '创建者',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_manage_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还管理费',
  `payed_extra_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷GPS服务费)',
  `payed_extra_fee_2` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷停车费)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cxph_repayment_settlement`;
CREATE TABLE `cxph_repayment_settlement` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) DEFAULT NULL,
  `settlement_date` date DEFAULT NULL,
  `settlement_reason` tinyint(2) NOT NULL COMMENT '结清原因',
  `settlement_principle` decimal(10,2) NOT NULL COMMENT '剩余本金',
  `settlement_interest` decimal(10,2) NOT NULL COMMENT '提前结清当期利息',
  `settlement_manage_fee` decimal(10,2) NOT NULL,
  `settlement_penalty` decimal(10,2) NOT NULL COMMENT '提前结清违约金',
  `towing_fee` decimal(10,2) DEFAULT NULL COMMENT '拖车费',
  `parking_fee` decimal(10,2) DEFAULT NULL COMMENT '停车费',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(60) NOT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `cxph_loan_fee`;
CREATE TABLE `cxph_loan_fee` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) NOT NULL,
  `fee_name` varchar(100) DEFAULT NULL COMMENT '费率名称',
  `fee_value` decimal(20,2) DEFAULT NULL COMMENT '费率值',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `cxph_repayment_record`;
CREATE TABLE `cxph_repayment_record` (
  `id` varchar(200) NOT NULL COMMENT 'ID',
  `repayment_detail_id` varchar(200) DEFAULT NULL COMMENT '还款明细ID',
  `repayment_time` datetime DEFAULT NULL COMMENT '实际还款时间',
  `repayment_principle` decimal(10,2) DEFAULT NULL COMMENT '月还款本金',
  `repayment_interest` decimal(10,2) DEFAULT NULL COMMENT '月还款利息',
  `repayment_manage_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款管理费',
  `repayment_extra_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款额外费用(GPS费)',
  `repayment_extra_fee_2` decimal(10,2) DEFAULT '0.00',
  `overdue_fee` decimal(10,2) DEFAULT NULL,
  `overdue_derate` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `cxph_bp_loans`
ADD COLUMN `loan_status` tinyint(2) DEFAULT '0' COMMENT '放款状态' AFTER `apply_period`;
ALTER TABLE `cxph_bp_loans`
ADD COLUMN `loan_amount` decimal(10,2) DEFAULT NULL COMMENT '放款金额' AFTER `loan_status`;
ALTER TABLE `cxph_bp_loans`
ADD COLUMN `loan_platform` varchar(60) DEFAULT NULL COMMENT '放款平台' AFTER `loan_amount`;
ALTER TABLE `cxph_bp_loans`
ADD COLUMN `loan_lender` varchar(60) DEFAULT NULL COMMENT '放款人' AFTER `loan_platform`;
ALTER TABLE `cxph_bp_loans`
ADD COLUMN `loan_time` datetime DEFAULT NULL COMMENT '放款时间' AFTER `loan_lender`;


 

-- ----------------------------
-- Table structure for wdgs_repayment_base
-- ----------------------------
DROP TABLE IF EXISTS `wdgs_repayment_base`;
CREATE TABLE `wdgs_repayment_base` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) NOT NULL,
  `payed_issue` int(60) NOT NULL DEFAULT '0' COMMENT '已还期次',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还本金',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还利息',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '还款状态:0还款中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wdgs_repayment_detail`;
CREATE TABLE `wdgs_repayment_detail` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) DEFAULT NULL COMMENT '流程号',
  `issue` int(100) DEFAULT NULL COMMENT '期次',
  `issue_date` date DEFAULT NULL COMMENT '还款日期',
  `interest` decimal(20,2) NOT NULL COMMENT '利息',
  `principle` decimal(20,2) NOT NULL COMMENT '本金',
  `manage_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `payment` decimal(20,2) NOT NULL COMMENT '月供',
  `left_principle` decimal(20,2) NOT NULL COMMENT '剩余本金',
  `is_finish` tinyint(2) NOT NULL COMMENT '是否结束',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(100) NOT NULL COMMENT '创建者',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_manage_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还管理费',
  `payed_extra_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷GPS服务费)',
  `payed_extra_fee_2` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷停车费)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wdgs_repayment_settlement`;
CREATE TABLE `wdgs_repayment_settlement` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) DEFAULT NULL,
  `settlement_date` date DEFAULT NULL,
  `settlement_reason` tinyint(2) NOT NULL COMMENT '结清原因',
  `settlement_principle` decimal(10,2) NOT NULL COMMENT '剩余本金',
  `settlement_interest` decimal(10,2) NOT NULL COMMENT '提前结清当期利息',
  `settlement_manage_fee` decimal(10,2) NOT NULL,
  `settlement_penalty` decimal(10,2) NOT NULL COMMENT '提前结清违约金',
  `towing_fee` decimal(10,2) DEFAULT NULL COMMENT '拖车费',
  `parking_fee` decimal(10,2) DEFAULT NULL COMMENT '停车费',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(60) NOT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wdgs_loan_fee`;
CREATE TABLE `wdgs_loan_fee` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) NOT NULL,
  `fee_name` varchar(100) DEFAULT NULL COMMENT '费率名称',
  `fee_value` decimal(20,2) DEFAULT NULL COMMENT '费率值',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `wdgs_repayment_record`;
CREATE TABLE `wdgs_repayment_record` (
  `id` varchar(200) NOT NULL COMMENT 'ID',
  `repayment_detail_id` varchar(200) DEFAULT NULL COMMENT '还款明细ID',
  `repayment_time` datetime DEFAULT NULL COMMENT '实际还款时间',
  `repayment_principle` decimal(10,2) DEFAULT NULL COMMENT '月还款本金',
  `repayment_interest` decimal(10,2) DEFAULT NULL COMMENT '月还款利息',
  `repayment_manage_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款管理费',
  `repayment_extra_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款额外费用(GPS费)',
  `repayment_extra_fee_2` decimal(10,2) DEFAULT '0.00',
  `overdue_fee` decimal(10,2) DEFAULT NULL,
  `overdue_derate` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `loan_status` tinyint(2) DEFAULT '0' COMMENT '放款状态' AFTER `apply_period`;
ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `loan_amount` decimal(10,2) DEFAULT NULL COMMENT '放款金额' AFTER `loan_status`;
ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `loan_platform` varchar(60) DEFAULT NULL COMMENT '放款平台' AFTER `loan_amount`;
ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `loan_lender` varchar(60) DEFAULT NULL COMMENT '放款人' AFTER `loan_platform`;
ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `loan_time` datetime DEFAULT NULL COMMENT '放款时间' AFTER `loan_lender`;


 

-- ----------------------------
-- Table structure for ddk_repayment_base
-- ----------------------------
DROP TABLE IF EXISTS `ddk_repayment_base`;
CREATE TABLE `ddk_repayment_base` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) NOT NULL,
  `payed_issue` int(60) NOT NULL DEFAULT '0' COMMENT '已还期次',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还本金',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还利息',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '还款状态:0还款中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ddk_repayment_detail`;
CREATE TABLE `ddk_repayment_detail` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) DEFAULT NULL COMMENT '流程号',
  `issue` int(100) DEFAULT NULL COMMENT '期次',
  `issue_date` date DEFAULT NULL COMMENT '还款日期',
  `interest` decimal(20,2) NOT NULL COMMENT '利息',
  `principle` decimal(20,2) NOT NULL COMMENT '本金',
  `manage_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `payment` decimal(20,2) NOT NULL COMMENT '月供',
  `left_principle` decimal(20,2) NOT NULL COMMENT '剩余本金',
  `is_finish` tinyint(2) NOT NULL COMMENT '是否结束',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(100) NOT NULL COMMENT '创建者',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_manage_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还管理费',
  `payed_extra_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷GPS服务费)',
  `payed_extra_fee_2` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷停车费)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ddk_repayment_settlement`;
CREATE TABLE `ddk_repayment_settlement` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) DEFAULT NULL,
  `settlement_date` date DEFAULT NULL,
  `settlement_reason` tinyint(2) NOT NULL COMMENT '结清原因',
  `settlement_principle` decimal(10,2) NOT NULL COMMENT '剩余本金',
  `settlement_interest` decimal(10,2) NOT NULL COMMENT '提前结清当期利息',
  `settlement_manage_fee` decimal(10,2) NOT NULL,
  `settlement_penalty` decimal(10,2) NOT NULL COMMENT '提前结清违约金',
  `towing_fee` decimal(10,2) DEFAULT NULL COMMENT '拖车费',
  `parking_fee` decimal(10,2) DEFAULT NULL COMMENT '停车费',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(60) NOT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `ddk_loan_fee`;
CREATE TABLE `ddk_loan_fee` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) NOT NULL,
  `fee_name` varchar(100) DEFAULT NULL COMMENT '费率名称',
  `fee_value` decimal(20,2) DEFAULT NULL COMMENT '费率值',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ddk_repayment_record`;
CREATE TABLE `ddk_repayment_record` (
  `id` varchar(200) NOT NULL COMMENT 'ID',
  `repayment_detail_id` varchar(200) DEFAULT NULL COMMENT '还款明细ID',
  `repayment_time` datetime DEFAULT NULL COMMENT '实际还款时间',
  `repayment_principle` decimal(10,2) DEFAULT NULL COMMENT '月还款本金',
  `repayment_interest` decimal(10,2) DEFAULT NULL COMMENT '月还款利息',
  `repayment_manage_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款管理费',
  `repayment_extra_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款额外费用(GPS费)',
  `repayment_extra_fee_2` decimal(10,2) DEFAULT '0.00',
  `overdue_fee` decimal(10,2) DEFAULT NULL,
  `overdue_derate` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `ddk_bp_loans`
ADD COLUMN `loan_status` tinyint(2) DEFAULT '0' COMMENT '放款状态' AFTER `apply_period`;
ALTER TABLE `ddk_bp_loans`
ADD COLUMN `loan_amount` decimal(10,2) DEFAULT NULL COMMENT '放款金额' AFTER `loan_status`;
ALTER TABLE `ddk_bp_loans`
ADD COLUMN `loan_platform` varchar(60) DEFAULT NULL COMMENT '放款平台' AFTER `loan_amount`;
ALTER TABLE `ddk_bp_loans`
ADD COLUMN `loan_lender` varchar(60) DEFAULT NULL COMMENT '放款人' AFTER `loan_platform`;
ALTER TABLE `ddk_bp_loans`
ADD COLUMN `loan_time` datetime DEFAULT NULL COMMENT '放款时间' AFTER `loan_lender`;


 

-- ----------------------------
-- Table structure for tyz_repayment_base
-- ----------------------------
DROP TABLE IF EXISTS `tyz_repayment_base`;
CREATE TABLE `tyz_repayment_base` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) NOT NULL,
  `payed_issue` int(60) NOT NULL DEFAULT '0' COMMENT '已还期次',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还本金',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还利息',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '还款状态:0还款中',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tyz_repayment_detail`;
CREATE TABLE `tyz_repayment_detail` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) DEFAULT NULL COMMENT '流程号',
  `issue` int(100) DEFAULT NULL COMMENT '期次',
  `issue_date` date DEFAULT NULL COMMENT '还款日期',
  `interest` decimal(20,2) NOT NULL COMMENT '利息',
  `principle` decimal(20,2) NOT NULL COMMENT '本金',
  `manage_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `payment` decimal(20,2) NOT NULL COMMENT '月供',
  `left_principle` decimal(20,2) NOT NULL COMMENT '剩余本金',
  `is_finish` tinyint(2) NOT NULL COMMENT '是否结束',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(100) NOT NULL COMMENT '创建者',
  `payed_interest` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_principle` decimal(10,2) NOT NULL DEFAULT '0.00',
  `payed_manage_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还管理费',
  `payed_extra_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷GPS服务费)',
  `payed_extra_fee_2` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '已还额外费用(车贷停车费)',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(100) DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tyz_repayment_settlement`;
CREATE TABLE `tyz_repayment_settlement` (
  `id` varchar(60) NOT NULL,
  `bp_id` varchar(60) DEFAULT NULL,
  `settlement_date` date DEFAULT NULL,
  `settlement_reason` tinyint(2) NOT NULL COMMENT '结清原因',
  `settlement_principle` decimal(10,2) NOT NULL COMMENT '剩余本金',
  `settlement_interest` decimal(10,2) NOT NULL COMMENT '提前结清当期利息',
  `settlement_manage_fee` decimal(10,2) NOT NULL,
  `settlement_penalty` decimal(10,2) NOT NULL COMMENT '提前结清违约金',
  `towing_fee` decimal(10,2) DEFAULT NULL COMMENT '拖车费',
  `parking_fee` decimal(10,2) DEFAULT NULL COMMENT '停车费',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_by` varchar(60) NOT NULL COMMENT '创建者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `tyz_loan_fee`;
CREATE TABLE `tyz_loan_fee` (
  `id` varchar(100) NOT NULL,
  `bp_no` varchar(100) NOT NULL,
  `fee_name` varchar(100) DEFAULT NULL COMMENT '费率名称',
  `fee_value` decimal(20,2) DEFAULT NULL COMMENT '费率值',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `tyz_repayment_record`;
CREATE TABLE `tyz_repayment_record` (
  `id` varchar(200) NOT NULL COMMENT 'ID',
  `repayment_detail_id` varchar(200) DEFAULT NULL COMMENT '还款明细ID',
  `repayment_time` datetime DEFAULT NULL COMMENT '实际还款时间',
  `repayment_principle` decimal(10,2) DEFAULT NULL COMMENT '月还款本金',
  `repayment_interest` decimal(10,2) DEFAULT NULL COMMENT '月还款利息',
  `repayment_manage_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款管理费',
  `repayment_extra_fee` decimal(10,2) DEFAULT NULL COMMENT '月还款额外费用(GPS费)',
  `repayment_extra_fee_2` decimal(10,2) DEFAULT '0.00',
  `overdue_fee` decimal(10,2) DEFAULT NULL,
  `overdue_derate` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `tyz_bp_loans`
ADD COLUMN `loan_status` tinyint(2) DEFAULT '0' COMMENT '放款状态' AFTER `apply_period`;
ALTER TABLE `tyz_bp_loans`
ADD COLUMN `loan_amount` decimal(10,2) DEFAULT NULL COMMENT '放款金额' AFTER `loan_status`;
ALTER TABLE `tyz_bp_loans`
ADD COLUMN `loan_platform` varchar(60) DEFAULT NULL COMMENT '放款平台' AFTER `loan_amount`;
ALTER TABLE `tyz_bp_loans`
ADD COLUMN `loan_lender` varchar(60) DEFAULT NULL COMMENT '放款人' AFTER `loan_platform`;
ALTER TABLE `tyz_bp_loans`
ADD COLUMN `loan_time` datetime DEFAULT NULL COMMENT '放款时间' AFTER `loan_lender`;



