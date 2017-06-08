ALTER TABLE `risk_corp`
ADD COLUMN `lw_key`  varchar(128) NULL COMMENT '乐位接口key' AFTER `jf_support`,
ADD COLUMN `lw_secret`  varchar(128) NULL COMMENT '乐位接口secret' AFTER `lw_key`;

update `risk_corp` set `lw_key` = 'c447926b-5970-4ef9-a204-882f372ccd40', `lw_secret` = 'h581AdAfCBv5A73ABrt' where `domain` = 'dsqx';
update `risk_corp` set `lw_key` = '9ca8ae56-d855-4400-b22b-b3cbb03403d6', `lw_secret` = 'wC1FB0B3a547E3438Cj' where `domain` = 'myd';