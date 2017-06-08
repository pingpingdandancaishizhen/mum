package cn.sunfit.risk.buz.server.service.p2p.partnerCorp;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.p2p.P2PAsset;
import cn.sunfit.risk.buz.api.service.p2p.partnerCorp.P2PAssetService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetDTO;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetQueryReq;
import cn.sunfit.risk.buz.server.dao.p2p.partnerCorp.P2PAssetDAO;

@Service("risk.p2PAssetService")
public class P2PAssetServiceImpl implements P2PAssetService {

    @Autowired
    private P2PAssetDAO p2pAssetDAO;

    @Override
    public List<P2PAsset> checkCorpAbbreviation(P2PAsset asset) {
        // TODO Auto-generated method stub
        return p2pAssetDAO.checkCorpAbbreviation(asset);
    }

    @Override
    public List<P2PAsset> checkCorpName(P2PAsset asset) {
        // TODO Auto-generated method stub
        return p2pAssetDAO.checkCorpName(asset);
    }

    @Override
    public List<P2PAsset> checkInstitutionCode(P2PAsset asset) {
        // TODO Auto-generated method stub
        return p2pAssetDAO.checkInstitutionCode(asset);
    }

    @Override
    public void insert(P2PAsset asset) {
        // TODO Auto-generated method stub
        p2pAssetDAO.insert(asset);

    }

    @Override
    public RespPage<List<P2PAssetDTO>> queryAssetList(P2PAssetQueryReq req) {
        List<P2PAssetDTO> list = p2pAssetDAO.queryAssetList(req, new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        for (P2PAssetDTO assetDTO : list) {

            String assetType = cn.sunfit.risk.buz.api.constants.asset.AssetType.getTypeNameStrByTypeId(assetDTO
                    .getAssetType());
            if (assetType != null) {
                assetDTO.setAssetTypeName(assetType);
            }
        }

        return new RespPage<List<P2PAssetDTO>>(list, totalCount);
    }

    @Override
    public P2PAsset selectByPrimaryKey(String id, String domain) {
        // TODO Auto-generated method stub
        return p2pAssetDAO.selectByPrimaryKey(id, domain);
    }

    @Override
    public void updateByPrimaryKey(P2PAsset asset) {
        // TODO Auto-generated method stub
        p2pAssetDAO.updateByPrimaryKey(asset);

    }

}
