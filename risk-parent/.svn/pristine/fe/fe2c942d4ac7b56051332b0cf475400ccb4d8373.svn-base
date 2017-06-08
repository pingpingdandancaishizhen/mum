package cn.sunfit.risk.buz.api.constants.asset;

public enum OtherType {
    // 没有其他费用
    NO_OTHERFEE("0", "否"),
    // 有其他费用
    HAS_OTHERFEE("1", "是");

    public static OtherType getTypeNameByTypeId(String typeId) {
        for (OtherType assetType : OtherType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (OtherType assetType : OtherType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    OtherType(String typeId, String typeName) {
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
