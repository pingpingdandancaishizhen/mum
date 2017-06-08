package cn.sunfit.risk.buz.api.constants.repayment;

public enum RepaymentBaseStatus {

    REPAYMENT(0, "还款中"),
    OVERDUE(1, "逾期"),
    EARLY(2, "提前结清"),
    FINISH(3, "还款完成");

    public static RepaymentBaseStatus getNameByStatus(Integer status) {
        for (RepaymentBaseStatus repaymentBaseStatus : RepaymentBaseStatus.values()) {
            if (repaymentBaseStatus.status.equals(status)) {
                return repaymentBaseStatus;
            }
        }
        return null;
    }

    private final Integer status;

    private final String statusName;

    RepaymentBaseStatus(Integer status, String statusName) {
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
