package cn.sunfit.risk.buz.server.service.p2p.activiti.listener;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class GlobalEventListener implements ActivitiEventListener {

    private static Logger logger = LoggerFactory.getLogger(GlobalEventListener.class);

    private Map<String, String> hanlders = new HashMap<String, String>();

    @Autowired
    private ApplicationContext context;

    public Map<String, String> getHanlders() {
        return hanlders;
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }

    @Override
    public void onEvent(ActivitiEvent event) {
        String eventType = event.getType().name();
        logger.debug("envent type is ========>" + eventType);
        String handlername = hanlders.get(eventType);
        if (handlername != null) {
            EventHandler handler = context.getBean(handlername, EventHandler.class);
            if (handler != null) {
                handler.handler(event);
            }
        }

    }

    public void setHanlders(Map<String, String> hanlders) {
        this.hanlders = hanlders;
    }

}
