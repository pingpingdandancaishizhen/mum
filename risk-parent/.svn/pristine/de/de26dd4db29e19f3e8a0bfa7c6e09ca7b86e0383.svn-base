package cn.sunfit.risk.buz.api.constants;

public enum FeeType {

    HTJE("HTJE", "合同金额", true),
    JKRSSJE("JKRSSJE", "借款人实收金额", false),
    ZXF("ZXF", "咨询费", true),
    YZHFY("YZHFY", "月综合费用", true),
    YLX("YLX", "月利息", true),
    YGLF("YGLF", "月管理费", true),
    BZJ("BZJ", "保证金", true),
    WYJ("WYJ", "违约金", true),
    DZJ("DZJ", "滞纳金", true),
    TCF("TCF", "停车费", true),
    TCFF("TCFF", "拖车费", true),
    GPSAZF("GPSAZF", "GPS安装费", true),
    GPSFWF("GPSFWF", "GPS服务费", true);

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (FeeType userStatusType : FeeType.values()) {
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
        for (FeeType userStatusType : FeeType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    private boolean related;

    FeeType(String status, String label, boolean realted) {
        this.status = status;
        this.label = label;
        this.related = realted;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

    public boolean isRelated() {
        return related;
    }

}
