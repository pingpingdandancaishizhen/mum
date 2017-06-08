package cn.sunfit.risk.buz.api.vo.p2p.activiti;

import org.hibernate.validator.constraints.NotBlank;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

public class FormQuery extends CorpReqBase {

    private static final long serialVersionUID = 1L;
    @NotBlank
    private String productId;// 资产方PRODUCT_CODE
    private String bpDefId;
    private String bpDefKey;
    @NotBlank
    private String bpId;

    private String deptId;

    private boolean view = false;

    private String taskId;

    private String channel;
    // 模式，查看 编辑 处理 等
    private String model;

    private String productType;
    private String loanInfoId;

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

    public String getDeptId() {
        return deptId;
    }

    public String getLoanInfoId() {
        return loanInfoId;
    }

    public String getModel() {
        return model;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductType() {
        return productType;
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

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public void setLoanInfoId(String loanInfoId) {
        this.loanInfoId = loanInfoId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setView(boolean view) {
        this.view = view;
    }

}
