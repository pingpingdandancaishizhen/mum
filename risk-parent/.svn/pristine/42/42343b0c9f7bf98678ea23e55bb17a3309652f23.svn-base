package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeAssign;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeAssignDeleteReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeAssignQueryReq;

@Repository
public interface BPMetaNodeAssignDAO {
    void deleteAssign(BpMetaNodeAssignDeleteReq req);

    int insert(BPMetaNodeAssign record);

    void insertBatch(@Param("assignList") List<BPMetaNodeAssign> list, @Param("domain") String domain);

    List<BPMetaNodeAssign> selectByNodeId(BpMetaNodeAssignQueryReq req, RowBounds rowBounds);

    List<BPMetaNodeAssign> selectByNodeKey(@Param("nodeKey") String nodeKey, @Param("bpDefId") String bpDefId,
            @Param("domain") String domain);

    BPMetaNodeAssign selectByPrimaryKey(@Param("assignId") String assignId, @Param("domain") String domain);

    List<String> selectUserByNodeKey(@Param("nodeKey") String nodeKey, @Param("bpDefId") String bpDefId,
            @Param("domain") String domain);

    int updateByPrimaryKey(BPMetaNodeAssign record);

}