package cn.sunfit.risk.buz.server.dao.solution;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.vo.CorpReqBase;
import cn.sunfit.risk.buz.api.vo.solution.ProductCorpVO;

@Repository
public interface ProductDAO {
    long countByCorpIdProductId(@Param("corpId") String corpId, @Param("productId") String productId);

    int insert(Product record);

    Product selectByPrimaryKey(String id);

    String selectFeeConfig(@Param("id") String productId);

    List<ProductCorpVO> selectProductByCorp(CorpReqBase req, RowBounds rowBounds);

    List<Product> selectProductByCorpId(String corpId);

    int updateByPrimaryKey(Product record);

    void updateFeeConfig(@Param("id") String productId, @Param("feeConfig") String feeConfig);
}