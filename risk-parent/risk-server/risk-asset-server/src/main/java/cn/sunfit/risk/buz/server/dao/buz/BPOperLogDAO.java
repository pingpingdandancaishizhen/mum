package cn.sunfit.risk.buz.server.dao.buz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.BPOperLog;
import cn.sunfit.risk.buz.api.vo.buz.OperLogReq;

@Repository
public interface BPOperLogDAO {
    // 插入审核日志
    void insert(BPOperLog log);

    // 查询operlog
    List<BPOperLog> selectBpOperLog(OperLogReq req, RowBounds rowBounds);

    // 查询审核日志
    List<BPOperLog> selectBpOperLogReview(OperLogReq req, RowBounds rowBounds);

    // 查询最新的审核日志
    List<BPOperLog> selectLastestLogReview(@Param("bpids") List<String> bpId, @Param("domain") String domain);
}