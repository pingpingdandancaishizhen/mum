package cn.sunfit.risk.buz.server.util.api.jfjd.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import cn.sunfit.risk.buz.server.util.api.jfjd.event.ProductStatusChangeEvent;

@Component
public class ProductStatusListener implements ApplicationListener<ProductStatusChangeEvent> {

    @Override
    public void onApplicationEvent(ProductStatusChangeEvent event) {

        System.out.println("CORPID:" + event.getProductId() + "  STATUS:" + event.getStatus());
    }

}
