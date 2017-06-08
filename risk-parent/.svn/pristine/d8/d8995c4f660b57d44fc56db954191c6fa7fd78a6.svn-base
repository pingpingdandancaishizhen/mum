package cn.sunfit.risk.buz.server.activiti.listener.handler;

import java.util.Date;
import java.util.List;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.api.beans.buz.BPJump;
import cn.sunfit.risk.buz.api.beans.buz.BPRunPath;
import cn.sunfit.risk.buz.api.cmd.ProcessHandleHelper;
import cn.sunfit.risk.buz.api.service.activiti.AssignService;
import cn.sunfit.risk.buz.api.service.corp.CorpDataRoleService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.server.activiti.listener.EventHandler;
import cn.sunfit.risk.buz.server.dao.buz.BPJumpDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPRunPathDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.service.buz.BPUtils;

@Component("taskCreatedHandler")
public class TaskCreatedHandler implements EventHandler {
    private static Logger logger = LoggerFactory.getLogger(TaskCreatedHandler.class);

    @Autowired
    private AssignService assignService;
    @Autowired
    private CorpDataRoleService corpDataRoleService;
    @Autowired
    private BPJumpDAO bpJumpDAO;
    @Autowired
    private BPRunPathDAO bpRunPathDAO;
    @Autowired
    private CorpDAO corpDAO;

    private BPJump createNodeJump(TaskEntity taskEntity, String bpDefId, String domain, String bpId) {
        BPJump j = new BPJump();
        j.setBpDefId(bpDefId);
        j.setCheckStatus("-2");
        // j.setCompleteTime(completeTime);
        // j.setDuration(duration);
        // j.setDurationVal(durationVal);
        j.setEngineKey(taskEntity.getProcessInstanceId());
        // j.setHandleId(handleId);
        j.setJumpId(IdUtil.geneId());
        j.setJumpType("UNHANDLE");
        j.setNodeKey(taskEntity.getTaskDefinitionKey());
        j.setNodeName(taskEntity.getName());
        // j.setOwnerId(ownerId);
        j.setRemark("无");
        j.setTaskId(taskEntity.getId());
        j.setDomain(domain);
        j.setCreateTime(new Date());
        j.setBpId(bpId);
        bpJumpDAO.insert(j);
        return j;
    }

    private String getUserIds(String userIds, Integer index) {
        String[] uIds = userIds.split("[,]");
        if (index.intValue() < uIds.length) {
            return uIds[index.intValue()];
        }
        return null;
    }

    @Override
    public void handler(ActivitiEvent event) {
        logger.debug("事件进入了TaskCreateHandler");
        ActivitiEntityEventImpl eventImpl = (ActivitiEntityEventImpl) event;
        TaskEntity taskEntity = (TaskEntity) eventImpl.getEntity();
        // 获取节点ID，根据节点ID查询
        String pdefid = taskEntity.getProcessDefinitionId();
        String nodekey = taskEntity.getTaskDefinitionKey();
        String corpId = taskEntity.getTenantId();
        String businessKey = taskEntity.getProcessInstance().getBusinessKey();
        String bpId = BPUtils.parseIdFromBuzKey(businessKey);
        String bpDefId = BPUtils.parseBpDefIdFromBuzKey(businessKey);
        String domain = corpDAO.selectByPrimaryKey(corpId).getDomain();
        BPJump nodeJump = createNodeJump(taskEntity, bpDefId, domain, bpId);
        boolean isAssigned = false;
        // 获取path
        String multiInstance = (String) taskEntity.getExecution().getActivity().getProperty("multiInstance");
        BPRunPath backRuPath = ProcessHandleHelper.getBackPath();
        if ((backRuPath != null) && StringUtils.isEmpty(multiInstance)) {
            if ("userTask".equals(backRuPath.getNodeType())) {
                taskEntity.setAssignee(backRuPath.getAssignee());
                isAssigned = true;
            } else {
                BPRunPath nodePath = bpRunPathDAO.selectByParentIdNodeId(backRuPath.getPathId(),
                        taskEntity.getTaskDefinitionKey(), domain);
                if (nodePath != null && StringUtils.isNotEmpty(nodePath.getAssignee())) {
                    taskEntity.setAssignee(nodePath.getAssignee());
                    isAssigned = true;
                }
            }
        }
        if (isAssigned) {
            updateJump(nodeJump, taskEntity);
            return;
        }
        if (StringUtils.isNotEmpty(multiInstance)) {
            Integer loopCounter = (Integer) taskEntity.getExecution().getVariable("loopCounter");
            String signUserIds = (String) taskEntity.getExecution().getVariable(
                    "signUserIds_" + taskEntity.getTaskDefinitionKey());

            String assignee = getUserIds(signUserIds, loopCounter);
            if (StringUtils.isNotEmpty(assignee)) {
                isAssigned = true;
                taskEntity.setAssignee(assignee);
                if (taskEntity.getOwner() == null) {
                    taskEntity.setOwner(assignee);
                }
                Date expiretime = (Date) taskEntity.getExecution().getVariable(
                        "expiretime_" + taskEntity.getTaskDefinitionKey());
                Integer priority = (Integer) taskEntity.getExecution().getVariable(
                        "priority_" + taskEntity.getTaskDefinitionKey());
                taskEntity.setDueDate(expiretime);
                taskEntity.setPriority(priority.intValue());
            }
        }
        if (isAssigned) {
            updateJump(nodeJump, taskEntity);
            return;
        }

        List<String> userIds = assignService.getUserIdsByNode(bpDefId, nodekey, corpId, bpId);
        // 查看此单号有没有数据权限
        List<String> roleusers = corpDataRoleService.getPermissionByBpId(bpId, corpId);
        userIds.retainAll(roleusers);
        // 分配
        if (!userIds.isEmpty()) {
            if (userIds.size() == 1) {
                taskEntity.setAssignee(userIds.get(0));
                taskEntity.setOwner(userIds.get(0));
            } else {
                taskEntity.addCandidateUsers(userIds);
            }
            isAssigned = true;
        }
        if (isAssigned) {
            updateJump(nodeJump, taskEntity);
        }
    }

    private void updateJump(BPJump nodeJump, TaskEntity taskEntity) {
        nodeJump.setOwnerId(taskEntity.getAssignee());
        bpJumpDAO.updateByPrimaryKey(nodeJump);
    }
}
