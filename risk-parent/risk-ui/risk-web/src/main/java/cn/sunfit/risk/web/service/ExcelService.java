/**
 * Copyright(C) 2011-2012 Muer DS. All Rights Reserved.
 * @title ExcelUtil.java
 * @package com.leo.fecalms.util
 * @compiler JDK1.6
 * @description TODO
 * @author Leo.Chen
 * @date 2011-12-15 下午1:00:16
 * @version V1.0  
 */

package cn.sunfit.risk.web.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.corp.District;
import cn.sunfit.risk.buz.api.service.p2p.excel.ImportExcelTemplateService;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.system.DistrictService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.util.p2p.BaseEnum;
import cn.sunfit.risk.buz.util.p2p.CompanyType;
import cn.sunfit.risk.buz.util.p2p.CustomerType;
import cn.sunfit.risk.buz.util.p2p.DateUtil;
import cn.sunfit.risk.buz.util.p2p.EducationType;
import cn.sunfit.risk.buz.util.p2p.GenderType;
import cn.sunfit.risk.buz.util.p2p.LoanEachTimeType;
import cn.sunfit.risk.buz.util.p2p.LoanRepaymentType;
import cn.sunfit.risk.buz.util.p2p.LoanUsageType;
import cn.sunfit.risk.buz.util.p2p.MaritalStatus;
import cn.sunfit.risk.buz.util.p2p.RelationType;




/**
 * @className ExcelUtil
 * @description TODO
 * @author Leo.Chen
 * @date 2011-12-15 下午1:00:16
 */
@Service
public class ExcelService {
    @Autowired
    P2PProductService p2PProductService;
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private P2PBankService p2PBankService;
    
	private static Logger log = Logger.getLogger(ExcelService.class);
	
	public final static String TMP_PATH = "temp/";
	public final static String EXCEL_EXTENSION = ".xls";
	 /** 
     * Excel 2003 
     */  
	public final static String XLS = "xls";  
    /** 
     * Excel 2007 
     */  
	public final static String XLSX = "xlsx";
	public final static String ERR = "ERR";
	public final static String ERR_FILENAME_NVL = "ERR_FILENAME_NVL";
	public final static String TEMPLATE_DIR = "template";
	public final static String CUSTOMER_TEMPLATE_NAME = "EXPORT_CUSTOMER.xls";
	public final static String CUSTOMERDRAFTIMPORT_TEMPLATE_NAME = "EXPORT_CUSTOMERDRAFTIMPORT.xls";
	public final static String HKTX_TEMPLATE_NAME = "fhktx.xls";
	public final static String JMSP_TEMPLATE_NAME = "jmsp.xls";
	public final static String CUSTOMERINFOFORKINGDEE_TEMPLATE_NAME = "CustomerInfoForKingdee.xls";
	public final static String CUSTOMERFINANCEFORKINGDEE_TEMPLATE_NAME = "CustomerFinanceForKingdee.xls";
	public final static String VOUCHERFORKINGDEE_TEMPLATE_NAME = "VoucherForKingdee.xls";
	public final static int ROWS_READ = 1000;//每次读取的数据条数
	
	/**
	 * 现金贷导入校验模板
	 */
	private static List<Map<String,Object>> xjdCheckTemps = null;
	
	private static List<District> districts;
	
	public List<District> getDistricts() {
	    if(districts == null){
	        districts = districtService.selectNodes();
	    }
        return districts;
    }

