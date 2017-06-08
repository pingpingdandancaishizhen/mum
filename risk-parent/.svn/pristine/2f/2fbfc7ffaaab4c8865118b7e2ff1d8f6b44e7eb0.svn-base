package cn.sunfit.risk.credit.api.beans;

import java.io.Serializable;

import cn.sunfit.risk.credit.api.constant.ResponseStatus;

public class Resp implements Serializable {
    public static final int STATUS_SUCCESS = 1;
    private static final long serialVersionUID = 1L;

    public static Resp buildErrorResponse(int status, String message) {
        return new Resp(status, message);
    }

    public static Resp buildErrorResponse(ResponseStatus responseStatus) {
        return new Resp(responseStatus.getStatus(), responseStatus.getName());
    }

    public static Resp buildErrorResponse(String message) {
        return new Resp(0, message);
    }

    public static Resp buildErrorResponse(String message, Object data) {
        Resp responseBase = buildErrorResponse(message);
        responseBase.setData(data);
        return responseBase;
    }

    private int status;

    private String message;

    private Object data;

    public Resp() {
        this.status = 1;
        this.message = "成功";
    }

    public Resp(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Resp(Object data) {
        this();
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResponseBase [status=" + status + ", message=" + message + ", data=" + data + "]";
    }

}
