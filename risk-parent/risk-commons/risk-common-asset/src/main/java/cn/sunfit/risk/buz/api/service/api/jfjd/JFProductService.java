package cn.sunfit.risk.buz.api.service.api.jfjd;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFIdNameVO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFMetaDTO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFProduct;
import cn.sunfit.risk.buz.api.vo.Resp;

public interface JFProductService {
    /**
     * 
     * @Title: queryMeta
     * @Description: 查询产品的最新流程
     * @param @param prodType
     * @param @param domain
     * @param @return   
     * @return JFMetaDTO 
     * @author XFL 2017年3月23日 
     * @throws
     */
    JFMetaDTO queryMeta(String prodType, String domain);

    /**
     * 
     * @Title: queryMonthlyFee
     * @Description: 查询支持的月
     * @param @param productId
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月23日 
     * @throws
     */
    Resp queryMonthlyFee(String productId);

    /**
     * 
     * @Title: queryPartnerByProductId
     * @Description: 查询抵押权人
     * @param @param productId
     * @param @param domain
     * @param @param roleId
     * @param @return   
     * @return List<JFIdNameVO> 
     * @author XFL 2017年3月23日 
     * @throws
     */
    public List<JFIdNameVO> queryPartnerByProductId(String productId, String domain, String roleId);

    /**
     * 
     * @Title: queryProduct
     * @Description: 查询产品
     * @param @param prodType
     * @param @return   
     * @return JFProduct 
     * @author XFL 2017年3月27日 
     * @throws
     */
    JFProduct queryProduct(String prodType);

    /**
     * 
     * @Title: queryProducts
     * @Description: 查询所有产品
     * @param @param corpId
     * @param @return   
     * @return Map<String,Object> 
     * @author XFL 2017年3月23日 
     * @throws
     */
    Map<String, Object> queryProducts(String corpId);
}
