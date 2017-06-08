package cn.sunfit.risk.buz.api.vo.contract;

import java.rmi.ServerException;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.beans.contract.ContractTemplateAddDTO;
import cn.sunfit.risk.buz.api.vo.ReqBase;

public class ConTempSaveReq extends ReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = 2043583723521768544L;

    private String domain;

    private String id;

    @NotBlank(message = "合同名称不能为空")
    private String templateName;

    @NotBlank(message = "产品不能为空")
    private String product;

    @NotBlank(message = "模板不能为空")
    private String fileResource;

    private String templateDesc;

    @NotBlank(message = "文件名不能为空")
    private String fileName;

    private Integer status;

    private String mainFlag;

    @NotNull(message = "请至少选择一个参与方")
    private List<String> partnerIds;

    public ContractTemplateAddDTO copyToDTO() {
        ContractTemplateAddDTO ct = new ContractTemplateAddDTO();
        ct.setDomain(this.domain);
        ct.setId(this.id);
        ct.setTemplateName(this.templateName);
        ct.setFileResource(this.fileResource);
        ct.setProduct(this.product);
        ct.setFileName(this.fileName);
        ct.setTemplateDesc(this.templateDesc);
        ct.setStatus(this.status);
        if (StringUtils.isBlank(this.mainFlag)) {
            this.mainFlag = "0";
        }
        ct.setMainFlag(this.mainFlag);
        return ct;
    }

    public TempPartnerRelDTO copyToRelDTO() throws ServerException {
        TempPartnerRelDTO dto = new TempPartnerRelDTO();
        dto.setDomain(domain);
        dto.setTempId(id);
        if (partnerIds != null && partnerIds.size() > 0) {
            for (String ids : partnerIds) {
                String idd[] = ids.split("_");
                if (idd.length < 2) {
                    throw new ServerException("参数错误");
                }
                dto.addTempRels(new TempPartnerRel(id, idd[1], idd[0]));
            }
        }
        return dto;
    }

    public String getDomain() {
        return domain;
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

    public String getMainFlag() {
        return mainFlag;
    }

    public List<String> getPartnerIds() {
        return partnerIds;
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

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileResource(String fileResource) {
        this.fileResource = fileResource;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMainFlag(String mainFlag) {
        this.mainFlag = mainFlag;
    }

    public void setPartnerIds(List<String> partnerIds) {
        this.partnerIds = partnerIds;
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

}
