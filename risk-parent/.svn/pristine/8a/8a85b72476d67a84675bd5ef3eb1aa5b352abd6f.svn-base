package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpRole;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.RoleQueryReq;

public interface CorpRoleService {

    List<CorpRole> queryAllRole(String corpId);

    CorpRole queryRoleById(String roleId);

    RespPage<List<CorpRoleDTO>> queryRoleList(RoleQueryReq req);

    void saveRole(CorpRoleAddReq role);

    void updateStatus(String corpId, String roleId, String status);

}
