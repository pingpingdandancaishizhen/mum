package cn.sunfit.risk.buz.api.constants.system;

public enum SystemNoticeStatus {

    CREATE("0", "已创建"),
    RELEASED("1", "已发布"),
    DISABLE("2", "已下架");

    private String status;

    private String statusName;

    SystemNoticeStatus(String status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

    public static SystemNoticeStatus getNameByStatus(String status) {
        for (SystemNoticeStatus systemNoticeStatus : SystemNoticeStatus.values()) {
            if (systemNoticeStatus.status.equals(status)) {
                return systemNoticeStatus;
            }
        }
        return null;
    }

}
