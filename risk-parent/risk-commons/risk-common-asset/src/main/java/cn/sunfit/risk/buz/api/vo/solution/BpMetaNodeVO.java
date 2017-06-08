package cn.sunfit.risk.buz.api.vo.solution;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;

public class BpMetaNodeVO extends BPMetaNode {

    private static final long serialVersionUID = 1L;

    private String bpName;

    private String formName;

    private String queryFormName;

    public String getBpName() {
        return bpName;
    }

    public String getFormName() {
        return formName;
    }

    public String getQueryFormName() {
        return queryFormName;
    }

    public void setBpName(String bpName) {
        this.bpName = bpName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public void setQueryFormName(String queryFormName) {
        this.queryFormName = queryFormName;
    }

}
