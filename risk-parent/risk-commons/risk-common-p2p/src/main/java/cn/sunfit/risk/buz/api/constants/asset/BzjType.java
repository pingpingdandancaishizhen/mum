package cn.sunfit.risk.buz.api.constants.asset;

public enum BzjType {
    // 没有保证金
    NO_BZJFEE("0", "否"),
    // 有保证金
    HAS_BZJFEE("1", "是");

    public static BzjType getTypeNameByTypeId(String typeId) {
        for (BzjType assetType : BzjType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (BzjType assetType : BzjType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    BzjType(String typeId, String typeName) {
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
