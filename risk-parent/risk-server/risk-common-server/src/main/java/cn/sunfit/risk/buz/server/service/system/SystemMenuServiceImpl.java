package cn.sunfit.risk.buz.server.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.service.system.SystemMenuService;
import cn.sunfit.risk.buz.api.vo.system.SystemMenuFunc;
import cn.sunfit.risk.buz.server.dao.system.SystemMenuDAO;

@Service("risk.systemMenuService")
public class SystemMenuServiceImpl implements SystemMenuService {
    @Autowired
    private SystemMenuDAO systemMenuDAO;

    @Override
    public List<SystemMenuFunc> queryAllCorpFuncMenu(String corpId) {
        List<SystemMenuFunc> list = systemMenuDAO.selectMenuFuncByCorp(corpId);
        return list;
    }

    @Override
    public List<SystemMenuFunc> queryRoleCorpFuncMenu(String corpId, String roleId) {
        List<SystemMenuFunc> list = systemMenuDAO.selectMenuFuncByRoleCorp(corpId, roleId);
        return list;
    }
}
