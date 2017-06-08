package cn.sunfit.risk.web.controller.order;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import cn.sunfit.risk.buz.api.beans.p2p.LoanInfoAttachment;
import cn.sunfit.risk.buz.api.beans.p2p.P2PCustOperLog;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.p2p.activiti.OperLogService;
import cn.sunfit.risk.buz.api.service.p2p.activiti.SuperFormService;
import cn.sunfit.risk.buz.api.service.p2p.excel.ImportExcelTemplateService;
import cn.sunfit.risk.buz.api.service.p2p.excel.OperationLogService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
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
import cn.sunfit.risk.buz.api.vo.p2p.excel.P2PImportExcelTemplateXJD;
import cn.sunfit.risk.buz.util.p2p.OperationType;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.service.ExcelService;
import cn.sunfit.risk.web.service.OrderService;
import cn.sunfit.risk.web.utils.OSSUtil;
import cn.sunfit.risk.web.utils.UrlUtil;

@Controller
@RequestMapping(value = "/order")
public class OrderController extends BaseController {
    @Autowired
    ImportExcelTemplateService importExcelTemplateService;
    @Autowired
    P2PProductService p2PProductService;
    @Autowired
    private OSSUtil OSSUtil;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OperationLogService operationLogService;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private SuperFormService superFormService;
    @Autowired
    private OperLogService operLogService;
    
    @ResponseBody
    @RequestMapping(value = "/batchSubmit", method = RequestMethod.POST)
    public Resp batchSubmit(@RequestParam("ids[]") Long[] ids) {
        Resp resp = new Resp();
        try {
            if (ids == null || ids.length == 0)
                return new Resp().buildErrorResponse("请选择需要提交的订单！");
            String idParam = "";
            for (long id : ids) {
                idParam += id + ",";
            }
            idParam = idParam.substring(0, idParam.length() - 1);
            LoanInfoQueryReq req = new LoanInfoQueryReq();
            req.setIds(idParam);
            List<P2PImportExcelTemplateXJD> infos = importExcelTemplateService.queryLoanInfoByParam(req);
            String res = null;
            List<P2PImportExcelTemplateXJD> sucInfos = new ArrayList<P2PImportExcelTemplateXJD>();
            List<Map<String, Object>> failInfos = new ArrayList<Map<String, Object>>();
            Map<String, Object> failInfo = null;
            for (P2PImportExcelTemplateXJD info : infos) {
                res = orderService.pushFKP2PApproveXJD(info);
                if ("success".equals(res)) {
                    sucInfos.add(info);
                } else {
                    failInfo = new HashMap<String, Object>();
                    failInfo.put("err", res);
                    failInfo.put("info", info);
                    failInfos.add(failInfo);
                }
            }
            if (sucInfos.size() > 0)
                importExcelTemplateService.updateInfoAproveStatus(sucInfos);

            Map<String, Object> result = new HashMap<String, Object>();
            result.put("subCount", sucInfos.size());
            result.put("err", failInfos);
            resp.setData(result);
            return resp;
        } catch (Exception e) {
            return new Resp().buildErrorResponse("批量提交失败");
        }
    }

