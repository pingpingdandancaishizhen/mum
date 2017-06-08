package cn.sunfit.risk.buz.server.service.p2p.imp.handle;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.ProductSubType;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPAttr;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.constants.order.CydLoanInfo2AttrEnum;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.p2p.productSubType.ProductSubTypeService;
import cn.sunfit.risk.buz.api.service.system.DataService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ExcelToBeanResult;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportBean;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportError;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.Term;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;
import cn.sunfit.risk.buz.server.service.p2p.util.CydCheckRulesService;

/**
 * 
 * @Title: CYDImportHandle.java
 * @Package cn.sunfit.risk.buz.server.service.p2p.imp.handle
 * @Description: 车易贷的导入处理，包含了封装数据，验证，插入，开启流程等
 * @author DELL
 * @date 2017年5月5日 下午1:11:17
 * @version V1.0
 */
@Service("cydimporthandle")
public class CYDImportHandle extends ImportHandleAbstrat {

    private static List<Map<String, Object>> cydCheckTemps;

    @Autowired
    CydCheckRulesService cydCheckRulesService;

    @Autowired
    private P2PBankService p2PBankService;

    @Autowired
    private DataService dataService;

    @Autowired
    private ProductSubTypeService productSubTypeService;

    @Autowired
    private LoanInfoDAO loanInfoDAO;

    @Autowired
    private P2PProductService p2PProductService;

    @Override
    public ExcelToBeanResult excelToBean(String domain, String corpId, String productId, String userId,
            String importCode, InputStream in) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException {
        P2PProduct products = p2PProductService.findByProductCode(productId, domain);
        CydFeeConfig cydFeeConfig = JsonUtils.parseJSON(products.getFeeConfig(), CydFeeConfig.class);
        cydCheckTemps = cydCheckRulesService.getCydCheckTemp(domain, productId);
        ExcelToBeanResult result = new ExcelToBeanResult();
        List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
        Map<String, Object> data = null;
        List<ImportError> errList = new ArrayList<ImportError>();
        ImportError err = null;
        XSSFWorkbook wb = new XSSFWorkbook(in);
        XSSFSheet sheet = wb.getSheetAt(0);
        int totalRow = sheet.getLastRowNum() + 1;
        if (totalRow == 0)
            return null;
        int totalCellNum = sheet.getRow(0).getLastCellNum();
        List<String> cellNames = getCellNames(sheet.getRow(0));
        if (cellNames.size() != cydCheckTemps.size()) {
            result.setSuccess(false);
            result.setMessage("导入失败，导入模板列数不匹配!");
            return result;
        }
        if (totalRow > 1001) {
            result.setSuccess(false);
            result.setMessage("导入失败，一次导入订单数不能超过1000条!");
            return result;
        }
        XSSFRow row = null;
        XSSFCell cell = null;
        Date sysDate = new Date();
        for (int i = 1; i < totalRow; i++) {
            data = new HashMap<String, Object>();
            err = new ImportError();
            row = sheet.getRow(i);
            if (!isNotEmpty(row, totalCellNum))
                continue;
            for (int k = 0; k < totalCellNum; k++) {
                cell = row.getCell(k);
                cellCheck(cell, cellNames, cydCheckTemps, k, data, err, i, cydFeeConfig.getTerms(), products);
                if (err != null && err.getLine() > 0) {
                    errList.add(err);
                    break;
                }
            }
            if (err != null && err.getLine() > 0)
                continue;
            for (Map<String, Object> m : datas) {
                if (m.get("thirdLoanId").toString().equals(data.get("thirdLoanId").toString())) {
                    err.setLine(i);
                    err.setLoanId(data.get("thirdLoanId").toString());
                    err.setErrorInfo("此行订单与第" + m.get("index").toString() + "条订单重复!");
                    errList.add(err);
                    break;
                }
            }

            if (err != null && err.getLine() > 0)
                continue;

            data.put("loanHandleType", "1");
            data.put("createTime", sysDate);
            data.put("createUser", userId);
            data.put("importCode", importCode);
            data.put("index", i);
            data.put("corporation", products.getAssetId());
            datas.add(data);
        }
        List<String> loanIds = new ArrayList<String>();
        for (Map<String, Object> m : datas) {
            if (m.get("thirdLoanId") != null) {
                loanIds.add(m.get("thirdLoanId").toString());
            }
        }
        if (loanIds.size() > 0) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("thirdLoanIds", loanIds);
            param.put("productCode", productId);
            param.put("domain", domain);
            List<String> existLoanIds = loanInfoDAO.queryExistLoanIds(param);
            List<Map<String, Object>> existList = new ArrayList<Map<String, Object>>();
            if (existLoanIds != null && existLoanIds.size() > 0) {
                for (Map<String, Object> m : datas) {
                    if (existLoanIds.contains(m.get("thirdLoanId").toString())) {
                        existList.add(m);
                    }
                }
            }

            datas.removeAll(existList);

            for (Map<String, Object> m : existList) {
                err = new ImportError();
                err.setLine((int) m.get("index"));
                err.setLoanId(m.get("thirdLoanId").toString());
                err.setErrorInfo("此订单在系统中已存在！");
                errList.add(err);
            }
        }

