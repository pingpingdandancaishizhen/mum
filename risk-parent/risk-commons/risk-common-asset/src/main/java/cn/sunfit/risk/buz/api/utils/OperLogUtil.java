package cn.sunfit.risk.buz.api.utils;

import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.buz.BPOperLog;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;
import cn.sunfit.risk.buz.api.constants.OperationLogContent;
import cn.sunfit.risk.buz.api.constants.OperationLogType;
import cn.sunfit.risk.buz.api.constants.OperationType;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.form.ModifyField;
import cn.sunfit.risk.buz.api.vo.loan.AssignReq;

public class OperLogUtil {

    public static BPOperLog createAssignLog(AssignReq req, BP bp, CorpUserDTO oldUser, CorpUserDTO newUser) {
        BPOperLog log = new BPOperLog();
        log.setBpId(req.getBpId());
        log.setContent(String.format(OperationLogContent.ASSIGN_LOAN_LOG, req.getUserName(), oldUser.getUserName(),
                newUser.getUserName()));
        log.setCorpId(req.getCorpId());
        log.setCurtask(bp.getCurrentTaskName());
        log.setDomain(req.getDomain());
        log.setFieldDetail(null);
        log.setLogOperType(null);
        log.setLogType(OperationLogType.SIMPLE.getStatus());
        log.setPretask(bp.getCurrentTaskName());
        log.setReason(null);
        log.setUserId(req.getUserId());
        log.setUserName(req.getUserName());
        return log;
    }

    public static BPOperLog createDraftLog(FormQuery req, BP bp, Map<String, String> formdata,
            List<ModifyField> modifyFields, Task task) {
        BPOperLog log = new BPOperLog();
        log.setBpId(req.getBpId());
        StringBuilder sb = new StringBuilder();
        if (modifyFields != null && !modifyFields.isEmpty()) {
            sb.append("【修改属性值如下】<br/>");
            for (ModifyField mf : modifyFields) {
                if (!StringUtils.equals(mf.getOldValue(), mf.getValue())
                        && !(StringUtils.isBlank(mf.getOldValue()) && StringUtils.isBlank(mf.getValue()))) {
                    sb.append(mf.getFieldName()).append("由").append("【")
                            .append(mf.getOldValue() != null ? mf.getOldValue() : "").append("】修改为【")
                            .append(mf.getValue() != null ? mf.getValue() : "").append("】<br/>");
                }
            }
        }
        log.setContent(String.format(OperationLogContent.DRAFT_LOAN_LOG, req.getUserName()) + sb.toString());
        log.setCorpId(req.getCorpId());
        log.setCurtask(bp.getCurrentTaskName());
        log.setDomain(req.getDomain());
        log.setFieldDetail(JsonUtils.toJSON(formdata));
        log.setLogOperType(OperationType.SAVE.getStatus());
        log.setLogType(OperationLogType.SIMPLE.getStatus());
        log.setPretask(bp.getCurrentTaskName());
        log.setReason(null);
        log.setUserId(req.getUserId());
        log.setUserName(req.getUserName());
        log.setBpDefId(bp.getBpDefId());
        log.setHandleTaskKey(task.getTaskDefinitionKey());
        log.setHandleTaskName(task.getName());
        log.setCurtaskkey(bp.getCurrentTaskKey());
        return log;
    }