    /**
     * 编辑订单详情
     * @param req
     * @param aresult
     * @return
     */
    @RequestMapping(value = "/editOrder", method = RequestMethod.POST)
    @ResponseBody
    public Resp editOrder(@Valid LoanInfoQueryReq req, BindingResult aresult) {
        // model.addAttribute("mode", req.getModel());
        // P2PImportExcelTemplateXJD info = importExcelTemplateService.queryLoanInfo(req);
        // List<P2PParams> list=importExcelTemplateService.queryAttachParamList();
        // model.addAttribute("attachParams", list);
        // model.addAttribute("info", info);
        // model.addAttribute("pathRoot", OSSUtil.buildUrl(""));
        // model.addAttribute("genders", GenderType.values());
        // model.addAttribute("marital", MaritalStatus.values());
        // model.addAttribute("education", EducationType.values());
        // model.addAttribute("relations", RelationType.values());
        // model.addAttribute("productTypes", ProductType.values());
        // List<Map<String, String>> products = p2PProductService.findRiskProductList();
        // model.addAttribute("products", products);
        // model.addAttribute("loanUsages", LoanUsageType.values());
        // model.addAttribute("loanRepayments", LoanRepaymentType.values());
        // model.addAttribute("customerTypes", CustomerType.values());
        // return "/order/editOrder";
        
        Resp a = buildValidationFaildResponse(aresult);
        if (a.getStatus() == DATA_VALIDATION_ERROR) {
            return a;
        }
        BpMetaQueryReq s = new BpMetaQueryReq();
        s.setCorpInfo(getCurrentUser());
        s.setLastest(true);
        s.setProductId(req.getProductCode());
        BpMetaCorpProductVO vo = p2PProductService.queryMetaByProduct(s);
        if (vo == null) {
            throw new ServiceException("流程查询异常");
        } else {
            if (!StringUtils.contains(vo.getVersion(), ":")) {
                throw new ServiceException("流程未部署");
            }
            FormQuery r = new FormQuery();
            r.setBpDefId(vo.getBpDefId());
            r.setBpDefKey(vo.getBpDefKey());
            r.setProductId(req.getProductCode());
            r.setBpId(req.getId());
            r.setDeptId(getCurrentUser().getDeptId());
            if("view".equals(req.getModel()))
                r.setView(true);
            return new Resp(r);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Resp fileUpload(@RequestParam(required = true) MultipartFile file) {
        Resp resp = new Resp();
        if (file.isEmpty())
            return Resp.buildErrorResponse("导入文件失败！");
        List<Map<String, Object>> dataList = null;
        try {
            CorpUserDTO user = getCurrentUser();
            String importCode = IdUtil.geneId();
            Map<String, Object> result = excelService.batchImportLoan(user.getId(), file.getInputStream(),
                    importExcelTemplateService, excelService.getXjdCheckTemp(),importCode);
            if (result == null) {
                return Resp.buildErrorResponse("文件内容为空！");
            }
            if (result.containsKey("errStr"))
                return Resp.buildErrorResponse(result.get("errStr").toString());
            dataList = (List<Map<String, Object>>) result.get("data");
            if (dataList.size() > 0) {
                String res = importExcelTemplateService.insertLoanInfo(dataList,"XJD");
                if (!"success".equals(res)) {
                    return new Resp().buildErrorResponse(res);
                }
            }
            Map<String, Object> respResult = new HashMap<String, Object>();
            respResult.put("err", result.get("err"));
            respResult.put("importCount", dataList.size());
            respResult.put("errCount", ((List<Map<String, Object>>) result.get("err")).size());
            resp.setData(respResult);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return Resp.buildErrorResponse("解析批量导入订单错误！", e);
        }
        return resp;
    }

    /**
     * 
     * @Title: getFormData
     * @Description: 获取表单
     * @param @return   
     * @return Resp 
     * @author kevinhan 2017年4月17日 
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
        if (req.isView()) {
            formdata = superFormService.queryNodeFormData4View(req);
        } else {
            formdata = superFormService.queryNodeFormData(req);
        }
        return new Resp(formdata);
    }

    @ResponseBody
    @RequestMapping(value = "/loadAllLoanByCustomer", method = RequestMethod.POST)
    public Resp loadAllLoanByCustomer(LoanInfoQueryReq req) {
        req.setPaseSize(100);
        RespPage<List<P2PImportExcelTemplateXJD>> info = importExcelTemplateService.queryLoanInfoByCustomer(req);
        if (info.getTotalCount() > 0) {
            return new Resp(info);
        } else {
            return new Resp().buildErrorResponse("没有记录", 0);
        }

    }

    @ResponseBody
    @RequestMapping(value = "/removeAttach", method = RequestMethod.POST)
    public Resp loadAllLoanByCustomer(@RequestParam(required = true) String attachId) {
        try {
            importExcelTemplateService.backupAttach(attachId);
            importExcelTemplateService.removeAttach(attachId);
            return new Resp("success!");
        } catch (Exception e) {
            return new Resp().buildErrorResponse("删除失败", 0);
        }
    }

    @RequestMapping(value = "/loadOrderManager", method = RequestMethod.GET)
    public String loadAllLoanManager(HttpServletRequest request) {
        // CorpUserDTO user = getCurrentUser();
        return "/order/loadOrderManager";
    }

    @ResponseBody
    @RequestMapping(value = "/loadAllLoanManager", method = RequestMethod.POST)
    public Resp loadAllLoanManager(LoanInfoQueryReq req) {
        RespPage<List<P2PImportExcelTemplateXJD>> info = importExcelTemplateService.queryLoanInfoList(req);
        return new Resp(info);
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
            importExcelTemplateService.updateInfoAproveStatus(req);
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
            return new Resp().buildErrorResponse("拒绝订单失败！错误：" + e.getMessage());
        }
    }

    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    @ResponseBody
    public Resp saveOrder(P2PImportExcelTemplateXJD info) {
        String houseHoldAddrJoin = info.getHouseHoldAddrJoin();
        if (StringUtils.isNotEmpty(houseHoldAddrJoin)) {
            String[] address = houseHoldAddrJoin.split("/");
            if (address.length == 1)
                return new Resp().buildErrorResponse("请选择户口所在地");
            info.setHouseHoldProvince(address[0]);
            info.setHouseHoldCity(address[1]);
            if (address.length == 3)
                info.setHouseHoldRegion(address[2]);
        }
        String schoolAddrJoin = info.getSchoolAddrJoin();
        if (StringUtils.isNotEmpty(schoolAddrJoin)) {
            String[] address = schoolAddrJoin.split("/");
            if (address.length == 1)
                return new Resp().buildErrorResponse("请选择学校地址");
            info.setSchoolProvince(address[0]);
            info.setSchoolCity(address[1]);
            if (address.length == 3)
                info.setSchoolRegion(address[2]);
        }
        String companyAddrJoin = info.getCompanyAddrJoin();
        if (StringUtils.isNotEmpty(companyAddrJoin)) {
            String[] address = companyAddrJoin.split("/");
            if (address.length == 1)
                return new Resp().buildErrorResponse("请选择公司地址");
            info.setCompanyProvince(address[0]);
            info.setCompanyCity(address[1]);
            if (address.length == 3)
                info.setCompanyRegion(address[2]);
        }
        String receiversBankAddr = info.getReceiversBankAddr();
        if (StringUtils.isNotEmpty(receiversBankAddr)) {
            String[] address = receiversBankAddr.split("/");
            info.setReceiversBankProvince(address[0]);
            info.setReceiversBankCity(address[1]);
        }
        String repaymentBankAddr = info.getRepaymentBankAddr();
        if (StringUtils.isNotEmpty(repaymentBankAddr)) {
            String[] address = repaymentBankAddr.split("/");
            info.setRepaymentBankProvince(address[0]);
            info.setRepaymentBankCity(address[1]);
        }
        importExcelTemplateService.updateLoanInfo(info);
        return new Resp();
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public Resp submit(@Valid FormQuery req, String data, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        Map<String, String> formdata = JsonUtils.parseJSON(data, Map.class, String.class, String.class);
        logger.debug("提交流程参数{}", formdata);
        superFormService.submit(req, formdata);
        return new Resp();
    }
    
    @RequestMapping(value = "/uploadLoanAttach", method = RequestMethod.POST)
    @ResponseBody
    public Resp uploadCorpLogo(@RequestParam(required = true) MultipartFile file,
            @RequestParam(required = true) String loanInfoId, @RequestParam(required = true) String attachGroup,
            @RequestParam(required = true) String attachType) {
        Long size = file.getSize();
        if (size > 10 * 1024 * 1024) {
            return Resp.buildErrorResponse("上传文件大超过10M，请重新小上传！", "");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String suffix = file.getOriginalFilename().toString()
                .substring(file.getOriginalFilename().toString().lastIndexOf("."));
        String key = UrlUtil.getLOGOUrl("p2puploader", dateFormat.format(new Date()), suffix);
        try {
            OSSUtil.uploadFile(key, file.getBytes());
        } catch (IOException e) {
            logger.error("file getBytes exception," + e.getMessage());
            throw new RuntimeException("file getBytes exception," + e.getMessage());
        }
        CorpUserDTO user = getCurrentUser();
        String coverUrl = OSSUtil.buildUrl(key);
        LoanInfoAttachment loanInfoAttachment = new LoanInfoAttachment();
        loanInfoAttachment.setAttachSize(String.valueOf(size));
        loanInfoAttachment.setAttachOldName(file.getOriginalFilename().toString());
        String[] keys = key.split("/");
        loanInfoAttachment.setAttachNewName(keys[keys.length - 1]);
        loanInfoAttachment.setAttachPath(key);
        loanInfoAttachment.setAttachGroup(attachGroup);
        loanInfoAttachment.setAttachType(attachType);
        loanInfoAttachment.setFullPath(coverUrl);
        loanInfoAttachment.setLoanInfoId(loanInfoId);
        loanInfoAttachment
                .setCreateTime(new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE_TIME).format(new Date()));
        loanInfoAttachment.setCreateUser(user.getId());
        importExcelTemplateService.insertLoanInfoAttach(loanInfoAttachment);
        return new Resp("upload success!");
    }
    
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
    //getFeeConfig
}
