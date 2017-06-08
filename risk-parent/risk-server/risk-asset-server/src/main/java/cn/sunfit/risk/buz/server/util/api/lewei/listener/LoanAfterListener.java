package cn.sunfit.risk.buz.server.util.api.lewei.listener;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.solution.ProductDAO;
import cn.sunfit.risk.buz.server.util.ServerConfig;
import cn.sunfit.risk.buz.server.util.api.lewei.event.LoanAfterEvent;

@Component
public class LoanAfterListener implements ApplicationListener<LoanAfterEvent> {

    private static Logger log = LoggerFactory.getLogger(LoanAfterListener.class);

    private static String getAttr(List<BPAttr> attrs, String attrName) {
        String attr = null;
        for (BPAttr bpAttr : attrs) {
            if (StringUtils.equals(bpAttr.getAttrName(), attrName) && StringUtils.isNotBlank(bpAttr.getAttrValue())) {
                attr = bpAttr.getAttrValue();
                break;
            }
        }
        return attr;
    }

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private BPAttrDAO bpAttrDAO;

    @Autowired
    private ProductDAO productDAO;

    @Override
    public void onApplicationEvent(LoanAfterEvent event) {
        // if (event != null) {
        // Product product = productDAO.selectByPrimaryKey(event.getProductId());
        // if (StringUtils.equals(ProductMedium.C.getStatus(), product.getMedium())
        // && StringUtils.equals(ProductType.DYDK.getStatus(), product.getProductType())) {
        //
        // FormQuery r = new FormQuery();
        // r.setDomain(event.getDomain());
        // r.setBpId(event.getBpId());
        // List<BPAttr> attrs = bpAttrDAO.findByBP(r);
        //
        // ValueSelectReq req = new ValueSelectReq();
        // req.setBpId(event.getBpId());
        // req.setDicType("115");
        // req.setDicKey(getAttr(attrs, "loancar_car_color"));
        // req.setDomain(event.getDomain());
        // String color = bpAttrDAO.getValueFromDic(req);
        // event.setLicenseNum(getAttr(attrs, "loancar_license_plate"));
        // event.setMaster(getAttr(attrs, "cust_name"));
        // event.setBrand(getAttr(attrs, "loancar_car_bms_brand"));
        // event.setSeries(getAttr(attrs, "loancar_car_bms_series"));
        // event.setModel(getAttr(attrs, "loancar_car_bms_model"));
        // event.setColor(color);
        // event.setMasterPhone(getAttr(attrs, "cust_mobile"));
        // event.setMasterAddress(getAttr(attrs, "cust_live_addr"));
        // event.setLocalAddress("");
        // event.setMasterWorkAddress(getAttr(attrs, "custjob_company_addr"));
        // event.setLocalWordAddress("");
        // event.setSpeedCall("");
        // event.setFrameNum(getAttr(attrs, "loancar_frame_number"));
        // event.setEngineNum(getAttr(attrs, "loancar_engine_number"));
        // event.setPurchaseTime(getAttr(attrs, "loancar_purchase_date"));
        //
        // Map<String, Object> params = new HashMap<>();
        // String str = "";
        // try {
        // str = event.toJSON();
        // params.put("key", serverConfig.getLw_key());
        // params.put("data", str);
        // String sign = DigitalSignature.getSignature(params, serverConfig.getLw_secret());
        // params.put("sign", sign);
        // log.info("请求参数：{}", params);
        // } catch (IOException e) {
        // log.error(e.getMessage(), e);
        // }
        // String result = "";
        //
        // try {
        // result = HttpUtils.sendPost(serverConfig.getLw_host()
        // + "/standard/interface/carControl/saveLoanInfo.json", JsonUtil.objectToJsonStr(params));
        // log.info("第一次乐位通知结果：{}", result);
        // } catch (Exception e1) {
        // log.error(e1.getMessage(), e1);
        // }
        //
        // if (StringUtils.isNotBlank(result)) {
        // try {
        // Map<String, Integer> resultMap = JsonUtil.jsonStrToMap(result);
        // log.info("乐位通知结果：{}", resultMap.get("message"));
        // } catch (IOException e) {
        // log.error(e.getMessage(), e);
        // }
        // }
        // }
        // }
    }

}
