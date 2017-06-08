package cn.sunfit.risk.buz.server.dao.templates;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.templates.MetaFieldsTemplates;

@Repository
public interface MetaFieldsTemplatesDAO {
    int insert(MetaFieldsTemplates record);

    MetaFieldsTemplates selectByPrimaryKey(String fieldId);

    List<MetaFieldsTemplates> selectMetaFieldsTemplates(String bpDefId, RowBounds rowBounds);

    int updateByPrimaryKey(MetaFieldsTemplates record);
}