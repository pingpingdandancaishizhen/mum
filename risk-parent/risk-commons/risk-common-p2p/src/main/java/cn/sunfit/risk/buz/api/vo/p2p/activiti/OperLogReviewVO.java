package cn.sunfit.risk.buz.api.vo.p2p.activiti;

import java.io.Serializable;

public class OperLogReviewVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String operUserName;

    private String logTime;

    private String pretask;

    private String curtask;

    private String reason;

    private String logOperType;

    public String getCurtask() {
        return curtask;
    }

    public String getLogOperType() {
        return logOperType;
    }

    public String getLogTime() {
        return logTime;
    }

    public String getOperUserName() {
        return operUserName;
    }

    public String getPretask() {
        return pretask;
    }

    public String getReason() {
        return reason;
    }

    public void setCurtask(String curtask) {
        this.curtask = curtask;
    }

    public void setLogOperType(String logOperType) {
        this.logOperType = logOperType;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }

    public void setPretask(String pretask) {
        this.pretask = pretask;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
