package cn.sunfit.risk.buz.api.vo.loan;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoanReportDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date loanPlanDate;

    private int loanPlanCount;

    private BigDecimal loanPlanAmount;

    private int loanCount;

    private BigDecimal loanAmount;

    private BigDecimal leftLoanAmount;

    private BigDecimal loanAmountPerOrder;

    public BigDecimal getLeftLoanAmount() {
        return leftLoanAmount;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public BigDecimal getLoanAmountPerOrder() {
        if (loanCount == 0) {
            return BigDecimal.ZERO;
        } else {
            return this.loanAmount.divide(new BigDecimal(loanCount), 2, BigDecimal.ROUND_HALF_UP);
        }
    }

    public int getLoanCount() {
        return loanCount;
    }

    public BigDecimal getLoanPlanAmount() {
        return loanPlanAmount;
    }

    public int getLoanPlanCount() {
        return loanPlanCount;
    }

    public String getLoanPlanDate() {
        if (loanPlanDate != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(loanPlanDate);
        } else {
            return null;
        }
    }

    public void setLeftLoanAmount(BigDecimal leftLoanAmount) {
        this.leftLoanAmount = leftLoanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    public void setLoanPlanAmount(BigDecimal loanPlanAmount) {
        this.loanPlanAmount = loanPlanAmount;
    }

    public void setLoanPlanCount(int loanPlanCount) {
        this.loanPlanCount = loanPlanCount;
    }

    public void setLoanPlanDate(Date loanPlanDate) {
        this.loanPlanDate = loanPlanDate;
    }

    @Override
    public String toString() {
        return "LoanReportDTO [loanPlanDate=" + loanPlanDate + ", loanPlanCount=" + loanPlanCount + ", loanPlanAmount="
                + loanPlanAmount + ", loanCount=" + loanCount + ", loanAmount=" + loanAmount + "]";
    }

}
