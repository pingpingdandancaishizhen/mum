package cn.sunfit.risk.buz.server.service.product.form;

import java.util.Map;

import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.vo.form.Attr;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;

public interface ProductFormHandler {
    /**
     * 
     * @Title: fillLoan
     * @Description: 填充LOAN表数据
     * @param @param loan
     * @param @param formdata   
     * @return void 
     * @author XFL 2017年3月3日 
     * @throws
     */
    void fillLoan(BPLoan loan, Map<String, String> formdata);

    public boolean filter(String productId);

    // public void finish(FormQuery req, BPLoan loan);

    /**
     * @Title: hasLoan
     * @Description: 贷款数据校验
     * @param @param req
     * @param @param loan
     * @param @return   
     * @return boolean 
     * @author XFL 2017年3月3日 
     * @throws
     */
    public boolean hasLoan(FormQuery req, BPLoan loan);

    /**
     * 
     * @Title: initStartAttr
     * @Description: 初始化第一步的参数
     * @param @param req   
     * @return void 
     * @author XFL 2017年3月3日 
     * @throws
     */
    Map<String, Attr> initStartAttr(FormQuery req);

}
