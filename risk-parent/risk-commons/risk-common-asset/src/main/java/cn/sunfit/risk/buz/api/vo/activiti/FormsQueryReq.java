package cn.sunfit.risk.buz.api.vo.activiti;

import cn.sunfit.risk.buz.api.vo.ReqBase;

public class FormsQueryReq extends ReqBase {
    private static final long serialVersionUID = 1L;
    private String bpDefId;

    public String getBpDefId() {
        return bpDefId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

}
