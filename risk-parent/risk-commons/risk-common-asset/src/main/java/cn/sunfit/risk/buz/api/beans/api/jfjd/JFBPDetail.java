package cn.sunfit.risk.buz.api.beans.api.jfjd;

import java.util.Date;
import java.util.List;

import orj.worf.core.model.BaseObject;

public class JFBPDetail extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 641152972751731132L;

    private String userName;

    private String mobile;

    private String idCard;

    private String loanTerm;

    private String applyMoney;

    private String carSeries;

    private String carNo;

    private String carFrameNo;

    private String carEngineNo;

    private Date applyTime;

    private String status;

    private List<JFRepayment> repayment;

    public String getApplyMoney() {
        return applyMoney;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public String getCarEngineNo() {
        return carEngineNo;
    }

    public String getCarFrameNo() {
        return carFrameNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getLoanTerm() {
        return loanTerm;
    }

    public String getMobile() {
        return mobile;
    }

    public List<JFRepayment> getRepayment() {
        return repayment;
    }

    public String getStatus() {
        return status;
    }

    public String getUserName() {
        return userName;
    }

    public void setApplyMoney(String applyMoney) {
        this.applyMoney = applyMoney;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo;
    }

    public void setCarFrameNo(String carFrameNo) {
        this.carFrameNo = carFrameNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setLoanTerm(String loanTerm) {
        this.loanTerm = loanTerm;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setRepayment(List<JFRepayment> repayment) {
        this.repayment = repayment;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
