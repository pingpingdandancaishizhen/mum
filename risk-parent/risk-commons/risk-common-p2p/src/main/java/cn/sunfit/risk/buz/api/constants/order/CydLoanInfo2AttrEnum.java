package cn.sunfit.risk.buz.api.constants.order;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public enum CydLoanInfo2AttrEnum {

    E1("productCode", "loan_product_code", "产品编号"),
    E2("productName", "loan_product_name", "产品名称"),
    E3("productSubType", "loan_product_sub_type_name", "产品子类型"),
    E137("productSubTypeId", "loan_product_sub_type_id", "产品子类型ID"),
    E4("loanWayType", "loan_type", "借款形式"),
    E5("loanPurpose", "loan_usage", "借款用途"),
    E6("repayType", "loan_fee_repaymentTypes", "借款人还款方式"),
    E7("loanMonthlyTerm", "loan_fee_monthlyTerm", "借款期限-月标"),
    E135("loanDaylyTerm", "loan_fee_daylyTerm", "借款期限-天标"),
    E136("isDaylyTrem", "loan_fee_tb", "是否天标"),
    E8("loanMoney", "loan_fee_amount", "借款金额"),
    E9("zhMonthlyRate", "loan_fee_monthlyZHFee", "综合月利率"),
    E10("pledgee", "loan_mortgage_user", "抵押权人"),
    E11("wyRate", "loan_fee_wyj", "违约金率"),
    E12("znRate", "loan_fee_znj", "滞纳金率"),
    E13("bzRate", "loan_fee_bzj", "保证金率"),
    E14("consultingRate", "loan_fee_consulting", "咨询费率"),
    E15("parkFee", "loan_fee_park", "停车费"),
    E16("gpsInstallationFee", "loan_fee_gpsinstall", "GPS安装费"),
    E17("gpsServiceFee", "loan_fee_gpsservice", "GPS服务费"),
    E18("otherFee", "loan_fee_other", "其他费用"),
    E19("customerType", "cust_type", "客户类型"),
    E20("customerName", "cust_name", "客户姓名"),
    E21("gender", "cust_license_num_gender", "性别"),
    E22("age", "cust_license_num_age", "年龄"),
    E23("idCard", "cust_license_num", "身份证号"),
    E24("idCardExpiryTime", "cust_license_num_invalid", "身份证有效期"),
    E25("houseHoldAddress", "cust_regist_addr_city", "户口所在地"),
    E26("houseHoldProvince", "cust_regist_addr_province", "户口所在地-省"),
    E27("houseHoldCity", "cust_regist_addr_city", "户口所在地-市"),
    E28("houseHoldRegion", "cust_regist_addr_counties", "户口所在地-区/县"),
    E29("houseHoldDetail", "cust_regist_addr_detail", "户口所在地-详细地址"),
    E30("marriage", "cust_marriage", "婚姻状况"),
    E31("hasChild", "cust_child_count", "子女数目"),
    E32("hightDegree", "cust_education", "最高学历"),
    E33("mobilePhoneOne", "cust_mobile", "手机号1"),
    E34("mobilePhoneTwo", "cust_mobile2", "手机号2"),
    E35("homePhone", "cust_phone", "住宅电话"),
    E36("qq", "cust_qq", "QQ"),
    E37("email", "cust_email", "邮箱地址"),
    E38("wechat", "cust_wechat", "微信"),
    E39("arrivedCityTime", "cust_come_time", "来本市时间"),
    E40("curHouseHoldAddress", "cust_live_addr", "现住址"),
    E41("curHouseHoldProvince", "cust_live_addr_province", "现住址-省"),
    E42("curHouseHoldCity", "cust_live_addr_city", "现住址-市"),
    E43("curHouseHoldRegion", "cust_live_addr_counties", "现住址-区/县"),
    E44("curHouseHoldDetail", "cust_live_addr_detail", "现住址-详细地址"),
    E45("checkInTime", "cust_house_time", "现住址入住时间"),
    E46("houseProperty", "cust_house_type", "现住址类别"),
    E47("jobIdentity", "custjob_identity", "职业身份"),
    E48("personalCredit", "loan_credit_has", "个人征信"),
    E49("housePropertyAddress", "loanasseth_address", "房产地址"),
    E50("housePropertyProvince", "loanasseth_address_province", "房产地址-省"),
    E51("housePropertyCity", "loanasseth_address_city", "房产地址-市"),
    E52("housePropertyRegion", "loanasseth_address_counties", "房产地址-区/县"),
    E53("housePropertyDetail", "loanasseth_address_detail", "房产地址-详细地址"),
    E54("buyingOption", "loanasseth_purchase_method", "购买方式"),
    E55("buyOrBuildDate", "loanasseth_purchase_date", "购买/建成日期"),
    E56("ownershipOfProperty", "loanasseth_ownership", "房产所有权性质"),
    E57("carNo", "loancar_license_plate", "车牌号码"),
    E58("recordDate", "loancar_registration_date", "初次登记日期"),
    E59("carBrand", "loancar_car_bms_brand", "车辆品牌"),
    E60("carSeries", "loancar_car_bms_series", "车系"),
    E61("carRegistrationModel", "loancar_registration_model", "车辆型号"),
    E62("carPrice", "loancar_purchase_price", "购买价格"),
    E63("carType", "loancar_car_type", "车辆类型"),
    E64("carColor", "loancar_car_color", "车辆颜色"),
    E65("carFrameNo", "loancar_frame_number", "车架号"),
    E66("carEngineNo", "loancar_engine_number", "发动机号"),
    E67("carFuelType", "loancar_car_fuel", "燃料种类"),
    E68("carSeats", "loancar_approved_passenger", "核定载客"),
    E69("carFactoryTime", "loancar_factory_date", "车辆出厂日期"),
    E70("carDriverPosition", "loancar_driving_position", "驾驶位置"),
    E71("carSum", "loancar_num", "车辆数量"),
    E72("carBlone", "loancar_ownership", "车辆归属"),
    E73("companyName", "custjob_company_name", "单位名称"),
    E74("companyAddress", "custjob_company_addr", "单位地址"),
    E75("companyProvince", "custjob_company_addr_province", "单位地址-省"),
    E76("companyCity", "custjob_company_addr_city", "单位地址-市"),
    E77("companyRegion", "custjob_company_addr_counties", "单位地址-区/县"),
    E78("companyDetail", "custjob_company_addr_detail", "单位地址-详细地址"),
    E79("companyNature", "custjob_company_type", " 单位性质"),
    E80("companyTel", "custjob_company_phone", "单位电话"),
    E81("companyFax", "custjob_company_fax", "传真号码"),
    E82("companyWeb", "custjob_company_url", "单位网址"),
    E83("jobTitle", "custjob_job_lvl", "部门职位"),
    E84("entryTime", "custjob_entry_time", "入职时间"),
    E85("salaryBase", "custjob_salary", "每月基本薪金"),
    E86("salaryOther", "custjob_salary_other", "其他收入"),
    E87("salaryTotal", "custjob_income_month", "每月总收入"),
    E88("companyType", "custjob_syyz_type", "私营企业类型"),
    E89("foundTime", "custjob_syyz_date", "成立时间"),
    E90("urgenOneName", "custfriend_name_0", "紧急联系人姓名1"),
    E91("urgenOneRelation", "custfriend_relation_0", "关系1"),
    E92("urgenOnePhone", "custfriend_phone_0", "手机号码1"),
    E93("urgenOneCompanyName", "custfriend_company_name_0", "单位名称1"),
    E94("urgenOneKnown", "custfriend_know_0", "是否知晓借款1"),
    E95("urgenTwoName", "custfriend_name_1", "紧急联系人姓名2"),
    E96("urgenTwoRelation", "custfriend_relation_1", "关系2"),
    E97("urgenTwoPhone", "custfriend_phone_1", "手机号码2"),
    E98("urgenTwoCompanyName", "custfriend_company_name_1", "单位名称2"),
    E99("urgenTwoKnown", "custfriend_know_1", "是否知晓借款2"),
    E100("sharerOneName", "borrower2_name", "共同借款人1"),
    E101("sharerOneIdCard", "borrower2_license_num", "身份证1"),
    E102("sharerOnePhone", "borrower2_mobile", "移动电话1"),
    E103("sharerOneLivingAddress", "borrower2_home_addr", "现住宅地址1"),
    E104("sharerOneLivingProvince", "borrower2_home_addr_province", "现住宅地址-省1"),
    E105("sharerOneLivingCity", "borrower2_home_addr_city", "现住宅地址-市1"),
    E106("sharerOneLivingRegion", "borrower2_home_addr_counties", "现住宅地址-县/区1"),
    E107("sharerOneLivingDetail", "borrower2_home_addr_detail", "现住宅地址-街道1"),
    E108("sharerTwoName", "borrower3_name", "共同借款人2"),
    E109("sharerTwoIdCard", "borrower3_license_num", "身份证2"),
    E110("sharerTwoPhone", "borrower3_mobile", "移动电话2"),
    E111("sharerTwoLivingAddress", "borrower3_home_addr", "现住宅地址2"),
    E112("sharerTwoLivingProvince", "borrower3_home_addr_province", "现住宅地址-省2"),
    E113("sharerTwoLivingCity", "borrower3_home_addr_city", "现住宅地址-市1"),
    E114("sharerTwoLivingRegion", "borrower3_home_addr_counties", "现住宅地址-县/区2"),
    E115("sharerTwoLivingDetail", "borrower3_home_addr_detail", "现住宅地址-街道2"),
    E116("receiversName", "loanbank_account_name", "收款账户户名"),
    E117("receiversBankName", "loanbank_bank", "收款银行开户行"),
    E118("receiversBankAddress", "loanbank_addr", "收款银行开户地"),
    E119("receiversBankProvince", "loanbank_addr_province", "收款银行开户地-省"),
    E120("receiversBankCity", "loanbank_addr_city", "收款银行开户地-市"),
    E121("receiversBankBranch", "loanbank_branch", "收款银行支行"),
    E122("receiversBankAccount", "loanbank_account_no", "收款银行账号"),
    E123("receiversConfirmBankAccount", "loanbank_account_no_re", "收款确认银行账号"),
    E124("repaymentName", "loanrebank_account_name", "还款账户户名"),
    E125("repaymentBankName", "loanrebank_bank", "还款银行开户行"),
    E126("repaymentBankAddress", "loanrebank_addr", "还款银行开户地"),
    E127("repaymentBankProvince", "loanrebank_addr_province", "还款银行开户地-省"),
    E128("repaymentBankCity", "loanrebank_addr_city", "还款银行开户地-市"),
    E129("repaymentBankBranch", "loanrebank_branch", "还款银行支行"),
    E130("repaymentBankAccount", "loanrebank_account_no", "还款款银行账号"),
    E131("repaymentConfirmBankAccount", "loanrebank_account_no_re", "还款款银行账号"),
    E132("productType", "loan_product_type_name", "产品类型"),
    E138("productTypeId", "loan_product_type_id", "产品类型ID"),
    E133("hasHouseProperty", "loanasseth_has", "是否有房产"),
    E134("isSyyz", "custjob_is_syyz", "是否私营业主");

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
        for (CydLoanInfo2AttrEnum e : CydLoanInfo2AttrEnum.values()) {
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
    public static CydLoanInfo2AttrEnum getByAttrFieldKey(String AttrFieldKey) {
        for (CydLoanInfo2AttrEnum e : CydLoanInfo2AttrEnum.values()) {
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
    public static CydLoanInfo2AttrEnum getByLoanInfoProperty(String loanInfoProperty) {
        for (CydLoanInfo2AttrEnum e : CydLoanInfo2AttrEnum.values()) {
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

    private CydLoanInfo2AttrEnum(String loainfoProperty, String attrFieldKey, String name) {
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
