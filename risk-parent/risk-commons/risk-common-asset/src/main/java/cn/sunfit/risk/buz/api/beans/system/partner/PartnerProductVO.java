package cn.sunfit.risk.buz.api.beans.system.partner;

import orj.worf.core.model.BaseObject;

public class PartnerProductVO extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String productId;

    private String productName;

    private String roleId;

    private String roleName;

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}