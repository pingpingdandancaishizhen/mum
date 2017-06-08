package cn.sunfit.risk.buz.api.constants.customer;

public enum SalaryType {

    online("0", "网银"),
    offline("1", "现金"),
    both("2", "网银+现金");

    private final String type;

    private final String name;

    SalaryType(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static SalaryType getNameByStatus(String type) {
        for (SalaryType salaryType : SalaryType.values()) {
            if (salaryType.type.equals(type)) {
                return salaryType;
            }
        }
        return null;
    }

}
