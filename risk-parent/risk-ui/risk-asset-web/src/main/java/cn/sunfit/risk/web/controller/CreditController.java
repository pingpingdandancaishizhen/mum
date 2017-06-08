package cn.sunfit.risk.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.credit.api.service.CJDService;
import cn.sunfit.risk.credit.api.service.JXLService;
import cn.sunfit.risk.credit.api.vo.jxl.JXLQuery;
import cn.sunfit.risk.web.bean.CreditInfo;

@Controller
@RequestMapping(value = "/credit")
public class CreditController extends BaseController {

    @Autowired
    private CJDService cjdService;

    @Autowired
    private JXLService jxlService;

    @ResponseBody
    @RequestMapping(value = "/attrInfo", method = RequestMethod.GET)
    public Resp attrInfo() throws IOException {
        List<CreditInfo> creditInfoList = new ArrayList<CreditInfo>();
        creditInfoList.add(new CreditInfo("人法网", "全国法院被执行人信息查询", "http://zhixing.court.gov.cn/search/"));
        creditInfoList.add(new CreditInfo("企业网", "国家企业信用信息查询", "http://gsxt.gdgs.gov.cn/"));
        creditInfoList.add(new CreditInfo("好搜网", "网络身份证号码查询", "https://www.so.com/?src=360sou_newhome&ls=0"));
        creditInfoList.add(new CreditInfo("聚信立", "", "/credit/toJxlPage"));
        return new Resp(creditInfoList);
    }
    
    @RequestMapping(value = "/toJxlPage", method = RequestMethod.GET)
    public String toJxlPage(Model model) throws ParseException{
    	JXLQuery req = new JXLQuery();
    	req.setIdcard("441226198806223419");
    	req.setName("陆国荣");
    	req.setPhone("15016399857");
    	String resp = jxlService.query(JsonUtils.toJSON(req));
    	cn.sunfit.risk.credit.api.beans.Resp response = new cn.sunfit.risk.credit.api.beans.Resp();
    	response = JsonUtils.parseJSON(resp, cn.sunfit.risk.credit.api.beans.Resp.class);
    	if(response.getData() != null){
    		Map<String, Object> resultMap = (HashMap<String, Object>) response.getData();
    		Map<String, Object> result = setJxlCreditResult((Map<String, Object>) resultMap.get("report_data"));  		
    		model.addAttribute("result", result);
    	}
    	return "/credit/jxlPage";
    }
    
    private Map<String, Object> setJxlCreditResult(Map<String, Object> retMap) throws ParseException {
    	Map<String, Object> result = new HashMap<String, Object>();
		// 处理报告时间
		Map<String, Object> reportMap = (Map<String, Object>) retMap.get("report");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		reportMap.put("update_time", df.parse(reportMap.get("update_time").toString()));
		retMap.put("report", reportMap);
		result.put("data", retMap);
		return result;
	}
    
    
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
    public Resp datadic(HttpServletRequest request) {
        String info = cjdService.accountInfo();
        return new Resp(info);
    }

}
