package cn.sunfit.risk.buz.api.beans.metadata;

import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.constants.AssignRelateType;
import cn.sunfit.risk.buz.api.constants.AssignType;

public class BPMetaNodeAssign extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String assignId;

    private String assignType;

    private String relateId;

    private String relateName;
    private String relateType;
    private Integer relateGroup;
    private Date createTime;

    private String createUserId;

    private String corpId;

    private String nodeId;

    private String domain;

    private String bpDefId;

    public String getAssignId() {
        return assignId;
    }

    public String getAssignType() {
        return assignType;
    }

    public String getAssignTypeStr() {
        return AssignType.getLabelByStatus(this.assignType);
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getCorpId() {
        return corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getDomain() {
        return domain;
    }

    public String getNodeId() {
        return nodeId;
    }

    public Integer getRelateGroup() {
        return relateGroup;
    }

    public String getRelateId() {
        return relateId;
    }

    public String getRelateName() {
        return relateName;
    }

    public String getRelateType() {
        return relateType;
    }

    public String getRelateTypeStr() {
        return AssignRelateType.getLabelByStatus(this.relateType);
    }

    public void setAssignId(String assignId) {
        this.assignId = assignId == null ? null : assignId.trim();
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType == null ? null : assignType.trim();
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public void setRelateGroup(Integer relateGroup) {
        this.relateGroup = relateGroup;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId == null ? null : relateId.trim();
    }

    public void setRelateName(String relateName) {
        this.relateName = relateName == null ? null : relateName.trim();
    }

    public void setRelateType(String relateType) {
        this.relateType = relateType;
    }
}