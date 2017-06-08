package cn.sunfit.risk.buz.api.vo.contract;

import java.util.ArrayList;
import java.util.List;

import orj.worf.core.model.BaseObject;

public class TempPartnerRelDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1722118817814634683L;

    private String domain;

    private String tempId;

    private List<TempPartnerRel> tempRels;

    public void addTempRels(TempPartnerRel rel) {
        if (this.tempRels == null) {
            this.tempRels = new ArrayList<TempPartnerRel>();
        }
        tempRels.add(rel);
    }

    public String getDomain() {
        return domain;
    }

    public String getTempId() {
        return tempId;
    }

    public List<TempPartnerRel> getTempRels() {
        return tempRels;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public void setTempRels(List<TempPartnerRel> tempRels) {
        this.tempRels = tempRels;
    }

}
