package cn.sunfit.risk.buz.api.constants;

public enum LoanRepaymentType {

    DBDX("1", "等额等息", false),
    XXHB("2", "先息后本", false),
    YCXHQ("3", "一次性还清", false),
    DEBJ("4", "等额本金", false),
    DEBX("5", "等额本息", false);

    public static LoanRepaymentType getTypeNameByTypeId(String typeId) {
        for (LoanRepaymentType loanApplyPeriodType : LoanRepaymentType.values()) {
            if (loanApplyPeriodType.typeId.equals(typeId)) {
                return loanApplyPeriodType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (LoanRepaymentType loanApplyPeriodType : LoanRepaymentType.values()) {
            if (loanApplyPeriodType.typeId.equals(typeId)) {
                return loanApplyPeriodType.getTypeName();
            }
        }
        return null;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    LoanRepaymentType(String typeId, String typeName, boolean selected) {
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
