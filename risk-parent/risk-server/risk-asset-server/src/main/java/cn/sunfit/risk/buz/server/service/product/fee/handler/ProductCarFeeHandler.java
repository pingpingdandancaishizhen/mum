package cn.sunfit.risk.buz.server.service.product.fee.handler;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectDTO;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectReq;
import cn.sunfit.risk.buz.api.beans.loan.LoanFee;
import cn.sunfit.risk.buz.api.constants.LoanEachTimeType;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.loan.LoanSaveReq;
import cn.sunfit.risk.buz.api.vo.solution.dyc.DycFeeConfig;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.loan.LoanFeeDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentBaseDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentDetailDAO;
import cn.sunfit.risk.buz.server.service.product.fee.ProductFeeAbstractHandler;

/**
 * 车辆-抵押贷款 费用计算处理类
 * @Title: ProductCarFeeHandler.java
 * @Package cn.sunfit.risk.buz.server.service.product.fee.handler
 * @Description: 车辆-抵押贷款 费用计算处理类
 * @author XJ
 * @date 2017年3月7日 下午1:59:23
 * @version V1.0
 */
@Service("productCarFeeHandler")
public class ProductCarFeeHandler extends ProductFeeAbstractHandler {

    private static String accountFormatter(String accountNo) {
        if (StringUtils.isNotEmpty(accountNo)) {
            StringBuilder str = new StringBuilder(accountNo.replace(" ", ""));
            int i = str.length() / 4;
            int j = str.length() % 4;
            for (int x = (j == 0 ? i - 1 : i); x > 0; x--) {
                str = str.insert(x * 4, " ");
            }
            return str.toString();
        }
        return accountNo;
    }

    @Autowired
    LoanFeeDAO loanFeeDAO;

    @Autowired
    BPAttrDAO bpAttrDAO;

    @Autowired
    BPLoanDAO bpLoanDAO;

    @Autowired
    BPDAO bpDAO;

    @Autowired
    RepaymentBaseDAO repaymentBaseDAO;

    @Autowired
    RepaymentDetailDAO repaymentDetailDAO;

    @Override
    public boolean filter(String productId) {
        return true;
    }

