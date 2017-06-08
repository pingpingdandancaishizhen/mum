package cn.sunfit.risk.buz.api.constants.order;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public enum LoanInfo2AttrEnum {

    E1("customerType", "cust_type", "客户类型"), // CODE NEEDED
    E2("customerName", "cust_name", "客户姓名"),
    E3("gender", "cust_gender", "性别"), // CODE NEEDED
    E4("idCard", "cust_license_num", "身份证号"),
    E5("marriage", "cust_marriage", "婚姻状况"), // CODE NEEDED
    E6("hasChild", "cust_child_count", "子女数目"),
    E7("hightDegree", "cust_education", "最高学历"), // CODE NEEDED
    E8("graduateInstitutions", "cust_school", "毕业院校"),
    // E9("", "cust_school_addr", "学校地址"),
    E10("schoolProvince", "cust_school_addr_province", "学校地址-省"),
    E11("schoolCity", "cust_school_addr_city", "学校地址-市"),
    E12("schoolRegion", "cust_school_addr_counties", "学校地址-区/县"),
    E13("schoolAddress", "cust_school_addr_detail", "学校地址-详细地址"),
    E14("mobilePhone", "cust_mobile", "手机号1"),
    // E15("", "cust_mobile2", "手机号2"),
    // E16("", "cust_email", "邮箱地址"),
    // E17("", "cust_qq", "QQ"),
    // E18("", "cust_wechat", "微信"),
    // E19("", "cust_regist_addr", "户口所在地"),
    E20("houseHoldProvince", "cust_regist_addr_province", "户口所在地-省"),
    E21("houseHoldCity", "cust_regist_addr_city", "户口所在地-市"),
    E22("houseHoldRegion", "cust_regist_addr_counties", "户口所在地-区/县"),
    E23("houseHoldAddress", "cust_regist_addr_detail", "户口所在地-详细地址"),
    // E24("", "cust_live_addr", "现住址"),
    // E25("", "cust_live_addr_province", "现住址-省"),
    // E26("", "cust_live_addr_city", "现住址-市"),
    // E27("", "cust_live_addr_counties", "现住址-区/县"),
    // E28("", "cust_live_addr_detail", "现住址-详细地址"),
    // E29("", "custimg_idcard1", "身份证照正面"),
    // E30("", "custimg_idcard2", "身份证照反面"),
    E31("", "custjob_industry", "所属行业"),
    E32("jobType", "custjob_company_type", "单位性质"),
    E33("jobTitle", "custjob_job_lvl", "职位"),
    E34("companyName", "custjob_company_name", "单位名称"),
    // E35("", "custjob_dept_name", "所在部门/科室"),
    // E36("", "custjob_entry_time", "入职时间"),
    // E37("", "custjob_salary", "月均工资"),
    // E38("", "custjob_salary_date", "每月发薪日"),
    // E39("", "custjob_salary_type", "工资发放形式"),
    E40("companyTel", "custjob_company_phone", "单位电话"),
    // E41("", "custjob_company_addr", "单位地址"),
    E42("companyProvince", "custjob_company_addr_province", "单位地址-省"),
    E43("companyCity", "custjob_company_addr_city", "单位地址-市"),
    E44("companyRegion", "custjob_company_addr_counties", "单位地址-区/县"),
    E45("companyAddress", "custjob_company_addr_detail", "单位地址-详细地址"),
    // E46("", "custearn_security_fund", "社保/公积金流水"),
    // E47("", "custearn_bank_bill", "银行流水"),
    // E48("", "custearn_credit_report", "央行征信报告"),
    E49("relation1", "custfriend_relation1", "关系1"), // CODE NEEDED
    E50("urgenContact1", "custfriend_name1", "姓名1"),
    // E51("", "custfriend_know1", "是否知晓1"),
    E52("urgenPhone1", "custfriend_mobile1", "移动电话1"),
    // E53("", "custfriend_company_name1", "单位名称1"),
    E54("relation2", "custfriend_relation2", "关系2"), // CODE NEEDED
    E55("urgenContact2", "custfriend_name2", "姓名2"),
    // E56("", "custfriend_know2", "是否知晓2"),
    E57("urgenPhone2", "custfriend_mobile2", "移动电话2"),
    // E58("", "custfriend_company_name2", "单位名称2"),
    // E59("", "custfriend_relation3", "关系3"),
    // E60("", "custfriend_name3", "姓名3"),
    // E61("", "custfriend_know3", "是否知晓3"),
    // E62("", "custfriend_mobile3", "移动电话3"),
    // E63("", "custfriend_company_name3", "单位名称3"),
    E64("zMCreditScore", "credit_score", "芝麻信用分"),
    E65("productCode", "loan_product_key", "产品"), // CODE NEEDED
    E66("loanPurpose", "loan_usage", "借款用途"), // CODE NEEDED
    // E67("", "loan_usage_other", "借款用途-其他"),
    // E68("", "loan_type", "借款形式"),
    E69("loanMoney", "loan_amount", "借款金额"),
    E70("repayType", "loan_apply_repaymentTypes", "借款人还款方式"), // CODE NEEDED
    E71("loanPeriod", "loan_apply_monthlyTerm", "借款期限"),
    // E72("", "loan_monthlyRate", "利息/月"),
    E73("loanDayRate", "loan_daylyRate", "利息/日"),
    // E74("", "loan_monthlyGLFee", "管理费/月"),
    E75("manageDayRate", "loan_daylyGLFee", "管理费/日"),
    // E76("", "loan_yearlyRate", "年化率"),
    // E77("", "loan_znjFee", "滞纳金率"),
    // E78("", "loan_wyFee", "违约金率"),
    E79("otherFee", "loan_otherFee", "其他费用"),
    E80("receiversName", "loanbank_account_name", "收款账户户名"),
    E81("receiversBankAccount", "loanbank_account_no", "收款银行账号"),
    E82("receiversBankName", "loanbank_bank", "收款银行开户行"),
    // E83("", "loanbank_addr", "收款银行开户地"),
    E84("receiversBankProvince", "loanbank_addr_province", "收款银行开户地-省"),
    E85("receiversBankCity", "loanrebank_addr_city", "收款银行开户地-市"),
    E86("receiversBankBranch", "loanbank_branch", "收款银行支行"),
    E87("repaymentName", "loanrebank_account_name", "还款账户户名"),
    E88("repaymentBankAccount", "loanrebank_account_no", "还款款银行账号"),
    E89("repaymentBankName", "loanrebank_bank", "还款银行开户行"),
    // E90("", "loanrebank_addr", "还款银行开户地"),
    E91("repaymentBankProvince", "loanrebank_addr_province", "还款银行开户地-省"),
    E92("repaymentBankCity", "loanrebank_addr_city", "还款银行开户地-市"),
    E93("repaymentBankBranch", "loanrebank_branch", "还款银行支行");

    /*
     * public static void main(String[] args) throws IOException { List<String> s = FileUtils.readLines(new
     * File("D:/A.txt")); int i = 0; for (String a : s) { i++; String[] cs = a.split("\\t"); System.out.println("E" + i
     * + String.format("(\"\",\"%s\",\"%s\")", cs[2], cs[0]) + ","); } }
     */
    private static Map<String, String> loaninfo2attr;
    private static Map<String, String> attr2loaninfo;
    static {
        // 丢成MAP 可以用用
        loaninfo2attr = new HashMap<String, String>();
        attr2loaninfo = new HashMap<String, String>();
        for (LoanInfo2AttrEnum e : LoanInfo2AttrEnum.values()) {
            loaninfo2attr.put(e.loainfoProperty, e.attrFieldKey);
            attr2loaninfo.put(e.attrFieldKey, e.loainfoProperty);
        }
        loaninfo2attr = Collections.unmodifiableMap(loaninfo2attr);
        attr2loaninfo = Collections.unmodifiableMap(attr2loaninfo);
    }

    public static Map<String, String> getAttrFieldMap() {
        return attr2loaninfo;
    }

    /*
     * 通过attr的key找到loaninf对应的property name
     */
    public static LoanInfo2AttrEnum getByAttrFieldKey(String AttrFieldKey) {
        for (LoanInfo2AttrEnum e : LoanInfo2AttrEnum.values()) {
            if (StringUtils.equals(e.attrFieldKey, AttrFieldKey)) {
                return e;
            }
        }
        return null;
    }

    /**
     * 
     * 通过loaninfo里的property找到attr对应的key
     */
    public static LoanInfo2AttrEnum getByLoanInfoProperty(String loanInfoProperty) {
        for (LoanInfo2AttrEnum e : LoanInfo2AttrEnum.values()) {
            if (StringUtils.equals(e.loainfoProperty, loanInfoProperty)) {
                return e;
            }
        }
        return null;
    }

    public static Map<String, String> getLoanInfoPropertyMap() {
        return loaninfo2attr;
    }

    // loan info 实体属性
    private String loainfoProperty;

    // attr 额外的属性
    private String attrFieldKey;

    // 中文名
    private String name;

    private LoanInfo2AttrEnum(String loainfoProperty, String attrFieldKey, String name) {
        this.loainfoProperty = loainfoProperty;
        this.attrFieldKey = attrFieldKey;
        this.name = name;
    }

    public String getAttrFieldKey() {
        return attrFieldKey;
    }

    public String getLoainfoProperty() {
        return loainfoProperty;
    }

    public String getName() {
        return name;
    }

    public void setAttrFieldKey(String attrFieldKey) {
        this.attrFieldKey = attrFieldKey;
    }

    public void setLoainfoProperty(String loainfoProperty) {
        this.loainfoProperty = loainfoProperty;
    }

    public void setName(String name) {
        this.name = name;
    }
}
