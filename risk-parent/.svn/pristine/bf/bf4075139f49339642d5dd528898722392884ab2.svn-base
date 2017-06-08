package cn.sunfit.risk.buz.api.constants.form;

public enum AssignRelateType {

    AND("0", "交集"),
    OR("1", "并集"),
    NOT("2", "非");

    public static AssignRelateType getByStatus(String status) {
        for (AssignRelateType userStatusType : AssignRelateType.values()) {
            if (userStatusType.status.equals(status)) {
                return userStatusType;
            }
        }
        return null;
    }

    public static String getLabelByStatus(String status) {
        for (AssignRelateType userStatusType : AssignRelateType.values()) {
            if (userStatusType.status.equals(status)) {
                return userStatusType.getLabel();
            }
        }
        return "";
    }

    public static String getStatusByLabel(String label) {
        for (AssignRelateType userStatusType : AssignRelateType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    AssignRelateType(String status, String label) {
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
