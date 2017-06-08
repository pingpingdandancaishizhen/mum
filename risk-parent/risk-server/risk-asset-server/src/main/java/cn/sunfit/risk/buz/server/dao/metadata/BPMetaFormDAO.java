package cn.sunfit.risk.buz.server.dao.metadata;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaForm;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaFormDefQuery;
import cn.sunfit.risk.buz.api.vo.solution.BpMetaFormDefVO;

@Repository
public interface BPMetaFormDAO {

    List<BpMetaFormDefVO> selectBPMetaFormByDefId(BpMetaFormDefQuery req);

    // 查询开始表单
    BPMetaForm selectStartFormByBpDefId(FormQuery req);

    // 根据taskkey和bpid查询表单
    BPMetaForm selectTaskFormByBpDefIdTaskKey(@Param("req") FormQuery req, @Param("taskKey") String taskDefinitionKey);

}