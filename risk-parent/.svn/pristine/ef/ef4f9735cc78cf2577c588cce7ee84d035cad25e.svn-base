package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum EducationType implements BaseEnum {

    belowSenior("0", "高中以下"),
    senior("1", "高中"),
    juniorCollege("2", "中专"),
    seniorCollege("3", "大专"),
    university("4", "本科"),
    doctor("5", "硕士及以上");

    public static EducationType getNameByStatus(String type) {
        for (EducationType educationType : EducationType.values()) {
            if (educationType.type.equals(type)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (EducationType cducationType : EducationType.values()) {
            names.add(cducationType.name);
        }
        return names;
    }

    public static EducationType getTypeByName(String name) {
        for (EducationType educationType : EducationType.values()) {
            if (educationType.name.equals(name)) {
                return educationType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (EducationType cducationType : EducationType.values()) {
            types.add(cducationType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    EducationType(String type, String name) {
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
