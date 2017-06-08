package cn.sunfit.risk.buz.server.service.repayment;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import orj.worf.util.JsonUtils;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentBase;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentRecord;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentSettlement;
import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.repayment.RepaymentDetailService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
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
import cn.sunfit.risk.buz.api.vo.solution.dyc.DycFeeConfig;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentBaseDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentDetailDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentRecordDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentSettlementDAO;
import cn.sunfit.risk.buz.server.service.product.fee.ProductFeeFactory;

@Service("risk.repaymentDetailService")
public class RepaymentDetailServiceImpl implements RepaymentDetailService {

    @Autowired
    private ProductFeeFactory productFeeFactory;

    @Autowired
    RepaymentDetailDAO repaymentDetailDAO;

    @Autowired
    RepaymentRecordDAO repaymentRecordDAO;

    @Autowired
    RepaymentSettlementDAO repaymentSettlementDAO;

    @Autowired
    RepaymentBaseDAO repaymentBaseDAO;

    @Autowired
    BPDAO bpDAO;

    @Override
    public boolean checkEarlyRecord(List<RepaymentRecordDTO> list) {
        Date lastPayedIsuueDate = null;
        for (RepaymentRecordDTO repaymentRecordDTO : list) {
            // 如果未结束获得 管理费 并求和 计算剩余管理费
            if (repaymentRecordDTO.isFinish()) {
                lastPayedIsuueDate = repaymentRecordDTO.getIssueDate();
            }
        }
        return lastPayedIsuueDate != null;
    }

    // 设置还款记录(是否逾期 )
    private void checkRepaymentRecordOverdue(RepaymentQueryResp resp) {
        List<RepaymentRecordDTO> details = resp.getDetails();
        pickOutCurrentRepaymentRecord(details);
    }

    @Override
    public Map<String, String> getRepaymentAttr(String corpId, String domain, String bpId) throws ServiceException {
        BP bp = bpDAO.findById(corpId, domain, bpId);
        return productFeeFactory.getHandler(bp.getProductType()).getRepaymentAttr(domain, bpId);
    }

    @Override
    public Map<String, BigDecimal> getRepaymentFeeRate(String corpId, String domain, String bpId)
            throws ServiceException {
        BP bp = bpDAO.findById(corpId, domain, bpId);
        return productFeeFactory.getHandler(bp.getProductType()).getRepaymentFeeRate(domain, bpId);
    }

    @Override
    public RepaymentSettlement getSettlementInfo(List<RepaymentRecordDTO> list, Map<String, BigDecimal> rate)
            throws ServiceException {
        RepaymentSettlement settlement = new RepaymentSettlement();
        BigDecimal leftManageFee = BigDecimal.ZERO;
        BigDecimal leftPrinciple = BigDecimal.ZERO;
        Date lastPayedIsuueDate = null;
        for (RepaymentRecordDTO repaymentRecordDTO : list) {
            // 如果未结束获得 管理费 并求和 计算剩余管理费
            if (!repaymentRecordDTO.isFinish()) {
                leftManageFee = leftManageFee.add(new BigDecimal(repaymentRecordDTO.getLeftManageFee()));
            }
            if (repaymentRecordDTO.isFinish()) {
                lastPayedIsuueDate = repaymentRecordDTO.getIssueDate();
            }
            // 如果是当期 获取剩余本金
            if (repaymentRecordDTO.isCurrent()) {
                leftPrinciple = new BigDecimal(repaymentRecordDTO.getLeftPrinciple());
                settlement.setSettlementPrinciple(leftPrinciple);
            }
        }
        settlement.setSettlementManageFee(leftManageFee);
        // 默认提前还款日为当天
        Date curDate = new Date();
        settlement.setSettlementDate(curDate);
        // 计算剩余利息 = 剩余本金 * 日息(月息/30) * 当期已过天数(实际提前结清日 - 上期还款日)
        // 计算当期已过天数(实际提前结清日 - 上期还款日)
        if (lastPayedIsuueDate == null) {
            throw new ServiceException("至少还款一期开始提前结清");
        }
        long dayCount = (curDate.getTime() - lastPayedIsuueDate.getTime()) / 24 / 3600 / 1000;
        dayCount = dayCount > 0 ? dayCount : 0;
        Date lastDay = list.get(list.size() - 1).getIssueDate();
        settlement.setSettlementCount(new Long((lastDay.getTime() - curDate.getTime()) / 24 / 3600 / 1000).intValue());
        settlement.setSettlementInterest(leftPrinciple
                .multiply(rate.get("monthlyRate").divide(new BigDecimal(3000), 6, BigDecimal.ROUND_HALF_UP))
                .multiply(new BigDecimal(dayCount)).setScale(2, BigDecimal.ROUND_HALF_UP));
        // 计算合同金额 * 违约费率 = 违约金
        BigDecimal htje = new BigDecimal(list.get(0).getPrinciple())
                .add(new BigDecimal(list.get(0).getLeftPrinciple()));
        settlement.setSettlementPenalty(htje.multiply(rate.get("wyFee").divide(new BigDecimal(100))).setScale(2,
                BigDecimal.ROUND_HALF_UP));
        return settlement;
    }

