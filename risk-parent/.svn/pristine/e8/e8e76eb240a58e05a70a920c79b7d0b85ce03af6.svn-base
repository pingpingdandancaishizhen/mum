package cn.sunfit.risk.web.controller.api.jfjd;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.api.jfjd.JFCarBmsService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping("/jfjd/carBms")
public class JFCarBmsController extends BaseController {

    @Autowired
    private JFCarBmsService carBmsService;

    @ResponseBody
    @RequestMapping(value = "/bmsInfo", method = RequestMethod.GET)
    public Resp bmsInfo(String type, String id) {
        if (StringUtils.isBlank(type)) {
            return Resp.buildErrorResponse("参数错误");
        }
        Map<String, Object> reslut = carBmsService.getBmsInfo(type, id);
        return new Resp(reslut);
    }
}
