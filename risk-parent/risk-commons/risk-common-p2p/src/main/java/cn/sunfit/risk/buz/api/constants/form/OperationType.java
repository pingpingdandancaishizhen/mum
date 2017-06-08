package cn.sunfit.risk.buz.api.constants.form;

/**
 * 
 * @Title: OperationType.java
 * @Package cn.sunfit.risk.buz.api.constants
 * @Description: 操作类型
 * @author XFL
 * @date 2017年1月16日 下午2:18:02
 * @version V1.0
 */
public enum OperationType {

    BACK("-1", "退回"),
    PASS("1", "通过"),
    SAVE("0", "保存"),
    REJECT("2", "拒绝"),
    BACK2PREV("3", "回退到上个节点");

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (OperationType userStatusType : OperationType.values()) {
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
        for (OperationType userStatusType : OperationType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    OperationType(String status, String label) {
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
