package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum PersonalCredit implements BaseEnum {

    YES("1", "有"),
    NO("0", "无");

    public static PersonalCredit getNameByStatus(String type) {
        for (PersonalCredit companyType : PersonalCredit.values()) {
            if (companyType.type.equals(type)) {
                return companyType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (PersonalCredit companyType : PersonalCredit.values()) {
            names.add(companyType.name);
        }
        return names;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (PersonalCredit companyType : PersonalCredit.values()) {
            types.add(companyType.type);
        }
        return types;
    }

    private final String type;

    private final String name;

    PersonalCredit(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getEnumName() {
        return name;
    }

    public String getEnumType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

}
