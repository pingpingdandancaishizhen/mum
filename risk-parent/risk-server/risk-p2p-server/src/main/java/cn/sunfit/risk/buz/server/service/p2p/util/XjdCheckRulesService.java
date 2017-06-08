package cn.sunfit.risk.buz.server.service.p2p.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.constants.order.CompanyType;
import cn.sunfit.risk.buz.api.constants.order.CustomerType;
import cn.sunfit.risk.buz.api.constants.order.EducationType;
import cn.sunfit.risk.buz.api.constants.order.GenderType;
import cn.sunfit.risk.buz.api.constants.order.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.order.LoanUsageType;
import cn.sunfit.risk.buz.api.constants.order.MaritalStatus;
import cn.sunfit.risk.buz.api.constants.order.RelationType;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;

@Service
public class XjdCheckRulesService {

    @Autowired
    private P2PProductService p2PProductService;

    @Autowired
    private P2PBankService p2PBankService;

    /**
     * 现金贷导入校验模板
     */
    public List<Map<String, Object>> xjdCheckTemps = null;

    private List<String> getValItem(List<Map<String, String>> list, String key) {
        if (list == null)
            return null;
        List<String> valItem = new ArrayList<String>();
        for (Map<String, String> item : list) {
            valItem.add(item.get(key).toString());
        }
        return valItem;
    }

    public List<Map<String, Object>> getXjdCheckTemp(String domain, String productCode) {
        if (xjdCheckTemps == null) {
            xjdCheckTemps = new ArrayList<Map<String, Object>>();
            Map<String, Object> xjdCheckTemp = null;

            // 订单号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "thirdLoanId");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须为数字");
            xjdCheckTemp.put("checkWay", "^[1-9]\\d*$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 产品代码
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "productCode");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "产品代码必须是CYD");
            xjdCheckTemp.put("checkWay", "^CYD$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemps.add(xjdCheckTemp);

            // 产品名称
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "productName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(p2PProductService.findRiskProductList(domain), "productName"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 借款用途
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "loanPurpose");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", LoanUsageType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款方式
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repayType");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", LoanRepaymentType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 借款期限
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "loanPeriod");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "必须为数字");
            xjdCheckTemp.put("checkWay", "^[1-9]\\d*$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 2);
            xjdCheckTemp.put("checkFun", "periodValidate");
            xjdCheckTemp.put("parentKey", "repayType");
            xjdCheckTemps.add(xjdCheckTemp);

            // 客户类型
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "customerType");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", CustomerType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 借款金额
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "loanMoney");
            xjdCheckTemp.put("type", "BigDecimal");
            xjdCheckTemp.put("typeName", "必须为亿万以下的数字");
            xjdCheckTemp.put("checkWay", "^[1-9]\\d*(\\.\\d{1,2})?$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 13);
            xjdCheckTemps.add(xjdCheckTemp);

            // 实际放款金额
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "realFKMoney");
            xjdCheckTemp.put("type", "BigDecimal");
            xjdCheckTemp.put("typeName", "必须为亿万以下的数字");
            xjdCheckTemp.put("checkWay", "^[1-9]\\d*(\\.\\d{1,2})?$");
            xjdCheckTemp.put("length", 13);
            xjdCheckTemps.add(xjdCheckTemp);

            // 客户姓名
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "customerName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 性别
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "gender");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", GenderType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 手机号码
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "mobilePhone");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须是11位数字");
            xjdCheckTemp.put("checkWay", "^\\d{11}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 11);
            xjdCheckTemps.add(xjdCheckTemp);

            // 身份证号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "idCard");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d{18}$|^\\d{17}[Xx]$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 18);
            // xjdCheckTemp.put("checkFun", "idCarValidate");
            xjdCheckTemps.add(xjdCheckTemp);

            // 户口所在地-省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);

            // 户口所在地-市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "houseHoldProvince");
            xjdCheckTemps.add(xjdCheckTemp);

            // 户口所在地-区/县
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldRegion");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "houseHoldCity");
            xjdCheckTemps.add(xjdCheckTemp);

            // 户口所在地-街道
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldAddress");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 婚姻状况
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "marriage");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", MaritalStatus.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 子女数
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "hasChild");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d+$");
            xjdCheckTemp.put("length", 2);
            xjdCheckTemps.add(xjdCheckTemp);

            // 职业类型
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "jobType");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", CompanyType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 公司名称
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.+$");
            xjdCheckTemp.put("length", 40);
            xjdCheckTemps.add(xjdCheckTemp);

            // 公司地址-省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);

            // 公司地址-市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "companyProvince");
            xjdCheckTemps.add(xjdCheckTemp);

            // 公司地址-县
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyRegion");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "companyCity");
            xjdCheckTemps.add(xjdCheckTemp);

            // 公司地址-街道
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyAddress");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 公司电话
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyTel");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[0-9\\-]+$");
            xjdCheckTemp.put("length", 13);
            xjdCheckTemps.add(xjdCheckTemp);

            // 部门职位
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "jobTitle");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 最高学历
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "hightDegree");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", EducationType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 毕业院校
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "graduateInstitutions");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 学校地址-省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);

            // 学校地址-市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "schoolProvince");
            xjdCheckTemps.add(xjdCheckTemp);

            // 学校地址-县
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolRegion");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "schoolCity");
            xjdCheckTemps.add(xjdCheckTemp);

            // 学校地址-街道
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolAddress");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 紧急联系人姓名1
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenContact1");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 关系1
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "relation1");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", RelationType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 手机号码1
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenPhone1");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须是11位数字");
            xjdCheckTemp.put("checkWay", "^\\d{11}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 11);
            xjdCheckTemps.add(xjdCheckTemp);

            // 紧急联系人姓名2
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenContact2");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 关系2
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "relation2");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", RelationType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 手机号码2
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenPhone2");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须是11位数字");
            xjdCheckTemp.put("checkWay", "^\\d{11}$");
            xjdCheckTemp.put("length", 11);
            xjdCheckTemps.add(xjdCheckTemp);

            // 芝麻信用分
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "zMCreditScore");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "必须为350--950内的数字");
            xjdCheckTemp.put("checkWay", "^3[5-9]\\d$|^[4-8]\\d{2}$|^9[0-4]\\d$|^950$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 3);
            xjdCheckTemps.add(xjdCheckTemp);

            // 收款人姓名
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 收款人银行账号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankAccount");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d{16,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 19);
            xjdCheckTemps.add(xjdCheckTemp);

            // 收款银行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(p2PBankService.getBankList(), "bankName"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 收款银行所在省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);

            // 收款银行所在市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "receiversBankProvince");
            xjdCheckTemps.add(xjdCheckTemp);

            // 收款支行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankBranch");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款人姓名
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款人银行账号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankAccount");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d{16,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 19);
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款银行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(p2PBankService.getBankList(), "bankName"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款银行所在省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款银行所在市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "repaymentBankProvince");
            xjdCheckTemps.add(xjdCheckTemp);

            // 还款支行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankBranch");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
        }
        return xjdCheckTemps;
    }
}
