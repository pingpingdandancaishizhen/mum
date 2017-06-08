package cn.sunfit.risk.web.controller.loan;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.service.activiti.AssignService;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.solution.SuperFormService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.loan.AssignReq;
import cn.sunfit.risk.buz.api.vo.loan.RestartReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/loanApply")
public class LoanApplyController extends BaseController {

    @Autowired
    BpService bpService;

    @Autowired
    ProductService productService;
    @Autowired
    private AssignService assignService;
    @Autowired
    private SuperFormService superFormService;

    @ResponseBody
    @RequestMapping(value = "/assign", method = RequestMethod.POST)
    public Resp assign(@Valid AssignReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        CorpUserDTO user = getCurrentUser();
        req.setCorpInfo(user);
        assignService.assignBp2Other(req);
        return new Resp();
    }

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

    @RequestMapping(value = "/allLoan/loadAllLoanManager", method = RequestMethod.GET)
    public String loadAllLoanManager(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        request.setAttribute("customerTypes", CustomerType.values());
        request.setAttribute("products", productService.queryProductByCorpId(user.getCorpId()));
        // request.setAttribute("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        return "/myLoan/loadAllLoanManager";
    }

    /**
     * 
     * @Title: loadMyLoanManager
     * @Description: 加载我的借款初始页
     * @param @return   
     * @return String 
     * @author XJ 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/myLoan/loadMyLoanManager", method = RequestMethod.GET)
    public String loadMyLoanManager(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        request.setAttribute("customerTypes", CustomerType.values());
        request.setAttribute("products", productService.queryProductByCorpId(user.getCorpId()));
        // request.setAttribute("bpMetaNodes", bpService.selectAllBPMetaNode(user.getDomain()));
        return "/myLoan/loadMyLoanManager";
    }

    /**
     * 
     * @Title: queryAllLoanList
     * @Description: 查询我的借款信息
     * @param @return   
     * @return Resp 
     * @author XJ 2017年1月11日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/allLoan/queryAllLoanList", method = RequestMethod.POST)
    public Resp queryAllLoanList(BpQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUid(user.getId());
        req.setCorpId(user.getCorpId());
        RespPage<List<BpQueryDTO>> info = bpService.selectAllLoanList(req);
        for (BpQueryDTO bp : info.getData()) {
            bp.setCustMobile(HideInfoUtils.hidePhoneNo(bp.getCustMobile()));
            bp.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(bp.getCustLicenseNum()));
        }
        return new Resp(info);
    }

    /**
     * 
     * @Title: queryMyLoanList
     * @Description: 查询我的借款信息
     * @param @return   
     * @return Resp 
     * @author XJ 2017年1月11日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/myLoan/queryMyLoanList", method = RequestMethod.POST)
    public Resp queryMyLoanList(BpQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUid(user.getId());
        req.setCorpId(user.getCorpId());
        RespPage<List<BpQueryDTO>> info = bpService.selectMyLoanList(req);
        for (BpQueryDTO bp : info.getData()) {
            bp.setCustMobile(HideInfoUtils.hidePhoneNo(bp.getCustMobile()));
            bp.setCustLicenseNum(HideInfoUtils.hideIdentificationCard(bp.getCustLicenseNum()));
        }
        return new Resp(info);
    }

    @ResponseBody
    @RequestMapping(value = "/restart", method = RequestMethod.POST)
    public Resp restart(@Valid RestartReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        CorpUserDTO user = getCurrentUser();
        req.setCorpInfo(user);
        superFormService.restart(req);
        return new Resp();
    }

}
