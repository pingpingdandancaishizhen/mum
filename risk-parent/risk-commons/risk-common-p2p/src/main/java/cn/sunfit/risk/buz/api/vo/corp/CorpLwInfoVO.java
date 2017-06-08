package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

public class CorpLwInfoVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String lwKey;

    private String lwSecret;

    public String getId() {
        return id;
    }

    public String getLwKey() {
        return lwKey;
    }

    public String getLwSecret() {
        return lwSecret;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLwKey(String lwKey) {
        this.lwKey = lwKey;
    }

    public void setLwSecret(String lwSecret) {
        this.lwSecret = lwSecret;
    }

}
