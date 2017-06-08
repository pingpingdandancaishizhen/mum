package cn.sunfit.risk.buz.server.service.p2p.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;

public interface EventHandler {

    void handler(ActivitiEvent event);
}
