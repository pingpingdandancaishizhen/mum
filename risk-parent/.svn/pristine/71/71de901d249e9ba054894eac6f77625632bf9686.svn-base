package cn.sunfit.risk.buz.api.service.solution;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayResultVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryVO;

/**
 * 
 * @Title: AuditService.java
 * @Package cn.sunfit.risk.buz.api.service.solution
 * @Description: 审核管理Service
 * @author XFL
 * @date 2017年3月1日 上午11:24:15
 * @version V1.0
 */
public interface AuditService {

    /**
     * 
     * @Title: queryAllAuditList
     * @Description: 查询审核
     * @param @param req
     * @param @return   
     * @return RespPage<LoanAuditVO> 
     * @author XFL 2017年3月1日 
     * @throws
     */
    RespPage<List<LoanAuditQueryVO>> queryAllAuditList(LoanAuditQueryReq req);

    /**
     * @Title: queryAllHistoryAuditList
     * @Description: 查询历史审核记录
     * @param @param req
     * @param @return   
     * @return RespPage<List<LoanAuditQueryVO>> 
     * @author XFL 2017年3月1日 
     * @throws
     */
    RespPage<List<LoanAuditQueryVO>> queryAllHistoryAuditList(LoanAuditQueryReq req);

    /**
     * 
     * @Title: queryAuditDayList
     * @Description: 查询审核日报表
     * @param @param req
     * @param @return   
     * @return Map<String,Map<String,String>> 
     * @author XFL 2017年3月2日 
     * @throws
     */
    Map<String, List<LoanAuditDayResultVO>> queryAuditDayList(LoanAuditDayQueryReq req);

    /**
     * 
     * @Title: queryMyAuditList
     * @Description: 查询我的审核
     * @param @param req
     * @param @return   
     * @return RespPage<LoanAuditVO> 
     * @author XFL 2017年3月1日 
     * @throws
     */
    RespPage<List<LoanAuditQueryVO>> queryMyAuditList(LoanAuditQueryReq req);
}
