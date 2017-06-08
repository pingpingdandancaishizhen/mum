package cn.sunfit.risk.buz.api.beans.p2p.activiti;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.order.OrderStatus;

public class TodoQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String taskId;

    private String bpId;

    private String customerId;

    private String productTypeName;
    private String productId;

    private String bpDefId;

    private String bpDefKey;

    private String bpNo;

    private String taskName;

    private String custName;

    private String custGender;

    private String custGenderStr;

    private String custLicenseNum;

    private String custMobile;

    private String custType;

    private String custTypeStr;

    private String productType;

    private String productName;

    private Date createTime;

    private BigDecimal applyAmount;

    private String loanUsage;

    private String loanUsageStr;

    private String loanPeriod;

    private String loanRepaymentMethod;

    private String loanRepaymentMethodStr;

    private String loancarLicensePlate;

    private String loancarCarBrand;

    private String createUserId;

    private String currentTaskName;

    private String brandName;

    private String userName;

    private String deptName;

    private String deptHead;

    private String deptId;

    private String preOper;
    private String preReason;
    private BigDecimal loanMoney;
    private Date orderAddTime;

    private String corporation;
    private String loanInfoId;
    private String aproveStatus;
    private String processUser;
    private String preOperUserName;
    private Date preOperTime;

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public String getAproveStatus() {
        return aproveStatus;
    }

    public String getAproveStatusStr() {
        return OrderStatus.getLabelByStatus(aproveStatus);
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpDefKey() {
        return bpDefKey;
    }

    public String getBpId() {
        return bpId;
    }

    public String getBpNo() {
        return bpNo;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getCorporation() {
        return corporation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getCurrentTaskName() {
        return currentTaskName;
    }

    public String getCustGender() {
        return custGender;
    }

    public String getCustGenderStr() {
        return custGenderStr;
    }

    public String getCustLicenseNum() {
        return custLicenseNum;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustType() {
        return custType;
    }

    public String getCustTypeStr() {
        return custTypeStr;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getLoanApplyPeriodStr() {
        if (StringUtils.startsWith(loanPeriod, "M")) {
            return loanPeriod.replace("M", "") + "月";
        } else if (StringUtils.startsWith(loanPeriod, "D")) {
            return loanPeriod.replace("D", "") + "天";
        } else {
            return "";
        }
    }

    public String getLoancarCarBrand() {
        return loancarCarBrand;
    }

    public String getLoancarLicensePlate() {
        return loancarLicensePlate;
    }

    public String getLoanInfoId() {
        return loanInfoId;
    }

    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    public String getLoanRepaymentMethod() {
        return loanRepaymentMethod;
    }

    public String getLoanRepaymentMethodStr() {
        return loanRepaymentMethodStr;
    }

    public String getLoanUsage() {
        return loanUsage;
    }

    public String getLoanUsageStr() {
        return loanUsageStr;
    }

    public Date getOrderAddTime() {
        return orderAddTime;
    }

    public String getPreOper() {
        return preOper;
    }

    public Date getPreOperTime() {
        return preOperTime;
    }

    public String getPreOperUserName() {
        return preOperUserName;
    }

    public String getPreReason() {
        return preReason;
    }

    public String getProcessUser() {
        return processUser;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductTypeName() {
        return productTypeName;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getUserName() {
        return userName;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public void setAproveStatus(String aproveStatus) {
        this.aproveStatus = aproveStatus;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setBpDefKey(String bpDefKey) {
        this.bpDefKey = bpDefKey;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }

    public void setCustGender(String custGender) {
        this.custGender = custGender;
    }

    public void setCustGenderStr(String custGenderStr) {
        this.custGenderStr = custGenderStr;
    }

    public void setCustLicenseNum(String custLicenseNum) {
        this.custLicenseNum = custLicenseNum;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public void setCustTypeStr(String custTypeStr) {
        this.custTypeStr = custTypeStr;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setLoancarCarBrand(String loancarCarBrand) {
        this.loancarCarBrand = loancarCarBrand;
    }

    public void setLoancarLicensePlate(String loancarLicensePlate) {
        this.loancarLicensePlate = loancarLicensePlate;
    }

    public void setLoanInfoId(String loanInfoId) {
        this.loanInfoId = loanInfoId;
    }

    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    public void setLoanRepaymentMethod(String loanRepaymentMethod) {
        this.loanRepaymentMethod = loanRepaymentMethod;
    }

    public void setLoanRepaymentMethodStr(String loanRepaymentMethodStr) {
        this.loanRepaymentMethodStr = loanRepaymentMethodStr;
    }

    public void setLoanUsage(String loanUsage) {
        this.loanUsage = loanUsage;
    }

    public void setLoanUsageStr(String loanUsageStr) {
        this.loanUsageStr = loanUsageStr;
    }

    public void setOrderAddTime(Date orderAddTime) {
        this.orderAddTime = orderAddTime;
    }

    public void setPreOper(String preOper) {
        this.preOper = preOper;
    }

    public void setPreOperTime(Date preOperTime) {
        this.preOperTime = preOperTime;
    }

    public void setPreOperUserName(String preOperUserName) {
        this.preOperUserName = preOperUserName;
    }

    public void setPreReason(String preReason) {
        this.preReason = preReason;
    }

    public void setProcessUser(String processUser) {
        this.processUser = processUser;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
