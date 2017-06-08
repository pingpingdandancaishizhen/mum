package cn.sunfit.risk.buz.api.vo.loan;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class LoanReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String productId;
    @NotBlank
    private String customerId;

    public LoanReq() {
        super();
    }

    public LoanReq(String productId, String customerId) {
        super();
        this.productId = productId;
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

}
