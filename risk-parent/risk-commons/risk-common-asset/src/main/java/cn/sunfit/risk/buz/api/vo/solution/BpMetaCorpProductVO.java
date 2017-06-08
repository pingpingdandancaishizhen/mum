package cn.sunfit.risk.buz.api.vo.solution;

import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
import cn.sunfit.risk.buz.api.constants.ProductType;

public class BpMetaCorpProductVO extends BPMeta {

    private static final long serialVersionUID = 1L;

    private String productName;

    private String productType;

    private String corpName;

    private String medium;

    public String getCorpName() {
        return corpName;
    }

    public String getMedium() {
        return medium;
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

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}
