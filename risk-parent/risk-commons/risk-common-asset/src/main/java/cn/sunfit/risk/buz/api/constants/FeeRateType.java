package cn.sunfit.risk.buz.api.constants;

public enum FeeRateType {

    GPS("GPS", "GPS安装费"),
    WYL("WYL", "违约率"),
    BZJL("BZJL", "保证金率"),
    YGLFL("YGLFL", "月管理费"),
    YZHLL("YZHLL", "月综合利率");

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (FeeRateType userStatusType : FeeRateType.values()) {
            if (userStatusType.status.equals(status)) {
                return userStatusType.getLabel();
            }
        }
        return "";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static String getStatusByLabel(String label) {
        for (FeeRateType userStatusType : FeeRateType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    FeeRateType(String status, String label) {
        this.status = status;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

}
