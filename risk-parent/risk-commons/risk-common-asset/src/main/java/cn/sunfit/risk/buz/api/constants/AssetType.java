package cn.sunfit.risk.buz.api.constants;

public enum AssetType {

	INTERNAL_ENTERPRISE("0", "内部企业", false),
	EXTERNAL_ENTERPRISE("1", "外部企业", false);

    public static AssetType getTypeNameByTypeId(String typeId) {
        for (AssetType assetType : AssetType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (AssetType assetType : AssetType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    private final boolean selected;

    AssetType(String typeId, String typeName, boolean selected) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.selected = selected;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public boolean isSelected() {
        return selected;
    }

}
