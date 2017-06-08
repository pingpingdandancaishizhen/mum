package cn.sunfit.risk.buz.api.constants.asset;

public enum FirstIssueType {

    DEDUCT_BENXI("1", "扣除第一期的本息"),

    DEDUCT_BENJIN("2", "扣除第一期的本金"),

    DEDUCT_LIXI("3", "扣除第一期的息"),

    NO_DEDUCT("4", "不扣第一期的本或息");

    public static FirstIssueType getTypeNameByTypeId(String typeId) {
        for (FirstIssueType assetType : FirstIssueType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (FirstIssueType assetType : FirstIssueType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    FirstIssueType(String typeId, String typeName) {
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
