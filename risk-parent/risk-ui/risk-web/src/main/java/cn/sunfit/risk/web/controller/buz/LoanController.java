package cn.sunfit.risk.web.controller.buz;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.buz.OperLogService;
import cn.sunfit.risk.buz.api.service.loan.LoanService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.solution.SuperFormService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.buz.OperLogReq;
import cn.sunfit.risk.buz.api.vo.buz.OperLogReviewVO;
import cn.sunfit.risk.buz.api.vo.buz.OperLogSimpleVO;
import cn.sunfit.risk.buz.api.vo.form.FormData;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.loan.LoanReq;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaCorpProductVO;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaQueryReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping("/loan")
public class LoanController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(LoanController.class);

    @Autowired
    private LoanService loanService;
    @Autowired
    private SuperFormService superFormService;

    @Autowired
    private OperLogService operLogService;
    @Autowired
    private ProductService productService;
    
    /**
     * 
     * @Title: getFormData
     * @Description: 获取表单
     * @param @return   
     * @return Resp 
     * @author XFL 2017年1月13日 
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

    /**
     * 
     * @Title: toApply
     * @Description: 借款申请跳转
     * @param @param req
     * @param @param map
     * @param @return   
     * @return String 
     * @author XFL 2017年1月13日 
     * @throws
     */
    @RequestMapping(value = "/getStartParam", method = RequestMethod.POST)
    @ResponseBody
    public Resp getStartParam(@Valid LoanReq req, BindingResult aresult) {
        Resp a = buildValidationFaildResponse(aresult);
        if (a.getStatus() == DATA_VALIDATION_ERROR) {
            return a;
        }
        BpMetaQueryReq s = new BpMetaQueryReq();
        s.setCorpInfo(getCurrentUser());
        s.setLastest(true);
        s.setProductId(req.getProductId());
        BpMetaCorpProductVO vo = productService.queryMetaByProduct(s);
        if (vo == null) {
            throw new ServiceException("流程查询异常");
        } else {
            if (!StringUtils.contains(vo.getVersion(), ":")) {
                throw new ServiceException("流程未部署");
            }
            FormQuery r = new FormQuery();
            r.setBpDefId(vo.getBpDefId());
            r.setBpDefKey(vo.getBpDefKey());
            r.setCustomerId(req.getCustomerId());
            r.setProductId(req.getProductId());
            r.setBpId(IdUtil.geneId());
            r.setDeptId(getCurrentUser().getDeptId());
            return new Resp(r);
        }
    }

    @RequestMapping(value = "/getStartParamView", method = RequestMethod.POST)
    @ResponseBody
    public Resp getStartParamView(@RequestParam(required = true) String bpId) {
        // 根据单号查询所有参数 然后，
        FormQuery r = new FormQuery();
        r.setCorpInfo(getCurrentUser());
        r = loanService.queryFormReqByBPId(bpId, r);
        r.setView(true);
        return new Resp(r);
    }

    /**
     * 
     * @Title: hasLoan
     * @Description: 查询客户名下是否有贷款
     * @param @return   
     * @return Resp 
     * @author XFL 2017年1月12日 
     * @throws
     */
    // @RequestMapping(value = "/hasLoan", method = RequestMethod.POST)
    // @ResponseBody
    // public Resp hasLoan(@Valid LoanReq req, BindingResult result) {
    // Resp r = buildValidationFaildResponse(result);
    // if (r.getStatus() == DATA_VALIDATION_ERROR) {
    // return r;
    // }
    // req.setCorpInfo(getCurrentUser());
    // boolean d = loanService.hasLoan(req);
    // return new Resp(d);
    // }

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

    @RequestMapping(value = "/saveDraft", method = RequestMethod.POST)
    @ResponseBody
    public Resp saveDraft(@Valid FormQuery req, String data, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        req.setCorpInfo(getCurrentUser());
        Map<String, String> formdata = JsonUtils.parseJSON(data, Map.class, String.class, String.class);
        logger.debug("保存草稿参数{}", formdata);
        superFormService.saveDraft(req, formdata);
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

}
