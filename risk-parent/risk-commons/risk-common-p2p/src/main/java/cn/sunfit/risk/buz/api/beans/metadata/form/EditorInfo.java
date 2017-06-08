/*******************************************************************************
 * @Title: EditorInfo.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.form;

import java.util.List;
import java.util.Map;

/**   
 * @Title: EditorInfo.java
 * @Description: Editor的信息
 * @author zouxuejun
 * @date 2016年12月28日 上午10:30:12
 * @version V1.0   
 */
public class EditorInfo extends ComponentInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 8374057631788124173L;

    private String editor;

    private int rows;

    private int cols;

    private boolean readonly;

    private String dataSource;

    private String binding;

    private String category;

    private Map<String, String> visible;
    // 单位
    private String unit;

    private boolean required;

    private Map<String, List<EditorInfo>> extEditors;
    private Map<String, List<GroupInfo>> extGroups;

    private String param;

    public String getBinding() {
        return binding;
    }

    public String getCategory() {
        return category;
    }

    public int getCols() {
        return cols;
    }

    public String getDataSource() {
        return dataSource;
    }

    public String getEditor() {
        return editor;
    }

    public Map<String, List<EditorInfo>> getExtEditors() {
        return extEditors;
    }

    public Map<String, List<GroupInfo>> getExtGroups() {
        return extGroups;
    }

    public String getParam() {
        return param;
    }

    public boolean getRequired() {
        return required;
    }

    public int getRows() {
        return rows;
    }

    public String getUnit() {
        return unit;
    }

    public Map<String, String> getVisible() {
        return visible;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setExtEditors(Map<String, List<EditorInfo>> extEditors) {
        this.extEditors = extEditors;
    }

    public void setExtGroups(Map<String, List<GroupInfo>> extGroups) {
        this.extGroups = extGroups;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setVisible(Map<String, String> visible) {
        this.visible = visible;
    }

}
