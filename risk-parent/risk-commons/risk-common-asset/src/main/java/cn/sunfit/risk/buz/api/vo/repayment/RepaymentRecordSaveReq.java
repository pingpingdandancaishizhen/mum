package cn.sunfit.risk.buz.api.vo.repayment;

import java.math.BigDecimal;
import java.util.Date;

import cn.sunfit.risk.buz.api.beans.repayment.RepaymentRecord;
import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class RepaymentRecordSaveReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    private String id;

    private String bpId;

    private String repaymentDetailId;

    private Date repaymentTime;

    private BigDecimal repaymentPrinciple;

    private BigDecimal repaymentInterest;

    private BigDecimal repaymentManageFee;

    private BigDecimal repaymentExtraFee;

    private BigDecimal repaymentExtraFee2;

    private BigDecimal overdueFee;

    private BigDecimal overdueDerate;

    private Integer overdueCount;

    private Date createTime;

    public String getBpId() {
        return bpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getId() {
        return id;
    }

    public Integer getOverdueCount() {
        return overdueCount;
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

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOverdueCount(Integer overdueCount) {
        this.overdueCount = overdueCount;
    }

    public void setOverdueDerate(BigDecimal overdueDerate) {
        this.overdueDerate = overdueDerate;
    }

    public void setOverdueFee(BigDecimal overdueFee) {
        this.overdueFee = overdueFee;
    }

    public void setRepaymentDetailId(String repaymentDetailId) {
        this.repaymentDetailId = repaymentDetailId;
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

    public RepaymentRecord toRepaymentRecord() {
        RepaymentRecord repaymentRecord = new RepaymentRecord();
        repaymentRecord.setCreateTime(this.createTime);
        repaymentRecord.setId(this.id);
        repaymentRecord.setRepaymentDetailId(this.repaymentDetailId);
        repaymentRecord.setRepaymentExtraFee(this.repaymentExtraFee);
        repaymentRecord.setRepaymentExtraFee2(this.repaymentExtraFee2);
        repaymentRecord.setRepaymentInterest(this.repaymentInterest);
        repaymentRecord.setRepaymentManageFee(this.repaymentManageFee);
        repaymentRecord.setRepaymentPrinciple(this.repaymentPrinciple);
        repaymentRecord.setRepaymentTime(this.repaymentTime);
        return repaymentRecord;
    }

}
