package cn.sunfit.risk.buz.api.constants.asset;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum HousePropertyType implements BaseEnum {
    commodityHouse("1", "商品房"),
    selfbuiltHouse("2", "自建房"),
    unitRoom("3", "单位房");

    public static HousePropertyType getNameByStatus(String type) {
        for (HousePropertyType educationType : HousePropertyType.values()) {
            if (educationType.type.equals(type)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (HousePropertyType cducationType : HousePropertyType.values()) {
            names.add(cducationType.name);
        }
        return names;
    }

    public static HousePropertyType getTypeByName(String name) {
        for (HousePropertyType educationType : HousePropertyType.values()) {
            if (educationType.name.equals(name)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (HousePropertyType cducationType : HousePropertyType.values()) {
            types.add(cducationType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    HousePropertyType(String type, String name) {
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
