package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeDeptRel;

@Repository
public interface BPMetaNodeDeptRelDAO {

    void batchInsert(@Param("domain") String domain, @Param("nodes") List<BPMetaNodeDeptRel> nodes);

    void deleteByDeptId(@Param("domain") String domain, @Param("deptId") String deptId);

    List<BPMetaNodeDeptRel> selectByDeptId(@Param("domain") String domain, @Param("deptId") String deptId);

}