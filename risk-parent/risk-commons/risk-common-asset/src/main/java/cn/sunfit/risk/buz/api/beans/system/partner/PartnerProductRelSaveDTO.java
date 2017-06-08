package cn.sunfit.risk.buz.api.beans.system.partner;

import java.util.ArrayList;
import java.util.List;

import orj.worf.core.model.BaseObject;

public class PartnerProductRelSaveDTO extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = 5178763222812160330L;

    private String domain;

    private String productId;

    private List<PartnerProductRel> relList;

    public void addRelList(String partnerId, String productId, String roleId) {
        PartnerProductRel rel = new PartnerProductRel(partnerId, productId, roleId);
        if (this.relList == null) {
            this.relList = new ArrayList<PartnerProductRel>();
        }
        this.relList.add(rel);
    }

    public String getDomain() {
        return domain;
    }

    public String getProductId() {
        return productId;
    }

    public List<PartnerProductRel> getRelList() {
        return relList;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setRelList(List<PartnerProductRel> relList) {
        this.relList = relList;
    }
}
