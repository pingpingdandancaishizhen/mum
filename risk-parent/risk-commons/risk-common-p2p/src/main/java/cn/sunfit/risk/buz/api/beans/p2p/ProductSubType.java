package cn.sunfit.risk.buz.api.beans.p2p;

import orj.worf.core.model.BaseObject;

public class ProductSubType extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String typeId;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

}