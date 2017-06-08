package cn.sunfit.risk.buz.api.service.system;

import java.util.List;

import cn.sunfit.risk.buz.api.vo.system.SystemMenuFunc;

public interface SystemMenuService {
    List<SystemMenuFunc> queryAllCorpFuncMenu(String corpId);

    List<SystemMenuFunc> queryRoleCorpFuncMenu(String corpId, String roleId);
}
