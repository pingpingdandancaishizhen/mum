package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNode;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormRelateReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaNodeVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;

@Repository
public interface BPMetaNodeDAO {

    List<BPMetaNode> selectAllBPMetaNode(@Param("domain") String domain);

    List<BPMetaNode> selectAuditNodeByProduct(@Param("productId") String productId, @Param("domain") String domain);

    List<BPMetaNode> selectBPMetaNodeByProduct(@Param("domain") String domain, @Param("product") String product);

    List<BpMetaNodeVO> selectBpMetaNodeMetaAllTask(FormQuery req);

    List<BpMetaNodeVO> selectBpMetaNodeMetaTask(BpMetaNodeQueryReq req, RowBounds rowBounds);

    List<BpMetaNodeVO> selectBpMetaNodeMetaTaskAndStart(BpMetaNodeQueryReq req, RowBounds rowBounds);

    BPMetaNode selectByNodeKey(@Param("nodeKey") String nodeKey, @Param("bpDefId") String bpDefId,
            @Param("domain") String domain);

    List<String> selectNodeReasons(@Param("domain") String domain, @Param("bpDefId") String bpDefId,
            @Param("nodeKey") String taskDefinitionKey);

    List<String> selectStartReasons(@Param("domain") String domain, @Param("bpDefId") String bpDefId);

    void updateFormKeyByNodeId(BpMetaFormRelateReq req);

}