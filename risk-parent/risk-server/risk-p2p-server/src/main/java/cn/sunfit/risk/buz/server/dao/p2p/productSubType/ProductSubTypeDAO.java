package cn.sunfit.risk.buz.server.dao.p2p.productSubType;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.ProductSubType;

@Repository
public interface ProductSubTypeDAO {

    ProductSubType getByName(@Param("domain") String domain, @Param("productCode") String productCode,
            @Param("subTypeName") String subTypeName);

    List<Map<String, String>> getProductSubTypes(@Param("domain") String domain,
            @Param("productCode") String productCode);

    List<ProductSubType> selectByProductCode(@Param("productCode") String productCode, @Param("domain") String domain);

    List<ProductSubType> selectByTypeId(@Param("typeId") String typeId);
}