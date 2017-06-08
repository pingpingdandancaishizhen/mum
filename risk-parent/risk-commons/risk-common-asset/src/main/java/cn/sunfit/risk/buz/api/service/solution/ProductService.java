package cn.sunfit.risk.buz.api.service.solution;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.ProductCorpVO;
import cn.sunfit.risk.buz.api.vo.solution.ProductModifyReq;
import cn.sunfit.risk.buz.api.vo.solution.ProductQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.dyc.MonthlyFee;

/**   
 * @Title: ProductService.java
 * @Package cn.sunfit.risk.buz.server.service.solution
 * @Description: 产品的服务类
 * @author XFL
 * @date 2016年12月29日 下午2:25:25
 * @version V1.0   
 */
public interface ProductService {

    /**
     * 
     * @Title: modifyFeeConfig
     * @Description: 修改费用配置
     * @param @param productId
     * @param @param feeConfig   
     * @return void 
     * @author XFL 2017年2月28日 
     * @throws
     */
    void modifyFeeConfig(String productId, String feeConfig, String corpId) throws ServiceException;

    /**
     * 
     * @Title: queryFeeConfig
     * @Description: 查询费用配置
     * @param @param productId
     * @param @return   
     * @return String 
     * @author XFL 2017年2月28日 
     * @throws
     */
    String queryFeeConfig(String productId);

    /**
     * 
     * @Title: queryMetaByProduct
     * @Description: 查询产品最新流程
     * @param @param s
     * @param @return   
     * @return BpMetaCorpProductVO 
     * @author XFL 2017年2月25日 
     * @throws
     */
    BpMetaCorpProductVO queryMetaByProduct(BpMetaQueryReq s);

    /**
     * 
     * @Title: queryMonthlyFee
     * @Description: 获取产品期限配置
     * @param @param productId
     * @param @return   
     * @return List<MonthlyFee> 
     * @author RJS 2017年4月27日 
     * @throws
     */
    List<MonthlyFee> queryMonthlyFee(String productId);

    /**
     * 
     * @Title: queryProductByCorp
     * @Description: 查询公司的所有产品分页
     * @param @param req
     * @param @return   
     * @return RespPage<List<ProductCorpVO>> 
     * @author XFL 2016年12月29日 
     * @throws
     */
    RespPage<List<ProductCorpVO>> queryProductByCorp(ProductQueryReq req);

    List<Product> queryProductByCorpId(String corpId);

    /**
     * 
     * @Title: updateProduct
     * @Description: 修改产品基本信息
     * @param @param req   
     * @return void 
     * @author XFL 2017年2月20日 
     * @throws
     */
    void updateProduct(ProductModifyReq req) throws ServiceException;

}
