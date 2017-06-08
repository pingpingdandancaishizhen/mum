package cn.sunfit.risk.buz.api.vo.activiti;

import java.io.Serializable;

public class UploadBpmnReq implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String bpmnxml;

    private String userId;

    private String productId;

    private Integer version;

    private String loanType;

    public String getBpmnxml() {
        return bpmnxml;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setBpmnxml(String bpmnxml) {
        this.bpmnxml = bpmnxml;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
