package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptListVO;
import cn.sunfit.risk.buz.api.constants.system.DeptStatusType;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptNodeDTO;

public interface CorpDeptService {

    void addDept(CorpDept dept);

    void changeDeptStatus(String id, DeptStatusType type);

    List<String> getAllDeptIds(String deptId);

    CorpDeptNodeDTO queryAllAvailableDept(String corpId);

    CorpDeptNodeDTO queryAllDept(String corpId);

    List<CorpDept> queryByDeptType(String corpId, String type);

    List<CorpDeptListVO> queryCoopDetps(String corpId);

    List<CorpDept> queryCorpDeptList(String corpId);

    List<CorpDept> queryDeptByDataRole(String corpId, String roleId);

    List<CorpDept> selectAddableCorpDept(String corpId, Integer level);

    List<CorpDept> selectAvailableCorpDept(String corpId);
    
    List<CorpDept> selectAvailableCorpDeptByType(String corpId,Integer Type);

    void updateDept(CorpDept dept);
}
