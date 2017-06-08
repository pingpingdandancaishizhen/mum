package cn.sunfit.risk.buz.api.service.loan;

import java.util.List;

import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.loan.LoanDetailQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryExportVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanQueryResp;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanReportReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanSaveReq;

public interface LoanService {

    // public boolean hasLoan(LoanReq req);

    public List<LoanQueryExportVO> queryExportLoan(LoanQueryReq req, String domain);

    /**
     * 
     * @Title: queryFormReqByBPId
     * @Description: 根据单子ID查询FORM需要的参数
     * @param @param bpId
     * @param @return   
     * @return FormQuery 
     * @author XFL 2017年2月8日 
     * @throws
     */
    public FormQuery queryFormReqByBPId(String bpId, FormQuery req);

    public RespPage<List<LoanQueryResp>> queryLoan(LoanQueryReq req, String domain);

    public LoanDetailQueryResp queryLoanDetail(String bpId, String domain);

    public void saveLoan(LoanSaveReq req) throws ServiceException;

    RespPage<List<LoanReportDTO>> selectLoanReport(LoanReportReq req);

}
