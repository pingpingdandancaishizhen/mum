package cn.sunfit.risk.buz.api.vo.activiti;

import java.util.Date;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class TodoQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String uid;

    private String corpId;

    private String productType;

    private String bpNo;

    private String custName;

    private String custLicenseNum;

    private String custType;

    private String loancarLicensePlate;

    private String currentTaskKey;

    private Date startDate;

    private Date endDate;

    public String getBpNo() {
        return bpNo;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getCurrentTaskKey() {
        return currentTaskKey;
    }

    public String getCustLicenseNum() {
        return custLicenseNum;
    }

    public String getCustName() {
        return custName;
    }

    public String getCustType() {
        return custType;
    }

    public String getDomain() {
        return domain;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getLoancarLicensePlate() {
        return loancarLicensePlate;
    }

    public String getProductType() {
        return productType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getUid() {
        return uid;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCurrentTaskKey(String currentTaskKey) {
        this.currentTaskKey = currentTaskKey;
    }

    public void setCustLicenseNum(String custLicenseNum) {
        this.custLicenseNum = custLicenseNum;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setLoancarLicensePlate(String loancarLicensePlate) {
        this.loancarLicensePlate = loancarLicensePlate;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
