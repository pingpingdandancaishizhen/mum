package cn.sunfit.risk.web.controller.contract;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.contract.ContractResource;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.service.contract.ContractResourceService;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.contract.ContractDTO;
import cn.sunfit.risk.buz.api.vo.contract.ContractProcessedQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ContractProcessingQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ContractQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping("/contract/manager")
public class ContractManagerController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(ContractManagerController.class);

    public static final String CONTRACT_STATUS_PROCESSING = "1";

    public static final String CONTRACT_STATUS_PROCESSED = "2";

    @Autowired
    private BpService bpService;

    @Autowired
    ProductService productService;

    @Autowired
    private CorpDeptService corpDeptService;

    @Autowired
    private ContractResourceService contractResourceService;

    @ResponseBody
    @RequestMapping(value = "/getBpMetaNodesByProduct", method = RequestMethod.GET)
    public Resp getBpMetaNodesByProduct(String product) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<BPMetaNode> list = bpService.selectBPMetaNodeByProduct(user.getDomain(), product);
        return new Resp(list);
    }

    /**
     * 
     * @Title: processingList
     * @Description: 加载合同查询页
     * @param @return   
     * @return String 
     * @author RJS 2017年3月6日 
     * @throws
     */
    @RequestMapping(value = "/loadContractManager", method = RequestMethod.GET)
    public String loadContractManager(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        request.setAttribute("customerTypes", CustomerType.values());
        request.setAttribute("products", productService.queryProductByCorpId(user.getCorpId()));
        // request.setAttribute("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        request.setAttribute("deptList", corpDeptService.queryCoopDetps(user.getCorpId()));
        return "/contract/manager/loadContractManager";
    }

    /**
     * 
     * @Title: queryContractsByBp
     * @Description: 获取合同文件列表
     * @param @param bpId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryContractsByBp", method = RequestMethod.GET)
    public Resp queryContractsByBp(String bpId) {
        CorpUserDTO user = getCurrentUser();
        if (user == null || StringUtils.isBlank(user.getDomain())) {
            return new Resp("用户登录");
        }
        List<ContractResource> resourcrList = contractResourceService.queryByBpId(bpId, user.getDomain());
        return new Resp(resourcrList);
    }

    /**
     * 
     * @Title: queryProcessedList
     * @Description: 查询已归档的合同
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryProcessedList", method = RequestMethod.POST)
    public Resp queryProcessedList(ContractProcessedQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setCorpId(user.getCorpId());
        req.setUid(user.getId());
        ContractQueryReq request = req.copyToReq();
        request.setStatus(CONTRACT_STATUS_PROCESSED);
        if (StringUtils.isNotBlank(req.getDeptId_processed())) {
            request.setDeptIds(corpDeptService.getAllDeptIds(req.getDeptId_processed()));
        }
        RespPage<List<ContractDTO>> list = bpService.queryContractList(request);
        for (ContractDTO con : list.getData()) {
            con.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(con.getCustLicenseNum()));
            con.setCustMobile(HideInfoUtils.hidePhoneNo(con.getCustMobile()));
        }
        return new Resp(list);
    }

    /**
     * 
     * @Title: queryProcessingList
     * @Description: 查询办理中的合同
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月7日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryProcessingList", method = RequestMethod.POST)
    public Resp queryProcessingList(ContractProcessingQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setCorpId(user.getCorpId());
        req.setUid(user.getId());
        ContractQueryReq request = req.copyToReq();
        request.setStatus(CONTRACT_STATUS_PROCESSING);
        if (StringUtils.isNotBlank(req.getDeptId_processing())) {
            request.setDeptIds(corpDeptService.getAllDeptIds(req.getDeptId_processing()));
        }
        RespPage<List<ContractDTO>> list = bpService.queryContractList(request);
        for (ContractDTO con : list.getData()) {
            con.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(con.getCustLicenseNum()));
            con.setCustMobile(HideInfoUtils.hidePhoneNo(con.getCustMobile()));
        }
        return new Resp(list);
    }
}
