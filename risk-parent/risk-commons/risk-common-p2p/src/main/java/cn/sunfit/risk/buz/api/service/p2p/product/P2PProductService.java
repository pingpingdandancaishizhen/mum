package cn.sunfit.risk.buz.api.service.p2p.product;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;

public interface P2PProductService {

    List<P2PProduct> checkAssetProductType(P2PProduct product);

    /**
     * 根据产品编码，产品id校验产品编码是否重复
     * @Title: checkByProductCode
     * @Description: TODO
     * @param @param product 产品编码，产品id
     * @param @return   
     * @return List<P2PProduct> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<P2PProduct> checkByProductCode(P2PProduct product);

    /**
     * 根据产品编码查询产品
     * @Title: findByProductCode
     * @Description: TODO
     * @param @param productCode 产品编码
     * @param @param domain
     * @param @return   
     * @return P2PProduct 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    P2PProduct findByProductCode(String productCode, String domain);

    /**
     * 查询所有产品
     * @Title: findRiskProductList
     * @Description: TODO
     * @param @param domain 域名
     * @param @return   
     * @return List<Map<String,String>> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<Map<String, String>> findRiskProductList(String domain);

    /**
     * 
     * @Title: getProductTypeByCode
     * @Description: 根据产品编号查询产品类型名称
     * @param @param domain
     * @param @param productCode
     * @param @return   
     * @return String 
     * @author RJS 2017年5月22日 
     * @throws
     */
    String getProductTypeByCode(String domain, String productCode);

    // Object queryFeeConfig(String productId);

    /**
     * 插入一条产品
     * @Title: insert
     * @Description: TODO
     * @param @param product 一条产品
     * @return void 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    void insert(P2PProduct product);

    /**
     *  查询所有产品
     * @Title: queryAllRiskProduct
     * @Description: TODO
     * @param @param domain 域名
     * @param @return   
     * @return List<P2PProduct> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<P2PProduct> queryAllRiskProduct(String domain);

    BpMetaCorpProductVO queryMetaByProduct(BpMetaQueryReq s);

    /**
     * 根据资产方id查询该资产方的所有产品
     * @Title: queryProductByAssetId
     * @Description: TODO
     * @param @param assetId 资产方id
     * @param @param domain 域名
     * @param @return   
     * @return List<P2PProduct> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<P2PProduct> queryProductByAssetId(String assetId, String domain);

    /**
     * 根据某个产品
     * @Title: queryProductById
     * @Description: TODO
     * @param @param productId 产品id
     * @param @param domain 域名
     * @param @return   
     * @return P2PProduct 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    P2PProduct queryProductById(String productId, String domain);

    /**
     * 查询某公司的产品
     * @Title: selectProductByCorpId
     * @Description: TODO
     * @param @param corpId 公司id
     * @param @param domain 域名
     * @param @return   
     * @return List<P2PProduct> 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    List<P2PProduct> selectProductByCorpId(String corpId, String domain);

    /**
     * 更新某产品的信息
     * @Title: updateByPrimaryKey
     * @Description: TODO
     * @param @param record  产品的最新信息
     * @return void 
     * @author wangguang 2017年5月15日 
     * @throws
     */
    void updateByPrimaryKey(P2PProduct record);
}
