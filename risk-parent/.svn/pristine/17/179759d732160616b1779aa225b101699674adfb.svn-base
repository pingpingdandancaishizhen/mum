package cn.sunfit.risk.buz.api.vo.solution;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

/**
 * 
 * @Title: BpMetaNodeAssignAddReq.java
 * @Package cn.sunfit.risk.buz.api.vo.solution
 * @Description: 删除节点分配规则的请求参数
 * @author XFL
 * @date 2017年1月3日 下午4:24:23
 * @version V1.0
 */
public class BpMetaNodeAssignDeleteReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String bpDefId;
    @NotBlank
    private String nodeId;
    @NotBlank
    private String assignId;

    public String getAssignId() {
        return assignId;
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setAssignId(String assignId) {
        this.assignId = assignId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

}
