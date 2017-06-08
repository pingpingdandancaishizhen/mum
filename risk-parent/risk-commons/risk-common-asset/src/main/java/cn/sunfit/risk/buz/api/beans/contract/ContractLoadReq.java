package cn.sunfit.risk.buz.api.beans.contract;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class ContractLoadReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = -9124697918743049980L;

    private String bpId;

    private String contaractType;

    public String getBpId() {
        return bpId;
    }

    public String getContaractType() {
        return contaractType;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setContaractType(String contaractType) {
        this.contaractType = contaractType;
    }

}
