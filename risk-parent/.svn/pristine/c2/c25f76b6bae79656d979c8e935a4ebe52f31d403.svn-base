package cn.sunfit.risk.buz.api.constants.customer;

public enum HouseType {

    SYAJF("0", "商业按揭房", false),
    WAJFGF("1", "无按揭房购房", false),
    GJJAJGF("2", "公积金按揭购房", false),
    ZJF("3", "自建房", false),
    ZY("4", "租用", false),
    QSZF("5", "亲属住房", false),
    DWZF("6", "单位住房", false);

    public static HouseType getTypeNameByTypeId(String typeId) {
        for (HouseType houseType : HouseType.values()) {
            if (houseType.typeId.equals(typeId)) {
                return houseType;
            }
        }
        return null;
    }

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

    public String getTypeName() {
        return typeName;
    }

    public boolean isSelected() {
        return selected;
    }

}
