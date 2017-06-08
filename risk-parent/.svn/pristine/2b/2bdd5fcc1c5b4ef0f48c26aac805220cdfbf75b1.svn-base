package cn.sunfit.risk.buz.server.dao.templates;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.templates.MetaNodesTemplates;

@Repository
public interface MetaNodesTemplatesDAO {
    int insert(MetaNodesTemplates record);

    void insertBatch(@Param("list") List<MetaNodesTemplates> nodeList);

    MetaNodesTemplates selectByPrimaryKey(String nodeId);

    List<MetaNodesTemplates> selectMetaNodesTemplates(String bpDefId, RowBounds rowBounds);

    int updateByPrimaryKey(MetaNodesTemplates record);
}