package cn.sunfit.risk.buz.api.vo.loan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class LoanSaveReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String corpId;

    private String bpId;

    private BigDecimal approvedAmount;

    private String userId;

    private BigDecimal loanAmount;

    private String loanPlatform;

    private String loanLender;

    private Date loanTime;

    private String znjFeeCal;

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public String getBpId() {
        return bpId;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getDomain() {
        return domain;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public String getLoanLender() {
        return loanLender;
    }

    public String getLoanPlatform() {
        return loanPlatform;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getZnjFeeCal() {
        return znjFeeCal;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanLender(String loanLender) {
        this.loanLender = loanLender;
    }

    public void setLoanPlatform(String loanPlatform) {
        this.loanPlatform = loanPlatform;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setZnjFeeCal(String znjFeeCal) {
        this.znjFeeCal = znjFeeCal;
    }

}