    // 设置当期还款(未逾期中 第一笔为还清记录)
    private void pickOutCurrentRepaymentRecord(List<RepaymentRecordDTO> list) {
        if (list != null) {
            for (RepaymentRecordDTO repaymentRecordDTO : list) {
                if (!repaymentRecordDTO.isOverdue() && !repaymentRecordDTO.isFinish()) {
                    repaymentRecordDTO.setCurrent(true);
                    break;
                }
            }
        }
    }

    @Override
    public List<OverdueQueryVO> queryOverdueExportList(RepaymentQueryReq req, String domain) {
        List<OverdueQueryVO> list = repaymentDetailDAO.queryOverdueExportList(req, domain);
        for (OverdueQueryVO overdueQueryVO : list) {
            overdueQueryVO.setStatus(RepaymentBaseStatus.OVERDUE.getStatus());
        }
        return list;
    }

    @Override
    public RespPage<List<OverdueQueryResp>> queryOverdueList(RepaymentQueryReq req, String domain) {
        List<OverdueQueryResp> list = repaymentDetailDAO.queryOverdueList(req, domain, new RowBounds(req.getOffset(),
                req.getLimit()));
        for (OverdueQueryResp overdueQueryVO : list) {
            overdueQueryVO.setStatus(RepaymentBaseStatus.OVERDUE.getStatus());
        }
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<OverdueQueryResp>>(list, totalCount);
    }

    @Override
    public List<RepaymentDetail> queryRepaymentDetailList(String bpId, String domain) {
        return repaymentDetailDAO.queryRepaymentDetailList(bpId, domain);
    }

    @Override
    public List<RepaymentQueryVO> queryRepaymentExportList(RepaymentQueryReq req, String domain)
            throws ServiceException {
        List<RepaymentQueryVO> list = repaymentDetailDAO.queryRepaymentExportList(req, domain);
        for (RepaymentQueryVO repaymentQueryResp : list) {
            if (repaymentQueryResp.getOverdue()) {
                repaymentQueryResp.setStatus(RepaymentBaseStatus.OVERDUE.getStatus());
            }
        }
        return list;
    }

    @Override
    public RespPage<List<RepaymentQueryResp>> queryRepaymentList(RepaymentQueryReq req, String domain)
            throws ServiceException {
        List<RepaymentQueryResp> list = repaymentDetailDAO.queryRepaymentList(req, domain,
                new RowBounds(req.getOffset(), req.getLimit()));
        for (RepaymentQueryResp repaymentQueryResp : list) {
            checkRepaymentRecordOverdue(repaymentQueryResp);
            if (repaymentQueryResp.isOverdue()) {
                repaymentQueryResp.setStatus(RepaymentBaseStatus.OVERDUE.getStatus());
            }
        }
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<RepaymentQueryResp>>(list, totalCount);
    }

