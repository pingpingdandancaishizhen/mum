package cn.sunfit.risk.buz.api.constants.order;

import java.util.ArrayList;
import java.util.List;

public enum LoanEachTimeType {
    
    D1("1","1天", false),
    D2("2","2天", false),
    D3("3","3天", false),
    D4("4","4天", false),
    D5("5","5天", false),
    D6("6","6天", false),
    D7("7","7天", false),
    D8("8","8天", false),
    D9("9","9天", false),
    D10("10","10天", false),
    D11("11","11天", false),
    D12("12","12天", false),
    D13("13","13天", false),
    D14("14","14天", false),
    D15("15","15天", false),
    D16("16","16天", false),
    D17("17","17天", false),
    D18("18","18天", false),
    D19("19","19天", false),
    D20("20","20天", false),
    D21("21","21天", false),
    D22("22","22天", false),
    D23("23","23天", false),
    D24("24","24天", false),
    D25("25","25天", false),
    D26("26","26天", false),
    D27("27","27天", false),
    D28("28","28天", false),
    D29("29","29天", false),
    D30("30","30天", false),
    D31("31","31天", false),
    D32("32","32天", false),
    D33("33","33天", false),
    D34("34","34天", false),
    D35("35","35天", false),
    D36("36","36天", false),
    D37("37","37天", false),
    D38("38","38天", false),
    D39("39","39天", false),
    D40("40","40天", false),
    D41("41","41天", false),
    D42("42","42天", false),
    D43("43","43天", false),
    D44("44","44天", false),
    D45("45","45天", false),
    D46("46","46天", false),
    D47("47","47天", false),
    D48("48","48天", false),
    D49("49","49天", false),
    D50("50","50天", false),
    D51("51","51天", false),
    D52("52","52天", false),
    D53("53","53天", false),
    D54("54","54天", false),
    D55("55","55天", false),
    D56("56","56天", false),
    D57("57","57天", false),
    D58("58","58天", false),
    D59("59","59天", false),
    D60("60","60天", false),
    M1("1", "1个月", false),
    M2("2", "2个月", false),
    M3("3", "3个月", false),
    M4("4", "4个月", false),
    M5("5", "5个月", false),
    M6("6", "6个月", false),
    M12("12", "12个月", false),
    M18("18", "18个月", false),
    M24("24", "24个月", false);

    /**
     * 根据用户状态，返回用户状态标签
     */
    public static String getLabelByStatus(String status) {
        for (LoanEachTimeType userStatusType : LoanEachTimeType.values()) {
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
        for (LoanEachTimeType userStatusType : LoanEachTimeType.values()) {
            if (userStatusType.label.equals(label)) {
                return userStatusType.getStatus();
            }
        }
        return "";
    }

    public static LoanEachTimeType getTypeByStatus(String status) {
        for (LoanEachTimeType loanEachTimeType : LoanEachTimeType.values()) {
            if (loanEachTimeType.status.equals(status)) {
                return loanEachTimeType;
            }
        }
        return null;
    }

    private String status;

    private String label;

    private boolean disabled;

    LoanEachTimeType(String status, String label, boolean disabled) {
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
    
    public static List<String> getTypes(){
        List<String> types = new ArrayList<String>();
        for (LoanEachTimeType loanEachTimeType : LoanEachTimeType.values()) {
            types.add(loanEachTimeType.status);
        }
        return types;
    }
    
    public static List<String> getNames(){
        List<String> names = new ArrayList<String>();
        for (LoanEachTimeType loanEachTimeType : LoanEachTimeType.values()) {
            names.add(loanEachTimeType.label);
        }
        return names;
    }
    
    public static List<LoanEachTimeType> getEnumByNameSuffix(String suffix){
        List<LoanEachTimeType> letts = new ArrayList<LoanEachTimeType>();
        for (LoanEachTimeType loanEachTimeType : LoanEachTimeType.values()) {
            if(loanEachTimeType.getLabel().endsWith(suffix))
                letts.add(loanEachTimeType);
        }
        return letts;
    }

}
