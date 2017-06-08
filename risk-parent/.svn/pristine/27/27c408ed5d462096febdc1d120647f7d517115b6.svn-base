package cn.sunfit.risk.buz.server.dao.buz;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.buz.BPJump;

@Repository
public interface BPJumpDAO {
    int insert(BPJump record);

    BPJump selectByTaskId(@Param("taskId") String taskId, @Param("domain") String domain);

    int updateByPrimaryKey(BPJump record);
}