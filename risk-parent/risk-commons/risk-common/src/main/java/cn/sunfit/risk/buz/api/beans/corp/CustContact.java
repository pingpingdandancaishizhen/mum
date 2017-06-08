package cn.sunfit.risk.buz.api.beans.corp;

import orj.worf.core.model.BaseObject;

public class CustContact extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String custId;

    private Integer index;

    private String relation;

    private String name;

    private boolean isknow;

    private String mobile;

    private String company;

    public String getCompany() {
        return company;
    }

    public String getCustId() {
        return custId;
    }

    public String getId() {
        return id;
    }

    public Integer getIndex() {
        return index;
    }

    public String getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getRelation() {
        return relation;
    }

    public boolean isIsknow() {
        return isknow;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public void setIsknow(boolean isknow) {
        this.isknow = isknow;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setRelation(String relation) {
        this.relation = relation == null ? null : relation.trim();
    }
}