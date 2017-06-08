package cn.sunfit.risk.buz.api.service.system;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.log.LoginLog;
import cn.sunfit.risk.buz.api.beans.system.SystemFunc;
import cn.sunfit.risk.buz.api.beans.system.SystemMenu;
import cn.sunfit.risk.buz.api.constants.LoginChannel;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.LoginHistoryReq;
import cn.sunfit.risk.buz.api.vo.system.SystemUrlFunc;

public interface PermissionService {

    String getLoginUserCode(String username, String password, String domain);

    void insertLogHistory(CorpUserDTO currentUser, String ipAddr, LoginChannel channel);

    List<SystemUrlFunc> queryAllUrlFunc();

    RespPage<List<LoginLog>> queryLoginHistory(LoginHistoryReq req);

    List<SystemFunc> queryRoleFunction(String corpId, List<String> roleIds);

    List<SystemMenu> querySystemMenu(List<String> roleIds, String systemId);
}
