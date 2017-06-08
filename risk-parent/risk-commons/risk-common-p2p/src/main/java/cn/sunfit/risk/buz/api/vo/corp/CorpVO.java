package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

public class CorpVO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String simpleName;
    private String corpName;
    private String linkPhone;
    private String address;
    private String addressDetail;
    private String descc;
    private String logo;

    private String admin;

    public String getAddress() {
        return address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public String getAdmin() {
        return admin;
    }

    public String getCorpName() {
        return corpName;
    }

    public String getDescc() {
        return descc;
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public String getLogo() {
        return logo;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

}
