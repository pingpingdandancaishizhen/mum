package cn.sunfit.risk.buz.api.beans.corp;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class Corp extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String simpleName;

    private String corpName;

    private String linkMan;

    private String linkPhone;

    private String address;

    private String addressDetail;

    private String status;

    private String url;

    private Date createTime;

    private String domain;

    private String descc;

    private String logo;

    private String systems;

    public String getAddress() {
        return address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public String getCorpName() {
        return corpName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getDescc() {
        return descc;
    }

    public String getDomain() {
        return domain;
    }

    public String getId() {
        return id;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public String getLogo() {
        return logo;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public String getStatus() {
        return status;
    }

    public String getSystems() {
        return systems;
    }

    public String getUrl() {
        return url;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan == null ? null : linkMan.trim();
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName == null ? null : simpleName.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setSystems(String systems) {
        this.systems = systems;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}