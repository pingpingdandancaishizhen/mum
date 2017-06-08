package cn.sunfit.risk.buz.server.util.api.jfjd.listener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.loan.LoanChannel;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;
import cn.sunfit.risk.buz.api.utils.api.jfjd.Base64;
import cn.sunfit.risk.buz.api.utils.api.jfjd.HttpUtils;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusGetReq;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFBPDAO;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFProductDAO;
import cn.sunfit.risk.buz.server.util.JsonUtil;
import cn.sunfit.risk.buz.server.util.ServerConfig;
import cn.sunfit.risk.buz.server.util.api.jfjd.event.BpStatusChangeEvent;

@Component
public class BpStatusListener implements ApplicationListener<BpStatusChangeEvent> {

    private static Logger log = LoggerFactory.getLogger(BpStatusListener.class);

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private JFProductDAO jFProductDAO;

    @Autowired
    private JFBPDAO jFBPDAO;

    @Override
    public void onApplicationEvent(BpStatusChangeEvent event) {
        if (event != null) {
            // 判断是否有产品编号，如果没有重新获取
            if (StringUtils.isBlank(event.getProdType())) {
                event.setProdType(jFBPDAO.getProductByBp(new JFBpStatusGetReq(event.getBpId(), event.getDomain())));
            }

            // 查询产品是否支持疾风
            int prdCount = jFProductDAO.selectCountByIdForJF(event.getProdType());
            // 计算订单状态
            if (prdCount > 0 && StringUtils.isNotBlank(event.getBpId())
                    && LoanChannel.JFJD.getStatus().equals(event.getBpChannel())) {

                Integer loanStatus = jFBPDAO.getLoanStatus(new JFBpStatusGetReq(event.getBpId(), event.getDomain()));
                if (BpStatus.LOAN_ING.equals(BpStatus.getByStatus(event.getBpStatus()))) {
                    event.setCurrentTaskName(LoanStatus.getNameByStatus(loanStatus).getStatusName());
                } else if (BpStatus.LOAN_AFTER.equals(BpStatus.getByStatus(event.getBpStatus()))) {
                    event.setCurrentTaskName(RepaymentBaseStatus.getNameByStatus(event.getRepayStatus())
                            .getStatusName());
                } else if (BpStatus.LOAN_FINISH.equals(BpStatus.getByStatus(event.getBpStatus()))) {
                    event.setCurrentTaskName(BpStatus.LOAN_FINISH.getLabel());
                } else {
                    if (StringUtils.isNotBlank(event.getCurrentTaskName())) {
                        event.setCurrentTaskName(event.getCurrentTaskName().substring(1,
                                event.getCurrentTaskName().length() - 1));
                    }
                }

                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", event.getBpId());
                map.put("prodType", event.getProdType());
                map.put("status", event.getCurrentTaskName());
                map.put("comment", event.getComment());
                String str = "";

                try {
                    str = JsonUtil.objectToJsonStr(map);
                    log.info("请求参数：{}", str);
                    str = Base64.getBASE64(str);
                } catch (IOException e) {
                    log.error(e.getMessage(), e);
                }
                String result = "";

                try {
                    result = HttpUtils.sendPost(serverConfig.getJf_host() + "/borrowerAudit/v1/dataAudit.json", str);
                    log.info("第一次疾风通知结果：{}", result);
                } catch (Exception e1) {
                    log.error(e1.getMessage(), e1);
                    // 如果第一次发送失败，休眠2秒钟再发一次
                    try {
                        Thread.sleep(2000);
                        result = HttpUtils
                                .sendPost(serverConfig.getJf_host() + "/borrowerAudit/v1/dataAudit.json", str);
                        log.info("第二次疾风通知结果：{}", result);
                    } catch (Exception e2) {
                        log.error(e2.getMessage(), e2);
                        // 如果第二次发送失败，休眠3秒钟再发一次
                        try {
                            Thread.sleep(3000);
                            result = HttpUtils.sendPost(serverConfig.getJf_host() + "/borrowerAudit/v1/dataAudit.json",
                                    str);
                            log.info("第三次疾风通知结果：{}", result);
                        } catch (Exception e3) {
                            log.error(e3.getMessage(), e3);
                        }
                    }
                }

                if (StringUtils.isNotBlank(result)) {
                    try {
                        Map<String, Object> resultMap = JsonUtil.jsonStrToMap(result);
                        log.info("疾风通知结果：{}", Base64.getFromBASE64((String) resultMap.get("message")));
                    } catch (IOException e) {
                        log.error(e.getMessage(), e);
                    }
                }
            }
        }
    }
}
