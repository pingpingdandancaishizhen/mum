package cn.sunfit.risk.buz.api.vo.repayment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;

public class RepaymentQueryResp implements Serializable {

    private static final long serialVersionUID = 1L;

    // 单号
    private String bpId;

    // 借款合同号
    private String loanContractId;

    // 借款人
    private String loanCustName;

    // 归属部门
    private String deptName;

    // 还款类型
    private LoanRepaymentType loanApprovalRepayment;

    // 合同金额
    private BigDecimal debitAmount;

    // 保证金
    private BigDecimal loanGuaranteeFee;

    // 当期还款期次
    private Integer payedIssue;

    // 已还本金
    private BigDecimal payedPrinciple;

    // 已还利息
    private BigDecimal payedInterest;

    // 还款日期
    private Integer issueDay;

    // 逾期天数
    private Integer overdueDay;

    private boolean overdue;

    // 状态
    private RepaymentBaseStatus status;

    private Integer statusCode;

    private List<RepaymentRecordDTO> details;

    private String eachTime;

    public String getBpId() {
        return bpId;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public String getDeptName() {
        return deptName;
    }

    public List<RepaymentRecordDTO> getDetails() {
        return details;
    }

    public String getEachTime() {
        return eachTime;
    }

    public Integer getIssueDay() {
        return issueDay;
    }

    public String getLoanApprovalRepayment() {
        if (loanApprovalRepayment != null) {
            return loanApprovalRepayment.getTypeName();
        } else {
            return null;
        }
    }

    public String getLoanContractId() {
        return loanContractId;
    }

    public String getLoanCustName() {
        return loanCustName;
    }

    public BigDecimal getLoanGuaranteeFee() {
        return loanGuaranteeFee;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public BigDecimal getPayedInterest() {
        return payedInterest;
    }

    public Integer getPayedIssue() {
        return payedIssue;
    }

    public BigDecimal getPayedPrinciple() {
        return payedPrinciple;
    }

    public String getStatus() {
        if (status != null) {
            return status.getStatusName();
        }
        return null;
    }

    public Integer getStatusCode() {
        if (status != null) {
            return status.getStatus();
        }
        return null;
    }

    public boolean isOverdue() {
        return overdue;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDetails(List<RepaymentRecordDTO> details) {
        this.details = details;
    }

    public void setEachTime(String eachTime) {
        this.eachTime = eachTime;
    }

    public void setIssueDay(Integer issueDay) {
        this.issueDay = issueDay;
    }

    public void setLoanApprovalRepayment(String loanApprovalRepayment) {
        this.loanApprovalRepayment = LoanRepaymentType.getTypeNameByTypeId(loanApprovalRepayment);
    }

    public void setLoanContractId(String loanContractId) {
        this.loanContractId = loanContractId;
    }

    public void setLoanCustName(String loanCustName) {
        this.loanCustName = loanCustName;
    }

    public void setLoanGuaranteeFee(BigDecimal loanGuaranteeFee) {
        this.loanGuaranteeFee = loanGuaranteeFee;
    }

    public void setOverdue(boolean overdue) {
        this.overdue = overdue;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public void setPayedInterest(BigDecimal payedInterest) {
        this.payedInterest = payedInterest;
    }

    public void setPayedIssue(Integer payedIssue) {
        this.payedIssue = payedIssue;
    }

    public void setPayedPrinciple(BigDecimal payedPrinciple) {
        this.payedPrinciple = payedPrinciple;
    }

    public void setStatus(Integer status) {
        this.status = RepaymentBaseStatus.getNameByStatus(status);
    }

}
