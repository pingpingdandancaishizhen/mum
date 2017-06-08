package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum CompanyType implements BaseEnum {

    JGSY("0", "机关事业"),
    GYGF("1", "国有股份"),
    WM("2", "外资"),
    MY("3", "民营"),
    HZ("4", "合资"),
    GT("5", "个体"),
    SHTT("6", "社会团体");

    public static CompanyType getNameByStatus(String type) {
        for (CompanyType companyType : CompanyType.values()) {
            if (companyType.type.equals(type)) {
                return companyType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (CompanyType companyType : CompanyType.values()) {
            names.add(companyType.name);
        }
        return names;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (CompanyType companyType : CompanyType.values()) {
            types.add(companyType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    CompanyType(String type, String name) {
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
