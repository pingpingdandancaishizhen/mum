package cn.sunfit.risk.buz.api.constants.asset;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum OwnershipOfProperty implements BaseEnum {

    myself("1", "本人"),
    common("2", "共有"),
    couples("3", "配偶"),
    other("3", "其他");

    public static OwnershipOfProperty getNameByStatus(String type) {
        for (OwnershipOfProperty educationType : OwnershipOfProperty.values()) {
            if (educationType.type.equals(type)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (OwnershipOfProperty cducationType : OwnershipOfProperty.values()) {
            names.add(cducationType.name);
        }
        return names;
    }

    public static OwnershipOfProperty getTypeByName(String name) {
        for (OwnershipOfProperty educationType : OwnershipOfProperty.values()) {
            if (educationType.name.equals(name)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (OwnershipOfProperty cducationType : OwnershipOfProperty.values()) {
            types.add(cducationType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    OwnershipOfProperty(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getEnumName() {
        // TODO Auto-generated method stub
        return name;
    }

    public String getEnumType() {
        // TODO Auto-generated method stub
        return type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
