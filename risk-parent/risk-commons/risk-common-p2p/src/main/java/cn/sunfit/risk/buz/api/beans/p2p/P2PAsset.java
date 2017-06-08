package cn.sunfit.risk.buz.api.beans.p2p;

import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.corp.AssetAddReq;

public class P2PAsset extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String assetType;

    private Date createTime;

    private Date lastmodTime;

    private String corpName;

    private String corpAbbreviation;

    private String institutionCode;

    private String corpContact;

    private String corpContactTel;

    private String email;

    private String fax;

    private String corpAddress;

    private String addressDetail;

    private String acceptAccountName;

    private String acceptAccountNum;

    private String acceptAccountBank;

    private String branchBank;

    private String createMan;

    private Short status;

    private String domain;

    private String repaymentName;

    private String repaymentNum;

    private String repaymentBank;

    private String repaymentBranchBank;

    public void convert(AssetAddReq req) {
        this.setId(IdUtil.geneId());
        this.setAcceptAccountBank(req.getAcceptAccountBank());
        this.setAcceptAccountName(req.getAcceptAccountName());
        this.setAcceptAccountNum(req.getAcceptAccountNum());
        this.setAddressDetail(req.getRegistAddrDetail());
        this.setAssetType(req.getAssetType());
        this.setBranchBank(req.getBranchBank());
        this.setCorpAbbreviation(req.getCorpAbbreviation());
        this.setCorpAddress(req.getRegistAddr());
        this.setCorpContact(req.getCorpContact());
        this.setCorpContactTel(req.getCorpContactTel());
        this.setCorpName(req.getCorpName());
        this.setCreateTime(new Date());
        this.setEmail(req.getEmail());
        this.setFax(req.getFax());
        this.setInstitutionCode(req.getInstitutionCode());
        this.setLastmodTime(new Date());
        this.setRepaymentName(req.getRepaymentName());
        this.setRepaymentNum(req.getRepaymentNum());
        this.setRepaymentBank(req.getRepaymentBank());
        this.setRepaymentBranchBank(req.getRepaymentBranchBank());
    }

    public String getAcceptAccountBank() {
        return acceptAccountBank;
    }

    public String getAcceptAccountName() {
        return acceptAccountName;
    }

    public String getAcceptAccountNum() {
        return acceptAccountNum;
    }

    public String getAddressDetail() {
        return addressDetail;
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

    public String getCorpAddress() {
        return corpAddress;
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

    public String getCreateMan() {
        return createMan;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getDomain() {
        return domain;
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

    public Short getStatus() {
        return status;
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

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
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

    public void setCorpAddress(String corpAddress) {
        this.corpAddress = corpAddress;
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

    public void setCreateMan(String createMan) {
        this.createMan = createMan;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDomain(String domain) {
        this.domain = domain;
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

    public void setStatus(Short status) {
        this.status = status;
    }

}