package cn.sunfit.risk.buz.api.vo.api.jfjd;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class JFBpStatusDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -6615080533116086286L;

    private Integer loanStatus;

    private Integer bpStatus;

    private Date createTime;

    private String currentTaskName;

    public Integer getBpStatus() {
        return bpStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCurrentTaskName() {
        return currentTaskName;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setBpStatus(Integer bpStatus) {
        this.bpStatus = bpStatus;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

}
