package cn.sunfit.risk.web.controller.partnerCorp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.JsonUtils;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.p2p.P2PAsset;
import cn.sunfit.risk.buz.api.beans.p2p.P2PBank;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.ProductType;
import cn.sunfit.risk.buz.api.constants.asset.AssetType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.partnerCorp.P2PAssetService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.p2p.productType.ProductTypeService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.AssetAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.P2PProductAddReq;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetDTO;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;
import cn.sunfit.risk.buz.util.p2p.AssetProductRsp;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/asset")
public class AssetController extends BaseController {

    @Autowired
    P2PAssetService p2PAssetService;

    @Autowired
    P2PBankService bankService;

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    P2PProductService productService;

    @RequestMapping(value = "/addAssetPage", method = RequestMethod.GET)
    public String addAssetPage(HttpServletRequest request) {
        List<P2PBank> banks = bankService.getBankByThirdType("allinpay");
        request.setAttribute("banks", banks);
        request.setAttribute("assetType", cn.sunfit.risk.buz.api.constants.asset.AssetType.values());
        return "/partnerCorp/addAssetPage";
    }

    @RequestMapping(value = "/allBank", method = RequestMethod.GET)
    @ResponseBody
    public Map allBank(HttpServletRequest request) {
        Map map = new HashMap();
        List<P2PBank> banks = bankService.getBankByThirdType("allinpay");
        map.put("message", "");
        map.put("value", banks);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/checkAssetProduct", method = RequestMethod.POST)
    public Resp checkAssetProduct(HttpServletRequest req, String assetId) {
        List<P2PProduct> pageList = productService.queryProductByAssetId(assetId, getCurrentUser().getDomain());
        return new Resp(pageList);
    }

    /**
     * 校验公司简称
     * @Title: checkCorpAbbreviationExist
     * @Description: TODO
     * @param @param corpAbbreviation
     * @param @param id
     * @param @return   
     * @return Map<String,Object> 
     * @author wangguang 2017年5月22日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/checkCorpAbbreviationExist", method = RequestMethod.POST)
    public Map<String, Object> checkCorpAbbreviationExist(@RequestParam(required = true) String corpAbbreviation,
            String id) {
        P2PAsset asset = new P2PAsset();
        CorpUserDTO user = getCurrentUser();
        asset.setDomain(getCurrentUser().getDomain());
        asset.setCorpAbbreviation(corpAbbreviation);
        asset.setId(id);
        Map<String, Object> map = new HashMap<String, Object>();
        boolean exist = CollectionUtils.isEmpty(p2PAssetService.checkCorpAbbreviation(asset));
        map.put("valid", exist);
        return map;

    }

    /**
     * 校验公司名称
     * @Title: checkCustomerExist
     * @Description: TODO
     * @param @param corpName
     * @param @param id
     * @param @return   
     * @return Map<String,Object> 
     * @author wangguang 2017年5月22日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/checkCorpNameExist", method = RequestMethod.POST)
    public Map<String, Object> checkCustomerExist(@RequestParam(required = true) String corpName, String id) {
        P2PAsset asset = new P2PAsset();
        CorpUserDTO user = getCurrentUser();
        asset.setDomain(getCurrentUser().getDomain());
        asset.setCorpName(corpName);
        asset.setId(id);
        Map<String, Object> map = new HashMap<String, Object>();
        boolean exist = CollectionUtils.isEmpty(p2PAssetService.checkCorpName(asset));
        map.put("valid", exist);
        return map;

    }

    /**
     * 校验产品代码
     * @Title: checkInstitutionCodeExist
     * @Description: TODO
     * @param @param institutionCode
     * @param @param id
     * @param @return   
     * @return Map<String,Object> 
     * @author wangguang 2017年5月22日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/checkInstitutionCodeExist", method = RequestMethod.POST)
    public Map<String, Object> checkInstitutionCodeExist(@RequestParam(required = true) String institutionCode,
            String id) {
        P2PAsset asset = new P2PAsset();
        CorpUserDTO user = getCurrentUser();
        asset.setDomain(getCurrentUser().getDomain());
        asset.setInstitutionCode(institutionCode);
        asset.setId(id);
        Map<String, Object> map = new HashMap<String, Object>();
        boolean exist = CollectionUtils.isEmpty(p2PAssetService.checkInstitutionCode(asset));
        map.put("valid", exist);
        return map;

    }

    @RequestMapping(value = "/editAssetPage", method = RequestMethod.GET)
    public String editAssetPage(HttpServletRequest request, String id) {
        List<P2PBank> banks = bankService.getBankByThirdType("allinpay");
        request.setAttribute("banks", banks);
        request.setAttribute("assetType", AssetType.values());
        P2PAsset asset = p2PAssetService.selectByPrimaryKey(id, getCurrentUser().getDomain());
        request.setAttribute("asset", asset);
        request.setAttribute("repaymentBank", bankService.findByBankCode(asset.getRepaymentBank()));
        request.setAttribute("acceptAccountBank", bankService.findByBankCode(asset.getAcceptAccountBank()));
        return "/partnerCorp/editAssetPage";
    }

    @RequestMapping(value = "/loadAssetManager", method = RequestMethod.GET)
    public String loadAssetManager(HttpServletRequest request) {

        // CorpUserDTO user = getCurrentUser();
        List<ProductType> productTypes = productTypeService.findAll();
        request.setAttribute("assetType", AssetType.values());
        request.setAttribute("productTypes", productTypes);
        return "/partnerCorp/loadPartnerManager";
    }

    @RequestMapping(value = "/loadProductEdit", method = RequestMethod.GET)
    public String loadProductEdit(HttpServletRequest request, String assetId) {

        // CorpUserDTO user = getCurrentUser();
        List<ProductType> proList = productTypeService.findAll();
        List<P2PProduct> products = productService.queryProductByAssetId(assetId, getCurrentUser().getDomain());
        List<AssetProductRsp> rsp = new ArrayList<AssetProductRsp>();
        for (P2PProduct product : products) {
            CydFeeConfig feeConfig = null;
            try {
                feeConfig = JsonUtils.parseJSON(product.getFeeConfig(), CydFeeConfig.class);
                AssetProductRsp pro = new AssetProductRsp().convert(product);
                for (ProductType type : proList) {
                    if (StringUtils.equals(product.getProductType(), type.getId())) {
                        pro.setProductTypeStr(type.getName());
                    }
                }
                pro.setCydfeeConfig(feeConfig);
                rsp.add(pro);

            } catch (Exception e) {
                e.printStackTrace();
                throw new ServiceException("产品配置出错");
            }
        }

        request.setAttribute("products", rsp);
        request.setAttribute("assetId", assetId);
        request.setAttribute("proList", proList);
        return "/partnerCorp/product/editProduct";
    }

    @RequestMapping(value = "/loadProductManager", method = RequestMethod.GET)
    public String loadProductManager(HttpServletRequest request, String assetId) {
        // CorpUserDTO user = getCurrentUser();
        List<ProductType> proList = productTypeService.findAll();
        request.setAttribute("assetId", assetId);
        request.setAttribute("proList", proList);
        return "/partnerCorp/product/addProduct";
    }

    @ResponseBody
    @RequestMapping(value = "/updateAsset", method = RequestMethod.POST)
    public Resp modifyCustomer(@Valid AssetAddReq assetReq, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        CorpUserDTO user = getCurrentUser();
        P2PAsset asset = new P2PAsset();
        asset.convert(assetReq);

        asset.setId(assetReq.getId());
        asset.setLastmodTime(new Date());
        asset.setStatus((short) 1);
        asset.setDomain(getCurrentUser().getDomain());
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpName(asset))) {
            throw new ServiceException("企业名称已经存在");
        }
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpAbbreviation(asset))) {
            throw new ServiceException("企业简称已经存在");
        }

        if (!StringUtils.isEmpty(asset.getInstitutionCode())) {
            if (CollectionUtils.isNotEmpty(p2PAssetService.checkInstitutionCode(asset))) {
                throw new ServiceException("机构代码已经存在");
            }
        }

        p2PAssetService.updateByPrimaryKey(asset);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/queryAsset", method = RequestMethod.POST)
    public Resp queryAsset(P2PAssetQueryReq req) {
        req.setStatus((short) 1);
        req.setDomain(getCurrentUser().getDomain());
        RespPage<List<P2PAssetDTO>> pageList = p2PAssetService.queryAssetList(req);
        return new Resp(pageList);
    }

    @ResponseBody
    @RequestMapping(value = "/saveAsset", method = RequestMethod.POST)
    public Resp saveAsset(@Valid AssetAddReq assetReq, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        P2PAsset asset = new P2PAsset();
        CorpUserDTO user = getCurrentUser();
        asset.setCreateMan(user.getId());
        asset.convert(assetReq);
        asset.setStatus((short) 1);
        asset.setDomain(getCurrentUser().getDomain());
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpName(asset))) {
            throw new ServiceException("企业名称已经存在");
        }
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpAbbreviation(asset))) {
            throw new ServiceException("企业简称已经存在");
        }

        if (!StringUtils.isEmpty(asset.getInstitutionCode())) {
            if (CollectionUtils.isNotEmpty(p2PAssetService.checkInstitutionCode(asset))) {
                throw new ServiceException("机构代码已经存在");
            }
        }

        p2PAssetService.insert(asset);

        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public Resp saveProduct(@Valid P2PProductAddReq productReq, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        P2PProduct product = new P2PProduct();
        productReq.setCorpId(getCurrentUser().getCorpId());
        product.convert(productReq);
        CorpUserDTO user = getCurrentUser();
        product.setCorpId(user.getCorpId());
        product.setCreateTime(new Date());
        product.setStatus("1");
        product.setId(IdUtil.geneId());
        product.setLastmodTime(new Date());
        product.setDomain(getCurrentUser().getDomain());
        if (CollectionUtils.isNotEmpty(productService.checkByProductCode(product))) {
            throw new ServiceException("产品代码已经存在");
        }
        if (CollectionUtils.isNotEmpty(productService.checkAssetProductType(product))) {
            throw new ServiceException("资产方已配置过此类产品");
        }
        product.setDomain(getCurrentUser().getDomain());
        productService.insert(product);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public Resp updateProduct(@Valid P2PProductAddReq productReq, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        P2PProduct product = new P2PProduct();
        product.convert(productReq);
        CorpUserDTO user = getCurrentUser();
        product.setCorpId(user.getCorpId());
        product.setId(productReq.getId());
        product.setStatus("1");
        product.setLastmodTime(new Date());
        product.setDomain(getCurrentUser().getDomain());
        if (CollectionUtils.isNotEmpty(productService.checkByProductCode(product))) {
            throw new ServiceException("产品代码已经存在");
        }
        List<P2PProduct> checkList = productService.checkAssetProductType(product);
        if (CollectionUtils.isNotEmpty(checkList)) {
            if (checkList.size() == 1 && !StringUtils.equals(checkList.get(0).getId(), product.getId())) {
                throw new ServiceException("资产方已配置过此类产品");
            }
        }

        productService.updateByPrimaryKey(product);
        return new Resp();
    }

}
