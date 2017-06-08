/*******************************************************************************
 * @Title: BP.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.p2p.activiti;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import orj.worf.core.model.BaseObject;

/**
 * 
 * @Title: BP.java
 * @Description: 业务流程对象
 * @author zouxuejun
 * @date 2016年12月8日 下午5:11:24
 * @version V1.0
 */
public class BP extends BaseObject {

    private static final long serialVersionUID = 1L;

    private String bpId;

    private String corpId;

    private String bpDefId;

    private String bpNo;

    private String productType;

    private Byte bpStatus;

    private String engineKey;

    private String currentTaskKey;

    private String currentTaskId;

    private String currentTaskName;

    // private Integer version;

    private String createUserId;

    private Date createTime;

    private Date updateTime;

    private String domain;

    private String channel;

    private String loanInfoId;

    private String preOperUserId;
    private Date preOperTime;

    public BP() {

    }

    public BP(String corpId, String bpId) {
        if (corpId == null || StringUtils.isBlank(corpId)) {
            throw new IllegalArgumentException("corpId can not be empty");
        }
        this.corpId = corpId;
        this.bpId = bpId;
    }

    @Override
    public BP clone() {
        try {
            return (BP) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpId() {
        return bpId;
    }

    public String getBpNo() {
        return bpNo;
    }

    public Byte getBpStatus() {
        return bpStatus;
    }

    public String getChannel() {
        return channel;
    }

    public String getCorpId() {
        return corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public String getCurrentTaskId() {
        return currentTaskId;
    }

    public String getCurrentTaskKey() {
        return currentTaskKey;
    }

    public String getCurrentTaskName() {
        return currentTaskName;
    }

    public String getDomain() {
        return domain;
    }

    public String getEngineKey() {
        return engineKey;
    }

    public String getLoanInfoId() {
        return loanInfoId;
    }

    public Date getPreOperTime() {
        return preOperTime;
    }

    public String getPreOperUserId() {
        return preOperUserId;
    }

    public String getProductType() {
        return productType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId == null ? null : bpDefId.trim();
    }

    public void setBpId(String bpId) {
        this.bpId = bpId == null ? null : bpId.trim();
    }

    public void setBpNo(String bpNo) {
        this.bpNo = bpNo == null ? null : bpNo.trim();
    }

    public void setBpStatus(Byte bpStatus) {
        this.bpStatus = bpStatus;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    public void setCurrentTaskId(String currentTaskId) {
        this.currentTaskId = currentTaskId;
    }

    public void setCurrentTaskKey(String currentTaskKey) {
        this.currentTaskKey = currentTaskKey == null ? null : currentTaskKey.trim();
    }

    public void setCurrentTaskName(String currentTaskName) {
        this.currentTaskName = currentTaskName;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setEngineKey(String engineKey) {
        this.engineKey = engineKey == null ? null : engineKey.trim();
    }

    public void setLoanInfoId(String loanInfoId) {
        this.loanInfoId = loanInfoId;
    }

    public void setPreOperTime(Date preOperTime) {
        this.preOperTime = preOperTime;
    }

    public void setPreOperUserId(String preOperUserId) {
        this.preOperUserId = preOperUserId;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}