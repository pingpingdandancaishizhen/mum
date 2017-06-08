package cn.sunfit.risk.buz.server.dao.p2p.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;

@Repository
public interface P2PProductDAO {

    List<P2PProduct> checkByProductCode(P2PProduct product);

    P2PProduct findByProductCode(@Param("productCode") String productCode, @Param("domain") String domain);

    List<Map<String, String>> findRiskProductList(@Param("domain") String domain);

    String getProductTypeByCode(@Param("domain") String domain, @Param("productCode") String productCode);

    int insert(P2PProduct record);

    List<P2PProduct> selectAllRiskProduct(@Param("domain") String domain);

    List<P2PProduct> selectByAssetId(@Param("assetId") String assetId, @Param("domain") String domain);

    List<P2PProduct> selectByCorpId(@Param("corpId") String corpId, RowBounds rowBounds, @Param("domain") String domain);

    P2PProduct selectByPrimaryKey(@Param("id") String id, @Param("domain") String corpDomain);

    String selectFeeConfig(@Param("id") String productId, @Param("domain") String corpDomain);

    List<P2PProduct> selectProductByAssetIdCode(P2PProduct product);

    List<P2PProduct> selectProductByCorpId(@Param("corpId") String corpId, @Param("domain") String domain);

    void updateByPrimaryKey(P2PProduct record);

    void updateFeeConfig(@Param("id") String productId, @Param("feeConfig") String feeConfig,
            @Param("domain") String domain);
}