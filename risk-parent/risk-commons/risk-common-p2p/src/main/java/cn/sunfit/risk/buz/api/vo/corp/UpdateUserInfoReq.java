package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class UpdateUserInfoReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @NotBlank
    @Pattern(regexp = "^[\u4e00-\u9fa5_a-zA-Z]{2,20}$")
    private String userName;
    @Pattern(regexp = "^[A-Za-z\u4e00-\u9fa5]{2,20}$")
    private String job;

    @NotBlank
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$")
    private String telephone;
    @Email
    private String email;
    @Pattern(regexp = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$")
    private String idcard;
    @Size(min = 0, max = 100)
    private String desc;

    public String getDesc() {
        return desc;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getJob() {
        return job;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getUserName() {
        return userName;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
