package cn.sunfit.risk.buz.api.vo.corp;

import java.util.Date;
import java.util.List;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class BpQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String uid;

    private String corpId;

    private String productType;

    private String bpId;

    private String bpNo;

    private String custName;

    private String custLicenseNum;

    private String custType;

    private String loancarLicensePlate;

    private String status;

    private String currentTaskKey;

    private Date startDate;

    private Date endDate;

    private String loanType;

    private List<String> uids;

    public String getBpId() {
        return bpId;
    }

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

    public String getLoanType() {
        return loanType;
    }

    public String getProductType() {
        return productType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public String getStatus() {
        return status;
    }

    public String getUid() {
        return uid;
    }

    public List<String> getUids() {
        return uids;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
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

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUids(List<String> uids) {
        this.uids = uids;
    }

}
