package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;

public class ParkResFee extends ParkFee implements Serializable {

    private String name = "停车费";

    private String unit = "元";

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
