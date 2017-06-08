package cn.sunfit.risk.web.controller.solution;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.constants.FeeType;
import cn.sunfit.risk.buz.api.constants.LoanEachTimeType;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.LoanTermType;
import cn.sunfit.risk.buz.api.constants.ProductMedium;
import cn.sunfit.risk.buz.api.constants.ProductType;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.ProductCorpVO;
import cn.sunfit.risk.buz.api.vo.solution.ProductModifyReq;
import cn.sunfit.risk.buz.api.vo.solution.ProductQueryReq;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerConfigShowVO;
import cn.sunfit.risk.web.controller.BaseController;

/**
 * 
 * @Title: ProductController.java
 * @Package cn.sunfit.risk.web.controller.solution
 * @Description: 产品管理
 * @author XFL
 * @date 2016年12月29日 下午3:49:10
 * @version V1.0
 */
@Controller
@RequestMapping("/solution/product")
public class ProductController extends BaseController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CorpDeptService corpDeptService;
    @Autowired
    private ContractPartnerService contractPartnerService;

    /**
     * 
     * @Title: loadProductFeeConfig
     * @Description: 加载产品费用配置
     * @param @param map
     * @param @param productId
     * @param @return   
     * @return String 
     * @author XFL 2017年2月28日 
     * @throws
     */
    @RequestMapping(value = "/loadProductFeeConfig", method = RequestMethod.GET)
    public String loadProductFeeConfig(ModelMap map, String productId) {
        BpMetaQueryReq s = new BpMetaQueryReq();
        s.setCorpInfo(getCurrentUser());
        s.setLastest(true);
        s.setProductId(productId);
        BpMetaCorpProductVO vo = productService.queryMetaByProduct(s);
        map.put("vo", vo);
        if (vo.getProductType().equals(ProductType.DYDK.getStatus())
                && vo.getMedium().equals(ProductMedium.C.getStatus())) {
            // 抵押车贷配置
            map.put("feetype", FeeType.values());
            map.put("loanrepaymenttype", LoanRepaymentType.values());
            map.put("loaneachtime", LoanEachTimeType.values());
            map.put("loantermtype", LoanTermType.values());
            // 放入所有营业机构
            List<CorpDept> deptList = corpDeptService.queryByDeptType(getCurrentUser().getCorpId(), "1");
            map.put("deptList", deptList);
            // 查询各种方
            List<PartnerConfigShowVO> partnerList = contractPartnerService.queryPartnerByProductId(getCurrentUser()
                    .getDomain(), productId, null);
            map.put("partnerList", partnerList);
            String feeConfig = productService.queryFeeConfig(productId);
            map.put("feeConfig", feeConfig);
            return "/solution/product/diyacheProductConfig";
        } else {
            // 产品暂时没用产品配置页面
            return "/solution/product/noProductConfig";
        }

    }

    /**
     * 
     * @Title: loadProductManager
     * @Description: 产品页跳转
     * @param @return   
     * @return String 
     * @author XFL 2016年12月29日 
     * @throws
     */
    @RequestMapping(value = "/loadProductManager", method = RequestMethod.GET)
    public String loadProductManager(ModelMap map) {
        map.put("productTypeEnum", ProductType.values());
        map.put("productMediumEnum", ProductMedium.values());
        return "/solution/product/loadProductManager";
    }

    @RequestMapping(value = "/feeConfig", method = RequestMethod.POST)
    @ResponseBody
    public Resp modifyFeeConfig(String productId, String feeConfig) {
        productService.modifyFeeConfig(productId, feeConfig, getCurrentUser().getCorpId());
        return new Resp();
    }

    /**
     * 
     * @Title: modifyProduct
     * @Description: 修改产品基本信息
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author XFL 2017年2月20日 
     * @throws
     */
    @RequestMapping(value = "/modifyProduct", method = RequestMethod.POST)
    @ResponseBody
    public Resp modifyProduct(@Valid ProductModifyReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpId(getCurrentUser().getCorpId());
        productService.updateProduct(req);
        return new Resp(r);
    }

    /**
     * @Title: queryProductList
     * @Description: 公司所拥有的产品
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author XFL 2016年12月29日 
     * @throws
     */
    @RequestMapping(value = "/queryProductListCorp", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryProductList(ProductQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        RespPage<List<ProductCorpVO>> r = productService.queryProductByCorp(req);
        return new Resp(r);
    }

}
