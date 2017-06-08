package cn.sunfit.risk.buz.api.constants.loan;

public enum LoanChannel {

    LEDAI("0", "乐贷"),
    JFJD("1", "疾风交单");

    public static LoanChannel getNameByStatus(String status) {
        for (LoanChannel loanStatus : LoanChannel.values()) {
            if (loanStatus.status.equals(status)) {
                return loanStatus;
            }
        }
        return null;
    }

    private final String status;

    private final String statusName;

    LoanChannel(String status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

}
