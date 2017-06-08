package cn.sunfit.risk.web.controller.contract;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
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

import cn.sunfit.risk.buz.api.beans.contract.CheckTempNameExisitReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractFieldRel;
import cn.sunfit.risk.buz.api.beans.contract.ContractFieldSaveReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractTemplate;
import cn.sunfit.risk.buz.api.beans.contract.ProductVO;
import cn.sunfit.risk.buz.api.beans.contract.TempIdDTO;
import cn.sunfit.risk.buz.api.beans.corp.Resources;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.service.contract.ContractTemplateService;
import cn.sunfit.risk.buz.api.service.corp.ResourcesService;
import cn.sunfit.risk.buz.api.service.product.contract.ProductContractService;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.contract.ConTempQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ConTempSaveReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.product.ProductContractFields;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.buz.api.vo.system.partner.RoleConfigShowVO;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.OSSUtil;

import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

@Controller
@RequestMapping("/contract/template")
public class ContractTemplateController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(ContractTemplateController.class);

    @Autowired
    private ContractTemplateService contractTemplateService;

    @Autowired
    private ContractPartnerService contractPartnerService;

    @Autowired
    private OSSUtil oSSUtil;

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private ProductContractService productContractService;

    /**
     * 
     * @Title: checkNameExist
     * @Description: 检查是否已经存在合同名
     * @param @param req
     * @param @return   
     * @return Map<String,Object> 
     * @author RJS 2017年3月9日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/checkNameExist", method = RequestMethod.POST)
    public Map<String, Object> checkNameExist(CheckTempNameExisitReq req) {
        Map<String, Object> result = new HashMap<String, Object>();
        req.setCorpInfo(getCurrentUser());
        int count = contractTemplateService.getCountByName(req);
        if (count > 0) {
            result.put("valid", false);
        } else {
            result.put("valid", true);
        }
        return result;
    }

    /**
     * 
     * @Title: disableTemplate
     * @Description: 停用模板
     * @param @param tmpId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/disableTemplate", method = RequestMethod.POST)
    public Resp disableTemplate(String tmpId) {
        if (StringUtils.isBlank(tmpId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        ContractTemplate ct = contractTemplateService.selectById(new TempIdDTO(user.getDomain(), tmpId));
        if (ct != null && ct.getStatus() == 0) {
            return Resp.buildErrorResponse("该合同模板已经停用，请不要重复操作");
        }
        contractTemplateService.disableTempById(new TempIdDTO(user.getDomain(), tmpId));
        return new Resp();
    }

    /**
     * 
     * @Title: getTempFields
     * @Description: 获取模板字段
     * @param @param resourceId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月17日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getTempFields", method = RequestMethod.GET)
    public Resp getTempFields(String tempId) {
        if (StringUtils.isBlank(tempId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        ContractTemplate ct = contractTemplateService.selectById(new TempIdDTO(user.getDomain(), tempId));
        if (ct == null) {
            return Resp.buildErrorResponse("获取模板数据失败");
        }
        Resources result = resourcesService
                .queryResourcesById(user.getCorpId(), ct.getFileResource(), user.getDomain());

        List<ProductContractFields> contractFieldList = productContractService.getContractFields(ct.getProduct());
        List<ContractFieldRel> selectRelList = contractTemplateService.querySelectFieldRel(new TempIdDTO(user
                .getDomain(), tempId));
        try {
            String key = GlobalConstants.OSS_URL_HEADER + result.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfReader reader = new PdfReader(oSSUtil.downloadFile(key));
            PdfStamper stamp = new PdfStamper(reader, baos);
            AcroFields form = stamp.getAcroFields();
            Map<String, Object> fields = form.getFields();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("tempFields", fields.keySet());
            resultMap.put("dataFields", contractFieldList);
            resultMap.put("selectRelList", selectRelList);
            return new Resp(resultMap);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Resp.buildErrorResponse("获取模板文件失败");
        }
    }

    /**
     * 
     * @Title: getTemplate
     * @Description:获取合同模板
     * @param @param signId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getTemplate", method = RequestMethod.GET)
    public Resp getTemplate(String tempId) {
        if (StringUtils.isBlank(tempId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("未获取到用户公司信息");
        }
        TempIdDTO tempIdDTO = new TempIdDTO(user.getDomain(), tempId);
        ContractTemplate ct = contractTemplateService.selectById(tempIdDTO);
        if (ct != null) {
            ct.setPartnerList(contractPartnerService.querySelectedPartners(tempIdDTO));
        }
        return new Resp(ct);
    }

    /**
     * 
     * @Title: getTemplateView
     * @Description: 获取查看合同模板页面数据
     * @param @param tempId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月9日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getTemplateView", method = RequestMethod.GET)
    public Resp getTemplateView(String tempId) {
        Map<String, Object> result = new HashMap<String, Object>();
        if (StringUtils.isBlank(tempId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("未获取到用户公司信息");
        }
        TempIdDTO tempIdDTO = new TempIdDTO(user.getDomain(), tempId);
        ContractTemplate ct = contractTemplateService.selectById(tempIdDTO);
        if (ct != null) {
            ct.setPartnerList(contractPartnerService.querySelectedPartners(tempIdDTO));
        }
        result.put("ct", ct);

        List<ProductContractFields> contractFieldList = productContractService.getContractFields(ct.getProduct());
        List<ContractFieldRel> selectRelList = contractTemplateService.querySelectFieldRel(new TempIdDTO(user
                .getDomain(), tempId));
        result.put("dataFields", contractFieldList);
        result.put("selectRelList", selectRelList);

        List<RoleConfigShowVO> roleList = contractPartnerService.queryAllRoles(user.getDomain());
        result.put("roleList", roleList);
        return new Resp(result);
    }

    /**
     * 
     * @Title: loadTemplateManager
     * @Description: 加载合同模板初始页
     * @param @param request
     * @param @return   
     * @return String 
     * @author RJS 2017年2月6日 
     * @throws
     */
    @RequestMapping(value = "/loadTemplateManager", method = RequestMethod.GET)
    public String loadTemplateManager(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        if (user != null) {
            List<ProductVO> productList = contractTemplateService.queryProductList(user.getCorpId());
            request.setAttribute("productList", productList);
        }
        return "/contract/template/loadTemplateManager";
    }

    /**
     * 
     * @Title: queryAllPartner
     * @Description: 获取所有参与方
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月8日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryAllPartner", method = RequestMethod.GET)
    public Resp queryAllPartner() {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("未获取到用户公司信息");
        }

        List<PartnerSelectVO> partnerList = contractPartnerService.queryAllPartnerList(user.getDomain());
        return new Resp(partnerList);
    }

    /**
    * 
    * @Title: queryList
    * @Description: 查询合同模板列表数据
    * @param @param req
    * @param @return   
    * @return Resp 
    * @author RJS 2017年2月6日 
    * @throws
    */
    @ResponseBody
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    public Resp queryList(ConTempQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("未获取到用户公司信息");
        }
        req.setDomain(user.getDomain());
        RespPage<List<ContractTemplate>> info = contractTemplateService.queryList(req);
        return new Resp(info);
    }

    /**
     * 
     * @Title: saveContractTemplate
     * @Description: 保存合同模板
     * @param @param req
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月6日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/saveTemplate", method = RequestMethod.POST)
    public Resp saveContractTemplate(@Valid ConTempSaveReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("未获取到用户公司信息");
        }
        req.setDomain(user.getDomain());
        try {
            contractTemplateService.save(req);
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.buildErrorResponse(e.getMessage());
        }

        return new Resp();
    }

    /**
     * 
     * @Title: saveTemplateConfig
     * @Description: 保存字段配置
     * @param @param ContractFieldSaveReq
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月20日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/saveTemplateConfig", method = RequestMethod.POST)
    public Resp saveTemplateConfig(ContractFieldSaveReq req) {
        if (StringUtils.isBlank(req.getTempId()) || req.getDataFields() == null || req.getTempFields() == null
                || req.getDataFields().size() != req.getTempFields().size()) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<ContractFieldRel> fieldList = new ArrayList<ContractFieldRel>();
        for (int i = 0; i < req.getTempFields().size(); i++) {
            ContractFieldRel rel = new ContractFieldRel();
            rel.setTempId(req.getTempId());
            rel.setDataField(req.getDataFields().get(i));
            rel.setTempField(req.getTempFields().get(i));
            fieldList.add(rel);
        }
        contractTemplateService.saveContractFieldRel(new TempIdDTO(user.getDomain(), req.getTempId()), fieldList);
        return new Resp();
    }
}
