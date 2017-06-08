package cn.sunfit.risk.buz.api.beans.contract;

import java.util.Date;
import java.util.List;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.vo.system.partner.PartnerSelectVO;

public class ContractTemplate extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String corpId;

    private String product;

    private String templateName;

    private String templateDesc;

    private Integer status;

    private String fileResource;

    private String fileName;

    private Date createTime;

    private Date updateTime;

    private Date invalidTime;

    private List<PartnerSelectVO> partnerList;

    private String partnerNames;

    private String mainFlag;

    public String getCorpId() {
        return corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileResource() {
        return fileResource;
    }

    public String getId() {
        return id;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public String getMainFlag() {
        return mainFlag;
    }

    public List<PartnerSelectVO> getPartnerList() {
        return partnerList;
    }

    public String getPartnerNames() {
        return partnerNames;
    }

    public String getProduct() {
        return product;
    }

    public Integer getStatus() {
        return status;
    }

    public String getTemplateDesc() {
        return templateDesc;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public void setFileResource(String fileResource) {
        this.fileResource = fileResource;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    public void setPartnerList(List<PartnerSelectVO> partnerList) {
        this.partnerList = partnerList;
    }

    public void setPartnerNames(String partnerNames) {
        this.partnerNames = partnerNames;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setTemplateDesc(String templateDesc) {
        this.templateDesc = templateDesc;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}