package cn.sunfit.risk.buz.api.vo.contract;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class ContractProcessingQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String uid;

    private String corpId;

    private String productType_processing;

    private String bpNo_processing;

    private String custName_processing;

    private String custLicenseNum_processing;

    private String custType_processing;

    private String loancarLicensePlate_processing;

    private String contractNo_processing;

    private String deptId_processing;

    private String currentTaskKey_processing;

    private String contractSigner_processing;

    public ContractQueryReq copyToReq() {
        ContractQueryReq req = new ContractQueryReq();
        req.setBpNo(this.bpNo_processing);
        req.setContractNo(this.contractNo_processing);
        req.setCorpId(this.corpId);
        req.setCurrentPage(this.getCurrentPage());
        req.setCustLicenseNum(this.custLicenseNum_processing);
        req.setCustName(this.custName_processing);
        req.setCustType(this.custType_processing);
        req.setDomain(this.domain);
        req.setLoancarLicensePlate(this.loancarLicensePlate_processing);
        req.setPaseSize(this.getPaseSize());
        req.setProductType(this.productType_processing);
        req.setUid(this.uid);
        req.setCurrentTaskKey(this.currentTaskKey_processing);
        req.setContractSigner(this.contractSigner_processing);
        return req;
    }

    public String getBpNo_processing() {
        return bpNo_processing;
    }

    public String getContractNo_processing() {
        return contractNo_processing;
    }

    public String getContractSigner_processing() {
        return contractSigner_processing;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getCurrentTaskKey_processing() {
        return currentTaskKey_processing;
    }

    public String getCustLicenseNum_processing() {
        return custLicenseNum_processing;
    }

    public String getCustName_processing() {
        return custName_processing;
    }

    public String getCustType_processing() {
        return custType_processing;
    }

    public String getDeptId_processing() {
        return deptId_processing;
    }

    public String getDomain() {
        return domain;
    }

    public String getLoancarLicensePlate_processing() {
        return loancarLicensePlate_processing;
    }

    public String getProductType_processing() {
        return productType_processing;
    }

    public String getUid() {
        return uid;
    }

    public void setBpNo_processing(String bpNo_processing) {
        this.bpNo_processing = bpNo_processing;
    }

    public void setContractNo_processing(String contractNo_processing) {
        this.contractNo_processing = contractNo_processing;
    }

    public void setContractSigner_processing(String contractSigner_processing) {
        this.contractSigner_processing = contractSigner_processing;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCurrentTaskKey_processing(String currentTaskKey_processing) {
        this.currentTaskKey_processing = currentTaskKey_processing;
    }

    public void setCustLicenseNum_processing(String custLicenseNum_processing) {
        this.custLicenseNum_processing = custLicenseNum_processing;
    }

    public void setCustName_processing(String custName_processing) {
        this.custName_processing = custName_processing;
    }

    public void setCustType_processing(String custType_processing) {
        this.custType_processing = custType_processing;
    }

    public void setDeptId_processing(String deptId_processing) {
        this.deptId_processing = deptId_processing;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setLoancarLicensePlate_processing(String loancarLicensePlate_processing) {
        this.loancarLicensePlate_processing = loancarLicensePlate_processing;
    }

    public void setProductType_processing(String productType_processing) {
        this.productType_processing = productType_processing;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
