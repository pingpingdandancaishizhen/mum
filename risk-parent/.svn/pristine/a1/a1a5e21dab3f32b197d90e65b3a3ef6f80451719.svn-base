package cn.sunfit.risk.buz.server.service.api.lewei;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentBase;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentSettlement;
import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;
import cn.sunfit.risk.buz.api.service.api.lewei.LWBpService;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentBaseDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentDetailDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentSettlementDAO;
import cn.sunfit.risk.buz.server.util.api.lewei.event.LoanAfterEvent;

@Service("lewei.bpService")
public class LWBpServiceImpl implements LWBpService {

    @Autowired
    RepaymentBaseDAO repaymentBaseDAO;
    @Autowired
    RepaymentDetailDAO repaymentDetailDAO;
    @Autowired
    RepaymentSettlementDAO repaymentSettlementDAO;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BPDAO bpdao;
    @Autowired
    private BPAttrDAO bpAttrDAO;
    @Autowired
    private BPLoanDAO bpLoanDAO;

    @Override
    @Async
    public void sendNoticeToLW(String corpId, String domain, String bpId, String repaymentDetailId, Integer overDay) {
        // FormQuery formQuery = new FormQuery();
        // formQuery.setDomain(domain);
        // formQuery.setBpId(bpId);
        // List<BPAttr> attrs = bpAttrDAO.findByBP(formQuery);
        BP bp = bpdao.findById(corpId, domain, bpId);
        RepaymentBase base = repaymentBaseDAO.selectByPrimaryKey(domain, bpId);
        // LoanDetailQueryResp loanDetail = bpLoanDAO.queryLoanDetail(bpId, domain);
        RepaymentDetail repaymentDetail = repaymentDetailDAO.queryRepaymentDetailInfo(repaymentDetailId, domain);
        BigDecimal residualPrincipal = new BigDecimal(repaymentDetail.getLeftPrinciple())
                .add(new BigDecimal(repaymentDetail.getPrinciple()))
                .subtract(new BigDecimal(repaymentDetail.getPayedPrinciple())).setScale(2, BigDecimal.ROUND_HALF_UP);

        List<RepaymentDetail> detailList = repaymentDetailDAO.queryRepaymentDetailList(bpId, domain);
        if (residualPrincipal.compareTo(BigDecimal.ZERO) < 0) {
            residualPrincipal = BigDecimal.ZERO;
        }
        // String backPayName = "";
        Date settleTime = null;
        Integer residualPeriod = 0;
        if (repaymentDetail.isFinish()) {
            residualPeriod = detailList.size() - repaymentDetail.getIssue();
        } else {
            residualPeriod = detailList.size() - repaymentDetail.getIssue() + 1;
        }
        if (repaymentDetail.isFinish() && repaymentDetail.getIssue() == detailList.size()) {
            settleTime = repaymentDetail.getUpdateTime();
        }
        String backStatus = "";
        RepaymentBaseStatus baseStatus = RepaymentBaseStatus.getNameByStatus(base.getStatus());
        switch (baseStatus) {
            case REPAYMENT:
                backStatus = "0";
                break;
            case OVERDUE:
                backStatus = "0";
                break;
            case FINISH:
                backStatus = "1";
                break;
            case EARLY:
                backStatus = "1";
                break;
        }
        // Integer status = repaymentBaseDAO.selectStatusByBp(new JFBpStatusGetReq(bpId, domain));

        applicationContext.publishEvent(new LoanAfterEvent(this, bpId, domain, bp.getProductType(), null, null, null,
                null, null, null, null, bp.getBpNo(), backStatus, (overDay == null ? "0" : overDay + ""),
                residualPrincipal.toString(), BpStatus.getLabelByStatus(bp.getBpStatus()), residualPeriod,
                settleTime == null ? null : new SimpleDateFormat("yyyy-MM-dd").format(settleTime)));
    }

    @Override
    @Async
    public void sendNoticeToLW4Settlement(String corpId, String domain, String bpId) {
        BP bp = bpdao.findById(corpId, domain, bpId);
        RepaymentBase base = repaymentBaseDAO.selectByPrimaryKey(domain, bpId);
        // LoanDetailQueryResp loanDetail = bpLoanDAO.queryLoanDetail(bpId, domain);
        // RepaymentDetail repaymentDetail = repaymentDetailDAO.queryRepaymentDetailInfo(repaymentDetailId, domain);
        RepaymentSettlement repaymentSettlement = repaymentSettlementDAO.queryByPrimaryKey(bpId, domain);
        // List<RepaymentDetail> detailList = repaymentDetailDAO.queryRepaymentDetailList(bpId, domain);
        // String backPayName = "";
        Date settleTime = repaymentSettlement.getCreateTime();
        String backStatus = "";
        RepaymentBaseStatus baseStatus = RepaymentBaseStatus.getNameByStatus(base.getStatus());
        switch (baseStatus) {
            case REPAYMENT:
                backStatus = "0";
                break;
            case OVERDUE:
                backStatus = "0";
                break;
            case FINISH:
                backStatus = "1";
                break;
            case EARLY:
                backStatus = "1";
                break;
        }
        // Integer status = repaymentBaseDAO.selectStatusByBp(new JFBpStatusGetReq(bpId, domain));

        applicationContext.publishEvent(new LoanAfterEvent(this, bpId, domain, bp.getProductType(), null, null, null,
                null, null, null, null, bp.getBpNo(), backStatus, "0", "0",
                BpStatus.getLabelByStatus(bp.getBpStatus()), 0, settleTime == null ? null : new SimpleDateFormat(
                        "yyyy-MM-dd").format(settleTime)));
    }
}
