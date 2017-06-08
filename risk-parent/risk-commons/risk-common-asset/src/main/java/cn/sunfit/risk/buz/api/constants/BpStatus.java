package cn.sunfit.risk.buz.api.constants;

public enum BpStatus {

    LOAN_BEFORE((byte) 0, "贷前"),
    LOAN_ING((byte) 1, "贷中"),
    LOAN_AFTER((byte) 2, "贷后"),
    LOAN_FINISH((byte) 3, "贷款结束"),
    LOAN_FAIL((byte) 4, "贷款作废"),
    LOAN_REFUSE((byte) 5, "贷款拒绝");

    public static BpStatus getByStatus(Integer status) {
        if (status == null) {
            return null;
        }
        for (BpStatus userStatusType : BpStatus.values()) {
            if (userStatusType.status == status.intValue()) {
                return userStatusType;
            }
        }
        return null;
    }

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(byte status) {
        for (BpStatus userStatusType : BpStatus.values()) {
            if (userStatusType.status == status) {
                return userStatusType.getLabel();
            }
        }
        return "未知";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static byte getStatusByLabel(String label) {
        for (BpStatus userStatusType : BpStatus.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return -1;
    }

    private byte status;

    private String label;

    BpStatus(byte status, String label) {
        this.status = status;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public byte getStatus() {
        return status;
    }

}
