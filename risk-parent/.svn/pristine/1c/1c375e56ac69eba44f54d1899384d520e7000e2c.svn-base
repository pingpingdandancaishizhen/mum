package cn.sunfit.risk.web.controller.loan;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.loan.LoanService;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanDetailQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryExportVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanSaveReq;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.ExcelHandleUtil;

@Controller
@RequestMapping(value = "/loanManager")
public class LoanManagerController extends BaseController {

    @Autowired
    LoanService loanService;

    @Autowired
    ContractPartnerService contractPartnerService;

    @Autowired
    CorpDeptService corpDeptService;

    /**
     * 
     * @Title: exportAllLoan
     * @Description: TODO
     * @param @param req
     * @param @param response
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月1日 
     * @throws
     */
    @RequestMapping(value = "/exportAllLoan", method = RequestMethod.GET)
    public void exportAllLoan(LoanQueryReq req, HttpServletResponse response) {
        List<LoanQueryExportVO> pageList = loanService.queryExportLoan(req, getCurrentUser().getDomain());
        try {
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=" + "export.xls");
            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            ExcelHandleUtil.exportExcel("放款查询", new String[] { "借款人", "手机号", "借款合同号", "合同金额", "咨询费", "管理费", "保证金",
                    "GPS安装费", "GPS服务费", "停车费", "所属门店", "还款方式", "支付方式", "放款状态", "实际放款金额", "放款时间", "放款人" }, pageList,
                    response.getOutputStream(), GlobalConstants.DATE_FORMAT_DATE);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("导出excel IO异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("导出excel 异常");
        }
    }

    @RequestMapping(value = "/loadAllLoanPage", method = RequestMethod.GET)
    public String loadAllLoanPage(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        List<CorpDept> depts = corpDeptService.queryByDeptType(user.getCorpId(), "1");
        request.setAttribute("repaymentTypes", LoanRepaymentType.values());
        request.setAttribute("depts", depts);
        return "/loanManager/loadAllLoanPage";
    }

    @RequestMapping(value = "/loadLoanPlanPage", method = RequestMethod.GET)
    public String loadLoanPlanPage(HttpServletRequest request, String bpId) {
        CorpUserDTO user = getCurrentUser();
        LoanDetailQueryResp detail = loanService.queryLoanDetail(bpId, user.getDomain());
        request.setAttribute("detail", detail);
        return "/loanManager/loanPlan";
    }

    @RequestMapping(value = "/loadLoanRecordPage", method = RequestMethod.GET)
    public String loadLoanRecordPage(HttpServletRequest request, String bpId) {
        CorpUserDTO user = getCurrentUser();
        LoanDetailQueryResp detail = loanService.queryLoanDetail(bpId, user.getDomain());
        List<PartnerSelectVO> partner = contractPartnerService.queryPartnersByBp(bpId, user.getDomain());
        request.setAttribute("partner", partner);
        request.setAttribute("bpId", bpId);
        request.setAttribute("detail", detail);
        return "/loanManager/loanPlanRecord";
    }

    @RequestMapping(value = "/loadLoanReportPage", method = RequestMethod.GET)
    public String loadLoanReportPage(HttpServletRequest request) {
        return "/loanManager/loadLoanReportPage";
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllLoan", method = RequestMethod.POST)
    public Resp queryAllLoan(LoanQueryReq req) {
        RespPage<List<LoanQueryResp>> pageList = loanService.queryLoan(req, getCurrentUser().getDomain());
        for (LoanQueryResp loan : pageList.getData()) {
            loan.setLoanCustMobile(HideInfoUtils.hidePhoneNo(loan.getLoanCustMobile()));
        }
        return new Resp(pageList);
    }

    @ResponseBody
    @RequestMapping(value = "/queryLoanReport", method = RequestMethod.POST)
    public Resp queryLoanReport(LoanReportReq req, HttpServletResponse response) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUserId(user.getId());
        RespPage<List<LoanReportDTO>> pagelist = loanService.selectLoanReport(req);
        return new Resp(pagelist);
    }

    @ResponseBody
    @RequestMapping(value = "/saveLoanRecord", method = RequestMethod.POST)
    public Resp saveLoanRecord(LoanSaveReq req, HttpServletResponse response) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUserId(user.getId());
        req.setCorpId(user.getCorpId());
        loanService.saveLoan(req);
        return new Resp();
    }

}
