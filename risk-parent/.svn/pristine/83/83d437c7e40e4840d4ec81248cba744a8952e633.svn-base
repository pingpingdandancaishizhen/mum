package cn.sunfit.risk.buz.server.util.api.lewei.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.context.ApplicationEvent;

import cn.sunfit.risk.buz.server.util.JsonUtil;

public class FromSubmitEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private String bpId;

    private String domain;

    private String productId;

    private String licenseNum;

    private String master;

    private String brand;

    private String series;

    private String model;

    private String color;

    private String masterPhone;

    private String masterAddress;

    private String localAddress;

    private String masterWorkAddress;

    private String localWordAddress;

    private String speedCall;

    private String frameNum;

    private String engineNum;

    private String purchaseTime;

    public FromSubmitEvent(Object source, String bpId, String domain, String productId) {
        super(source);
        this.bpId = bpId;
        this.domain = domain;
        this.productId = productId;
    }

    public String getBpId() {
        return bpId;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getDomain() {
        return domain;
    }

    public String getEngineNum() {
        return engineNum;
    }

    public String getFrameNum() {
        return frameNum;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public String getLocalWordAddress() {
        return localWordAddress;
    }

    public String getMaster() {
        return master;
    }

    public String getMasterAddress() {
        return masterAddress;
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public String getMasterWorkAddress() {
        return masterWorkAddress;
    }

    public String getModel() {
        return model;
    }

    public String getProductId() {
        return productId;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public String getSeries() {
        return series;
    }

    public String getSpeedCall() {
        return speedCall;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEngineNum(String engineNum) {
        this.engineNum = engineNum;
    }

    public void setFrameNum(String frameNum) {
        this.frameNum = frameNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public void setLocalWordAddress(String localWordAddress) {
        this.localWordAddress = localWordAddress;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void setMasterAddress(String masterAddress) {
        this.masterAddress = masterAddress;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    public void setMasterWorkAddress(String masterWorkAddress) {
        this.masterWorkAddress = masterWorkAddress;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public void setSpeedCall(String speedCall) {
        this.speedCall = speedCall;
    }

    public String toJSON() throws JsonGenerationException, JsonMappingException, IOException {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = new HashMap<String, String>();
        map.put("licenseNum", this.licenseNum);
        map.put("master", this.master);
        map.put("brand", this.brand);
        map.put("series", this.series);
        map.put("model", this.model);
        map.put("color", this.color);
        map.put("masterPhone", this.masterPhone);
        map.put("masterAddress", this.masterAddress);
        map.put("localAddress", "");
        map.put("masterWorkAddress", this.masterWorkAddress);
        map.put("localWordAddress", "");
        map.put("speedCall", "");
        map.put("frameNum", this.frameNum);
        map.put("engineNum", this.engineNum);
        map.put("purchaseTime", this.purchaseTime);
        list.add(map);
        return JsonUtil.objectToJsonStr(list);
    }

}
