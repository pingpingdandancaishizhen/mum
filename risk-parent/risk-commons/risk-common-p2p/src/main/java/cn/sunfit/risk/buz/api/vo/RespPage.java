package cn.sunfit.risk.buz.api.vo;

import java.io.Serializable;

public class RespPage<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private T data;

    private int totalCount;

    public RespPage(T data, int totalCount) {
        this.data = data;
        this.totalCount = totalCount;
    }

    public T getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

}
