package cn.sunfit.risk.buz.api.vo.repayment;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;

public class OverdueQueryResp implements Serializable {

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

    // 产品名称
    private String productName;

    // 产品名称
    private String loanTerm;

    private String daylyTerm;

    private String monthlyTerm;

    // 合同金额
    private BigDecimal debitAmount;

    // 剩余本金
    private BigDecimal leftAmount;

    // 当期还款期次
    private Integer payedIssue;

    // 逾期天数
    private Integer overdueDay;

    // 逾期账龄
    private String overdueZL;

    // 逾期滞纳金率
    private BigDecimal overdueZnjFee;

    // 逾期滞纳金
    private BigDecimal overdueZnj;

    // 逾期滞纳金减免
    private BigDecimal overdueDerate;

    // 还款日
    private Integer issueDay;

    // 状态
    private RepaymentBaseStatus status;

    private String eachTime;

    public String getBpId() {
        return bpId;
    }

    public String getDaylyTerm() {
        return daylyTerm;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getDeptName() {
        return deptName;
    }

    public String getEachTime() {
        return eachTime;
    }

    public Integer getIssueDay() {
        return issueDay;
    }

    public BigDecimal getLeftAmount() {
        return leftAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
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

    public String getLoanTerm() {
        switch (loanApprovalRepayment) {
            case YCXHQ:
                if (!StringUtils.isBlank(daylyTerm)) {
                    loanTerm = daylyTerm + "天";
                }
                break;
            default:
                if (!StringUtils.isBlank(monthlyTerm)) {
                    loanTerm = monthlyTerm.substring(1) + "月";
                } else if (!StringUtils.isBlank(daylyTerm)) {
                    loanTerm = daylyTerm + "天";
                }
                break;
        }
        return loanTerm;
    }

    public String getMonthlyTerm() {
        return monthlyTerm;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public BigDecimal getOverdueDerate() {
        return overdueDerate.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public String getOverdueZL() {
        return "M" + new BigDecimal(overdueDay).divide(new BigDecimal(30), 0, BigDecimal.ROUND_UP).toString();
    }

    public BigDecimal getOverdueZnj() {
        return overdueZnj.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getOverdueZnjFee() {
        return overdueZnjFee.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public Integer getPayedIssue() {
        return payedIssue;
    }

    public String getProductName() {
        return productName;
    }

    public String getStatus() {
        if (status != null) {
            return status.getStatusName();
        }
        return null;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setDaylyTerm(String daylyTerm) {
        this.daylyTerm = daylyTerm;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setEachTime(String eachTime) {
        this.eachTime = eachTime;
    }

    public void setIssueDay(Integer issueDay) {
        this.issueDay = issueDay;
    }

    public void setLeftAmount(BigDecimal leftAmount) {
        this.leftAmount = leftAmount;
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

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public void setMonthlyTerm(String monthlyTerm) {
        this.monthlyTerm = monthlyTerm;
    }

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public void setOverdueDerate(BigDecimal overdueDerate) {
        this.overdueDerate = overdueDerate;
    }

    public void setOverdueZL(String overdueZL) {
        // overdueDay % 30 ;
        this.overdueZL = overdueZL;
    }

    public void setOverdueZnj(BigDecimal overdueZnj) {
        this.overdueZnj = overdueZnj;
    }

    public void setOverdueZnjFee(BigDecimal overdueZnjFee) {
        this.overdueZnjFee = overdueZnjFee;
    }

    public void setPayedIssue(Integer payedIssue) {
        this.payedIssue = payedIssue;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStatus(Integer status) {
        this.status = RepaymentBaseStatus.getNameByStatus(status);
    }

}
