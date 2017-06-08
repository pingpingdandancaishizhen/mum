package cn.sunfit.risk.buz.server.util;

/**
 * 
 * @Title: ServerConfig.java
 * @Package com.rjs.rjr.util.vo
 * @Description: oss配置
 * @author yanlei
 * @date 2016年7月28日 下午1:26:13
 * @version V1.0
 */
public class ServerConfig {

    /*****************短信服务器*******************/
    private String messageServerUrl;// 消息服务器地址
    private String pathSendSms;// 发送短信路径
    private String pathSendEmail;// 发送邮件路径
    private String smsAppid;
    private boolean smsRandomCode;

    /*****************OSS*******************/
    private String oss_accessKey_id;
    private String oss_accessKey_secret;
    private String oss_endpoint;
    private String oss_bucketName;
    private String oss_url;

    /*****************疾风交单*******************/
    private String jf_host;

    /*****************乐位接口*******************/
    private String lw_host;

    public String getJf_host() {
        return jf_host;
    }

    public String getLw_host() {
        return lw_host;
    }

    public String getMessageServerUrl() {
        return messageServerUrl;
    }

    public String getOss_accessKey_id() {
        return oss_accessKey_id;
    }

    public String getOss_accessKey_secret() {
        return oss_accessKey_secret;
    }

    public String getOss_bucketName() {
        return oss_bucketName;
    }

    public String getOss_endpoint() {
        return oss_endpoint;
    }

    public String getOss_url() {
        return oss_url;
    }

    public String getPathSendEmail() {
        return pathSendEmail;
    }

    public String getPathSendSms() {
        return pathSendSms;
    }

    public String getSmsAppid() {
        return smsAppid;
    }

    public boolean isSmsRandomCode() {
        return smsRandomCode;
    }

    public void setJf_host(String jf_host) {
        this.jf_host = jf_host;
    }

    public void setLw_host(String lw_host) {
        this.lw_host = lw_host;
    }

    public void setMessageServerUrl(String messageServerUrl) {
        this.messageServerUrl = messageServerUrl;
    }

    public void setOss_accessKey_id(String oss_accessKey_id) {
        this.oss_accessKey_id = oss_accessKey_id;
    }

    public void setOss_accessKey_secret(String oss_accessKey_secret) {
        this.oss_accessKey_secret = oss_accessKey_secret;
    }

    public void setOss_bucketName(String oss_bucketName) {
        this.oss_bucketName = oss_bucketName;
    }

    public void setOss_endpoint(String oss_endpoint) {
        this.oss_endpoint = oss_endpoint;
    }

    public void setOss_url(String oss_url) {
        this.oss_url = oss_url;
    }

    public void setPathSendEmail(String pathSendEmail) {
        this.pathSendEmail = pathSendEmail;
    }

    public void setPathSendSms(String pathSendSms) {
        this.pathSendSms = pathSendSms;
    }

    public void setSmsAppid(String smsAppid) {
        this.smsAppid = smsAppid;
    }

    public void setSmsRandomCode(boolean smsRandomCode) {
        this.smsRandomCode = smsRandomCode;
    }

}
