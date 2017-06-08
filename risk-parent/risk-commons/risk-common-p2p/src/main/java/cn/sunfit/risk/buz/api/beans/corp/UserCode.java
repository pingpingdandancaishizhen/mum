package cn.sunfit.risk.buz.api.beans.corp;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class UserCode extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String code;

    private Date createTime;

    private String phone;

    private String codeType;

    private Date effectiveTime;

    private String status;

    public UserCode() {
        super();
    }

    public UserCode(String userId, String code, String codeType) {
        super();
        this.userId = userId;
        this.code = code;
        this.codeType = codeType;
        this.createTime = new Date();
    }

    public String getCode() {
        return code;
    }

    public String getCodeType() {
        return codeType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType == null ? null : codeType.trim();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}