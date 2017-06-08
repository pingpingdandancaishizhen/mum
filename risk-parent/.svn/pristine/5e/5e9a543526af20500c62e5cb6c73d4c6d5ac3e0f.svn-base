package cn.sunfit.risk.buz.server.dao.p2p.partnerCorp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.P2PAsset;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetDTO;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetQueryReq;

@Repository
public interface P2PAssetDAO {

    List<P2PAsset> checkCorpAbbreviation(P2PAsset asset);

    List<P2PAsset> checkCorpName(P2PAsset asset);

    List<P2PAsset> checkInstitutionCode(P2PAsset asset);

    void insert(P2PAsset asset);

    List<P2PAssetDTO> queryAssetList(@Param("asset") P2PAssetQueryReq asset, RowBounds rowBounds);

    P2PAsset selectByPrimaryKey(@Param("id") String id, @Param("domain") String corpDomain);

    void updateByPrimaryKey(P2PAsset asset);

}