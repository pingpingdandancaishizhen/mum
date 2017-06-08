package cn.sunfit.risk.buz.server.dao.buz;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayResultVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryVO;

@Repository
public interface BPLoanAuditDAO {

    List<LoanAuditQueryVO> selectAllAuditList(LoanAuditQueryReq req, RowBounds rowBounds);

    List<LoanAuditQueryVO> selectAllHistoryAuditList(LoanAuditQueryReq req, RowBounds rowBounds);

    List<LoanAuditDayResultVO> selectAuditDayList(LoanAuditDayQueryReq req);

}
