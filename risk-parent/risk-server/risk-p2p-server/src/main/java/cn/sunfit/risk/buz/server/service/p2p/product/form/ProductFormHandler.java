package cn.sunfit.risk.buz.server.service.p2p.product.form;

import java.util.Map;

import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;

public interface ProductFormHandler {

    public boolean filter(String productId);

    // public void finish(FormQuery req, BPLoan loan);

    /**
     * 
     * @Title: updateLoan
     * @Description: 修改借款单横表
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author DELL 2017年5月4日 
     * @throws
     */
    void updateLoan(FormQuery req, Map<String, String> formdata);

    /**
     * 
     * @Title: updateStatus
     * @Description: 修改订单状态
     * @param @param req
     * @param @param status   
     * @return void 
     * @author DELL 2017年5月10日 
     * @throws
     */
    public void updateStatus(FormQuery req, String status);

}
