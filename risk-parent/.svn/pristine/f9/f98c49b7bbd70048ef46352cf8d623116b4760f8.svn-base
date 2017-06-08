package cn.sunfit.risk.buz.api.vo.repayment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RepaymentReportDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date date;

    private int planCount;

    private BigDecimal planPrinciple;

    private BigDecimal planInterest;

    private BigDecimal planManageFee;

    private BigDecimal planExtraFee;

    private BigDecimal planExtraFee2;

    private BigDecimal planOverdueFee;

    private BigDecimal planTotal;

    private int payedCount;

    private BigDecimal payedPrinciple;

    private BigDecimal payedInterest;

    private BigDecimal payedManageFee;

    private BigDecimal payedExtraFee;

    private BigDecimal payedExtraFee2;

    private BigDecimal payedOverdue;

    private BigDecimal payedPenalty;

    private BigDecimal payedTotal;

    private BigDecimal leftTotal;

    private BigDecimal repaymentPerOrder;

    public String getDate() {
        if (date != null) {
            return new SimpleDateFormat("yyyy-MM-dd").format(date);
        } else {
            return null;
        }
    }

    public BigDecimal getLeftTotal() {
        leftTotal = getPlanTotal().subtract(getPayedTotal());
        return leftTotal.compareTo(BigDecimal.ZERO) > 0 ? leftTotal : BigDecimal.ZERO;
    }

    public int getPayedCount() {
        return payedCount;
    }

    public BigDecimal getPayedExtraFee() {
        return payedExtraFee;
    }

    public BigDecimal getPayedExtraFee2() {
        return payedExtraFee2;
    }

    public BigDecimal getPayedInterest() {
        return payedInterest;
    }

    public BigDecimal getPayedManageFee() {
        return payedManageFee;
    }

    public BigDecimal getPayedOverdue() {
        return payedOverdue;
    }

    public BigDecimal getPayedPenalty() {
        return payedPenalty;
    }

    public BigDecimal getPayedPrinciple() {
        return payedPrinciple;
    }

    public BigDecimal getPayedTotal() {
        return payedPrinciple.add(payedInterest).add(payedManageFee).add(payedExtraFee).add(payedExtraFee2)
                .add(payedOverdue).add(payedPenalty);
    }

    public int getPlanCount() {
        return planCount;
    }

    public BigDecimal getPlanExtraFee() {
        return planExtraFee;
    }

    public BigDecimal getPlanExtraFee2() {
        return planExtraFee2;
    }

    public BigDecimal getPlanInterest() {
        return planInterest;
    }

    public BigDecimal getPlanManageFee() {
        return planManageFee;
    }

    public BigDecimal getPlanOverdueFee() {
        return planOverdueFee;
    }

    public BigDecimal getPlanPrinciple() {
        return planPrinciple;
    }

    public BigDecimal getPlanTotal() {
        return planPrinciple.add(planInterest).add(planManageFee).add(planExtraFee).add(planExtraFee2)
                .add(planOverdueFee);
    }

    public BigDecimal getRepaymentPerOrder() {
        if (payedCount == 0) {
            return BigDecimal.ZERO;
        } else {
            return getPayedTotal().divide(new BigDecimal(payedCount), 2, BigDecimal.ROUND_HALF_UP);
        }
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setPayedCount(int payedCount) {
        this.payedCount = payedCount;
    }

    public void setPayedExtraFee(BigDecimal payedExtraFee) {
        this.payedExtraFee = payedExtraFee;
    }

    public void setPayedExtraFee2(BigDecimal payedExtraFee2) {
        this.payedExtraFee2 = payedExtraFee2;
    }

    public void setPayedInterest(BigDecimal payedInterest) {
        this.payedInterest = payedInterest;
    }

    public void setPayedManageFee(BigDecimal payedManageFee) {
        this.payedManageFee = payedManageFee;
    }

    public void setPayedOverdue(BigDecimal payedOverdue) {
        this.payedOverdue = payedOverdue;
    }

    public void setPayedPenalty(BigDecimal payedPenalty) {
        this.payedPenalty = payedPenalty;
    }

    public void setPayedPrinciple(BigDecimal payedPrinciple) {
        this.payedPrinciple = payedPrinciple;
    }

    public void setPlanCount(int planCount) {
        this.planCount = planCount;
    }

    public void setPlanExtraFee(BigDecimal planExtraFee) {
        this.planExtraFee = planExtraFee;
    }

    public void setPlanExtraFee2(BigDecimal planExtraFee2) {
        this.planExtraFee2 = planExtraFee2;
    }

    public void setPlanInterest(BigDecimal planInterest) {
        this.planInterest = planInterest;
    }

    public void setPlanManageFee(BigDecimal planManageFee) {
        this.planManageFee = planManageFee;
    }

    public void setPlanOverdueFee(BigDecimal planOverdueFee) {
        this.planOverdueFee = planOverdueFee;
    }

    public void setPlanPrinciple(BigDecimal planPrinciple) {
        this.planPrinciple = planPrinciple;
    }

}
