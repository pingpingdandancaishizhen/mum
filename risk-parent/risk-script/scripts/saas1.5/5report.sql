SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cxph_repayment_overdue
-- ----------------------------
DROP TABLE IF EXISTS `cxph_repayment_overdue`;
CREATE TABLE `cxph_repayment_overdue` (
  `id` varchar(60) NOT NULL,
  `repayment_detail_id` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `principle` decimal(10,2) NOT NULL COMMENT '剩余应付本金',
  `interest` decimal(10,2) NOT NULL COMMENT '剩余应付利息',
  `manage_fee` decimal(10,2) DEFAULT NULL COMMENT '剩余应付管理费',
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `overdue_fee` decimal(10,2) NOT NULL COMMENT '逾期滞纳金',
  `overdue_count` int(10) NOT NULL COMMENT '逾期天数',
  `create_time` datetime NOT NULL COMMENT '生成记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `cxph_bp_loans`
ADD COLUMN `loan_plan_time`  date NULL AFTER `loan_time`;
ALTER TABLE `cxph_bp_loans`
ADD COLUMN `znj_fee_cal`  varchar(2) NULL AFTER `loan_plan_time`;
--  老数据默认值设置
update cxph_bp_loans set loan_plan_time = IFNULL(DATE(loan_time) ,CURDATE()) , znj_fee_cal = '1';



DROP TABLE IF EXISTS `wdgs_repayment_overdue`;
CREATE TABLE `wdgs_repayment_overdue` (
  `id` varchar(60) NOT NULL,
  `repayment_detail_id` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `principle` decimal(10,2) NOT NULL COMMENT '剩余应付本金',
  `interest` decimal(10,2) NOT NULL COMMENT '剩余应付利息',
  `manage_fee` decimal(10,2) DEFAULT NULL COMMENT '剩余应付管理费',
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `overdue_fee` decimal(10,2) NOT NULL COMMENT '逾期滞纳金',
  `overdue_count` int(10) NOT NULL COMMENT '逾期天数',
  `create_time` datetime NOT NULL COMMENT '生成记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `loan_plan_time`  date NULL AFTER `loan_time`;
ALTER TABLE `wdgs_bp_loans`
ADD COLUMN `znj_fee_cal`  varchar(2) NULL AFTER `loan_plan_time`;
--  老数据默认值设置
update wdgs_bp_loans set loan_plan_time = IFNULL(DATE(loan_time) ,CURDATE()) , znj_fee_cal = '1';


DROP TABLE IF EXISTS `tyz_repayment_overdue`;
CREATE TABLE `tyz_repayment_overdue` (
  `id` varchar(60) NOT NULL,
  `repayment_detail_id` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `principle` decimal(10,2) NOT NULL COMMENT '剩余应付本金',
  `interest` decimal(10,2) NOT NULL COMMENT '剩余应付利息',
  `manage_fee` decimal(10,2) DEFAULT NULL COMMENT '剩余应付管理费',
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `overdue_fee` decimal(10,2) NOT NULL COMMENT '逾期滞纳金',
  `overdue_count` int(10) NOT NULL COMMENT '逾期天数',
  `create_time` datetime NOT NULL COMMENT '生成记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `tyz_bp_loans`
ADD COLUMN `loan_plan_time`  date NULL AFTER `loan_time`;
ALTER TABLE `tyz_bp_loans`
ADD COLUMN `znj_fee_cal`  varchar(2) NULL AFTER `loan_plan_time`;
--  老数据默认值设置
update tyz_bp_loans set loan_plan_time = IFNULL(DATE(loan_time) ,CURDATE()) , znj_fee_cal = '1';




DROP TABLE IF EXISTS `ddk_repayment_overdue`;
CREATE TABLE `ddk_repayment_overdue` (
  `id` varchar(60) NOT NULL,
  `repayment_detail_id` varchar(60) NOT NULL,
  `date` date NOT NULL,
  `principle` decimal(10,2) NOT NULL COMMENT '剩余应付本金',
  `interest` decimal(10,2) NOT NULL COMMENT '剩余应付利息',
  `manage_fee` decimal(10,2) DEFAULT NULL COMMENT '剩余应付管理费',
  `extra_fee` decimal(10,2) DEFAULT NULL,
  `extra_fee_2` decimal(10,2) DEFAULT NULL,
  `overdue_fee` decimal(10,2) NOT NULL COMMENT '逾期滞纳金',
  `overdue_count` int(10) NOT NULL COMMENT '逾期天数',
  `create_time` datetime NOT NULL COMMENT '生成记录时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


ALTER TABLE `ddk_bp_loans`
ADD COLUMN `loan_plan_time`  date NULL AFTER `loan_time`;
ALTER TABLE `ddk_bp_loans`
ADD COLUMN `znj_fee_cal`  varchar(2) NULL AFTER `loan_plan_time`;
--  老数据默认值设置
update ddk_bp_loans set loan_plan_time = IFNULL(DATE(loan_time) ,CURDATE()) , znj_fee_cal = '1';