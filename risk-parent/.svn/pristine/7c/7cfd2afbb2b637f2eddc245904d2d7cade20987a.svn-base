package cn.sunfit.risk.buz.api.constants.customer;

public enum GenderType {

    MALE("1", "男"),
    FEMALE("0", "女");

    private final String type;

    private final String name;

    GenderType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static GenderType getNameByStatus(String type) {
        for (GenderType genderType : GenderType.values()) {
            if (genderType.type.equals(type)) {
                return genderType;
            }
        }
        return null;
    }

}
