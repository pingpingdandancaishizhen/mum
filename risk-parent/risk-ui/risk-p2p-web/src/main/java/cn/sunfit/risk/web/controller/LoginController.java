package cn.sunfit.risk.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.system.SystemMenu;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.system.LoginChannel;
import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.web.shiro.UsernamePasswordCaptchaToken;
import cn.sunfit.risk.web.utils.IpUtil;

@Controller
public class LoginController extends BaseController {

    protected static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        final CorpUserDTO corpUser = getCurrentUser();
        if (corpUser != null) {
            return "index";
        }
        return "login";
    }

    /**
     * 登录按钮
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Resp login(String username, String password, String smsCode, String domain, HttpServletRequest request) {
        final UsernamePasswordCaptchaToken usernamePasswordToken = new UsernamePasswordCaptchaToken(username, password,
                smsCode, domain);
        final Subject subject;
        subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);
        // 登录成功后，插入登录成功历史记录
        permissionService.insertLogHistory(getCurrentUser(), IpUtil.getIpAddr(request), LoginChannel.WEB);
        final Resp resp = new Resp();
        resp.setMessage("登录成功");
        return resp;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String loginOut() {
        final Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/login";
    }

    @RequestMapping(value = "/loginSendSmsCode", method = RequestMethod.POST)
    @ResponseBody
    public Resp loginSendSmsCode(String username, String password, String domain) {
        // 需要判断用户名密码是否对，上次发送时间多久之前。才能进行发送短信
        String code = permissionService.getLoginUserCode(username, password, domain);
        return new Resp(code);
    }

    @RequestMapping(value = "/querySystemMenu", method = RequestMethod.POST)
    @ResponseBody
    public Resp querySystemMenu() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        CorpUserDTO user = (CorpUserDTO) session.getAttribute(GlobalConstants.SHIRO_LOGIN_USER);
        List<SystemMenu> systemMenuList = permissionService.querySystemMenu(user.getRoleIds(), user.getSystem()
                .getCode());
        return new Resp(systemMenuList);
    }
}
