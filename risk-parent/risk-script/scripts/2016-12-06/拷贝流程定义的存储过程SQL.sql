COPY:BEGIN
    #Routine body goes here...
    declare err INT default 0;#声明一个整形变量err，默认值是0
    declare versioncount INT DEFAULT 0;
    #declare continue handler for sqlexception set err=1;#当sqlexception handler捕捉到异常时，设置err=1
    set autocommit = 0;
    START TRANSACTION;#开始事务
    #判断meta能否拷贝。如果流程版本没升级，不拷贝
    SET @SELECTREPEATVERSION = CONCAT(
    "select count(1) into @versioncount from wdgs_bp_meta m,bp_meta_templates n where m.bp_def_key = n.bp_def_key and m.version=n.version and n.bp_def_id='",bpDefId,"';");
       PREPARE SELECTREPEATVERSION FROM @SELECTREPEATVERSION; 
    EXECUTE SELECTREPEATVERSION;
    deallocate prepare SELECTREPEATVERSION;
    set versioncount = @versioncount ;
     IF (@versioncount <> 0) THEN
         LEAVE COPY;
     END IF;
    #拷贝META_
	  SET @meta_id = (SELECT REPLACE(UUID(),'-',''));
	  SET @INSERT_BP_META = CONCAT(		"insert into " ,domain,"_bp_meta (corp_id,bp_def_id, product_key, engine_def_id, bp_name, bp_def_key,bp_desc, bp_no_rule, "
      ,"version, create_user_id, create_time, "
      ,"update_time, bind_clazz, loan_type, "
      ,"loan_ext_table, bpmn_xml,latest)"
      ,"select '",corpId,"','",@meta_id,"',product_key,engine_def_id,bp_name,bp_def_key,bp_desc,bp_no_rule,version,create_user_id,"
      ,"create_time,null,bind_clazz,loan_type,loan_ext_table,bpmn_xml,1  from bp_meta_templates where bp_def_id='",bpDefId,"';");
select @INSERT_BP_META;
    PREPARE INSERT_BP_META FROM @INSERT_BP_META; 
    EXECUTE INSERT_BP_META;
deallocate prepare INSERT_BP_META;
		#拷贝META_NODE
    SET @INSERT_BP_META_NODE = CONCAT("insert into " ,domain,"_bp_meta_nodes(corp_id,node_id,bp_def_id,node_key,node_name,node_desc,form_key,gateway,node_type) " 
	     ,"select '",corpId,"',REPLACE(UUID(),'-','') ,'",@meta_id,"',node_key,node_name,node_desc,form_key,gateway,node_type from bp_meta_nodes_templates "
       ,"where bp_def_id='",bpDefId,"';");
select @INSERT_BP_META_NODE;
			PREPARE INSERT_BP_META_NODE FROM @INSERT_BP_META_NODE; 
			EXECUTE INSERT_BP_META_NODE;
deallocate prepare INSERT_BP_META_NODE;
     #拷贝meta_category

		SET @INSERT_META_CATEGORY = CONCAT("insert into ",domain,"_bp_meta_category(corp_id,category_key,category_id,name,bp_def_id,category_desc) "
     ,"select '",corpId,"',category_key,REPLACE(UUID(),'-',''),name,'",@meta_id,"',category_desc from bp_meta_category_templates "
     ,"where bp_def_id='",bpDefId,"';");
select @INSERT_META_CATEGORY;
     	PREPARE INSERT_META_CATEGORY FROM @INSERT_META_CATEGORY; 
			EXECUTE INSERT_META_CATEGORY;
deallocate prepare INSERT_META_CATEGORY;
     #拷贝meta_field
		SET @INSERT_META_FIELD = CONCAT("insert into ",domain,"_bp_meta_fields(corp_id,field_id,bp_def_id,field_key,field_name,field_desc,datatype,field_table,is_attr,data_provider,check_rule,category,default_order,update_time,default_value) " 
     ,"select '",corpId,"',REPLACE(UUID(),'-',''),'",@meta_id,"',field_key,field_name,field_desc,datatype,field_table,is_attr,data_provider,check_rule,category,default_order,null,default_value from bp_meta_fields_templates "
		,"where bp_def_id='",bpDefId,"';");
select @INSERT_META_FIELD;
  	PREPARE INSERT_META_FIELD FROM @INSERT_META_FIELD; 
		EXECUTE INSERT_META_FIELD;
deallocate prepare INSERT_META_FIELD;
		#拷贝meta_form
     SET @INSERT_META_FORM = CONCAT("insert into ",domain,"_bp_meta_forms(form_id,corp_id,bp_def_id,form_key,form_name,form_desc,operations,layout,is_outside,form_html,check_rules) "
     ,"select REPLACE(UUID(),'-',''),'",corpId,"','",@meta_id,"',form_key,form_name,form_desc,operations,layout,is_outside,form_html,check_rules from bp_meta_forms_templates "
   ,"where bp_def_id='",bpDefId,"';");
select @INSERT_META_FORM;
	PREPARE INSERT_META_FORM FROM @INSERT_META_FORM; 
		EXECUTE INSERT_META_FORM;
deallocate prepare INSERT_META_FORM;
    #拷贝meta_operation
    SET @INSERT_META_OPERATION = CONCAT("insert into ",domain,"_bp_meta_operations(corp_id,operation_id,bp_def_id,oper_key,oper_name,oper_desc,oper_type,node_key,binding,is_basic,pre_condition,post_condition,update_time) "		
    ,"select '",corpId,"',REPLACE(UUID(),'-',''),'",@meta_id,"',oper_key,oper_name,oper_desc,oper_type,node_key,binding,is_basic,pre_condition,post_condition,null from bp_meta_operations_templates "
   ,"where bp_def_id='",bpDefId,"';");
select @INSERT_META_OPERATION;
	PREPARE INSERT_META_OPERATION FROM @INSERT_META_OPERATION; 
		EXECUTE INSERT_META_OPERATION;
deallocate prepare INSERT_META_OPERATION;
    IF (err=0) THEN
        commit;
        select 'OK';
     ELSE
        rollback;
        select 'err';
     END IF;
END