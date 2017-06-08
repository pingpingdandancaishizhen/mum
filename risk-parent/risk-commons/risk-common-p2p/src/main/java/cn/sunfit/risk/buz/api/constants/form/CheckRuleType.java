package cn.sunfit.risk.buz.api.constants.form;

public enum CheckRuleType {

    NOT_EMPTY("notEmpty", "不为空"),
    FILE("file", "文件"), // 子属性 number 文件数, extension 文件后缀 maxSize 最大大小 type(image/jpeg)
    NUMBER("integer", "整数"), // 子属性 min max
    PHONE("phone", "手机号"), // 子属性
    TELEPHONE("telephone", "电话"),
    EMAIL("email", "电子邮箱"),
    REGEXP("regexp", "正则"), // 子属性 regexp
    LENGTH("length", "字符串长度"), // 子属性 length min max
    IDNUMBER("idnumber", "身份证号"), // 子属性
    DECIMAL("decimal", "小数"), // 子属性 digits 小数点后几位 min max
    EQUAL("equal", "与某相等"); //

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (CheckRuleType userStatusType : CheckRuleType.values()) {
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
        for (CheckRuleType userStatusType : CheckRuleType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    CheckRuleType(String status, String label) {
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
