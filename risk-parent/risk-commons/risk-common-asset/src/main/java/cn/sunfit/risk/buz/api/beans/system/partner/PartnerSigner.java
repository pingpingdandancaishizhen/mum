package cn.sunfit.risk.buz.api.beans.system.partner;

import orj.worf.core.model.BaseObject;

public class PartnerSigner extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 141537392123380152L;

    private String id;

    private String corpId;

    private String name;

    private String code;

    private String coopDept;

    private String phone;

    private String address;

    private String addrDetail;

    private String email;

    private String fax;

    private Integer del_flag;

    private String type;

    private String sealName;

    private String sealResource;

    private String signName;

    private String signResource;

    private String roleId;

    private String roleName;

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

    public String getCorpId() {
        return corpId;
    }

    public Integer getDel_flag() {
        return del_flag;
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

    public String getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
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

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
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

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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