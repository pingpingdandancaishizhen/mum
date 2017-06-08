package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeUserRel;

@Repository
public interface BPMetaNodeUserRelDAO {

    void batchInsert(@Param("domain") String domain, @Param("nodes") List<BPMetaNodeUserRel> nodes);

    void deleteByUserId(@Param("domain") String domain, @Param("userId") String userId);

    List<BPMetaNodeUserRel> selectByUserId(@Param("domain") String domain, @Param("userId") String userId);

}