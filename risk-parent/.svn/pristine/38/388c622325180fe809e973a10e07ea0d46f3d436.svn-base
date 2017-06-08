package cn.sunfit.risk.buz.api.constants;

import org.apache.commons.lang3.StringUtils;

public enum RiskSystem {
    ZC("1", "资产系统"),
    P2P("2", "P2P审核系统");

    public static RiskSystem getSystemByCode(String code) {
        for (RiskSystem r : RiskSystem.values()) {
            if (StringUtils.equals(r.code, code)) {
                return r;
            }
        }
        return null;
    }

    private String code;

    private String name;

    private RiskSystem(String code, String name) {
        this.code = code;
        this.name = name;
    }

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
