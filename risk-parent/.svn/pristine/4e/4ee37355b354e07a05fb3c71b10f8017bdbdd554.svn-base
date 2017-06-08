package cn.sunfit.risk.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;

public class BaseController {

    public static final int DATA_VALIDATION_ERROR = -1;

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public Resp buildValidationFaildResponse(BindingResult result) {
        final Resp responseBase = new Resp();
        if (result.getFieldErrors().size() > 0) {
            responseBase.setStatus(DATA_VALIDATION_ERROR);
            // 这里只取字段类型的错误
            final List<FieldError> errors = result.getFieldErrors();
            final Map<String, String> error_map = new HashMap<>();
            for (final FieldError e : errors) {
                responseBase.setMessage(e.getDefaultMessage());
                error_map.put(e.getField().toString(), e.getDefaultMessage());
            }
            responseBase.setData(error_map);
        }
        return responseBase;
    }

    /**
    * 获得当前登录用户
    */
    public CorpUserDTO getCurrentUser() {
        final Subject currentUser = SecurityUtils.getSubject();
        final Session session = currentUser.getSession();
        CorpUserDTO user = (CorpUserDTO) session.getAttribute(GlobalConstants.SHIRO_LOGIN_USER);
        return user;
    }

    @ExceptionHandler(NullPointerException.class)
    public Resp handlerNullPointException(NullPointerException ex) {
        logger.warn(ex.getMessage(), ex);
        final Resp responseBase = new Resp(DATA_VALIDATION_ERROR, ex.getMessage());
        return responseBase;
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public Resp handlerServiceException(AuthenticationException ex) {
        final Resp responseBase = new Resp(DATA_VALIDATION_ERROR, ex.getMessage());
        return responseBase;
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Resp handlerServiceException(ServiceException ex) {
        final Resp responseBase = new Resp(DATA_VALIDATION_ERROR, ex.getMsg());
        return responseBase;
    }

    /**
     * 首字母z用作排序
     * @Title: zhandlerException
     * @Description: 其他错误处理
     * @param @param ex
     * @param @return   
     * @return ResponseBase 
     * @author guzhen 2016年4月23日 
     * @throws
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Resp zhandlerException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        final Resp responseBase = new Resp(DATA_VALIDATION_ERROR, "内部错误");
        return responseBase;
    }
}
