package cn.sunfit.risk.buz.api.beans.api.jfjd;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class JFCorpUser extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String corpId;

    private String deptId;

    private String userAccount;

    private String userName;

    private String salt;

    private String password;

    private String email;

    private String desc;

    private String idcard;

    private String telephone;

    private String job;

    private String status;

    private Date lastModTime;

    private String isFirstLogin;

    private Integer errorTimes;

    private Date errorDay;

    private Date createTime;

    private String clientId;

    private String channel = "0";

    public String getChannel() {
        return channel;
    }

    public String getClientId() {
        return clientId;
    }

    public String getCorpId() {
        return corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDesc() {
        return desc;
    }

    public String getEmail() {
        return email;
    }

    public Date getErrorDay() {
        return errorDay;
    }

    public Integer getErrorTimes() {
        return errorTimes;
    }

    public String getId() {
        return id;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getIsFirstLogin() {
        return isFirstLogin;
    }

    public String getJob() {
        return job;
    }

    public Date getLastModTime() {
        return lastModTime;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getStatus() {
        return status;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setErrorDay(Date errorDay) {
        this.errorDay = errorDay;
    }

    public void setErrorTimes(Integer errorTimes) {
        this.errorTimes = errorTimes;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public void setIsFirstLogin(String isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setLastModTime(Date lastModTime) {
        this.lastModTime = lastModTime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
