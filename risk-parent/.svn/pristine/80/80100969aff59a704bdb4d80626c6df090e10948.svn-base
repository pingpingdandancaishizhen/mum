package cn.sunfit.risk.buz.api.vo.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductContractFields implements Serializable {

    private static final long serialVersionUID = 1L;

    private String category;

    private List<ProductContractField> fields = new ArrayList<ProductContractField>();

    public void addField(String key, String name, String category) {
        this.fields.add(new ProductContractField(key, name, category));
    }

    public String getCategory() {
        return category;
    }

    public List<ProductContractField> getFields() {
        return fields;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFields(List<ProductContractField> fields) {
        this.fields = fields;
    }

}
