package cn.sunfit.risk.web.controller.contract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.contract.ContractLoadReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractResource;
import cn.sunfit.risk.buz.api.service.contract.ContractResourceService;
import cn.sunfit.risk.buz.api.service.contract.ContractTemplateService;
import cn.sunfit.risk.buz.api.service.corp.ResourcesService;
import cn.sunfit.risk.buz.api.service.product.contract.ProductContractService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.contract.ContractGenerateReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.OSSUtil;

@Controller
@RequestMapping("/contract/resource")
public class ContractResourceController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(ContractResourceController.class);

    @Autowired
    private ContractTemplateService contractTemplateService;

    @Autowired
    private OSSUtil oSSUtil;

    @Autowired
    private ResourcesService resourcesService;

    @Autowired
    private ProductContractService productContractService;

    @Autowired
    private ContractResourceService contractResourceService;

    /**
     * 
     * @Title: generate
     * @Description: 生成合同
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年2月24日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/generate", method = RequestMethod.POST)
    public Resp generate(ContractGenerateReq req) {
        if (StringUtils.isEmpty(req.getBpId())) {
            return Resp.buildErrorResponse("参数错误");
        }
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        req.setCorpInfo(user);
        Resp resp = contractResourceService.generate(req);
        return resp;

    }

    /**
     * 
     * @Title: getContractByBpId
     * @Description: 获取合同资源ID
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryContractByBpId", method = RequestMethod.GET)
    public Resp queryContractByBpId(ContractLoadReq req) {
        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        req.setCorpInfo(user);
        List<ContractResource> resourceList = contractResourceService.queryByBpId(req.getBpId(), user.getDomain());
        for (ContractResource resource : resourceList) {
            Map<String, String> bean = new HashMap<String, String>();
            bean.put("resourceId", resource.getResource());
            bean.put("name", resource.getContractName());
            result.add(bean);
        }
        return new Resp(result);
    }
}
