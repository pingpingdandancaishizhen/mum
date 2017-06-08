package cn.sunfit.risk.buz.server.service.product.form;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.exception.ServiceException;

@Service("productFormFactory")
public class ProductFormFactory {

    private List<ProductFormHandler> handlers;

    public ProductFormHandler getHandler(String productId) {
        ProductFormHandler handler = null;
        for (ProductFormHandler h : handlers) {
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

    public List<ProductFormHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<ProductFormHandler> handlers) {
        this.handlers = handlers;
    }

}
