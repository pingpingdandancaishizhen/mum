package cn.sunfit.risk.buz.api.vo.repayment;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;

public class RepaymentDetailAddReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bpNo;

    private Integer issue;

    // 第一期还款日
    private Date investDate;

    // 借款金额
    private BigDecimal invest;

    // 年利率
    private BigDecimal yearRate;

    // 还款期数
    private int period;

    // 还款周期
    private int cycle;

    // 还款类型
    private LoanRepaymentType repaymentType;

    private Date createTime;

    private String createBy;

    public String getBpNo() {
        return bpNo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public int getCycle() {
        return cycle;
    }

    public BigDecimal getInvest() {
        return invest;
    }

    public Date getInvestDate() {
        return investDate;
    }

    public Integer getIssue() {
        return issue;
    }

    public int getPeriod() {
        return period;
    }

    public LoanRepaymentType getRepaymentType() {
        return repaymentType;
    }

    public BigDecimal getYearRate() {
        return yearRate;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public void setInvest(BigDecimal invest) {
        this.invest = invest;
    }

    public void setInvestDate(Date investDate) {
        this.investDate = investDate;
    }

    public void setIssue(Integer issue) {
        this.issue = issue;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = LoanRepaymentType.getTypeNameByTypeId(repaymentType);
    }

    public void setYearRate(BigDecimal yearRate) {
        this.yearRate = yearRate;
    }

}
