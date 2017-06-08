package cn.sunfit.risk.buz.api.beans.corp;

import orj.worf.core.model.BaseObject;

public class CorpDeptListVO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -7547068069755870635L;

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
