package cn.sunfit.risk.buz.api.service.p2p.order;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoAttachment;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.p2p.excel.LoanInfoQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.order.OrderListBean;

public interface OrderService {

    /**
     * @Title: batchSubmit
     * @Description: 批量提交订单
     * @param @param currentUser
     * @param @param ids   
     * @return void 
     * @author DELL 2017年5月12日 
     * @throws
     */
    public void batchSubmit(CorpUserDTO currentUser, Long[] ids) throws ServiceException;

    /**
     * 
     * @Title: cancle
     * @Description: 作废
     * @param @param currentUser
     * @param @param ids   
     * @return void 
     * @author DELL 2017年5月16日 
     * @throws
     */
    public void cancle(CorpUserDTO currentUser, Long[] ids) throws ServiceException;

    /**
     * 
     * @Title: insertLoanInfoAttach
     * @Description: 插入附件
     * @param @param loanInfoAttachment   
     * @return void 
     * @author DELL 2017年5月16日 
     * @throws
     */
    public LoanInfoAttachment insertLoanInfoAttach(LoanInfoAttachment loanInfoAttachment, CorpUserDTO user);

    public List<OrderListBean> queryCustAllLoanInfo(LoanInfoQueryReq req);

    public RespPage<List<OrderListBean>> queryLoanInfoList(LoanInfoQueryReq req);

    /**
     * 
     * @Title: removeAttach
     * @Description: 删除附件
     * @param @param attachId   
     * @return void 
     * @author DELL 2017年5月16日 
     * @throws
     */
    public void removeAttach(Long attachId, CorpUserDTO user);
}
