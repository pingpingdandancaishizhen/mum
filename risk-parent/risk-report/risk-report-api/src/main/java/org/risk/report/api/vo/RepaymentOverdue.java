package org.risk.report.api.vo;

import java.math.BigDecimal;
import java.util.Date;
import orj.worf.core.model.BaseObject;

public class RepaymentOverdue extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String repaymentDetailId;

    private BigDecimal principle;

    private BigDecimal interest;

    private BigDecimal manageFee;

    private BigDecimal overdueFee;

    private Integer overdueCount;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRepaymentDetailId() {
        return repaymentDetailId;
    }

    public void setRepaymentDetailId(String repaymentDetailId) {
        this.repaymentDetailId = repaymentDetailId == null ? null : repaymentDetailId.trim();
    }

    public BigDecimal getPrinciple() {
        return principle;
    }

    public void setPrinciple(BigDecimal principle) {
        this.principle = principle;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getManageFee() {
        return manageFee;
    }

    public void setManageFee(BigDecimal manageFee) {
        this.manageFee = manageFee;
    }

    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    public Integer getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(Integer overdueCount) {
        this.overdueCount = overdueCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}