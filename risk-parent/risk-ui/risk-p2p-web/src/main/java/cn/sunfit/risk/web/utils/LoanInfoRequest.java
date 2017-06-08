package cn.sunfit.risk.web.utils;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class LoanInfoRequest extends ReqBase {
    private static final long serialVersionUID = 1L;

    @NotBlank
    private String productCode;
    @NotBlank
    private String term;// 如 “1M ,60D 等”
    @NotBlank
    private String loanMoney;
    @NotBlank
    private String repaymentType;

    public String getLoanMoney() {
        return loanMoney;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public String getTerm() {
        return term;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public void setTerm(String term) {
        this.term = term;
    }

}
