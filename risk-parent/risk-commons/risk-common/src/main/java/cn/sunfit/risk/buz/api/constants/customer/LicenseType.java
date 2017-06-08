package cn.sunfit.risk.buz.api.constants.customer;

public enum LicenseType {

    id("0", "身份证"),
    passport("1", "护照");

    private final String type;

    private final String name;

    LicenseType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static LicenseType getNameByStatus(String type) {
        for (LicenseType licenseType : LicenseType.values()) {
            if (licenseType.type.equals(type)) {
                return licenseType;
            }
        }
        return null;
    }

}
