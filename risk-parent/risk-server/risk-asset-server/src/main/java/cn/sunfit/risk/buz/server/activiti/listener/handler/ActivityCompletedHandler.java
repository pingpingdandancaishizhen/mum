package cn.sunfit.risk.buz.server.activiti.listener.handler;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.server.activiti.listener.EventHandler;

@Component("activityCompletedHandler")
public class ActivityCompletedHandler implements EventHandler {

    @Override
    public void handler(ActivitiEvent event) {
        // TODO Auto-generated method stub

    }

}
