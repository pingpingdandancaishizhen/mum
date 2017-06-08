package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

public class ResetPasswordReq implements Serializable {
    private static final long serialVersionUID = 1L;
    private String corpId;
    @NotBlank
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)(?!([^(0-9a-zA-Z)]|[\\(\\)])+$)([^(0-9a-zA-Z)]|[\\(\\)]|[a-zA-Z]|[0-9]){6,20}$")
    private String password;
    private String id;

    public String getCorpId() {
        return corpId;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
