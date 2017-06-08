package cn.sunfit.risk.buz.api.beans.system;

import orj.worf.core.model.BaseObject;

public class CarBrand extends BaseObject {
    private static final long serialVersionUID = 1L;

    private Integer brandId;

    private String brandName;

    private String logeImage;

    private String firstPinyin;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getLogeImage() {
        return logeImage;
    }

    public void setLogeImage(String logeImage) {
        this.logeImage = logeImage == null ? null : logeImage.trim();
    }

    public String getFirstPinyin() {
        return firstPinyin;
    }

    public void setFirstPinyin(String firstPinyin) {
        this.firstPinyin = firstPinyin == null ? null : firstPinyin.trim();
    }
}