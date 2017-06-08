package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaOperation;

@Repository
public interface BPMetaOperationDAO {

    // 查询节点的操作
    List<BPMetaOperation> selectNodeOperation(@Param("corpId") String corpId, @Param("domain") String domain,
            @Param("bpDefId") String bpDefId, @Param("nodeKey") String nodeKey);

    BPMetaOperation selectNodeOperationByType(@Param("corpId") String corpId, @Param("domain") String domain,
            @Param("bpDefId") String bpDefId, @Param("nodeKey") String nodeKey, @Param("opertype") String opertype);

    // 查询开始表单的操作
    List<BPMetaOperation> selectStartOperation(@Param("corpId") String corpId, @Param("domain") String domain,
            @Param("bpDefId") String bpDefId);

}