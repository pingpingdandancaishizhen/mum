package cn.sunfit.risk.buz.server.util.api.lewei.event;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.context.ApplicationEvent;

import cn.sunfit.risk.buz.server.util.JsonUtil;

public class LoanAfterEvent extends ApplicationEvent {

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

    private String backPay;

    private String backPayName;

    private String borrowProperty;

    private String borrowPropertyName;

    private String borrowExpires;

    private String borrowMoney;

    private String loanTime;

    private String borrowOrderId;

    private String backStatus;

    private String overDay;

    private String residualPrincipal;

    private String orderStatusName;

    private Integer residualPeriod;

    private String settleTime;

    public LoanAfterEvent(Object source, String bpId, String domain, String productId, String backPay,
            String backPayName, String borrowProperty, String borrowPropertyName, String borrowExpires,
            String borrowMoney, String loanTime, String borrowOrderId, String backStatus, String overDay,
            String residualPrincipal, String orderStatusName, Integer residualPeriod, String settleTime) {
        super(source);
        this.bpId = bpId;
        this.domain = domain;
        this.productId = productId;
        this.backPay = backPay;
        this.backPayName = backPayName;
        this.borrowProperty = borrowProperty;
        this.borrowPropertyName = borrowPropertyName;
        this.borrowExpires = borrowExpires;
        this.borrowMoney = borrowMoney;
        this.loanTime = loanTime;
        this.borrowOrderId = borrowOrderId;
        this.backStatus = backStatus;
        this.overDay = overDay;
        this.residualPrincipal = residualPrincipal;
        this.orderStatusName = orderStatusName;
        this.residualPeriod = residualPeriod;
        this.settleTime = settleTime;
    }

    public String getBackPay() {
        return backPay;
    }

    public String getBackPayName() {
        return backPayName;
    }

    public String getBackStatus() {
        return backStatus;
    }

    public String getBorrowExpires() {
        return borrowExpires;
    }

    public String getBorrowMoney() {
        return borrowMoney;
    }

    public String getBorrowOrderId() {
        return borrowOrderId;
    }

    public String getBorrowProperty() {
        return borrowProperty;
    }

    public String getBorrowPropertyName() {
        return borrowPropertyName;
    }

    public String getBpId() {
        return bpId;
    }

    public String getDomain() {
        return domain;
    }

    public String getLoanTime() {
        return loanTime;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public String getOverDay() {
        return overDay;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getResidualPeriod() {
        return residualPeriod;
    }

    public String getResidualPrincipal() {
        return residualPrincipal;
    }

    public String getSettleTime() {
        return settleTime;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
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
        map.put("backPay", this.backPay);
        map.put("backPayName", this.backPayName);
        map.put("borrowProperty", this.borrowProperty);
        map.put("borrowPropertyName", this.borrowPropertyName);
        map.put("borrowExpires", this.borrowExpires);
        map.put("borrowMoney", this.borrowMoney);
        map.put("loanTime", this.loanTime);
        map.put("borrowOrderId", this.borrowOrderId);
        map.put("backStatus", this.backStatus);
        map.put("overDay", this.overDay);
        map.put("residualPrincipal", this.residualPrincipal);
        map.put("orderStatusName", this.orderStatusName);
        map.put("residualPeriod", this.residualPeriod + "");
        map.put("settleTime", this.settleTime);
        return JsonUtil.objectToJsonStr(map);
    }

}
