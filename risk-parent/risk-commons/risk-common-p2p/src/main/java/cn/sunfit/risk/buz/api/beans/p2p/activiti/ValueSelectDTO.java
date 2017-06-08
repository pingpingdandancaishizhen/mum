package cn.sunfit.risk.buz.api.beans.p2p.activiti;

import orj.worf.core.model.BaseObject;

public class ValueSelectDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 7222124956128557185L;

    private String fieldKey;

    private String fieldName;

    private String fieldValue;

    private String provider;

    public String getFieldKey() {
        return fieldKey;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public String getProvider() {
        return provider;
    }

    public void setFieldKey(String fieldKey) {
        this.fieldKey = fieldKey;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

}
