package cn.sunfit.risk.buz.server.service.solution;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ActivitiTaskAlreadyClaimedException;
import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.BPBigAttr;
import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.beans.buz.BPOperLog;
import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaField;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaForm;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;
import cn.sunfit.risk.buz.api.beans.metadata.form.EditorInfo;
import cn.sunfit.risk.buz.api.beans.metadata.form.GroupInfo;
import cn.sunfit.risk.buz.api.beans.metadata.form.LayoutInfo;
import cn.sunfit.risk.buz.api.beans.metadata.form.TabInfo;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import cn.sunfit.risk.buz.api.cmd.ProcessHandleHelper;
import cn.sunfit.risk.buz.api.cmd.ProcessNextCmd;
import cn.sunfit.risk.buz.api.cmd.ProcessStartCmd;
import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.OperationType;
import cn.sunfit.risk.buz.api.constants.loan.LoanChannel;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.activiti.AssignService;
import cn.sunfit.risk.buz.api.service.buz.OperLogService;
import cn.sunfit.risk.buz.api.service.corp.CorpDataRoleService;
import cn.sunfit.risk.buz.api.service.loan.LoanService;
import cn.sunfit.risk.buz.api.service.solution.SuperFormService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.utils.OperLogUtil;
import cn.sunfit.risk.buz.api.utils.SolutionUtil;
import cn.sunfit.risk.buz.api.vo.form.Attr;
import cn.sunfit.risk.buz.api.vo.form.FormData;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.form.ModifyField;
import cn.sunfit.risk.buz.api.vo.form.Opera;
import cn.sunfit.risk.buz.api.vo.loan.RestartReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFBPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPBigAttrDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDeptDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaFieldDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaFormDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaNodeDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaOperationDAO;
import cn.sunfit.risk.buz.server.dao.solution.ProductDAO;
import cn.sunfit.risk.buz.server.service.buz.BPUtils;
import cn.sunfit.risk.buz.server.service.product.fee.ProductFeeFactory;
import cn.sunfit.risk.buz.server.service.product.form.ProductFormFactory;
import cn.sunfit.risk.buz.server.util.CmdUtil;
import cn.sunfit.risk.buz.server.util.api.jfjd.event.BpStatusChangeEvent;
import cn.sunfit.risk.buz.server.util.api.lewei.event.FromSubmitEvent;

