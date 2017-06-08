package cn.sunfit.risk.buz.api.constants;


public enum LoginChannel {

    WEB("1", "网页登录"),
    ANDROID("2", "安卓端登录"),
    IOS("3", "IOS端登录");

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (LoginChannel userStatusType : LoginChannel.values()) {
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
        for (LoginChannel userStatusType : LoginChannel.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    LoginChannel(String status, String label) {
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
