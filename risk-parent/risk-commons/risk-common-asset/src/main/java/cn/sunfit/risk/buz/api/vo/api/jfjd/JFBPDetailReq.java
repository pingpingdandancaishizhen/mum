package cn.sunfit.risk.buz.api.vo.api.jfjd;

import orj.worf.core.model.BaseObject;

public class JFBPDetailReq extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 3089412533678690689L;

    private String bpId;

    private String corpId;

    public String getBpId() {
        return bpId;
    }

    public String getCorpId() {
        return corpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

}
