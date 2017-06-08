package cn.sunfit.risk.buz.server.service.product.contract;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.util.ContractField;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.product.contract.ProductContractService;
import cn.sunfit.risk.buz.api.vo.product.ProductContractField;
import cn.sunfit.risk.buz.api.vo.product.ProductContractFields;
import cn.sunfit.risk.buz.api.vo.product.ProductContractReq;

@Service("risk.productContractService")
public class ProductContractServiceImpl implements ProductContractService {

    // 注入时 请把default放在最后
    // @Autowired
    private List<ProductContractHandler> handlers;

    private List<ProductContractFields> field2fields(List<ProductContractField> filed) {
        Map<String, ProductContractFields> fields = new LinkedHashMap<String, ProductContractFields>();
        for (ProductContractField f : filed) {
            ProductContractFields pf = fields.get(f.getCategory());
            if (pf == null) {
                pf = new ProductContractFields();
                pf.setCategory(f.getCategory());
                fields.put(f.getCategory(), pf);
            }
            // pf = fields.get(f);
            pf.addField(f.getKey(), f.getName(), f.getCategory());
        }
        return new ArrayList<ProductContractFields>(fields.values());
    }

    @Override
    public List<ProductContractFields> getContractFields(String productId) throws ServiceException {
        ProductContractHandler handler = null;
        for (ProductContractHandler h : handlers) {
            if (h.filter(productId)) {
                handler = h;
                break;
            }
        }
        if (handler != null) {
            List<ProductContractField> fileds = handler.getContractFields();
            return field2fields(fileds);
        } else {
            throw new ServiceException("没有合适的产品合同管理类");
        }
    }

    @Override
    public Map<String, ContractField> getContractFieldsValue(ProductContractReq req) throws ServiceException {
        ProductContractHandler handler = null;
        for (ProductContractHandler h : handlers) {
            if (h.filter(req.getProductId())) {
                handler = h;
                break;
            }
        }
        if (handler != null) {
            Map<String, ContractField> valueMap = handler.getValue(req);
            return valueMap;
        } else {
            throw new ServiceException("没有合适的产品合同管理类");
        }
    }

    public List<ProductContractHandler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<ProductContractHandler> handlers) {
        this.handlers = handlers;
    }

}
