package cn.sunfit.risk.buz.api.beans.contract;

import orj.worf.core.model.BaseObject;

public class ProductVO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -3391894416354692869L;

    private String id;

    private String productName;

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
