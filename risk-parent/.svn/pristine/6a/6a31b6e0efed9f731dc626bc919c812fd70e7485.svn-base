package cn.sunfit.risk.buz.api.constants.asset;

public enum GpsType {
    // 没有gps费用
    NO_GPSFEE("0", "否"),
    // 有gps费用
    HAS_GPSFEE("1", "是");

    public static GpsType getTypeNameByTypeId(String typeId) {
        for (GpsType assetType : GpsType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (GpsType assetType : GpsType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    GpsType(String typeId, String typeName) {
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
