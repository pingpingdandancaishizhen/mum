package cn.sunfit.risk.buz.api.vo.system;

import java.io.Serializable;

public class CarBrandNodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

}
