package cn.sunfit.risk.buz.server.dao.buz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.beans.contract.UpdateBPContractNoReq;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.loan.LoanDetailQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryExportVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanSaveReq;

@Repository
public interface BPLoanDAO {

    long countByCarNum(@Param("bpId") String bpId, @Param("carnum") String carnum, @Param("domain") String domain);

    long countByCustomerProduct(LoanReq dto);

    void insertLoan(BPLoan loan);

    List<LoanQueryResp> queryAllLoan(@Param("req") LoanQueryReq req, @Param("domain") String domain, RowBounds rowBounds);

    List<LoanQueryExportVO> queryExportLoan(@Param("req") LoanQueryReq req, @Param("domain") String domain);

    LoanDetailQueryResp queryLoanDetail(@Param("bpId") String bpId, @Param("domain") String domain);

    BPLoan selectByBp(FormQuery req);

    List<LoanReportDTO> selectLoanReport(@Param("req") LoanReportReq req, RowBounds rowBounds);

    int update(BPLoan bpLoan);

    /**
     * 放款更新
     * @Title: updateBPLoanFK
     * @Description: TODO
     * @param @return   
     * @return int 
     * @author RJS 2017年3月1日 
     * @throws
     */
    int updateBPLoanFK(@Param("req") LoanSaveReq req);

    int updateBPLoanStartLoan(@Param("req") LoanSaveReq req);

    void updateContractNoByBp(UpdateBPContractNoReq req);
}