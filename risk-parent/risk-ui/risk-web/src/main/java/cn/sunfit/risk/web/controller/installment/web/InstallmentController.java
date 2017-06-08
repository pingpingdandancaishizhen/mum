package cn.sunfit.risk.web.controller.installment.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import cn.sunfit.risk.buz.api.beans.installment.Car;
import cn.sunfit.risk.buz.api.beans.installment.Coverage;
import cn.sunfit.risk.buz.api.beans.installment.InstallmentExportDTO;
import cn.sunfit.risk.buz.api.beans.installment.InsuranceDTO;
import cn.sunfit.risk.buz.api.beans.installment.LoanPeriods;
import cn.sunfit.risk.buz.api.beans.installment.Owner;
import cn.sunfit.risk.buz.api.beans.installment.Receiver;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.installment.InstallemntService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.installment.InstallmentQueryReq;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.ExcelHandleUtil;

@Controller
@RequestMapping("/installment")
public class InstallmentController extends BaseController {

    @Autowired
    private InstallemntService installemntService;

    @RequestMapping(value = "/loadInstallment", method = RequestMethod.GET)
    public String datadic() {
        return "installment/integrated/loadInstallmentManage";
    }

    /**
     * 
     * @Title: exportAllLoan
     * @Description: 导出车险分期
     * @param @param req
     * @param @param response
     * @param @return
     * @return Resp
     * @author RJS 2017年3月1日
     * @throws
     */
    @RequestMapping(value = "/exportInstallment", method = RequestMethod.GET)
    public void exportInstallment(HttpServletRequest request,
            InstallmentQueryReq req, HttpServletResponse response) {
        try {
            String ownerName = new String((req.getOwnerName() == null ? ""
                    : req.getOwnerName()).getBytes("iso8859-1"), "UTF-8");
            req.setOwnerName(ownerName);
            String licenseNo = new String((req.getLicenseNo() == null ? ""
                    : req.getLicenseNo()).getBytes("iso8859-1"), "UTF-8");
            req.setLicenseNo(licenseNo);
        } catch (UnsupportedEncodingException e) {
        }
        List<InsuranceDTO> pageList = installemntService
                .queryAllInstallemntList(req).getData();
        try {
            response.reset();// 清空输出流
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
            String agent = request.getHeader("User-Agent");
            String fileName = "车险分期" + df.format(new Date()) + ".xls";
            boolean isMSIE = (agent != null && agent.indexOf("MSIE") != -1);
            if (isMSIE) {// IE浏览器
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {// 其它浏览器
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }
            response.setHeader("Content-disposition", "attachment; filename="
                    + fileName);
            List<InstallmentExportDTO> exportList = new ArrayList<InstallmentExportDTO>();
            for (InsuranceDTO insurance : pageList) {
                InstallmentExportDTO export = new InstallmentExportDTO();
                export.setInsuranceId(insurance.getInsuranceId());
                export.setOwnerName(insurance.getOwnerName());
                export.setOwnerIdNo(insurance.getOwnerIdNo());
                export.setProductName(insurance.getProductName());
                export.setCreateTime(insurance.getCreateTime());
                export.setTotalPrice(insurance.getTotalPrice() == null ? ""
                        : insurance.getTotalPrice().toString());
                export.setInsurerName(insurance.getInsurerName());
                export.setCiProposalNo(insurance.getCiProposalNo());
                export.setBiProposalNo(insurance.getBiProposalNo());
                export.setLoanAmount(insurance.getbBalance() == null ? ""
                        : insurance.getbBalance().toString());
                export.setAmount(insurance.getAmount());
                export.setLoanPeriodsNum(insurance.getLoanPeriodsNum());
                export.setPayMethod(insurance.getPayMethod());
                export.setLicenseNo(insurance.getLicenseNo());
                export.setLoanProperty(insurance.getLoanProperty());
                export.setStatus(insurance.getStatus());
                export.setOrderSource(insurance.getOrderSource());
                exportList.add(export);
            }
            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            ExcelHandleUtil.exportExcel("车险分期查询", new String[] { "订单号", "客户名称",
                    "身份证号", "产品", "投保日期", "保费总额", "保险公司", "交强险保单号", "商业险保单号",
                    "借款金额", "首付款", "借款期限", "借款还款方式", "车牌号码", "借款性质", "单据状态",
                    "订单来源", "发标平台", "标的号", "标的状态" }, exportList,
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

    @ResponseBody
    @RequestMapping(value = "/queryAllInstallment", method = RequestMethod.POST)
    public Resp queryAllInstallment(InstallmentQueryReq req) {
        RespPage<List<InsuranceDTO>> info = installemntService
                .queryAllInstallemntList(req);
        return new Resp(info);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllInstallmentDetail", method = RequestMethod.POST)
    public List<InsuranceDTO> queryAllInstallmentDetail(String insuranceId,
            String ownerId) {
        InstallmentQueryReq req = new InstallmentQueryReq();
        req.setInsuranceId(insuranceId);
        req.setOwnerId(ownerId);
        List<InsuranceDTO> info = installemntService
                .queryAllInstallmentDetail(req);
        return info;
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllInstallmentNew", method = RequestMethod.POST)
    public Resp queryAllInstallmentNew(InstallmentQueryReq req) {
        RespPage<List<InsuranceDTO>> info = installemntService
                .queryAllInstallmentNew(req);
        return new Resp(info);
    }

    @RequestMapping(value = "/queryInstallmentDeatil", method = RequestMethod.GET)
    public String queryInstallmentDeatil(Integer insuranceId, Model model) {
        InsuranceDTO insurance = installemntService
                .selectByPrimaryKey(insuranceId);
        model.addAttribute("insurance", insurance);
        Car car = installemntService
                .selectCarByPrimaryKey(insurance.getCarId());
        model.addAttribute("car", car);
        List<Coverage> coverageList = installemntService
                .selectCoverageByPrimaryKey(insurance.getInsuranceId());
        model.addAttribute("coverageList", coverageList);
        installemntService.selectLoanByPrimaryKey(insurance.getInsuranceId());
        Owner owner = installemntService.selectOwnerByPrimaryKey(insurance
                .getOwnerId());
        model.addAttribute("owner", owner);
        Receiver receiver = installemntService
                .selectReceiverByPrimaryKey(insuranceId);
        model.addAttribute("receiver", receiver);
        List<LoanPeriods> loanPeriods = installemntService
                .selectLoanByPrimaryKey(insuranceId);
        Double totalRepayment = 0.00;
        for (LoanPeriods loan : loanPeriods) {
            if (loan.getAmount() != null)
                totalRepayment += loan.getAmount().doubleValue();
        }
        insurance.setTotalRepayment((double) Math.round(totalRepayment));
        model.addAttribute("loanPeriods", loanPeriods);
        return "installment/integrated/loadInstallmentDetail";
    }

}
