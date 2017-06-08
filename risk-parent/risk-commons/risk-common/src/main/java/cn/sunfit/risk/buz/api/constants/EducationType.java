package cn.sunfit.risk.buz.api.constants;

public enum EducationType {

    belowSenior("0", "高中以下"),
    senior("1", "高中"),
    juniorCollege("2", "中专"),
    seniorCollege("3", "大专"),
    university("4", "本科"),
    doctor("5", "硕士及以上");

    public static EducationType getNameByStatus(String type) {
        for (EducationType educationType : EducationType.values()) {
            if (educationType.type.equals(type)) {
                return educationType;
            }
        }
        return null;
    }

    private final String type;

    private final String name;

    EducationType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
