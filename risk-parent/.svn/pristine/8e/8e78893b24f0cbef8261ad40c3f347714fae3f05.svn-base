package cn.sunfit.risk.buz.server.util.api.jfjd.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.server.util.api.jfjd.event.CorpStatusChangeEvent;

@Component
public class CorpStatusListener implements ApplicationListener<CorpStatusChangeEvent> {

    @Override
    public void onApplicationEvent(CorpStatusChangeEvent event) {

        System.out.println("CORPID:" + event.getCorpId() + "  STATUS:" + event.getStatus());
    }

}
