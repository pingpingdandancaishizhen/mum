package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.Resources;

@Repository
public interface ResourcesDAO {
    void delete(@Param("domain") String domain, @Param("resourceId") String resourceId);

    int insert(@Param("domain") String domain, @Param("resource") Resources record);

    Resources selectById(@Param("domain") String domain, @Param("resourceId") String resourceId);

    List<Resources> selectByIds(@Param("domain") String domain, @Param("resourceIds") List<String> resourceIds);
}