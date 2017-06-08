package cn.sunfit.risk.buz.api.beans.system.partner;

import orj.worf.core.model.BaseObject;

public class PartnerProductRel extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1965649601292611875L;

    private String partnerId;

    private String productId;

    private String roleId;

    public PartnerProductRel() {

    }

    public PartnerProductRel(String partnerId, String productId, String roleId) {
        this.partnerId = partnerId;
        this.productId = productId;
        this.roleId = roleId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getProductId() {
        return productId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
