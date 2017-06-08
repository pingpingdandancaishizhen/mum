package cn.sunfit.risk.buz.api.constants.order;

public enum LoanHandleType {
    XZJK("1", "新增"),
    JQZD("2", "结清再贷"),
    ZQ("3", "展期");


    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (LoanHandleType loanHandleType : LoanHandleType.values()) {
            if (loanHandleType.status.equals(status)) {
                return loanHandleType.getLabel();
            }
        }
        return "";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static String getStatusByLabel(String label) {
        for (LoanHandleType loanHandleType : LoanHandleType.values()) {
            if (loanHandleType.label.equals(label)) {
                return loanHandleType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    LoanHandleType(String status, String label) {
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
