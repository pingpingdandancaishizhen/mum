package cn.sunfit.risk.buz.api.vo.p2p.activiti;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMeta;
import cn.sunfit.risk.buz.api.constants.asset.ProductType;

public class BpMetaCorpProductVO extends BPMeta {

    private static final long serialVersionUID = 1L;

    private String typeId;

    private String productType;

    private String corpName;

    private String medium;

    public String getCorpName() {
        return corpName;
    }

    public String getMedium() {
        return medium;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductTypeStr() {
        return ProductType.getLabelByStatus(getProductType());
    }

    public String getTypeId() {
        return typeId;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

}
