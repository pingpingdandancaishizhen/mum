package cn.sunfit.risk.web.controller.repayment;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentSettlement;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFBpService;
import cn.sunfit.risk.buz.api.service.api.lewei.LWBpService;
import cn.sunfit.risk.buz.api.service.loan.LoanService;
import cn.sunfit.risk.buz.api.service.repayment.RepaymentDetailService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanDetailQueryResp;
import cn.sunfit.risk.buz.api.vo.repayment.OverdueQueryResp;
import cn.sunfit.risk.buz.api.vo.repayment.OverdueQueryVO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentQueryReq;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentQueryResp;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentQueryVO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentRecordDTO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentRecordSaveReq;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentReportDTO;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentReportReq;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentSettlementSaveReq;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.ExcelHandleUtil;

@Controller
@RequestMapping("/repayment")
public class RepaymentManagerController extends BaseController {

    @Autowired
    private RepaymentDetailService repaymentDetailService;

    @Autowired
    LoanService loanService;

    @Autowired
    JFBpService jFBpService;

    @Autowired
    LWBpService lWBpService;

    @ResponseBody
    @RequestMapping(value = "/checkEarlyRecord", method = RequestMethod.GET)
    public Resp checkEarlyRecord(String bpId) {
        CorpUserDTO user = getCurrentUser();
        List<RepaymentRecordDTO> list = repaymentDetailService.queryRepaymentRecordList(bpId, user.getDomain(),
                user.getCorpId());
        boolean flag = repaymentDetailService.checkEarlyRecord(list);
        return flag ? new Resp() : Resp.buildErrorResponse("至少还款一期开始提前结清");
    }

