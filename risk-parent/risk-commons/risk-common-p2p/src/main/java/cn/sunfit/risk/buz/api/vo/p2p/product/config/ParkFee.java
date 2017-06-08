package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;

public class ParkFee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String start;

    private String end;

    public String getEnd() {
        return end;
    }

    public String getStart() {
        return start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setStart(String start) {
        this.start = start;
    }

}
