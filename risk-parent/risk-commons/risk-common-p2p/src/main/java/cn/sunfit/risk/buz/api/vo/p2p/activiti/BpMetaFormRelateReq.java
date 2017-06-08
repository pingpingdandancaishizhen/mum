package cn.sunfit.risk.buz.api.vo.p2p.activiti;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class BpMetaFormRelateReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String formKey;
    @NotBlank
    private String nodeId;
    @NotBlank
    private String bpDefId;

    public String getBpDefId() {
        return bpDefId;
    }

    public String getFormKey() {
        return formKey;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

}
