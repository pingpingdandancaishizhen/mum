package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;

public class BzjFee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer bzjStart;

    private Integer bzjEnd;

    private Double bzjFee;

    public Integer getBzjEnd() {
        return bzjEnd;
    }

    public Double getBzjFee() {
        return bzjFee;
    }

    public Integer getBzjStart() {
        return bzjStart;
    }

    public void setBzjEnd(Integer bzjEnd) {
        this.bzjEnd = bzjEnd;
    }

    public void setBzjFee(Double bzjFee) {
        this.bzjFee = bzjFee;
    }

    public void setBzjStart(Integer bzjStart) {
        this.bzjStart = bzjStart;
    }

}
