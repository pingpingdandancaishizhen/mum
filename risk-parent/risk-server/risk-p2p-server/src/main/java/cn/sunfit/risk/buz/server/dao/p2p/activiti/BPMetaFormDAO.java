package cn.sunfit.risk.buz.server.dao.p2p.activiti;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaForm;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormDefQuery;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.BpMetaFormDefVO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;

@Repository
public interface BPMetaFormDAO {

    List<BpMetaFormDefVO> selectBPMetaFormByDefId(BpMetaFormDefQuery req);

    // 查询编辑表单
    BPMetaForm selectEditFormByBpDefId(FormQuery req);

    // 查询开始表单
    BPMetaForm selectStartFormByBpDefId(FormQuery req);

    // 根据taskkey和bpid查询表单
    BPMetaForm selectTaskFormByBpDefIdTaskKey(@Param("req") FormQuery req, @Param("taskKey") String taskDefinitionKey);

    // 查询查看表单
    BPMetaForm selectViewFormByBpDefId(FormQuery req);

}