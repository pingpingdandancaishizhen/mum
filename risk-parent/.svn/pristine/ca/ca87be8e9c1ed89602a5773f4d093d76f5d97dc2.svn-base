package cn.sunfit.risk.buz.api.service.api.jfjd;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFBPAttrValue;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpUserDTO;
import cn.sunfit.risk.buz.api.exception.ServiceException;

public interface JFBpService {
    /**
     * 
     * @Title: countBpById
     * @Description: 查询BP是否存在
     * @param @param saasLoanId
     * @param @param domain
     * @param @return   
     * @return long 
     * @author XFL 2017年3月27日 
     * @throws
     */
    long countBpById(String saasLoanId, String domain);

    public void sendNoticeToJF(String corpId, String domain, String bpId);

    /**
     * 
     * @Title: submitOrder
     * @Description: 提交单子
     * @param @param user
     * @param @param attrValue   
     * @return void 
     * @author XFL 2017年3月23日 
     * @throws
     */
    String submitOrder(JFCorpUserDTO user, JFBPAttrValue attrValue) throws ServiceException;
}
