package cn.sunfit.risk.buz.api.beans.corp;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class CorpDept extends BaseObject {
    private static final long serialVersionUID = 1L;

    // public final static String ENABLE = "0";
    //
    // public final static String DISABLE = "1";
    //
    // public final static String DELETED = "2";

    private String id;

    private String corpId;

    private String deptCode;

    private String deptName;

    private String deptShortName;

    private Integer level;

    private Integer deptType;

    private String parentCode;

    private String deptHead;

    private String deptPhone;

    private String deptAddr;

    private String deptAddrDetail;

    private String status;

    private Date createTime;

    private String desc;

    private Date updateTime;

    public String getCorpId() {
        return corpId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public String getDeptAddrDetail() {
        return deptAddrDetail;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptPhone() {
        return deptPhone;
    }

    public String getDeptShortName() {
        return deptShortName;
    }

    public Integer getDeptType() {
        return deptType;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }

    public String getParentCode() {
        return parentCode;
    }

    public String getStatus() {
        return status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }

    public void setDeptAddrDetail(String deptAddrDetail) {
        this.deptAddrDetail = deptAddrDetail;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public void setDeptPhone(String deptPhone) {
        this.deptPhone = deptPhone;
    }

    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}