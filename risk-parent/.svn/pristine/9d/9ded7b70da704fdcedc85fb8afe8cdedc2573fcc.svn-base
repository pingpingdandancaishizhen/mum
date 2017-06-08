package cn.sunfit.risk.buz.api.service.p2p.productSubType;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.ProductSubType;

public interface ProductSubTypeService {

    /**
     * 根据产品子类型名称获取信息
     * @param domain
     * @param productCode
     * @param subTypeName
     * @return
     */
    ProductSubType getByName(String domain, String productCode, String subTypeName);

    /**
     * 通过产品编号查所有子类型
     * @Title: selectByProductCode
     * @Description: TODO
     * @param @param productCode 产品类型
     * @param @param domain 域名
     * @param @return   
     * @return List<ProductSubType> 
     * @author wangguang 2017年5月19日 
     * @throws
     */
    List<ProductSubType> selectByProductCode(String productCode, String domain);

    /**
     * 根据产品类型查他的所有子类型
     * @Title: selectByTypeId
     * @Description: TODO
     * @param @param typeId 产品类型
     * @param @return   
     * @return List<ProductSubType> 
     * @author wangguang 2017年5月19日 
     * @throws
     */
    List<ProductSubType> selectByTypeId(String typeId);
}
