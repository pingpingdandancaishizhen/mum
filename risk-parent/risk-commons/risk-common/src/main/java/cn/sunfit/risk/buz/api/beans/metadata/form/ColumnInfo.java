/*******************************************************************************
 * @Title: ColumnInfo.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.form;

/**   
 * @Title: ColumnInfo.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2016年12月28日 上午10:48:18
 * @version V1.0   
 */
public class ColumnInfo extends ComponentInfo {

    private static final long serialVersionUID = 2860466038321607506L;

    private boolean showRowNo;

    public boolean isShowRowNo() {
        return showRowNo;
    }

    public void setShowRowNo(boolean showRowNo) {
        this.showRowNo = showRowNo;
    }

}
