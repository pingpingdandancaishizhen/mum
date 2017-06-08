package cn.sunfit.risk.buz.api.vo.corp;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class SameDeptUserQuery extends CorpReqBase {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String bpId;

    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

}
