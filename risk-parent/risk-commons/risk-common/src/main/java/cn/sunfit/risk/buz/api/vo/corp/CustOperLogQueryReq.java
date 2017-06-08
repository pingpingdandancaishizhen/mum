package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class CustOperLogQueryReq extends ReqBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String licenseNum;

    private String cid;

    private String operaterName;

    private List<String> operType;

    private String operTypes;

    private Date startTime;

    private Date endTime;

    public String getCid() {
        return cid;
    }

    public String getDomain() {
        return domain;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public String getOperaterName() {
        return operaterName;
    }

    public List<String> getOperType() {
        return operType;
    }

    public String getOperTypes() {
        return operTypes;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public void setOperaterName(String operaterName) {
        this.operaterName = operaterName;
    }

    public void setOperType(List<String> operType) {
        this.operType = operType;
    }

    public void setOperTypes(String operTypes) {
        this.operTypes = operTypes;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

}
