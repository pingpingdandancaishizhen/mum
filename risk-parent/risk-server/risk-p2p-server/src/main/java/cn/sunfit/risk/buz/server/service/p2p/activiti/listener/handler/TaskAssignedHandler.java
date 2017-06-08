package cn.sunfit.risk.buz.server.service.p2p.activiti.listener.handler;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.server.service.p2p.activiti.listener.EventHandler;

@Component("taskAssignedHandler")
public class TaskAssignedHandler implements EventHandler {
    private static Logger logger = LoggerFactory.getLogger(TaskAssignedHandler.class);

    @Override
    public void handler(ActivitiEvent event) {
        logger.info("事件进入了TaskAssignedHandler");
    }

}
