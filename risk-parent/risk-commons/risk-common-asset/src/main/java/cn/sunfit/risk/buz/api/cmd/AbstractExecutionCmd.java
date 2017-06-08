package cn.sunfit.risk.buz.api.cmd;

import java.util.Map;

public class AbstractExecutionCmd implements IExecutionCmd {
    private String productId;
    private String bpDefId;
    private String bpDefKey;
    private String customerId;
    private String bpId;
    private String cropId;
    private String domain;
    private String userId;
    private String userName;
    protected String destNodeKey;
    protected Map<String, String> formData;
    protected String actInstId;
    protected String nodeKey;
    protected String operaType;
    protected String option;

    public String getActInstId() {
        return actInstId;
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpDefKey() {
        return bpDefKey;
    }

    public String getBpId() {
        return bpId;
    }

    public String getCropId() {
        return cropId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDestNodeKey() {
        return destNodeKey;
    }

    public String getDomain() {
        return domain;
    }

    public Map<String, String> getFormData() {
        return formData;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public String getOperaType() {
        return operaType;
    }

    public String getOption() {
        return option;
    }

    public String getProductId() {
        return productId;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setActInstId(String actInstId) {
        this.actInstId = actInstId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId;
    }

    public void setBpDefKey(String bpDefKey) {
        this.bpDefKey = bpDefKey;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setCropId(String cropId) {
        this.cropId = cropId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDestNodeKey(String destNodeKey) {
        this.destNodeKey = destNodeKey;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setFormData(Map<String, String> formData) {
        this.formData = formData;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public void setOperaType(String operaType) {
        this.operaType = operaType;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
