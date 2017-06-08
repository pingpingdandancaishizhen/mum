package cn.sunfit.risk.buz.server.service.p2p.product.form;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.constants.order.CydLoanInfo2AttrEnum;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;

public abstract class ProductFormAbstractHandler implements ProductFormHandler {

    @Autowired
    private LoanInfoDAO loanInfoDAO;

    private String supportProduct;

    public String getSupportProduct() {
        return supportProduct;
    }

    public void setSupportProduct(String supportProduct) {
        this.supportProduct = supportProduct;
    }

    @Override
    public void updateLoan(FormQuery req, Map<String, String> formdata) {
        LoanInfoBean bean = loanInfoDAO.selectLoanInfo(req.getDomain(), req.getLoanInfoId());
        // 将FORMDATA理和她对应的值赋值过去
        Map<String, String> ms = CydLoanInfo2AttrEnum.getAttrFieldMap();
        Map<String, String> newvalue = new HashMap<String, String>();
        for (Map.Entry<String, String> m : ms.entrySet()) {
            if (formdata.containsKey(m.getKey())) {
                // 获取到了有键 直接赋值过去
                newvalue.put(m.getValue(), formdata.get(m.getKey()));
            }
        }
        try {
            BeanUtils.copyProperties(bean, newvalue);
            if (StringUtils.equals("1", formdata.get("loan_fee_tb"))) {
                bean.setLoanPeriod(formdata.get("loan_fee_daylyTerm"));
            } else if (StringUtils.equals("0", formdata.get("loan_fee_tb"))) {
                bean.setLoanPeriod(formdata.get("loan_fee_monthlyTerm"));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        loanInfoDAO.update(req.getDomain(), bean);

    }

    @Override
    public void updateStatus(FormQuery req, String status) {
        loanInfoDAO.updateStatus(req.getDomain(), req.getBpId(), status);
    }

}
