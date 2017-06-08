package cn.sunfit.risk.credit.api.vo.cjd;

import java.io.Serializable;

import orj.worf.util.StringUtils;

public class OrderInfoQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean validate() {
        return StringUtils.isNotEmpty(this.orderId);
    }

}
