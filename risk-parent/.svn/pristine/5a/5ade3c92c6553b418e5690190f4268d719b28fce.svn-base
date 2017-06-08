package cn.sunfit.risk.web.controller.order;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import orj.worf.util.JsonUtils;
import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.p2p.ApiReq;
import cn.sunfit.risk.buz.api.beans.p2p.P2PCustOperLog;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.ProductType;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.constants.form.FormModelType;
import cn.sunfit.risk.buz.api.constants.form.OperationType;
import cn.sunfit.risk.buz.api.constants.order.CustomerType;
import cn.sunfit.risk.buz.api.constants.order.LoanHandleType;
import cn.sunfit.risk.buz.api.constants.order.OrderStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.p2p.activiti.OperLogService;
import cn.sunfit.risk.buz.api.service.p2p.activiti.SuperFormService;
import cn.sunfit.risk.buz.api.service.p2p.excel.OperationLogService;
import cn.sunfit.risk.buz.api.service.p2p.imp.ImportOrderService;
import cn.sunfit.risk.buz.api.service.p2p.order.OrderService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.service.p2p.productType.ProductTypeService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormData;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogReq;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogReviewVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.OperLogSimpleVO;
import cn.sunfit.risk.buz.api.vo.p2p.excel.LoanInfoQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportResult;
import cn.sunfit.risk.buz.api.vo.p2p.order.OrderListBean;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.BzjFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.BzjResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydDayFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydMonthlyFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.DaylyResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.MonthlyResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.OtherFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.OtherResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.ParkResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.Term;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.WyFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.WyjResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.ZnFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.ZnjResFee;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.ZxResFee;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.dto.LoanInfo;
import cn.sunfit.risk.web.service.OrderUtilService;
import cn.sunfit.risk.web.utils.LoanInfoRequest;
import cn.sunfit.risk.web.utils.OSSUtil;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {
    public static void main(String[] args) {
        String price_CNY = "5";
        Double cny = Double.parseDouble(price_CNY);// 转换成Double
        DecimalFormat df = new DecimalFormat("0.00");// 格式化
        String CNY = df.format(cny);
        System.out.println(CNY);
    }

    @Autowired
    P2PProductService p2PProductService;
    @Autowired
    private OSSUtil OSSUtil;
    @Autowired
    private OrderUtilService orderUtilService;
    @Autowired
    private OperationLogService operationLogService;
    @Autowired
    private SuperFormService superFormService;
    @Autowired
    private OperLogService operLogService;
    @Autowired
    private ImportOrderService importOrderService;
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductTypeService productTypeService;

    @ResponseBody
    @RequestMapping(value = "/batchSubmit", method = RequestMethod.POST)
    public Resp batchSubmit(@RequestParam("ids[]") Long[] ids) {
        Resp resp = new Resp();
        try {
            logger.info("批量提交ids{}", ids);
            orderService.batchSubmit(getCurrentUser(), ids);
            return resp;
        } catch (Exception e) {
            return Resp.buildErrorResponse("批量提交失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/cancle", method = RequestMethod.POST)
    public Resp cancle(@RequestParam("ids[]") Long[] ids) {
        Resp resp = new Resp();
        try {
            logger.info("作废ids{}", ids);
            orderService.cancle(getCurrentUser(), ids);
            return resp;
        } catch (Exception e) {
            return Resp.buildErrorResponse("批量提交失败");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Resp fileUpload(@RequestParam(required = true) MultipartFile file,
            @RequestParam(required = true) String productCode) {
        Resp resp = new Resp();
        if (file.isEmpty())
            return Resp.buildErrorResponse("导入文件失败！");
        List<Map<String, Object>> dataList = null;
        try {
            CorpUserDTO user = getCurrentUser();
            String importCode = IdUtil.geneId();
            ImportResult result = importOrderService.importExcel(user, file.getBytes(), productCode, importCode);
            resp.setData(result);
        } catch (IOException e) {
            e.printStackTrace();
            return Resp.buildErrorResponse("导入文件失败！", e);
        }
        return resp;
    }

    /**
     * 
     * @Title: getFormData
     * @Description: 获取表单
     * @param @return   
     * @return Resp 
     * @author DELL 2017年4月17日 
     * @throws
     */
    @RequestMapping(value = "/getFormData", method = RequestMethod.GET)
    @ResponseBody
    public Resp getFormData(@Valid FormQuery req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        // 如果是taskId是空，那么是开始表单任务
        req.setCorpInfo(getCurrentUser());
        FormData formdata;
        if (FormModelType.isView(req.getModel())) {
            formdata = superFormService.queryNodeFormData4View(req);
        } else if (FormModelType.isHandle(req.getModel())) {
            formdata = superFormService.queryNodeFormData(req);
        } else if (FormModelType.isEdit(req.getModel())) {
            formdata = superFormService.queryNodeFormData4Edit(req);
        } else {
            throw new ServiceException("不支持此模式");
        }
        return new Resp(formdata);
    }

    /*
     * @ResponseBody
     * @RequestMapping(value = "/removeAttach", method = RequestMethod.POST) public Resp
     * loadAllLoanByCustomer(@RequestParam(required = true) String attachId) { try { //
     * importExcelTemplateService.backupAttach(attachId); // importExcelTemplateService.removeAttach(attachId); return
     * new Resp("success!"); } catch (Exception e) { return Resp.buildErrorResponse("删除失败", 0); } }
     */

    /**
     * 获取参数
     * @param req
     * @param aresult
     * @return
     */
    @RequestMapping(value = "/getFormParam", method = RequestMethod.POST)
    @ResponseBody
    public Resp getFormParam(@Valid FormQuery req, BindingResult aresult) {
        Resp a = buildValidationFaildResponse(aresult);
        if (a.getStatus() == DATA_VALIDATION_ERROR) {
            return a;
        }
        BpMetaQueryReq s = new BpMetaQueryReq();
        s.setCorpInfo(getCurrentUser());
        s.setLastest(true);
        s.setProductId(req.getProductId());
        BpMetaCorpProductVO vo = p2PProductService.queryMetaByProduct(s);
        if (vo == null) {
            throw new ServiceException("流程查询异常");
        } else {
            if (!StringUtils.contains(vo.getVersion(), ":")) {
                throw new ServiceException("流程未部署");
            }
            req.setBpDefId(vo.getBpDefId());
            req.setBpDefKey(vo.getBpDefKey());
            req.setDeptId(getCurrentUser().getDeptId());
            req.setView(FormModelType.isView(req.getModel()));
            return new Resp(req);
        }
    }

    /**
         * 
         * @Title: getRates
         * @Description: 根据产品编码，贷款金额，还款期限获取该产品的各种汇率
         * @param @param req
         * @param @return   
         * @return Resp 
         * @author RJS 2017年5月8日 
         * @throws
         */
    @ResponseBody
    @RequestMapping(value = "/getRates", method = RequestMethod.POST)
    public Resp getRates(@Valid LoanInfoRequest req) {
        Resp resp = new Resp();
        Map res = new HashMap();
        P2PProduct products = p2PProductService.findByProductCode(req.getProductCode(), getCurrentUser().getDomain());
        if (products == null) {
            return Resp.buildErrorResponse("此订单的产品不存在！");
        }
        CydFeeConfig feeConfig = null;
        try {
            feeConfig = JsonUtils.parseJSON(products.getFeeConfig(), CydFeeConfig.class);

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("产品配置出错");
        }

        BigDecimal money = new BigDecimal(req.getLoanMoney());
        boolean flag = false;

        // 月利率
        List<CydMonthlyFee> months = feeConfig.getMonthlyFee();
        if (!CollectionUtils.isEmpty(months)) {
            for (CydMonthlyFee m : months) {
                if (m.getRepaymentType().equals(req.getRepaymentType())) {
                    MonthlyResFee mf = new MonthlyResFee();
                    mf.setStart(m.getStart());
                    mf.setEnd(m.getEnd());
                    res.put("loan_fee_monthlyZHFee", mf);
                    break;
                }
            }
        }

        // 日利率
        List<CydDayFee> dayss = feeConfig.getDaylyFee();
        if (!CollectionUtils.isEmpty(dayss)) {
            for (CydDayFee d : dayss) {
                if (d.getRepaymentType().equals(req.getRepaymentType())) {
                    DaylyResFee df = new DaylyResFee();
                    df.setStart(d.getStart());
                    df.setEnd(d.getEnd());
                    res.put("loan_fee_daylyZHFee", df);
                    break;
                }
            }
        }

        // 违约
        List<WyFee> wyfees = feeConfig.getWyFee();
        if (!CollectionUtils.isEmpty(wyfees)) {
            flag = false;
            WyjResFee wyF = new WyjResFee();
            List<String> wyFs = new ArrayList<String>();
            for (WyFee wy : wyfees) {
                if (new BigDecimal(wy.getWylStart()).compareTo(money) <= 0
                        && new BigDecimal(wy.getWylEnd()).compareTo(money) >= 0) {
                    wyFs.add(new DecimalFormat("0.00").format(wy.getWylFee()));
                    flag = true;
                }

            }
            wyF.setFee(wyFs);
            res.put("loan_fee_wyj", wyF);

            if (!flag) {
                throw new ServiceException("该贷款范围内的违约金未配置,请修改贷款金额");
            }

        }
        if (CollectionUtils.isEmpty(wyfees)) {
            throw new ServiceException("该贷款范围内的违约金未配置,请修改贷款金额");
        }

        // 滞纳
        List<ZnFee> znfees = feeConfig.getZnFee();
        if (!CollectionUtils.isEmpty(znfees)) {
            if (org.springframework.util.StringUtils.isEmpty(znfees.get(0).getTermText())) {
                // 按借款金额配置
                flag = false;
                ZnjResFee zn = new ZnjResFee();
                List<String> znFs = new ArrayList<String>();
                for (ZnFee zf : znfees) {
                    if (new BigDecimal(zf.getZnlStart()).compareTo(money) <= 0
                            && new BigDecimal(zf.getZnlEnd()).compareTo(money) >= 0) {
                        znFs.add(new DecimalFormat("0.00").format(zf.getZnlFee()));
                        flag = true;
                    }

                }
                zn.setFee(znFs);
                res.put("loan_fee_znj", zn);
                if (!flag) {
                    throw new ServiceException("该贷款范围内的滞纳金未配置,请修改贷款金额");
                }

            } else {// 按借款期限配置
                ZnjResFee zn = new ZnjResFee();
                List<String> znFs = new ArrayList<String>();

                if (req.getTerm().indexOf("M") == -1) {// 天标选'是'
                    for (ZnFee zf : znfees) {
                        List<Term> daylyTerm = new ArrayList<Term>();

                        String termt = zf.getTermVal();
                        if (termt.indexOf("D") != -1) {
                            String[] days = termt.split(",");
                            int start = Integer.parseInt(days[0].substring(1, days[0].length()));
                            int end = Integer.parseInt(days[1].substring(1, days[1].length()));
                            if (Integer.parseInt(req.getTerm()) >= start && Integer.parseInt(req.getTerm()) <= end) {
                                znFs.add(new DecimalFormat("0.00").format(zf.getZnlRate()));
                                break;
                            }
                        }
                    }
                }

                if (req.getTerm().indexOf("M") != -1) {// 天标选'否'
                    for (ZnFee zf : znfees) {
                        if (zf.getTermVal().equals(req.getTerm())) {
                            znFs.add(new DecimalFormat("0.00").format(zf.getZnlRate()));
                        }
                    }
                }

                zn.setFee(znFs);
                res.put("loan_fee_znj", zn);

            }
        }

        if (CollectionUtils.isEmpty(znfees)) {
            throw new ServiceException("滞纳金未配置,请联系后台");
        }

        // 咨询

        if (feeConfig.getZxfType() == 1) {
            ZxResFee zx = new ZxResFee();
            zx.setEnd(feeConfig.getZxfee().getEnd());
            zx.setStart(feeConfig.getZxfee().getStart());
            res.put("loan_fee_consulting", zx);
        }

        // 保证

        if (feeConfig.getBzjType() == 1) {
            List<BzjFee> BzjFees = feeConfig.getBzjFee();
            if (!CollectionUtils.isEmpty(BzjFees)) {
                flag = false;
                BzjResFee bzFee = new BzjResFee();
                List<String> bzFs = new ArrayList<String>();
                for (BzjFee bz : BzjFees) {
                    if (new BigDecimal(bz.getBzjStart()).compareTo(money) <= 0
                            && new BigDecimal(bz.getBzjEnd()).compareTo(money) >= 0) {
                        bzFs.add(new DecimalFormat("0.00").format(bz.getBzjFee()));
                        flag = true;
                    }

                }
                bzFee.setFee(bzFs);
                res.put("loan_fee_bzj", bzFee);
                if (!flag) {
                    throw new ServiceException("该贷款范围内的保证金费用未配置,请修改贷款金额");
                }
            }

            if (CollectionUtils.isEmpty(BzjFees)) {
                throw new ServiceException("该贷款范围内的保证金费用未配置,请修改贷款金额");
            }
        }

        // 其他费用
        if (1 == feeConfig.getOtherType()) {
            List<OtherFee> otherfees = feeConfig.getOtherFee();
            if (!CollectionUtils.isEmpty(otherfees)) {
                flag = false;
                OtherResFee otherFee = new OtherResFee();
                List<String> otherFs = new ArrayList<String>();
                for (OtherFee wy : otherfees) {
                    if (new BigDecimal(wy.getOtherStart()).compareTo(money) <= 0
                            && new BigDecimal(wy.getOtherEnd()).compareTo(money) >= 0) {

                        otherFs.add(new DecimalFormat("0.00").format(wy.getOtherFee()));
                        flag = true;
                    }

                }
                otherFee.setFee(otherFs);
                res.put("loan_fee_other", otherFee);
                if (!flag) {
                    throw new ServiceException("该贷款范围内的其他费用未配置,请修改贷款金额");
                }
            }
            if (CollectionUtils.isEmpty(otherfees)) {
                throw new ServiceException("该贷款范围内的其他费用未配置,请修改贷款金额");
            }

        }

        // gps
        if (feeConfig.getGpsType() == 1) {
            res.put("loan_fee_gpsinstall", feeConfig.getGpsFirstFee());
        }

        if (feeConfig.getGpsType() == 1) {
            res.put("loan_fee_gpsservice", feeConfig.getGpsServiceFee());
        }

        // 停车
        if (1 == feeConfig.getParkType()) {
            ParkResFee park = new ParkResFee();
            park.setStart(feeConfig.getParkFee().getStart());
            park.setEnd(feeConfig.getParkFee().getEnd());
            res.put("loan_fee_park", park);

        }
        resp.setData(res);
        return resp;

    }

    /**
     * @Title: loadAllLoanByCustomer
     * @Description: 相同客户历史订单
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author DELL 2017年5月4日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/loadAllLoanByCustomer", method = RequestMethod.POST)
    public Resp loadAllLoanByCustomer(LoanInfoQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        List<OrderListBean> list = orderService.queryCustAllLoanInfo(req);
        for (OrderListBean o : list) {
            o.setEidCard(HideInfoUtils.hideIdentificationCard(o.getIdCard()));
            o.setMobilePhone(HideInfoUtils.hidePhoneNo(o.getMobilePhone()));
        }
        return new Resp(list);
    }

    /**
     * 
     * @Title: loadAllLoanManager
     * @Description: 订单列表数据
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author DELL 2017年5月4日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/loadAllLoanManager", method = RequestMethod.POST)
    public Resp loadAllLoanManager(LoanInfoQueryReq req) {
        req.setCorpInfo(getCurrentUser());
        RespPage<List<OrderListBean>> info = orderService.queryLoanInfoList(req);
        for (OrderListBean o : info.getData()) {
            o.setEidCard(HideInfoUtils.hideIdentificationCard(o.getIdCard()));
            o.setMobilePhone(HideInfoUtils.hidePhoneNo(o.getMobilePhone()));
        }
        return new Resp(info);
    }

    /**
     * 
     * @Title: loadAllLoanManager
     * @Description: 订单列表
     * @param @param request
     * @param @return   
     * @return String 
     * @author DELL 2017年5月4日 
     * @throws
     */
    @RequestMapping(value = "/loadOrderManager", method = RequestMethod.GET)
    public String loadAllLoanManager(ModelMap map) {
        // 查询所有产品
        List<ProductType> ls = productTypeService.findAll();
        List<P2PProduct> lss = p2PProductService.queryAllRiskProduct(getCurrentUser().getDomain());
        map.put("products", lss);
        map.put("producttypes", ls);
        map.put("orderStatus", OrderStatus.values());
        map.put("loanhandletypes", LoanHandleType.values());
        map.put("customertypes", CustomerType.values());
        CorpUserDTO user = getCurrentUser();
        return "/order/loadOrderManager";
    }

    // getFeeConfig

    /**
     * 
     * @Title: loanInfoPlugin
     * @Description: 订单编辑页面的前端插件的接口一：根据产品编码获取该产品的还款方式和对应的还款期限
     * @param @param productCode
     * @param @return   
     * @return Resp 
     * @author wangguang 2017年5月8日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/loanInfoPlugin", method = RequestMethod.POST)
    public Resp loanInfoPlugin(String productCode) {
        Resp resp = new Resp();
        P2PProduct pro = p2PProductService.findByProductCode(productCode, getCurrentUser().getDomain());
        if (pro == null) {
            return Resp.buildErrorResponse("此订单的产品不存在！");
        }
        CydFeeConfig feeConfig = null;
        Map dataRes = new HashMap();

        List infos = new ArrayList<LoanInfoBean>();
        try {
            feeConfig = JsonUtils.parseJSON(pro.getFeeConfig(), CydFeeConfig.class);
            LoanInfo info = null;
            List<Term> monthlyTerm = new ArrayList<Term>();
            List<Term> daylyTerm = new ArrayList<Term>();
            for (Term term : feeConfig.getTerms()) {
                if (term.getTerm().indexOf("M") != -1) {
                    monthlyTerm.add(term);
                }
                if (term.getTerm().indexOf("D") != -1) {
                    daylyTerm.add(term);
                }
            }
            for (cn.sunfit.risk.buz.api.vo.p2p.product.config.RepaymentType re : feeConfig.getRepaymentTypes()) {
                info = new LoanInfo();
                info.setTerms(monthlyTerm);
                info.setRepaymentType(re.getRepaymentType());
                info.setRepaymentTypeName(re.getRepaymentTypeName());
                infos.add(info);
            }
            dataRes.put("dataArr", infos);

            List daylyTerms = new ArrayList<List>();
            if (!CollectionUtils.isEmpty(daylyTerm)) {
                List daylyT = null;
                for (Term term : daylyTerm) {
                    daylyT = new ArrayList<Integer>();
                    String[] days = term.getTerm().split(",");
                    daylyT.add(days[0].substring(1, days[0].length()));
                    daylyT.add(days[1].substring(1, days[1].length()));
                }
                if (daylyT != null) {
                    daylyTerms.add(daylyT);
                }
                dataRes.put("daylyTerm", daylyTerms);
            }

            resp.setData(dataRes);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("产品配置出错");
        }

        return resp;
    }

    /**
     * @Title: orderEdit
     * @Description: 编辑订单
     * @param @param req
     * @param @param data
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author DELL 2017年5月5日 
     * @throws
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Resp orderEdit(@Valid FormQuery req, String data, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        Map<String, String> formdata = JsonUtils.parseJSON(data, Map.class, String.class, String.class);
        logger.debug("提交订单参数{}", formdata);
        if (FormModelType.isHandle(req.getModel()) || FormModelType.isEdit(req.getModel())) {
            P2PProduct products = p2PProductService.findByProductCode(req.getProductId(), req.getDomain());
            if (products == null) {
                return Resp.buildErrorResponse("此订单的产品不存在！");
            }
            CydFeeConfig feeConfig = null;
            feeConfig = JsonUtils.parseJSON(products.getFeeConfig(), CydFeeConfig.class);
            formdata.put("to_node", feeConfig.getAutoTypeCheck() == null ? "" : feeConfig.getAutoTypeCheck());
            superFormService.submit(req, formdata);
        }
        // else if (FormModelType.isEdit(req.getModel())) {
        // superFormService.editFormData(req, formdata);
        // }
        else {
            throw new ServiceException("不支持此模式修改草稿");
        }

        return new Resp();
    }

    /**
     * @Title: orderEditDraft
     * @Description: 保存草稿
     * @param @param req
     * @param @param data
     * @param @param result
     * @param @return   
     * @return Resp 
     * @author DELL 2017年5月5日 
     * @throws
     */
    @RequestMapping(value = "/saveDraft", method = RequestMethod.POST)
    @ResponseBody
    public Resp orderEditDraft(@Valid FormQuery req, String data, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        Map<String, String> formdata = JsonUtils.parseJSON(data, Map.class, String.class, String.class);
        logger.debug("提交草稿订单参数{}", formdata);
        if (FormModelType.isHandle(req.getModel())) {
            superFormService.saveDraft(req, formdata);
        } else if (FormModelType.isEdit(req.getModel())) {
            superFormService.editFormDataDraft(req, formdata);
        } else {
            throw new ServiceException("不支持此模式修改草稿");
        }
        superFormService.editFormDataDraft(req, formdata);
        return new Resp();
    }

    /*
     * @RequestMapping(value = "/uploadLoanAttach", method = RequestMethod.POST)
     * @ResponseBody public Resp uploadCorpLogo(@RequestParam(required = true) MultipartFile file,
     * @RequestParam(required = true) String loanInfoId, @RequestParam(required = true) String attachGroup,
     * @RequestParam(required = true) String attachType) { Long size = file.getSize(); if (size > 10 * 1024 * 1024) {
     * return Resp.buildErrorResponse("上传文件大小超过10M，请重新上传！", ""); } SimpleDateFormat dateFormat = new
     * SimpleDateFormat("yyyyMMddHHmmss"); String suffix = file.getOriginalFilename().toString()
     * .substring(file.getOriginalFilename().toString().lastIndexOf(".")); String key =
     * UrlUtil.getLOGOUrl("p2puploader", dateFormat.format(new Date()), suffix); try { OSSUtil.uploadFile(key,
     * file.getBytes()); } catch (IOException e) { logger.error("file getBytes exception," + e.getMessage()); throw new
     * RuntimeException("file getBytes exception," + e.getMessage()); } CorpUserDTO user = getCurrentUser(); String
     * coverUrl = OSSUtil.buildUrl(key); LoanInfoAttachment loanInfoAttachment = new LoanInfoAttachment();
     * loanInfoAttachment.setAttachSize(String.valueOf(size));
     * loanInfoAttachment.setAttachOldName(file.getOriginalFilename().toString()); String[] keys = key.split("/");
     * loanInfoAttachment.setAttachNewName(keys[keys.length - 1]); loanInfoAttachment.setAttachPath(key);
     * loanInfoAttachment.setAttachGroup(attachGroup); loanInfoAttachment.setAttachType(attachType);
     * loanInfoAttachment.setFullPath(coverUrl); loanInfoAttachment.setLoanInfoId(loanInfoId); loanInfoAttachment
     * .setCreateTime(new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE_TIME).format(new Date()));
     * loanInfoAttachment.setCreateUser(user.getId()); //
     * importExcelTemplateService.insertLoanInfoAttach(loanInfoAttachment); return new Resp("upload success!"); }
     */

    /**
     * 查询操作日志
     */
    @RequestMapping(value = "/queryOperLog", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryOperLog(@Valid OperLogReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        RespPage<List<OperLogSimpleVO>> list = operLogService.querySimpleOperLog(req);
        return new Resp(list);
    }

    /**
     * 查询审核日志
     */
    @RequestMapping(value = "/queryOperReviewLog", method = RequestMethod.POST)
    @ResponseBody
    public Resp queryOperReviewLog(@Valid OperLogReq req, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        RespPage<List<OperLogReviewVO>> list = operLogService.queryReviewOperLog(req);
        return new Resp(list);
    }

    @ResponseBody
    @RequestMapping(value = "/api/refuseInform", method = RequestMethod.POST)
    public Resp refuseInform(@RequestBody Map<String, Object> param) {
        Resp resp = new Resp();
        try {
            ApiReq req = new ApiReq();
            req.setOrderId(Long.valueOf(param.get("orderId").toString()));
            req.setStatus(param.get("status").toString());
            req.setReason(param.get("reason").toString());
            // importExcelTemplateService.updateInfoAproveStatus(req);
            P2PCustOperLog col = new P2PCustOperLog();
            col.setUid("1");
            col.setOrderId(req.getOrderId());
            col.setOperType(OperationType.REJECT.getStatus());
            col.setOperTime(new Date());
            col.setDetail(req.getReason());
            operationLogService.insertOperLog(col);
            return resp;
        } catch (Exception e) {
            e.printStackTrace();
            return Resp.buildErrorResponse("拒绝订单失败！错误：" + e.getMessage());
        }
    }
}
