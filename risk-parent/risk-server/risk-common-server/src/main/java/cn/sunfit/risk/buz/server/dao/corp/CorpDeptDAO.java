package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptContractVO;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptListVO;
import cn.sunfit.risk.buz.api.vo.corp.CorpDeptNodeDTO;

@Repository
public interface CorpDeptDAO {

    CorpDept getCoopDetpById(@Param("deptId") String deptId);

    CorpDeptContractVO getDeptNameByBp(@Param("bpId") String bpId, @Param("domain") String domain);

    List<CorpDept> getDeptsByParent(@Param("deptCode") String deptCode);

    int insert(CorpDept record);

    List<CorpDeptListVO> queryCoopDetps(@Param("corpId") String corpId);

    List<CorpDept> queryCorpDeptList(String corpId);

    List<CorpDept> queryDeptByDataRole(@Param("corpId") String corpId, @Param("roleId") String roleId);

    List<CorpDept> selectAddableCorpDept(@Param("corpDept") CorpDept corpDept, @Param("statusList") String[] statusList);

    /**
     * 查询所有未删除公司部门
     * @Title: selectAllCorpDept
     * @Description: TODO
     * @param @param corpId
     * @param @return   
     * @return List<CorpDept> 
     * @author XJ 2016年12月16日 
     * @throws
     */
    List<CorpDept> selectAllCorpDept(String corpId);

    List<CorpDept> selectAvailableCorpDept(@Param("corpId") String corpId);
    
    List<CorpDept> selectAvailableCorpDeptByType(@Param("corpId") String corpId,@Param("deptType")Integer deptType);

    CorpDeptNodeDTO selectAvailableCorpDeptRoot(@Param("corpId") String corpId, @Param("deptCode") String deptCode);

    List<CorpDeptNodeDTO> selectAvailableCorpDeptSub(@Param("corpId") String corpId, @Param("deptCode") String deptCode);

    List<CorpDept> selectByDeptType(@Param("corpId") String corpId, @Param("deptType") String type);

    CorpDept selectByPrimaryKey(String id);

    List<CorpDept> selectCorpDept(@Param("corpDept") CorpDept corpDept, @Param("statusList") String[] statusList);

    CorpDeptNodeDTO selectCorpDeptRoot(@Param("corpId") String corpId, @Param("deptCode") String deptCode);

    List<CorpDeptNodeDTO> selectCorpDeptSub(@Param("corpId") String corpId, @Param("deptCode") String deptCode);

    CorpDept selectDeptByUserId(String userId);

    int selectDeptCountByCorpId(@Param("corpId") String corpId);

    int updateByPrimaryKey(CorpDept record);

    int updateStatusById(@Param("id") String id, @Param("status") String status);
}