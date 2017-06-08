package cn.sunfit.risk.buz.server.service.activiti;

import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.beans.buz.BPOperLog;
import cn.sunfit.risk.buz.api.beans.corp.Corp;
import cn.sunfit.risk.buz.api.service.activiti.AssignService;
import cn.sunfit.risk.buz.api.service.buz.OperLogService;
import cn.sunfit.risk.buz.api.service.corp.CorpUserService;
import cn.sunfit.risk.buz.api.utils.OperLogUtil;
import cn.sunfit.risk.buz.api.vo.loan.AssignReq;
import cn.sunfit.risk.buz.server.activiti.assign.AssignRuleFactory;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaNodeAssignDAO;

@Service("risk.assignService")
public class AssignServiceImpl implements AssignService {
    Logger logger = LoggerFactory.getLogger(AssignServiceImpl.class);

    @Autowired
    private CorpDAO corpDAO;
    @Autowired
    private BPMetaNodeAssignDAO bpMetaNodeAssignDAO;
    @Autowired
    private AssignRuleFactory assignRuleFactory;
    @Autowired
    private BPDAO bpDAO;
    @Autowired
    private TaskService taskService;
    @Autowired
    private CorpUserService corpUserService;
    @Autowired
    private OperLogService operLogService;

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 30)
    public void assignBp2Other(AssignReq req) {
        // 将BP修改createuserid 修改
        BP bp = bpDAO.findById(req.getCorpId(), req.getDomain(), req.getBpId());
        String oldUser = bp.getCreateUserId();
        bp.setCreateUserId(req.getAssignId());
        bp.setDomain(req.getDomain());
        bpDAO.update(bp);
        // 将待办换掉
        List<Task> tasks = taskService.createTaskQuery().processInstanceBusinessKeyLike("%:" + bp.getBpId() + ":%")
                .taskCandidateOrAssigned(oldUser).list();
        for (Task task : tasks) {
            if (task.getAssignee() != null && StringUtils.equals(oldUser, task.getAssignee())) {
                task.setAssignee(req.getAssignId());
            }
            if (task.getAssignee() == null) {
                taskService.deleteCandidateUser(task.getId(), oldUser);
                taskService.addCandidateUser(task.getId(), req.getAssignId());
            }
        }

        BPOperLog log = OperLogUtil.createAssignLog(req, bp, corpUserService.queryById(req.getCorpId(), oldUser),
                corpUserService.queryById(req.getCorpId(), req.getAssignId()));
        operLogService.insert(log);
    }

    @Override
    public List<String> getUserIdsByNode(String bpDefId, String nodeKey, String corpId, String bpId) {
        logger.debug("查询节点分配人员engineDefId：{}nodeKey：{}corpId：{}bpId：{}", bpDefId, nodeKey, corpId, bpId);
        // 根据节点规则查询出可以分配到的人
        Corp corp = corpDAO.selectByPrimaryKey(corpId);
        // List<BPMetaNodeAssign> assigns = bpMetaNodeAssignDAO.selectByNodeKey(nodeKey, bpDefId, corp.getDomain());
        // Set<String> userIds = assignRuleFactory.calUser(assigns, bpId, corp.getDomain(), corp.getId());
        // return new ArrayList<String>(userIds);

        List<String> userIds = bpMetaNodeAssignDAO.selectUserByNodeKey(nodeKey, bpDefId, corp.getDomain());
        return userIds;
    }

}
