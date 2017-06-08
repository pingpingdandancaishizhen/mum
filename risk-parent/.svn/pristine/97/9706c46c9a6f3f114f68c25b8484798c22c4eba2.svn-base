package cn.sunfit.risk.buz.api.vo.form;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.metadata.form.LayoutInfo;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;

public class FormData implements Serializable {

    private static final long serialVersionUID = 1L;

    private LayoutInfo layoutInfo;

    private Map<String, Attr> attrs;

    private Map<String, String> defaultHidden;

    private List<Opera> operations;

    private Map<String, List<CheckRuleInfo>> checkrules;

    public Map<String, Attr> getAttrs() {
        return attrs;
    }

    public Map<String, List<CheckRuleInfo>> getCheckrules() {
        return checkrules;
    }

    public Map<String, String> getDefaultHidden() {
        return defaultHidden;
    }

    public LayoutInfo getLayoutInfo() {
        return layoutInfo;
    }

    public List<Opera> getOperations() {
        return operations;
    }

    public void setAttrs(Map<String, Attr> attrs) {
        this.attrs = attrs;
    }

    public void setCheckrules(Map<String, List<CheckRuleInfo>> checkrules) {
        this.checkrules = checkrules;
    }

    public void setDefaultHidden(Map<String, String> defaultHidden) {
        this.defaultHidden = defaultHidden;
    }

    public void setLayoutInfo(LayoutInfo layoutInfo) {
        this.layoutInfo = layoutInfo;
    }

    public void setOperations(List<Opera> operations) {
        this.operations = operations;
    }

}
