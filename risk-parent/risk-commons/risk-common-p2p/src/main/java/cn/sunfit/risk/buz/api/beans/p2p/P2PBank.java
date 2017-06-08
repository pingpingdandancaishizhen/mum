package cn.sunfit.risk.buz.api.beans.p2p;

import orj.worf.core.model.BaseObject;

public class P2PBank extends BaseObject{
    private String id;
    
    private String bankCode;
    
    private String bankName;
    
    private String bankShort;
    
    private String thirdType;
    
    private Integer effectTag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankShort() {
        return bankShort;
    }

    public void setBankShort(String bankShort) {
        this.bankShort = bankShort;
    }

    public String getThirdType() {
        return thirdType;
    }

    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }

    public Integer getEffectTag() {
        return effectTag;
    }

    public void setEffectTag(Integer effectTag) {
        this.effectTag = effectTag;
    }
    
}
