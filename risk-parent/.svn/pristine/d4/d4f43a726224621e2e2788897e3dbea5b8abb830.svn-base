package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpDataRole;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.DataRoleQueryReq;

public interface CorpDataRoleService {

    List<String> getPermissionByBpId(String bpId, String corpId);

    List<CorpDataRoleDTO> queryAllDataRole(String corpId);

    CorpDataRole queryDataRoleById(String roleId);

    RespPage<List<CorpDataRoleDTO>> queryDataRoleList(DataRoleQueryReq req);

    void saveDataRole(CorpDataRoleAddReq role);

    void updateStatus(String corpId, String roleId, String status);

}