    public static BPOperLog createReviewLog(FormQuery req, BP bp, Map<String, String> formdata,
            BPMetaOperation operationshas, String pretask, String pretaskkey, List<ModifyField> modifyFields, Task task) {

        BPOperLog log = new BPOperLog();
        log.setBpId(req.getBpId());

        log.setCorpId(req.getCorpId());
        log.setCurtask(bp.getCurrentTaskName());
        log.setDomain(req.getDomain());
        log.setFieldDetail(JsonUtils.toJSON(formdata));
        if (operationshas != null) {
            // 有操作
            log.setLogOperType(formdata.get("oper_type"));
            log.setReason(formdata.get("reason"));
        } else {
            // 没有操作只是提交
            log.setLogOperType(OperationType.PASS.getStatus());
        }

        log.setLogType(OperationLogType.REVIEW.getStatus());
        log.setPretask(pretask);
        log.setUserId(req.getUserId());
        log.setUserName(req.getUserName());
        StringBuilder sb = new StringBuilder();
        sb.append(",流程状态由【").append(pretask).append("】变更为【").append(bp.getCurrentTaskName()).append("】<br/>");
        sb.append("审批结果【").append(OperationType.getLabelByStatus(log.getLogOperType())).append("】<br/>");
        sb.append("审批理由【").append(log.getReason() == null ? "" : log.getReason()).append("】<br/>");
        if (modifyFields != null && !modifyFields.isEmpty()) {
            sb.append("【修改属性值如下】<br/>");
            for (ModifyField mf : modifyFields) {
                if (!StringUtils.equals(mf.getOldValue(), mf.getValue())
                        && !(StringUtils.isBlank(mf.getOldValue()) && StringUtils.isBlank(mf.getValue()))) {
                    sb.append(mf.getFieldName()).append("由").append("【")
                            .append(mf.getOldValue() != null ? mf.getOldValue() : "").append("】修改为【")
                            .append(mf.getValue() != null ? mf.getValue() : "").append("】<br/>");
                }
            }
        }

        log.setContent(String.format(OperationLogContent.REVIEW_LOAN_LOG, req.getUserName()) + sb.toString());
        log.setBpDefId(bp.getBpDefId());
        log.setHandleTaskKey(task.getTaskDefinitionKey());
        log.setHandleTaskName(task.getName());
        log.setPretaskkey(pretaskkey);
        log.setCurtaskkey(bp.getCurrentTaskKey());
        return log;
    }

    /**
     * 
     * @Title: createStartLog
     * @Description: 开启流程日志，有开始流程，和回复流程
     * @param @param req
     * @param @param bp
     * @param @param isold
     * @param @param formdata
     * @param @param pretask
     * @param @param modifyFields
     * @param @return   
     * @return BPOperLog 
     * @author XFL 2017年1月16日 
     * @throws
     */
    public static BPOperLog createStartLog(FormQuery req, BP bp, boolean isold, Map<String, String> formdata,
            String pretask, List<ModifyField> modifyFields) {
        BPOperLog log = new BPOperLog();
        log.setBpId(req.getBpId());
        StringBuilder sb = new StringBuilder();
        if (modifyFields != null && !modifyFields.isEmpty()) {
            sb.append("【修改属性值如下】<br/>");
            for (ModifyField mf : modifyFields) {
                if (mf.getOldValue() == null && mf.getValue() == null) {
                    sb.append(mf.getFieldName()).append("由").append("【").append(mf.getOldValue()).append("】修改为【")
                            .append(mf.getValue()).append("】<br/>");
                }
            }
        }
        // TODO 这里回复单子有点问题。暂时不弄
        if (isold) {
            log.setContent(String.format(OperationLogContent.RECOVERY_LOAN_LOG, req.getUserName()));
        } else {
            log.setContent(String.format(OperationLogContent.START_LOAN_LOG, req.getUserName()));
        }
        log.setCorpId(req.getCorpId());
        log.setCurtask(bp.getCurrentTaskName());
        log.setDomain(req.getDomain());
        log.setFieldDetail(JsonUtils.toJSON(formdata));
        log.setLogOperType(null);
        log.setLogType(OperationLogType.SIMPLE.getStatus());
        log.setPretask(pretask);
        log.setReason(null);
        log.setUserId(req.getUserId());
        log.setUserName(req.getUserName());
        return log;

    }

    public static BPOperLog createViewLog(FormQuery req) {
        BPOperLog log = new BPOperLog();
        log.setBpId(req.getBpId());
        log.setContent(String.format(OperationLogContent.START_VIEW_LOG, req.getUserName()));
        log.setCorpId(req.getCorpId());
        log.setCurtask(null);
        log.setDomain(req.getDomain());
        log.setFieldDetail(null);
        log.setLogOperType(null);
        log.setLogType(OperationLogType.SIMPLE.getStatus());
        log.setPretask(null);
        log.setReason(null);
        log.setUserId(req.getUserId());
        log.setUserName(req.getUserName());
        return log;
    }
}
