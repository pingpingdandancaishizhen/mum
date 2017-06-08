package cn.sunfit.risk.buz.server.dao.templates;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.templates.MetaFormsTemplates;

@Repository
public interface MetaFormsTemplatesDAO {
    int insert(MetaFormsTemplates record);

    MetaFormsTemplates selectByPrimaryKey(String formId);

    List<MetaFormsTemplates> selectMetaFormsTemplates(String bpDefId, RowBounds rowBounds);

    int updateByPrimaryKey(MetaFormsTemplates record);

    int updateByPrimaryKeyWithBLOBs(MetaFormsTemplates record);
}