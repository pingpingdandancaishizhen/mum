package cn.sunfit.risk.buz.api.vo.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.corp.CorpDept;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNodeDeptRel;

public class CorpDeptModifyReq extends CorpDept {

    private static final long serialVersionUID = 1L;

    private String domain;

    private String userId;

    private List<BPMetaNodeDeptRel> node;

    public String getDomain() {
        return domain;
    }

    public List<BPMetaNodeDeptRel> getNode() {
        return node;
    }

    public String getUserId() {
        return userId;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setNode(List<BPMetaNodeDeptRel> node) {
        this.node = node;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
