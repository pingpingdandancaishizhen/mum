/*******************************************************************************
 * @Title: BPAttr.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.p2p.activiti;

import java.util.Date;

import orj.worf.core.model.BaseObject;

/**
 * @Title: BPAttr.java
 * @Description: BP Attribute
 * @author zouxuejun
 * @date 2016年12月8日 下午5:10:28
 * @version V1.0
 */
public class BPAttr extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String attrId;

    private String corpId;

    private String bpId;

    private String attrName;

    private String attrValue;

    private String draftValue;

    private Date updateTime;

    private String domain;

    public BPAttr() {

    }

    public BPAttr(String corpId, String bpId, String attrName) {
        this.corpId = corpId;
        this.bpId = bpId;
        this.attrName = attrName;

        this.updateTime = new Date(System.currentTimeMillis());
    }

    public BPAttr(String attrId, String corpId, String bpId, String attrName, String attrValue, String draftValue,
            Date updateTime, String domain) {
        super();
        this.attrId = attrId;
        this.corpId = corpId;
        this.bpId = bpId;
        this.attrName = attrName;
        this.attrValue = attrValue;
        this.draftValue = draftValue;
        this.updateTime = updateTime;
        this.domain = domain;
    }

    public String getAttrId() {
        return attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public String getBpId() {
        return bpId;
    }

    public String getCorpId() {
        return corpId;
    }

    public String getDomain() {
        return domain;
    }

    public String getDraftValue() {
        return draftValue;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? null : attrId.trim();
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    public void setBpId(String bpId) {
        this.bpId = bpId == null ? null : bpId.trim();
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setDraftValue(String draftValue) {
        this.draftValue = draftValue;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}