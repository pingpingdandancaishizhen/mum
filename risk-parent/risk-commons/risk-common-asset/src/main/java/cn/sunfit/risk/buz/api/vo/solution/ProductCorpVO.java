package cn.sunfit.risk.buz.api.vo.solution;

import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.constants.ProductType;
import cn.sunfit.risk.buz.api.constants.StatusType;

public class ProductCorpVO extends Product {
    private static final long serialVersionUID = 1L;

    private String corpId;

    private String corpName;

    public String getCorpId() {
        return corpId;
    }

    public String getCorpName() {
        return corpName;
    }

    public String getProductTypeStr() {
        return ProductType.getLabelByStatus(getProductType());
    }

    public String getStatusStr() {
        return StatusType.getLabelByStatus(getStatus());
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

}
