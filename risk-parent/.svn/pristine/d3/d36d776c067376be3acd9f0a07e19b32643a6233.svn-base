package cn.sunfit.risk.buz.api.constants;

public enum LoanEachTimeType {

    D15("D15", "15天", true),
    M1("M1", "1个月", false),
    M2("M2", "2个月", false),
    M3("M3", "3个月", false),
    M6("M6", "6个月", false),
    M12("M12", "12个月", false);

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (LoanEachTimeType userStatusType : LoanEachTimeType.values()) {
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
        for (LoanEachTimeType userStatusType : LoanEachTimeType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    public static LoanEachTimeType getTypeByStatus(String status) {
        for (LoanEachTimeType loanEachTimeType : LoanEachTimeType.values()) {
            if (loanEachTimeType.status.equals(status)) {
                return loanEachTimeType;
            }
        }
        return null;
    }

    private String status;

    private String label;

    private boolean disabled;

    LoanEachTimeType(String status, String label, boolean disabled) {
        this.status = status;
        this.label = label;
        this.disabled = disabled;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

}
