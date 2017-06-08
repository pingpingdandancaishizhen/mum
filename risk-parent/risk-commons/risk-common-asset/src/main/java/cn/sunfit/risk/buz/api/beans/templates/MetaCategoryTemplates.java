package cn.sunfit.risk.buz.api.beans.templates;

import orj.worf.core.model.BaseObject;

public class MetaCategoryTemplates extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String categoryId;

    private String categoryKey;

    private String name;

    private String categoryDesc;

    private String bpDefId;

    public String getBpDefId() {
        return bpDefId;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public String getName() {
        return name;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey == null ? null : categoryKey.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}