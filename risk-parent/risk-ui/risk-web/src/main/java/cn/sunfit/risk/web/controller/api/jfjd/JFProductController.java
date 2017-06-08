package cn.sunfit.risk.web.controller.api.jfjd;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.api.jfjd.JFProductService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.controller.BaseController;

/**
 * 
 * @Title: JFProductController.java
 * @Package cn.sunfit.risk.web.controller.api.jfjd
 * @Description: 疾风交单产品类
 * @author RJS
 * @date 2017年3月20日 下午4:54:17
 * @version V1.0
 */
@Controller
@RequestMapping("/jfjd/product")
public class JFProductController extends BaseController {

    @Autowired
    private JFProductService jFProductService;

    /**
     * 
     * @Title: queryMonthlyFee
     * @Description: 获取产品的期次配置
     * @param @param productId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月22日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryMonthlyFee", method = RequestMethod.GET)
    public Resp queryMonthlyFee(String productId) {
        if (StringUtils.isBlank(productId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        Resp resp = jFProductService.queryMonthlyFee(productId);
        return resp;
    }

    /**
     * 
     * @Title: queryProductsByCorp
     * @Description: 根据公司ID获取产品列表
     * @param @param corpId
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月20日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryProducts", method = RequestMethod.GET)
    public Resp queryProductsByCorp(String corpId) {
        if (StringUtils.isBlank(corpId)) {
            return Resp.buildErrorResponse("参数错误");
        }
        Map<String, Object> result = jFProductService.queryProducts(corpId);
        return new Resp(result);
    }
}
