package cn.sunfit.risk.buz.api.service.p2p.activiti;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPOperLog;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogReviewVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogSimpleVO;

public interface OperLogService {
    /**
     * 
     * @Title: insert
     * @Description: 插入操作日志
     * @param @param log   
     * @return void 
     * @author XFL 2017年1月16日 
     * @throws
     */
    void insert(BPOperLog log);

    /**
     * 
     * @Title: queryReviewOperLog
     * @Description: 查询审核日志
     * @param @return   
     * @return List<OperLogReviewVO> 
     * @author XFL 2017年1月16日 
     * @throws
     */
    RespPage<List<OperLogReviewVO>> queryReviewOperLog(OperLogReq req);

    /**
     * 
     * @Title: querySimpleOperLog
     * @Description: 查询操作日志
     * @param @return   
     * @return List<OperLogSimpleVO> 
     * @author XFL 2017年1月16日 
     * @throws
     */
    RespPage<List<OperLogSimpleVO>> querySimpleOperLog(OperLogReq req);

}
