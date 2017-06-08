package cn.sunfit.risk.buz.server.dao.templates;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.templates.MetaTemplates;

@Repository
public interface MetaTemplatesDAO {
    void copy2Corp(@Param("bpDefId") String bpDefId, @Param("corpId") String corpId, @Param("domain") String domain);

    int insert(MetaTemplates record);

    MetaTemplates selectByPrimaryKey(String bpDefId);

    List<MetaTemplates> selectMetaTemplates(RowBounds rowBounds);

    int updateByPrimaryKey(MetaTemplates record);

    int updateByPrimaryKeyWithBLOBs(MetaTemplates record);
}