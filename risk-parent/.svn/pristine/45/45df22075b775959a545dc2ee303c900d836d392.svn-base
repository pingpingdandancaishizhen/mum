package cn.sunfit.risk.buz.server.service.product.contract;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import cn.sunfit.risk.buz.api.beans.util.ContractField;
import cn.sunfit.risk.buz.api.vo.product.ProductContractField;
import cn.sunfit.risk.buz.api.vo.product.ProductContractReq;

public abstract class ProductContractHandler {

    protected List<ProductContractField> fields = new ArrayList<ProductContractField>();

    public abstract boolean filter(String productId);

    public List<ProductContractField> getContractFields() {
        return fields;
    }

    public abstract Map<String, ContractField> getValue(ProductContractReq req);

    @PostConstruct
    protected abstract void setContractFields();

}
