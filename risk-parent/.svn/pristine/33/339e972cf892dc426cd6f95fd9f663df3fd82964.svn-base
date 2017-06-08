package cn.sunfit.risk.buz.api.beans.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.LoginChannel;

public class LoginLog extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private Date createTime;

    private String channel;

    private String ip;

    private String status;

    private String address;

    private String country;

    private String region;

    private String city;

    private String isp;

    private String userId;

    public String getAddress() {
        return address;
    }

    public String getChannel() {
        return channel;
    }

    public String getChannelStr() {
        return LoginChannel.getLabelByStatus(this.channel);
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateTimeStr() {
        return new SimpleDateFormat(GlobalConstants.DATE_FORMAT_DATE_TIME).format(createTime);
    }

    public String getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public String getIsp() {
        return isp;
    }

    public String getRegion() {
        return region;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public void setIsp(String isp) {
        this.isp = isp == null ? null : isp.trim();
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}