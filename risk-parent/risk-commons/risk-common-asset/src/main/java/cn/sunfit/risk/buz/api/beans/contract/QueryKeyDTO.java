package cn.sunfit.risk.buz.api.beans.contract;

import orj.worf.core.model.BaseObject;

public class QueryKeyDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -769820904923105445L;

    private String domain;

    private String key;

    public QueryKeyDTO() {

    }

    public QueryKeyDTO(String domain, String key) {
        this.domain = domain;
        this.key = key;
    }

    public String getDomain() {
        return domain;
    }

    public String getKey() {
        return key;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
