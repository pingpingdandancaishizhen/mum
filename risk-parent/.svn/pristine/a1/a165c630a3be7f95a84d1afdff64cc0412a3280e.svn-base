package cn.sunfit.risk.buz.api.constants.customer;

public enum CustCustomerType {

    PO("0", "配偶"),
    FQ("1", "父亲"),
    MQ("2", "母亲"),
    EZ("3", "儿子"),
    NE("4", "女儿"),
    JM("5", "姐妹"),
    XD("6", "兄弟"),
    BQ("7", "表亲"),
    TX("8", "同学"),
    TS("9", "同事"),
    PY("10", "朋友"),
    QT("11", "其他");

    public static CustCustomerType getNameByStatus(String type) {
        for (CustCustomerType custCustomerType : CustCustomerType.values()) {
            if (custCustomerType.type.equals(type)) {
                return custCustomerType;
            }
        }
        return null;
    }

    private final String type;

    private final String name;

    CustCustomerType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
