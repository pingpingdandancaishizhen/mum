package cn.sunfit.risk.buz.server.dao.templates;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.templates.MetaCategoryTemplates;

@Repository
public interface MetaCategoryTemplatesDAO {
    int insert(MetaCategoryTemplates record);

    MetaCategoryTemplates selectByPrimaryKey(String categoryKey);

    List<MetaCategoryTemplates> selectMetaCategoryTemplates(String bpDefId, RowBounds rowBounds);

    List<MetaCategoryTemplates> selectMetaCategoryTemplatesAll(String bpDefId);

    int updateByPrimaryKey(MetaCategoryTemplates record);
}