    @Override
    public List<RepaymentRecordDTO> queryRepaymentRecordList(String bpId, String domain, String corpId)
            throws ServiceException {
        List<RepaymentRecordDTO> list = repaymentDetailDAO.queryRepaymentRecordList(bpId, domain);
        pickOutCurrentRepaymentRecord(list);
        setOverdueFee4RepaymentRecord(list, bpId, domain, corpId);
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRepaymentRecord(RepaymentRecordSaveReq req) throws ServiceException {
        req.setId(IdUtil.generateHKRecordNo());
        req.setCreateTime(new Date());
        RepaymentDetail r = repaymentDetailDAO.queryRepaymentDetailInfo(req.getRepaymentDetailId(), req.getDomain());
        if (r != null && r.isFinish()) {
            throw new ServiceException("当期还款已完成,请勿多次还款");
        }
        RepaymentDetail detail = new RepaymentDetail();
        detail.setId(req.getRepaymentDetailId());
        detail.setPayedExtraFee(req.getRepaymentExtraFee().doubleValue());
        detail.setPayedExtraFee2(req.getRepaymentExtraFee2().doubleValue());
        detail.setPayedPrinciple(req.getRepaymentPrinciple().doubleValue());
        detail.setPayedInterest(req.getRepaymentInterest().doubleValue());
        detail.setPayedManageFee(req.getRepaymentManageFee().doubleValue());
        detail.setUpdateBy(req.getUserId());
        detail.setUpdateTime(new Date());
        // 修改还款明细表 已还各项金额
        BigDecimal znjFee = null;
        // 如果有逾期数据 查询逾期滞纳金费率
        if (req.getOverdueCount() != null && req.getOverdueFee() != null && req.getOverdueDerate() != null) {
            BP bp = bpDAO.findById(req.getCorpId(), req.getDomain(), req.getBpId());
            znjFee = productFeeFactory.getHandler(bp.getProductType())
                    .getRepaymentFeeRate(req.getDomain(), req.getBpId()).get("znjFee");
            // 逾期还款 判断 逾期滞纳金是否还清
            String feeConfig = bpDAO.selectFeeConfigByBpId(req.getBpId(), req.getDomain());
            DycFeeConfig config = JsonUtils.parseJSON(feeConfig, DycFeeConfig.class);

            repaymentDetailDAO.updateRepaymentFee(detail, req.getDomain(), znjFee, req.getOverdueCount(), req
                    .getOverdueFee().add(req.getOverdueDerate()), config.getZnjFeeCal());
        } else {
            // 正常还款 无需 判断 逾期滞纳金是否还清
            repaymentDetailDAO.updateRepaymentFee(detail, req.getDomain(), null, null, null, null);
        }
        // 插入 还款记录表
        repaymentRecordDAO.insert(req);
        // 修改还款基础表 总共归还各项金额
        RepaymentBase base = new RepaymentBase();
        base.setBpId(req.getBpId());
        base.setPayedInterest(req.getRepaymentInterest());
        base.setPayedPrinciple(req.getRepaymentPrinciple());
        repaymentBaseDAO.updateRepaymentFee(base, req.getDomain());
        BP bp = new BP();
        bp.setDomain(req.getDomain());
        bp.setUpdateTime(new Date());
        bp.setBpId(req.getBpId());
        bp.setBpStatus(BpStatus.LOAN_FINISH.getStatus());
        bpDAO.updateFinishBPstatus4Repayment(bp);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSettlementRecord(RepaymentSettlementSaveReq req) throws ServiceException {
        RepaymentBase r = repaymentBaseDAO.selectByPrimaryKey(req.getDomain(), req.getBpId());
        if (r != null && RepaymentBaseStatus.EARLY.getStatus().equals(r.getStatus())) {
            throw new ServiceException("该笔还款已提前结清,请勿重复操作");
        }
        req.setId(IdUtil.generateHKRecordNo());
        repaymentSettlementDAO.insert(req);
        RepaymentBase base = new RepaymentBase();
        base.setBpId(req.getBpId());
        base.setPayedInterest(req.getSettlementInterest());
        base.setPayedPrinciple(req.getSettlementPrinciple());
        repaymentBaseDAO.updateRepaymentFee4Settlement(base, req.getDomain());
        BP bp = new BP();
        bp.setDomain(req.getDomain());
        bp.setUpdateTime(new Date());
        bp.setBpId(req.getBpId());
        bp.setBpStatus(BpStatus.LOAN_FINISH.getStatus());
        bpDAO.updateFinishBPstatus(bp);
    }

    @Override
    public RespPage<List<RepaymentReportDTO>> selectRepaymentReport(RepaymentReportReq req) {
        List<RepaymentReportDTO> pagelist = repaymentBaseDAO.selectRepaymentReport(req, new RowBounds(req.getOffset(),
                req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<RepaymentReportDTO>>(pagelist, totalCount);
    }

    // 设置当期还款(未逾期中 第一笔为还清记录)
    private void setOverdueFee4RepaymentRecord(List<RepaymentRecordDTO> list, String bpId, String domain, String corpId) {
        BP bp = bpDAO.findById(corpId, domain, bpId);
        Map<String, BigDecimal> feeMap = productFeeFactory.getHandler(bp.getProductType()).getRepaymentFeeRate(domain,
                bpId);
        // 逾期控制标识 ，控制逾期只能一期一期还款 ，匹配首条逾期记录之后变更为FALSE
        boolean flag = true;
        // 获得滞纳金率
        BigDecimal znjFee = feeMap.get("znjFee") == null ? BigDecimal.ZERO : feeMap.get("znjFee");
        String feeConfig = bpDAO.selectFeeConfigByBpId(bpId, domain);
        DycFeeConfig config = JsonUtils.parseJSON(feeConfig, DycFeeConfig.class);
        if (list != null) {
            for (RepaymentRecordDTO repaymentRecordDTO : list) {
                if (flag) {
                    if (repaymentRecordDTO.isOverdue() && repaymentRecordDTO.getOverdueDay() != null) {
                        flag = false;
                        BigDecimal overDueFee = BigDecimal.ZERO;
                        // 判断产品配置 滞纳金计算方式
                        if (StringUtils.equals(config.getZnjFeeCal(), "1")) {
                            // 获得滞纳金 = (当期剩余本金 - 当期逾期之前已还本金 （数据库已计算）) * 滞纳金率(百分比数) * 逾期天数 / 100 (换算百分比)
                            overDueFee = new BigDecimal(repaymentRecordDTO.getLeftPrinciple()).multiply(znjFee)
                                    .multiply(new BigDecimal(repaymentRecordDTO.getOverdueDay()))
                                    .divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                        } else {
                            // 获得滞纳金 = (合同金额(首期应付本金+首期剩余本金)) * 滞纳金率(百分比数) * 逾期天数 / 100 (换算百分比)
                            overDueFee = (new BigDecimal(list.get(0).getLeftPrinciple()).add(new BigDecimal(list.get(0)
                                    .getPrinciple()))).multiply(znjFee)
                                    .multiply(new BigDecimal(repaymentRecordDTO.getOverdueDay()))
                                    .divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                        }
                        List<RepaymentRecord> records = repaymentRecordDTO.getRecords();
                        // 应付滞纳金 -（当期已还滞纳金 + 当期已录入罚息减免）
                        for (RepaymentRecord repaymentRecord : records) {
                            BigDecimal overdueFee = repaymentRecord.getOverdueFee() == null ? BigDecimal.ZERO
                                    : repaymentRecord.getOverdueFee();
                            BigDecimal overdueDerate = repaymentRecord.getOverdueDerate() == null ? BigDecimal.ZERO
                                    : repaymentRecord.getOverdueDerate();
                            overDueFee = overDueFee.subtract(overdueFee).subtract(overdueDerate);
                        }
                        repaymentRecordDTO.setOverdueFee(overDueFee);
                    }
                } else {
                    repaymentRecordDTO.setOverdue(false);
                    repaymentRecordDTO.setOverdueFee(BigDecimal.ZERO);
                }
            }
        }
    }
}
