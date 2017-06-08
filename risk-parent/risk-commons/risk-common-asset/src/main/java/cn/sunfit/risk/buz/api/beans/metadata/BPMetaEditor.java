/*******************************************************************************
 * @Title: BPMetaEditor.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata;

import java.io.Serializable;

/**   
 * @Title: BPMetaEditor.java
 * @Description: 编辑器元数据
 * @author zouxuejun
 * @date 2016年12月27日 下午5:32:32
 * @version V1.0   
 */
public class BPMetaEditor implements Serializable {

    private static final long serialVersionUID = -3821444349093629596L;

    private String editorType;

    private String name;

    private String dataType;

    private boolean customized;

    public String getEditorType() {
        return editorType;
    }

    public void setEditorType(String editorType) {
        this.editorType = editorType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isCustomized() {
        return customized;
    }

    public void setCustomized(boolean customized) {
        this.customized = customized;
    }

}
