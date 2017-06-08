package cn.sunfit.risk.buz.api.beans.corp;

import java.util.Date;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.utils.IdUtil;

public class CustOperLog extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String id;

    private String uid;

    private String cid;

    private String operType;

    public static final String ADD_CUSTOMER = "0";
    public static final String MODIFY_CUSTOMER = "1";
    public static final String DETAIL_CUSTOMER = "2";
    public static final String DELETE_CUSTOMER = "3";
    public static final String ADD_BLACKLIST = "4";
    public static final String REMOVE_BLACKLIST = "5";

    private Date operTime;

    private String detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType == null ? null : operType.trim();
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public static CustOperLog createCustOperLog(String uid, String cid, String operType, String operDetail) {
        CustOperLog custOperLog = new CustOperLog();
        custOperLog.setId(IdUtil.geneId());
        custOperLog.setCid(cid);
        custOperLog.setUid(uid);
        custOperLog.setOperTime(new Date());
        custOperLog.setOperType(operType);
        custOperLog.setDetail(operDetail);
        return custOperLog;
    }
}