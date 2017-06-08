package cn.sunfit.risk.buz.api.vo.solution;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 * @Title: ProductModifyReq.java
 * @Package cn.sunfit.risk.buz.api.vo.solution
 * @Description: 修改产品基本信息
 * @author XFL
 * @date 2016年12月29日 下午4:08:53
 * @version V1.0
 */
public class ProductModifyReq implements Serializable {

    private static final long serialVersionUID = 8355948445871981535L;

    @NotBlank
    private String id;

    @NotBlank
    @Size(max = 32)
    private String productName;

    @NotBlank
    @Size(max = 200)
    private String desc;

    @Size(max = 1000)
    private String requirements;

    private String corpId;

    public String getCorpId() {
        return corpId;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

}
