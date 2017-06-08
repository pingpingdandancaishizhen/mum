package cn.sunfit.risk.buz.api.beans.util;

import orj.worf.core.model.BaseObject;

public class ContractField extends BaseObject {

    public static final String ITEM_TYPE_TEXT = "1";

    public static final String ITEM_TYPE_TABLE = "2";

    public static final String ITEM_TYPE_IMAGE = "3";

    /**
     * 
     */
    private static final long serialVersionUID = -6624272504326049295L;

    private String key;

    private Object value;

    private String type;

    public ContractField() {

    }

    public ContractField(String key, Object value, String type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public String getType() {
        return type;
    }

    public Object getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
