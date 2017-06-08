/*******************************************************************************
 * @Title: TableGroupInfo.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.form;

import java.util.List;

/**   
 * @Title: TableGroupInfo.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2016年12月28日 上午10:47:26
 * @version V1.0   
 */
public class TableGroupInfo extends GroupInfo {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private List<ColumnInfo> cols;

    private List<EditorInfo> rows;

    public List<ColumnInfo> getCols() {
        return cols;
    }

    public void setCols(List<ColumnInfo> cols) {
        this.cols = cols;
    }

    public List<EditorInfo> getRows() {
        return rows;
    }

    public void setRows(List<EditorInfo> rows) {
        this.rows = rows;
    }

}
