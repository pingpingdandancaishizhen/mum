package cn.sunfit.risk.buz.api.vo.p2p.activiti;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

/**
 * 
 * @Title: BpMetaNodeAssignAddReq.java
 * @Package cn.sunfit.risk.buz.api.vo.solution
 * @Description: 添加节点分配规则的请求参数
 * @author XFL
 * @date 2017年1月3日 下午4:24:23
 * @version V1.0
 */
public class BpMetaNodeAssignAddReq extends CorpReqBase {

    private static final long serialVersionUID = 1L;

    @NotBlank
    private String bpDefId;
    @NotBlank
    private String nodeId;
    @NotBlank
    private String assignType;
    @NotBlank
    private String relateName;
    @NotBlank
    private String relateId;
    @NotBlank
    private String relateType;
    @Digits(integer = 8, fraction = 0)
    private Integer relateGroup;

    private String userId;

    public String getAssignType() {
        return assignType;
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public Integer getRelateGroup() {
        return relateGroup;
    }

    public String getRelateId() {
        return relateId;
    }

    public String getRelateName() {
        return relateName;
    }

    public String getRelateType() {
        return relateType;
    }

    public String getUserId() {
        return userId;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public void setRelateGroup(Integer relateGroup) {
        this.relateGroup = relateGroup;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }

    public void setRelateName(String relateName) {
        this.relateName = relateName;
    }

    public void setRelateType(String relateType) {
        this.relateType = relateType;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}
