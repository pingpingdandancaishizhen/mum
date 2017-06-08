package cn.sunfit.risk.buz.api.beans.contract;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class CheckTempNameExisitReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = 1537094965984104295L;

    private String id;

    private String tempName;

    private String product;

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getTempName() {
        return tempName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

}
