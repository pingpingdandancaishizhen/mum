package cn.sunfit.risk.buz.server.service.p2p.activiti.task;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.constants.order.OrderStatus;
import cn.sunfit.risk.buz.server.dao.corp.CorpDAO;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;
import cn.sunfit.risk.buz.server.service.p2p.activiti.BPUtils;

/**
 * @Title: P2pPushTask.java
 * @Package cn.sunfit.risk.buz.server.service.p2p.activiti.task
 * @Description: 流程中调用的发标类
 * @author DELL
 * @date 2017年5月12日 下午2:20:33
 * @version V1.0
 */
@Service("p2pPushTask")
public class P2pPushTask implements JavaDelegate {
    @Autowired
    private LoanInfoDAO loanInfoDAO;
    @Autowired
    private CorpDAO corpDAO;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("我进来了。。。想发标,滾");
        String businessKey = execution.getProcessBusinessKey();
        String corpId = BPUtils.parseCorpIdFromBuzKey(businessKey);
        String bpId = BPUtils.parseIdFromBuzKey(businessKey);
        String domain = corpDAO.selectByPrimaryKey(corpId).getDomain();
        loanInfoDAO.updateStatus(domain, bpId, OrderStatus.DFB.getStatus());
        // throw new BpmnError("P2PPUSHERROR");
    }

}