    @RequestMapping(value = "/exportAllOverdue", method = RequestMethod.GET)
    public void exportAllOverdue(RepaymentQueryReq req, HttpServletResponse response) {
        List<OverdueQueryVO> pageList = repaymentDetailService
                .queryOverdueExportList(req, getCurrentUser().getDomain());
        try {
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=" + "export.xls");
            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            ExcelHandleUtil.exportExcel("逾期还款查询", new String[] { "借款人", "借款合同号", "所属部门", "还款方式", "产品", "借款期限", "合同金额",
                    "剩余本金", "已还期次", "逾期天数", "逾期账龄", "罚息率(滞纳金率)", "逾期罚息(滞纳金)", "罚息减免金额", "还款日", "状态" }, pageList,
                    response.getOutputStream(), GlobalConstants.DATE_FORMAT_DATE);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("导出excel IO异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("导出excel 异常");
        }
    }

    @RequestMapping(value = "/exportAllRepayment", method = RequestMethod.GET)
    public void exportAllRepayment(RepaymentQueryReq req, HttpServletResponse response) {
        List<RepaymentQueryVO> pageList = repaymentDetailService.queryRepaymentExportList(req, getCurrentUser()
                .getDomain());
        try {
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=" + "export.xls");
            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            ExcelHandleUtil.exportExcel("还款查询", new String[] { "借款人", "借款合同号", "所属部门", "还款方式", "合同金额", "保证金", "还款期次",
                    "已还利息", "已还本金", "未还本金", "还款日", "逾期天数", "还款状态" }, pageList, response.getOutputStream(),
                    GlobalConstants.DATE_FORMAT_DATE);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("导出excel IO异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("导出excel 异常");
        }
    }

    @RequestMapping(value = "/loadEarlyRecordPage", method = RequestMethod.GET)
    public String loadEarlyRecordPage(HttpServletRequest request, String bpId) {
        CorpUserDTO user = getCurrentUser();
        List<RepaymentRecordDTO> list = repaymentDetailService.queryRepaymentRecordList(bpId, user.getDomain(),
                user.getCorpId());
        Map<String, BigDecimal> rate = repaymentDetailService.getRepaymentFeeRate(user.getCorpId(), user.getDomain(),
                bpId);
        RepaymentSettlement settlement = repaymentDetailService.getSettlementInfo(list, rate);
        settlement.setBpId(bpId);
        Map<String, String> attr = repaymentDetailService.getRepaymentAttr(user.getCorpId(), user.getDomain(), bpId);
        LoanDetailQueryResp detail = loanService.queryLoanDetail(bpId, user.getDomain());
        attr.put("contractId", detail.getLoanContractId());
        attr.put("amount", detail.getApprovedAmount().add(detail.getLoanGuaranteeFee()).toString());
        if (list.size() > 0) {
            attr.put("issueCount", list.get(list.size() - 1).getIssue().toString());
        }
        request.setAttribute("bpId", bpId);
        request.setAttribute("attr", attr);
        request.setAttribute("rate", rate);
        request.setAttribute("settlement", settlement);
        request.setAttribute("requestDetails", list);
        return "/repayment/earlyRecord";
    }

    @RequestMapping(value = "/loadRepaymentReportPage", method = RequestMethod.GET)
    public String loadLoanReportPage(HttpServletRequest request) {
        return "/repayment/loadRepaymentReportPage";
    }

    @RequestMapping(value = "/loadOverdueManagePage", method = RequestMethod.GET)
    public String loadOverdueManagePage(HttpServletRequest request) {
        request.setAttribute("repaymentTypes", LoanRepaymentType.values());
        return "/repayment/overdueManage";
    }

    @RequestMapping(value = "/loadOverdueRecordPage", method = RequestMethod.GET)
    public String loadOverdueRecordPage(HttpServletRequest request, String bpId) {
        CorpUserDTO user = getCurrentUser();
        List<RepaymentRecordDTO> list = repaymentDetailService.queryRepaymentRecordList(bpId, user.getDomain(),
                user.getCorpId());
        Map<String, BigDecimal> rate = repaymentDetailService.getRepaymentFeeRate(user.getCorpId(), user.getDomain(),
                bpId);
        Map<String, String> attr = repaymentDetailService.getRepaymentAttr(user.getCorpId(), user.getDomain(), bpId);
        LoanDetailQueryResp detail = loanService.queryLoanDetail(bpId, user.getDomain());
        attr.put("contractId", detail.getLoanContractId());
        attr.put("amount", detail.getApprovedAmount().add(detail.getLoanGuaranteeFee()).toString());
        if (list.size() > 0) {
            attr.put("issueCount", list.get(list.size() - 1).getIssue().toString());
        }
        request.setAttribute("attr", attr);
        request.setAttribute("rate", rate);
        request.setAttribute("bpId", bpId);
        request.setAttribute("defaultDate", new Date());
        request.setAttribute("requestDetails", list);
        return "/repayment/overdueRecord";
    }

    @RequestMapping(value = "/loadRepaymentPage", method = RequestMethod.GET)
    public String loadRepaymentPage(HttpServletRequest request) {
        request.setAttribute("repaymentTypes", LoanRepaymentType.values());
        request.setAttribute("status", RepaymentBaseStatus.values());
        return "/repayment/repaymentManage";
    }

    @RequestMapping(value = "/loadRepaymentPlanPage", method = RequestMethod.GET)
    public String loadRepaymentPlanPage(HttpServletRequest request, String bpId) {
        CorpUserDTO user = getCurrentUser();
        List<RepaymentDetail> list = repaymentDetailService
                .queryRepaymentDetailList(bpId, getCurrentUser().getDomain());
        Map<String, String> attr = repaymentDetailService.getRepaymentAttr(user.getCorpId(), user.getDomain(), bpId);
        LoanDetailQueryResp detail = loanService.queryLoanDetail(bpId, user.getDomain());
        attr.put("contractId", detail.getLoanContractId());
        attr.put("amount", detail.getApprovedAmount().add(detail.getLoanGuaranteeFee()).toString());
        if (list.size() > 0) {
            attr.put("issueCount", list.get(list.size() - 1).getIssue().toString());
        }
        request.setAttribute("bpId", bpId);
        request.setAttribute("attr", attr);
        request.setAttribute("requestDetails", list);
        return "/repayment/repaymentPlan";
    }

    @RequestMapping(value = "/loadRepaymentRecordPage", method = RequestMethod.GET)
    public String loadRepaymentRecordPage(HttpServletRequest request, String bpId) {
        CorpUserDTO user = getCurrentUser();
        List<RepaymentRecordDTO> list = repaymentDetailService.queryRepaymentRecordList(bpId, user.getDomain(),
                user.getCorpId());
        Map<String, String> attr = repaymentDetailService.getRepaymentAttr(user.getCorpId(), user.getDomain(), bpId);
        LoanDetailQueryResp detail = loanService.queryLoanDetail(bpId, user.getDomain());
        attr.put("contractId", detail.getLoanContractId());
        attr.put("amount", detail.getApprovedAmount().add(detail.getLoanGuaranteeFee()).toString());
        if (list.size() > 0) {
            attr.put("issueCount", list.get(list.size() - 1).getIssue().toString());
        }
        request.setAttribute("bpId", bpId);
        request.setAttribute("attr", attr);
        request.setAttribute("requestDetails", list);
        return "/repayment/repaymentRecord";
    }

    @ResponseBody
    @RequestMapping(value = "/queryOverdueList", method = RequestMethod.POST)
    public Resp queryOverdueList(RepaymentQueryReq req) {
        RespPage<List<OverdueQueryResp>> result = repaymentDetailService.queryOverdueList(req, getCurrentUser()
                .getDomain());
        return new Resp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/queryRepaymentList", method = RequestMethod.POST)
    public Resp queryRepaymentList(RepaymentQueryReq req) {
        RespPage<List<RepaymentQueryResp>> result = repaymentDetailService.queryRepaymentList(req, getCurrentUser()
                .getDomain());
        return new Resp(result);
    }

    @ResponseBody
    @RequestMapping(value = "/queryRepaymentReport", method = RequestMethod.POST)
    public Resp queryRepaymentReport(RepaymentReportReq req, HttpServletResponse response) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUserId(user.getId());
        RespPage<List<RepaymentReportDTO>> pagelist = repaymentDetailService.selectRepaymentReport(req);
        return new Resp(pagelist);
    }

    @ResponseBody
    @RequestMapping(value = "/saveRepaymentRecord", method = RequestMethod.POST)
    public Resp saveRepaymentRecord(RepaymentRecordSaveReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUserId(user.getId());
        req.setCorpId(user.getCorpId());
        repaymentDetailService.saveRepaymentRecord(req);

        jFBpService.sendNoticeToJF(user.getCorpId(), user.getDomain(), req.getBpId());
        lWBpService.sendNoticeToLW(user.getCorpId(), user.getDomain(), req.getBpId(), req.getRepaymentDetailId(),
                req.getOverdueCount());
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/saveSettlementRecord", method = RequestMethod.POST)
    public Resp saveSettlementRecord(RepaymentSettlementSaveReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setCreateBy(user.getId());
        req.setCreateTime(new Date());
        repaymentDetailService.saveSettlementRecord(req);
        jFBpService.sendNoticeToJF(user.getCorpId(), user.getDomain(), req.getBpId());
        lWBpService.sendNoticeToLW4Settlement(user.getCorpId(), user.getDomain(), req.getBpId());
        return new Resp();
    }

}
