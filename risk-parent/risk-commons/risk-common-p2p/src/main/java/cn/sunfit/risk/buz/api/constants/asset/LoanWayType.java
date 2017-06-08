package cn.sunfit.risk.buz.api.constants.asset;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum LoanWayType implements BaseEnum {
    personal_credit("1", "个人信用", false),
    personal_collateral("2", "个人抵押", false),
    individual_stage("3", "个人分期", false),
    individual_lease("4", "个人租赁", false),
    business_standing("5", "企业信用", false),
    enterprise_mortgage("6", "企业抵押", false),
    enterprise_stage("7", "企业分期", false),
    corporate_lease("8", "企业租赁", false);

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (LoanWayType loanUsageType : LoanWayType.values()) {
            names.add(loanUsageType.typeName);
        }
        return names;
    }

    public static LoanWayType getTypeNameByTypeId(String typeId) {
        for (LoanWayType loanUsageType : LoanWayType.values()) {
            if (loanUsageType.typeId.equals(typeId)) {
                return loanUsageType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (LoanWayType loanUsageType : LoanWayType.values()) {
            types.add(loanUsageType.typeId);
        }
        return types;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    LoanWayType(String typeId, String typeName, boolean selected) {
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
