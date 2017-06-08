package cn.sunfit.risk.buz.api.beans.p2p;

import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.constants.asset.ProductMedium;
import cn.sunfit.risk.buz.api.constants.asset.ProductType;
import cn.sunfit.risk.buz.api.vo.corp.P2PProductAddReq;

public class P2PProduct extends BaseObject {
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

    private String productCode;

    private String domain;

    public P2PProduct convert(P2PProductAddReq req) {
        this.setAssetId(req.getAssetId());
        this.setCorpId(req.getCorpId());
        this.setDesc(req.getDesc());
        this.setFeeConfig(req.getFeeConfig());
        this.setMedium(req.getMedium());
        this.setProductCode(req.getProductCode());
        this.setProductName(req.getProductName());
        this.setProductType(req.getProductType());
        this.setStatus(req.getStatus());
        return this;

    }

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

    public String getDomain() {
        return domain;
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

    public String getProductCode() {
        return productCode;
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
        this.desc = desc == null ? null : desc.trim();
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}