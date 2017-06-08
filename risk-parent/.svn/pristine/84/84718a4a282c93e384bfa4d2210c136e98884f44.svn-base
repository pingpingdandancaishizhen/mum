package cn.sunfit.risk.buz.server.service.p2p.activiti.listener.handler;

import java.util.Date;

import org.activiti.engine.delegate.event.ActivitiEntityEvent;
import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPJump;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.cmd.IExecutionCmd;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.cmd.ProcessHandleHelper;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPJumpDAO;
import cn.sunfit.risk.buz.server.service.p2p.activiti.listener.EventHandler;

@Component("taskCompletedHandler")
public class TaskCompletedHandler implements EventHandler {
    private static Logger logger = LoggerFactory.getLogger(TaskCompletedHandler.class);

    @Autowired
    private BPJumpDAO bpJumpDAO;

    @Autowired
    private CorpDAO corpDAO;

    @Override
    public void handler(ActivitiEvent event) {
        logger.info("事件进入了taskCompletedHandler");
        ActivitiEntityEvent actEvent = (ActivitiEntityEvent) event;
        TaskEntity taskEntity = (TaskEntity) actEvent.getEntity();
        String corpId = taskEntity.getTenantId();
        String businessKey = taskEntity.getProcessInstance().getBusinessKey();
        String domain = corpDAO.selectByPrimaryKey(corpId).getDomain();
        // 处理多实例会签//TODO 会签需要处理
        String multiInstance = (String) taskEntity.getExecution().getActivity().getProperty("multiInstance");
        if (StringUtils.isNotEmpty(multiInstance)) {
            // handleMultiTask(taskEntity);
        }
        // 更新
        updateNodeJump(taskEntity.getId(), domain);
    }

    private void updateNodeJump(String taskId, String domain) {
        IExecutionCmd cmd = ProcessHandleHelper.getProcessCmd();
        BPJump nodeJump = bpJumpDAO.selectByTaskId(taskId, domain);
        if (nodeJump == null) {
            return;
        }
        nodeJump.setDomain(domain);
        nodeJump.setCheckStatus(cmd.getOperaType());
        // nodeJump.setRemark(cmd.getOpinion());
        nodeJump.setHandleId(cmd.getUserId());
        nodeJump.setCompleteTime(new Date());
        Long duration = Long.valueOf(nodeJump.getCompleteTime().getTime() - nodeJump.getCreateTime().getTime());
        nodeJump.setDuration(Integer.valueOf(duration.intValue()));
        if (cmd != null) {
            nodeJump.setCheckStatus(cmd.getOperaType());
            nodeJump.setRemark(cmd.getOption());
        }
        bpJumpDAO.updateByPrimaryKey(nodeJump);
    }
}