    public List<Map<String, Object>> getXjdCheckTemp() {
	    if(xjdCheckTemps == null){
	        List<Map<String, String>> product = p2PProductService.findRiskProductList();
	        List<Map<String, String>> banks = p2PBankService.getBankList();
	        
	        xjdCheckTemps = new ArrayList<Map<String,Object>>();
	        Map<String,Object> xjdCheckTemp = null;
	        
	        //订单号
	        xjdCheckTemp = new HashMap<String, Object>();
	        xjdCheckTemp.put("key", "thirdLoanId");
	        xjdCheckTemp.put("type", "String");
	        xjdCheckTemp.put("typeName", "必须为数字");
	        xjdCheckTemp.put("checkWay", "^[1-9]\\d*$");
	        xjdCheckTemp.put("isNotNull", true);
	        xjdCheckTemp.put("length", 20);
	        xjdCheckTemps.add(xjdCheckTemp);
	        
	        //产品代码
	        xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "productCode");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(product,"productCode"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //产品名称
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "productName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(product,"productName"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //借款用途
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "loanPurpose");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", LoanUsageType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //还款方式
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repayType");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", LoanRepaymentType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //借款期限
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
            
            //客户类型
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "customerType");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", CustomerType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //借款金额
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "loanMoney");
            xjdCheckTemp.put("type", "BigDecimal");
            xjdCheckTemp.put("typeName", "必须为亿万以下的数字");
            xjdCheckTemp.put("checkWay", "^[1-9]\\d*(\\.\\d{1,2})?$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 13);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //实际放款金额
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "realFKMoney");
            xjdCheckTemp.put("type", "BigDecimal");
            xjdCheckTemp.put("typeName", "必须为亿万以下的数字");
            xjdCheckTemp.put("checkWay", "^[1-9]\\d*(\\.\\d{1,2})?$");
            xjdCheckTemp.put("length", 13);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //客户姓名
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "customerName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,20}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //性别
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "gender");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", GenderType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //手机号码
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "mobilePhone");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须是11位数字");
            xjdCheckTemp.put("checkWay", "^\\d{11}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 11);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //身份证号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "idCard");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d{18}$|^\\d{17}[Xx]$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 18);
            //xjdCheckTemp.put("checkFun", "idCarValidate");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //户口所在地-省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //户口所在地-市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "houseHoldProvince");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //户口所在地-区/县
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldRegion");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "houseHoldCity");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //户口所在地-街道
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "houseHoldAddress");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //婚姻状况
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "marriage");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", MaritalStatus.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //子女数
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "hasChild");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d+$");
            xjdCheckTemp.put("length", 2);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //职业类型
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "jobType");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", CompanyType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //公司名称
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.+$");
            xjdCheckTemp.put("length", 40);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //公司地址-省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //公司地址-市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "companyProvince");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //公司地址-县
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyRegion");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "companyCity");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //公司地址-街道
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyAddress");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //公司电话
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "companyTel");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[0-9\\-]+$");
            xjdCheckTemp.put("length", 13);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //部门职位
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "jobTitle");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //最高学历
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "hightDegree");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", EducationType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //毕业院校
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "graduateInstitutions");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //学校地址-省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //学校地址-市
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolCity");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "schoolProvince");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //学校地址-县
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolRegion");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemp.put("parentKey", "schoolCity");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //学校地址-街道
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "schoolAddress");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^.{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //紧急联系人姓名1
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenContact1");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //关系1
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "relation1");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("baseEnums", RelationType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //手机号码1
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenPhone1");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须是11位数字");
            xjdCheckTemp.put("checkWay", "^\\d{11}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 11);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //紧急联系人姓名2
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenContact2");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //关系2
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "relation2");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("baseEnums", RelationType.values());
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //手机号码2
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "urgenPhone2");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "必须是11位数字");
            xjdCheckTemp.put("checkWay", "^\\d{11}$");
            xjdCheckTemp.put("length", 11);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //芝麻信用分
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "zMCreditScore");
            xjdCheckTemp.put("type", "Integer");
            xjdCheckTemp.put("typeName", "必须为350--950内的数字");
            xjdCheckTemp.put("checkWay", "^3[5-9]\\d$|^[4-8]\\d{2}$|^9[0-4]\\d$|^950$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 3);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //收款人姓名
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //收款人银行账号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankAccount");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d{16,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 19);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //收款银行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(banks, "bankName"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //收款银行所在省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //收款银行所在市
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
            
            //收款支行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "receiversBankBranch");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //还款人姓名
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^[\u4e00-\u9fa5a-zA-Z]{2,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //还款人银行账号
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankAccount");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "^\\d{16,}$");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 19);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //还款银行
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankName");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("valItem", getValItem(banks, "bankName"));
            xjdCheckTemp.put("length", 20);
            xjdCheckTemps.add(xjdCheckTemp);
            
            //还款银行所在省
            xjdCheckTemp = new HashMap<String, Object>();
            xjdCheckTemp.put("key", "repaymentBankProvince");
            xjdCheckTemp.put("type", "String");
            xjdCheckTemp.put("typeName", "填写错误");
            xjdCheckTemp.put("checkWay", "");
            xjdCheckTemp.put("isNotNull", true);
            xjdCheckTemp.put("length", 20);
            xjdCheckTemp.put("checkFun", "districtValidate");
            xjdCheckTemps.add(xjdCheckTemp);
            
            //还款银行所在市
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
            
            //还款支行
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
	
	private void cellCheck(XSSFCell cell,List<String> cellNames,List<Map<String, Object>> checkTemps,int index,
	        Map<String, Object> data,Map<String, Object> err,int row){
	    Map<String, Object> checkTemp = checkTemps.get(index);
        if(cell != null)
            cell.setCellType(Cell.CELL_TYPE_STRING);
        //非空判断
        if( (cell == null || "".equals(cell.getStringCellValue().replace(" ", ""))) && ( checkTemp.get("isNotNull") != null && (boolean)checkTemp.get("isNotNull") ) ){
            getErrObj(cell, data, row, index, cellNames.get(index)+"不能为空",err);
        }else{
            String key = checkTemp.get("key").toString();
            String parentKey = checkTemp.get("parentKey") != null ? checkTemp.get("parentKey").toString() : null;
            //如值为空进来，那么定为非必填，如必填进来，则值必定不为空
            if(cell == null || "".equals(cell.getStringCellValue())){
                data.put(key, null);
            }else{
                String value = cell.getStringCellValue().replace(" ", "");
                //如果列有指定只能填写的项值，那么只需要判断值有没有匹配
                if(checkTemp.containsKey("baseEnums")){
                    BaseEnum[] BaseEnums = (BaseEnum[])checkTemp.get("baseEnums");
                    boolean type = false;
                    BaseEnum val = null;
                    for(BaseEnum be : BaseEnums){
                        if(be.getEnumName().equals(value)){
                            type = true;
                            val = be;
                            break;
                        }
                    }
                    if(!type){
                        getErrObj(cell, data, row, index, cellNames.get(index)+"填写错误",err);
                    }else{
                        data.put(key, valConvertType(val.getEnumType(), checkTemp.get("type").toString()));
                    }
                }else if(checkTemp.containsKey("valItem")){
                    List<String> valItem = (List<String>)checkTemp.get("valItem");
                    if(!valItem.contains(value)){
                        getErrObj(cell, data, row, index, cellNames.get(index)+"填写错误",err);
                    }else{
                        data.put(key, valConvertType(value, checkTemp.get("type").toString()));
                    }
                }else{
                    if(!hasValType(value, checkTemp.get("checkWay").toString())
                        || !(checkTemp.containsKey("checkFun") ? 
                                checkFun(checkTemp.get("checkFun").toString(), value, key, parentKey, data) : true) ){
                        getErrObj(cell, data, row, index, cellNames.get(index)+checkTemp.get("typeName").toString(),err);
                    }else if(value.length() > Integer.valueOf(checkTemp.get("length").toString())){
                        getErrObj(cell, data, row, index, cellNames.get(index)+"输入长度不可超过"+checkTemp.get("length").toString(),err);
                    }else{
                        data.put(key, valConvertType(value, checkTemp.get("type").toString()));
                    }
                }
            }
        }
    }
	
	/**
	 * 封装错误提示
	 * @Title: getErrObj
	 * @Description: TODO
	 * @param @param cell
	 * @param @param data
	 * @param @param index
	 * @param @param err
	 * @param @return   
	 * @return Map<String,Object> 
	 * @author RJS 2017年4月12日 
	 * @throws
	 */
	public void getErrObj(XSSFCell cell,Map<String, Object> data,int row, int index, String err,Map<String,Object> errObj){
	    errObj.put("id", row);
        if(index == 0){
            errObj.put("thirdLoanId", cell == null ? "无":cell.getStringCellValue());
        }else{
            errObj.put("thirdLoanId", data.get("thirdLoanId"));
        }
        errObj.put("err", err);
	}
	
	public boolean hasValType(String val,String checkWay){
	    if(checkWay == null || "".equals(checkWay))
	        return true;
	    if(val.matches(checkWay))
	        return true;
	    return false;
	}
	
	public boolean checkFun(String fun,String val,String key,String parentKey,Map<String,Object> data){
	    if("idCarValidate".equals(fun)){
	        return idCarValidate(val);
	    }else if("districtValidate".equals(fun)){
	        return districtValidate(val, key, parentKey, data);
	    }else if("periodValidate".equals(fun)){
	        return periodValidate(val, key, parentKey, data);
	    }
	    return false;
	}
	
	public Object valConvertType(String val,String type){
	    if("Long".equals(type)){
	        return Long.valueOf(val);
	    }else if("Double".equals(type)){
	        return Double.valueOf(val);
	    }else if("BigDecimal".equals(type)){
	        return BigDecimal.valueOf(Double.valueOf(val));
	    }else if("Integer".equals(type)){
	        return Integer.valueOf(val);
	    }else{
	        return val;
	    }
	}
	
	/**
	 * 身份证验证
	 * 验证方法：
	 * 1、将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7－9－10－5－8－4－2－1－6－3－7－9－10－5－8－4－2
	 * 2、将这17位数字和系数相乘的结果相加
	 * 3、用加出来和除以11，看余数是多少？
	 * 4、余数只可能有0－1－2－3－4－5－6－7－8－9－10这11个数字。其分别对应的最后一位身份证的号码为1－0－X －9－8－7－6－5－4－3－2
	 * 5、通过上面得知如果余数是3，就会在身份证的第18位数字上出现的是9。
	 * @param idCar
	 * @return
	 */
	public static boolean idCarValidate(String idCar) {
	    int[] numArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2}; // 系数
	    String[] lastArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"}; // 最后一位身份证的号码
	    if (idCar == null || idCar.length() != 18) {
	        return false;
	    }
	    int sum = 0;
	    String[] strArr = idCar.toUpperCase().split("");
	    for (int i = 0; i < strArr.length - 2; i++) {
	        sum += Integer.valueOf(strArr[i+1]) * numArr[i];
	    }
	    return  strArr[18].equals(lastArr[sum % 11]);
	}
	
	public boolean districtValidate(String district,String key,String parentKey,Map<String,Object> data){
	    List<District> dists = getDistricts();
	    District parent = null;
	    if(parentKey != null)
	        parent = (District)data.get(parentKey+"Dis");
	    String newDistName = null;
	    for(District d:dists){
	        if(parent != null){
	            newDistName = d.getDistName().endsWith("市") 
	                            || d.getDistName().endsWith("区") 
	                            || d.getDistName().endsWith("县") 
	                            ? d.getDistName().substring(0, d.getDistName().length() - 1) : d.getDistName();
	            if(d.getParentCode().equals(parent.getDistCode()) 
	                    && (d.getDistName().equals(district) || newDistName.equals(district)) ){
	                data.put(key+"Dis", d);
	                return true;
	            }
	        }else{
	            newDistName = d.getDistName().replace("省", "");
	            if( (d.getDistName().equals(district) || newDistName.equals(district)) 
	                    && "1".equals(d.getParentCode()) ){
	                data.put(key+"Dis", d);
	                return true;
	            }
	        }
	    }
	    return false;
	}
	
	public boolean periodValidate(String period,String key,String parentKey,Map<String,Object> data){
	    String repayType = data.get(parentKey).toString();
	    List<LoanEachTimeType> letts = null;
	    if("3".equals(repayType)){
	        letts = LoanEachTimeType.getEnumByNameSuffix("天");
	    }else{
	        letts = LoanEachTimeType.getEnumByNameSuffix("月");
	    }
	    
	    for(LoanEachTimeType lett: letts){
	        if(lett.getStatus().equals(period))
	            return true;
	    }
	    
	    return false;
	}
	
	public static void main(String[] args) {
	    for(int i = 1;i<61;i++){//D1("D1", "15天", true)
	        System.out.println("D"+i+"(\""+i+"\",\""+i+"天\", false),");
	    }
        //System.out.println(idCarValidate("430522199206047813"));
    }
	
	public List<String> getValItem(List<Map<String, String>> list,String key){
	    if(list == null)
	        return null;
	    List<String> valItem = new ArrayList<String>();
	    for(Map<String, String> item:list){
	        valItem.add(item.get(key).toString());
	    }
	    return valItem;
	}

    /**
	 * 判断是否为空行
	 * @Title: isNotEmpty
	 * @Description: TODO
	 * @param @param row
	 * @param @param cellLength
	 * @param @return   
	 * @return boolean 
	 * @author RJS 2017年3月31日 
	 * @throws
	 */
	public boolean isNotEmpty(XSSFRow row,int cellLength){
	    if(row == null)
	        return false;
	    XSSFCell cell = null;
	    for(int i = 0;i<cellLength;i++){
	        cell = row.getCell(i);
            if(cell != null){
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if(StringUtils.isNotEmpty(cell.getStringCellValue()))
                    return true;
            }
	    }
	    return false;
	}
	
	private List<String> getCellNames(XSSFRow row){
	    if(row == null)
	        return null;
	    List<String> cellNames = new ArrayList<String>();
	    int totalCellNum = row.getLastCellNum();
	    XSSFCell cell = null;
	    for(int i = 0;i<totalCellNum;i++){
	        cell = row.getCell(i);
	        if(cell != null){
	            cell.setCellType(Cell.CELL_TYPE_STRING);
	            cellNames.add(cell.getStringCellValue().replace("*", ""));
	        }
	    }
	    return cellNames;
	}
	
	/**
	 * 解析批量导入订单数据
	 * @Title: batchImportLoan
	 * @Description: TODO
	 * @param @param in
	 * @param @return
	 * @param @throws IOException   
	 * @return List<Map<String,Object>> 
	 * @author dailongting 2017年3月22日 
	 * @throws
	 */
	public Map<String, Object> batchImportLoan(String userId,InputStream in,
	        ImportExcelTemplateService importExcelTemplateService,List<Map<String, Object>> xjdCheckTemps,
	        String importCode) throws IOException{
	    Map<String, Object> result = new HashMap<String, Object>();
	    List<Map<String, Object>> datas = new ArrayList<Map<String,Object>>();
	    Map<String, Object> data = null;
	    List<Map<String, Object>> errList = new ArrayList<Map<String,Object>>();
        Map<String, Object> err = null;
	    XSSFWorkbook wb = new XSSFWorkbook(in);
	    XSSFSheet sheet = wb.getSheetAt(0);
	    int totalRow = sheet.getLastRowNum() + 1;
	    if(totalRow == 0)
	        return null;
	    int totalCellNum = sheet.getRow(0).getLastCellNum();
	    List<String> cellNames = getCellNames(sheet.getRow(0));
	    if(cellNames.size() != xjdCheckTemps.size()){
	        result.put("errStr", "导入失败，导入模板列数不匹配!");
            return result;
	    }
	        
	    XSSFRow row = null;
	    XSSFCell cell = null;
	    Date sysDate = new Date();
	    for(int i = 1;i<totalRow;i++){
	        data = new HashMap<String, Object>();
	        err = new HashMap<String, Object>();
	        row = sheet.getRow(i);
	        if(!isNotEmpty(row, totalCellNum))
	            continue;
	        if(i > 1001){
	            result.put("errStr", "导入失败，一次导入订单数不能超过1000条!");
	            return result;
	        }
	        for(int k = 0;k<totalCellNum;k++){
	            cell = row.getCell(k);
	            cellCheck(cell, cellNames, xjdCheckTemps, k, data, err, i);
	            if(err.size() > 0){
	                errList.add(err);
	                break;
	            }
	        }
	        if(err.size() > 0)
	            continue;
	        
	        for(Map<String, Object> m:datas){
	            if(m.get("thirdLoanId").toString().equals(data.get("thirdLoanId").toString())){
                    err.put("id", i);
                    err.put("thirdLoanId", data.get("thirdLoanId").toString());
                    err.put("err", "此行订单与第"+m.get("index").toString()+"条订单重复!");
                    errList.add(err);
                    break;
	            }
	        }
	        
	        if(err.size() > 0)
                continue;
	        
	        data.put("loanHandleType", "1");
	        data.put("createTime", DateUtil.dateToStringFour(sysDate));
	        data.put("createUser", userId);
	        data.put("importCode", importCode);
	        data.put("index", i);
	        datas.add(data);
	    }
	    
	    String loanIds = "";
	    String corporation = "融金所";
	    for(Map<String,Object> m:datas){
	        loanIds += m.get("thirdLoanId").toString()+",";
	    }
	    if(loanIds.length() > 0){
	        loanIds = loanIds.substring(0, loanIds.length() - 1);
	        Map<String,Object> param = new HashMap<String, Object>();
	        param.put("thirdLoanIds", loanIds);
	        param.put("corporation", corporation);
	        List<Long> existLoanIds = importExcelTemplateService.queryExistLoanIds(param);
	        List<Map<String, Object>> existList = new ArrayList<Map<String,Object>>();
	        if(existLoanIds != null && existLoanIds.size() > 0){
	            for(Map<String,Object> m:datas){
	                if( existLoanIds.contains( Long.valueOf(m.get("thirdLoanId").toString()) ) ){
	                    existList.add(m);
	                }
	            }
	        }
	        
	        datas.removeAll(existList);
	        
	        for(Map<String,Object> m:existList){
	            err = new HashMap<String, Object>();
                err.put("id", m.get("index").toString());
                err.put("thirdLoanId", m.get("thirdLoanId").toString());
                err.put("err", "此订单在系统中已存在！");
                errList.add(err);
	        }
	    }
	    
	    result.put("data", datas);
	    result.put("err", errList);
	    return result;
	}
}
