package cn.sunfit.risk.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.system.DistrictService;
import cn.sunfit.risk.buz.api.vo.Resp;

@Controller
@RequestMapping("/district")
public class DistrictController extends BaseController {

    @Autowired
    private DistrictService districtService;

    /**
     * 
     * @Title: info
     * @Description: 查询地址表
     * @param @return   
     * @return Resp 
     * @author XJ 2017年1月11日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Resp datadic() {
        Map<String, Object> info = districtService.queryDistrictInfo();
        return new Resp(info);
    }

}
