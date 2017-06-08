package cn.sunfit.risk.buz.server.dao.system;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.system.SystemFunc;
import cn.sunfit.risk.buz.api.vo.system.SystemUrlFunc;

@Repository
public interface SystemFuncDAO {
    int insert(SystemFunc record);

    List<SystemUrlFunc> queryAllUrlFunc();

    List<SystemFunc> queryFuncByMenuCorp(@Param("corpId") String corpId, @Param("menuId") String menuId);

    List<SystemFunc> queryFuncByMenuCorpRole(@Param("corpId") String corpId, @Param("menuId") String menuId,
            @Param("roleId") String roleId);

    List<SystemFunc> queryRoleFunction(Map<String, Object> param);

    SystemFunc selectByPrimaryKey(String id);

    int updateByPrimaryKey(SystemFunc record);
}