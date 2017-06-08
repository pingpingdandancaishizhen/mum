package cn.sunfit.risk.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.system.CarInfoService;
import cn.sunfit.risk.buz.api.vo.Resp;

@Controller
@RequestMapping("/carInfo")
public class CarInfoController extends BaseController {

    @Autowired
    private CarInfoService carInfoService;

    /**
     * 
     * @Title: info
     * @Description: 查询车辆信息
     * @param @return   
     * @return Resp 
     * @author XJ 2017年1月11日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Resp datadic() {
        Map<String, Object> info = carInfoService.queryCarInfo();
        return new Resp(info);
    }

}