    @Override
    public Map<String, String> getRepaymentAttr(String domain, String bpId) {
        Map<String, String> map = new HashMap<String, String>();
        FormQuery req = new FormQuery();
        req.setDomain(domain);
        req.setBpId(bpId);
        List<BPAttr> attrs = bpAttrDAO.findByBP(req);
        map.put("eachTimes", ProductFeeCalUtil.getAttr(attrs, "loanapproval_eachTimes"));
        map.put("custName", ProductFeeCalUtil.getAttr(attrs, "cust_name"));
        LoanRepaymentType loanRepaymentType = ProductFeeCalUtil.getLoanRepaymentType(attrs);
        BigDecimal monthlyRate = BigDecimal.ZERO;
        BigDecimal monthlyGLFee = BigDecimal.ZERO;
        if (loanRepaymentType != LoanRepaymentType.YCXHQ) {
            monthlyRate = StringUtils.isBlank(ProductFeeCalUtil.getAttr(attrs, "loanapproval_monthlyRate")) ? BigDecimal.ZERO
                    : new BigDecimal(ProductFeeCalUtil.getAttr(attrs, "loanapproval_monthlyRate"));
            monthlyGLFee = StringUtils.isBlank(ProductFeeCalUtil.getAttr(attrs, "loanapproval_monthlyGLFee")) ? BigDecimal.ZERO
                    : new BigDecimal(ProductFeeCalUtil.getAttr(attrs, "loanapproval_monthlyGLFee"));
            LoanEachTimeType eachTimes = ProductFeeCalUtil.getEachTime(attrs);
            switch (eachTimes) {
                case D15:
                    monthlyRate = monthlyRate.divide(new BigDecimal("2")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("2")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    break;
                case M1:
                    break;
                case M2:
                    monthlyRate = monthlyRate.multiply(new BigDecimal("2")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("2")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    break;
                case M3:
                    monthlyRate = monthlyRate.multiply(new BigDecimal("3")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("3")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    break;
                case M6:
                    monthlyRate = monthlyRate.multiply(new BigDecimal("6")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("6")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    break;
                case M12:
                    monthlyRate = monthlyRate.multiply(new BigDecimal("12")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    monthlyGLFee = monthlyGLFee.multiply(new BigDecimal("12")).setScale(2, BigDecimal.ROUND_HALF_UP);
                    break;
            }
        }
        map.put("monthlyRate", monthlyRate.toString());
        map.put("daylyRate", ProductFeeCalUtil.getAttr(attrs, "loanapproval_daylyRate"));
        map.put("monthlyGLFee", monthlyGLFee.toString());
        map.put("daylyGLFee", ProductFeeCalUtil.getAttr(attrs, "loanapproval_daylyGLFee"));
        map.put("accountName", ProductFeeCalUtil.getAttr(attrs, "loanrebank_account_name"));
        String bank = "";
        ValueSelectReq valueReq = new ValueSelectReq();
        valueReq.setBpId(bpId);
        valueReq.setDomain(domain);
        valueReq.setFieldKey("loanrebank_bank");
        ValueSelectDTO dto = bpAttrDAO.getValueByBpAndKey(valueReq);
        if (dto != null) {
            if (StringUtils.isNotBlank(dto.getProvider())) {
                valueReq.setDicKey(dto.getFieldValue());
                valueReq.setDicType(dto.getProvider());
                bank = bpAttrDAO.getValueFromDic(valueReq);
            } else {
                bank = dto.getFieldValue();
            }
        }
        map.put("bank", bank);
        map.put("accountNo", accountFormatter(ProductFeeCalUtil.getAttr(attrs, "loanrebank_account_no")));
        map.put("repaymentType", ProductFeeCalUtil.getAttr(attrs, "loanapproval_repaymentTypes"));
        return map;
    }

    @Override
    public Map<String, BigDecimal> getRepaymentFeeRate(String domain, String bpId) {
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        FormQuery req = new FormQuery();
        req.setDomain(domain);
        req.setBpId(bpId);
        List<BPAttr> attrs = bpAttrDAO.findByBP(req);
        map.put("znjFee", ProductFeeCalUtil.getRate(attrs, "loanapproval_znjFee"));
        map.put("wyFee", ProductFeeCalUtil.getRate(attrs, "loanapproval_wyFee"));
        map.put("monthlyRate", ProductFeeCalUtil.getRate(attrs, "loanapproval_monthlyRate"));
        return map;
    }

    // 保存费率
    @Override
    public void saveLoanFeeList(FormQuery req, BPLoan loan) {
        List<LoanFee> list = new ArrayList<LoanFee>();
        List<BPAttr> attrs = bpAttrDAO.findByBP(req);
        // 审核通过金额
        BigDecimal approvedAmount = loan.getApprovedAmount();

        LoanRepaymentType loanRepaymentType = ProductFeeCalUtil.getLoanRepaymentType(attrs);
        // 添加保证金并返回
        BigDecimal bzjFee = ProductFeeCalUtil.setBzjFee(list, attrs, approvedAmount);
        // 添加咨询费
        ProductFeeCalUtil.setConsulting(list, attrs, approvedAmount, bzjFee);
        // 添加管理费
        ProductFeeCalUtil.setManageFee(list, attrs, approvedAmount, bzjFee, loanRepaymentType);
        // 添加GPS安装费
        ProductFeeCalUtil.setGPSFee(list, attrs);
        // 添加GPS管理费
        ProductFeeCalUtil.setGPSServiceFee(list, attrs);
        // 添加停车费
        ProductFeeCalUtil.setParkFee(list, attrs);
        // 设置首期利息
        ProductFeeCalUtil.setInterest(list, attrs, approvedAmount, bzjFee, loanRepaymentType);

        ProductFeeCalUtil.setPrinciple(list, attrs, approvedAmount, bzjFee, loanRepaymentType);
        Date current = new Date();
        for (LoanFee loanFee : list) {
            loanFee.setBpNo(req.getBpId());
            loanFee.setUpdateTime(current);
        }
        // 插入计算完成后的费用
        loanFeeDAO.insertLoanFeeList(list, req.getDomain());
        // 更新为放款结束
        LoanSaveReq updateReq = new LoanSaveReq();
        updateReq.setBpId(req.getBpId());
        updateReq.setDomain(req.getDomain());
        String feeConfig = bpDAO.selectFeeConfigByBpId(req.getBpId(), req.getDomain());
        DycFeeConfig config = JsonUtils.parseJSON(feeConfig, DycFeeConfig.class);
        updateReq.setZnjFeeCal(config.getZnjFeeCal());
        bpLoanDAO.updateBPLoanStartLoan(updateReq);

    }
}
