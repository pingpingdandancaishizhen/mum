package cn.sunfit.risk.buz.api.vo.system.partner;

import orj.worf.core.model.BaseObject;

public class PartnerSelectVO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -2317340831966027255L;

    private String id;

    private String name;

    private String role;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
