package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMeta;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;

@Repository
public interface BPMetaDAO {

    BPMeta findById(@Param("corpId") String corpId, @Param("domain") String corpDomain, @Param("bpDefId") String bpDefId);

    List<BpMetaCorpProductVO> selectBPMetaCorpProduct(BpMetaQueryReq req, RowBounds rowBounds);

    BpMetaCorpProductVO selectMetaByProduct(BpMetaQueryReq s);

    int updateByPrimaryKey(BPMeta meta);

    void updateLastest(BPMeta meta);
}