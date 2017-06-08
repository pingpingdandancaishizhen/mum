package cn.sunfit.risk.buz.api.constants.order;

public enum HouseType {

    ZGSYF("0", "自购商业房", false),
    ZGXCQF("1", "自购小产权房", false),
    ZJF("2", "自建房", false),
    ZY("3", "租用", false),
    QSZF("4", "亲属住房", false),
    DWZF("5", "单位住房", false);

    private String typeId;

    private String typeName;

    private boolean selected;

    HouseType(String typeId, String typeName, boolean selected) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.selected = selected;
    }

    public String getTypeId() {
        return typeId;
    }

    public boolean isSelected() {
        return selected;
    }

    public String getTypeName() {
        return typeName;
    }

    public static HouseType getTypeNameByTypeId(String typeId) {
        for (HouseType houseType : HouseType.values()) {
            if (houseType.typeId.equals(typeId)) {
                return houseType;
            }
        }
        return null;
    }

}
