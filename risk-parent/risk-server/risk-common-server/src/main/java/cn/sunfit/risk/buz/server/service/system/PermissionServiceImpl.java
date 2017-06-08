package cn.sunfit.risk.buz.server.service.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.corp.UserCode;
import cn.sunfit.risk.buz.api.beans.log.LoginLog;
import cn.sunfit.risk.buz.api.beans.system.SystemFunc;
import cn.sunfit.risk.buz.api.beans.system.SystemMenu;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.LoginChannel;
import cn.sunfit.risk.buz.api.constants.UserCodeType;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.system.PermissionService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.LoginHistoryReq;
import cn.sunfit.risk.buz.api.vo.system.SystemUrlFunc;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;
import cn.sunfit.risk.buz.server.dao.corp.UserCodeDAO;
import cn.sunfit.risk.buz.server.dao.log.LoginLogDAO;
import cn.sunfit.risk.buz.server.dao.system.SystemFuncDAO;
import cn.sunfit.risk.buz.server.dao.system.SystemMenuDAO;
import cn.sunfit.risk.buz.server.util.Digests;
import cn.sunfit.risk.buz.server.util.Encodes;
import cn.sunfit.risk.buz.server.util.IpUtil;
import cn.sunfit.risk.buz.server.util.SmsService;

@Service("risk.permissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SystemFuncDAO systemFuncDAO;
    @Autowired
    private SystemMenuDAO systemMenuDAO;
    @Autowired
    private CorpUserDAO corpUserDAO;
    @Autowired
    private UserCodeDAO userCodeDAO;
    @Autowired
    private LoginLogDAO loginLogDAO;
    @Autowired
    private SmsService smsService;

    @Override
    public String getLoginUserCode(String username, String password, String domain) {
        CorpUserDTO dto = new CorpUserDTO();
        dto.setUserAccount(username);
        dto.setDomain(domain);
        CorpUserDTO corpUser = corpUserDAO.selectCorpUserByIdOrCode(dto);
        if (corpUser == null) {
            throw new ServiceException("用户名或密码错误！");
        }
        byte[] salt = Encodes.decodeHex(corpUser.getSalt());
        byte[] hashPassword = Digests.sha1(new String(password).getBytes(), salt, GlobalConstants.HASH_INTERATIONS);
        String codepassword = Encodes.encodeHex(hashPassword).toUpperCase();
        if (!corpUser.getPassword().equals(codepassword)) {
            throw new ServiceException("用户名或密码错误！");
        } else {
            // 查询当天第几次发送
            long sendsum = userCodeDAO.countSendCode(corpUser.getId(), UserCodeType.LOGIN.getStatus());
            /*
             * if (sendsum > 10) { throw new ServiceException("短信验证码每天只能获取十次！"); }
             */

            // 如果一分钟前已经发送过，丢弃
            // UserCode userCode = userCodeDAO.selectLastCode(corpUser.getId(), UserCodeType.LOGIN.getStatus());
            // if (userCode != null && ((new Date().getTime() - userCode.getEffectiveTime().getTime()) < 0)) {
            // throw new ServiceException("短信验证码仍然未失效！");
            // }
            int i = RandomUtils.nextInt(1, 999999);
            String code = StringUtils.leftPad(String.valueOf(i), 6, '0');
            UserCode cd = new UserCode();
            cd.setCode(code);
            cd.setCodeType(UserCodeType.LOGIN.getStatus());
            cd.setCreateTime(new Date());
            cd.setPhone(corpUser.getTelephone());
            cd.setStatus("0");
            cd.setUserId(corpUser.getId());
            cd.setEffectiveTime(DateUtils.addSeconds(new Date(), 60));
            cd.setId(IdUtil.geneId());
            userCodeDAO.insert(cd);
            // 发送短信
            int expiredMinutes = 1;
            String verifyCode = code;
            List<String> params = new ArrayList<String>();
            params.add(verifyCode);
            params.add(expiredMinutes + "");
            // smsService.sendMsg(corpUser.getTelephone(), SMSTemplateEnum.SMS_VERIFY_CODE.getKey(), params);
            return code;
        }
    }

    @Override
    @Async
    public void insertLogHistory(CorpUserDTO currentUser, String ipAddr, LoginChannel channel) {
        String[] addr = IpUtil.getAddrByIP(ipAddr);
        LoginLog log = new LoginLog();
        log.setId(IdUtil.geneId());
        if (addr != null) {
            log.setAddress(StringUtils.join(addr, ""));
            log.setCity(addr[2]);
            log.setIsp(addr[3]);
            log.setRegion(addr[1]);
            log.setCountry(addr[0]);
        }
        log.setCreateTime(new Date());
        log.setIp(ipAddr);
        log.setChannel(channel.getStatus());
        log.setUserId(currentUser.getId());
        loginLogDAO.insert(log);
    }

    @Override
    public List<SystemUrlFunc> queryAllUrlFunc() {
        return systemFuncDAO.queryAllUrlFunc();
    }

    @Override
    public RespPage<List<LoginLog>> queryLoginHistory(LoginHistoryReq req) {
        List<LoginLog> list = loginLogDAO.selectByUserId(req, new RowBounds(req.getOffset(), req.getLimit()));
        final int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<LoginLog>>(list, totalCount);
    }

    @Override
    public List<SystemFunc> queryRoleFunction(String corpId, List<String> roleIds) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("corpId", corpId);
        param.put("roleIds", roleIds);
        return systemFuncDAO.queryRoleFunction(param);
    }

    @Override
    public List<SystemMenu> querySystemMenu(List<String> roleIds, String systemId) {
        if (roleIds == null || roleIds.isEmpty()) {
            return new ArrayList<SystemMenu>();
        }
        return systemMenuDAO.selectMenusByRoles(roleIds, systemId);
    }
}
