package cn.sunfit.risk.buz.api.beans.corp;

import orj.worf.core.model.BaseObject;

public class District extends BaseObject {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String distCode;

    private String distName;

    private String parentCode;

    private Boolean effectTag;

    private String py;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistCode() {
        return distCode;
    }

    public void setDistCode(String distCode) {
        this.distCode = distCode == null ? null : distCode.trim();
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName == null ? null : distName.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public Boolean getEffectTag() {
        return effectTag;
    }

    public void setEffectTag(Boolean effectTag) {
        this.effectTag = effectTag;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py == null ? null : py.trim();
    }
}