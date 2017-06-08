package cn.sunfit.risk.buz.api.vo.repayment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class RepaymentOverdueRecordVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String bpId;

    private Date issueDate;

    private BigDecimal principle;

    private BigDecimal interest;

    private BigDecimal manageFee;

    private BigDecimal leftPrinciple;

    // 合同金额
    private BigDecimal approvedAmount;

    private BigDecimal payedPrinciple;

    private BigDecimal payedInterest;

    private BigDecimal payedManageFee;

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public String getBpId() {
        return bpId;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public BigDecimal getLeftPrinciple() {
        return leftPrinciple;
    }

    public BigDecimal getManageFee() {
        return manageFee;
    }

    public BigDecimal getPayedInterest() {
        return payedInterest;
    }

    public BigDecimal getPayedManageFee() {
        return payedManageFee;
    }

    public BigDecimal getPayedPrinciple() {
        return payedPrinciple;
    }

    public BigDecimal getPrinciple() {
        return principle;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setLeftPrinciple(BigDecimal leftPrinciple) {
        this.leftPrinciple = leftPrinciple;
    }

    public void setManageFee(BigDecimal manageFee) {
        this.manageFee = manageFee;
    }

    public void setPayedInterest(BigDecimal payedInterest) {
        this.payedInterest = payedInterest;
    }

    public void setPayedManageFee(BigDecimal payedManageFee) {
        this.payedManageFee = payedManageFee;
    }

    public void setPayedPrinciple(BigDecimal payedPrinciple) {
        this.payedPrinciple = payedPrinciple;
    }

    public void setPrinciple(BigDecimal principle) {
        this.principle = principle;
    }

}
