package cn.sunfit.risk.buz.api.vo.corp;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class DataRoleQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String corpId;

    private String roleName;

    public String getCorpId() {
        return corpId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
