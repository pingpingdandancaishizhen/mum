package cn.sunfit.risk.buz.server.service.p2p.product;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaDAO;
import cn.sunfit.risk.buz.server.dao.p2p.product.P2PProductDAO;

@Service("risk.p2PProductService")
public class P2PProductServiceImpl implements P2PProductService {

    @Autowired
    private P2PProductDAO p2pProductDAO;
    @Autowired
    private BPMetaDAO bpMetaDAO;

    @Override
    public List<P2PProduct> checkAssetProductType(P2PProduct product) {
        return p2pProductDAO.selectProductByAssetIdCode(product);
    }

    @Override
    public List<P2PProduct> checkByProductCode(P2PProduct product) {
        return p2pProductDAO.checkByProductCode(product);
    }

    @Override
    public P2PProduct findByProductCode(String productCode, String domain) {
        // TODO Auto-generated method stub
        return p2pProductDAO.findByProductCode(productCode, domain);
    }

    @Override
    public List<Map<String, String>> findRiskProductList(String domain) {
        return p2pProductDAO.findRiskProductList(domain);
    }

    /*
     * @Override public Object queryFeeConfig(String productId) { P2PProduct p =
     * p2pProductDAO.selectByPrimaryKey(productId); String feeconfig = p2pProductDAO.selectFeeConfig(productId); if
     * (StringUtils.isNotBlank(feeconfig)) { if (ProductType.XYDK.getStatus().equals(p.getProductType())) { XJDFeeConfig
     * c = JsonUtils.parseJSON(feeconfig, XJDFeeConfig.class); return c; } } return null; }
     */

    @Override
    public String getProductTypeByCode(String domain, String productCode) {
        return p2pProductDAO.getProductTypeByCode(domain, productCode);
    }

    @Override
    public void insert(P2PProduct product) {
        p2pProductDAO.insert(product);
    }

    @Override
    public List<P2PProduct> queryAllRiskProduct(String domain) {
        return p2pProductDAO.selectAllRiskProduct(domain);
    }

    @Override
    public BpMetaCorpProductVO queryMetaByProduct(BpMetaQueryReq s) {
        BpMetaCorpProductVO vo = bpMetaDAO.selectMetaByProduct(s);
        return vo;
    }

    @Override
    public List<P2PProduct> queryProductByAssetId(String assetId, String domain) {
        return p2pProductDAO.selectByAssetId(assetId, domain);
    }

    @Override
    public P2PProduct queryProductById(String productId, String domain) {
        P2PProduct p = p2pProductDAO.selectByPrimaryKey(productId, domain);
        return p;
    }

    @Override
    public List<P2PProduct> selectProductByCorpId(String corpId, String domain) {
        // TODO Auto-generated method stub
        return p2pProductDAO.selectProductByCorpId(corpId, domain);

    }

    @Override
    public void updateByPrimaryKey(P2PProduct record) {
        p2pProductDAO.updateByPrimaryKey(record);
    }

}
