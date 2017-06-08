/*******************************************************************************
 * @Title: BPMetaForm.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.p2p.activiti;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.metadata.form.LayoutInfo;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;
import orj.worf.core.model.BaseObject;

public class BPMetaForm extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String formId;

    private String corpId;

    private String bpDefId;

    private String formKey;

    private String formName;

    private String formDesc;

    private String operations;

    private String layout;

    private String checkRules;

    private String isOutside;

    private String formHtml;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId == null ? null : formId.trim();
    }

    public String getCorpId() {
        return corpId;
    }

    public void setCorpId(String corpId) {
        this.corpId = corpId == null ? null : corpId.trim();
    }

    public String getBpDefId() {
        return bpDefId;
    }

    public void setBpDefId(String bpDefId) {
        this.bpDefId = bpDefId == null ? null : bpDefId.trim();
    }

    public String getFormKey() {
        return formKey;
    }

    public void setFormKey(String formKey) {
        this.formKey = formKey == null ? null : formKey.trim();
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName == null ? null : formName.trim();
    }

    public String getFormDesc() {
        return formDesc;
    }

    public void setFormDesc(String formDesc) {
        this.formDesc = formDesc == null ? null : formDesc.trim();
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations == null ? null : operations.trim();
    }

    public String getCheckRules() {
        return checkRules;
    }

    public void setCheckRules(String checkRules) {
        this.checkRules = checkRules;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }

    public String getIsOutside() {
        return isOutside;
    }

    public void setIsOutside(String isOutside) {
        this.isOutside = isOutside == null ? null : isOutside.trim();
    }

    public String getFormHtml() {
        return formHtml;
    }

    public void setFormHtml(String formHtml) {
        this.formHtml = formHtml == null ? null : formHtml.trim();
    }

    /* dto 字段 来自于 layout */
    private LayoutInfo layoutInfo;

    /* dto 字段 来自于 checkRules */
    private List<CheckRuleInfo> checkRuleList;

    public LayoutInfo getLayoutInfo() {
        return layoutInfo;
    }

    public void setLayoutInfo(LayoutInfo layoutInfo) {
        this.layoutInfo = layoutInfo;
    }

    public List<CheckRuleInfo> getCheckRuleList() {
        return checkRuleList;
    }

    public void setCheckRuleList(List<CheckRuleInfo> checkRuleList) {
        this.checkRuleList = checkRuleList;
    }
}