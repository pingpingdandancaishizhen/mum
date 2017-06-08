package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

public class SameDeptUserResp implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String userName;

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
