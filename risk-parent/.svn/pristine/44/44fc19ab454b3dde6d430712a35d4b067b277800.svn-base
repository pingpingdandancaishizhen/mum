package cn.sunfit.risk.web.controller.loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.service.solution.AuditService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayResultVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryVO;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/loanaudit")
public class LoanAuditController extends BaseController {

    @Autowired
    private AuditService auditService;

    @Autowired
    private ProductService productService;

    @Autowired
    private BpService bpService;

    @ResponseBody
    @RequestMapping(value = "/getBpMetaNodesByProduct", method = RequestMethod.GET)
    public Resp getBpMetaNodesByProduct(String product) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<BPMetaNode> list = bpService.selectBPMetaNodeByProduct(user.getDomain(), product);
        List<BPMetaNode> auditList = new ArrayList<BPMetaNode>();
        for (BPMetaNode node : list) {
            if (node.isAudit()) {
                auditList.add(node);
            }
        }
        return new Resp(auditList);
    }

    /**
     * 
     * @Title: loadAllAuditManager
     * @Description: 加载审核查询页面
     * @param @return   
     * @return String 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/loadAllAuditManager")
    public String loadAllAuditManager(ModelMap map) {
        CorpUserDTO user = getCurrentUser();
        map.put("customerTypes", CustomerType.values());
        map.put("products", productService.queryProductByCorpId(user.getCorpId()));
        // map.put("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        return "/loanaudit/loadAllAuditManager";
    }

    /**
     * 
     * @Title: loadDayAuditManager
     * @Description: 加载日审核查询
     * @param @return   
     * @return String 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/loadDayAuditManager")
    public String loadDayAuditManager(ModelMap map) {
        // CorpUserDTO user = getCurrentUser();
        // map.put("products", productService.queryProductByCorpId(user.getCorpId()));
        return "/loanaudit/loadDayAuditManager";
    }

    /**
     * 
     * @Title: loadMyAuditManager
     * @Description: 加载我的审核
     * @param @return   
     * @return String 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/loadMyAuditManager")
    public String loadMyAuditManager(ModelMap map) {
        CorpUserDTO user = getCurrentUser();
        map.put("customerTypes", CustomerType.values());
        map.put("products", productService.queryProductByCorpId(user.getCorpId()));
        // map.put("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        return "/loanaudit/loadMyAuditManager";
    }

    /**
     * 
     * @Title: queryAllAuditManager
     * @Description: 查询审核列表
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/queryAllAuditManager")
    @ResponseBody
    public Resp queryAllAuditManager(LoanAuditQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        RespPage<List<LoanAuditQueryVO>> r = auditService.queryAllAuditList(req);
        for (LoanAuditQueryVO loan : r.getData()) {
            loan.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(loan.getCustLicenseNum()));
            loan.setCustMobile(HideInfoUtils.hidePhoneNo(loan.getCustMobile()));
        }
        return new Resp(r);
    }

    /**
     * @Title: queryAllHistoryAuditManager
     * @Description: 查询历史审核记录
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/queryAllHistoryAuditManager")
    @ResponseBody
    public Resp queryAllHistoryAuditManager(LoanAuditQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        RespPage<List<LoanAuditQueryVO>> r = auditService.queryAllHistoryAuditList(req);
        for (LoanAuditQueryVO loan : r.getData()) {
            loan.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(loan.getCustLicenseNum()));
            loan.setCustMobile(HideInfoUtils.hidePhoneNo(loan.getCustMobile()));
        }
        return new Resp(r);
    }

    /**
     * 
     * @Title: queryDayAuditManager
     * @Description: 查询日审核数据
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/queryDayAuditManager")
    @ResponseBody
    public Resp queryDayAuditManager(LoanAuditDayQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        Map<String, List<LoanAuditDayResultVO>> r = auditService.queryAuditDayList(req);
        return new Resp(r);
    }

    /**
     * 
     * @Title: queryMyAuditManager
     * @Description: 查询我的审核
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月1日 
     * @throws
     */
    @RequestMapping("/queryMyAuditManager")
    @ResponseBody
    public Resp queryMyAuditManager(LoanAuditQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        RespPage<List<LoanAuditQueryVO>> r = auditService.queryMyAuditList(req);
        for (LoanAuditQueryVO loan : r.getData()) {
            loan.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(loan.getCustLicenseNum()));
            loan.setCustMobile(HideInfoUtils.hidePhoneNo(loan.getCustMobile()));
        }
        return new Resp(r);
    }

}
