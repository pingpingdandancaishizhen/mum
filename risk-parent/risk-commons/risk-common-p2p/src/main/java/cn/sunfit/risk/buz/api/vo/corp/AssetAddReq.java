package cn.sunfit.risk.buz.api.vo.corp;

import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import orj.worf.core.model.BaseObject;

public class AssetAddReq extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String assetType;

    private Date createTime;

    private Date lastmodTime;

    @NotBlank(message = "企业名称不能为空,请输入***")
    @Length(min = 1, max = 40, message = "企业名称为40个字以内")
    private String corpName;

    @NotBlank(message = "企业简称不能为空,请输入***")
    @Length(min = 1, max = 40, message = "企业简称为40个字以内")
    private String corpAbbreviation;

    private String institutionCode;

    private String corpContact;

    private String corpContactTel;

    @Email(message = "请使用正确的邮箱")
    private String email;

    private String fax;

    private String registAddr;

    private String registAddrDetail;

    private String acceptAccountName;

    private String acceptAccountNum;

    private String acceptAccountBank;

    @NotBlank(message = "收款银行支行不能为空,请输入***")
    private String branchBank;

    private String repaymentName;

    private String repaymentNum;

    private String repaymentBank;

    private String repaymentBranchBank;

    public String getAcceptAccountBank() {
        return acceptAccountBank;
    }

    public String getAcceptAccountName() {
        return acceptAccountName;
    }

    public String getAcceptAccountNum() {
        return acceptAccountNum;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getBranchBank() {
        return branchBank;
    }

    public String getCorpAbbreviation() {
        return corpAbbreviation;
    }

    public String getCorpContact() {
        return corpContact;
    }

    public String getCorpContactTel() {
        return corpContactTel;
    }

    public String getCorpName() {
        return corpName;
    }

    public Date getCreateTime() {
        return createTime;
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

    public String getInstitutionCode() {
        return institutionCode;
    }

    public Date getLastmodTime() {
        return lastmodTime;
    }

    public String getRegistAddr() {
        return registAddr;
    }

    public String getRegistAddrDetail() {
        return registAddrDetail;
    }

    public String getRepaymentBank() {
        return repaymentBank;
    }

    public String getRepaymentBranchBank() {
        return repaymentBranchBank;
    }

    public String getRepaymentName() {
        return repaymentName;
    }

    public String getRepaymentNum() {
        return repaymentNum;
    }

    public void setAcceptAccountBank(String acceptAccountBank) {
        this.acceptAccountBank = acceptAccountBank;
    }

    public void setAcceptAccountName(String acceptAccountName) {
        this.acceptAccountName = acceptAccountName;
    }

    public void setAcceptAccountNum(String acceptAccountNum) {
        this.acceptAccountNum = acceptAccountNum;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void setBranchBank(String branchBank) {
        this.branchBank = branchBank;
    }

    public void setCorpAbbreviation(String corpAbbreviation) {
        this.corpAbbreviation = corpAbbreviation;
    }

    public void setCorpContact(String corpContact) {
        this.corpContact = corpContact;
    }

    public void setCorpContactTel(String corpContactTel) {
        this.corpContactTel = corpContactTel;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

    public void setLastmodTime(Date lastmodTime) {
        this.lastmodTime = lastmodTime;
    }

    public void setRegistAddr(String registAddr) {
        this.registAddr = registAddr;
    }

    public void setRegistAddrDetail(String registAddrDetail) {
        this.registAddrDetail = registAddrDetail;
    }

    public void setRepaymentBank(String repaymentBank) {
        this.repaymentBank = repaymentBank;
    }

    public void setRepaymentBranchBank(String repaymentBranchBank) {
        this.repaymentBranchBank = repaymentBranchBank;
    }

    public void setRepaymentName(String repaymentName) {
        this.repaymentName = repaymentName;
    }

    public void setRepaymentNum(String repaymentNum) {
        this.repaymentNum = repaymentNum;
    }

}