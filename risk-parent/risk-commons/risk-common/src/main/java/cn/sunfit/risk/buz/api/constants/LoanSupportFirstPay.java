package cn.sunfit.risk.buz.api.constants;

public enum LoanSupportFirstPay {

    QC("1", "期初支付", false),
    QM("2", "期末支付", false);

    public static LoanSupportFirstPay getTypeNameByTypeId(String typeId) {
        for (LoanSupportFirstPay loanApplyPeriodType : LoanSupportFirstPay.values()) {
            if (loanApplyPeriodType.typeId.equals(typeId)) {
                return loanApplyPeriodType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (LoanSupportFirstPay loanApplyPeriodType : LoanSupportFirstPay.values()) {
            if (loanApplyPeriodType.typeId.equals(typeId)) {
                return loanApplyPeriodType.getTypeName();
            }
        }
        return null;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    LoanSupportFirstPay(String typeId, String typeName, boolean selected) {
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
