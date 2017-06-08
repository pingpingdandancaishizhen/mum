package cn.sunfit.risk.buz.api.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import orj.worf.util.DateUtils;
import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.BPBigAttr;
import cn.sunfit.risk.buz.api.beans.corp.CustContact;
import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaField;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.form.Opera;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class SolutionUtil {
    public static final String ATTR_TYPE = "bp_attr";
    public static final String ATTR_TYPE_BIG = "bp_big_attr";

    /**
     * 
     * @Title: bpFillTaskIdKey
     * @Description: bp生成TASKID 和TASKKEY 的值
     * @param @param tasks
     * @param @param bp   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    public static void bpFillTaskIdKey(List<Task> tasks, BP bp) {
        List<String> taskIds = new ArrayList<String>();
        List<String> taskKeys = new ArrayList<String>();
        List<String> taskNames = new ArrayList<String>();
        for (Task t : tasks) {
            taskIds.add(t.getId());
            taskKeys.add(t.getTaskDefinitionKey());
            taskNames.add(t.getName());
        }
        if (!tasks.isEmpty()) {
            bp.setCurrentTaskKey("," + StringUtils.join(taskKeys, ',') + ",");
            bp.setCurrentTaskId("," + StringUtils.join(taskIds, ',') + ",");
            bp.setCurrentTaskName("," + StringUtils.join(taskNames, ',') + ",");
        } else {
            // bp.setCurrentTaskId(null);
            // bp.setCurrentTaskKey(null);
            // bp.setCurrentTaskName(null);
        }
    }

    public static void bpFillTaskIdKeyEnd(HistoricActivityInstance hai, BP bp) {
        bp.setCurrentTaskId(null);
        bp.setCurrentTaskKey("," + hai.getActivityId() + ",");
        bp.setCurrentTaskName("," + hai.getActivityName() + ",");
    }

    /**
     * 
     * @Title: converCustomer2Map
     * @Description: 转换CUSTOMER对应的字段  开始流程的时候 表单带入的数据
     * @param @param c
     * @param @return   
     * @return Map<String,String> 
     * @author XFL 2017年1月14日 
     * @throws
     */
    public static Map<String, String> converCustomer2Map(Customer c) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cust_type", c.getType());
        map.put("cust_name", c.getName());
        map.put("cust_license_num", c.getLicenseNum());
        map.put("cust_gender", c.getGender());
        map.put("cust_email", c.getEmail());
        map.put("cust_come_time",
                c.getComeTime() != null ? DateUtils.format(GlobalConstants.DATE_FORMAT_DATE, c.getComeTime()) : null);
        map.put("cust_regist_addr_detail", c.getRegistAddrDetail());
        map.put("cust_marriage", c.getMaritalStatus());
        map.put("cust_live_addr_detail", c.getLiveAddrDetail());
        map.put("cust_house_time",
                c.getHouseTime() != null ? DateUtils.format(GlobalConstants.DATE_FORMAT_DATE, c.getHouseTime()) : null);
        map.put("cust_mobile2", c.getMobile2());
        map.put("cust_wechat", c.getWechat());
        map.put("cust_support_num", c.getSupportNum() != null ? c.getSupportNum().toString() : null);
        if (StringUtils.isNotBlank(c.getRegistAddr())) {
            String[] addrs = c.getRegistAddr().split("/");
            if (addrs.length == 3) {
                map.put("cust_regist_addr_province", addrs[0]);
                map.put("cust_regist_addr_city", addrs[1]);
                map.put("cust_regist_addr_counties", addrs[2]);
            } else if (addrs.length == 2) {
                map.put("cust_regist_addr_province", addrs[0]);
                map.put("cust_regist_addr_city", addrs[1]);
            }
        }
        map.put("cust_qq", c.getQq());
        map.put("cust_phone", c.getPhone());
        map.put("cust_mobile", c.getMobile());
        if (StringUtils.isNotBlank(c.getLiveAddr())) {
            String[] addrs = c.getLiveAddr().split("/");
            if (addrs.length == 3) {
                map.put("cust_live_addr_province", addrs[0]);
                map.put("cust_live_addr_city", addrs[1]);
                map.put("cust_live_addr_counties", addrs[2]);
            } else if (addrs.length == 2) {
                map.put("cust_live_addr_province", addrs[0]);
                map.put("cust_live_addr_city", addrs[1]);
            }
        }
        map.put("cust_house_type", c.getHouseType());
        map.put("cust_house_spending", c.getHouseSpending() != null ? String.valueOf(c.getHouseSpending().intValue())
                : null);
        map.put("cust_education", c.getEducation());
        map.put("cust_child_count", c.getChildCount() != null ? c.getChildCount().toString() : null);
        map.put("custjob_salary", c.getSalary() != null ? String.valueOf(c.getSalary().intValue()) : null);
        map.put("custjob_entry_time",
                c.getEntryTime() != null ? DateUtils.format(GlobalConstants.DATE_FORMAT_DATE, c.getEntryTime()) : null);
        map.put("custjob_salary_date", c.getSalaryDate() != null ? c.getSalaryDate().toString() : null);
        map.put("custjob_salary_type", c.getSalaryType());
        map.put("custjob_company_phone", c.getCompanyPhone());
        if (StringUtils.isNotBlank(c.getCompanyAddr())) {
            String[] addrs = c.getCompanyAddr().split("/");
            if (addrs.length == 3) {
                map.put("custjob_company_addr_province", addrs[0]);
                map.put("custjob_company_addr_city", addrs[1]);
                map.put("custjob_company_addr_counties", addrs[2]);
            } else if (addrs.length == 2) {
                map.put("custjob_company_addr_province", addrs[0]);
                map.put("custjob_company_addr_city", addrs[1]);
            }
        }
        String custjobIdentity = c.getJobType();
        if(custjobIdentity != null && custjobIdentity.equals("1")){//受薪人士
        	map.put("custjob_salary_date", c.getSalaryDate()+"");
        }else if(custjobIdentity != null && custjobIdentity.equals("2")){//自雇人士
        	if(c.getSalary() != null)
        		map.put("custjob_income_month", c.getSalary().doubleValue()+"");
        	map.put("custjob_income_source", c.getCompanyName());
        	map.put("custjob_industry1", c.getIndustry());
        }else if(custjobIdentity != null && custjobIdentity.equals("3")){//企业股东
        	map.put("custjob_reg_date",DateUtils.format(GlobalConstants.DATE_FORMAT_DATE,c.getEntryTime()));
        	if(c.getSalary() != null)
        		map.put("custjob_turnover_month", c.getSalary().doubleValue()+"");
        }
        map.put("cust_license_num_invalid", DateUtils.format(GlobalConstants.DATE_FORMAT_DATE,c.getIdCardVaild()));
        map.put("custjob_identity", c.getJobType());
        map.put("custjob_company_addr_detail", c.getCompanyAddrDetail());
        map.put("custjob_company_name", c.getCompanyName());
        map.put("custjob_dept_name", c.getDeptName());
        map.put("custjob_company_type", c.getCompanyType());
        map.put("custjob_industry", c.getIndustry());
        map.put("custjob_job_lvl", c.getJob());
        map.put("custimg_idcard1", c.getIdCardFront());
        map.put("custimg_idcard2", c.getIdCardBack());
        return map;
    }

    /**
     * 
     * @Title: createDefaultHidden
     * @Description: 创建DEFAULTHIDDEN
     * @param @param req
     * @param @return   
     * @return Map<String,String> 
     * @author XFL 2017年1月14日 
     * @throws
     */
    public static Map<String, String> createDefaultHidden(FormQuery req) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("bpDefId", req.getBpDefId());
        map.put("bpDefKey", req.getBpDefKey());
        map.put("customerId", req.getCustomerId());
        map.put("productId", req.getProductId());
        map.put("deptId", req.getDeptId());
        if (StringUtils.isNotBlank(req.getBpId())) {
            map.put("bpId", req.getBpId());
        }
        if (StringUtils.isNotBlank(req.getTaskId())) {
            map.put("taskId", req.getTaskId());
        }
        return map;
    }

    /**
     * 
     * @Title: joinCheckRuleFieldForm
     * @Description: 合并字段级校验和表单级别校验，如果校验有重合，以表单级别为准
     * @param @param checkrules
     * @param @param checkRules2   
     * @return void 
     * @author XFL 2017年1月19日 
     * @throws
     */
    public static void joinCheckRuleFieldForm(Map<String, List<CheckRuleInfo>> checkrules, String checkRules2) {
        if (StringUtils.isBlank(checkRules2)) {
            return;
        } else {
            List<CheckRuleInfo> formrule = JsonUtils.parseJSON(checkRules2, ArrayList.class, CheckRuleInfo.class);
            for (CheckRuleInfo c : formrule) {
                List<CheckRuleInfo> fieldrule = checkrules.get(c.getFieldKey());
                if (fieldrule == null || fieldrule.isEmpty()) {
                    fieldrule = new ArrayList<CheckRuleInfo>();
                    fieldrule.add(c);
                    checkrules.put(c.getFieldKey(), fieldrule);
                } else {
                    boolean chongfu = false;
                    CheckRuleInfo chongfucr = null;
                    for (CheckRuleInfo f : fieldrule) {
                        // 循环字段级别，如果发现重复 直接替换，如果没有重复 直接插入
                        if (StringUtils.equals(c.getRuleType(), f.getRuleType())) {
                            chongfu = true;
                            chongfucr = f;
                        }
                    }
                    if (chongfu) {
                        fieldrule.remove(chongfucr);
                        fieldrule.add(c);
                    } else {
                        fieldrule.add(c);
                    }
                }
            }
        }
    }

    /**
     * 
     * @Title: operations2Opers
     * @Description: 类型转换
     * @param @param operations
     * @param @param operas   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    public static void operations2Opers(List<BPMetaOperation> operations, List<Opera> operas) {
        for (BPMetaOperation p : operations) {
            operas.add(new Opera(p.getOperKey(), p.getOperName(), String.valueOf(p.getOperType())));
        }
    }

    /**
     * 
     * @Title: translateFormdata2Attr
     * @Description: 将传递的参数MAP，数值放到ATTRS和BIGATTRS中
     * @param @param attrs
     * @param @param bigattrs
     * @param @param fileds
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    public static void translateFormdata2Attr(List<BPAttr> attrs, List<BPBigAttr> bigattrs, List<BPMetaField> fileds,
            FormQuery req, Map<String, String> formdata) {
        for (BPMetaField f : fileds) {
            // fieldMap.put(f.getFieldKey(), f.getFieldName());
            if (StringUtils.equals(f.getFieldTable(), ATTR_TYPE)) {
                BPAttr a = new BPAttr(IdUtil.geneId(), req.getCorpId(), req.getBpId(), f.getFieldKey(), formdata.get(f
                        .getFieldKey()), null, new Date(), req.getDomain());
                attrs.add(a);

            } else if (StringUtils.equals(f.getFieldTable(), ATTR_TYPE_BIG)) {
                BPBigAttr ba = new BPBigAttr(IdUtil.geneId(), req.getCorpId(), req.getBpId(), f.getFieldKey(),
                        formdata.get(f.getFieldKey()), null, new Date(), req.getDomain());
                bigattrs.add(ba);
            }
        }
    }

    /**
     * 
     * @Title: validateOperations
     * @Description: 验证是否有操作
     * @param @param operations
     * @param @param formdata
     * @param @return   
     * @return boolean 
     * @author XFL 2017年1月14日 
     * @throws
     */
    public static BPMetaOperation validateOperations(List<BPMetaOperation> operations, Map<String, String> formdata) {
        BPMetaOperation operationshas = null;
        if (!operations.isEmpty()) {
            for (BPMetaOperation o : operations) {
                if (StringUtils.equals(formdata.get("operation"), o.getOperKey())) {
                    formdata.put("oper_type", String.valueOf(o.getOperType()));
                    operationshas = o;
                    break;
                }
            }
        }
        if (!operations.isEmpty() && operationshas == null) {
            throw new ServiceException("未选择任何操作");
        }
        if (operationshas == null) {
            formdata.remove("operation");
            formdata.remove("oper_type");
            formdata.remove("reason");
        }
        return operationshas;
    }
    
    /**
     * 
     * @Title: converCustContact2Map
     * @Description: 将紧急联系人转成map
     * @param @param contactList   
     * @return void 
     * @author zhaoziyu 2017年5月15日 
     * @throws
     */
	public static Map<String, String> converCustContact2Map(List<CustContact> contactList) {
		Map<String,String> map = new LinkedHashMap<String, String>();
		for(int i = 0;i < contactList.size(); i++){
			CustContact contact = contactList.get(i);
			map.put("custfriend_relation_"+i, contact.getRelation());
			map.put("custfriend_name_"+i, contact.getName());
			map.put("custfriend_know_"+i, contact.isIsknow() ? "1":"0");
			map.put("custfriend_phone_"+i, contact.getMobile());
			map.put("custfriend_company_name_"+i, contact.getCompany());
		}
		return map;
	}
}
