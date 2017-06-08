package cn.sunfit.risk.buz.api.constants.customer;

public enum JobType {

    SXRS("1", "受薪人士"),
    ZGRS("2", "自雇人士"),
    QYGD("3", "企业股东");

    public static JobType getNameByStatus(String type) {
        for (JobType jobType : JobType.values()) {
            if (jobType.type.equals(type)) {
                return jobType;
            }
        }
        return null;
    }

    private final String type;

    private final String name;

    JobType(String type, String name) {
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
