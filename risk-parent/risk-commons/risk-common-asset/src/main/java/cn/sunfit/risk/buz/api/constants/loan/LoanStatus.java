package cn.sunfit.risk.buz.api.constants.loan;

public enum LoanStatus {

    UNSTARTED(0, "未放款"),
    DOING(1, "待放款"),
    DONE(2, "放款完成");

    public static LoanStatus getNameByStatus(Integer status) {
        for (LoanStatus loanStatus : LoanStatus.values()) {
            if (loanStatus.status.equals(status)) {
                return loanStatus;
            }
        }
        return null;
    }

    private final Integer status;

    private final String statusName;

    LoanStatus(Integer status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public Integer getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

}
