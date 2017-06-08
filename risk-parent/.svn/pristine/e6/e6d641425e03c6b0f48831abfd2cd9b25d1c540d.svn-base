package cn.sunfit.risk.buz.api.vo.corp;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class CorpUpdateReq implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    @NotBlank
    @Size(max = 50, min = 0)
    private String simpleName;
    @NotBlank
    @Size(max = 100, min = 0)
    private String corpName;
    @Pattern(regexp = "((^0{0,1}1[0-9]{10}$)|^((\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})|(\\d{4}|\\d{3})(\\d{7,8})|(\\d{4}|\\d{3})-(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1})|(\\d{7,8})-(\\d{4}|\\d{3}|\\d{2}|\\d{1}))$)")
    private String linkPhone;
    @Size(max = 255, min = 0)
    private String address;
    @Size(max = 20, min = 0)
    private String addressDetail;
    @Size(max = 200, min = 0)
    private String descc;
    @URL
    private String logo;

    public String getAddress() {
        return address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public String getCorpName() {
        return corpName;
    }

    public String getDescc() {
        return descc;
    }

    public String getId() {
        return id;
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

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public void setDescc(String descc) {
        this.descc = descc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone;
        if (StringUtils.isBlank(this.linkPhone)) {
            this.linkPhone = null;
        }
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

}
