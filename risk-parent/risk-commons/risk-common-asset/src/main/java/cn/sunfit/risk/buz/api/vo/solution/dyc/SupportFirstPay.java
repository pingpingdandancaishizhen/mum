package cn.sunfit.risk.buz.api.vo.solution.dyc;

import java.io.Serializable;

public class SupportFirstPay implements Serializable {
    private static final long serialVersionUID = 1L;

    private String payName;

    private String payType;

    public String getPayName() {
        return payName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

}
