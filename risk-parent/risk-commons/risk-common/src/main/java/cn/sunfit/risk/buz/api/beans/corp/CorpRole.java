package cn.sunfit.risk.buz.api.beans.corp;

import java.util.Date;
import orj.worf.core.model.BaseObject;

public class CorpRole extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String corpId;

    private String roleName;

    private String desc;

    private String status;

    private String isCanModify;

    private Date createTime;

    private String isAdmin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIsCanModify() {
        return isCanModify;
    }

    public void setIsCanModify(String isCanModify) {
        this.isCanModify = isCanModify == null ? null : isCanModify.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin == null ? null : isAdmin.trim();
    }
}