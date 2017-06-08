package cn.sunfit.risk.buz.api.vo.system;

import java.io.Serializable;

public class ProvinceNodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String code;

    private String address;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
