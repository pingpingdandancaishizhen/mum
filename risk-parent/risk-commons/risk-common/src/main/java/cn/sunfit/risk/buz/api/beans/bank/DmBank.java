package cn.sunfit.risk.buz.api.beans.bank;

import java.util.Date;

import orj.worf.core.model.BaseObject;

public class DmBank extends BaseObject {
	
    private static final long serialVersionUID = 1L;
    
    private String id;

    private String bankCode;

    private String bankName;

    private String bankShort;

    private String thirdType;

    private int effectTag;
    
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

	public int getEffectTag() {
		return effectTag;
	}

	public void setEffectTag(int effectTag) {
		this.effectTag = effectTag;
	}

	

    

    
}
