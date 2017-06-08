package cn.sunfit.risk.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptListVO;
import cn.sunfit.risk.buz.api.beans.system.partner.CheckExisitNameCountReq;
import cn.sunfit.risk.buz.api.beans.system.partner.ContractPartner;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerListVO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductRel;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerProductRelSaveReq;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerRole;
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerQueryReq;
import cn.sunfit.risk.buz.api.vo.system.partner.ContractPartnerSaveReq;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.buz.api.vo.system.partner.RoleConfigShowVO;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping("/system/partner")
public class ContractPartnerController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(ContractPartnerController.class);

    @Autowired
    private ContractPartnerService contractPartnerService;

    @Autowired
    private CorpDeptService corpDeptService;

    /**
     * 
     * @Title: checkNameExist
     * @Description: 校验已存在的参与方名称
     * @param @param req
     * @param @return   
     * @return Map<String,Object> 
     * @author RJS 2017年3月10日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/checkNameExist", method = RequestMethod.POST)
    public Map<String, Object> checkNameExist(CheckExisitNameCountReq req) {
        Map<String, Object> result = new HashMap<String, Object>();
        req.setCorpInfo(getCurrentUser());
        int count = contractPartnerService.getExisitNameCount(req);
        if (count > 0) {
            result.put("valid", false);
        } else {
            result.put("valid", true);
        }
        return result;
    }

    /**
     * 
     * @Title: deletePartner
     * @Description: 删除参与方
     * @param @param partnerId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/deletePartner", method = RequestMethod.POST)
    public Resp deletePartner(String partnerId) {
        if (StringUtils.isBlank(partnerId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        PartnerIdDTO partnerDeleteDTO = new PartnerIdDTO(user.getDomain(), partnerId);
        int existCount = contractPartnerService.queryExisitCount(partnerDeleteDTO);
        if (existCount > 0) {
            return Resp.buildErrorResponse("参与方已经被使用，不能删除");
        }
        contractPartnerService.deletePartner(partnerDeleteDTO);
        return new Resp();
    }

    /**
     * 
     * @Title: getPartner
     * @Description: 获取参与方
     * @param @param partnerId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getPartner", method = RequestMethod.GET)
    public Resp getPartner(String partnerId) {
        if (StringUtils.isEmpty(partnerId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        PartnerIdDTO partnerIdDTO = new PartnerIdDTO(user.getDomain(), partnerId, user.getCorpId());
        ContractPartner partner = contractPartnerService.selectContractPartner(partnerIdDTO);
        return new Resp(partner);
    }

    /**
     * 
     * @Title: loadPartnerManager
     * @Description: 加载参与方初始页
     * @param @param request
     * @param @return   
     * @return String 
     * @author RJS 2017年2月6日 
     * @throws
     */
    @RequestMapping(value = "/loadPartnerManager", method = RequestMethod.GET)
    public String loadPartnerManager(HttpServletRequest request) {
        ContractPartner cp = new ContractPartner();
        CorpUserDTO user = getCurrentUser();
        if (user != null) {
            List<CorpDeptListVO> deptList = corpDeptService.queryCoopDetps(user.getCorpId());
            request.setAttribute("deptList", deptList);
        }

        request.setAttribute("partner", cp);
        return "/system/partner/loadPartnerManager";
    }

    /**
     * 
     * @Title: loadProductPartnerConfig
     * @Description: 加载合作方产品配置页面
     * @param @param request
     * @param @param proudctId
     * @param @return   
     * @return String 
     * @author RJS 2017年3月1日 
     * @throws
     */
    @RequestMapping(value = "/loadProductPartnerConfig", method = RequestMethod.GET)
    public String loadProductPartnerConfig(HttpServletRequest request, String productId) {
        request.setAttribute("productId", productId);
        CorpUserDTO user = getCurrentUser();
        if (user != null) {
            List<RoleConfigShowVO> roleList = contractPartnerService.queryAllRoles(user.getDomain());
            request.setAttribute("roleList", roleList);
        }

        return "/system/partner/productConfig";
    }

    /**
    * 
    * @Title: queryAllPartnerList
    * @Description: 查询参与方列表数据
    * @param @param req
    * @param @return   
    * @return Resp 
    * @author RJS 2017年2月6日 
    * @throws
    */
    @ResponseBody
    @RequestMapping(value = "/queryAllPartnerList", method = RequestMethod.GET)
    public Resp queryAllList(ContractPartnerQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("未获取到用户公司信息");
        }
        req.setDomain(user.getDomain());
        RespPage<List<PartnerListVO>> info = contractPartnerService.queryList(req);
        for (PartnerListVO par : info.getData()) {
            if ("1".equals(par.getType())) {// 法人
                par.setCode(HideInfoUtils.hideIdentificationCard(par.getCode()));
                par.setPhone(HideInfoUtils.hidePhoneNo(par.getPhone()));
            }
        }
        return new Resp(info);
    }

    /**
    * 
    * @Title: queryAllRoles
    * @Description: 获取所有参与方角色
    * @param @return   
    * @return Resp 
    * @author RJS 2017年2月23日 
    * @throws
    */
    @ResponseBody
    @RequestMapping(value = "/queryAllRoles", method = RequestMethod.GET)
    public Resp queryAllRoles() {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<PartnerRole> roleList = contractPartnerService.queryPartnerRoleList(user.getDomain());
        return new Resp(roleList);
    }

    /**
     * 
     * @Title: queryConfigByProduct
     * @Description: 获取已选择的关联
     * @param @param productId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月1日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryConfigByProduct", method = RequestMethod.GET)
    public Resp queryConfigByProduct(String productId) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<PartnerProductRel> relList = contractPartnerService.queryConfigByProduct(new ProductIdDTO(
                user.getDomain(), productId));
        return new Resp(relList);
    }

    /**
     * 
     * @Title: queryContactRoleListBySigner
     * @Description: 查询参与方已选的角色
     * @param @param partnerId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月13日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getRoleList", method = RequestMethod.GET)
    public Resp queryContactRoleListBySigner(String partnerId) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        PartnerIdDTO partnerIdDTO = new PartnerIdDTO(user.getDomain(), partnerId);
        List<PartnerRole> partnerRoleList = contractPartnerService.querySelectRoles(partnerIdDTO);
        return new Resp(partnerRoleList);
    }

    /**
     * 
     * @Title: queryPartnerByProduct
     * @Description: 根据产品获取参与方
     * @param @param productId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月2日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryPartnerByProduct", method = RequestMethod.GET)
    public Resp queryPartnerByProduct(String productId, String tempId) {
        Map<String, Object> result = new HashMap<String, Object>();
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<RoleConfigShowVO> roleList = contractPartnerService.queryRolesByProduct(new ProductIdDTO(user.getDomain(),
                productId));
        List<PartnerSelectVO> selects = contractPartnerService.querySelectedPartners(new TempIdDTO(user.getDomain(),
                tempId));
        result.put("roleList", roleList);
        result.put("selects", selects);
        return new Resp(result);
    }

    /**
     * 
     * @Title: queryPartnerRoleList
     * @Description: 查询参与方类别列表
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月9日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryPartnerRoleList", method = RequestMethod.GET)
    public Resp queryPartnerRoleList() {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<PartnerRole> partnerRoleList = contractPartnerService.queryPartnerRoleList(user.getDomain());
        return new Resp(partnerRoleList);
    }

    /**
     * 
     * @Title: savePartner
     * @Description: 保存参与方
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月6日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/savePartner", method = RequestMethod.POST)
    public Resp savePartner(@Valid ContractPartnerSaveReq req, BindingResult result) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(user);
        return contractPartnerService.saveContractPartner(req);
    }

    /**
     * 
     * @Title: saveProductConfig
     * @Description: 保存关联
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月1日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/saveProductConfig", method = RequestMethod.POST)
    public Resp saveProductConfig(PartnerProductRelSaveReq req) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        req.setCorpInfo(user);
        try {
            return contractPartnerService.savePartnerProductRels(req.copyToDTO());
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.buildErrorResponse("参数错误");
        }
    }

}
