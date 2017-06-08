package cn.sunfit.risk.buz.server.service.p2p.activiti.listener.handler;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNode;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaNodeDAO;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;
import cn.sunfit.risk.buz.server.service.p2p.activiti.BPUtils;
import cn.sunfit.risk.buz.server.service.p2p.activiti.listener.EventHandler;

@Component("processCompletedHandler")
public class ProcessCompletedHandler implements EventHandler {
    private static Logger logger = LoggerFactory.getLogger(ProcessCompletedHandler.class);

    @Autowired
    private CorpDAO corpDAO;

    @Autowired
    private BPMetaNodeDAO bpMetaNodeDAO;
    @Autowired
    private LoanInfoDAO loanInfoDAO;

    @Override
    public void handler(ActivitiEvent event) {
        logger.debug("事件进入了ProcessCompletedHandler");
        ActivitiEntityEventImpl eventImpl = (ActivitiEntityEventImpl) event;
        ExecutionEntity e = (ExecutionEntity) eventImpl.getEntity();
        String businessKey = e.getBusinessKey();
        String bpId = BPUtils.parseIdFromBuzKey(businessKey);
        String bpDefId = BPUtils.parseBpDefIdFromBuzKey(businessKey);
        String corpId = BPUtils.parseCorpIdFromBuzKey(businessKey);
        String domain = corpDAO.selectByPrimaryKey(corpId).getDomain();
        BPMetaNode node = bpMetaNodeDAO.selectByNodeKey(e.getActivityId(), bpDefId, domain);
        loanInfoDAO.updateStatus(domain, bpId, node.getStatus());
    }

}
