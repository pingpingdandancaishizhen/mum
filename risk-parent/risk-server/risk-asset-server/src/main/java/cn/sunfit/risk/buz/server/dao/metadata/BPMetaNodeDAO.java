package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaFormRelateReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaNodeVO;

@Repository
public interface BPMetaNodeDAO {

    List<BPMetaNode> selectAllBPMetaNode(@Param("domain") String domain);

    List<BPMetaNode> selectAuditNodeByProduct(@Param("productId") String productId, @Param("domain") String domain);

    List<BPMetaNode> selectBPMetaNodeByProduct(@Param("domain") String domain, @Param("product") String product);

    List<BpMetaNodeVO> selectBpMetaNodeMetaAllTask(FormQuery req);

    List<BpMetaNodeVO> selectBpMetaNodeMetaTask(BpMetaNodeQueryReq req);

    List<BpMetaNodeVO> selectBpMetaNodeMetaTask(BpMetaNodeQueryReq req, RowBounds rowBounds);

    List<BpMetaNodeVO> selectBpMetaNodeMetaTaskAndStart(BpMetaNodeQueryReq req, RowBounds rowBounds);

    BPMetaNode selectByNodeKey(@Param("nodeKey") String nodeKey, @Param("bpDefId") String bpDefId,
            @Param("domain") String domain);

    List<BpMetaNodeVO> selectDeptBpMetaNodeMetaTask(@Param("domain") String domain, @Param("bpDefId") String bpDefId,
            @Param("deptId") String deptId);

    void updateFormKeyByNodeId(BpMetaFormRelateReq req);

}