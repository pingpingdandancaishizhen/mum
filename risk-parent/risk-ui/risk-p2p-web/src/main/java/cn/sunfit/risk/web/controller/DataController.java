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

import cn.sunfit.risk.buz.api.beans.p2p.P2PBank;
import cn.sunfit.risk.buz.api.beans.p2p.ProductSubType;
import cn.sunfit.risk.buz.api.beans.system.DataDic;
import cn.sunfit.risk.buz.api.service.p2p.excel.P2PBankService;
import cn.sunfit.risk.buz.api.service.p2p.productSubType.ProductSubTypeService;
import cn.sunfit.risk.buz.api.service.system.DataService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.Resp;

@Controller
@RequestMapping("/data")
public class DataController extends BaseController {
    @Autowired
    private DataService dataService;

    @Autowired
    private P2PBankService bankService;

    @Autowired
    private ProductSubTypeService productSubTypeService;

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
        List<DataDic> list = dataService.getDataDicP2P(type, getCurrentUser().getCorpId(), productId, bpDefId,
                getCurrentUser().getDomain());
        return new Resp(list);
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
     * 获取第三方类型是allinpay的所有银行
     * @Title: getAllinpayBank
     * @Description: TODO
     * @param @return   
     * @return Resp 
     * @author wangguang 2017年5月22日 
     * @throws
     */
    @RequestMapping(value = "/getAllinpayBank", method = RequestMethod.GET)
    @ResponseBody
    public Resp getAllinpayBank() {
        List<P2PBank> list = bankService.getBankByThirdType("allinpay");
        List<DataDic> res = new ArrayList<DataDic>();
        DataDic dic = null;
        for (P2PBank bank : list) {
            dic = new DataDic();
            dic.setDicKey(bank.getBankCode());
            dic.setDicValue(bank.getBankName());
            res.add(dic);
        }
        return new Resp(res);
    }

    /**
     * 根据产品编码获取它的子类型
     * @Title: getSubType
     * @Description: TODO
     * @param @param productCode
     * @param @return   
     * @return Resp 
     * @author wangguang 2017年5月22日 
     * @throws
     */
    @RequestMapping(value = "/getSubType", method = RequestMethod.GET)
    @ResponseBody
    public Resp getSubType(String productId) {
        List<ProductSubType> types = productSubTypeService.selectByProductCode(productId, getCurrentUser().getDomain());
        List<DataDic> res = new ArrayList<DataDic>();
        DataDic dic = null;
        for (ProductSubType st : types) {
            dic = new DataDic();
            dic.setDicKey(st.getId());
            dic.setDicValue(st.getName());
            res.add(dic);
        }
        return new Resp(res);
    }

}
