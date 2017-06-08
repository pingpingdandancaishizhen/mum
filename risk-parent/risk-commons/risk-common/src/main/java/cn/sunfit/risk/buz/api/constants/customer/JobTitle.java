package cn.sunfit.risk.buz.api.constants.customer;

public enum JobTitle {

    TJJ("0", "厅局级及以上"),
    CJ("1", "处级"),
    KJ("2", "科级"),
    YBGB("3", "一般干部"),
    ZJLJ("4", "总经理级"),
    BMJLJ("5", "部门经理级"),
    ZY("6", "职员"),
    QT("7", "其他");

    public static JobTitle getNameByStatus(String type) {
        for (JobTitle Jobtitle : JobTitle.values()) {
            if (Jobtitle.type.equals(type)) {
                return Jobtitle;
            }
        }
        return null;
    }

    private final String type;

    private final String name;

    JobTitle(String type, String name) {
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
