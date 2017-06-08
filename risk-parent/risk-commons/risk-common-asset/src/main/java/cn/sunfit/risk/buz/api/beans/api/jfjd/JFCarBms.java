package cn.sunfit.risk.buz.api.beans.api.jfjd;

import orj.worf.core.model.BaseObject;

public class JFCarBms extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -8289272760363716231L;

    private String id;

    private String name;

    private String firstPinyin;

    public String getFirstPinyin() {
        return firstPinyin;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setFirstPinyin(String firstPinyin) {
        this.firstPinyin = firstPinyin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
