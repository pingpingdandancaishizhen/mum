package cn.sunfit.risk.buz.api.beans.api.jfjd;

import java.math.BigDecimal;
import java.util.Date;

import orj.worf.core.model.BaseObject;

public class JFRepayment extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 4981327622732516190L;

    private Integer issue;

    private Date repayDate;

    private BigDecimal repayAmount;

    private boolean isFinish;

    public Integer getIssue() {
        return issue;
    }

    public BigDecimal getRepayAmount() {
        return repayAmount;
    }

    public Date getRepayDate() {
        return repayDate;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean isFinish) {
        this.isFinish = isFinish;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public void setRepayAmount(BigDecimal repayAmount) {
        this.repayAmount = repayAmount;
    }

    public void setRepayDate(Date repayDate) {
        this.repayDate = repayDate;
    }

}
