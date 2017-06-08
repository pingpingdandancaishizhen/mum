/*******************************************************************************
 * @Title: BPDTO.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.buz;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**   
 * @Title: BPDTO.java
 * @Description: 完整的BP信息
 * @author zouxuejun
 * @date 2016年12月8日 下午6:00:54
 * @version V1.0   
 */
public class BPDTO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5692052316299755626L;

    private BP bp;

    private List<BPAttr> attrs;

    private BPLoan bpLoan;

    public BPDTO() {

    }

    public BPDTO(BP bp, List<BPAttr> attrs, BPLoan bpLoan) {
        this.bp = bp;
        this.attrs = attrs;
        this.bpLoan = bpLoan;
    }

    public BP getBp() {
        return bp;
    }

    public void setBp(BP bp) {
        this.bp = bp;
    }

    public List<BPAttr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<BPAttr> attrs) {
        this.attrs = attrs;
    }

    public String getAttrValue(String attrName) {
        for (BPAttr attr : attrs) {
            if (StringUtils.equals(attr.getAttrName(), attrName)) {
                return attr.getAttrValue();
            }
        }
        return null;
    }

    public void setAttrValue(String attrName, String value) {
        for (BPAttr attr : attrs) {
            if (StringUtils.equals(attr.getAttrName(), attrName)) {
                attr.setAttrValue(value);
                return;
            }
        }
        throw new RuntimeException("can not find attr:" + attrName);
    }

    public BPLoan getBpLoan() {
        return bpLoan;
    }

    public void setBpLoan(BPLoan bpLoan) {
        this.bpLoan = bpLoan;
    }

    public BPDTO clone() {
        try {
            BPDTO bpDTO = (BPDTO) super.clone();
            bpDTO.setBp(bpDTO.getBp().clone());
            return bpDTO;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
