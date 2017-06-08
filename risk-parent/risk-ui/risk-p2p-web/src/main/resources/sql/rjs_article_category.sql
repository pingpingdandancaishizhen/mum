/*
Navicat MySQL Data Transfer

Source Server         : 172.16.88.50 
Source Server Version : 50631
Source Host           : 172.16.88.50:3306
Source Database       : stdappdb

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-08-12 14:48:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rjs_article_category
-- ----------------------------
DROP TABLE IF EXISTS `rjs_article_category`;
CREATE TABLE `rjs_article_category` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(40) NOT NULL,
  `type_url` varchar(200) NOT NULL,
  `type_keyword` varchar(200) NOT NULL,
  `type_info` varchar(400) NOT NULL,
  `sort_order` int(11) NOT NULL,
  `parent_id` smallint(6) NOT NULL,
  `type_nid` varchar(50) NOT NULL COMMENT '分类nid',
  `is_hiden` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '是否隐藏',
  `add_time` datetime NOT NULL COMMENT '添加时间',
  `is_blank` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否在新窗口打开',
  `need_content` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章列表页是否需要获取文章内容',
  `show_thumb` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章内容是否显示缩略图',
  `page_size` int(5) NOT NULL DEFAULT '15' COMMENT '分页大小',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
