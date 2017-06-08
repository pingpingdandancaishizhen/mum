package cn.sunfit.risk.buz.api.vo.generalinfo;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class GeneralInfoQueryReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = -8522419026574461071L;

    private String custId;

    private String productType;

    private String bpNo;

    private String custName;

    private String licenseNo;

    private String custType;

    private String carNo;

    private String currTaskKey;

    private String contractNo;

    private String loanType;

    private Date applyStartDate;

    private Date applyEndDate;

    private String auditStatus;

    private String loanShare;

    private Date lendStartDate;

    private Date lendEndDate;

    private String owenStore;

    private String approveLine;

    private String daylyTerm;

    private String monthlyTerm;

    private String repayStatus;

    private String repayedTerm;

    private String tenderStatus;

    private String repaymentMethod;

    private Date tenderStartDate;

    private Date tenderEndDate;

    private String orderSource;

    private String loanPlatform;

    public void Decode4Request() throws UnsupportedEncodingException {
        this.custName = new String(this.custName.getBytes("ISO8859-1"));
        this.carNo = new String(this.carNo.getBytes("ISO8859-1"));
    }

    public Date getApplyEndDate() {
        return applyEndDate;
    }

    public Date getApplyStartDate() {
        return applyStartDate;
    }

    public String getApproveLine() {
        return approveLine;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public String getBpNo() {
        return bpNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public String getCurrTaskKey() {
        return currTaskKey;
    }

    public String getCustId() {
        return custId;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustType() {
        return custType;
    }

    public String getDaylyTerm() {
        return daylyTerm;
    }

    public Date getLendEndDate() {
        return lendEndDate;
    }

    public Date getLendStartDate() {
        return lendStartDate;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public String getLoanPlatform() {
        return loanPlatform;
    }

    public String getLoanShare() {
        return loanShare;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getMonthlyTerm() {
        return monthlyTerm;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public String getOwenStore() {
        return owenStore;
    }

    public String getProductType() {
        return productType;
    }

    public String getRepayedTerm() {
        return repayedTerm;
    }

    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public Date getTenderEndDate() {
        return tenderEndDate;
    }

    public Date getTenderStartDate() {
        return tenderStartDate;
    }

    public String getTenderStatus() {
        return tenderStatus;
    }

    public void setApplyEndDate(Date applyEndDate) {
        this.applyEndDate = applyEndDate;
    }

    public void setApplyStartDate(Date applyStartDate) {
        this.applyStartDate = applyStartDate;
    }

    public void setApproveLine(String approveLine) {
        if (StringUtils.isNotBlank(approveLine)) {
            if (approveLine.startsWith("D")) {
                this.daylyTerm = approveLine.replace("D", "");
            } else {
                this.monthlyTerm = approveLine;
            }
        }
        this.approveLine = approveLine;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public void setCurrTaskKey(String currTaskKey) {
        this.currTaskKey = currTaskKey;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public void setDaylyTerm(String daylyTerm) {
        this.daylyTerm = daylyTerm;
    }

    public void setLendEndDate(Date lendEndDate) {
        this.lendEndDate = lendEndDate;
    }

    public void setLendStartDate(Date lendStartDate) {
        this.lendStartDate = lendStartDate;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void setLoanPlatform(String loanPlatform) {
        this.loanPlatform = loanPlatform;
    }

    public void setLoanShare(String loanShare) {
        this.loanShare = loanShare;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setMonthlyTerm(String monthlyTerm) {
        this.monthlyTerm = monthlyTerm;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public void setOwenStore(String owenStore) {
        this.owenStore = owenStore;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setRepayedTerm(String repayedTerm) {
        this.repayedTerm = repayedTerm;
    }

    public void setRepaymentMethod(String repaymentMethod) {
        this.repaymentMethod = repaymentMethod;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public void setTenderEndDate(Date tenderEndDate) {
        this.tenderEndDate = tenderEndDate;
    }

    public void setTenderStartDate(Date tenderStartDate) {
        this.tenderStartDate = tenderStartDate;
    }

    public void setTenderStatus(String tenderStatus) {
        this.tenderStatus = tenderStatus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GeneralInfoQueryReq [custId=");
        builder.append(custId);
        builder.append(", productType=");
        builder.append(productType);
        builder.append(", bpNo=");
        builder.append(bpNo);
        builder.append(", custName=");
        builder.append(custName);
        builder.append(", licenseNo=");
        builder.append(licenseNo);
        builder.append(", custType=");
        builder.append(custType);
        builder.append(", carNo=");
        builder.append(carNo);
        builder.append(", currTaskKey=");
        builder.append(currTaskKey);
        builder.append(", contractNo=");
        builder.append(contractNo);
        builder.append(", loanType=");
        builder.append(loanType);
        builder.append(", applyStartDate=");
        builder.append(applyStartDate);
        builder.append(", applyEndDate=");
        builder.append(applyEndDate);
        builder.append(", auditStatus=");
        builder.append(auditStatus);
        builder.append(", loanShare=");
        builder.append(loanShare);
        builder.append(", lendStartDate=");
        builder.append(lendStartDate);
        builder.append(", lendEndDate=");
        builder.append(lendEndDate);
        builder.append(", owenStore=");
        builder.append(owenStore);
        builder.append(", approveLine=");
        builder.append(approveLine);
        builder.append(", repayStatus=");
        builder.append(repayStatus);
        builder.append(", repayedTerm=");
        builder.append(repayedTerm);
        builder.append(", tenderStatus=");
        builder.append(tenderStatus);
        builder.append(", repaymentMethod=");
        builder.append(repaymentMethod);
        builder.append(", tenderStartDate=");
        builder.append(tenderStartDate);
        builder.append(", tenderEndDate=");
        builder.append(tenderEndDate);
        builder.append(", orderSource=");
        builder.append(orderSource);
        builder.append(", loanPlatform=");
        builder.append(loanPlatform);
        builder.append("]");
        return builder.toString();
    }

}
