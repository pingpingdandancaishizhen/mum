/*
Navicat MySQL Data Transfer

Source Server         : 172.16.88.50 
Source Server Version : 50631
Source Host           : 172.16.88.50:3306
Source Database       : stdappdb

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-07-29 13:30:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rjs_role
-- ----------------------------
DROP TABLE IF EXISTS `rjs_role`;
CREATE TABLE `rjs_role` (
  `role_id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(128) DEFAULT NULL COMMENT '角色名称',
  `desc` text,
  `status` varchar(1) DEFAULT '0' COMMENT '状态 0:正常 1:停用',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rjs_role_func_rel
-- ----------------------------
DROP TABLE IF EXISTS `rjs_role_func_rel`;
CREATE TABLE `rjs_role_func_rel` (
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `func_id` int(10) NOT NULL COMMENT '功能id',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`,`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_role_menu_rel
-- ----------------------------
DROP TABLE IF EXISTS `rjs_role_menu_rel`;
CREATE TABLE `rjs_role_menu_rel` (
  `role_id` varchar(32) NOT NULL COMMENT '角色编码',
  `menu_id` int(10) NOT NULL COMMENT '菜单id',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_system_func
-- ----------------------------
DROP TABLE IF EXISTS `rjs_system_func`;
CREATE TABLE `rjs_system_func` (
  `func_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `func_name` varchar(128) DEFAULT NULL COMMENT '按钮名称',
  `func_code` varchar(64) DEFAULT NULL,
  `menu_id` int(10) DEFAULT NULL COMMENT '引用菜单code',
  `is_active` varchar(1) DEFAULT '0' COMMENT '是否启用 0:启用 1:不启用',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`func_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_system_func_url_rel
-- ----------------------------
DROP TABLE IF EXISTS `rjs_system_func_url_rel`;
CREATE TABLE `rjs_system_func_url_rel` (
  `func_id` int(10) NOT NULL COMMENT '主键',
  `url_id` int(11) NOT NULL,
  PRIMARY KEY (`func_id`,`url_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_system_menu
-- ----------------------------
DROP TABLE IF EXISTS `rjs_system_menu`;
CREATE TABLE `rjs_system_menu` (
  `menu_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_code` varchar(32) DEFAULT NULL COMMENT '菜单编码',
  `menu_name` varchar(128) DEFAULT NULL COMMENT '菜单名称',
  `system_type` varchar(1) DEFAULT NULL COMMENT '所属系统',
  `action_url` varchar(128) DEFAULT NULL COMMENT '菜单指向路径',
  `menu_img` varchar(128) DEFAULT NULL COMMENT '菜单图标',
  `menu_level` varchar(8) DEFAULT NULL,
  `is_active` varchar(1) DEFAULT '0' COMMENT '是否启用 0:启用 1:不启用',
  `is_leaf` varchar(1) DEFAULT '1' COMMENT '是否叶子节点 0:不是 1:是',
  `parent_code` varchar(32) DEFAULT NULL COMMENT '父级菜单code',
  `display_order` int(8) DEFAULT NULL COMMENT '显示顺序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_system_url
-- ----------------------------
DROP TABLE IF EXISTS `rjs_system_url`;
CREATE TABLE `rjs_system_url` (
  `url_id` int(10) NOT NULL COMMENT '主键',
  `url_name` varchar(128) DEFAULT NULL COMMENT '按钮名称',
  `action_url` varchar(64) DEFAULT NULL COMMENT '按钮功能路径',
  PRIMARY KEY (`url_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_user_role_rel
-- ----------------------------
DROP TABLE IF EXISTS `rjs_user_role_rel`;
CREATE TABLE `rjs_user_role_rel` (
  `uid` varchar(64) NOT NULL COMMENT '用户编码',
  `role_id` varchar(32) NOT NULL COMMENT '角色id',
  `status` varchar(1) DEFAULT '1' COMMENT '用户角色是否启用 1-启用 0-禁用',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`uid`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for rjs_users
-- ----------------------------
DROP TABLE IF EXISTS `rjs_users`;
CREATE TABLE `rjs_users` (
  `uid` varchar(64) NOT NULL COMMENT '唯一序列',
  `real_name` varchar(64) DEFAULT NULL COMMENT '真实姓名',
  `employee_no` varchar(64) DEFAULT NULL COMMENT '工号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `dept_no` varchar(64) DEFAULT NULL,
  `dept_name` varchar(64) DEFAULT NULL,
  `job` varchar(32) DEFAULT NULL COMMENT '岗位',
  `telephone` varchar(16) DEFAULT NULL COMMENT '手机号',
  `status` int(11) DEFAULT '1' COMMENT '状态，0-禁用 1-启用 -1删除',
  `nick_name` varchar(64) DEFAULT NULL COMMENT '昵称',
  `head_cover_url` longtext COMMENT '头像链接',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

