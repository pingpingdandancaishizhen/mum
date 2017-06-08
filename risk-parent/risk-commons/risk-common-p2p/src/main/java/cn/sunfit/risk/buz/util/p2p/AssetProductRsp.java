package cn.sunfit.risk.buz.util.p2p;

import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;

public class AssetProductRsp extends BaseObject {

    private static final long serialVersionUID = 1L;

    private String id;

    private String productName;

    private String productTypeStr;

    private Date createTime;

    private Date lastmodTime;

    private String status;

    private String productType;

    private CydFeeConfig cydfeeConfig;

    private String corpId;

    private String assetId;

    private String productCode;

    private String desc;

    public AssetProductRsp convert(P2PProduct product) {
        this.setAssetId(product.getAssetId());
        this.setCorpId(product.getCorpId());
        this.setProductCode(product.getProductCode());
        this.setProductName(product.getProductName());
        this.setProductType(product.getProductType());
        this.setStatus(product.getStatus());
        this.setId(product.getId());
        this.setDesc(product.getDesc());
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

    public CydFeeConfig getCydfeeConfig() {
        return cydfeeConfig;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public Date getLastmodTime() {
        return lastmodTime;
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
        return productTypeStr;
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

    public void setCydfeeConfig(CydFeeConfig cydfeeConfig) {
        this.cydfeeConfig = cydfeeConfig;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastmodTime(Date lastmodTime) {
        this.lastmodTime = lastmodTime;
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

    public void setProductTypeStr(String productTypeStr) {
        this.productTypeStr = productTypeStr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}