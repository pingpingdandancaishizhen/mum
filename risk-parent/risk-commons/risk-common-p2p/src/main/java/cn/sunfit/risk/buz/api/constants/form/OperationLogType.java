package cn.sunfit.risk.buz.api.constants.form;

/**
 * 
 * @Title: OperationType.java
 * @Package cn.sunfit.risk.buz.api.constants
 * @Description: 日志类型
 * @author XFL
 * @date 2017年1月16日 下午2:18:02
 * @version V1.0
 */
public enum OperationLogType {

    SIMPLE("1", "操作日志"),
    REVIEW("2", "审核日志");

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (OperationLogType userStatusType : OperationLogType.values()) {
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
        for (OperationLogType userStatusType : OperationLogType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    OperationLogType(String status, String label) {
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
