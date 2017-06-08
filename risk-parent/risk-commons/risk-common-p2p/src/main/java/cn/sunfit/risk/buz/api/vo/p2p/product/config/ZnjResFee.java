package cn.sunfit.risk.buz.api.vo.p2p.product.config;

import java.io.Serializable;
import java.util.List;

public class ZnjResFee implements Serializable {

    private String name = "滞纳金率";

    private List<String> fee;

    private String unit = "%";

    public List<String> getFee() {
        return fee;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public void setFee(List<String> fee) {
        this.fee = fee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
