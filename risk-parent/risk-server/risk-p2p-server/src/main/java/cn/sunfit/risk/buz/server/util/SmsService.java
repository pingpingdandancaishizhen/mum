package cn.sunfit.risk.buz.server.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.constants.ResponseStatus;
import cn.sunfit.risk.buz.api.vo.Resp;

/**
 * 短信服务
 */
@Service("smsService")
public class SmsService {

    public static final String PROJECT_ID = "ggcx";

    private static Logger logger = LoggerFactory.getLogger(SmsService.class);

    // 是否实时发送短信
    private Boolean isRealTime = true;

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 发送模块信息 
     * @param YTXparms 云通信参数  参数格式请参照service提供者
     * @param clazz 用于记录日志，确定来源
     * @author BUDDHA
     */
    @Async
    private <T> void doSend(String YTXparms, Class<T> clazz) {
        String fromDesc = clazz.getName();
        if (StringUtils.isBlank(fromDesc)) {
            fromDesc = "";
        }
        try {
            String result = HttpUtils.sendPost(serverConfig.getMessageServerUrl() + serverConfig.getPathSendSms(),
                    YTXparms);
            Resp smsResponse = null;
            if (StringUtils.isBlank(result)) {
                throw new RuntimeException(fromDesc + ":发送短信失败!未收到响应");
            }
            try {
                smsResponse = JsonUtil.jsonStrToObject(result, Resp.class);
            } catch (Exception e) {
                throw new RuntimeException(fromDesc + ":发送短信收到响应，但解析json出错!");
            }

            if (ResponseStatus.SUCCESS.getStatus() == smsResponse.getStatus()) {
                logger.info(fromDesc + " : 发送短信成功");
            } else {
                logger.info("ERROR INFO：" + smsResponse.getMessage());
                throw new RuntimeException(fromDesc + ":发送短信失败!");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 新的发送短信接口
     * @param phone
     * @param templateId
     * @param params
     */
    @Async
    public void sendMsg(String phone, String templateId, List<String> params) {
        try {
            SmsReq smsReq = new SmsReq();
            TemplateBase template = new TemplateBase();
            // 获取渠道 lzh_sms_template.third_party
            smsReq.setChannel("MEANINGLESS");
            smsReq.setPhoneNo(phone);
            smsReq.setTemplate(template);
            smsReq.setProjectId(PROJECT_ID);
            smsReq.setIsRealTime(this.isRealTime);
            template.setName(templateId);
            template.setParams(params);
            smsReq.setAppId(serverConfig.getSmsAppid());
            String jsonString = null;
            try {
                jsonString = JsonUtil.objectToJsonStr(smsReq);
            } catch (Exception e) {
                logger.error("发送手机短信，请求对象转化成JSON字符串异常", e);
            }
            doSend(jsonString, SmsService.class);
        } catch (Exception e) {
            logger.error(SmsService.class.getName() + ":" + e.getMessage());
        }
    }

    public void setIsRealTime(Boolean isRealTime) {
        this.isRealTime = isRealTime;
    }

}
