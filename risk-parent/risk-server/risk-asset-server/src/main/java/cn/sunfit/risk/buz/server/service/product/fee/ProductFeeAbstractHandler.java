package cn.sunfit.risk.buz.server.service.product.fee;

public abstract class ProductFeeAbstractHandler implements ProductFeeHandler {

    private String supportProduct;

    public String getSupportProduct() {
        return supportProduct;
    }

    public void setSupportProduct(String supportProduct) {
        this.supportProduct = supportProduct;
    }

}
