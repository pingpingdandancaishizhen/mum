package cn.sunfit.risk.buz.server.dao.p2p.order;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.api.vo.p2p.excel.LoanInfoQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.order.OrderListBean;

@Repository
public interface LoanInfoDAO {

    public long countLoanInfoStatus(@Param("domain") String domain, @Param("ids") Long[] ids,
            @Param("status") String[] status);

    public int insertLoanInfo(@Param("domain") String domain, @Param("bean") LoanInfoBean loan);

    public int insertLoanInfos(@Param("domain") String domain, @Param("list") List<LoanInfoBean> list);

    List<OrderListBean> queryCustAllLoanInfo(LoanInfoQueryReq req);

    public List<String> queryExistLoanIds(Map<String, Object> paraMap);

    List<OrderListBean> queryLoanInfoList(LoanInfoQueryReq req, RowBounds rowBounds);

    public List<FormQuery> selectFormQuery(@Param("domain") String domain, @Param("ids") Long[] ids);

    public LoanInfoBean selectLoanInfo(@Param("domain") String domain, @Param("id") String loanInfoId);

    public void update(@Param("domain") String domain, @Param("bean") LoanInfoBean bean);

    public void updateStatus(@Param("domain") String domain, @Param("bpId") String bpId, @Param("status") String status);

}
