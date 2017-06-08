package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFBPDetail;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFRepayment;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectReq;
import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.LoanTermType;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFBPAttrService;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBPDetailReq;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusDTO;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusGetReq;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFRepayDetailQueryReq;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFValueSelectDTO;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFBPAttrDAO;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFBPDAO;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFCorpDAO;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFRepaymentDetailDAO;

@Service("jfjd.bPAttrService")
public class JFBPAttrServiceImpl implements JFBPAttrService {
    @Autowired
    private JFBPAttrDAO jFBPAttrDAO;

    @Autowired
    private JFCorpDAO jFCorpDAO;

    @Autowired
    private JFRepaymentDetailDAO jFRepaymentDetailDAO;

    @Autowired
    private JFBPDAO jFBPDAO;

    @Override
    public Map<String, Object> getBPDetailById(JFBPDetailReq req) throws ServiceException {
        JFBPDetail bpDetail = new JFBPDetail();
        String domain = jFCorpDAO.getDomainByCorpId(req.getCorpId());
        if (StringUtils.isBlank(domain)) {
            throw new ServiceException("获取公司信息失败");
        }
        ValueSelectReq request = new ValueSelectReq(domain, req.getBpId(), "");

        // 客户姓名
        request.setFieldKey("cust_name");
        String custName = getValueFromBp(request);
        bpDetail.setUserName(custName);
        // 手机号码
        request.setFieldKey("cust_mobile");
        String mobile = getValueFromBp(request);
        bpDetail.setMobile(mobile);
        // 身份证号码
        request.setFieldKey("cust_license_num");
        String idCard = getValueFromBp(request);
        bpDetail.setIdCard(idCard);
        // 借款期限
        request.setFieldKey("loan_apply_monthlyTerm");
        String loanTerm = getValueFromBp(request);
        bpDetail.setLoanTerm(LoanTermType.getLabelByStatus(loanTerm));
        // 申请金额
        request.setFieldKey("loan_apply_amount");
        String applyAmount = getValueFromBp(request);
        bpDetail.setApplyMoney(applyAmount);
        // 车系
        request.setFieldKey("loancar_car_bms_brand");
        String brand = getValueFromBp(request);
        request.setFieldKey("loancar_car_bms_series");
        String series = getValueFromBp(request);
        request.setFieldKey("loancar_car_bms_model");
        String model = getValueFromBp(request);
        String bms = "";
        if (StringUtils.isNotBlank(brand)) {
            bms = brand;
        }
        if (StringUtils.isNotBlank(series)) {
            bms = bms + "/" + series;
        }
        if (StringUtils.isNotBlank(model)) {
            bms = bms + "/" + model;
        }
        bpDetail.setCarSeries(bms);
        // 车牌号
        request.setFieldKey("loancar_license_plate");
        String carNo = getValueFromBp(request);
        bpDetail.setCarNo(carNo);
        // 车架号
        request.setFieldKey("loancar_frame_number");
        String carFrame = getValueFromBp(request);
        bpDetail.setCarFrameNo(carFrame);
        // 发动机编号
        request.setFieldKey("loancar_engine_number");
        String engineNo = getValueFromBp(request);
        bpDetail.setCarEngineNo(engineNo);

        JFBpStatusDTO dto = jFBPDAO.getStatusById(new JFBpStatusGetReq(req.getBpId(), domain));
        if (dto != null) {
            // 申请日期
            bpDetail.setApplyTime(dto.getCreateTime());
            // 订单状态
            bpDetail.setStatus(getCurrentTaskName(dto.getBpStatus(), dto.getLoanStatus(), dto.getCurrentTaskName()));

            // 如果是贷中，贷后，贷款结束，则修改实际还款期限
            if (dto.getBpStatus() != null
                    && (dto.getBpStatus().equals((int) BpStatus.LOAN_ING.getStatus())
                            || dto.getBpStatus().equals((int) BpStatus.LOAN_AFTER.getStatus()) || dto.getBpStatus()
                            .equals((int) BpStatus.LOAN_FINISH.getStatus()))) {
                // 借款期限
                request.setFieldKey("loanapproval_monthlyTerm");
                loanTerm = getValueFromBp(request);
                bpDetail.setLoanTerm(LoanTermType.getLabelByStatus(loanTerm));
            }
        }

        // 还款明细
        List<JFRepayment> repaymentList = jFRepaymentDetailDAO.getRepayDetailByBp(new JFRepayDetailQueryReq(req
                .getBpId(), domain));
        bpDetail.setRepayment(repaymentList);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("loanDetail", bpDetail);
        return result;
    }

    private String getCurrentTaskName(Integer bpStatus, Integer loanStatus, String currentTaskName) {
        if (BpStatus.LOAN_ING.equals(BpStatus.getByStatus(bpStatus))) {
            return LoanStatus.getNameByStatus(loanStatus).getStatusName();
        } else if (BpStatus.LOAN_AFTER.equals(BpStatus.getByStatus(bpStatus))) {
            return BpStatus.LOAN_AFTER.getLabel();
        } else if (BpStatus.LOAN_FINISH.equals(BpStatus.getByStatus(bpStatus))) {
            return BpStatus.LOAN_FINISH.getLabel();
        } else {
            if (StringUtils.isNotBlank(currentTaskName)) {
                currentTaskName = currentTaskName.substring(1, currentTaskName.length() - 1);
            }
        }
        return currentTaskName;
    }

    private String getValueFromBp(ValueSelectReq req) {
        JFValueSelectDTO dto = jFBPAttrDAO.getValueByBpAndKey(req);
        if (dto != null) {
            if (StringUtils.isNotBlank(dto.getProvider())) {
                req.setDicKey(dto.getFieldValue());
                req.setDicType(dto.getProvider());
                return jFBPAttrDAO.getValueFromDic(req);
            } else {
                return dto.getFieldValue();
            }
        } else {
            return "";
        }
    }
}
