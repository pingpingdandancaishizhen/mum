package cn.sunfit.risk.buz.api.beans.metadata;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class BPMetaNodeUserRel extends CorpReqBase {
    private static final long serialVersionUID = 1L;

    private String id;

    private String userId;

    private String nodeId;

    private String bpDefId;

    private String createUserId;

    public String getBpDefId() {
        return bpDefId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getId() {
        return id;
    }

    public String getNodeId() {
        return nodeId;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId == null ? null : bpDefId.trim();
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}