package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum LoanRepaymentType implements BaseEnum {

    DBDX("1", "等额等息", false),
    XXHB("2", "先息后本", false),
    YCXHQ("3", "一次性还款", false),
    DEBJ("4", "等额本金", false),
    DEBX("5", "等额本息", false);

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (LoanRepaymentType loanRepaymentType : LoanRepaymentType.values()) {
            names.add(loanRepaymentType.typeName);
        }
        return names;
    }

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

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (LoanRepaymentType loanRepaymentType : LoanRepaymentType.values()) {
            types.add(loanRepaymentType.typeId);
        }
        return types;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    LoanRepaymentType(String typeId, String typeName, boolean selected) {
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
