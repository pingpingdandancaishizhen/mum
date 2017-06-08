package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum CustomerType implements BaseEnum {

    PERSON("0", "个人", true),
    ENTERPRISE("1", "企业", false);

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (CustomerType customerType : CustomerType.values()) {
            names.add(customerType.typeName);
        }
        return names;
    }

    public static CustomerType getTypeByName(String name) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.typeName.equals(name)) {
                return customerType;
            }
        }
        return null;
    }

    public static CustomerType getTypeNameByTypeId(String typeId) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.typeId.equals(typeId)) {
                return customerType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.typeId.equals(typeId)) {
                return customerType.getTypeName();
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (CustomerType customerType : CustomerType.values()) {
            types.add(customerType.typeId);
        }
        return types;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    CustomerType(String typeId, String typeName, boolean selected) {
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
