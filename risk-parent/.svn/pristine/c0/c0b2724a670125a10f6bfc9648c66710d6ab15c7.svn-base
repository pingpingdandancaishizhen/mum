package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPRunPath;

@Repository
public interface BPRunPathDAO {
    int insert(BPRunPath record);

    BPRunPath selectByParentIdNodeId(@Param("parentId") String parentId, @Param("nodeKey") String nodeKey,
            @Param("domain") String domain);

    BPRunPath selectByPrimaryKey(String pathId);

    int updateByPrimaryKey(BPRunPath record);
}