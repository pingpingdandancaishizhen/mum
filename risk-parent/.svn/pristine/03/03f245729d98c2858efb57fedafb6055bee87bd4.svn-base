package cn.sunfit.risk.buz.api.constants;

import org.apache.commons.lang3.StringUtils;

public enum UserStatusType {

    Active("0", "正常"),
    Suspended("1", "禁用"),
    delete("2", "删除");

    private String status;
    private String label;

    UserStatusType(String status, String label) {
        this.status = status;
        this.label = label;
    }

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (UserStatusType userStatusType : UserStatusType.values()) {
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
        for (UserStatusType userStatusType : UserStatusType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    /**
     * 检查用户状态是否正确
     */
    public static boolean validateStatus(String status) {
        if (StringUtils.isBlank(status)) {
            return false;
        }
        if (!UserStatusType.Active.getStatus().equals(status) && !UserStatusType.Suspended.getStatus().equals(status)
                && !UserStatusType.delete.getStatus().equals(status)) {
            return false;
        }
        return true;
    }

    /**
     * 检查用户状态的标签是否正确
     */
    public static boolean validateLabel(String label) {
        if (StringUtils.isBlank(label)) {
            return false;
        }
        if (!UserStatusType.Active.getLabel().equals(label) && !UserStatusType.Suspended.getLabel().equals(label)
                && !UserStatusType.delete.getLabel().equals(label)) {
            return false;
        }
        return true;
    }

    public String getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }

}
