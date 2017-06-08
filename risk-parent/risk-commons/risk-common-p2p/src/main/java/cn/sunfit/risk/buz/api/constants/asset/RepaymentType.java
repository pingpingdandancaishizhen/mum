package cn.sunfit.risk.buz.api.constants.asset;

public enum RepaymentType {
    // 先息后本
    XXHB("1", "先息后本"),
    // 一次性还款
    YCXHK("2", "一次性还款"),
    // 等额等息
    DEDX("3", "等额等息"),
    // 等额本息
    DEBX("4", "等额本息"),
    // 等额本金
    DEBJ("5", "等额本金");

    public static RepaymentType getTypeNameByTypeId(String typeId) {
        for (RepaymentType assetType : RepaymentType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (RepaymentType assetType : RepaymentType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    RepaymentType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

}
