package cn.sunfit.risk.web.controller.system;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.p2p.P2PParams;
import cn.sunfit.risk.buz.api.constants.ParamsType;
import cn.sunfit.risk.buz.api.service.p2p.param.P2PParamsService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/param")
public class ParamsController extends BaseController{
	
	@Autowired
    private P2PParamsService p2PParamsService;
	/**
     * @Title: loadParamsManager
     * @Description:  跳转参数配置页面
     * @param @param request
     * @param @return   
     * @return String 
     * @author kevin han 2017年2月15日 
     * @throws
     */
	@RequestMapping(value = "/loadParamsManager", method = RequestMethod.GET)
    public String loadParamsManager(ModelMap model) {
		
		
		
		return "/system/param/loadParamsManager";
	}
	@RequestMapping(value = "/editAttachParam", method = RequestMethod.GET)
    public String editAttachManager(ModelMap model) {
		
		List<P2PParams> atts=p2PParamsService.findAttachments(ParamsType.ATTACH.getStatus());
		model.addAttribute("atts", atts);
		return "system/param/modal/editAttachParam";
	}
    @ResponseBody
    @RequestMapping(value = "/saveAttachParam", method = RequestMethod.POST)
    public Resp saveAttachParam(@RequestParam(required = true) String id,
    							@RequestParam(required = true) String paramName,
    							@RequestParam(required = true) String paramGroup,
    							@RequestParam(required = true) String status,
    							@RequestParam(required = true) String paramType) {
    	try{
    		Map<String,Object> params=new HashMap<String,Object>();
    		params.put("id", id);
    		params.put("paramName", paramName);
    		params.put("paramGroup", paramGroup);
    		params.put("status", status);
    		params.put("paramType", paramType);
    		p2PParamsService.saveAttParam(params);
    		return new Resp("success!");
		}catch(Exception e){
			return new Resp().buildErrorResponse("保存失败", 0);
		}
    }
}
