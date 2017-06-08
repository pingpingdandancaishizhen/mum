package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPOperLog;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogReq;

@Repository
public interface BPOperLogDAO {
    // 插入审核日志,操作日志,log_type=1为操作日志
    void insert(BPOperLog log);

    // 查询操作log
    List<BPOperLog> selectBpOperLog(OperLogReq req, RowBounds rowBounds);

    // 查询审核日志 log_type=2
    List<BPOperLog> selectBpOperLogReview(OperLogReq req, RowBounds rowBounds);
    
    // 查询最新的审核日志
    List<BPOperLog> selectLastestLogReview(@Param("bpids") List<String> bpId, @Param("domain") String domain);
}