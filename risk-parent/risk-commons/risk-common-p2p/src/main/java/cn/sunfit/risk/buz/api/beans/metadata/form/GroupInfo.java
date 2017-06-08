/*******************************************************************************
 * @Title: FormGroup.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.form;

import java.util.List;

import orj.worf.core.model.BaseObject;

/**   
 * @Title: GroupInfo.java
 * @Description: 布局信息
 * @author zouxuejun
 * @date 2016年12月28日 上午10:25:27
 * @version V1.0   
 */
public class GroupInfo extends BaseObject {

    /**
     * 
     */
    private static final long serialVersionUID = -5311756337741919234L;

    private String label;

    private String key;

    private String layout;

    private List<EditorInfo> editors;

    private List<ColumnInfo> cols;

    private List<EditorInfo> rows;

    public void setRows(List<EditorInfo> rows) {
        this.rows = rows;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public List<EditorInfo> getEditors() {
        return editors;
    }

    public void setEditors(List<EditorInfo> editors) {
        this.editors = editors;
    }

    public List<ColumnInfo> getCols() {
        return cols;
    }

    public void setCols(List<ColumnInfo> cols) {
        this.cols = cols;
    }

    public List<EditorInfo> getRows() {
        return rows;
    }
}
