-- 添加公司可用系统
ALTER TABLE `risk_corp`
ADD COLUMN `systems`  varchar(20) NULL ;

update risk_corp set systems='1';
-- 增加菜单属性
ALTER TABLE `risk_system_menu`
ADD COLUMN `system_id`  varchar(20) NULL ;
update risk_system_menu set system_id='1' where menu_code like '5000%' or menu_code like '6000%' or menu_code like '8000%' or menu_code like '7000%'
or menu_code like '4000%' or menu_code like '3000%'  or menu_code like '2000%' or menu_code in ('10000006');


update risk_system_menu set display_order = 1 where menu_code='0000';
update risk_system_menu set display_order = 2 where menu_code='2000';
update risk_system_menu set display_order = 3 where menu_code='4000';
update risk_system_menu set display_order = 4 where menu_code='5000';
update risk_system_menu set display_order = 5 where menu_code='7000';
update risk_system_menu set display_order = 6 where menu_code='6000';
update risk_system_menu set display_order = 7 where menu_code='8000';
update risk_system_menu set display_order = 8 where menu_code='1000';
update risk_system_menu set display_order = 9 where menu_code='3000';



-- 修改客户表type
ALTER TABLE `ddk_customers`
MODIFY COLUMN `type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `wdgs_customers`
MODIFY COLUMN `type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `cxph_customers`
MODIFY COLUMN `type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
ALTER TABLE `tyz_customers`
MODIFY COLUMN `type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL;
-- 新增单子渠道
ALTER TABLE `cxph_risk_bps`
ADD COLUMN `channel`  varchar(10) DEFAULT '0'  NULL COMMENT '渠道';
ALTER TABLE `ddk_risk_bps`
ADD COLUMN `channel`  varchar(10) DEFAULT '0' NULL COMMENT '渠道';
ALTER TABLE `wdgs_risk_bps`
ADD COLUMN `channel`  varchar(10) DEFAULT '0' NULL COMMENT '渠道';
ALTER TABLE `tyz_risk_bps`
ADD COLUMN `channel`  varchar(10) DEFAULT '0' NULL COMMENT '渠道';