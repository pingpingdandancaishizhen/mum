package cn.sunfit.risk.credit.api.beans;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class ApiLog extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String ipAddress;

    private String uid;

    private String apiPlatform;

    private String apiName;

    private Date reqTime;

    private String req;

    private boolean cached;

    private String resp;

    public String getApiName() {
        return apiName;
    }

    public String getApiPlatform() {
        return apiPlatform;
    }

    public String getId() {
        return id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getReq() {
        return req;
    }

    public Date getReqTime() {
        return reqTime;
    }

    public String getResp() {
        return resp;
    }

    public String getUid() {
        return uid;
    }

    public boolean isCached() {
        return cached;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public void setApiPlatform(String apiPlatform) {
        this.apiPlatform = apiPlatform == null ? null : apiPlatform.trim();
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }

    public void setReq(String req) {
        this.req = req == null ? null : req.trim();
    }

    public void setReqTime(Date reqTime) {
        this.reqTime = reqTime;
    }

    public void setResp(String resp) {
        this.resp = resp == null ? null : resp.trim();
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}