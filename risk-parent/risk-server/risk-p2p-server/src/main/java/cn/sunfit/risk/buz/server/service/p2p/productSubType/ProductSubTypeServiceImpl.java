package cn.sunfit.risk.buz.server.service.p2p.productSubType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.p2p.ProductSubType;
import cn.sunfit.risk.buz.api.service.p2p.productSubType.ProductSubTypeService;
import cn.sunfit.risk.buz.server.dao.p2p.productSubType.ProductSubTypeDAO;

@Service("risk.p2pProductSubTypeService")
public class ProductSubTypeServiceImpl implements ProductSubTypeService {

    @Autowired
    private ProductSubTypeDAO productSubTypeDAO;

    @Override
    public ProductSubType getByName(String domain, String productCode, String subTypeName) {
        return productSubTypeDAO.getByName(domain, productCode, subTypeName);
    }

    @Override
    public List<ProductSubType> selectByProductCode(String productCode, String domain) {
        return productSubTypeDAO.selectByProductCode(productCode, domain);
    }

    @Override
    public List<ProductSubType> selectByTypeId(String typeId) {
        return productSubTypeDAO.selectByTypeId(typeId);
    }

}
