package cn.sunfit.risk.buz.api.vo.system.partner;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.beans.system.partner.ContractPartnerAddDTO;
import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class ContractPartnerSaveReq extends CorpReqBase {

    /**
     * 
     */
    private static final long serialVersionUID = 2043583723221768544L;

    // <<<<<<<<<<<<<<<基本信息>>>>>>>>>>>>>>>
    private String id;

    /**
     *  合作方名称
     */
    @NotBlank(message = "合作方名称不能为空")
    private String name;

    /**
     * 机构代码
     */
    @NotBlank(message = "机构代码/身份证号码不能为空")
    private String code;

    /**
     * 合作机构
     */
    private String coopDept;

    /**
     * 联系电话
     */
    @NotBlank(message = "联系电话不能为空")
    private String phone;

    /**
     * 传真号
     */
    private String fax;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 通讯地址
     */
    @NotBlank(message = "通讯地址不能为空")
    private String address;

    /**
     * 详细地址
     */
    private String addrDetail;

    /**
     * 合作方类型
     */
    @NotNull(message = "请至少选择一个合作方类型")
    private List<String> roleIds;

    /**
     * 合同签章人类型
     */
    @NotNull(message = "请至少选择一个合同签章人类型")
    private String type;

    /**
     * 企业/法人合同公章资源ID
     */
    private String sealResource;

    /**
     * 企业/法人合同公章文件名
     */
    private String sealName;

    /**
     * 企业/法人签名资源ID
     */
    private String signResource;

    /**
     * 企业/法人签名文件名
     */
    private String signName;

    public ContractPartnerAddDTO copyToBaseDTO() {
        ContractPartnerAddDTO contractSignerDTO = new ContractPartnerAddDTO();
        contractSignerDTO.setDomain(getDomain());
        contractSignerDTO.setId(this.id);
        contractSignerDTO.setName(this.name);
        contractSignerDTO.setCode(this.code);
        contractSignerDTO.setPhone(this.phone);
        contractSignerDTO.setAddress(this.address);
        contractSignerDTO.setAddrDetail(this.addrDetail);
        contractSignerDTO.setEmail(this.email);
        contractSignerDTO.setFax(this.fax);
        contractSignerDTO.setType(this.type);
        contractSignerDTO.setSealName(this.sealName);
        contractSignerDTO.setSealResource(this.sealResource);
        contractSignerDTO.setSignName(this.signName);
        contractSignerDTO.setSignResource(this.signResource);
        contractSignerDTO.setCreator(getUserId());
        contractSignerDTO.setCorpId(getCorpId());
        contractSignerDTO.setCoopDept(coopDept);
        return contractSignerDTO;
    }

    public String getAddrDetail() {
        return addrDetail;
    }

    public String getAddress() {
        return address;
    }

    public String getCode() {
        return code;
    }

    public String getCoopDept() {
        return coopDept;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public String getSealName() {
        return sealName;
    }

    public String getSealResource() {
        return sealResource;
    }

    public String getSignName() {
        return signName;
    }

    public String getSignResource() {
        return signResource;
    }

    public String getType() {
        return type;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCoopDept(String coopDept) {
        this.coopDept = coopDept;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }

    public void setSealName(String sealName) {
        this.sealName = sealName;
    }

    public void setSealResource(String sealResource) {
        this.sealResource = sealResource;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public void setSignResource(String signResource) {
        this.signResource = signResource;
    }

    public void setType(String type) {
        this.type = type;
    }

}
