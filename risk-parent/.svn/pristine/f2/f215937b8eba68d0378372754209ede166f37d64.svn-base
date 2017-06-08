package cn.sunfit.risk.web.filter;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Shiro登录验证
 */
public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {

    protected static final Logger logger = LoggerFactory.getLogger(ShiroFormAuthenticationFilter.class);

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        logger.info("ShiroFormAuthenticationFilter onAccessDenied");
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            if (httpRequest.getHeader("x-requested-with") != null
                    && httpRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
                HttpServletResponse res = WebUtils.toHttp(response);
                res.addHeader("sessionStatus", "timeout");
                // saveRequestAndRedirectToLogin(request, response);

                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/plain;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println("{\"status\":-999,\"success\":false,\"message\":\"请重新登录\"}");
                out.flush();
                out.close();

                return false;
            } else {
                saveRequestAndRedirectToLogin(request, response);
                return false;
            }
        }
    }
}
