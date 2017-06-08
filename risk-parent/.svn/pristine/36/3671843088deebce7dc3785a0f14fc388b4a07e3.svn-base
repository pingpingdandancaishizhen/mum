package cn.sunfit.risk.buz.server.util;

import java.io.Serializable;
import java.util.List;

/**
 * 模板
 */
public class TemplateBase implements Serializable {

    private static final long serialVersionUID = 1L;

    // 是否使用的是本地模板
    private boolean localTemplate = true;

    // 是否重新加载模板, 如果模板在数据库中修改后，马上生效，则可设置此属性为true
    private boolean reloadTemplate;

    private String name;

    private List<String> params;

    public String getName() {
        return name;
    }

    public List<String> getParams() {
        return params;
    }

    public boolean isLocalTemplate() {
        return localTemplate;
    }

    public boolean isReloadTemplate() {
        return reloadTemplate;
    }

    public void setLocalTemplate(boolean localTemplate) {
        this.localTemplate = localTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public void setReloadTemplate(boolean reloadTemplate) {
        this.reloadTemplate = reloadTemplate;
    }

    @Override
    public String toString() {
        return "TemplateBase = [name=" + name + ", params=" + params + ", reloadTemplate=" + reloadTemplate
                + ", localTemplate=" + localTemplate + "]";
    }
}
