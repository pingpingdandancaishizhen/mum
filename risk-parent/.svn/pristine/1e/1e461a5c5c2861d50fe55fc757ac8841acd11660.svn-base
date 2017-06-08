ALTER TABLE `risk_corp` ADD COLUMN `jf_support`  varchar(20) DEFAULT '0' COMMENT '是否支持疾风交单';
ALTER TABLE `risk_product` ADD COLUMN `jf_support`  varchar(20) DEFAULT '0' COMMENT '是否支持疾风交单';

update risk_corp set jf_support =1 where id in('0','3');

update risk_product set jf_support =1 where id in('CSCYD','TYCYD');