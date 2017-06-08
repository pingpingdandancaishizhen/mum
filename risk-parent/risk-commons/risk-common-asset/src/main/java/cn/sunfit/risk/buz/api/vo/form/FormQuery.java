package cn.sunfit.risk.buz.api.vo.form;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class FormQuery extends CorpReqBase {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String productId;
    @NotBlank
    private String bpDefId;
    @NotBlank
    private String bpDefKey;
    @NotBlank
    private String customerId;
    @NotBlank
    private String bpId;

    private String deptId;

    private boolean view = false;

    private String taskId;

    private String channel;

    public String getBpDefId() {
        return bpDefId;
    }

    public String getBpDefKey() {
        return bpDefKey;
    }

    public String getBpId() {
        return bpId;
    }

    public String getChannel() {
        return channel;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getProductId() {
        return productId;
    }

    public String getTaskId() {
        return taskId;
    }

    public boolean isView() {
        return view;
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

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setView(boolean view) {
        this.view = view;
    }

}
