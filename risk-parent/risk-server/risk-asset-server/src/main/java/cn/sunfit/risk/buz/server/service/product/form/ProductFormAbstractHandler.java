package cn.sunfit.risk.buz.server.service.product.form;

public abstract class ProductFormAbstractHandler implements ProductFormHandler {

    private String supportProduct;

    public String getSupportProduct() {
        return supportProduct;
    }

    public void setSupportProduct(String supportProduct) {
        this.supportProduct = supportProduct;
    }

}
