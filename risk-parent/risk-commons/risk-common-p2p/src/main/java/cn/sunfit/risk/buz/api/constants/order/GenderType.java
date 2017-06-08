package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum GenderType implements BaseEnum {

    MALE("1", "男"),
    FEMALE("0", "女");

    public static GenderType getNameByStatus(String type) {
        for (GenderType genderType : GenderType.values()) {
            if (genderType.type.equals(type)) {
                return genderType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (GenderType genderType : GenderType.values()) {
            names.add(genderType.name);
        }
        return names;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (GenderType genderType : GenderType.values()) {
            types.add(genderType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    GenderType(String type, String name) {
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
