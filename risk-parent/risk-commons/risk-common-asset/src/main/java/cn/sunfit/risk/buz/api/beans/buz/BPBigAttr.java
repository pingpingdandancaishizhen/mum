/*******************************************************************************
 * @Title: BPBigAttr.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.buz;

import java.util.Date;

/**
 * 
 * @Title: BPBigAttr.java
 * @Description: BP 大对象属性
 * @author zouxuejun
 * @date 2016年12月8日 下午5:12:04
 * @version V1.0
 */
public class BPBigAttr extends BPAttr {

    private static final long serialVersionUID = 1L;

    public BPBigAttr() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * <p>Title: </p>
     * <p>Description: </p>
     * @param corpId
     * @param bpId
     * @param attrName
     */
    public BPBigAttr(String corpId, String bpId, String attrName) {
        super(corpId, bpId, attrName);
    }

    public BPBigAttr(String attrId, String corpId, String bpId, String attrName, String attrValue, String draftValue,
            Date updateTime, String domain) {
        super(attrId, corpId, bpId, attrName, attrValue, draftValue, updateTime, domain);
        // TODO Auto-generated constructor stub
    }

}