@Service("risk.superFormService")
public class SuperFormServiceImpl implements SuperFormService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BPMetaFieldDAO bpMetaFieldDAO;
    @Autowired
    BPMetaOperationDAO bpMetaOperationDAO;
    @Autowired
    BPMetaFormDAO bpMetaFormDAO;
    @Autowired
    BPMetaDAO bpMetaDAO;
    @Autowired
    BPMetaNodeDAO bpMetaNodeDAO;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private TaskService taskService;
    @Autowired
    BPAttrDAO bpAttrDAO;
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    BPBigAttrDAO bpBigAttrDAO;
    @Autowired
    private BPDAO bpdao;

    @Autowired
    private BPLoanDAO bpLoanDAO;

    @Autowired
    private OperLogService operLogService;
    @Autowired
    private LoanService loanService;
    @Autowired
    private SpecialTaskService specialTaskService;
    @Autowired
    private CorpDataRoleService corpDataRoleService;
    @Autowired
    private CorpDeptDAO corpDeptDAO;
    @Autowired
    private FormService formService;

    @Autowired
    private AssignService assignService;

    @Autowired
    private ProductFormFactory productFormFactory;

    @Autowired
    private ProductFeeFactory productFeeFactory;

    @Autowired
    private JFBPDAO jFBPDAO;

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, Attr> getAttrs(FormQuery req) {
        if (StringUtils.isBlank(req.getTaskId()) && !req.isView() && !req.getCustomerId().equals("-1")){//客户ID是-1的话就自动创建客户
            // 如果是开始表单，读取用户信息放入 attr中
            return productFormFactory.getHandler(req.getProductId()).initStartAttr(req);
        }
        if (StringUtils.isBlank(req.getBpId())) {
            return null;
        } else {
            List<BPAttr> attrs = bpAttrDAO.findByBP(req);
            List<BPBigAttr> bigAttrs = bpBigAttrDAO.findByBP(req);
            attrs.addAll(bigAttrs);
            Map<String, Attr> r = new HashMap<String, Attr>();
            for (BPAttr attr : attrs) {
                r.put(attr.getAttrName(), new Attr(attr.getAttrName(), attr.getAttrValue(), attr.getDraftValue()));
            }
            return r;
        }
    }

    private Map<String, List<CheckRuleInfo>> getFieldCheckRule(FormQuery req) {
        Map<String, List<CheckRuleInfo>> m = new HashMap<String, List<CheckRuleInfo>>();
        List<BPMetaField> fileds = bpMetaFieldDAO.findFieldKey(req);
        for (BPMetaField f : fileds) {
            if (StringUtils.isNotBlank(f.getCheckRule())) {
                List<CheckRuleInfo> list = JsonUtils.parseJSON(f.getCheckRule(), List.class, CheckRuleInfo.class);
                if (list != null && !list.isEmpty()) {
                    for (CheckRuleInfo cf : list) {
                        cf.setFieldName(f.getFieldName());
                    }
                }

                m.put(f.getFieldKey(), list);
            } else {
                m.put(f.getFieldKey(), new ArrayList<CheckRuleInfo>());
            }
        }
        return m;
    }

    private BPMetaForm getMetaForm(FormQuery req, Task task) {
        if (StringUtils.isBlank(req.getTaskId()) || req.isView()) {
            // 如果没有传taskId说明是开始表单
            BPMetaForm form = bpMetaFormDAO.selectStartFormByBpDefId(req);
            return form;
        } else {
            // 根据TASKID 获得task的key，这样才能拿到表单
            // Task task = taskService.createTaskQuery().processDefinitionKey(req.getBpDefKey())
            // .taskCandidateOrAssigned(req.getUserId()).taskId(req.getTaskId()).singleResult();
            // if (task == null) {
            // throw new ServiceException("该任务您无权受理");
            // } else {
            BPMetaForm form = bpMetaFormDAO.selectTaskFormByBpDefIdTaskKey(req, task.getTaskDefinitionKey());
            return form;
            // }
        }
    }

    private List<Opera> getOperations(FormQuery req, Task task) {
        List<BPMetaOperation> operations;
        List<Opera> r = new ArrayList<Opera>();
        if (StringUtils.isBlank(req.getTaskId())) {
            operations = bpMetaOperationDAO.selectStartOperation(req.getCorpId(), req.getDomain(), req.getBpDefId());
        } else {
            // Task task = taskService.createTaskQuery().processDefinitionKey(req.getBpDefKey())
            // .taskCandidateOrAssigned(req.getUserId()).taskId(req.getTaskId()).singleResult();
            // if (task == null) {
            // return r;
            // }
            operations = bpMetaOperationDAO.selectNodeOperation(req.getCorpId(), req.getDomain(), req.getBpDefId(),
                    task.getTaskDefinitionKey());
        }
        SolutionUtil.operations2Opers(operations, r);
        return r;
    }

    private Map<String, String> getSubmitFormData(Map<String, String> formdata) {
        Map<String, String> submitformdata = new HashMap<String, String>();
        submitformdata.put("operation", formdata.get("operation"));
        submitformdata.put("oper_type", formdata.get("oper_type"));
        submitformdata.put("reason", formdata.get("reason"));
        submitformdata.put("formdata", JsonUtils.toJSON(formdata));
        return submitformdata;
    }

    private void isEnd(FormQuery req, BP bp, BPMetaOperation operationshas, BPLoan loan) {
        ProcessInstance rpi = runtimeService.createProcessInstanceQuery().processInstanceId(bp.getEngineKey())
                .singleResult();
        if (rpi == null) {
            List<HistoricActivityInstance> hai = historyService.createHistoricActivityInstanceQuery()
                    .activityTenantId(req.getCorpId()).processInstanceId(bp.getEngineKey()).activityType("endEvent")
                    .finished().orderByHistoricActivityInstanceEndTime().desc().list();
            if (hai == null || hai.isEmpty()) {
                throw new ServiceException("流程未结束");
            } else {

                SolutionUtil.bpFillTaskIdKeyEnd(hai.get(0), bp);
                if (operationshas != null
                        && OperationType.REJECT.getStatus().equals(String.valueOf(operationshas.getOperType()))) {
                    bp.setBpStatus(BpStatus.LOAN_REFUSE.getStatus());
                } else {
                    bp.setBpStatus(BpStatus.LOAN_ING.getStatus());
                    // TODO 计算放款费率存库 先不移到对应的产品类去。用factory做吧。
                    productFeeFactory.getHandler(req.getProductId()).saveLoanFeeList(req, loan);
                }
            }
        }

    }

    private List<ModifyField> modifyBpsLoanAttr(FormQuery req, Map<String, String> formdata, BP bp, BPLoan loan) {

        List<ModifyField> modifys = new ArrayList<ModifyField>();
        bp.setDomain(req.getDomain());
        // loan填值
        productFormFactory.getHandler(req.getProductId()).fillLoan(loan, formdata);
        // 更新loan表
        loan.setDomain(req.getDomain());
        bpLoanDAO.update(loan);
        productFormFactory.getHandler(req.getProductId()).hasLoan(req, loan);
        // 更新attr
        List<BPMetaField> fileds = bpMetaFieldDAO.findFieldKey(req);
        // 修改attr的日志值
        bpAttrDAO.clearDraftValueByBpId(new BPAttr(null, null, req.getBpId(), null, null, null, null, req.getDomain()));
        bpBigAttrDAO.clearDraftValueByBpId(new BPBigAttr(null, null, req.getBpId(), null, null, null, null, req
                .getDomain()));
        List<BPAttr> attrs = new ArrayList<BPAttr>();
        List<BPBigAttr> bigattrs = new ArrayList<BPBigAttr>();
        Map<String, String> fieldMap = new HashMap<String, String>();
        for (BPMetaField f : fileds) {
            fieldMap.put(f.getFieldKey(), f.getFieldName());
            if (StringUtils.equals(f.getFieldTable(), SolutionUtil.ATTR_TYPE)) {
                if (formdata.get(f.getFieldKey()) == null) {
                    continue;
                } else {
                    attrs.add(new BPAttr(null, null, req.getBpId(), f.getFieldKey(), formdata.get(f.getFieldKey()),
                            null, null, req.getDomain()));
                }
                // 查询所有值，然后集体update 后面的代码废弃
                // 修改值
                // String oldValue = bpAttrDAO.selectValueByNameBpId(new BPAttr(null, null, req.getBpId(),
                // f.getFieldKey(), formdata.get(f.getFieldKey()), null, null, req.getDomain()));
                // if (StringUtils.equals(oldValue, formdata.get(f.getFieldKey()))) {
                // continue;
                // }
                // int i = bpAttrDAO.updateValueByNameBpId(new BPAttr(null, null, req.getBpId(), f.getFieldKey(),
                // formdata
                // .get(f.getFieldKey()), null, null, req.getDomain()));
                // if (i > 0) {
                // // 记录字段修改日志
                // modifys.add(new ModifyField(f.getFieldName(), oldValue, formdata.get(f.getFieldKey())));
                // }
            } else if (StringUtils.equals(f.getFieldTable(), SolutionUtil.ATTR_TYPE_BIG)) {
                if (formdata.get(f.getFieldKey()) == null) {
                    continue;
                } else {
                    bigattrs.add(new BPBigAttr(null, null, req.getBpId(), f.getFieldKey(),
                            formdata.get(f.getFieldKey()), null, null, req.getDomain()));
                }
                // int i = bpBigAttrDAO.updateValueByNameBpId(new BPBigAttr(null, null, req.getBpId(), f.getFieldKey(),
                // formdata.get(f.getFieldKey()), null, null, req.getDomain()));
                // if (i > 0) {
                // // 记录字段修改日志 大字段不记录值
                // modifys.add(new ModifyField(f.getFieldName(), null, null));
                // }
            }
        }
        // 一次性查询出本次传递值的原value然后对比
        if (!attrs.isEmpty()) {
            List<BPAttr> oldvalues = bpAttrDAO.selectBatch(attrs, req.getBpId(), req.getDomain());
            if (!oldvalues.isEmpty()) {
                for (BPAttr bpAttr : oldvalues) {
                    if (StringUtils.equals(bpAttr.getAttrValue(), formdata.get(bpAttr.getAttrName()))) {
                        continue;
                    } else {
                        modifys.add(new ModifyField(fieldMap.get(bpAttr.getAttrName()), bpAttr.getAttrValue(), formdata
                                .get(bpAttr.getAttrName())));
                        BPAttr tmp = new BPAttr();
                        BeanUtils.copyProperties(bpAttr, tmp);
                        tmp.setAttrValue(formdata.get(bpAttr.getAttrName()));
                        tmp.setDomain(req.getDomain());
                        bpAttrDAO.updateValueByNameBpId(tmp);
                    }
                }
            }

        }
        if (!bigattrs.isEmpty()) {
            List<BPBigAttr> oldbigvalues = bpBigAttrDAO.selectBatch(bigattrs, req.getBpId(), req.getDomain());
            if (!oldbigvalues.isEmpty()) {
                for (BPBigAttr bpBigAttr : oldbigvalues) {
                    if (StringUtils.equals(bpBigAttr.getAttrValue(), formdata.get(bpBigAttr.getAttrName()))) {
                        continue;
                    } else {
                        modifys.add(new ModifyField(fieldMap.get(bpBigAttr.getAttrName()), null, null));
                        BPBigAttr tmp = new BPBigAttr();
                        BeanUtils.copyProperties(bpBigAttr, tmp);
                        tmp.setAttrValue(formdata.get(bpBigAttr.getAttrName()));
                        tmp.setDomain(req.getDomain());
                        bpBigAttrDAO.updateValueByNameBpId(tmp);
                    }
                }
            }
        }
        bpdao.update(bp);
        return modifys;
    }

    @Override
    public FormData queryNodeFormData(FormQuery req) throws ServiceException {
        FormData fd = new FormData();
        Task task = null;
        if (StringUtils.isNotBlank(req.getTaskId())) {
            task = taskService.createTaskQuery().processDefinitionKey(req.getBpDefKey())
                    .taskCandidateOrAssigned(req.getUserId()).taskId(req.getTaskId()).singleResult();
            if (task == null) {
                throw new ServiceException("该任务您无权受理");
            }
        }
        BPMetaForm form = getMetaForm(req, task);
        // 查询表单，封装
        fd.setLayoutInfo(JsonUtils.parseJSON(form.getLayout(), LayoutInfo.class));
        // 查询字段
        Map<String, List<CheckRuleInfo>> checkrules = getFieldCheckRule(req);
        SolutionUtil.joinCheckRuleFieldForm(checkrules, form.getCheckRules());
        fd.setCheckrules(checkrules);
        // 查询值
        Map<String, Attr> attrs = getAttrs(req);
        fd.setAttrs(attrs);
        if(req.getCustomerId().equals("-1")){//没有客户信息，默认自动创建客户，放开客户信息的input填写权限
        	LayoutInfo layoutInfo = fd.getLayoutInfo();
        	if(layoutInfo.getGroups().size() > 0){
        		TabInfo tabInfo = layoutInfo.getGroups().get(0);	
        		for(GroupInfo groupInfo : tabInfo.getTabList()){
        			if(groupInfo.getLabel().equals("客户基本信息")){
        				for(EditorInfo editorInfo : groupInfo.getEditors()){
        					editorInfo.setReadonly(false);
        				}
        				break;
        			}
        		}
        	}
        	layoutInfo.getRules();
        }
        // 设置默认hidden的表单
        Map<String, String> defaultHidden = SolutionUtil.createDefaultHidden(req);
        fd.setDefaultHidden(defaultHidden);
        fd.setOperations(getOperations(req, task));
        return fd;
    }

    @Override
    public FormData queryNodeFormData4View(FormQuery req) {
        FormData fd = new FormData();
        BPMetaForm form = getMetaForm(req, null);
        // 查询表单，封装
        fd.setLayoutInfo(JsonUtils.parseJSON(form.getLayout(), LayoutInfo.class));
        // 查询字段

        // Map<String, List<CheckRuleInfo>> checkrules = getFieldCheckRule(req);
        // SolutionUtil.joinCheckRuleFieldForm(checkrules, form.getCheckRules());
        // fd.setCheckrules(checkrules);
        // 查询值
        Map<String, Attr> attrs = getAttrs(req);
        fd.setAttrs(attrs);
        // 设置默认hidden的表单
        Map<String, String> defaultHidden = SolutionUtil.createDefaultHidden(req);
        fd.setDefaultHidden(defaultHidden);
        BPOperLog log = OperLogUtil.createViewLog(req);
        operLogService.insert(log);
        return fd;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    public void restart(RestartReq req) throws ServiceException {
        BP bp = bpdao.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        bp.setEngineKey(null);
        bp.setBpStatus(BpStatus.LOAN_BEFORE.getStatus());
        bp.setCurrentTaskId(null);
        bp.setCurrentTaskKey(null);
        bp.setDomain(req.getDomain());
        bp.setUpdateTime(new Date());
        bp.setCurrentTaskName(null);
        // bp.setFeeConfig(productDAO.selectFeeConfig(bp.getProductType()));
        // 修改BP重置状态。 提交bp
        bpdao.update(bp);
        BpMetaCorpProductVO meta = bpMetaDAO.selectMetaByProduct(new BpMetaQueryReq(bp.getProductType(), true, req
                .getDomain()));
        FormQuery q = new FormQuery();
        q.setBpDefId(meta.getBpDefId());
        q.setBpDefKey(meta.getBpDefKey());
        q.setBpId(bp.getBpId());
        q.setCorpId(req.getCorpId());
        q.setDomain(req.getDomain());
        q.setUserId(req.getUserId());
        q.setUserName(req.getUserName());
        BPLoan loan = bpLoanDAO.selectByBp(q);
        q.setCustomerId(loan.getCustomerId());
        q.setProductId(meta.getProductKey());
        this.saveDraft(q, new HashMap<String, String>());
    }

    private BP saveBpsLoanAttr(FormQuery req, Map<String, String> formdata) {
        // 创建BPS
        BP bp = new BP();
        bp.setBpDefId(req.getBpDefId());
        bp.setBpId(req.getBpId());
        bp.setBpNo(IdUtil.generateBPNo(req.getProductId()));
        bp.setBpStatus(BpStatus.LOAN_BEFORE.getStatus());
        bp.setCorpId(req.getCorpId());
        bp.setCreateTime(new Date());
        bp.setCreateUserId(req.getUserId());
        bp.setProductType(req.getProductId());
        bp.setUpdateTime(new Date());
        bp.setDomain(req.getDomain());
        if (StringUtils.isBlank(req.getChannel())) {
            bp.setChannel(LoanChannel.LEDAI.getStatus());
        } else {
            bp.setChannel(req.getChannel());
        }
        // bp.setFeeConfig(productDAO.selectFeeConfig(bp.getProductType()));
        bpdao.insertBp(bp);
        req.setBpId(bp.getBpId());
        // 创建loan
        BPLoan loan = new BPLoan(bp.getCorpId(), bp.getBpId());
        loan.setCustomerId(req.getCustomerId());
        productFormFactory.getHandler(req.getProductId()).fillLoan(loan, formdata);
        loan.setDomain(req.getDomain());
        bpLoanDAO.insertLoan(loan);
        productFormFactory.getHandler(req.getProductId()).hasLoan(req, loan);
        // 放入ATTR
        List<BPMetaField> fileds = bpMetaFieldDAO.findFieldKey(req);
        List<BPAttr> attrs = new ArrayList<BPAttr>();
        List<BPBigAttr> bigattrs = new ArrayList<BPBigAttr>();
        // 把所有的field先插入到attr和bigattr里
        SolutionUtil.translateFormdata2Attr(attrs, bigattrs, fileds, req, formdata);
        for (BPAttr attr : attrs) {
            bpAttrDAO.insertAttr(attr);
        }
        for (BPBigAttr attr : bigattrs) {
            bpBigAttrDAO.insertBigAttr(attr);
        }
        return bp;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    public void saveDraft(FormQuery req, Map<String, String> formdata) throws ServiceException {
        try {
            if (StringUtils.isBlank(req.getTaskId())) {
                ProcessStartCmd cmd = CmdUtil.createStartCmd(req, formdata);
                // 开始节点，推进节点，
                this.submitStartForm(req, formdata, cmd, true);
            } else {
                if (StringUtils.isBlank(req.getBpId())) {
                    throw new ServiceException("数据异常");
                }
                // 不是开始节点，不推进流程，不记录操作日志，更新草稿值
                this.saveTaskDraft(req, formdata);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("保存草稿出错" + e.getMessage());
            throw e;
        } finally {
            ProcessHandleHelper.clearProcessCmd();
            ProcessHandleHelper.clearBackPath();
        }
    }

    private void saveTaskDraft(FormQuery req, Map<String, String> formdata) throws ServiceException {
        // 更新bpattr的值
        // 根据TASKID 获得task的key，这样才能拿到表单
        Task task = taskService.createTaskQuery().processDefinitionKey(req.getBpDefKey())
                .taskCandidateOrAssigned(req.getUserId()).taskId(req.getTaskId()).singleResult();
        if (task == null) {
            throw new ServiceException("该任务您无权受理");
        } else {
            List<ModifyField> modifys = new ArrayList<ModifyField>();
            BP bp = bpdao.findById(req.getCorpId(), req.getDomain(), req.getBpId());
            List<BPMetaField> fileds = bpMetaFieldDAO.findFieldKey(req);
            // 修改attr的日志值
            List<BPAttr> attrs = new ArrayList<BPAttr>();
            List<BPBigAttr> bigattrs = new ArrayList<BPBigAttr>();
            Map<String, String> fieldMap = new HashMap<String, String>();
            for (BPMetaField f : fileds) {
                fieldMap.put(f.getFieldKey(), f.getFieldName());
                if (StringUtils.equals(f.getFieldTable(), SolutionUtil.ATTR_TYPE)) {
                    String oldValue = bpAttrDAO.selectDraftValueByNameBpId(new BPAttr(null, null, req.getBpId(), f
                            .getFieldKey(), formdata.get(f.getFieldKey()), null, null, req.getDomain()));
                    if (formdata.get(f.getFieldKey()) == null
                            || StringUtils.equals(oldValue, formdata.get(f.getFieldKey()))) {
                        continue;
                    } else {
                        attrs.add(new BPAttr(null, null, req.getBpId(), f.getFieldKey(), formdata.get(f.getFieldKey()),
                                null, null, req.getDomain()));
                    }

                    // 修改值
                    // int i = bpAttrDAO.updateDraftByNameBpId(new BPAttr(null, null, req.getBpId(), f.getFieldKey(),
                    // null, formdata.get(f.getFieldKey()), null, req.getDomain()));
                    // if (i > 0) {
                    // // 记录字段修改日志
                    // modifys.add(new ModifyField(f.getFieldName(), oldValue, formdata.get(f.getFieldKey())));
                    // }
                } else if (StringUtils.equals(f.getFieldTable(), SolutionUtil.ATTR_TYPE_BIG)) {
                    String oldValue = bpBigAttrDAO.selectValueByNameBpId(new BPBigAttr(null, null, req.getBpId(), f
                            .getFieldKey(), formdata.get(f.getFieldKey()), null, null, req.getDomain()));
                    if (formdata.get(f.getFieldKey()) == null
                            || StringUtils.equals(oldValue, formdata.get(f.getFieldKey()))) {
                        continue;
                    } else {
                        bigattrs.add(new BPBigAttr(null, null, req.getBpId(), f.getFieldKey(), formdata.get(f
                                .getFieldKey()), null, null, req.getDomain()));
                    }

                    // int i = bpBigAttrDAO.updateDraftByNameBpId(new BPBigAttr(null, null, req.getBpId(),
                    // f.getFieldKey(), null, formdata.get(f.getFieldKey()), null, req.getDomain()));
                    // if (i > 0) {
                    // // 记录字段修改日志
                    // modifys.add(new ModifyField(f.getFieldName(), oldValue, formdata.get(f.getFieldKey())));
                    // }
                }
            }
            // 一次性查询出本次传递值的原value然后对比
            if (!attrs.isEmpty()) {
                List<BPAttr> oldvalues = bpAttrDAO.selectBatch(attrs, req.getBpId(), req.getDomain());
                if (!oldvalues.isEmpty()) {
                    for (BPAttr bpAttr : oldvalues) {
                        if (StringUtils.equals(bpAttr.getDraftValue(), formdata.get(bpAttr.getAttrName()))) {
                            continue;
                        } else {
                            modifys.add(new ModifyField(fieldMap.get(bpAttr.getAttrName()), bpAttr.getAttrValue(),
                                    formdata.get(bpAttr.getAttrName())));
                            BPAttr tmp = new BPAttr();
                            BeanUtils.copyProperties(bpAttr, tmp);
                            tmp.setDraftValue(formdata.get(bpAttr.getAttrName()));
                            tmp.setDomain(req.getDomain());
                            bpAttrDAO.updateDraftByNameBpId(tmp);
                        }
                    }
                }
            }
            if (!bigattrs.isEmpty()) {
                List<BPBigAttr> oldbigvalues = bpBigAttrDAO.selectBatch(bigattrs, req.getBpId(), req.getDomain());
                if (!oldbigvalues.isEmpty()) {
                    for (BPBigAttr bpBigAttr : oldbigvalues) {
                        if (StringUtils.equals(bpBigAttr.getAttrValue(), formdata.get(bpBigAttr.getAttrName()))) {
                            continue;
                        } else {
                            modifys.add(new ModifyField(fieldMap.get(bpBigAttr.getAttrName()), null, null));
                            BPBigAttr tmp = new BPBigAttr();
                            BeanUtils.copyProperties(bpBigAttr, tmp);
                            tmp.setDraftValue(formdata.get(bpBigAttr.getAttrName()));
                            tmp.setDomain(req.getDomain());
                            bpBigAttrDAO.updateDraftByNameBpId(tmp);
                        }
                    }
                }
            }
            // 记录日志
            BPOperLog log = OperLogUtil.createDraftLog(req, bp, formdata, modifys, task);
            operLogService.insert(log);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    public BP submit(FormQuery req, Map<String, String> formdata) throws ServiceException {
        try {
            if (StringUtils.isBlank(req.getTaskId())) {
                ProcessStartCmd cmd = CmdUtil.createStartCmd(req, formdata);
                BP m = this.submitStartForm(req, formdata, cmd, false);
                return m;
            } else {
                ProcessNextCmd cmd = CmdUtil.createNextCmd(req, formdata);
                // 验证是否有权限操作
                this.submitTask(req, formdata, cmd);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("提交出错" + e.getMessage());
            throw e;
        } finally {
            ProcessHandleHelper.clearProcessCmd();
            ProcessHandleHelper.clearBackPath();
        }
        return null;
    }

    /**
     * @param draft 
     * 
     * @Title: submitStartForm
     * @Description: 提交开始表单
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    private BP submitStartForm(FormQuery req, Map<String, String> formdata, ProcessStartCmd cmd, boolean draft) {
        // 需要创建bps，loan，ATTR等
        BP bp = bpdao.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        boolean isold = false;
        List<ModifyField> modifyFields = null;
        if (bp == null) {
            bp = saveBpsLoanAttr(req, formdata);
        } else {
            isold = true;
            BPLoan loan = bpLoanDAO.selectByBp(req);
            // 恢复的单子，直接查出来就行了。因为他的值已经拷贝好了
            modifyFields = this.modifyBpsLoanAttr(req, formdata, bp, loan);
            // bp = bpdao.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        }
        validateFlowConfig(req, bp);
        BPMeta bpMeta = bpMetaDAO.findById(req.getCorpId(), req.getDomain(), req.getBpDefId());
        // 修改完毕后，提交activiti
        String buzKey = BPUtils.toBusinessKey(req.getCorpId(), bpMeta.getBpDefKey(), bpMeta.getVersion().split(":")[0],
                bp.getBpId(), bpMeta.getBpDefId());
        // 操作。
        // 查询节点的所有operation，如果存在operation在提交的时候 放到里面
        List<BPMetaOperation> operations = bpMetaOperationDAO.selectStartOperation(req.getCorpId(), req.getDomain(),
                bp.getBpDefId());
        SolutionUtil.validateOperations(operations, formdata);
        ProcessHandleHelper.setProcessCmd(cmd);
        // 提交开始表单
        if (draft) {
            formdata.put("oper_type", OperationType.SAVE.getStatus());
        } else {
            formdata.put("oper_type", OperationType.PASS.getStatus());
        }

        ProcessInstance process = formService.submitStartFormData(bpMeta.getEngineDefId(), buzKey,
                getSubmitFormData(formdata));
        // 流程实例
        bp.setEngineKey(process.getId());
        String pretask = bp.getCurrentTaskName();
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(process.getId()).orderByProcessInstanceId()
                .desc().list();
        SolutionUtil.bpFillTaskIdKey(tasks, bp);
        bp.setDomain(req.getDomain());
        bpdao.update(bp);

        // 发送通知到疾风交单
        applicationContext.publishEvent(new BpStatusChangeEvent(this, req.getDomain(), formdata.get("oper_type"), bp
                .getChannel(), req.getBpId(), bp.getCurrentTaskName(), req.getProductId(), (int) bp.getBpStatus(),
                null, formdata.get("reason")));

        // 日志再看 XXX发起了流程
        BPOperLog log = OperLogUtil.createStartLog(req, bp, isold, formdata, pretask, modifyFields);
        operLogService.insert(log);
        return bp;
    }

    /**
     * 
     * @Title: saveTask
     * @Description: 提交任务
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    private void submitTask(FormQuery req, Map<String, String> formdata, ProcessNextCmd cmd) {
        // 提交任务
        if (StringUtils.isBlank(req.getBpId()) || StringUtils.isBlank(req.getTaskId())) {
            throw new ServiceException("数据异常");
        }
        List<ModifyField> modifyFields = null;
        BP bp = bpdao.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        BPLoan loan = bpLoanDAO.selectByBp(req);
        Task task = taskService.createTaskQuery().processDefinitionKey(req.getBpDefKey())
                .taskCandidateOrAssigned(req.getUserId()).taskId(req.getTaskId()).singleResult();
        validateFlowConfig(req, bp);
        if (task == null) {
            throw new ServiceException("该任务您无权受理");
        } else {
            // 看看任务是否已经指派，如果没指派 认领
            try {
                taskService.claim(task.getId(), req.getUserId());
            } catch (ActivitiTaskAlreadyClaimedException e) {
                // 如果已经被别人认领
                throw new ServiceException("该任务已经被他人认领，您无权受理");
            }

        }
        String pretask = bp.getCurrentTaskName();
        String pretaskkey = bp.getCurrentTaskKey();
        List<BPMetaOperation> operations = bpMetaOperationDAO.selectNodeOperation(req.getCorpId(), req.getDomain(),
                bp.getBpDefId(), task.getTaskDefinitionKey());
        BPMetaOperation operationshas = SolutionUtil.validateOperations(operations, formdata);
        cmd.setActInstId(bp.getEngineKey());
        cmd.setNodeKey(task.getTaskDefinitionKey());
        ProcessHandleHelper.setProcessCmd(cmd);
        // 设置跳转的节点
        if (operationshas != null) {
            cmd.setOperaType(String.valueOf(operationshas.getOperType()));
            if (OperationType.BACK2PREV.getStatus().equals(String.valueOf(operationshas.getOperType()))) {
                // TODO 回退到上一个节点，特殊操作 查询执行路径 //
                // BPRunPath path = getBackPath(task.getProcessInstanceId(), task.getTaskDefinitionKey());
                // if(path){
                //
                // }
            } else {
                // 目标节点不为空
                if (StringUtils.isNotBlank(operationshas.getBinding())) {
                    // 拒绝 和回退到哪个节点
                    // 设置自由跳转节点
                    cmd.setDestNodeKey(operationshas.getBinding());
                }
            }
        } else {
            cmd.setOperaType(OperationType.PASS.getStatus());
        }
        cmd.setOption(formdata.get("reason"));
        ProcessHandleHelper.setProcessCmd(cmd);
        // 提交到ACTIVITI 如果目标节点不为空，则使用跳转方法。
        if (StringUtils.isNotBlank(cmd.getDestNodeKey())) {
            specialTaskService.completeTask(req.getTaskId(), new String[] { cmd.getDestNodeKey() });
        } else {
            formService.submitTaskFormData(req.getTaskId(), getSubmitFormData(formdata));
        }
        List<Task> tasks = taskService.createTaskQuery().processInstanceId(bp.getEngineKey())
                .orderByProcessInstanceId().desc().list();
        SolutionUtil.bpFillTaskIdKey(tasks, bp);
        // 判断流程是否结束，并赋值BPtask结束点
        isEnd(req, bp, operationshas, loan);

        // 调用乐位新增修改车辆接口
        if (StringUtils.equals(bp.getCurrentTaskName(), ",风控复核,")) {
            applicationContext.publishEvent(new FromSubmitEvent(this, req.getBpId(), req.getDomain(), req
                    .getProductId()));
        }

        // 发送通知到疾风交单
        applicationContext.publishEvent(new BpStatusChangeEvent(this, req.getDomain(), formdata.get("oper_type"), bp
                .getChannel(), req.getBpId(), bp.getCurrentTaskName(), req.getProductId(), (int) bp.getBpStatus(),
                null, formdata.get("reason")));

        // 改值 TODO 如果是退回或者拒绝 是不是不该填写？
        modifyFields = this.modifyBpsLoanAttr(req, formdata, bp, loan);
        BPOperLog log = OperLogUtil.createReviewLog(req, bp, formdata, operationshas, pretask, pretaskkey,
                modifyFields, task);
        operLogService.insert(log);
    }

    private void validateFlowConfig(FormQuery req, BP bp) {
        // 验证流程配置是否正常
        List<BpMetaNodeVO> list = bpMetaNodeDAO.selectBpMetaNodeMetaAllTask(req);
        BPMeta meta = bpMetaDAO.findById(req.getCorpId(), req.getDomain(), req.getBpDefId());
        StringBuilder sb = new StringBuilder();
        boolean pass = true;
        for (BpMetaNodeVO node : list) {
            boolean error = false;
            List<String> userIds = assignService.getUserIdsByNode(meta.getBpDefId(), node.getNodeKey(),
                    req.getCorpId(), req.getBpId());
            // 查看此单号有没有数据权限
            List<String> roleusers = corpDataRoleService.getPermissionByBpId(req.getBpId(), req.getCorpId());
            CorpDept dept = corpDeptDAO.selectDeptByUserId(bp.getCreateUserId());
            if (userIds.isEmpty()) {
                error = true;// 节点审批分配不对
                sb.append("节点【" + node.getNodeName() + "】审批分配有误！<br/>");
            }
            if (roleusers.isEmpty()) {
                error = true;// 部门数据权限没有
                sb.append("部门【" + dept.getDeptName() + "】数据权限配置有误！<br/>");
            }
            if (!error) {
                if (userIds.retainAll(roleusers)) {
                    if (userIds.isEmpty()) {
                        error = true;// 部门数据权限没有 审批分配的没有
                        sb.append("节点【" + node.getNodeName() + "】审批分配和部门【" + dept.getDeptName() + "】数据权限配置没有交集！<br/>");
                    }
                }
            }
            pass = pass & !error;
        }
        if (!pass) {
            throw new ServiceException(sb.toString());
        }

    }

}
