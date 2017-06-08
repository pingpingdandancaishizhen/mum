package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class CorpUserAddReq implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String deptId;
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_\\-\\.]{2,20}$")
    private String userAccount;
    @NotBlank
    @Pattern(regexp = "^[\u4e00-\u9fa5_a-zA-Z]{2,20}$")
    private String userName;
    @NotBlank
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\(\\)])+$)([^(0-9a-zA-Z)]|[\\(\\)]|[a-zA-Z]|[0-9]){6,20}$")
    private String password;
    @Email
    private String email;
    @Size(min = 0, max = 100)
    private String desc;
    @Pattern(regexp = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$")
    private String idcard;
    @NotBlank
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$")
    private String telephone;
    @Pattern(regexp = "^[A-Za-z\u4e00-\u9fa5]{2,20}$")
    private String job;
    @NotBlank
    private String roleId;
    @NotBlank
    private String dataRoleId;

    private String nodes;

    public String getDataRoleId() {
        return dataRoleId;
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

    public String getIdcard() {
        return idcard;
    }

    public String getJob() {
        return job;
    }

    public String getNodes() {
        return nodes;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleId() {
        return roleId;
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

    public void setDataRoleId(String dataRoleId) {
        this.dataRoleId = dataRoleId;
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

    public void setIdcard(String idcard) {
        this.idcard = idcard;
        if (StringUtils.isBlank(idcard)) {
            this.idcard = null;
        }
    }

    public void setJob(String job) {
        this.job = job;
        if (StringUtils.isBlank(job)) {
            this.job = null;
        }
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
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

    public CorpUserDTO toCorpUserDTO() {
        CorpUserDTO dto = new CorpUserDTO();
        dto.setUserAccount(this.userAccount);
        dto.setUserName(this.userName);
        dto.setPassword(this.password);
        dto.setTelephone(this.telephone);
        dto.setDeptId(this.deptId);
        dto.setJob(this.job);
        dto.setEmail(this.email);
        dto.setIdcard(this.idcard);
        dto.setDesc(this.desc);
        return dto;
    }

}
