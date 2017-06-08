package cn.sunfit.risk.web.controller.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.log.LoginLog;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.constants.RiskSystem;
import cn.sunfit.risk.buz.api.service.p2p.activiti.BpService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.LoginHistoryReq;
import cn.sunfit.risk.buz.util.p2p.CustomerType;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
public class P2PIndexController extends BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(P2PIndexController.class);

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private BpService bpService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/p2pindex/changeSystem", method = RequestMethod.GET)
    public String changeSystem(String system) {
        CorpUserDTO user = getCurrentUser();
        user.setSystem(RiskSystem.getSystemByCode(system));
        return "redirect:/index";
    }

    @ResponseBody
    @RequestMapping(value = "/p2pindex/getBpMetaNodesByProduct", method = RequestMethod.GET)
    public Resp getBpMetaNodesByProduct(String product) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<BPMetaNode> list = bpService.selectBPMetaNodeByProduct(user.getDomain(), product);
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/p2pindex/queryTodoList", method = RequestMethod.POST)
    public Resp loadTodoListManager(TodoQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setCorpId(user.getCorpId());
        req.setUid(user.getId());
        RespPage<List<TodoQueryDTO>> list = bpService.selectTodoList(req);
        return new Resp(list);
    }

    @RequestMapping(value = "/p2pindex/loghistory", method = RequestMethod.POST)
    @ResponseBody
    public Resp loghistory(LoginHistoryReq req) {
        req.setUserId(getCurrentUser().getId());
        RespPage<List<LoginLog>> r = permissionService.queryLoginHistory(req);
        return new Resp(r);
    }

    @RequestMapping(value = "/p2pindex/settings", method = RequestMethod.GET)
    public String settings() {
        return "/index/settings";
    }

    @RequestMapping(value = "/p2pindex/toIndex", method = RequestMethod.GET)
    public String toIndex(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        if (RiskSystem.ZC.equals(user.getSystem())) {
            request.setAttribute("customerTypes", CustomerType.values());
            request.setAttribute("products", productService.queryProductByCorpId(user.getCorpId()));
            // request.setAttribute("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        }
        return "/index/loadIndexManager";
    }

}
