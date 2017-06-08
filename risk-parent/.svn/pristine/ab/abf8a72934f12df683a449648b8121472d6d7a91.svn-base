package cn.sunfit.risk.buz.api.vo.repayment;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;

public class OverdueQueryVO extends OverdueQueryVOBase {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Field[] fields = OverdueQueryVO.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }

    // 借款人
    private String loanCustName;

    // 借款合同号
    private String loanContractId;

    // 归属部门
    private String deptName;

    // 还款类型
    private LoanRepaymentType loanApprovalRepayment;

    // 产品名称
    private String productName;

    // 借款期限
    private String loanTerm;

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

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public String getDeptName() {
        return deptName;
    }

    public Integer getIssueDay() {
        return issueDay;
    }

    public BigDecimal getLeftAmount() {
        return leftAmount;
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
        if (loanApprovalRepayment == LoanRepaymentType.YCXHQ) {
            if (!StringUtils.isBlank(getDaylyTerm())) {
                loanTerm = getDaylyTerm() + "天";
            }
        } else {
            if (!StringUtils.isBlank(getDaylyTerm())) {
                loanTerm = getDaylyTerm() + "天";
            } else if (!StringUtils.isBlank(getMonthlyTerm())) {
                loanTerm = getMonthlyTerm().substring(1) + "月";
            }
        }
        return loanTerm;
    }

    public Integer getOverdueDay() {
        return overdueDay;
    }

    public BigDecimal getOverdueDerate() {
        return overdueDerate;
    }

    public String getOverdueZL() {
        return "M" + new BigDecimal(overdueDay).divide(new BigDecimal(30), 0, BigDecimal.ROUND_UP).toString();
    }

    public BigDecimal getOverdueZnj() {
        return overdueZnj;
    }

    public BigDecimal getOverdueZnjFee() {
        return overdueZnjFee;
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

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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

    public void setOverdueDay(Integer overdueDay) {
        this.overdueDay = overdueDay;
    }

    public void setOverdueDerate(BigDecimal overdueDerate) {
        this.overdueDerate = overdueDerate;
    }

    public void setOverdueZL(String overdueZL) {
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
