package cn.sunfit.risk.buz.api.vo.system.partner;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class ContractPartnerQueryReq extends ReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = 2938737238414614458L;

    private String domain;

    private String name;

    private String code;

    private Integer type;

    public String getCode() {
        return code;
    }

    public String getDomain() {
        return domain;
    }

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
