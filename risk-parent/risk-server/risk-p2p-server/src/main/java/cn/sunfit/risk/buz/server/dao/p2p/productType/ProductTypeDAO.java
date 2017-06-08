package cn.sunfit.risk.buz.server.dao.p2p.productType;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.ProductType;

@Repository
public interface ProductTypeDAO {

    int deleteByPrimaryKey(String id);

    List<ProductType> findAll();

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(String id);

    int updateByPrimaryKey(ProductType record);

    int updateByPrimaryKeySelective(ProductType record);
}