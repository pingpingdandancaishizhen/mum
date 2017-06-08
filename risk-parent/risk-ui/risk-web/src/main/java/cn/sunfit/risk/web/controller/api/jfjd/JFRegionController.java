package cn.sunfit.risk.web.controller.api.jfjd;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.service.api.jfjd.JFRegionService;
import cn.sunfit.risk.buz.api.vo.Resp;

/**
 * 
 * @Title: PositionController.java
 * @Package cn.sunfit.risk.web.controller.api.jfjd
 * @Description: 地址选择框数据获取
 * @author RJS
 * @date 2017年3月20日 上午9:59:43
 * @version V1.0
 */
@Controller
@RequestMapping("/jfjd/region")
public class JFRegionController {

    @Autowired
    private JFRegionService regionService;

    /**
     * 
     * @Title: 获取省市区单级信息
     * @Description: TODO
     * @param @param code
     * @param @return   
     * @return Resp 
     * @author RJS 2017年3月20日 
     * @throws
     */
    @ResponseBody
    @RequestMapping(value = "/info/regions", method = RequestMethod.GET)
    public Resp getProvince(String code) {
        Map<String, Object> regionMap = new HashMap<String, Object>();
        if (StringUtils.isNotBlank(code)) {
            regionMap = regionService.queryNodes(code);
        } else {
            regionMap = regionService.queryProvinces();
        }

        return new Resp(regionMap);
    }

}
