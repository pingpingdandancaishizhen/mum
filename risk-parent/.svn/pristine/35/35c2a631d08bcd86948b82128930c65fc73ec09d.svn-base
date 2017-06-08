package cn.sunfit.risk.web.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.log.LoginLog;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.constants.RiskSystem;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.customer.GenderType;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.corp.CorpUserService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryReq;
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
    ProductService productService;
    @Autowired
    private CorpDeptService corpDeptService;
    @Autowired
    private CorpUserService corpUserService;

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
        for (TodoQueryDTO todo : list.getData()) {
            todo.setCustMobile(HideInfoUtils.hidePhoneNo(todo.getCustMobile()));
            todo.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(todo.getCustLicenseNum()));
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
    public String toIndex(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        List<Product> productList = productService.queryProductByCorpId(getCurrentUser().getCorpId());
        List<CorpDept> corpDeptList = corpDeptService.selectAvailableCorpDeptByType(getCurrentUser().getCorpId(),1);
        Map<String,List<CorpUserDTO>> corpUserMap = new LinkedHashMap<String, List<CorpUserDTO>>();
        for(CorpDept corpDept : corpDeptList){
        	List<CorpUserDTO> list = corpUserService.queryUserListByDeptId(corpDept.getId());
        	corpUserMap.put(corpDept.getId(), list);
        }
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        request.setAttribute("productList", productList);
        request.setAttribute("corpDeptList",corpDeptList);
        request.setAttribute("corpUserMap",corpUserMap);
        if (RiskSystem.ZC.equals(user.getSystem())) {
            request.setAttribute("customerTypes", CustomerType.values());
            request.setAttribute("products", productService.queryProductByCorpId(user.getCorpId()));
            // request.setAttribute("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        }
        return "/index/loadIndexManager";
    }

    @RequestMapping(value = "/error/unauthorized", method = RequestMethod.GET)
    public String unauthorized() {
        return "/error/unauthorized";
    }
}
