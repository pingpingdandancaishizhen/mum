package cn.sunfit.risk.web.bean;

import java.io.Serializable;

public class CreditInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resource;

    private String content;

    private String url;

    public CreditInfo(String resource, String content, String url) {
        super();
        this.resource = resource;
        this.content = content;
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public String getResource() {
        return resource;
    }

    public String getUrl() {
        return url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
