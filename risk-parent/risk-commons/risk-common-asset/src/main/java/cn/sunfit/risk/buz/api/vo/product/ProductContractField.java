package cn.sunfit.risk.buz.api.vo.product;

import java.io.Serializable;

public class ProductContractField implements Serializable {

    private static final long serialVersionUID = 1L;

    private String key;

    private String name;

    private String category;

    public ProductContractField() {

    }

    public ProductContractField(String key, String name, String category) {
        super();
        this.key = key;
        this.name = name;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

}
