package cn.sunfit.risk.web.exception;

import org.apache.shiro.authc.AuthenticationException;

public class LossSmsCodeException extends AuthenticationException {

    /**
     * 
     */
    private static final long serialVersionUID = 3953237101862872263L;

    public LossSmsCodeException() {
        super();
    }

    public LossSmsCodeException(String message) {
        super(message);
    }

    public LossSmsCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public LossSmsCodeException(Throwable cause) {
        super(cause);
    }

}
