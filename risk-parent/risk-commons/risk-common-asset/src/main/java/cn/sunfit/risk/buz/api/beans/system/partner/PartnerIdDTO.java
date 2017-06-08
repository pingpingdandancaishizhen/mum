package cn.sunfit.risk.buz.api.beans.system.partner;

import orj.worf.core.model.BaseObject;

public class PartnerIdDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 2499950271185187423L;

    private String domain;

    private String partnerId;

    private String corpId;

    public PartnerIdDTO() {

    }

    public PartnerIdDTO(String domain, String partnerId) {
        this.domain = domain;
        this.partnerId = partnerId;
    }

    public PartnerIdDTO(String domain, String partnerId, String corpId) {
        this.domain = domain;
        this.partnerId = partnerId;
        this.corpId = corpId;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getDomain() {
        return domain;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

}
