package cn.sunfit.risk.buz.server.dao.contract;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.contract.ContractLoadReq;
import cn.sunfit.risk.buz.api.beans.contract.ContractResource;
import cn.sunfit.risk.buz.api.beans.contract.ContractResourceDTO;

@Repository
public interface ContractResourceDAO {

    int addContractResource(ContractResourceDTO contractResourceDTO);

    ContractResource getByBpId(ContractLoadReq req);

    List<ContractResource> queryByBpId(@Param("bpId") String bpId, @Param("domain") String domain);

    int removeContractResourceByBp(@Param("bpId") String bpId, @Param("domain") String domain);

    int signContract(@Param("bpId") String bpId, @Param("domain") String domain);

}