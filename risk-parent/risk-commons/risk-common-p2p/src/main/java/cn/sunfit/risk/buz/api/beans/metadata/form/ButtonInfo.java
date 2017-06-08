package cn.sunfit.risk.buz.api.beans.metadata.form;

import java.io.Serializable;

public class ButtonInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String key;

    private String name;

    private String url;

    private String method;

    private boolean close;

    private boolean validate;

    public String getKey() {
        return key;
    }

    public String getMethod() {
        return method;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public boolean isClose() {
        return close;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

}
