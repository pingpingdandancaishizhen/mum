package cn.sunfit.risk.buz.api.beans.repayment;

import java.math.BigDecimal;
import java.util.Date;

import orj.worf.core.model.BaseObject;

/**
 * 还款明细
 * @Title: RepaymentDetail.java
 * @Package cn.sunfit.risk.buz.api.beans.repayment
 * @Description: 还款明细
 * @author XJ
 * @date 2017年2月16日 下午1:50:00
 * @version V1.0
 */
public class RepaymentRecord extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String repaymentDetailId;

    private Date repaymentTime;

    private BigDecimal repaymentPrinciple;

    private BigDecimal repaymentInterest;

    private BigDecimal repaymentManageFee;

    private BigDecimal repaymentExtraFee;

    private BigDecimal repaymentExtraFee2;

    private BigDecimal overdueFee;

    private BigDecimal overdueDerate;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getOverdueDerate() {
        return overdueDerate;
    }

    public BigDecimal getOverdueFee() {
        return overdueFee;
    }

    public String getRepaymentDetailId() {
        return repaymentDetailId;
    }

    public BigDecimal getRepaymentExtraFee() {
        return repaymentExtraFee;
    }

    public BigDecimal getRepaymentExtraFee2() {
        return repaymentExtraFee2;
    }

    public BigDecimal getRepaymentInterest() {
        return repaymentInterest;
    }

    public BigDecimal getRepaymentManageFee() {
        return repaymentManageFee;
    }

    public BigDecimal getRepaymentPrinciple() {
        return repaymentPrinciple;
    }

    public Date getRepaymentTime() {
        return repaymentTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setOverdueDerate(BigDecimal overdueDerate) {
        this.overdueDerate = overdueDerate;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    public void setRepaymentDetailId(String repaymentDetailId) {
        this.repaymentDetailId = repaymentDetailId == null ? null : repaymentDetailId.trim();
    }

    public void setRepaymentExtraFee(BigDecimal repaymentExtraFee) {
        this.repaymentExtraFee = repaymentExtraFee;
    }

    public void setRepaymentExtraFee2(BigDecimal repaymentExtraFee2) {
        this.repaymentExtraFee2 = repaymentExtraFee2;
    }

    public void setRepaymentInterest(BigDecimal repaymentInterest) {
        this.repaymentInterest = repaymentInterest;
    }

    public void setRepaymentManageFee(BigDecimal repaymentManageFee) {
        this.repaymentManageFee = repaymentManageFee;
    }

    public void setRepaymentPrinciple(BigDecimal repaymentPrinciple) {
        this.repaymentPrinciple = repaymentPrinciple;
    }

    public void setRepaymentTime(Date repaymentTime) {
        this.repaymentTime = repaymentTime;
    }
}
