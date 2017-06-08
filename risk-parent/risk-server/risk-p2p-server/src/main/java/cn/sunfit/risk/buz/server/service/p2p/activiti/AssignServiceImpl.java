package cn.sunfit.risk.buz.server.service.p2p.activiti;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.activiti.engine.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.corp.Corp;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNodeAssign;
import cn.sunfit.risk.buz.api.service.corp.CorpUserService;
import cn.sunfit.risk.buz.api.service.p2p.activiti.AssignService;
import cn.sunfit.risk.buz.api.service.p2p.activiti.OperLogService;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaNodeAssignDAO;
import cn.sunfit.risk.buz.server.service.p2p.activiti.assign.AssignRuleFactory;

@Service("risk.p2p.assignService")
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
    public List<String> getUserIdsByNode(String bpDefId, String nodeKey, String corpId, String bpId) {
        logger.debug("查询节点分配人员engineDefId：{}nodeKey：{}corpId：{}bpId：{}", bpDefId, nodeKey, corpId, bpId);
        // 根据节点规则查询出可以分配到的人
        Corp corp = corpDAO.selectByPrimaryKey(corpId);
        List<BPMetaNodeAssign> assigns = bpMetaNodeAssignDAO.selectByNodeKey(nodeKey, bpDefId, corp.getDomain());
        Set<String> userIds = assignRuleFactory.calUser(assigns, bpId, corp.getDomain(), corp.getId());
        return new ArrayList<String>(userIds);
    }

}
