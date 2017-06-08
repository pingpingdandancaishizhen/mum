package cn.sunfit.risk.buz.api.beans.api.jfjd;

import orj.worf.core.model.BaseObject;

public class JFRegion extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -2717320623691093878L;

    private String code;

    private String address;

    public String getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
