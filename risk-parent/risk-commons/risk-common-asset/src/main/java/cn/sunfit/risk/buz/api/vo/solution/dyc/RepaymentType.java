package cn.sunfit.risk.buz.api.vo.solution.dyc;

import java.io.Serializable;
import java.util.List;

public class RepaymentType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String repaymentType;

    private String repaymentTypeName;

    private List<SupportFirstPay> supportFirstPay;

    public String getRepaymentType() {
        return repaymentType;
    }

    public String getRepaymentTypeName() {
        return repaymentTypeName;
    }

    public List<SupportFirstPay> getSupportFirstPay() {
        return supportFirstPay;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType;
    }

    public void setRepaymentTypeName(String repaymentTypeName) {
        this.repaymentTypeName = repaymentTypeName;
    }

    public void setSupportFirstPay(List<SupportFirstPay> supportFirstPay) {
        this.supportFirstPay = supportFirstPay;
    }

}
