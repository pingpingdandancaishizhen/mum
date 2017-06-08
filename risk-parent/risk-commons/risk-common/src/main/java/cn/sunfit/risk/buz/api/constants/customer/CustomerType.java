package cn.sunfit.risk.buz.api.constants.customer;

public enum CustomerType {

    PERSON("0", "个人", true),
    ENTERPRISE("1", "企业", false);

    public static CustomerType getTypeNameByTypeId(String typeId) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.typeId.equals(typeId)) {
                return customerType;
            }
        }
        return null;
    }

    public static String getTypeNameStrByTypeId(String typeId) {
        for (CustomerType customerType : CustomerType.values()) {
            if (customerType.typeId.equals(typeId)) {
                return customerType.getTypeName();
            }
        }
        return null;
    }

    private String typeId;

    private String typeName;

    private boolean selected;

    CustomerType(String typeId, String typeName, boolean selected) {
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
