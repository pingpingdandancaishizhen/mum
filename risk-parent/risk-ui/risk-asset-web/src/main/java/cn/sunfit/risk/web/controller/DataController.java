package cn.sunfit.risk.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.system.DataDic;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.service.system.ContractPartnerService;
import cn.sunfit.risk.buz.api.service.system.DataService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.solution.dyc.DycFeeConfig;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerConfigShowVO;

@Controller
@RequestMapping("/data")
public class DataController extends BaseController {
    @Autowired
    private DataService dataService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ContractPartnerService contractPartnerService;

    /**
     * 
     * @Title: datadic
     * @Description: 查询字典表
     * @param @param type 多个type用英文，分割
     * @param @return   
     * @return Resp 
     * @author XFL 2017年1月5日 
     * @throws
     */
    @RequestMapping(value = "/datadic", method = RequestMethod.GET)
    @ResponseBody
    public Resp datadic(@RequestParam("type") String type, @RequestParam(required = false) String productId,
            @RequestParam(required = false) String bpDefId) {
        List<DataDic> list = dataService.getDataDic(type, getCurrentUser().getCorpId(), productId, bpDefId);
        return new Resp(list);
    }

    private List<DataDic> fk(List<Double> fees) {
        List<DataDic> list = new ArrayList<DataDic>();
        for (Double v : fees) {
            DataDic d = new DataDic();
            d.setDicKey(String.valueOf(v));
            d.setDicValue(String.valueOf(v));
            list.add(d);
        }
        return list;
    }

    /**
     * 
     * @Title: genNo
     * @Description: 获取单号
     * @param @param productId
     * @param @param type
     * @param @return   
     * @return Resp 
     * @author XFL 2017年1月17日 
     * @throws
     */
    @RequestMapping(value = "/genNo", method = RequestMethod.GET)
    @ResponseBody
    public Resp genNo(String productId, String type) {
        if (StringUtils.equals(type, "c")) {
            String cid = IdUtil.generateBPContratNo(productId);
            return new Resp(cid);
        } else if (StringUtils.equals(type, "y")) {
            String cid = IdUtil.generateBPYapinNo(productId);
            return new Resp(cid);
        } else if (StringUtils.equals(type, "f")) {
            String cid = IdUtil.generateBPFangkuanNo(productId);
            return new Resp(cid);
        }
        return new Resp(-1, "");
    }

    /**
     * 获取抵押人
     */
    @RequestMapping(value = "/getDyUser", method = RequestMethod.GET)
    @ResponseBody
    public Resp getDyUser(@RequestParam(required = true) String productId, String roleId) {
        List<PartnerConfigShowVO> vo = contractPartnerService.queryPartnerByProductId(getCurrentUser().getDomain(),
                productId, roleId);
        List<DataDic> list = new ArrayList<DataDic>();
        for (PartnerConfigShowVO v : vo) {
            DataDic d = new DataDic();
            d.setDicKey(v.getId());
            d.setDicValue(v.getName());
            list.add(d);
        }
        return new Resp(list);
    }

    /**
     * 
     * @Title: getFeeConfig
     * @Description: 获取产品费用配置
     * @param @param productId
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月4日 
     * @throws
     */
    @RequestMapping(value = "/getFeeConfig", method = RequestMethod.GET)
    @ResponseBody
    public Resp getFeeConfig(@RequestParam(required = true) String productId) {
        String feeConfig = productService.queryFeeConfig(productId);
        if (StringUtils.isBlank(feeConfig)) {
            return Resp.buildErrorResponse(-1, "产品没有产品费用配置");
        }
        return new Resp(JsonUtils.parseJSON(feeConfig, Object.class));
    }

    /**
     * 
     * @Title: getFeeConfig
     * @param @param productId
     * @param @return   
     * @return Resp 
     * @author XFL 2017年3月7日 
     * @throws
     */
    @RequestMapping(value = "/getFeeConfigType", method = RequestMethod.GET)
    @ResponseBody
    public Resp getFeeConfigType(@RequestParam(required = true) String productId,
            @RequestParam(required = true) String type, @RequestParam(required = true) String feetype) {
        String feeConfig = productService.queryFeeConfig(productId);
        if (StringUtils.equals("dyc", type)) {
            DycFeeConfig config = JsonUtils.parseJSON(feeConfig, DycFeeConfig.class);
            if (StringUtils.equals(feetype, "gps")) {
                return new Resp(fk(config.getGpsFee()));
            } else if (StringUtils.equals(feetype, "gpsser")) {
                return new Resp(fk(config.getGpsSerFee()));
            }/*
              * else if (StringUtils.equals(feetype, "park")) { return new Resp(fk(config.getParkFee())); }
              */
        }

        return new Resp();
    }
}
