package cn.sunfit.risk.buz.api.constants.customer;

public enum CompanyType {

    JGSY("0", "机关事业"),
    GYGF("1", "国有股份"),
    WM("2", "外贸"),
    MY("3", "民营"),
    HZ("4", "合资"),
    GT("5", "个体"),
    SHTT("6", "社会团体");

    private final String type;

    private final String name;

    CompanyType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static CompanyType getNameByStatus(String type) {
        for (CompanyType companyType : CompanyType.values()) {
            if (companyType.type.equals(type)) {
                return companyType;
            }
        }
        return null;
    }

}
