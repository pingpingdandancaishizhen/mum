package cn.sunfit.risk.buz.server.service.product.fee;

import java.math.BigDecimal;
import java.util.Map;

import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;

public interface ProductFeeHandler {

    public boolean filter(String productId);

    public Map<String, String> getRepaymentAttr(String domain, String bpId);

    public Map<String, BigDecimal> getRepaymentFeeRate(String domain, String bpId);

    void saveLoanFeeList(FormQuery req, BPLoan loan);

}
