package cn.sunfit.risk.buz.api.constants.asset;

public enum LoanType {

    DEDUCT_OTHERFEE("1", "借款人实收金额=借款金额-（第一期的利息+第一期的管理费）-其他费用"),
    DEDUCT_FIRSTISSUEANDGPSFEE("2", "借款人实收金额=借款金额-（第一期的利息+第一期的管理费）-第一期的本息-GPS费用");

    public static LoanType getTypeNameByTypeId(String typeId) {
        for (LoanType assetType : LoanType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (LoanType assetType : LoanType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    private final String typeId;

    private final String typeName;

    LoanType(String typeId, String typeName) {
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
