/*------------- wangguang 20170519 -----------------*/
DROP TABLE IF EXISTS `p2p_product_sub_type`;
CREATE TABLE `p2p_product_sub_type` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*------------- wangguang 20170519 -----------------*/