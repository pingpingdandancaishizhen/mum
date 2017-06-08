package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum LoanUsageType implements BaseEnum {

    life_cost("1", "日常生活消费", false),
    education("2", "教育支出", false),
    hospital("3", "医疗支出", false),
    advice("4", "提高生活质量", false),
    shopping("5", "购物", false),
    business("6", "生意往来", false),
    baoxian("7", "保险", false),
    other("8", "其他", false);

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (LoanUsageType loanUsageType : LoanUsageType.values()) {
            names.add(loanUsageType.typeName);
        }
        return names;
    }

    public static LoanUsageType getTypeNameByTypeId(String typeId) {
        for (LoanUsageType loanUsageType : LoanUsageType.values()) {
            if (loanUsageType.typeId.equals(typeId)) {
                return loanUsageType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (LoanUsageType loanUsageType : LoanUsageType.values()) {
            types.add(loanUsageType.typeId);
        }
        return types;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    LoanUsageType(String typeId, String typeName, boolean selected) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.selected = selected;
    }

    public String getEnumName() {
        // TODO Auto-generated method stub
        return typeName;
    }

    public String getEnumType() {
        // TODO Auto-generated method stub
        return typeId;
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
