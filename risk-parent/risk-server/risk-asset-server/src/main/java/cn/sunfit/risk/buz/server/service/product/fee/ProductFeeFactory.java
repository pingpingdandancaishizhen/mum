package cn.sunfit.risk.buz.server.service.product.fee;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.exception.ServiceException;

@Service("productFeeFactory")
public class ProductFeeFactory {

    private List<ProductFeeHandler> handlers;

    public ProductFeeHandler getHandler(String productId) {
        ProductFeeHandler handler = null;
        for (ProductFeeHandler h : handlers) {
            if (h.filter(productId)) {
                handler = h;
                break;
            }
        }
        if (handler != null) {
            return handler;
        } else {
            throw new ServiceException("没有合适的产品表单服务类");
        }
    }

    public List<ProductFeeHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<ProductFeeHandler> handlers) {
        this.handlers = handlers;
    }

}
