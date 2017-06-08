package cn.sunfit.risk.buz.api.constants;

public enum PartnerRoleEmu {

    ROLE_SHI_CHANG_FANG("1", "市场方"),

    ROLE_CHU_JIE_REN("2", "出借人"),

    ROLE_DI_YA_QUAN_REN("3", "抵押权人"),

    ROLE_DAN_BAO_FANG("4", "担保方"),

    ROLE_SHOU_QUAN_FANG("5", "受权方"),

    ROLE_ZI_JIN_FANG("6", "资金方"),

    ROLE_FENG_KONG_FANG("7", "风控方");

    private String id;

    private String name;

    PartnerRoleEmu(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
