package cn.sunfit.risk.web.controller.api.jfjd;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.api.jfjd.JFCorpService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.controller.BaseController;

/**
 * 
 * @Title: JFCorpController.java
 * @Package cn.sunfit.risk.web.controller.api.jfjd
 * @Description: 疾风交单公司类
 * @author RJS
 * @date 2017年3月20日 下午4:13:32
 * @version V1.0
 */
@Controller
@RequestMapping("/jfjd/corp")
public class JFCorpController extends BaseController {

    @Autowired
    private JFCorpService JFCorpService;

    /**
     * 
     * @Title: queryCorps
     * @Description: 获取公司下拉列表数据
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月20日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/queryCorps", method = RequestMethod.GET)
    public Resp queryCorps() {
        Map<String, Object> result = new HashMap<String, Object>();
        result = JFCorpService.queryCorps();
        return new Resp(result);

    }
}
