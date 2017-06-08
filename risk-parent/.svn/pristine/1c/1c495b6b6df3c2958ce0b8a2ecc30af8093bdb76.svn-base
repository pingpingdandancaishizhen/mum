package cn.sunfit.risk.buz.server.util.api.lewei.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import orj.worf.util.StringUtils;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectReq;
import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.constants.ProductMedium;
import cn.sunfit.risk.buz.api.constants.ProductType;
import cn.sunfit.risk.buz.api.vo.corp.CorpLwInfoVO;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.solution.ProductDAO;
import cn.sunfit.risk.buz.server.util.DigitalSignature;
import cn.sunfit.risk.buz.server.util.HttpUtils;
import cn.sunfit.risk.buz.server.util.JsonUtil;
import cn.sunfit.risk.buz.server.util.ServerConfig;
import cn.sunfit.risk.buz.server.util.api.lewei.event.FromSubmitEvent;

@Component
public class FromSubmitListener implements ApplicationListener<FromSubmitEvent> {

    private static Logger log = LoggerFactory.getLogger(FromSubmitListener.class);

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

    @Autowired
    private CorpDAO corpDAO;

    @Override
    public void onApplicationEvent(FromSubmitEvent event) {
        if (event != null) {
            CorpLwInfoVO corp = corpDAO.selectLwInfoByDomain(event.getDomain());
            if (corp != null && corp.getLwKey() != null && corp.getLwSecret() != null) {
                Product product = productDAO.selectByPrimaryKey(event.getProductId());
                if (StringUtils.equals(ProductMedium.C.getStatus(), product.getMedium())
                        && StringUtils.equals(ProductType.DYDK.getStatus(), product.getProductType())) {
                    FormQuery r = new FormQuery();
                    r.setDomain(event.getDomain());
                    r.setBpId(event.getBpId());
                    List<BPAttr> attrs = bpAttrDAO.findByBP(r);

                    ValueSelectReq req = new ValueSelectReq();
                    req.setBpId(event.getBpId());
                    req.setDicType("115");
                    req.setDicKey(getAttr(attrs, "loancar_car_color"));
                    req.setDomain(event.getDomain());
                    String color = bpAttrDAO.getValueFromDic(req);
                    event.setLicenseNum(getAttr(attrs, "loancar_license_plate"));
                    event.setMaster(getAttr(attrs, "cust_name"));
                    event.setBrand(getAttr(attrs, "loancar_car_bms_brand"));
                    event.setSeries(getAttr(attrs, "loancar_car_bms_series"));
                    event.setModel(getAttr(attrs, "loancar_car_bms_model"));
                    event.setColor(color);
                    event.setMasterPhone(getAttr(attrs, "cust_mobile"));
                    event.setMasterAddress(getAttr(attrs, "cust_live_addr"));
                    event.setLocalAddress("");
                    event.setMasterWorkAddress(getAttr(attrs, "custjob_company_addr"));
                    event.setLocalWordAddress("");
                    event.setSpeedCall("");
                    event.setFrameNum(getAttr(attrs, "loancar_frame_number"));
                    event.setEngineNum(getAttr(attrs, "loancar_engine_number"));
                    event.setPurchaseTime(getAttr(attrs, "loancar_purchase_date"));

                    sendRequest2Lw(event, corp.getLwKey(), corp.getLwSecret());
                }
            }
        }
    }

    private void sendRequest2Lw(final FromSubmitEvent event, final String key, final String secret) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                String result = "";
                try {
                    Map<String, Object> params = new HashMap<>();
                    params.put("key", key);
                    params.put("data", event.toJSON());
                    String sign = DigitalSignature.getSignature(params, secret);
                    params.put("sign", sign);
                    log.info("请求参数：{}", params);
                    result = HttpUtils.sendPost(serverConfig.getLw_host()
                            + "/standard/interface/carControl/saveOrUpdateInfo.json", JsonUtil.objectToJsonStr(params));
                    log.info("第一次乐位通知结果：{}", result);
                } catch (IOException e) {
                    sendRequest2Lw(event, key, secret);
                }
            }
        }).start();

    }

}