        List<ImportBean> importList = new ArrayList<ImportBean>();
        BPAttr attr;
        for (Map<String, Object> beanMap : datas) {
            List<BPAttr> attrList = new ArrayList<BPAttr>();
            ImportBean importBean = new ImportBean();
            String bpId = IdUtil.geneId().replace("-", "");
            beanMap.put("bpId", bpId);
            beanMap.put("importWay", "批量导入");
            // 收款银行
            String receiveBankName = p2PBankService.getBankcodeByName(beanMap.get("receiversBankName").toString());
            if (StringUtils.isNotBlank(receiveBankName)) {
                beanMap.put("receiversBankName", receiveBankName);
            }
            // 还款银行
            String repaymentBankName = p2PBankService.getBankcodeByName(beanMap.get("repaymentBankName").toString());
            if (StringUtils.isNotBlank(repaymentBankName)) {
                beanMap.put("repaymentBankName", repaymentBankName);
            }

            // 产品类型
            String productType = p2PProductService.getProductTypeByCode(domain, beanMap.get("productCode").toString());
            beanMap.put("productType", productType);
            beanMap.put("productTypeId", products.getProductType());

            // 产品子类型
            ProductSubType pst = productSubTypeService.getByName(domain, beanMap.get("productCode").toString(), beanMap
                    .get("productSubType").toString());
            if (pst != null && StringUtils.isNotBlank(pst.getId())) {
                beanMap.put("productSubTypeId", pst.getId());
            }
            // 完整户籍地址
            if (beanMap.get("houseHoldProvince") != null && beanMap.get("houseHoldCity") != null
                    && beanMap.get("houseHoldRegion") != null) {
                String regAddrStr = beanMap.get("houseHoldProvince") + "/" + beanMap.get("houseHoldCity") + "/"
                        + beanMap.get("houseHoldRegion");
                if (beanMap.get("houseHoldDetail") != null
                        && StringUtils.isNotBlank((String) beanMap.get("houseHoldDetail"))) {
                    regAddrStr = regAddrStr + "/" + beanMap.get("houseHoldDetail");
                }
                beanMap.put("houseHoldAddress", regAddrStr);
            }

            // 完整现住址
            if (beanMap.get("curHouseHoldProvince") != null && beanMap.get("curHouseHoldCity") != null
                    && beanMap.get("curHouseHoldRegion") != null) {
                String livingAddrStr = beanMap.get("curHouseHoldProvince") + "/" + beanMap.get("curHouseHoldCity")
                        + "/" + beanMap.get("curHouseHoldRegion");
                if (beanMap.get("curHouseHoldDetail") != null
                        && StringUtils.isNotBlank((String) beanMap.get("curHouseHoldDetail"))) {
                    livingAddrStr = livingAddrStr + "/" + beanMap.get("curHouseHoldDetail");
                }
                beanMap.put("curHouseHoldAddress", livingAddrStr);
            }

            // 完整房产地址
            if (beanMap.get("housePropertyProvince") != null && beanMap.get("housePropertyCity") != null
                    && beanMap.get("housePropertyRegion") != null) {
                String houseAddrStr = beanMap.get("housePropertyProvince") + "/" + beanMap.get("housePropertyCity")
                        + "/" + beanMap.get("housePropertyRegion");
                if (beanMap.get("housePropertyDetail") != null
                        && StringUtils.isNotBlank((String) beanMap.get("housePropertyDetail"))) {
                    houseAddrStr = houseAddrStr + "/" + beanMap.get("housePropertyDetail");
                }
                beanMap.put("housePropertyAddress", houseAddrStr);
            }

            // 完整单位地址
            if (beanMap.get("companyProvince") != null && beanMap.get("companyCity") != null
                    && beanMap.get("companyRegion") != null) {
                String companyAddrStr = beanMap.get("companyProvince") + "/" + beanMap.get("companyCity") + "/"
                        + beanMap.get("companyRegion");
                if (beanMap.get("companyDetail") != null
                        && StringUtils.isNotBlank((String) beanMap.get("companyDetail"))) {
                    companyAddrStr = companyAddrStr + "/" + beanMap.get("companyDetail");
                }
                beanMap.put("companyAddress", companyAddrStr);
            }

            // 完整共借人1现住址
            if (beanMap.get("sharerOneLivingProvince") != null && beanMap.get("sharerOneLivingCity") != null
                    && beanMap.get("sharerOneLivingRegion") != null) {
                String sharerOneAddrStr = beanMap.get("sharerOneLivingProvince") + "/"
                        + beanMap.get("sharerOneLivingCity") + "/" + beanMap.get("sharerOneLivingRegion");
                if (beanMap.get("sharerOneLivingDetail") != null
                        && StringUtils.isNotBlank((String) beanMap.get("sharerOneLivingDetail"))) {
                    sharerOneAddrStr = sharerOneAddrStr + "/" + beanMap.get("sharerOneLivingDetail");
                }
                beanMap.put("sharerOneLivingAddress", sharerOneAddrStr);
            }

            // 完整共借人2现住址
            if (beanMap.get("sharerTwoLivingProvince") != null && beanMap.get("sharerTwoLivingCity") != null
                    && beanMap.get("sharerTwoLivingRegion") != null) {
                String sharerTwoAddrStr = beanMap.get("sharerTwoLivingProvince") + "/"
                        + beanMap.get("sharerTwoLivingCity") + "/" + beanMap.get("sharerTwoLivingRegion");
                if (beanMap.get("sharerTwoLivingDetail") != null
                        && StringUtils.isNotBlank((String) beanMap.get("sharerTwoLivingDetail"))) {
                    sharerTwoAddrStr = sharerTwoAddrStr + "/" + beanMap.get("sharerTwoLivingDetail");
                }
                beanMap.put("sharerTwoLivingAddress", sharerTwoAddrStr);
            }

            // 完整收款银行所在地
            if (beanMap.get("receiversBankProvince") != null && beanMap.get("receiversBankCity") != null) {
                beanMap.put("receiversBankAddress",
                        beanMap.get("receiversBankProvince") + "/" + beanMap.get("receiversBankCity"));
            }

            // 还款银行所在地
            if (beanMap.get("repaymentBankProvince") != null && beanMap.get("repaymentBankCity") != null) {
                beanMap.put("repaymentBankAddress",
                        beanMap.get("repaymentBankProvince") + "/" + beanMap.get("repaymentBankCity"));
            }

            // 是否有房产
            if ((beanMap.containsKey("housePropertyProvince") && StringUtils.isNotBlank(beanMap.get(
                    "housePropertyProvince").toString()))
                    || (beanMap.containsKey("housePropertyCity") && StringUtils.isNotBlank(beanMap.get(
                            "housePropertyCity").toString()))
                    || (beanMap.containsKey("housePropertyRegion") && StringUtils.isNotBlank(beanMap.get(
                            "housePropertyRegion").toString()))
                    || (beanMap.containsKey("housePropertyDetail") && StringUtils.isNotBlank(beanMap.get(
                            "housePropertyDetail").toString()))
                    || (beanMap.containsKey("housePropertyDetail") && StringUtils.isNotBlank(beanMap
                            .get("buyingOption").toString()))
                    || (beanMap.containsKey("buyOrBuildDate") && StringUtils.isNotBlank(beanMap.get("buyOrBuildDate")
                            .toString()))
                    || (beanMap.containsKey("ownershipOfProperty") && StringUtils.isNotBlank(beanMap.get(
                            "ownershipOfProperty").toString()))) {
                beanMap.put("hasHouseProperty", "是");
            } else {
                beanMap.put("hasHouseProperty", "否");
            }

            // 是否是私营企业主
            if ((beanMap.containsKey("companyType") && StringUtils.isNotBlank(beanMap.get("companyType").toString()))
                    || (beanMap.containsKey("foundTime") && StringUtils.isNotBlank(beanMap.get("foundTime").toString()))) {
                beanMap.put("isSyyz", "是");
            } else {
                beanMap.put("isSyyz", "否");
            }

            // 借款期限
            if (beanMap.containsKey("loanPeriod") && beanMap.get("loanPeriod") != null) {
                for (Term term : cydFeeConfig.getTerms()) {
                    if (term.getTermName().equals(beanMap.get("loanPeriod"))) {
                        if (beanMap.get("loanPeriod").toString().endsWith("月")) {
                            beanMap.put("loanMonthlyTerm", term.getTerm());
                            beanMap.put("isDaylyTrem", "否");
                        } else {
                            beanMap.put("loanDaylyTerm", term.getTerm());
                            beanMap.put("isDaylyTrem", "是");
                        }
                        beanMap.put("loanPeriod", term.getTerm());
                        break;
                    }
                }
            }
            // 金额转换
            if (beanMap.get("otherFee") != null && StringUtils.isNotBlank(beanMap.get("otherFee").toString())) {
                BigDecimal decimal = new BigDecimal(beanMap.get("otherFee").toString());
                beanMap.put("otherFee", new DecimalFormat("0.00").format(decimal.doubleValue()));
            }
            if (beanMap.get("znRate") != null && StringUtils.isNotBlank(beanMap.get("znRate").toString())) {
                BigDecimal decimal = new BigDecimal(beanMap.get("znRate").toString());
                beanMap.put("znRate", new DecimalFormat("0.00").format(decimal.doubleValue()));
            }
            if (beanMap.get("wyRate") != null && StringUtils.isNotBlank(beanMap.get("wyRate").toString())) {
                BigDecimal decimal = new BigDecimal(beanMap.get("wyRate").toString());
                beanMap.put("wyRate", new DecimalFormat("0.00").format(decimal.doubleValue()));
            }
            if (beanMap.get("bzRate") != null && StringUtils.isNotBlank(beanMap.get("bzRate").toString())) {
                BigDecimal decimal = new BigDecimal(beanMap.get("bzRate").toString());
                beanMap.put("bzRate", new DecimalFormat("0.00").format(decimal.doubleValue()));
            }

            // 车牌号转换大写字母
            if (beanMap.get("carNo") != null && StringUtils.isNotBlank(beanMap.get("carNo").toString())) {
                beanMap.put("carNo", beanMap.get("carNo").toString().toUpperCase());
            }

            // 身份证转换大写字母
            if (beanMap.get("idCard") != null && StringUtils.isNotBlank(beanMap.get("idCard").toString())) {
                beanMap.put("idCard", beanMap.get("idCard").toString().toUpperCase());
            }
            if (beanMap.get("sharerOneIdCard") != null
                    && StringUtils.isNotBlank(beanMap.get("sharerOneIdCard").toString())) {
                beanMap.put("sharerOneIdCard", beanMap.get("sharerOneIdCard").toString().toUpperCase());
            }
            if (beanMap.get("sharerTwoIdCard") != null
                    && StringUtils.isNotBlank(beanMap.get("sharerTwoIdCard").toString())) {
                beanMap.put("sharerTwoIdCard", beanMap.get("sharerTwoIdCard").toString().toUpperCase());
            }

            // 转换成attr
            for (String key : beanMap.keySet()) {
                if (key.endsWith("Dis")) {
                    continue;
                }
                CydLoanInfo2AttrEnum loan2attr = CydLoanInfo2AttrEnum.getByLoanInfoProperty(key);
                if (loan2attr == null) {
                    continue;
                }
                String fieldKey = loan2attr.getAttrFieldKey();
                if (beanMap.get(key) != null) {
                    String realValue = dataService.getDicKeyFromValue(domain, productId, fieldKey, beanMap.get(key)
                            + "");
                    attr = new BPAttr(IdUtil.geneId().replace("-", ""), corpId, bpId, fieldKey, realValue, "",
                            new Date(), domain);
                    beanMap.put(key, realValue);
                } else {
                    attr = new BPAttr(IdUtil.geneId().replace("-", ""), corpId, bpId, fieldKey, null, "", new Date(),
                            domain);
                }
                attrList.add(attr);
            }

            // 转换成loaninfo
            LoanInfoBean loaninfo = (LoanInfoBean) dataUtil.mapToObj(beanMap, LoanInfoBean.class);
            importBean.setLoaninfo(loaninfo);
            importBean.setAttrs(attrList);
            importList.add(importBean);
        }

        result.setSuccess(true);
        result.setImports(importList);
        result.setErrors(errList);
        return result;
    }
}
