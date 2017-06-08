package cn.sunfit.risk.buz.server.util;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 短信
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SmsReq implements Serializable {

    private static final long serialVersionUID = 1L;
    // 短信渠道
    private String channel;

    // 电话号码
    private String phoneNo;

    // 短信模板ID
    // private String templateId;

    // 短信内容
    private String content;

    // 短信模板对应参数，如果有多个参数，以逗号分隔
    // private String params;

    // 指定的发送时间，若马上发送，为空即可
    private String triggerTime;

    // 发送短信的类型，营销类或者是验证类，如果是营销类，则type为：marketing,确认类为：confirm
    private String type;

    // 如果模板对象与 content 都不为空，则优先使用模板内容进行发送,仅当模板对象为空时，才使用content的内容作为发送内容
    private TemplateBase template;

    private String appId;

    private String projectId;

    private String sendType;// 发送类型,voice语音，sms短信

    private Boolean isRealTime = true;

    public String getAppId() {
        return appId;
    }

    public String getChannel() {
        return channel;
    }

    public String getContent() {
        return content;
    }

    public Boolean getIsRealTime() {
        return isRealTime;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getSendType() {
        return sendType;
    }

    public TemplateBase getTemplate() {
        return template;
    }

    public String getTriggerTime() {
        return triggerTime;
    }

    public String getType() {
        return type;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setIsRealTime(Boolean isRealTime) {
        this.isRealTime = isRealTime;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public void setTemplate(TemplateBase template) {
        this.template = template;
    }

    public void setTriggerTime(String triggerTime) {
        this.triggerTime = triggerTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RequestBase [channel=" + channel + ", phoneNo=" + phoneNo + ", content=" + content + ", template="
                + template + ", triggerTime=" + triggerTime + ", type=" + type + "]";
    }

}
