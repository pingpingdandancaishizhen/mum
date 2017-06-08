package cn.sunfit.risk.web.controller.generalinfo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.generalinfo.GeneralInfoExportBean;
import cn.sunfit.risk.buz.api.beans.generalinfo.GeneralInfoListBean;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.loan.LoanChannel;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.service.corp.CorpDeptService;
import cn.sunfit.risk.buz.api.service.generalinfo.GeneralInfoService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.generalinfo.GeneralInfoQueryReq;
import cn.sunfit.risk.buz.api.vo.solution.dyc.MonthlyFee;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.ExcelHandleUtil;

@Controller
@RequestMapping("/generalinfo")
public class GeneralInfoController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(GeneralInfoController.class);

    @Autowired
    private GeneralInfoService generalInfoService;

    @Autowired
    ProductService productService;

    @Autowired
    private BpService bpService;

    @Autowired
    ContractPartnerService contractPartnerService;

    @Autowired
    private CorpDeptService corpDeptService;

    @ResponseBody
    @RequestMapping(value = "/exportAllList", method = RequestMethod.GET)
    public Resp exportAllRepayment(GeneralInfoQueryReq req, HttpServletResponse response)
            throws UnsupportedEncodingException {
        req.Decode4Request();
        req.setCorpInfo(getCurrentUser());
        List<GeneralInfoListBean> page = generalInfoService.queryBaseList4Export(req);
        List<GeneralInfoExportBean> list = new ArrayList<GeneralInfoExportBean>();

        if (page != null && page.size() > 0) {
            for (GeneralInfoListBean bean : page) {
                GeneralInfoExportBean eb = new GeneralInfoExportBean(bean);
                list.add(eb);
                req.setCustId(bean.getCustId());
                List<GeneralInfoListBean> extList = generalInfoService.queryExtralList4Export(req);
                if (extList != null && extList.size() > 0) {
                    for (GeneralInfoListBean ext : extList) {
                        GeneralInfoExportBean ebe = new GeneralInfoExportBean(ext);
                        list.add(ebe);
                    }
                }
            }
        }
        try {
            response.reset();// 清空输出流
            response.setHeader("Content-disposition", "attachment; filename=" + "export.xls");
            // 设定输出文件头
            response.setContentType("application/msexcel");// 定义输出类型
            ExcelHandleUtil.exportExcel("综合查询", new String[] { "订单号", "订单来源", "放款平台", "产品", "客户名称", "主合同号", "身份证号",
                    "客户类型", "申请日期", "是否共同借款", "申请金额", "申请期限", "申请还款方式", "审批金额", "审批期限", "保证金", "合同金额", "审批还款方式",
                    "车牌号码", "所属门店", "借款性质", "订单状态", "审核状态", "放款时间", "还款状态", "已还期次", "标状态", "满标时间", "标还款方式" }, list,
                    response.getOutputStream(), GlobalConstants.DATE_FORMAT_DATE);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException("导出excel IO异常");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("导出excel 异常");
        }
        return new Resp();
    }

    /**
     * 
     * @Title: getBpMetaNodesByProduct
     * @Description: TODO
     * @param @param product
     * @param @return   
     * @return Resp 
     * @author RJS 2017年4月27日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getBpMetaNodesByProduct", method = RequestMethod.GET)
    public Resp getBpMetaNodesByProduct(String product) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        List<BPMetaNode> nodeList = bpService.selectBPMetaNodeByProduct(user.getDomain(), product);
        List<PartnerSelectVO> partnerList = contractPartnerService.queryLenderPartnerByProduct(product,
                user.getDomain());
        List<MonthlyFee> paridList = productService.queryMonthlyFee(product);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("nodeList", nodeList);
        data.put("partnerList", partnerList);
        data.put("paridList", paridList);
        return new Resp(data);
    }

    /**
     * 
     * @Title: loadGeneralInfoManager
     * @Description: 加载综合查询列表页
     * @param @return   
     * @return String 
     * @author RJS 2017年4月26日 
     * @throws
     */
    @RequestMapping(value = "/loadGeneralInfoManager", method = RequestMethod.GET)
    public String loadGeneralInfoManager(HttpServletRequest request) {
        CorpUserDTO user = getCurrentUser();
        request.setAttribute("products", productService.queryProductByCorpId(user.getCorpId()));
        request.setAttribute("deptList", corpDeptService.queryCoopDetps(user.getCorpId()));
        request.setAttribute("customerTypes", CustomerType.values());
        request.setAttribute("repayType", LoanRepaymentType.values());
        request.setAttribute("repayStatus", RepaymentBaseStatus.values());
        request.setAttribute("channels", LoanChannel.values());
        return "generalinfo/loadGeneralinfoManager";
    }

    /**
     * 
     * @Title: queryExtList
     * @Description: 查询历史订单数据
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年4月26日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryExtList", method = RequestMethod.POST)
    public Resp queryExtList(GeneralInfoQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        req.setCorpInfo(user);
        List<GeneralInfoListBean> list = generalInfoService.queryExtralList(req);
        return new Resp(list);
    }

    /**
     * 
     * @Title: queryList
     * @Description: 查询最新数据
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年4月26日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryNewList", method = RequestMethod.POST)
    public Resp queryNewList(GeneralInfoQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        if (user == null) {
            return Resp.buildErrorResponse("用户未登录");
        }
        req.setCorpInfo(user);
        RespPage<List<GeneralInfoListBean>> page = generalInfoService.queryBaseList(req);
        return new Resp(page);
    }
}
