package cn.sunfit.risk.credit.api.vo.nfcs;

import java.io.Serializable;

import orj.worf.util.StringUtils;

public class NFCSQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String JGB_PLATE = "1";

    private static final String TSJYB_PLATE = "3";

    private String idcard;

    private String name;

    private String plate;

    public String getIdcard() {
        return idcard;
    }

    public String getName() {
        return name;
    }

    public String getPlate() {
        return plate;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean validate() {
        if (StringUtils.isNotEmpty(this.name) && StringUtils.isNotEmpty(this.idcard)
                && StringUtils.isNotEmpty(this.plate)) {
            if (StringUtils.equals(this.plate, JGB_PLATE) || StringUtils.equals(this.plate, TSJYB_PLATE)) {
                return true;
            }
        }
        return false;
    }

}
