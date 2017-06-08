package cn.sunfit.risk.buz.api.constants;

public enum ParamsType {
	ATTACH("attach","附件");


    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (ParamsType paramsType : ParamsType.values()) {
            if (paramsType.status.equals(status)) {
                return paramsType.getLabel();
            }
        }
        return "";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static String getStatusByLabel(String label) {
        for (ParamsType paramsType : ParamsType.values()) {
            if (paramsType.label.equals(label)) {
                return paramsType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    ParamsType(String status, String label) {
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
