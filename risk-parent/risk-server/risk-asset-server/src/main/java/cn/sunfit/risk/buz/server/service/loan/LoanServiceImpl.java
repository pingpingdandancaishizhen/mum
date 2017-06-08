package cn.sunfit.risk.buz.server.service.loan;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.activiti.engine.TaskService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.beans.loan.LoanFee;
import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentBase;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.loan.LoanService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.loan.LoanDetailQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryExportVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanSaveReq;
import cn.sunfit.risk.buz.api.vo.repayment.RepaymentRecordSaveReq;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.contract.ContractResourceDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentBaseDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentDetailDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentRecordDAO;
import cn.sunfit.risk.buz.server.dao.solution.ProductDAO;
import cn.sunfit.risk.buz.server.service.product.fee.handler.ProductFeeCalUtil;
import cn.sunfit.risk.buz.server.util.MortgageCalculatorUtil;
import cn.sunfit.risk.buz.server.util.api.jfjd.event.BpStatusChangeEvent;
import cn.sunfit.risk.buz.server.util.api.lewei.event.LoanAfterEvent;

@Service("risk.loanService")
public class LoanServiceImpl implements LoanService {
    private final static void getExtraFee(List<RepaymentDetail> repaymentDetailList, double GPSServiceFee,
            String gpsPayType, double parkFee, String parkPayType) {
        MortgageCalculatorUtil.GPSServiceFeeCalculator(repaymentDetailList, GPSServiceFee, gpsPayType);
        MortgageCalculatorUtil.ParkFeeCalculator(repaymentDetailList, parkFee, parkPayType);
    }

    @Autowired
    private BPLoanDAO bpLoanDAO;
    @Autowired
    private BPMetaDAO bpMetaDAO;
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private BPDAO bpDAO;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CorpUserDAO corpUserDAO;
    @Autowired
    private RepaymentDetailDAO repaymentDetailDAO;
    @Autowired
    private RepaymentBaseDAO repaymentBaseDAO;
    @Autowired
    private RepaymentRecordDAO repaymentRecordDAO;
    @Autowired
    private ContractResourceDAO contractResourceDAO;
    @Autowired
    private BPAttrDAO bpAttrDAO;
    @Autowired
    private ApplicationContext applicationContext;

    // @Override
    // public boolean hasLoan(LoanReq dto) {
    // long count = bpLoanDAO.countByCustomerProduct(dto);
    // return count > 0;
    // }

    @Override
    public List<LoanQueryExportVO> queryExportLoan(LoanQueryReq req, String domain) {
        return bpLoanDAO.queryExportLoan(req, domain);
    }

    @Override
    public FormQuery queryFormReqByBPId(String bpId, FormQuery req) {
        req.setBpId(bpId);
        BP bp = bpDAO.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        BPLoan loan = bpLoanDAO.selectByBp(req);
        BPMeta meta = bpMetaDAO.findById(req.getCorpId(), req.getDomain(), bp.getBpDefId());
        req.setBpDefId(bp.getBpDefId());
        req.setBpDefKey(meta.getBpDefKey());
        req.setCustomerId(loan.getCustomerId());
        req.setProductId(meta.getProductKey());
        CorpUser cu = corpUserDAO.selectByPrimaryKey(bp.getCreateUserId());
        req.setDeptId(cu.getDeptId());
        return req;
    }

