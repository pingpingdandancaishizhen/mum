package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;

public class CydMonthFee extends CydMonthlyFee implements Serializable {

    private String name = "综合月利率";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
