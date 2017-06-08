package cn.sunfit.risk.buz.api.vo.loan;

import java.util.Date;
import java.util.List;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class LoanAuditQueryReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    private String productType;

    private String bpNo;

    private String custName;

    private String custLicenseNum;

    private String custType;

    private String loancarLicensePlate;

    private String currentTaskKey;

    private Date startDate;

    private Date endDate;

    private List<String> uids;

    public String getBpNo() {
        return bpNo;
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

    public List<String> getUids() {
        return uids;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
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

    public void setUids(List<String> uids) {
        this.uids = uids;
    }

}
