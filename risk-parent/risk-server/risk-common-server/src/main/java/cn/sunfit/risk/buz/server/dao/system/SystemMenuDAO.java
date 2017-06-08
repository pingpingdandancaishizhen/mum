package cn.sunfit.risk.buz.server.dao.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.system.SystemMenu;
import cn.sunfit.risk.buz.api.vo.system.SystemMenuFunc;

@Repository
public interface SystemMenuDAO {
    int insert(SystemMenu record);

    SystemMenu selectByPrimaryKey(String id);

    List<SystemMenuFunc> selectMenuFuncByCorp(String corpId);

    List<SystemMenuFunc> selectMenuFuncByRoleCorp(@Param("corpId") String corpId, @Param("roleId") String roleId);

    List<SystemMenu> selectMenusByRoles(@Param("roleIds") List<String> roleIds, @Param("systemId") String systemId);

    int updateByPrimaryKey(SystemMenu record);
}