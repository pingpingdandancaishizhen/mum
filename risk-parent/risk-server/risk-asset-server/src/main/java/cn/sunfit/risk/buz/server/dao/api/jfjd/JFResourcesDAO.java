package cn.sunfit.risk.buz.server.dao.api.jfjd;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFResources;
import cn.sunfit.risk.buz.api.beans.corp.Resources;

@Repository
public interface JFResourcesDAO {
    void delete(@Param("domain") String domain, @Param("resourceId") String resourceId);

    int insert(@Param("domain") String domain, @Param("resource") Resources record);

    JFResources selectById(@Param("domain") String domain, @Param("resourceId") String resourceId);

    List<JFResources> selectByIds(@Param("domain") String domain, @Param("resourceIds") List<String> resourceIds);
}