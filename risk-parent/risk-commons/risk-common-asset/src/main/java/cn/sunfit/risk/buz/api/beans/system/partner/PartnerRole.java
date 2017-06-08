package cn.sunfit.risk.buz.api.beans.system.partner;

import orj.worf.core.model.BaseObject;

public class PartnerRole extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}