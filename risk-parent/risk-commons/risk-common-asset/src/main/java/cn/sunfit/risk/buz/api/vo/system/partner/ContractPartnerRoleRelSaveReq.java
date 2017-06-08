package cn.sunfit.risk.buz.api.vo.system.partner;

import java.util.List;

public class ContractPartnerRoleRelSaveReq {

    private String domain;

    private String partnerId;

    private List<String> roleIds;

    public ContractPartnerRoleRelSaveReq() {

    }

    public ContractPartnerRoleRelSaveReq(String partnerId, List<String> roleIds, String domain) {
        this.partnerId = partnerId;
        this.roleIds = roleIds;
        this.domain = domain;
    }

    public String getDomain() {
        return domain;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

}
