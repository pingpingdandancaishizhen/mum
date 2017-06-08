package cn.sunfit.risk.buz.server.util.api.jfjd.event;

import org.springframework.context.ApplicationEvent;

public class ProductStatusChangeEvent extends ApplicationEvent {

    /**
     * 
     */
    private static final long serialVersionUID = 822395607622287691L;

    private String productId;

    private String status;

    public ProductStatusChangeEvent(Object source, String productId, String status) {
        super(source);
        this.productId = productId;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public String getStatus() {
        return status;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
