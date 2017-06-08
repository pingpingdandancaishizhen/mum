package cn.sunfit.risk.buz.server.util.p2p;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BP;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPAttr;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPBigAttr;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaField;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaOperation;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.Opera;

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
        map.put("productId", req.getProductId());
        map.put("deptId", req.getDeptId());
        map.put("model", req.getModel());
        map.put("productType", req.getProductType());
        if (StringUtils.isNotBlank(req.getBpId())) {
            map.put("bpId", req.getBpId());
            map.put("loanInfoId", req.getLoanInfoId());
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
    // public static void translateFormdata2Attr(List<BPAttr> attrs, List<BPBigAttr> bigattrs, List<BPMetaField> fileds,
    // FormQuery req, Map<String, String> formdata) {
    // for (BPMetaField f : fileds) {
    // // fieldMap.put(f.getFieldKey(), f.getFieldName());
    // if (StringUtils.equals(f.getFieldTable(), ATTR_TYPE)) {
    // BPAttr a = new BPAttr(IdUtil.geneId(), req.getCorpId(), req.getBpId(), f.getFieldKey(), formdata.get(f
    // .getFieldKey()), null, new Date(), req.getDomain());
    // attrs.add(a);
    //
    // } else if (StringUtils.equals(f.getFieldTable(), ATTR_TYPE_BIG)) {
    // BPBigAttr ba = new BPBigAttr(IdUtil.geneId(), req.getCorpId(), req.getBpId(), f.getFieldKey(),
    // formdata.get(f.getFieldKey()), null, new Date(), req.getDomain());
    // bigattrs.add(ba);
    // }
    // }
    // }

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
}
