package cn.sunfit.risk.web.controller.partnerCorp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.JsonUtils;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.bank.DmBank;
import cn.sunfit.risk.buz.api.beans.p2p.P2PAsset;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.ProductType;
import cn.sunfit.risk.buz.api.beans.p2p.ProductTypeName;
import cn.sunfit.risk.buz.api.constants.AssetType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.bank.BankService;
import cn.sunfit.risk.buz.api.service.p2p.partnerCorp.P2PAssetService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.p2p.productType.ProductTypeService;
import cn.sunfit.risk.buz.api.service.p2p.productTypeName.ProductTypeNameService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.AssetAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.P2PProductAddReq;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetDTO;
import cn.sunfit.risk.buz.api.vo.p2p.partnerCorp.P2PAssetQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.XydFeeConfig;
import cn.sunfit.risk.buz.util.p2p.AssetProductRsp;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/asset")
public class AssetController extends BaseController {

    @Autowired
    P2PAssetService p2PAssetService;

    @Autowired
    BankService bankService;

    @Autowired
    ProductTypeService productTypeService;

    @Autowired
    ProductTypeNameService productTypeNameService;

    @Autowired
    P2PProductService productService;

    @RequestMapping(value = "/addAssetPage", method = RequestMethod.GET)
    public String addAssetPage(HttpServletRequest request) {
        List<DmBank> banks = bankService.findAll();
        request.setAttribute("banks", banks);
        request.setAttribute("assetType", AssetType.values());
        return "/partnerCorp/addAssetPage";
    }

    @ResponseBody
    @RequestMapping(value = "/checkAssetProduct", method = RequestMethod.POST)
    public Resp checkAssetProduct(HttpServletRequest req, String assetId) {
        List<P2PProduct> pageList = productService.queryProductByAssetId(assetId);
        return new Resp(pageList);
    }

    @RequestMapping(value = "/editAssetPage", method = RequestMethod.GET)
    public String editAssetPage(HttpServletRequest request, String id) {
        List<DmBank> banks = bankService.findAll();
        request.setAttribute("banks", banks);
        request.setAttribute("assetType", AssetType.values());
        CorpUserDTO user = getCurrentUser();
        P2PAsset asset = p2PAssetService.selectByPrimaryKey(id);
        request.setAttribute("asset", asset);
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
        List<ProductTypeName> nameList = productTypeNameService.findAll();
        List<P2PProduct> products = productService.queryProductByAssetId(assetId);
        List<AssetProductRsp> rsp = new ArrayList<AssetProductRsp>();
        for (P2PProduct product : products) {
            XydFeeConfig feeConfig = null;
            try {
                feeConfig = JsonUtils.parseJSON(product.getFeeConfig(), XydFeeConfig.class);
                AssetProductRsp pro = new AssetProductRsp().convert(product);
                for (ProductType type : proList) {
                    if (StringUtils.equals(product.getProductType(), type.getId())) {
                        pro.setProductTypeStr(type.getName());
                    }
                }
                pro.setFeeConfig(feeConfig);
                rsp.add(pro);

            } catch (Exception e) {
                e.printStackTrace();
                throw new ServiceException("产品配置出错");
            }
        }

        request.setAttribute("products", rsp);
        request.setAttribute("assetId", assetId);
        request.setAttribute("proList", proList);
        request.setAttribute("nameList", JSONArray.fromObject(nameList));
        return "/partnerCorp/product/editProduct";
    }

    @RequestMapping(value = "/loadProductManager", method = RequestMethod.GET)
    public String loadProductManager(HttpServletRequest request, String assetId) {
        // CorpUserDTO user = getCurrentUser();
        List<ProductType> proList = productTypeService.findAll();
        List<ProductTypeName> nameList = productTypeNameService.findAll();
        request.setAttribute("assetId", assetId);
        request.setAttribute("proList", proList);
        request.setAttribute("nameList", JSONArray.fromObject(nameList));
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
        asset.setStatus((short) 0);
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpName(asset))) {
            throw new ServiceException("企业名称已经存在");
        }
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpAbbreviation(asset))) {
            throw new ServiceException("企业简称已经存在");
        }
        p2PAssetService.updateByPrimaryKey(asset);
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/queryAsset", method = RequestMethod.POST)
    public Resp queryAsset(P2PAssetQueryReq req) {
        req.setStatus((short) 0);
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

        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpName(asset))) {
            throw new ServiceException("企业名称已经存在");
        }
        if (CollectionUtils.isNotEmpty(p2PAssetService.checkCorpAbbreviation(asset))) {
            throw new ServiceException("企业简称已经存在");
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
        product.setStatus("0");
        product.setId(IdUtil.geneId());
        product.setLastmodTime(new Date());
        if (CollectionUtils.isNotEmpty(productService.checkByProductCode(product))) {
            throw new ServiceException("产品代码已经存在");
        }
        if (CollectionUtils.isNotEmpty(productService.checkAssetProductType(product))) {
            throw new ServiceException("资产方已配置过此类产品");
        }
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
        product.setStatus("0");
        product.setLastmodTime(new Date());
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
