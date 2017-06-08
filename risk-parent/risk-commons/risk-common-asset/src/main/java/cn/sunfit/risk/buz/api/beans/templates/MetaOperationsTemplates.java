package cn.sunfit.risk.buz.api.beans.templates;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class MetaOperationsTemplates extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String operationId;

    private String bpDefId;

    private String operKey;

    private String operName;

    private String operDesc;

    private String binding;

    private String isBasic;

    private String preCondition;

    private String postCondition;

    private Date updateTime;

    private String operType;
    private String nodeKey;

    public String getBinding() {
        return binding;
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getIsBasic() {
        return isBasic;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getOperDesc() {
        return operDesc;
    }

    public String getOperKey() {
        return operKey;
    }

    public String getOperName() {
        return operName;
    }

    public String getOperType() {
        return operType;
    }

    public String getPostCondition() {
        return postCondition;
    }

    public String getPreCondition() {
        return preCondition;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId == null ? null : bpDefId.trim();
    }

    public void setIsBasic(String isBasic) {
        this.isBasic = isBasic == null ? null : isBasic.trim();
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc == null ? null : operDesc.trim();
    }

    public void setOperKey(String operKey) {
        this.operKey = operKey == null ? null : operKey.trim();
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public void setPostCondition(String postCondition) {
        this.postCondition = postCondition == null ? null : postCondition.trim();
    }

    public void setPreCondition(String preCondition) {
        this.preCondition = preCondition == null ? null : preCondition.trim();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}