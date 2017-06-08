package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMeta;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;

@Repository
public interface BPMetaDAO {

    BPMeta findById(@Param("corpId") String corpId, @Param("domain") String corpDomain, @Param("bpDefId") String bpDefId);

    List<BpMetaCorpProductVO> queryDeptMeteCorpProduct(@Param("domain") String domain, @Param("deptId") String deptId);

    List<BpMetaCorpProductVO> selectBPMetaCorpProduct(BpMetaQueryReq req);

    List<BpMetaCorpProductVO> selectBPMetaCorpProduct(BpMetaQueryReq req, RowBounds rowBounds);

    BpMetaCorpProductVO selectMetaByProduct(BpMetaQueryReq s);

    int updateByPrimaryKey(BPMeta meta);

    void updateLastest(BPMeta meta);
}