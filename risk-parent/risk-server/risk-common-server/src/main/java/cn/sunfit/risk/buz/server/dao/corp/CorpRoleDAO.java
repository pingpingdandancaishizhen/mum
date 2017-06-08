package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CorpRole;
import cn.sunfit.risk.buz.api.vo.corp.CorpRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.RoleQueryReq;

@Repository
public interface CorpRoleDAO {

    long countRoleUse(String roleId);

    void deleteRoleFunc(String roleId);

    void deleteRoleMenu(String roleId);

    int insert(CorpRole record);

    void insertRoleFunc(@Param("roleId") String roleId, @Param("funcs") List<String> funcs);

    void insertRoleMenu(@Param("roleId") String roleId, @Param("menus") List<String> menus);

    List<CorpRole> selectAllCorpRole(String corpId);

    CorpRole selectByPrimaryKey(String id);

    List<CorpRoleDTO> selectCorpRole(RoleQueryReq req, RowBounds rowBounds);

    List<String> selectHasRole(String roleId);

    int updateByPrimaryKey(CorpRole record);
}