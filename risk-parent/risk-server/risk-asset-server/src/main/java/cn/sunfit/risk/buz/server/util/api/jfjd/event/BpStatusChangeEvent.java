package cn.sunfit.risk.buz.server.util.api.jfjd.event;

import org.springframework.context.ApplicationEvent;

public class BpStatusChangeEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 822395607622287691L;

    private String domain;

    private String opType;

    private String bpChannel;

    private String bpId;

    private String prodType;

    private String currentTaskName;

    private Integer bpStatus;

    private Integer repayStatus;

    private String comment;

    public BpStatusChangeEvent(Object source, String domain, String opType, String bpChannel, String bpId,
            String currentTaskName, String prodType, Integer bpStatus, Integer repayStatus, String comment) {
        super(source);
        this.bpId = bpId;
        this.currentTaskName = currentTaskName;
        this.prodType = prodType;
        this.comment = comment;
        this.bpStatus = bpStatus;
        this.repayStatus = repayStatus;
        this.opType = opType;
        this.domain = domain;
        this.bpChannel = bpChannel;
    }

    public String getBpChannel() {
        return bpChannel;
    }

    public String getBpId() {
        return bpId;
    }

    public Integer getBpStatus() {
        return bpStatus;
    }

    public String getComment() {
        return comment;
    }

    public String getCurrentTaskName() {
        return currentTaskName;
    }

    public String getDomain() {
        return domain;
    }

    public String getOpType() {
        return opType;
    }

    public String getProdType() {
        return prodType;
    }

    public Integer getRepayStatus() {
        return repayStatus;
    }

    public void setBpChannel(String bpChannel) {
        this.bpChannel = bpChannel;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setBpStatus(Integer bpStatus) {
        this.bpStatus = bpStatus;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public void setRepayStatus(Integer repayStatus) {
        this.repayStatus = repayStatus;
    }

}
