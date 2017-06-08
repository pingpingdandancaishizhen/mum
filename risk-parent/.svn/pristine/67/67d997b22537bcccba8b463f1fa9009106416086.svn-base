package cn.sunfit.risk.buz.server.service.p2p.activiti.listener.handler;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaNodeDAO;
import cn.sunfit.risk.buz.server.service.p2p.activiti.listener.EventHandler;

@Component("activityStartedHandler")
public class ActivityStartedHandler implements EventHandler {
    private static Logger logger = LoggerFactory.getLogger(ActivityStartedHandler.class);

    @Autowired
    private BPMetaNodeDAO bpMetaNodeDAO;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private CorpDAO corpDAO;

    @Override
    public void handler(ActivitiEvent event) {
        // ActivitiActivityEventImpl eventImpl = (ActivitiActivityEventImpl) event;
        // String activityId = eventImpl.getActivityId();
        // String entityName = eventImpl.getActivityName();
        // String instId = eventImpl.getProcessInstanceId();
        // ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(instId).singleResult();
        // String bpId = BPUtils.parseIdFromBuzKey(pi.getBusinessKey());
        // String corpId = BPUtils.parseCorpIdFromBuzKey(pi.getBusinessKey());
        // Corp corp = corpDAO.selectByPrimaryKey(corpId);
        // IExecutionCmd cmd = ProcessHandleHelper.getProcessCmd();
        // if (cmd != null) {
        // BPMetaNode node = bpMetaNodeDAO.selectByNodeKey(activityId, cmd.getBpDefId(), corp.getDomain());
        // }
        //
        // logger.debug("entity:" + activityId + " entityName:" + entityName);
        // if (node != null) {
        // // TODO 会签先不做处理
        // BPRunPath path = new BPRunPath();
        // path.setPathId(IdUtil.geneId());
        // path.setBpDefId(eventImpl.getProcessDefinitionId());
        // path.setBpEngineKey(eventImpl.getProcessInstanceId());
        // path.setExcutionId(eventImpl.getExecutionId());
        // path.setNodeName(node.getNodeName());
        // path.setNodeKey(node.getNodeKey());
        // path.setNodeType(node.getNodeType());
        // path.setStartTime(new Date());
        // path.setBpId(bpId);
        // // 是否多实例需要扩展
        //
        // }

    }

}