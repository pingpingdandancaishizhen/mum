package cn.sunfit.risk.buz.api.constants.system;

import org.apache.commons.lang3.StringUtils;

public enum StatusType {

    ENABLED("1", "启用"),
    DISABLED("0", "禁用"),
    DELETED("2", "删除");

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (StatusType userStatusType : StatusType.values()) {
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
        for (StatusType userStatusType : StatusType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    /**
     * 检查用户状态的标签是否正确
     */
    public static boolean validateLabel(String label) {
        if (StringUtils.isBlank(label)) {
            return false;
        }
        if (!StatusType.ENABLED.getLabel().equals(label) && !StatusType.DISABLED.getLabel().equals(label)
                && !StatusType.DELETED.getLabel().equals(label)) {
            return false;
        }
        return true;
    }

    /**
     * 检查状态是否正确
     */
    public static boolean validateStatus(String status) {
        if (StringUtils.isBlank(status)) {
            return false;
        }
        if (!StatusType.ENABLED.getStatus().equals(status) && !StatusType.DISABLED.getStatus().equals(status)
                && !StatusType.DELETED.getStatus().equals(status)) {
            return false;
        }
        return true;
    }

    private String status;

    private String label;

    StatusType(String status, String label) {
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
