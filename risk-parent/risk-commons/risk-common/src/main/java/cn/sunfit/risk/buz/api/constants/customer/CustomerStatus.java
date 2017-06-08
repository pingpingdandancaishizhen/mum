package cn.sunfit.risk.buz.api.constants.customer;

public enum CustomerStatus {

    CREATE("0", "新建"),
    APPLY("1", "删除");

    public static CustomerStatus getNameByStatus(String status) {
        for (CustomerStatus customerStatus : CustomerStatus.values()) {
            if (customerStatus.status.equals(status)) {
                return customerStatus;
            }
        }
        return null;
    }

    private final String status;

    private final String statusName;

    CustomerStatus(String status, String statusName) {
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
