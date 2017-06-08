/*
Navicat MySQL Data Transfer

Source Server         : 172.16.88.50 
Source Server Version : 50631
Source Host           : 172.16.88.50:3306
Source Database       : stdappdb

Target Server Type    : MYSQL
Target Server Version : 50631
File Encoding         : 65001

Date: 2016-08-12 14:48:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rjs_article
-- ----------------------------
DROP TABLE IF EXISTS `rjs_article`;
CREATE TABLE `rjs_article` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `art_info` varchar(255) NOT NULL,
  `art_keyword` varchar(200) NOT NULL,
  `art_content` text NOT NULL,
  `art_writer` varchar(20) NOT NULL,
  `art_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `type_id` smallint(5) unsigned NOT NULL COMMENT '文章类型id',
  `art_url` varchar(200) NOT NULL COMMENT '文章链接',
  `art_img` varchar(200) NOT NULL COMMENT '文章缩略图',
  `sort_order` int(10) unsigned NOT NULL COMMENT '排序',
  `is_hot` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否热门',
  `view_count` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '浏览次数',
  `is_hidden` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否隐藏 1隐藏 0显示',
  `is_prompt` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0不提示 1提示',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0正常 1删除',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
