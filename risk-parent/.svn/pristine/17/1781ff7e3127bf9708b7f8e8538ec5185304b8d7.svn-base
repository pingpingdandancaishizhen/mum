package cn.sunfit.risk.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * 在进行角色检测时，只要有一个满足即通
*/
public class ShiroFuncFilter extends AuthorizationFilter {

    private static final Logger logger = LoggerFactory.getLogger(ShiroFuncFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
            throws Exception {
        logger.info("ShiroFuncFilter isAccessAllowed");
        Subject subject = SecurityUtils.getSubject();
        String[] funcArray = (String[]) mappedValue;
        if (funcArray == null || funcArray.length == 0) {
            // do not allow access.
            JSONResponse(request, response);
            return false;
        }
        // 判断是否有权限访问
        for (String func : funcArray) {
            if (subject.isPermitted(func)) {
                return true;
            }
        }
        JSONResponse(request, response);
        return false;
    }

    private void JSONResponse(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpRequest = WebUtils.toHttp(request);
        if (httpRequest.getHeader("x-requested-with") != null
                && httpRequest.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println("{\"status\":-1,\"success\":false,\"message\":\"无权访问\"}");
            out.flush();
            out.close();
        }
    }
}
