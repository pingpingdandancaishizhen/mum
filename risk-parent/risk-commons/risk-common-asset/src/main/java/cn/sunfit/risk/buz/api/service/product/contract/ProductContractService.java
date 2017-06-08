package cn.sunfit.risk.buz.api.service.product.contract;

import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.util.ContractField;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.product.ProductContractFields;
import cn.sunfit.risk.buz.api.vo.product.ProductContractReq;

public interface ProductContractService {

    /**
     * 
     * @Title: getContractFileds
     * @Description: 获取产品合同提供的所有分类字段
     * @param @param productId
     * @param @return   
     * @return List<ContractFields> 
     * @author XFL 2017年2月21日 
     * @throws
     */
    public List<ProductContractFields> getContractFields(String productId) throws ServiceException;

    /**
     * 
     * @Title: getContractFieldsValue
     * @Description: 根据产品获取字段值
     * @param @return   
     * @author XFL 2017年2月21日 
     * @throws
     */
    public Map<String, ContractField> getContractFieldsValue(ProductContractReq req) throws ServiceException;
}
