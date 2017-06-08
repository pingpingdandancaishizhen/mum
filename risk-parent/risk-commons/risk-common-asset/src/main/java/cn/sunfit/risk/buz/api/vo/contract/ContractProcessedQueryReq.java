package cn.sunfit.risk.buz.api.vo.contract;

import java.util.Date;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class ContractProcessedQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String uid;

    private String corpId;

    private String productType_processed;

    private String bpNo_processed;

    private String custName_processed;

    private String custLicenseNum_processed;

    private String custType_processed;

    private String loancarLicensePlate_processed;

    private String contractNo_processed;

    private String deptId_processed;

    private Date startDate_processed;

    private Date endDate_processed;

    private String currentTaskKey_processed;

    private String contractSigner_processed;

    public ContractQueryReq copyToReq() {
        ContractQueryReq req = new ContractQueryReq();
        req.setBpNo(this.bpNo_processed);
        req.setContractNo(this.contractNo_processed);
        req.setCorpId(this.corpId);
        req.setCurrentPage(this.getCurrentPage());
        req.setCustLicenseNum(this.custLicenseNum_processed);
        req.setCustName(this.custName_processed);
        req.setCustType(this.custType_processed);
        req.setDomain(this.domain);
        req.setLoancarLicensePlate(this.loancarLicensePlate_processed);
        req.setPaseSize(this.getPaseSize());
        req.setProductType(this.productType_processed);
        req.setUid(this.uid);
        req.setStartDate(this.startDate_processed);
        req.setEndDate(this.endDate_processed);
        req.setCurrentTaskKey(this.currentTaskKey_processed);
        req.setContractSigner(this.contractSigner_processed);
        return req;
    }

    public String getBpNo_processed() {
        return bpNo_processed;
    }

    public String getContractNo_processed() {
        return contractNo_processed;
    }

    public String getContractSigner_processed() {
        return contractSigner_processed;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getCurrentTaskKey_processed() {
        return currentTaskKey_processed;
    }

    public String getCustLicenseNum_processed() {
        return custLicenseNum_processed;
    }

    public String getCustName_processed() {
        return custName_processed;
    }

    public String getCustType_processed() {
        return custType_processed;
    }

    public String getDeptId_processed() {
        return deptId_processed;
    }

    public String getDomain() {
        return domain;
    }

    public Date getEndDate_processed() {
        return endDate_processed;
    }

    public String getLoancarLicensePlate_processed() {
        return loancarLicensePlate_processed;
    }

    public String getProductType_processed() {
        return productType_processed;
    }

    public Date getStartDate_processed() {
        return startDate_processed;
    }

    public String getUid() {
        return uid;
    }

    public void setBpNo_processed(String bpNo_processed) {
        this.bpNo_processed = bpNo_processed;
    }

    public void setContractNo_processed(String contractNo_processed) {
        this.contractNo_processed = contractNo_processed;
    }

    public void setContractSigner_processed(String contractSigner_processed) {
        this.contractSigner_processed = contractSigner_processed;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCurrentTaskKey_processed(String currentTaskKey_processed) {
        this.currentTaskKey_processed = currentTaskKey_processed;
    }

    public void setCustLicenseNum_processed(String custLicenseNum_processed) {
        this.custLicenseNum_processed = custLicenseNum_processed;
    }

    public void setCustName_processed(String custName_processed) {
        this.custName_processed = custName_processed;
    }

    public void setCustType_processed(String custType_processed) {
        this.custType_processed = custType_processed;
    }

    public void setDeptId_processed(String deptId_processed) {
        this.deptId_processed = deptId_processed;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEndDate_processed(Date endDate_processed) {
        this.endDate_processed = endDate_processed;
    }

    public void setLoancarLicensePlate_processed(String loancarLicensePlate_processed) {
        this.loancarLicensePlate_processed = loancarLicensePlate_processed;
    }

    public void setProductType_processed(String productType_processed) {
        this.productType_processed = productType_processed;
    }

    public void setStartDate_processed(Date startDate_processed) {
        this.startDate_processed = startDate_processed;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
