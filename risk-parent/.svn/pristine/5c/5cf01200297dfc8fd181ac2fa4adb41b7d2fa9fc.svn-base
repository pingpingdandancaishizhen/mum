package cn.sunfit.risk.credit.api.vo.cjd;

import java.io.Serializable;

import orj.worf.util.StringUtils;

public class CheckBrandQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vin;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public boolean validate() {
        return StringUtils.isNotEmpty(this.vin);
    }
}
