package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;

public class EachTime implements Serializable {

    private static final long serialVersionUID = 1L;

    private String eachTimeName;

    private String eachTime;

    public EachTime() {
        super();
        // TODO Auto-generated constructor stub
    }

    public EachTime(String eachTimeName, String eachTime) {
        super();
        this.eachTimeName = eachTimeName;
        this.eachTime = eachTime;
    }

    public String getEachTime() {
        return eachTime;
    }

    public String getEachTimeName() {
        return eachTimeName;
    }

    public void setEachTime(String eachTime) {
        this.eachTime = eachTime;
    }

    public void setEachTimeName(String eachTimeName) {
        this.eachTimeName = eachTimeName;
    }

}
