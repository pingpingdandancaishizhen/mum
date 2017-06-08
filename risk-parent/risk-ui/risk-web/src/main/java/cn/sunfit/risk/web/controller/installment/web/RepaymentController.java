package cn.sunfit.risk.web.controller.installment.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.installment.InsuranceDTO;
import cn.sunfit.risk.buz.api.beans.installment.InsuranceReportDTO;
import cn.sunfit.risk.buz.api.beans.installment.LoanPeriods;
import cn.sunfit.risk.buz.api.beans.installment.LoansExportDTO;
import cn.sunfit.risk.buz.api.beans.installment.Owner;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.installment.InstallemntReportService;
import cn.sunfit.risk.buz.api.service.installment.InstallemntService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.installment.InstallmentQueryReq;
import cn.sunfit.risk.web.utils.ExcelHandleUtil;

/**
 * 
 * @Title: LoansController.java
 * @Package cn.sunfit.risk.web.controller.installment.web
 * @Description: 换款管理
 * @author LiuYa
 * @date 2017年4月25日 上午10:17:08
 * @version V1.0
 */
@Controller
@RequestMapping("/repayment")
public class RepaymentController {

    @Autowired
    private InstallemntService installemntService;

    @Autowired
    private InstallemntReportService installemntReportService;

    /**
     * 
     * @Title: exportAllLoans
     * @Description: 导出放款
     * @param @param req
     * @param @param response
     * @return void
     * @author QuGuanglei 2017年4月13日
     * @throws
     */
    @RequestMapping(value = "/exportAllLoans", method = RequestMethod.GET)
    public void exportAllLoans(InstallmentQueryReq req,
            HttpServletRequest request, HttpServletResponse response) {
        try {
            try {
                String ownerName = req.getOwnerName();
                if (!StringUtils.isEmpty(ownerName)) {
                    // ownerName =
                    // java.net.URLDecoder.decode(req.getOwnerName(), "UTF-8");
                    ownerName = new String(ownerName.getBytes("iso8859-1"),
                            "UTF-8");
                    req.setOwnerName(ownerName);
                }
                String licenseNo = req.getLicenseNo();
                if (!StringUtils.isEmpty(licenseNo)) {
                    // licenseNo =
                    // java.net.URLDecoder.decode(req.getLicenseNo(), "UTF-8");
                    licenseNo = new String(licenseNo.getBytes("iso8859-1"),
                            "UTF-8");
                    req.setLicenseNo(licenseNo);
                }
                String salesman = req.getSalesman();
                if (!StringUtils.isEmpty(salesman)) {
                    // salesman = java.net.URLDecoder.decode(req.getSalesman(),
                    // "UTF-8");
                    salesman = new String(salesman.getBytes("iso8859-1"),
                            "UTF-8");
                    req.setSalesman(salesman);
                }
                String loanProperty = req.getLoanProperty();
                if (!StringUtils.isEmpty(loanProperty)) {
                    // loanProperty =
                    // java.net.URLDecoder.decode(req.getLoanProperty(),
                    // "UTF-8");
                    loanProperty = new String(
                            loanProperty.getBytes("iso8859-1"), "UTF-8");
                    req.setLoanProperty(loanProperty);
                }
            } catch (UnsupportedEncodingException e) {

            }
            List<LoansExportDTO> exportList = installemntService
                    .queryAllLoans(req);
            response.reset();// 清空输出流
            String fileName = "放款"
                    + new SimpleDateFormat("yyyyMMdd").format(new Date())
                    + ".xls";
            String agent = request.getHeader("User-Agent");
            boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
            if (isMSIE) {// IE浏览器
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {// 其它浏览器
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setHeader("Content-disposition", "attachment; filename="
                    + fileName);
            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            ExcelHandleUtil.exportExcel("放款查询", new String[] { "订单号", "客户名称",
                    "产品", "车牌号码", "投保日期", "保费总额", "借款金额", "还款方式", "借款期限",
                    "借款性质", "保险公司", "已还期次", "已还本金", "未还本金" }, exportList,
                    response.getOutputStream(),
                    GlobalConstants.DATE_FORMAT_DATE);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("导出excel IO异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("导出excel 异常");
        }
    }

    /**
     * 
     * @Title: loadRepayment
     * @Description: 还款列表页面
     * @param @return
     * @return String
     * @author Liuya 2017年4月13日
     * @throws
     */
    @RequestMapping(value = "/loadRepayment", method = RequestMethod.GET)
    public String loadLoans() {
        return "installment/repayment/loadRepaymentManage";
    }

    /**
     * 
     * @Title: loadRepaymentReport
     * @Description: 放款日报表
     * @param @return
     * @return String
     * @author "liuya" 2017年4月24日
     * @throws
     */
    @RequestMapping(value = "/loadRepaymentReport", method = RequestMethod.GET)
    public String loadRepaymentReport() {
        return "loads/repayment/loadRepaymentReport";
    }

    @ResponseBody
    @RequestMapping(value = "/queryInstallmentDetail", method = RequestMethod.POST)
    public List<InsuranceReportDTO> queryAllInstallmentDetail(String expireTime) {
        InstallmentQueryReq req = new InstallmentQueryReq();
        req.setExpireTime(expireTime);
        List<InsuranceReportDTO> info = installemntReportService
                .queryInstallmentReportDetail(req);
        return info;
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllInstallmentReport", method = RequestMethod.POST)
    public Resp queryAllInstallmentReport(InstallmentQueryReq req) {
        RespPage<List<InsuranceReportDTO>> info = installemntReportService
                .queryAllInstallmentReport(req);

        return new Resp(info);
    }

    /**
     * 
     * @Title: queryAllLoansNew
     * @Description: 最新放款数据，列表主数据
     * @param @param req
     * @param @return
     * @return Resp
     * @author QuGuanglei 2017年4月13日
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllLoansNew", method = RequestMethod.POST)
    public Resp queryAllLoansNew(InstallmentQueryReq req) {
        RespPage<List<InsuranceDTO>> info = installemntService
                .queryAllLoansNew(req);
        return new Resp(info);
    }

    /**
     * 
     * @Title: queryAllLoansOther
     * @Description: 其他放款，列表展开数据
     * @param @param req
     * @param @return
     * @return Resp
     * @author QuGuanglei 2017年4月13日
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllLoansOther", method = RequestMethod.POST)
    public Resp queryAllLoansOther(InstallmentQueryReq req) {
        List<InsuranceDTO> info = installemntService.queryAllLoansOther(req);
        return new Resp(info);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllReportBySource", method = RequestMethod.POST)
    public Resp queryAllReportBySource(InstallmentQueryReq req) {
        RespPage<List<InsuranceReportDTO>> info = installemntReportService
                .queryAllReportBySource(req);

        return new Resp(info);
    }

    @RequestMapping(value = "/queryOverdue", method = RequestMethod.GET)
    public String queryOverdueDetail(Integer insuranceId, Model model) {
        InsuranceDTO insurance = installemntService
                .selectByPrimaryKey(insuranceId);
        model.addAttribute("insurance", insurance);
        Owner owner = installemntService.selectOwnerByPrimaryKey(insurance
                .getOwnerId());
        model.addAttribute("owner", owner);
        return "installment/repayment/insuranceDeatil";
    }

    @RequestMapping(value = "/queryRepaymentDetail", method = RequestMethod.GET)
    public String queryRepaymentDetail(Integer insuranceId, Model model) {
        InsuranceDTO insurance = installemntService
                .selectByPrimaryKey(insuranceId);
        model.addAttribute("insurance", insurance);
        Owner owner = installemntService.selectOwnerByPrimaryKey(insurance
                .getOwnerId());
        model.addAttribute("owner", owner);
        List<LoanPeriods> loanPeriods = installemntService
                .selectLoanByPrimaryKey(insuranceId);
        Double totalRepayment = 0.00;
        for (LoanPeriods loan : loanPeriods) {
            if (loan.getAmount() != null)
                totalRepayment += loan.getAmount().doubleValue();
        }
        insurance.setTotalRepayment((double) Math.round(totalRepayment));
        model.addAttribute("loanPeriods", loanPeriods);
        return "installment/repayment/repaymentDetail";
    }

    @ResponseBody
    @RequestMapping(value = "/queryReportBySourceDetail", method = RequestMethod.POST)
    public List<InsuranceReportDTO> queryReportBySourceDetail(String expireTime) {
        InstallmentQueryReq req = new InstallmentQueryReq();
        req.setExpireTime(expireTime);
        List<InsuranceReportDTO> info = installemntReportService
                .queryInstallmentReportDetail(req);
        return info;
    }

}
