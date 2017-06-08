/*******************************************************************************
 * @Title: ComponentInfo.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.form;

import orj.worf.core.model.BaseObject;

/**   
 * @Title: ComponentInfo.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2016年12月28日 上午10:52:21
 * @version V1.0   
 */
public class ComponentInfo extends BaseObject {

    private static final long serialVersionUID = 5465031833138862887L;

    private String key;

    private String label;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
