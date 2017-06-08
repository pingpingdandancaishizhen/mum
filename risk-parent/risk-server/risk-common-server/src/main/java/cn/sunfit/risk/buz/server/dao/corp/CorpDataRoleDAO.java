package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CorpDataRole;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.DataRoleQueryReq;

@Repository
public interface CorpDataRoleDAO {

    long countDataRoleUse(String roleId);

    void deleteDataRoleDept(String id);

    int insert(CorpDataRole record);

    void insertDataRoleDept(@Param("roleId") String roleId, @Param("deptIds") List<String> deptIds);

    List<CorpDataRoleDTO> selectAllDataRole(String corpId);

    List<String> selectBpPermission(@Param("deptId") String deptId);

    CorpDataRole selectByPrimaryKey(String id);

    List<CorpDataRoleDTO> selectCorpDataRole(DataRoleQueryReq req, RowBounds rowBounds);

    List<CorpDataRoleDTO> selectUserCorpDataRole(@Param("userId") String userId, @Param("corpId") String corpId);

    int updateByPrimaryKey(CorpDataRole record);

}