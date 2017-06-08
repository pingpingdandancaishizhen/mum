package cn.sunfit.risk.buz.api.vo;

import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;

public class CorpReqBase extends ReqBase {
    private static final long serialVersionUID = 1L;

    private String corpId;

    private String domain;

    private String userId;

    private String userName;

    public String getCorpId() {
        return corpId;
    }

    public String getDomain() {
        return domain;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCorpInfo(CorpUserDTO user) {
        this.corpId = user.getCorpId();
        this.domain = user.getDomain();
        this.userId = user.getId();
        this.userName = user.getUserName();
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
