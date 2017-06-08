package cn.sunfit.risk.buz.api.vo.solution;

import cn.sunfit.risk.buz.api.vo.CorpReqBase;

/**
 * 
 * @Title: ProductQueryReq.java
 * @Package cn.sunfit.risk.buz.api.vo.solution
 * @Description: 查询公司产品列表参数
 * @author XFL
 * @date 2016年12月29日 下午4:08:53
 * @version V1.0
 */
public class ProductQueryReq extends CorpReqBase {

    private static final long serialVersionUID = 8355948445871981535L;

    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
