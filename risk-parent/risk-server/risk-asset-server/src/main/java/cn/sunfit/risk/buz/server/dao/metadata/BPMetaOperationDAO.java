package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaOperation;

@Repository
public interface BPMetaOperationDAO {

    // 查询节点的操作
    List<BPMetaOperation> selectNodeOperation(@Param("corpId") String corpId, @Param("domain") String domain,
            @Param("bpDefId") String bpDefId, @Param("nodeKey") String nodeKey);

    // 查询开始表单的操作
    List<BPMetaOperation> selectStartOperation(@Param("corpId") String corpId, @Param("domain") String domain,
            @Param("bpDefId") String bpDefId);

}