package cn.sunfit.risk.buz.api.vo.api.jfjd;

import orj.worf.core.model.BaseObject;

public class JFBpStatusGetReq extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -6615080533116086286L;

    private String bpId;

    private String domain;

    public JFBpStatusGetReq() {

    }

    public JFBpStatusGetReq(String bpId, String domain) {
        this.bpId = bpId;
        this.domain = domain;
    }

    public String getBpId() {
        return bpId;
    }

    public String getDomain() {
        return domain;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
