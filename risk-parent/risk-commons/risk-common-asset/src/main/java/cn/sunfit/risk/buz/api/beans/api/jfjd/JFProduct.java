package cn.sunfit.risk.buz.api.beans.api.jfjd;

import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.constants.ProductMedium;
import cn.sunfit.risk.buz.api.constants.ProductType;

public class JFProduct extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String productName;

    private Date createTime;

    private Date lastmodTime;

    private String status;

    private String desc;

    private String productType;

    private String medium;

    private String feeConfig;

    private String requirements;

    public Date getCreateTime() {
        return createTime;
    }

    public String getDesc() {
        return desc;
    }

    public String getFeeConfig() {
        return feeConfig;
    }

    public String getId() {
        return id;
    }

    public Date getLastmodTime() {
        return lastmodTime;
    }

    public String getMedium() {
        return medium;
    }

    public String getMediumStr() {
        return ProductMedium.getLabelByStatus(getMedium());
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductTypeStr() {
        return ProductType.getLabelByStatus(getProductType());
    }

    public String getRequirements() {
        return requirements;
    }

    public String getStatus() {
        return status;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public void setFeeConfig(String feeConfig) {
        this.feeConfig = feeConfig;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setLastmodTime(Date lastmodTime) {
        this.lastmodTime = lastmodTime;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}