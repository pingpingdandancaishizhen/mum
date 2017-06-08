package cn.sunfit.risk.credit.api.beans;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class JxlCredit extends BaseObject {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String idcard;

    private String phone;

    private Date queryTime;

    private byte[] result;

    public Integer getId() {
        return id;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public byte[] getResult() {
        return result;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public void setQueryTime(Date queryTime) {
        this.queryTime = queryTime;
    }

    public void setResult(byte[] result) {
        this.result = result;
    }
}