package cn.sunfit.risk.buz.api.beans.contract;

import orj.worf.core.model.BaseObject;

public class TempIdDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 2499950271185187423L;

    private String domain;

    private String tempId;

    private String corpId;

    private String roleId;

    public TempIdDTO() {

    }

    public TempIdDTO(String domain, String tempId) {
        this.domain = domain;
        this.tempId = tempId;
    }

    public TempIdDTO(String domain, String tempId, String corpId) {
        this.domain = domain;
        this.tempId = tempId;
        this.corpId = corpId;
    }

    public TempIdDTO(String domain, String tempId, String corpId, String roleId) {
        this.domain = domain;
        this.tempId = tempId;
        this.corpId = corpId;
        this.roleId = roleId;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getDomain() {
        return domain;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

}
