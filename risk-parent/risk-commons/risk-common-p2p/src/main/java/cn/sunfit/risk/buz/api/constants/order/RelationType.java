package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.BaseEnum;

public enum RelationType implements BaseEnum {
    spouse("0", "配偶"),
    father("1", "父亲"),
    mother("2", "母亲"),
    son("3", "儿子"),
    daughter("4", "女儿"),
    schoolmate("5", "同学"),
    colleagues("6", "同事"),
    friend("7", "朋友");

    public static RelationType getNameByType(String type) {
        for (RelationType relationType : RelationType.values()) {
            if (relationType.type.equals(type)) {
                return relationType;
            }
        }
        return null;
    }

    public static List<String> getNames() {
        List<String> names = new ArrayList<String>();
        for (RelationType relationType : RelationType.values()) {
            names.add(relationType.name);
        }
        return names;
    }

    public static RelationType getTypeByName(String name) {
        for (RelationType relationType : RelationType.values()) {
            if (relationType.name.equals(name)) {
                return relationType;
            }
        }
        return null;
    }

    public static List<String> getTypes() {
        List<String> types = new ArrayList<String>();
        for (RelationType relationType : RelationType.values()) {
            types.add(relationType.type);
        }
        return types;
    }

    private String name;

    private String type;

    private RelationType(String type, String name) {
        this.name = name;
        this.type = type;
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
