package cn.sunfit.risk.buz.api.service.repayment;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentDetail;
import cn.sunfit.risk.buz.api.beans.repayment.RepaymentSettlement;
import cn.sunfit.risk.buz.api.exception.ServiceException;
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

public interface RepaymentDetailService {

    // public void addRepaymentDetail(RepaymentDetailAddReq req);

    boolean checkEarlyRecord(List<RepaymentRecordDTO> list) throws ServiceException;

    Map<String, String> getRepaymentAttr(String corpId, String domain, String bpId) throws ServiceException;

    Map<String, BigDecimal> getRepaymentFeeRate(String corpId, String domain, String bpId) throws ServiceException;

    RepaymentSettlement getSettlementInfo(List<RepaymentRecordDTO> list, Map<String, BigDecimal> rate)
            throws ServiceException;

    List<OverdueQueryVO> queryOverdueExportList(RepaymentQueryReq req, String domain) throws ServiceException;

    public RespPage<List<OverdueQueryResp>> queryOverdueList(RepaymentQueryReq req, String domain)
            throws ServiceException;

    public List<RepaymentDetail> queryRepaymentDetailList(String bpId, String domain) throws ServiceException;

    List<RepaymentQueryVO> queryRepaymentExportList(RepaymentQueryReq req, String domain) throws ServiceException;

    public RespPage<List<RepaymentQueryResp>> queryRepaymentList(RepaymentQueryReq req, String domain)
            throws ServiceException;

    public List<RepaymentRecordDTO> queryRepaymentRecordList(String bpId, String domain, String corpId)
            throws ServiceException;

    public void saveRepaymentRecord(RepaymentRecordSaveReq req) throws ServiceException;

    public void saveSettlementRecord(RepaymentSettlementSaveReq req) throws ServiceException;

    RespPage<List<RepaymentReportDTO>> selectRepaymentReport(RepaymentReportReq req);

}
