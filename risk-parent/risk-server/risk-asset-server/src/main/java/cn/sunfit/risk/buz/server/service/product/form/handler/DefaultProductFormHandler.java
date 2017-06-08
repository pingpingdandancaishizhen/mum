package cn.sunfit.risk.buz.server.service.product.form.handler;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.beans.corp.CustContact;
import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.utils.SolutionUtil;
import cn.sunfit.risk.buz.api.vo.form.Attr;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustContactDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustomerDAO;
import cn.sunfit.risk.buz.server.service.product.form.ProductFormAbstractHandler;

/**
 * 
 * @Title: DefaultProductFormHandler.java
 * @Package cn.sunfit.risk.buz.server.service.product.form.handler
 * @Description: 默认产品表单处理
 * @author XFL
 * @date 2017年3月3日 上午11:00:15
 * @version V1.0
 */
@Service("defaultProductFormHandler")
public class DefaultProductFormHandler extends ProductFormAbstractHandler {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustContactDAO custContactDAO;

    @Autowired
    private BPLoanDAO bpLoanDAO;

    // @Autowired
    // private ProductFeeService productFeeService;

    @Override
    public void fillLoan(BPLoan loan, Map<String, String> formdata) {
        if (StringUtils.isNotBlank(formdata.get("loan_apply_amount"))) {
            BigDecimal a = new BigDecimal(formdata.get("loan_apply_amount").trim()).setScale(2,
                    BigDecimal.ROUND_HALF_DOWN);
            loan.setApplyAmount(a);
        }
        if (StringUtils.isNotBlank(formdata.get("loan_apply_period"))) {
            loan.setApplyPeriod(formdata.get("loan_apply_period"));
        }
        if (StringUtils.isNotBlank(formdata.get("loan_repayment_method"))) {
            loan.setRepaymentMethod(formdata.get("loan_repayment_method").trim());
        }
        if (StringUtils.isNotBlank(formdata.get("loanapproval_limit"))) {
            loan.setApprovedAmount(new BigDecimal(formdata.get("loanapproval_limit").trim()).setScale(2,
                    BigDecimal.ROUND_HALF_DOWN));
        }
        if (StringUtils.isNotBlank(formdata.get("loancar_license_plate"))) {
            loan.setCarNo(formdata.get("loancar_license_plate"));
        }
    }

    @Override
    public boolean filter(String productId) {
        return true;
    }

    // @Override
    // public void finish(FormQuery req, BPLoan loan) {
    // // TODO Auto-generated method stub
    // productFeeService.saveLoanFeeList(req.getProductId());
    // }

    @Override
    public boolean hasLoan(FormQuery req, BPLoan loan) {
        // 如果是车贷 ，单号不是 自己。
        String carnum = loan.getCarNo();
        if (StringUtils.isNotBlank(carnum)) {
            long count = bpLoanDAO.countByCarNum(req.getBpId(), carnum, req.getDomain());
            if (count > 0) {
                throw new ServiceException("贷款不合规，可能原因抵押物二次贷款");
            }
        }
        return false;
    }

    @Override
    public Map<String, Attr> initStartAttr(FormQuery req) {
        Customer c = customerDAO.selectByPrimaryKey(req.getCustomerId(), req.getDomain());
        List<CustContact> contacts = custContactDAO.selectCustContactsByCustId(req.getCustomerId(), req.getDomain());

        if (c == null) {
            throw new ServiceException("未查询到客户，非法操作");
        }
        // 赋值
        Map<String, Attr> r = new HashMap<String, Attr>();
        Map<String, String> s = SolutionUtil.converCustomer2Map(c);
        if(contacts != null && contacts.size() > 0){
	        Map<String, String> m = SolutionUtil.converCustContact2Map(contacts);
	        for (Map.Entry<String, String> d : m.entrySet()) {
	            r.put(d.getKey(), new Attr(d.getKey(), d.getValue(), null));
	        }
        }
        for (Map.Entry<String, String> d : s.entrySet()) {
            r.put(d.getKey(), new Attr(d.getKey(), d.getValue(), null));
        }
        return r;
    }

}
