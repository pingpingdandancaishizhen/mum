package cn.sunfit.risk.buz.api.beans.system.partner;

import orj.worf.core.model.BaseObject;

public class RoleProductIdDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 2499950271185187423L;

    private String domain;

    private String roleId;

    private String productId;

    public RoleProductIdDTO() {

    }

    public RoleProductIdDTO(String domain, String roleId, String productId) {
        this.domain = domain;
        this.roleId = roleId;
        this.productId = productId;
    }

    public String getDomain() {
        return domain;
    }

    public String getProductId() {
        return productId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

}
