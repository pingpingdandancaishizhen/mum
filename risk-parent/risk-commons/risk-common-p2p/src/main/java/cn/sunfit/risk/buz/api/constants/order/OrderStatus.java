package cn.sunfit.risk.buz.api.constants.order;

import org.apache.commons.lang3.StringUtils;

public enum OrderStatus {

    ADD("1", "新增"),
    AUDIT("2", "P2P审核"),
    IMAGEAUDIT("3", "P2P影像审核"),
    CANCLE("10", "作废"),
    BACK("11", "已退回"),
    DFB("4", "待发标"),
    ZBZ("1001", "招标中"),
    MB("1002", "满标-复审待审核"),
    HKZ("1003", "还款中"),
    LB("1004", "流标"),
    YYQ("1005", "已逾期"),
    YHZ("1006", "已坏账"),
    YTQJQ("1007", "还款完成-提前结清"),
    YWC("1008", "还款完成");
    // ZFDD("0","作废订单"),
    // XZDD("1", "新增订单"),
    // P2PSH("2", "p2p审核"),
    // P2PYXSH("3", "p2p影像审核"),
    // YFK("4", "已放款"),
    // HKZ("5", "还款中"),
    // YQ("6", "逾期"),
    // TQJQ("7", "还款完成-提前结清"),
    // HKWC("8", "还款完成");

    public static String getLabelByStatus(String aproveStatus) {
        for (OrderStatus e : OrderStatus.values()) {
            if (StringUtils.equals(aproveStatus, e.getStatus())) {
                return e.getName();
            }
        }
        return null;
    }

    private String status;

    private String name;

    private OrderStatus(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
