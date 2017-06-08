package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum MaritalStatus implements BaseEnum {

    single("0", "未婚"),
    merried("1", "已婚"),
    divorced("2", "离异"),
    remarry("3", "再婚"),
    widowed("4", "丧偶");

    public static MaritalStatus getNameByType(String type) {
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if (maritalStatus.type.equals(type)) {
                return maritalStatus;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            names.add(maritalStatus.name);
        }
        return names;
    }

    public static MaritalStatus getTypeByName(String name) {
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            if (maritalStatus.name.equals(name)) {
                return maritalStatus;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (MaritalStatus maritalStatus : MaritalStatus.values()) {
            types.add(maritalStatus.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    MaritalStatus(String type, String name) {
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
