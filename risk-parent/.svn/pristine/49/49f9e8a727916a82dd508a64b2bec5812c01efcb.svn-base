package cn.sunfit.risk.web.controller.api.jfjd;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.api.jfjd.JFCorpUserService;
import cn.sunfit.risk.buz.api.utils.api.jfjd.Base64;
import cn.sunfit.risk.buz.api.utils.api.jfjd.HttpUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFCorpUserExisitQueryReq;
import cn.sunfit.risk.web.controller.BaseController;
import cn.sunfit.risk.web.utils.JsonUtil;

/**
 * 
 * @Title: JFCorpController.java
 * @Package cn.sunfit.risk.web.controller.api.jfjd
 * @Description: 疾风交单用户类
 * @author RJS
 * @date 2017年3月20日 下午4:13:32
 * @version V1.0
 */
@Controller
@RequestMapping("/jfjd/corpUser")
public class JFCorpUserController extends BaseController {

    private static Logger log = LoggerFactory.getLogger(JFCorpUserController.class);

    @Autowired
    private JFCorpUserService jFCorpUserService;

    /**
     * 
     * @Title: userAuth
     * @Description: 机构认证
     * @param @param req
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月23日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/userAuth", method = RequestMethod.POST)
    public Resp userAuth(HttpServletRequest request) {
        JFCorpUserExisitQueryReq req = new JFCorpUserExisitQueryReq();
        try {
            String paraStr = HttpUtils.getRequestParam(request);
            if (StringUtils.isNotBlank(paraStr)) {
                req = JsonUtil.jsonStrToObject(Base64.getFromBASE64(paraStr), JFCorpUserExisitQueryReq.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return Resp.buildErrorResponse("参数错误");
        }

        if (req == null || StringUtils.isBlank(req.getCorpId()) || StringUtils.isBlank(req.getIdCard())) {
            return Resp.buildErrorResponse("参数错误");
        }
        Map<String, Object> reslut = jFCorpUserService.userAuth(req);
        return new Resp(reslut);
    }
}
