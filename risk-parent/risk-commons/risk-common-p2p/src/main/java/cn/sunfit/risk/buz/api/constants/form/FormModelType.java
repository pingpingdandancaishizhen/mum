package cn.sunfit.risk.buz.api.constants.form;

import org.apache.commons.lang3.StringUtils;

public enum FormModelType {

    VIEW("view", "查看"),
    EDIT("edit", "编辑"),
    HANDLE("handle", "处理");

    public static FormModelType getTypeNameByTypeId(String typeId) {
        for (FormModelType assetType : FormModelType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (FormModelType assetType : FormModelType.values()) {
            if (assetType.typeId.equals(typeId)) {
                return assetType.getTypeName();
            }
        }
        return null;
    }

    public static boolean isEdit(String model) {
        return StringUtils.equals(EDIT.getTypeId(), model);
    }

    public static boolean isHandle(String model) {
        return StringUtils.equals(HANDLE.getTypeId(), model);
    }

    public static boolean isView(String model) {
        return StringUtils.equals(VIEW.getTypeId(), model);
    }

    private final String typeId;

    private final String typeName;

    FormModelType(String typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

}
