package cn.sunfit.risk.buz.api.vo.corp;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;

import orj.worf.core.model.BaseObject;

public class P2PProductAddReq extends BaseObject {
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

    private String corpId;

    private String assetId;

    @NotBlank(message = "产品代码不能为空,请输入***")
    private String productCode;

    public String getAssetId() {
        return assetId;
    }

    public String getCorpId() {
        return corpId;
    }

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

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getStatus() {
        return status;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setFeeConfig(String feeConfig) {
        this.feeConfig = feeConfig;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastmodTime(Date lastmodTime) {
        this.lastmodTime = lastmodTime;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}