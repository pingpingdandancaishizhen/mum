package cn.sunfit.risk.buz.api.constants;

import org.apache.commons.lang3.StringUtils;

public enum DeptStatusType {

    Active("0", "正常"),
    Suspended("1", "停用"),
    delete("2", "删除");

    private String status;
    private String label;

    DeptStatusType(String status, String label) {
        this.status = status;
        this.label = label;
    }

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (DeptStatusType deptStatusType : DeptStatusType.values()) {
            if (deptStatusType.status.equals(status)) {
                return deptStatusType.getLabel();
            }
        }
        return "";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static String getStatusByLabel(String label) {
        for (DeptStatusType deptStatusType : DeptStatusType.values()) {
            if (deptStatusType.label.equals(label)) {
                return deptStatusType.getStatus();
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
        if (!DeptStatusType.Active.getStatus().equals(status) && !DeptStatusType.Suspended.getStatus().equals(status)
                && !DeptStatusType.delete.getStatus().equals(status)) {
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
        if (!DeptStatusType.Active.getLabel().equals(label) && !DeptStatusType.Suspended.getLabel().equals(label)
                && !DeptStatusType.delete.getLabel().equals(label)) {
            return false;
        }
        return true;
    }

    /**
     * 检查用户状态的标签是否正确
     */
    public static DeptStatusType getDeptStatusByStatus(String status) {
        for (DeptStatusType deptStatusType : DeptStatusType.values()) {
            if (deptStatusType.status.equals(status)) {
                return deptStatusType;
            }
        }
        return null;
    }

    public String getStatus() {
        return status;
    }

    public String getLabel() {
        return label;
    }

}
