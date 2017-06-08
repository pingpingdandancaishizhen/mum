package cn.sunfit.risk.buz.api.constants;

public enum LoanTermType {

    D15("D15", "15天", true),
    M1("M1", "1个月", false),
    M2("M2", "2个月", false),
    M3("M3", "3个月", false),
    M4("M4", "4个月", false),
    M5("M5", "5个月", false),
    M6("M6", "6个月", false),
    M7("M7", "7个月", false),
    M8("M8", "8个月", false),
    M9("M9", "9个月", false),
    M10("M10", "10个月", false),
    M11("M11", "11个月", false),
    M12("M12", "12个月", false),
    M13("M13", "13个月", false),
    M14("M14", "14个月", false),
    M15("M15", "15个月", false),
    M16("M16", "16个月", false),
    M17("M17", "17个月", false),
    M18("M18", "18个月", false),
    M19("M19", "19个月", false),
    M20("M20", "20个月", false),
    M21("M21", "21个月", false),
    M22("M22", "22个月", false),
    M23("M23", "23个月", false),
    M24("M24", "24个月", false),
    M25("M25", "25个月", false),
    M26("M26", "26个月", false),
    M27("M27", "27个月", false),
    M28("M28", "28个月", false),
    M29("M29", "29个月", false),
    M30("M30", "30个月", false),
    M31("M31", "31个月", false),
    M32("M32", "32个月", false),
    M33("M33", "33个月", false),
    M34("M34", "34个月", false),
    M35("M35", "35个月", false),
    M36("M36", "36个月", false),
    M37("M37", "37个月", false),
    M38("M38", "38个月", false),
    M39("M39", "39个月", false),
    M40("M40", "40个月", false),
    M41("M41", "41个月", false),
    M42("M42", "42个月", false),
    M43("M43", "43个月", false),
    M44("M44", "44个月", false),
    M45("M45", "45个月", false),
    M46("M46", "46个月", false),
    M47("M47", "47个月", false),
    M48("M48", "48个月", false),
    M49("M49", "49个月", false),
    M50("M50", "50个月", false),
    M51("M51", "51个月", false),
    M52("M52", "52个月", false),
    M53("M53", "53个月", false),
    M54("M54", "54个月", false),
    M55("M55", "55个月", false),
    M56("M56", "56个月", false),
    M57("M57", "57个月", false),
    M58("M58", "58个月", false),
    M59("M59", "59个月", false),
    M60("M60", "60个月", false);

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (LoanTermType userStatusType : LoanTermType.values()) {
            if (userStatusType.status.equals(status)) {
                return userStatusType.getLabel();
            }
        }
        return "";
    }

    /**
     * 根据用户状态标签，返回用户状态
     */
    public static String getStatusByLabel(String label) {
        for (LoanTermType userStatusType : LoanTermType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    private String status;

    private String label;

    private boolean disabled;

    LoanTermType(String status, String label, boolean disabled) {
        this.status = status;
        this.label = label;
        this.disabled = disabled;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }

}
