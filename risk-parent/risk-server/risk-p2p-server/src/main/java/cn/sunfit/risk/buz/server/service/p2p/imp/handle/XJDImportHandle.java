package cn.sunfit.risk.buz.server.service.p2p.imp.handle;

import java.io.IOException;
import java.io.InputStream;
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
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPAttr;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.constants.order.LoanInfo2AttrEnum;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.system.DataService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ExcelToBeanResult;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportBean;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportError;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;
import cn.sunfit.risk.buz.server.service.p2p.util.XjdCheckRulesService;

/**
 * 
 * @Title: XJDImportHandle.java
 * @Package cn.sunfit.risk.buz.server.service.p2p.imp.handle
 * @Description: 现金贷的导入处理，包含了封装数据，验证，插入，开启流程等
 * @author RJS
 * @date 2017年5月8日 上午9:29:59
 * @version V1.0
 */
@Service("xjdimporthandle")
public class XJDImportHandle extends ImportHandleAbstrat {

    private static List<Map<String, Object>> xjdCheckTemps;

    @Autowired
    private XjdCheckRulesService xjdCheckRulesService;

    @Autowired
    private P2PProductService p2PProductService;

    @Autowired
    private P2PBankService p2PBankService;

    @Autowired
    private DataService dataService;

    @Autowired
    private LoanInfoDAO loanInfoDAO;

    @Override
    public ExcelToBeanResult excelToBean(String domain, String corpId, String productId, String userId,
            String importCode, InputStream in) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException {
        P2PProduct products = p2PProductService.findByProductCode(productId, domain);
        CydFeeConfig cydFeeConfig = JsonUtils.parseJSON(products.getFeeConfig(), CydFeeConfig.class);
        xjdCheckTemps = xjdCheckRulesService.getXjdCheckTemp(productId, domain);
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
        if (cellNames.size() != xjdCheckTemps.size()) {
            result.setSuccess(false);
            result.setMessage("导入失败，导入模板列数不匹配!");
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
            if (i > 1001) {
                result.setSuccess(false);
                result.setMessage("导入失败，一次导入订单数不能超过1000条!");
                return result;
            }
            for (int k = 0; k < totalCellNum; k++) {
                cell = row.getCell(k);
                cellCheck(cell, cellNames, xjdCheckTemps, k, data, err, i, cydFeeConfig.getTerms(), products);
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
            data.put("corporation", corpId);
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
            param.put("corporation", corpId);
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
        for (Map<String, Object> beanMap : datas) {
            List<BPAttr> attrList = new ArrayList<BPAttr>();
            ImportBean importBean = new ImportBean();
            String bpId = IdUtil.geneId().replace("-", "");
            beanMap.put("bpId", bpId);
            beanMap.put("importWay", "批量导入");
            String receiveBankName = p2PBankService.getBankcodeByName(beanMap.get("receiversBankName").toString());
            if (StringUtils.isNotBlank(receiveBankName)) {
                beanMap.put("receiversBankName", receiveBankName);
            }
            String repaymentBankName = p2PBankService.getBankcodeByName(beanMap.get("repaymentBankName").toString());
            if (StringUtils.isNotBlank(repaymentBankName)) {
                beanMap.put("repaymentBankName", repaymentBankName);
            }
            // 转换成attr
            for (String key : beanMap.keySet()) {
                if (key.endsWith("Dis")) {
                    continue;
                }
                LoanInfo2AttrEnum loan2attr = LoanInfo2AttrEnum.getByLoanInfoProperty(key);
                if (loan2attr == null) {
                    continue;
                }
                String fieldKey = loan2attr.getAttrFieldKey();
                String realValue = dataService.getDicKeyFromValue(domain, productId, fieldKey, beanMap.get(key) + "");
                BPAttr attr = new BPAttr(IdUtil.geneId().replace("-", ""), corpId, bpId, fieldKey, realValue, "",
                        new Date(), domain);
                attrList.add(attr);
            }

            // 完整户籍地址
            BPAttr attr_regist = new BPAttr(IdUtil.geneId().replace("-", ""), corpId, bpId, "cust_regist_addr",
                    beanMap.get("houseHoldProvince") + "/" + beanMap.get("houseHoldCity") + "/"
                            + beanMap.get("houseHoldRegion") + "/" + beanMap.get("houseHoldAddress"), "", new Date(),
                    domain);
            attrList.add(attr_regist);

            // 完整学校地址
            BPAttr attr_school = new BPAttr(IdUtil.geneId().replace("-", ""), corpId, bpId, "cust_school_addr",
                    beanMap.get("schoolProvince") + "/" + beanMap.get("schoolCity") + "/" + beanMap.get("schoolRegion")
                            + "/" + beanMap.get("schoolAddress"), "", new Date(), domain);
            attrList.add(attr_school);

            // 完整单位地址
            BPAttr attr_corp = new BPAttr(IdUtil.geneId().replace("-", ""), corpId, bpId, "custjob_company_addr",
                    beanMap.get("companyProvince") + "/" + beanMap.get("companyCity") + "/"
                            + beanMap.get("companyRegion") + "/" + beanMap.get("companyAddress"), "", new Date(),
                    domain);
            attrList.add(attr_corp);

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
