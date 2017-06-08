package cn.sunfit.risk.web.controller.api.jfjd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFBPAttrValue;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpUserDTO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFProduct;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFBPAttrService;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFBpService;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCorpUserService;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFProductService;
import cn.sunfit.risk.buz.api.utils.api.jfjd.Base64;
import cn.sunfit.risk.buz.api.utils.api.jfjd.HttpUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBPDetailReq;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.JsonUtil;

/**
 * 
 * @Title: JFBpController.java
 * @Package cn.sunfit.risk.web.controller.api.jfjd
 * @Description: 疾风交单订单类
 * @author RJS
 * @date 2017年3月22日 下午4:09:19
 * @version V1.0
 */
@Controller
@RequestMapping("/jfjd/bp")
public class JFBPAttrController extends BaseController {

    @Autowired
    private JFBpService jFBpService;
    @Autowired
    private JFCorpUserService jFCorpUserService;

    @Autowired
    private JFBPAttrService jFBPAttrService;
    @Autowired
    private JFProductService jFProductService;

    @ResponseBody
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Resp bpFieldsSave(HttpServletRequest request) {

        // 添加用户后，提交单子
        JFBPAttrValue attrValue = new JFBPAttrValue();
        try {
            String paraStr = HttpUtils.getRequestParam(request);
            if (StringUtils.isNotBlank(paraStr)) {
                String param = Base64.getFromBASE64(paraStr);
                logger.info("提单接口参数：" + param);
                attrValue = JsonUtil.jsonStrToObject(param, JFBPAttrValue.class);
                String sassId = attrValue.getSaasUid();
                // 获取当前用户信息
                JFCorpUserDTO user = jFCorpUserService.queryUserById(sassId);
                // 验证产品是否支持，验证单号是否存在
                if (user == null) {
                    throw new ServiceException("用户不存在");
                }
                JFProduct p = jFProductService.queryProduct(attrValue.getProdType());
                if (p == null) {
                    throw new ServiceException("产品不存在");
                }
                long c = jFBpService.countBpById(attrValue.getSaasLoanId(), user.getDomain());
                if (c > 0) {
                    throw new ServiceException("单号已存在");
                }
                String status = jFBpService.submitOrder(user, attrValue);
                return new Resp(status);
            }
        } catch (ServiceException ex) {
            return Resp.buildErrorResponse(ex.getMsg());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Resp.buildErrorResponse("参数错误");
        }

        return new Resp();
    }

    /**
     * 
     * @Title: getRepayDetailByBp
     * @Description: 获取订单详细信息
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月23日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/getRepayDetailByBp", method = RequestMethod.GET)
    public Resp getRepayDetailByBp(JFBPDetailReq req) {
        if (req == null || StringUtils.isBlank(req.getBpId()) || StringUtils.isBlank(req.getCorpId())) {
            return Resp.buildErrorResponse("参数错误");
        }
        Map<String, Object> result = jFBPAttrService.getBPDetailById(req);
        return new Resp(result);
    }
}
