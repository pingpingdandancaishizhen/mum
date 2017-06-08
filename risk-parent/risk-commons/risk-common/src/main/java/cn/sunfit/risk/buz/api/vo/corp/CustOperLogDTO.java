package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

import cn.sunfit.risk.buz.api.beans.corp.CustOperLog;

public class CustOperLogDTO extends CustOperLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private String operaterName;

    private String operDetail;

    private String customerName;

    public String getOperaterName() {
        return operaterName;
    }

    public void setOperaterName(String operaterName) {
        this.operaterName = operaterName;
    }

    public String getOperDetail() {
        this.operDetail = this.operaterName + this.getDetail();
        return operDetail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setOperDetail(String operDetail) {
        this.operDetail = "[" + this.operaterName + "]" + this.getDetail();
    }

}
