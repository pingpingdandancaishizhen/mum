package cn.sunfit.risk.buz.api.vo.corp;

import cn.sunfit.risk.buz.api.vo.ReqBase;

/**
 * @Title: UserQueryReq.java
 * @Package cn.sunfit.risk.buz.api.reqresp.system
 * @Description: 用户查询参数
 * @author 薛凡龙
 * @date 2016年12月8日 上午11:33:35
 * @version V1.0
 */
public class UserQueryReq extends ReqBase {

    private static final long serialVersionUID = 1L;

    private String userAccount;

    private String userName;

    private String corpId;

    public String getCorpId() {
        return corpId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
