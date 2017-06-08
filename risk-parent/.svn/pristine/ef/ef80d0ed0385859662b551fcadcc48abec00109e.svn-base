package cn.sunfit.risk.buz.api.constants.asset;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum BuyingOption implements BaseEnum {

    OneTimePurchase("1", "一次性购买"),
    mortgage("2", "按揭"),
    selfBuild("3", "自建");

    public static BuyingOption getNameByStatus(String type) {
        for (BuyingOption educationType : BuyingOption.values()) {
            if (educationType.type.equals(type)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (BuyingOption cducationType : BuyingOption.values()) {
            names.add(cducationType.name);
        }
        return names;
    }

    public static BuyingOption getTypeByName(String name) {
        for (BuyingOption educationType : BuyingOption.values()) {
            if (educationType.name.equals(name)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (BuyingOption cducationType : BuyingOption.values()) {
            types.add(cducationType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    BuyingOption(String type, String name) {
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
