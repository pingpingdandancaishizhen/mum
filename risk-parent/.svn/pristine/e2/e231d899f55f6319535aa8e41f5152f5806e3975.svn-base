package cn.sunfit.risk.buz.api.constants.customer;

public enum MaritalStatus {

    single("0", "未婚"),
    merried("1", "已婚"),
    divorced("2", "离异"),
    remarry("3", "再婚"),
    widowed("4", "丧偶");

    private final String type;

    private final String name;

    MaritalStatus(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static MaritalStatus getNameByType(String type) {
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if (maritalStatus.type.equals(type)) {
                return maritalStatus;
            }
        }
        return null;
    }
}
