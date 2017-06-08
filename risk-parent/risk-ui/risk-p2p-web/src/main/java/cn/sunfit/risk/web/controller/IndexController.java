package cn.sunfit.risk.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.log.LoginLog;
import cn.sunfit.risk.buz.api.beans.p2p.ProductType;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.constants.RiskSystem;
import cn.sunfit.risk.buz.api.constants.order.CustomerType;
import cn.sunfit.risk.buz.api.constants.order.LoanHandleType;
import cn.sunfit.risk.buz.api.constants.order.OrderStatus;
import cn.sunfit.risk.buz.api.service.p2p.activiti.BpService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.p2p.productType.ProductTypeService;
import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.LoginHistoryReq;

@Controller
public class IndexController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private BpService bpService;

    @Autowired
    P2PProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @RequestMapping(value = "/index/changeSystem", method = RequestMethod.GET)
    public String changeSystem(String system) {
        CorpUserDTO user = getCurrentUser();
        user.setSystem(RiskSystem.getSystemByCode(system));
        return "redirect:/index";
    }

    @ResponseBody
    @RequestMapping(value = "/index/getBpMetaNodesByProduct", method = RequestMethod.GET)
    public Resp getBpMetaNodesByProduct(String product) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<BPMetaNode> list = bpService.selectBPMetaNodeByProduct(user.getDomain(), product);
        return new Resp(list);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/index/queryTodoList", method = RequestMethod.POST)
    public Resp loadTodoListManager(TodoQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setCorpId(user.getCorpId());
        req.setUid(user.getId());
        RespPage<List<TodoQueryDTO>> list = bpService.selectTodoList(req);
        for (TodoQueryDTO dto : list.getData()) {
            dto.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(dto.getCustLicenseNum()));
        }
        return new Resp(list);
    }

    @RequestMapping(value = "/index/loghistory", method = RequestMethod.POST)
    @ResponseBody
    public Resp loghistory(LoginHistoryReq req) {
        req.setUserId(getCurrentUser().getId());
        RespPage<List<LoginLog>> r = permissionService.queryLoginHistory(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/index/settings", method = RequestMethod.GET)
    public String settings() {
        return "/index/settings";
    }

    @RequestMapping(value = "/index/toIndex", method = RequestMethod.GET)
    public String toIndex(ModelMap map) {
        CorpUserDTO user = getCurrentUser();
        if (RiskSystem.P2P.equals(user.getSystem())) {
            List<ProductType> ls = productTypeService.findAll();
            map.put("producttypes", ls);
            map.put("orderStatus", OrderStatus.values());
            map.put("loanhandletypes", LoanHandleType.values());
            map.put("customertypes", CustomerType.values());
        }
        return "/index/loadIndexManager";
    }

    @RequestMapping(value = "/error/unauthorized", method = RequestMethod.GET)
    public String unauthorized() {
        return "/error/unauthorized";
    }
}
