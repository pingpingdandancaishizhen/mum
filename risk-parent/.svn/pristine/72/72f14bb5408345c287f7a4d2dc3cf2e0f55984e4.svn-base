delete from risk_corp_func_rel;
insert into risk_corp_func_rel(id,corp_id,func_id,create_time)  
select replace(uuid(),'-','')    as id,
'1',id,now() from risk_system_func ;
delete from risk_corp_menu_rel;
insert into risk_corp_menu_rel(corp_id,menu_id,create_time)  
select '1',id,now() from risk_system_menu;
delete from risk_corp_role_menu_rel;
insert risk_corp_role_menu_rel(role_id,menu_id,create_time) 
select '1',id,now() from risk_system_menu;
delete from risk_corp_role_func_rel;
insert risk_corp_role_func_rel(role_id,func_id,create_time) 
select '1',id,now() from risk_system_func;