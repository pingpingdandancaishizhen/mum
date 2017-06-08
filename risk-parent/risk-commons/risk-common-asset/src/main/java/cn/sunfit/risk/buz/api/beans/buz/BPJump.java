package cn.sunfit.risk.buz.api.beans.buz;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class BPJump extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String jumpId;

    private String bpDefId;

    private String engineKey;

    private String nodeKey;

    private String nodeName;

    private String taskId;

    private Date completeTime;

    private Integer duration;

    private Integer durationVal;

    private String handleId;

    private String ownerId;

    private String checkStatus;

    private String jumpType;

    private String remark;

    private String domain;

    private Date createTime;

    private String bpId;

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpId() {
        return bpId;
    }

    public String getCheckStatus() {
        return checkStatus;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getDomain() {
        return domain;
    }

    public Integer getDuration() {
        return duration;
    }

    public Integer getDurationVal() {
        return durationVal;
    }

    public String getEngineKey() {
        return engineKey;
    }

    public String getHandleId() {
        return handleId;
    }

    public String getJumpId() {
        return jumpId;
    }

    public String getJumpType() {
        return jumpType;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public String getNodeName() {
        return nodeName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getRemark() {
        return remark;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId == null ? null : bpDefId.trim();
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus == null ? null : checkStatus.trim();
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setDurationVal(Integer durationVal) {
        this.durationVal = durationVal;
    }

    public void setEngineKey(String engineKey) {
        this.engineKey = engineKey == null ? null : engineKey.trim();
    }

    public void setHandleId(String handleId) {
        this.handleId = handleId == null ? null : handleId.trim();
    }

    public void setJumpId(String jumpId) {
        this.jumpId = jumpId == null ? null : jumpId.trim();
    }

    public void setJumpType(String jumpType) {
        this.jumpType = jumpType == null ? null : jumpType.trim();
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey == null ? null : nodeKey.trim();
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }
}