package cn.sunfit.risk.credit.api.exception;

import orj.worf.exception.FastRuntimeException;

/**
 * 
 * @Title: ServiceException.java
 * @Package com.rjs.gps.exception
 * @Description: 业务逻辑异常
 * @author guzhen
 * @date 2016年4月19日 上午9:19:35
 * @version V1.0
 */
public class ServiceException extends FastRuntimeException {

    private static final long serialVersionUID = -8658734776862356035L;

    private String msg;

    public ServiceException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
