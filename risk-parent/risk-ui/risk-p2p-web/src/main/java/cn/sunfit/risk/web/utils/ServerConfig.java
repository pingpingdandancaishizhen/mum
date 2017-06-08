package cn.sunfit.risk.web.utils;

import org.springframework.beans.factory.annotation.Value;

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

    /*****************OSS*******************/
    private String oss_accessKey_id;
    private String oss_accessKey_secret;
    private String oss_endpoint;
    private String oss_bucketName;
    private String oss_url;
    
    /***************fengkong services***************/
    private String fengkong_api_services;

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

    public String getFengkong_api_services() {
        return fengkong_api_services;
    }

    public void setFengkong_api_services(String fengkong_api_services) {
        this.fengkong_api_services = fengkong_api_services;
    }

}
