package cn.sunfit.risk.web.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {

    private static final long serialVersionUID = 8836695304861550947L;
    private String smsCode;
    private String domain;

    public UsernamePasswordCaptchaToken() {
        super();
    }

    public UsernamePasswordCaptchaToken(String username, String password, String smsCode, String domain) {
        super(username, password);
        this.smsCode = smsCode;
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

}
