package cn.sunfit.risk.buz.api.beans.contract;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class ContractResourceSaveReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = 2471350859398442150L;

    private String bpId;

    private String tempId;

    private String contractType;

    private String contractNo;

    private String contractName;

    private String resourceId;

    public ContractResourceDTO copyToEntity() {
        ContractResourceDTO crDTO = new ContractResourceDTO();
        crDTO.setDomain(getDomain());
        crDTO.setBpId(this.bpId);
        crDTO.setTempId(this.tempId);
        crDTO.setContractType(this.contractType);
        crDTO.setResource(this.resourceId);
        crDTO.setCreator(getUserId());
        crDTO.setContractNo(this.contractNo);
        crDTO.setContractName(this.contractName);
        return crDTO;
    }

    public ContractResourceQueryReq copyToQueryReq() {
        ContractResourceQueryReq req = new ContractResourceQueryReq();
        req.setDomain(getDomain());
        req.setBpId(bpId);
        req.setTempId(tempId);
        return req;
    }

    public String getBpId() {
        return bpId;
    }

    public String getContractName() {
        return contractName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public String getContractType() {
        return contractType;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getTempId() {
        return tempId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

}
