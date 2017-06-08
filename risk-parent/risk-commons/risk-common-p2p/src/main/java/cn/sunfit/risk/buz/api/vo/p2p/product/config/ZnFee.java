package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;

public class ZnFee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String znlStart;

    private String znlEnd;

    private Double znlFee;

    private String termText;

    private Double znlRate;

    private String termVal;

    public String getTermText() {
        return termText;
    }

    public String getTermVal() {
        return termVal;
    }

    public String getZnlEnd() {
        return znlEnd;
    }

    public Double getZnlFee() {
        return znlFee;
    }

    public Double getZnlRate() {
        return znlRate;
    }

    public String getZnlStart() {
        return znlStart;
    }

    public void setTermText(String termText) {
        this.termText = termText;
    }

    public void setTermVal(String termVal) {
        this.termVal = termVal;
    }

    public void setZnlEnd(String znlEnd) {
        this.znlEnd = znlEnd;
    }

    public void setZnlFee(Double znlFee) {
        this.znlFee = znlFee;
    }

    public void setZnlRate(Double znlRate) {
        this.znlRate = znlRate;
    }

    public void setZnlStart(String znlStart) {
        this.znlStart = znlStart;
    }

}
