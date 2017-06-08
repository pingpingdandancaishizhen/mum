package cn.sunfit.risk.buz.api.constants;

public enum LoanUsageType {

    life_cost("1", "日常生活消费", false),
    education("2", "教育支出", false),
    hospital("3", "医疗支出", false),
    advice("4", "提高生活质量", false),
    shopping("5", "购物", false),
    business("6", "生意往来", false),
    baoxian("7", "保险", false),
    other("8", "其他", false);

    private String typeId;

    private String typeName;

    private boolean selected;

    LoanUsageType(String typeId, String typeName, boolean selected) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.selected = selected;
    }

    public String getTypeId() {
        return typeId;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getTypeName() {
        return typeName;
    }

    public static LoanUsageType getTypeNameByTypeId(String typeId) {
        for (LoanUsageType loanUsageType : LoanUsageType.values()) {
            if (loanUsageType.typeId.equals(typeId)) {
                return loanUsageType;
            }
        }
        return null;
    }

}
