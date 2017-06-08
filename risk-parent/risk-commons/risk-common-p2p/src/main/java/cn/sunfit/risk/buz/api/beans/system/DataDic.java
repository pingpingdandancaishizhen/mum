package cn.sunfit.risk.buz.api.beans.system;

import orj.worf.core.model.BaseObject;

public class DataDic extends BaseObject {
    private static final long serialVersionUID = 1L;
    private String id;

    private String dicKey;

    private String dicValue;

    private String displayName;

    private String dicType;

    private Boolean dicStatus;

    private String description;

    private Boolean deleted;

    private String productId;

    private String corpId;

    private String bpDefId;


    public String getBpDefId() {
        return bpDefId;
    }

    public String getCorpId() {
        return corpId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public String getDescription() {
        return description;
    }

    public String getDicKey() {
        return dicKey;
    }

    public Boolean getDicStatus() {
        return dicStatus;
    }

    public String getDicType() {
        return dicType;
    }

    public String getDicValue() {
        return dicValue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }


    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }

    public void setDicStatus(Boolean dicStatus) {
        this.dicStatus = dicStatus;
    }

    public void setDicType(String dicType) {
        this.dicType = dicType;
    }

    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
