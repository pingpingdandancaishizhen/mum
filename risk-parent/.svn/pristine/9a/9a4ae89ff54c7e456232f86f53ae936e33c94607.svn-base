package cn.sunfit.risk.buz.server.dao.templates;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.templates.MetaOperationsTemplates;

@Repository
public interface MetaOperationsTemplatesDAO {
    int insert(MetaOperationsTemplates record);

    MetaOperationsTemplates selectByPrimaryKey(String operationId);

    List<MetaOperationsTemplates> selectMetaOperationsTemplates(String bpDefId, RowBounds rowBounds);

    List<MetaOperationsTemplates> selectMetaOperationsTemplatesNoNode(String bpDefId);

    int updateByPrimaryKey(MetaOperationsTemplates record);

    void updateOperationsNodeKey(@Param("operationIds") List<String> operationIds, @Param("bpDefId") String bpDefId,
            @Param("nodeKey") String nodeKey);
}