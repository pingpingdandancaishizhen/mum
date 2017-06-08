package cn.sunfit.risk.buz.api.beans.loan;

import java.math.BigDecimal;
import java.util.Date;

import orj.worf.core.model.BaseObject;

public class LoanFee extends BaseObject {

    private static final long serialVersionUID = 1L;

    private String id;

    private String bpNo;

    private String feeName;

    private BigDecimal feeValue;

    private Date updateTime;

    public String getBpNo() {
        return bpNo;
    }

    public String getFeeName() {
        return feeName;
    }

    public BigDecimal getFeeValue() {
        return feeValue;
    }

    public String getId() {
        return id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo;
    }

    public void setFeeName(String feeName) {
        this.feeName = feeName;
    }

    public void setFeeValue(BigDecimal feeValue) {
        this.feeValue = feeValue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
