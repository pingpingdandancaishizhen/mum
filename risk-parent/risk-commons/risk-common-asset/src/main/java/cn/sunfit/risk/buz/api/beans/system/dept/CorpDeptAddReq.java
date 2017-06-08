package cn.sunfit.risk.buz.api.beans.system.dept;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeDeptRel;

public class CorpDeptAddReq extends CorpDept {

    private static final long serialVersionUID = 1L;

    private List<BPMetaNodeDeptRel> node;

    public List<BPMetaNodeDeptRel> getNode() {
        return node;
    }

    public void setNode(List<BPMetaNodeDeptRel> node) {
        this.node = node;
    }

}