    @Override
    public RespPage<List<LoanQueryResp>> queryLoan(LoanQueryReq req, String domain) {
        List<LoanQueryResp> list = bpLoanDAO.queryAllLoan(req, domain, new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<LoanQueryResp>>(list, totalCount);
    }

    @Override
    public LoanDetailQueryResp queryLoanDetail(String bpId, String domain) {
        return bpLoanDAO.queryLoanDetail(bpId, domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveLoan(LoanSaveReq req) throws ServiceException {
        LoanDetailQueryResp detail = bpLoanDAO.queryLoanDetail(req.getBpId(), req.getDomain());
        if (detail != null && StringUtils.equals(detail.getLoanStatus(), LoanStatus.DONE.getStatusName())) {
            throw new ServiceException("已放款完成,请勿重复操作");
        }
        bpLoanDAO.updateBPLoanFK(req);

        FormQuery formQuery = new FormQuery();
        formQuery.setDomain(req.getDomain());
        formQuery.setBpId(req.getBpId());
        List<BPAttr> attrs = bpAttrDAO.findByBP(formQuery);
        // 审核通过金额
        BigDecimal approvedAmount = req.getApprovedAmount();
        List<LoanFee> list = new ArrayList<LoanFee>();
        // 添加保证金并返回
        BigDecimal bzjFee = ProductFeeCalUtil.setBzjFee(list, attrs, approvedAmount);
        // 添加GPS管理费
        double GPSServiceFee = ProductFeeCalUtil.setGPSServiceFee(list, attrs);
        // 添加停车费
        double parkFee = ProductFeeCalUtil.setParkFee(list, attrs);
        LoanRepaymentType loanRepaymentType = ProductFeeCalUtil.getLoanRepaymentType(attrs);

        RepaymentBase record = new RepaymentBase();
        record.setId(IdUtil.geneId());
        record.setBpId(req.getBpId());
        record.setStatus(0);

        Date repayDay = ProductFeeCalUtil.getRepayDayCount(attrs, req.getLoanTime());

        double totalAmount = approvedAmount.add(bzjFee).doubleValue();
        List<RepaymentDetail> repaymentDetailList = new ArrayList<RepaymentDetail>();

        String backPayName = "";
        switch (loanRepaymentType) {
            case YCXHQ:
                backPayName = "一次性还款";
                BigDecimal rate = ProductFeeCalUtil.getInterestDayRate(attrs);
                int dayCount = ProductFeeCalUtil.getInterestDayCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.YCXHQCalculator(new BigDecimal(totalAmount), rate,
                        dayCount);
                MortgageCalculatorUtil.ManageFeeCalculator4YCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getDayZHFeeRate(attrs), dayCount);
                break;
            case DEBJ:
                backPayName = "等额本金";
                BigDecimal monthRate = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.DEBJCalculator(new BigDecimal(totalAmount), monthRate,
                        monthCount);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
            case DEBX:
                backPayName = "等额本息";
                BigDecimal monthRate1 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount1 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.DEBXCalculator(new BigDecimal(totalAmount), monthRate1,
                        monthCount1);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
            case DBDX:
                backPayName = "等本等息";
                BigDecimal monthRate2 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount2 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.DBDXCalculator(new BigDecimal(totalAmount), monthRate2,
                        monthCount2);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;
            case XXHB:
                backPayName = "先息后本";
                BigDecimal monthRate3 = ProductFeeCalUtil.getInterestMonthRate(attrs);
                int monthCount3 = ProductFeeCalUtil.getInterestMonthCount(attrs);
                repaymentDetailList = MortgageCalculatorUtil.XXHBCalculator(new BigDecimal(totalAmount), monthRate3,
                        monthCount3);
                MortgageCalculatorUtil.ManageFeeCalculator4NotYCX(repaymentDetailList, new BigDecimal(totalAmount),
                        ProductFeeCalUtil.getMonthZHFeeRate(attrs));
                break;

        }

        switch (loanRepaymentType) {
            case YCXHQ:
                Integer daylyTerm = new Integer(ProductFeeCalUtil.getAttr(attrs, "loanapproval_daylyTerm"));
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(repayDay);
                calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + daylyTerm));
                repaymentDetailList.get(0).setIssueDate(calendar.getTime());
                break;
            default:
                MortgageCalculatorUtil.IssueDateCalculator(repaymentDetailList, repayDay,
                        ProductFeeCalUtil.getEachTime(attrs));
                break;
        }
        Date currentTime = new Date();
        for (RepaymentDetail repaymentDetail : repaymentDetailList) {
            repaymentDetail.setId(IdUtil.geneId());
            repaymentDetail.setFinish(false);
            repaymentDetail.setOverdue(false);
            repaymentDetail.setCreateTime(currentTime);
            repaymentDetail.setCreateBy(req.getUserId());
            repaymentDetail.setBpNo(req.getBpId());
        }

        String gpsPayType = ProductFeeCalUtil.getAttr(attrs, "loanofee_gpsservice_pay");
        String parkPayType = ProductFeeCalUtil.getAttr(attrs, "loanofee_park_pay");
        getExtraFee(repaymentDetailList, GPSServiceFee, gpsPayType, parkFee, parkPayType);
        if (!ProductFeeCalUtil.isFirstPay(attrs)) {
            record.setPayedInterest(BigDecimal.ZERO);
            record.setPayedPrinciple(BigDecimal.ZERO);
            record.setPayedIssue(0);
        } else {
            // 期初结算
            // 期初结算还款基础表设置
            record.setPayedInterest(new BigDecimal(repaymentDetailList.get(0).getInterest()));
            record.setPayedPrinciple(new BigDecimal(repaymentDetailList.get(0).getPrinciple()));
            record.setPayedIssue(1);
            // 期初结算还款明细表首记录设置
            repaymentDetailList.get(0).setPayedInterest(repaymentDetailList.get(0).getInterest());
            repaymentDetailList.get(0).setPayedPrinciple(repaymentDetailList.get(0).getPrinciple());
            repaymentDetailList.get(0).setPayedManageFee(repaymentDetailList.get(0).getManageFee());
            repaymentDetailList.get(0).setPayedExtraFee(GPSServiceFee);
            repaymentDetailList.get(0).setPayedExtraFee2(parkFee);
            repaymentDetailList.get(0).setFinish(true);
            // 期初结算还款记录表插入一条还款记录
            RepaymentRecordSaveReq repaymentRecord = new RepaymentRecordSaveReq();
            repaymentRecord.setUserId(req.getUserId());
            repaymentRecord.setDomain(req.getDomain());
            repaymentRecord.setRepaymentDetailId(repaymentDetailList.get(0).getId());
            repaymentRecord.setRepaymentInterest(new BigDecimal(repaymentDetailList.get(0).getPayedInterest()));
            repaymentRecord.setRepaymentPrinciple(new BigDecimal(repaymentDetailList.get(0).getPayedPrinciple()));
            repaymentRecord.setRepaymentManageFee(new BigDecimal(repaymentDetailList.get(0).getPayedManageFee()));
            repaymentRecord.setRepaymentExtraFee(new BigDecimal(GPSServiceFee));
            repaymentRecord.setRepaymentExtraFee2(new BigDecimal(parkFee));
            repaymentRecord.setRepaymentTime(new Date());
            repaymentRecord.setId(IdUtil.generateHKRecordNo());
            repaymentRecord.setCreateTime(new Date());
            repaymentRecordDAO.insert(repaymentRecord);
        }

        repaymentBaseDAO.insert(record, req.getDomain());
        repaymentDetailDAO.addRepaymentDetail(repaymentDetailList, req.getDomain());
        contractResourceDAO.signContract(req.getBpId(), req.getDomain());
        BP bp = new BP();
        bp.setDomain(req.getDomain());
        bp.setUpdateTime(currentTime);
        bp.setBpStatus(BpStatus.LOAN_AFTER.getStatus());
        bp.setBpId(req.getBpId());
        bpDAO.updateFinishBPstatus(bp);

        // 通知疾风交单修改状态
        BP bpTemp = bpDAO.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        applicationContext.publishEvent(new BpStatusChangeEvent(this, req.getDomain(), "1", bpTemp.getChannel(), req
                .getBpId(), bp.getCurrentTaskName(), "", (int) bp.getBpStatus(), record.getStatus(), ""));

        String taskName = bpTemp.getCurrentTaskName();

        long day = (repaymentDetailList.get(repaymentDetailList.size() - 1).getIssueDate().getTime() - repayDay
                .getTime()) / 3600000 / 24;
        applicationContext.publishEvent(new LoanAfterEvent(this, req.getBpId(), req.getDomain(), bpTemp
                .getProductType(), null, backPayName, null, null,
        // 借款期限
                day + "",
                // 放款金额
                approvedAmount.add(bzjFee).toString(),
                // 放款时间
                new SimpleDateFormat("yyyy-MM-dd").format(req.getLoanTime()),
                // 接款单号
                bpTemp.getBpNo(),
                // 0：还款中
                "0",
                // 逾期天数
                "0",
                // 剩余本金
                approvedAmount.add(bzjFee).subtract(record.getPayedPrinciple()).toString(),
                // 订单状态
                BpStatus.getLabelByStatus(bp.getBpStatus()),
                // 剩余期次 最后一期期数 - 已付期数
                repaymentDetailList.get(repaymentDetailList.size() - 1).getIssue() - record.getPayedIssue(),
                // 结清时间 null
                null));
    }

    @Override
    public RespPage<List<LoanReportDTO>> selectLoanReport(LoanReportReq req) {
        List<LoanReportDTO> list = bpLoanDAO.selectLoanReport(req, new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<LoanReportDTO>>(list, totalCount);
    }
}
