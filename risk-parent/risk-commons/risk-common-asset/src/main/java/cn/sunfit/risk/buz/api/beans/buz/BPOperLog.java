package cn.sunfit.risk.buz.api.beans.buz;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class BPOperLog extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String logId;

    private String corpId;

    private String bpId;

    private Date logTime;

    private String userId;

    private String logType;

    private String pretask;

    private String curtask;

    private String userName;

    private String reason;

    private String content;

    private String fieldDetail;

    private String domain;

    private String logOperType;
    // 新
    private String bpDefId;
    // 新
    private String handleTaskKey;
    // 新
    private String handleTaskName;
    // 新
    private String pretaskkey;
    // 新
    private String curtaskkey;

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpId() {
        return bpId;
    }

    public String getContent() {
        return content;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getCurtask() {
        return curtask;
    }

    public String getCurtaskkey() {
        return curtaskkey;
    }

    public String getDomain() {
        return domain;
    }

    public String getFieldDetail() {
        return fieldDetail;
    }

    public String getHandleTaskKey() {
        return handleTaskKey;
    }

    public String getHandleTaskName() {
        return handleTaskName;
    }

    public String getLogId() {
        return logId;
    }

    public String getLogOperType() {
        return logOperType;
    }

    public Date getLogTime() {
        return logTime;
    }

    public String getLogType() {
        return logType;
    }

    public String getPretask() {
        return pretask;
    }

    public String getPretaskkey() {
        return pretaskkey;
    }

    public String getReason() {
        return reason;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId == null ? null : bpId.trim();
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public void setCurtask(String curtask) {
        this.curtask = curtask == null ? null : curtask.trim();
    }

    public void setCurtaskkey(String curtaskkey) {
        this.curtaskkey = curtaskkey;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setFieldDetail(String fieldDetail) {
        this.fieldDetail = fieldDetail == null ? null : fieldDetail.trim();
    }

    public void setHandleTaskKey(String handleTaskKey) {
        this.handleTaskKey = handleTaskKey;
    }

    public void setHandleTaskName(String handleTaskName) {
        this.handleTaskName = handleTaskName;
    }

    public void setLogId(String logId) {
        this.logId = logId == null ? null : logId.trim();
    }

    public void setLogOperType(String logOperType) {
        this.logOperType = logOperType;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public void setLogType(String logType) {
        this.logType = logType == null ? null : logType.trim();
    }

    public void setPretask(String pretask) {
        this.pretask = pretask == null ? null : pretask.trim();
    }

    public void setPretaskkey(String pretaskkey) {
        this.pretaskkey = pretaskkey;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}