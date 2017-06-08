package cn.sunfit.risk.credit.api.constant;

public enum CJDOrderStatus {

    PASS("2", "报告审核通过"),
    DOING("3", "订单处理中"),
    REJECT("4", "订单被驳回"),
    NO_RECORD("5", "无维修保养记录"),
    BRAND_NOT_SUPPORT("6", "暂不支持品牌"),
    MAINTENANCE("8", "品牌数据维护中"),
    VIN_ERROR("10", "VIN错误"),
    CARNUM_ERROR("11", "车牌输入有误"),
    ENGIN_ERROR("13", "发动机输入有误");

    public static String getNameByStatus(String status) {
        for (CJDOrderStatus orderStatus : CJDOrderStatus.values()) {
            if (orderStatus.status.equals(status)) {
                return orderStatus.getName();
            }
        }
        return "";
    }

    private String status;

    private String name;

    private CJDOrderStatus(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

}
