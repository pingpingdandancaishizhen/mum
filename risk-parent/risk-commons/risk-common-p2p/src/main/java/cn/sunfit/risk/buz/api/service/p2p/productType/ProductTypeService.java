package cn.sunfit.risk.buz.api.service.p2p.productType;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.ProductType;

public interface ProductTypeService {

    /**
     * 删除某条产品类型
     * @Title: deleteByPrimaryKey
     * @Description: TODO
     * @param @param id 产品类型id
     * @param @return   
     * @return int 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    int deleteByPrimaryKey(String id);

    /**
     * 查找所有产品类型
     * @Title: findAll
     * @Description: TODO
     * @param @return   
     * @return List<ProductType> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<ProductType> findAll();

    /**
     * 插入一条产品类型数据
     * @Title: insert
     * @Description: TODO
     * @param @param record 一条产品类型数据
     * @param @return   
     * @return int 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    int insert(ProductType record);

    /**
     * 插入一条产品类型
     * @Title: insertSelective
     * @Description: TODO
     * @param @param record 产品类型数据
     * @param @return   
     * @return int 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    int insertSelective(ProductType record);

    /**
     * 查询某条产品类型
     * @Title: selectByPrimaryKey
     * @Description: TODO
     * @param @param id 产品类型id
     * @param @return   
     * @return ProductType 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    ProductType selectByPrimaryKey(String id);

    /**
     * 更新某条产品类型的数据
     * @Title: updateByPrimaryKey
     * @Description: TODO
     * @param @param record 产品类型的数据
     * @param @return   
     * @return int 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    int updateByPrimaryKey(ProductType record);

    /**
     * 更新某条产品类型的数据
     * @Title: updateByPrimaryKeySelective
     * @Description: TODO
     * @param @param record 产品类型的数据
     * @param @return   
     * @return int 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    int updateByPrimaryKeySelective(ProductType record);
}
