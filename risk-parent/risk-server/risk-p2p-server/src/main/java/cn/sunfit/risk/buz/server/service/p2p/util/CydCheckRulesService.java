package cn.sunfit.risk.buz.server.service.p2p.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.constants.order.LoanRepaymentType;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.server.dao.p2p.productSubType.ProductSubTypeDAO;
import cn.sunfit.risk.buz.server.dao.system.DataDicDAO;

@Service
public class CydCheckRulesService {

    public static void main(String[] args) {
        System.out.println("88".matches("^\\d{1,2}|100|100.0|100.00|\\d{1,2}.\\d{1,2}$"));
    }

    @Autowired
    private P2PProductService p2PProductService;

    @Autowired
    private P2PBankService p2PBankService;

    @Autowired
    private DataDicDAO dataDicDAO;

    @Autowired
    private ProductSubTypeDAO productSubTypeDAO;

    /**
     * 车易贷导入校验模板
     */
    private List<Map<String, Object>> cydCheckTemps = null;

    public List<Map<String, Object>> getCydCheckTemp(String domain, String productCode) {
        cydCheckTemps = new ArrayList<Map<String, Object>>();
        Map<String, Object> cydCheckTemp = null;

        // 订单号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "thirdLoanId");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须为数字");
        cydCheckTemp.put("checkWay", "^\\d*$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 产品名称
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "productName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "与选择的产品不匹配");
        cydCheckTemp.put("checkWay", "");
        // cydCheckTemp.put("valItem", getValItem(p2PProductService.findRiskProductList(domain), "productName"));
        cydCheckTemp.put("checkFun", "productNameValidate");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 40);
        cydCheckTemps.add(cydCheckTemp);

        // 产品代码
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "productCode");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "与选择的产品不匹配");
        cydCheckTemp.put("checkWay", "");
        // cydCheckTemp.put("valItem", getValItem(p2PProductService.findRiskProductList(domain), "productCode"));
        cydCheckTemp.put("checkFun", "productCodeValidate");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 子产品类型
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "productSubType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(productSubTypeDAO.getProductSubTypes(domain, productCode), "name"));
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 借款形式
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "loanWayType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "借款形式填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "149"), "dicValue"));
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 借款用途
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "loanPurpose");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "120"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 还款方式
        // -------------------------------------------------------------------------------------
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repayType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("baseEnums", LoanRepaymentType.values());
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 借款期限
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "loanPeriod");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkFun", "periodValidate");
        cydCheckTemp.put("parentKey", "repayType");
        cydCheckTemps.add(cydCheckTemp);

        // 借款金额
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "loanMoney");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是1-12位之间的整数，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,12})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 综合月利率
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "zhMonthlyRate");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须在0-100之间，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^\\d{1,2}|100|100.0|100.00|\\d{1,2}.\\d{1,2}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 抵押权人
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "pledgee");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 违约金率
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "wyRate");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须在0-100之间，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^\\d{1,2}|100|100.0|100.00|\\d{1,2}.\\d{1,2}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 滞纳金率
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "znRate");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须在0-100之间，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^\\d{1,2}|100|100.0|100.00|\\d{1,2}.\\d{1,2}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 保证金率
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "bzRate");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须在0-100之间，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^\\d{1,2}|100|100.0|100.00|\\d{1,2}.\\d{1,2}$");
        cydCheckTemps.add(cydCheckTemp);

        // 咨询费率
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "consultingRate");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须在0-100之间，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^\\d{1,2}|100|100.0|100.00|\\d{1,2}.\\d{1,2}$");
        cydCheckTemps.add(cydCheckTemp);

        // 停车费
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "parkFee");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是小于10000的数字，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,4})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // GPS安装费
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "gpsInstallationFee");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是小于10000的数字，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,4})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // GPS服务费
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "gpsServiceFee");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是小于10000的数字，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,4})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // 其他费用
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "otherFee");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是小于10000的数字，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,4})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // 客户类型
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "customerType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "110"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 客户姓名
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "customerName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 性别
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "gender");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "101"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 年龄
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "age");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^(\\d{1,2}|1\\d{2})$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 身份证号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "idCard");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkFun", "idCarValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 身份证有效期
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "idCardExpiryTime");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemp.put("idCardDateValidate", true);
        cydCheckTemps.add(cydCheckTemp);

        // 户口所在地-省
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "houseHoldProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 户口所在地-市
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "houseHoldCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "houseHoldProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 户口所在地-区/县
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "houseHoldRegion");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "houseHoldCity");
        cydCheckTemps.add(cydCheckTemp);

        // 户口所在地-街道
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "houseHoldDetail");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 婚姻状况
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "marriage");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "105"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 子女数
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "hasChild");
        cydCheckTemp.put("type", "Integer");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^\\d{1,2}$");
        cydCheckTemps.add(cydCheckTemp);

        // 最高学历
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "hightDegree");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "106"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 手机号码1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "mobilePhoneOne");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须是11位数字");
        cydCheckTemp.put("checkWay", "^\\d{11}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 手机号码2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "mobilePhoneTwo");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须是11位数字");
        cydCheckTemp.put("checkWay", "^\\d{11}$");
        cydCheckTemp.put("length", 11);
        cydCheckTemps.add(cydCheckTemp);

        // 住宅电话
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "homePhone");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^(\\d{3,4}-|\\d{3,4})?\\d{7,8}$");
        cydCheckTemps.add(cydCheckTemp);

        // qq
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "qq");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^\\d{1,15}$");
        cydCheckTemp.put("length", 15);
        cydCheckTemps.add(cydCheckTemp);

        // 邮箱
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "email");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp
                .put("checkWay",
                        "^[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$");
        cydCheckTemps.add(cydCheckTemp);

        // 微信
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "wechat");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[a-zA-Z][a-zA-Z0-9_-]{5,19}$");
        cydCheckTemps.add(cydCheckTemp);

        // 来本市时间
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "arrivedCityTime");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 现住地址-省
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "curHouseHoldProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 现住地址-市
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "curHouseHoldCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "houseHoldProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 现住地址-区/县
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "curHouseHoldRegion");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "houseHoldCity");
        cydCheckTemps.add(cydCheckTemp);

        // 现住地址-街道
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "curHouseHoldDetail");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 现住址入住时间
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "checkInTime");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 现住址类别
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "houseProperty");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "107"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 职业身份
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "jobIdentity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "151"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 个人征信
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "personalCredit");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 3);
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "159"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 房产地址-省
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "housePropertyProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 房产地址-市
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "housePropertyCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "housePropertyProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 房产地址-区/县
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "housePropertyRegion");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "housePropertyCity");
        cydCheckTemps.add(cydCheckTemp);

        // 房产地址-街道
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "housePropertyDetail");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 购买方式
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "buyingOption");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "152"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 购买/建成日期
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "buyOrBuildDate");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 房产所有权性质
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "ownershipOfProperty");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "122"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 车牌号码
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carNo");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z0-9]{7,8}$");
        cydCheckTemps.add(cydCheckTemp);

        // 初次登记日期
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "recordDate");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 车辆品牌
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carBrand");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "carBSMValidate");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 车系
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carSeries");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "carBSMValidate");
        cydCheckTemp.put("parentKey", "carBrands");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 登记证车辆型号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carRegistrationModel");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkWay", "^.{2,50}$");
        cydCheckTemps.add(cydCheckTemp);

        // 购买价格
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carPrice");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是1-12位之间的整数，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,12})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 车辆类型
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "114"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 车辆颜色
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carColor");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "115"), "dicValue"));
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 车架号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carFrameNo");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[0-9a-zA-Z]{17}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 发动机号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carEngineNo");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[0-9a-zA-Z]{8,10}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 燃料种类
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carFuelType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "116"), "dicValue"));
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 核定载客
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carSeats");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[1-9]+\\d*$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 车辆出厂日期
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carFactoryTime");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 驾驶位置
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carDriverPosition");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "117"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 车辆数量
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carSum");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[1-9]+\\d*$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 车辆归属
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "carBlone");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "118"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 单位名称
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 40);
        cydCheckTemps.add(cydCheckTemp);

        // 单位地址-省
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 单位地址-市
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "companyProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 单位地址-区/县
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyRegion");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "companyCity");
        cydCheckTemps.add(cydCheckTemp);

        // 单位地址-街道
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyDetail");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 单位性质
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyNature");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "108"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 单位电话
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyTel");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^(\\d{3,4}-|\\d{3,4})?\\d{7,8}$");
        cydCheckTemps.add(cydCheckTemp);

        // 传真号码
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyFax");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^(\\d{3,4}-|\\d{3,4})?\\d{7,8}$");
        cydCheckTemps.add(cydCheckTemp);

        // 单位网址
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyWeb");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^(https?:\\/\\/)?([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?$");
        cydCheckTemps.add(cydCheckTemp);

        // 部门职位
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "jobTitle");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 入职时间
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "entryTime");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 每月基本薪金
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "salaryBase");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是1-12位之间的整数，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,12})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // 其他收入
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "salaryOther");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是1-12位之间的整数，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,12})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // 每月总收入
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "salaryTotal");
        cydCheckTemp.put("type", "BigDecimal");
        cydCheckTemp.put("typeName", "必须是1-12位之间的整数，且最多支持两位小数");
        cydCheckTemp.put("checkWay", "^(\\d{1,12})(\\.\\d{1,2}|\\.{0})$");
        cydCheckTemps.add(cydCheckTemp);

        // 私营企业类型
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "companyType");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "158"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 成立时间
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "foundTime");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "dateValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 紧急联系人姓名1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenOneName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 关系1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenOneRelation");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "111"), "dicValue"));
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 手机号码1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenOnePhone");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须是11位数字");
        cydCheckTemp.put("checkWay", "^\\d{11}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 11);
        cydCheckTemps.add(cydCheckTemp);

        // 单位名称1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenOneCompanyName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 40);
        cydCheckTemps.add(cydCheckTemp);

        // 是否知晓借款1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenOneKnown");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "113"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 紧急联系人姓名2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenTwoName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 关系2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenTwoRelation");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "111"), "dicValue"));
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 手机号码2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenTwoPhone");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须是11位数字");
        cydCheckTemp.put("checkWay", "^\\d{11}$");
        cydCheckTemp.put("length", 11);
        cydCheckTemps.add(cydCheckTemp);

        // 单位名称2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenTwoCompanyName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 40);
        cydCheckTemps.add(cydCheckTemp);

        // 是否知晓借款2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "urgenTwoKnown");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("valItem", getValItem(dataDicDAO.getListByType(domain, productCode, "113"), "dicValue"));
        cydCheckTemps.add(cydCheckTemp);

        // 共同借款人1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOneName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 身份证1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOneIdCard");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "idCarValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 移动电话1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOnePhone");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须是11位数字");
        cydCheckTemp.put("checkWay", "^\\d{11}$");
        cydCheckTemp.put("length", 11);
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-省1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOneLivingProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-市1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOneLivingCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "sharerOneLivingProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-县/区1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOneLivingRegion");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "sharerOneLivingCity");
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-街道1
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerOneLivingDetail");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 共同借款人2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 身份证2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoIdCard");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("checkFun", "idCarValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 移动电话2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoPhone");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "必须是11位数字");
        cydCheckTemp.put("checkWay", "^\\d{11}$");
        cydCheckTemp.put("length", 11);
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-省2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoLivingProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-市2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoLivingCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "sharerTwoLivingProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-县/区2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoLivingRegion");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "sharerTwoLivingCity");
        cydCheckTemps.add(cydCheckTemp);

        // 现住宅地址-街道2
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "sharerTwoLivingDetail");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("length", 50);
        cydCheckTemps.add(cydCheckTemp);

        // 收款人姓名
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 收款银行
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversBankName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(p2PBankService.getBankList(), "bankName"));
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 收款银行所在省
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversBankProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 收款银行所在市
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversBankCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "receiversBankProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 收款支行
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversBankBranch");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 收款银行账号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversBankAccount");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "只能是10-25位数字");
        cydCheckTemp.put("checkWay", "^\\d{10,25}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 收款确认银行账号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "receiversConfirmBankAccount");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "只能是10-25位数字");
        cydCheckTemp.put("checkWay", "^\\d{10,25}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 还款人姓名
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 还款银行
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentBankName");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("valItem", getValItem(p2PBankService.getBankList(), "bankName"));
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 还款银行所在省
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentBankProvince");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemps.add(cydCheckTemp);

        // 还款银行所在市
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentBankCity");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemp.put("checkFun", "districtValidate");
        cydCheckTemp.put("parentKey", "repaymentBankProvince");
        cydCheckTemps.add(cydCheckTemp);

        // 还款支行
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentBankBranch");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "填写错误");
        cydCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemp.put("length", 20);
        cydCheckTemps.add(cydCheckTemp);

        // 还款银行账号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentBankAccount");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "只能是10-25位数字");
        cydCheckTemp.put("checkWay", "^\\d{10,25}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);

        // 还款确认银行账号
        cydCheckTemp = new HashMap<String, Object>();
        cydCheckTemp.put("key", "repaymentConfirmBankAccount");
        cydCheckTemp.put("type", "String");
        cydCheckTemp.put("typeName", "只能是10-25位数字");
        cydCheckTemp.put("checkWay", "^\\d{10,25}$");
        cydCheckTemp.put("isNotNull", true);
        cydCheckTemps.add(cydCheckTemp);
        return cydCheckTemps;
    }

    private List<String> getValItem(List<Map<String, String>> list, String key) {
        if (list == null)
            return null;
        List<String> valItem = new ArrayList<String>();
        for (Map<String, String> item : list) {
            valItem.add(item.get(key).toString());
        }
        return valItem;
    }
}
