package cn.sunfit.risk.buz.api.service.contract;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.contract.ContractLoadReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractResource;
import cn.sunfit.risk.buz.api.beans.contract.ContractResourceSaveReq;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.contract.ContractGenerateReq;

/**
 * 
 * @Title: ContractResourceService.java
 * @Package cn.sunfit.risk.buz.api.service.contract
 * @Description: TODO
 * @author RJS
 * @date 2017年2月25日 下午5:49:03
 * @version V1.0
 */
public interface ContractResourceService {

    public Resp generate(ContractGenerateReq req) throws ServiceException;

    ContractResource getByBpId(ContractLoadReq req);

    public List<ContractResource> queryByBpId(String bpId, String domain);

    public void saveContractResource(ContractResourceSaveReq req);
}
