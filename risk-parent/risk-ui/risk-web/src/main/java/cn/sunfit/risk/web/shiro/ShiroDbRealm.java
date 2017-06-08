package cn.sunfit.risk.web.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sunfit.risk.buz.api.beans.system.SystemFunc;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.UserCodeType;
import cn.sunfit.risk.buz.api.constants.UserStatusType;
import cn.sunfit.risk.buz.api.service.corp.CorpUserService;
import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.web.exception.LossSmsCodeException;
import cn.sunfit.risk.web.utils.Digests;
import cn.sunfit.risk.web.utils.Encodes;

/**
 * 登录认证、鉴权
 *
 */
public class ShiroDbRealm extends AuthorizingRealm {

    protected static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);

    @Autowired
    private CorpUserService corpUserService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 认证回调函数,登录时调用.
     * 
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
        CorpUserDTO corpUserDTO = new CorpUserDTO();
        corpUserDTO.setUserAccount(token.getUsername());
        corpUserDTO.setDomain(token.getDomain());
        CorpUserDTO corpUser = null;
        try {
            corpUser = corpUserService.queryCorpUserByIdOrCode(corpUserDTO);
        } catch (Exception e) {
            throw new AuthenticationException(e.getMessage());
        }
        if (corpUser != null) {
            byte[] salt = null;
            if (StringUtils.isNotEmpty(corpUser.getSalt())) {
                salt = Encodes.decodeHex(corpUser.getSalt());
            }
            byte[] hashPassword = Digests.sha1(new String(token.getPassword()).getBytes(), salt,
                    GlobalConstants.HASH_INTERATIONS);
            String password = Encodes.encodeHex(hashPassword).toUpperCase();
            if (corpUser.getPassword().equals(password)) {
                // 状态是激活的
                if (UserStatusType.Active.getStatus().equals(corpUser.getStatus())) {
                    logger.info("username password match");
                    // 判断是否开启了短信登录认证
                    // if ("1".equals(corpUser.getSmsLoginOpt())) {
                    if (StringUtils.isEmpty(token.getSmsCode())) {
                        throw new LossSmsCodeException("您的账户需要手机验证码登录");
                    } else {
                        boolean flag = corpUserService.checkUserSmsCode(corpUser.getId(), token.getSmsCode(),
                                UserCodeType.LOGIN);
                        if (flag) {
                            Subject currentUser = SecurityUtils.getSubject();
                            Session session = currentUser.getSession();
                            session.setAttribute(GlobalConstants.SHIRO_LOGIN_USER, corpUser);
                            return new SimpleAuthenticationInfo(corpUser, token.getPassword(), null, getName());
                        } else {
                            throw new AuthenticationException("您的手机验证码输入有误");
                        }
                    }
                    // } else {
                    // Subject currentUser = SecurityUtils.getSubject();
                    // Session session = currentUser.getSession();
                    // session.setAttribute(GlobalConstants.SHIRO_LOGIN_USER, corpUser);
                    // session.setAttribute("userId", corpUser.getId());
                    // return new SimpleAuthenticationInfo(corpUser, token.getPassword(), null, getName());
                    // }
                } else if (UserStatusType.Suspended.getStatus().equals(corpUser.getStatus())) {
                    throw new AuthenticationException("用户名或密码错误！");
                } else
                    throw new AuthenticationException("用户名或密码错误！");
            } else {
                throw new AuthenticationException("用户名或密码错误！");
            }
        } else {
            throw new AuthenticationException("用户名不存在！");
        }
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Subject currentUser = SecurityUtils.getSubject();
        CorpUserDTO user = (CorpUserDTO) currentUser.getPrincipal();
        // 查询用户所有权限
        List<SystemFunc> allFunctionList = permissionService.queryRoleFunction(user.getCorpId(), user.getRoleIds());
        List<String> funcCodeList = new ArrayList<String>();
        if (null != allFunctionList && allFunctionList.size() > 0) {
            for (SystemFunc sysFunc : allFunctionList) {
                String funcCode = sysFunc.getFuncCode();
                if (!StringUtils.isEmpty(funcCode) && !funcCodeList.contains(funcCode)) {
                    funcCodeList.add(sysFunc.getFuncCode());
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        logger.info("addStringPermissions---->" + funcCodeList);
        info.addStringPermissions(funcCodeList);
        return info;
    }

    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        // HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(AccountService.HASH_ALGORITHM);
        // matcher.setHashIterations(AccountService.HASH_INTERATIONS);
        // setCredentialsMatcher(matcher);
    }

}
