/*******************************************************************************
 * @Title: BPMetaOperation.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class BPMetaOperation extends BaseObject {
    private static final long serialVersionUID = 1L;

    public static BPMetaOperation OPERATION_NEW = new BPMetaOperation();

    public static BPMetaOperation OPERATION_VIEW = new BPMetaOperation();

    private String operationId;

    private String corpId;

    private String bpDefId;

    private String operKey;

    private int operType;// 操作类型 回退=-1，通过=1，拒绝=2，保存=0，其他=3

    private String operName;

    private String operDesc;

    private String binding;

    private String isBasic;

    private String nodeKey;

    private String preCondition;

    private String postCondition;

    private Date updateTime;

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId == null ? null : bpDefId.trim();
    }

    public String getOperKey() {
        return operKey;
    }

    public void setOperKey(String operKey) {
        this.operKey = operKey == null ? null : operKey.trim();
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName == null ? null : operName.trim();
    }

    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc == null ? null : operDesc.trim();
    }

    public int getOperType() {
        return operType;
    }

    public void setOperType(int operType) {
        this.operType = operType;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding == null ? null : binding.trim();
    }

    public String getIsBasic() {
        return isBasic;
    }

    public void setIsBasic(String isBasic) {
        this.isBasic = isBasic == null ? null : isBasic.trim();
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public String getPreCondition() {
        return preCondition;
    }

    public void setPreCondition(String preCondition) {
        this.preCondition = preCondition == null ? null : preCondition.trim();
    }

    public String getPostCondition() {
        return postCondition;
    }

    public void setPostCondition(String postCondition) {
        this.postCondition = postCondition == null ? null : postCondition.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}