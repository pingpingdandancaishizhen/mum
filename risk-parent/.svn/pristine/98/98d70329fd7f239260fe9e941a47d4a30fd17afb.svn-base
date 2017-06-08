package cn.sunfit.risk.buz.server.service.product.contract.handler;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sunfit.risk.buz.api.beans.buz.BPAttr;
import cn.sunfit.risk.buz.api.beans.buz.BPLoan;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectDTO;
import cn.sunfit.risk.buz.api.beans.buz.ValueSelectReq;
import cn.sunfit.risk.buz.api.beans.corp.CorpDeptContractVO;
import cn.sunfit.risk.buz.api.beans.corp.Resources;
import cn.sunfit.risk.buz.api.beans.system.partner.ContractPartner;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerIdDTO;
import cn.sunfit.risk.buz.api.beans.system.partner.PartnerSigner;
import cn.sunfit.risk.buz.api.beans.system.partner.ProductIdDTO;
import cn.sunfit.risk.buz.api.beans.util.ContractField;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.LoanEachTimeType;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.PartnerRoleEmu;
import cn.sunfit.risk.buz.api.service.OSSService;
import cn.sunfit.risk.buz.api.utils.DateUtils;
import cn.sunfit.risk.buz.api.utils.RMBUtil;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.product.ProductContractField;
import cn.sunfit.risk.buz.api.vo.product.ProductContractReq;
import cn.sunfit.risk.buz.server.dao.buz.BPAttrDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDeptDAO;
import cn.sunfit.risk.buz.server.dao.corp.ResourcesDAO;
import cn.sunfit.risk.buz.server.dao.system.ContractPartnerDAO;
import cn.sunfit.risk.buz.server.service.product.contract.ProductContractHandler;
import cn.sunfit.risk.buz.server.service.product.fee.handler.ProductFeeCalUtil;
import cn.sunfit.risk.buz.server.util.ContractFieldCalculateUtil;

import com.lowagie.text.Image;

public class DefaultProductContractHandler extends ProductContractHandler {

    private String supportProduct;

    @Autowired
    private BPAttrDAO bPAttrDAO;

    @Autowired
    private ContractPartnerDAO contractPartnerDAO;

    @Autowired
    private ResourcesDAO resourcesDAO;

    @Autowired
    private BPLoanDAO bpLoanDAO;

    @Autowired
    private BPAttrDAO bpAttrDAO;

    @Autowired
    private CorpDeptDAO corpDeptDAO;

    @Autowired
    private OSSService ossService;

    @Override
    public boolean filter(String productId) {
        // 如果非默认，这里可以写 if(productId in supportProduct){RETURN TRUE}
        return true;
    }

    public String getSupportProduct() {
        return supportProduct;
    }

    @Override
    public Map<String, ContractField> getValue(ProductContractReq req) {
        // 增加获取合同字段的值
        Map<String, ContractField> resultMap = new HashMap<String, ContractField>();

        // <<<<<<<<<<<<<<<<<<<查询封装参数 开始>>>>>>>>>>>>>>>>>>>
        packageParaMapWithBp(resultMap, new ValueSelectReq(req.getDomain(), req.getBpId(), null));
        packageParaMapWithPartner(resultMap, new ProductIdDTO(req.getDomain(), req.getProductId()));
        packageParaMapWithCalculate(resultMap, req.getBpId(), req.getDomain());
        packageParaMapWithCurrentTime(resultMap);
        // <<<<<<<<<<<<<<<<<<<查询封装参数 结束>>>>>>>>>>>>>>>>>>>
        return resultMap;
    }

    private String getValueFromBp(ValueSelectReq req) {
        ValueSelectDTO dto = bPAttrDAO.getValueByBpAndKey(req);
        if (dto != null) {
            if (StringUtils.isNotBlank(dto.getProvider())) {
                req.setDicKey(dto.getFieldValue());
                req.setDicType(dto.getProvider());
                return bPAttrDAO.getValueFromDic(req);
            } else {
                return dto.getFieldValue();
            }
        } else {
            return "";
        }
    }

    private String getValueFromBpWithOutDic(ValueSelectReq req) {
        ValueSelectDTO dto = bPAttrDAO.getValueByBpAndKey(req);
        if (dto != null) {
            return dto.getFieldValue();
        } else {
            return "";
        }
    }

    /**
     * 
     * @Title: packageParaMapWithBp
     * @Description:获取流程字段
     * @param @param result
     * @param @param req   
     * @return void 
     * @author RJS 2017年3月10日 
     * @throws
     */
    private void packageParaMapWithBp(Map<String, ContractField> result, ValueSelectReq req) {
        if (result == null) {
            result = new HashMap<String, ContractField>();
        }
        // 借款用途
        req.setFieldKey("loan_usage");
        result.put("he_tong_usage", new ContractField("he_tong_usage", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 还款方式
        req.setFieldKey("loanapproval_repaymentTypes");
        String repayType = getValueFromBp(req);
        String repayment = LoanRepaymentType.getTypeNameStrByTypeId(repayType);
        result.put("he_tong_repayment", new ContractField("he_tong_repayment", repayment, ContractField.ITEM_TYPE_TEXT));

        // 保证金率
        req.setFieldKey("loanapproval_bzjFee");
        result.put("he_tong_margin_ratio", new ContractField("he_tong_margin_ratio", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // GPS安装费
        req.setFieldKey("loanofee_gps");
        String gpsFee = getValueFromBp(req);
        BigDecimal gpsD = BigDecimal.ZERO;
        if (StringUtils.isNotBlank(gpsFee)) {
            gpsD = new BigDecimal(gpsFee).setScale(2);
        }
        result.put("he_tong_fee_gps", new ContractField("he_tong_fee_gps", gpsD.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // GPS服务费
        req.setFieldKey("loanofee_gpsservice");
        String gpsServerFee = getValueFromBp(req);
        BigDecimal gpsSD = BigDecimal.ZERO;
        if (StringUtils.isNotBlank(gpsServerFee)) {
            gpsSD = new BigDecimal(gpsServerFee).setScale(2);
        }
        result.put("he_tong_fee_gpsservice", new ContractField("he_tong_fee_gpsservice", gpsSD.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // 停车费
        req.setFieldKey("loanofee_park");
        String parkingFee = getValueFromBp(req);
        BigDecimal parkingD = BigDecimal.ZERO;
        if (StringUtils.isNotBlank(parkingFee)) {
            parkingD = new BigDecimal(parkingFee).setScale(2);
        }
        result.put("he_tong_fee_park", new ContractField("he_tong_fee_park", parkingD.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // 还款日
        req.setFieldKey("loanofee_repay_day");
        result.put("he_tong_repay_day", new ContractField("he_tong_repay_day", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 提前结清罚息率（违约金率）
        req.setFieldKey("loanapproval_wyFee");
        result.put("he_tong_liquidated_ratio", new ContractField("he_tong_liquidated_ratio", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 逾期罚息率(滞纳金率)
        req.setFieldKey("loanapproval_znjFee");
        result.put("he_tong_znj_ratio", new ContractField("he_tong_znj_ratio", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 月利率
        if (LoanRepaymentType.YCXHQ.getTypeId().equals(repayType)) {
            req.setFieldKey("loanapproval_daylyRate");
            result.put("he_tong_month_ratio", new ContractField("he_tong_month_ratio", getValueFromBp(req),
                    ContractField.ITEM_TYPE_TEXT));
        } else {
            req.setFieldKey("loanapproval_monthlyRate");
            result.put("he_tong_month_ratio", new ContractField("he_tong_month_ratio", getValueFromBp(req),
                    ContractField.ITEM_TYPE_TEXT));
        }

        // 姓名/公司名称
        req.setFieldKey("cust_name");
        result.put("jie_kuan_ren_name", new ContractField("jie_kuan_ren_name", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 身份证号/机构代码
        req.setFieldKey("cust_license_num");
        result.put("jie_kuan_ren_license_num", new ContractField("jie_kuan_ren_license_num", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 电话
        req.setFieldKey("cust_mobile");
        result.put("jie_kuan_ren_mobile", new ContractField("jie_kuan_ren_mobile", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 借款人通讯地址
        req.setFieldKey("cust_live_addr_province");
        String province = getValueFromBp(req);
        req.setFieldKey("cust_live_addr_city");
        String city = getValueFromBp(req);
        req.setFieldKey("cust_live_addr_counties");
        String country = getValueFromBp(req);
        String addr = "";
        if (StringUtils.isNotBlank(province)) {
            addr = addr + province;
        }
        if (StringUtils.isNotBlank(city)) {
            addr = addr + "/" + city;
        }
        if (StringUtils.isNotBlank(country)) {
            addr = addr + "/" + country;
        }
        result.put("jie_kuan_ren_live_address", new ContractField("jie_kuan_ren_live_address", addr,
                ContractField.ITEM_TYPE_TEXT));

        // 借款人详细地址
        req.setFieldKey("cust_live_addr_detail");
        result.put("jie_kuan_ren_live_addr_detail", new ContractField("jie_kuan_ren_live_addr_detail",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 邮箱地址
        req.setFieldKey("cust_email");
        result.put("jie_kuan_ren_email", new ContractField("jie_kuan_ren_email", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 传真号
        req.setFieldKey("");
        result.put("jie_kuan_ren_fax", new ContractField("jie_kuan_ren_fax", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 车牌号
        req.setFieldKey("loancar_license_plate");
        result.put("jie_kuan_ren_loancar_license", new ContractField("jie_kuan_ren_loancar_license",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 车架号
        req.setFieldKey("loancar_frame_number");
        result.put("jie_kuan_ren_loancar_frame_number", new ContractField("jie_kuan_ren_loancar_frame_number",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 行驶证号
        req.setFieldKey("");
        result.put("jie_kuan_ren_loancar_drive_license", new ContractField("jie_kuan_ren_loancar_drive_license",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 发动机号
        req.setFieldKey("loancar_engine_number");
        result.put("jie_kuan_ren_loancar_engine_number", new ContractField("jie_kuan_ren_loancar_engine_number",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 车品牌
        req.setFieldKey("loancar_car_bms_brand");
        result.put("jie_kuan_ren_loancar_car_bms_brand", new ContractField("jie_kuan_ren_loancar_car_bms_brand",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 车系
        req.setFieldKey("loancar_car_bms_series");
        result.put("jie_kuan_ren_loancar_car_bms_series", new ContractField("jie_kuan_ren_loancar_car_bms_series",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 车型号
        req.setFieldKey("loancar_car_bms_model");
        result.put("jie_kuan_ren_loancar_car_bms_model", new ContractField("jie_kuan_ren_loancar_car_bms_model",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 车颜色
        req.setFieldKey("loancar_car_color");
        result.put("jie_kuan_ren_loancar_car_color", new ContractField("jie_kuan_ren_loancar_car_color",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 车燃料
        req.setFieldKey("loancar_car_fuel");
        result.put("jie_kuan_ren_loancar_car_fuel", new ContractField("jie_kuan_ren_loancar_car_fuel",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 驾驶位置
        req.setFieldKey("loancar_driving_position");
        result.put("jie_kuan_ren_loancar_driving_position", new ContractField("jie_kuan_ren_loancar_driving_position",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 座位数
        req.setFieldKey("");
        result.put("jie_kuan_ren_loancar_seat_no", new ContractField("jie_kuan_ren_loancar_seat_no",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 收款银行
        req.setFieldKey("loanbank_bank");
        result.put("jie_kuan_ren_collect_bank", new ContractField("jie_kuan_ren_collect_bank", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 收款银行户名
        req.setFieldKey("loanbank_account_name");
        result.put("jie_kuan_ren_collect_bank_name", new ContractField("jie_kuan_ren_collect_bank_name",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 收款银行账号
        req.setFieldKey("loanbank_account_no");
        result.put("jie_kuan_ren_collect_bank_account", new ContractField("jie_kuan_ren_collect_bank_account",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 还款银行
        req.setFieldKey("loanrebank_bank");
        result.put("jie_kuan_ren_repay_bank", new ContractField("jie_kuan_ren_repay_bank", getValueFromBp(req),
                ContractField.ITEM_TYPE_TEXT));

        // 还款银行户名
        req.setFieldKey("loanrebank_account_name");
        result.put("jie_kuan_ren_repay_bank_name", new ContractField("jie_kuan_ren_repay_bank_name",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 还款银行账号
        req.setFieldKey("loanrebank_account_no");
        result.put("jie_kuan_ren_repay_bank_account", new ContractField("jie_kuan_ren_repay_bank_account",
                getValueFromBp(req), ContractField.ITEM_TYPE_TEXT));

        // 抵押权人信息
        req.setFieldKey("loan_mortgage_user");
        String partnerId = getValueFromBp(req);
        if (StringUtils.isNotBlank(partnerId)) {
            ContractPartner partner = contractPartnerDAO.selectPartner(new PartnerIdDTO(req.getDomain(), partnerId));
            if (partner != null) {
                Resources signResource = resourcesDAO.selectById(req.getDomain(), partner.getSignResource());
                Resources sealResource = resourcesDAO.selectById(req.getDomain(), partner.getSealResource());
                result.put("di_ya_quan_ren_name", new ContractField("di_ya_quan_ren_name", partner.getName(),
                        ContractField.ITEM_TYPE_TEXT));
                result.put("di_ya_quan_ren_code", new ContractField("di_ya_quan_ren_code", partner.getCode(),
                        ContractField.ITEM_TYPE_TEXT));
                result.put("di_ya_quan_ren_phone", new ContractField("di_ya_quan_ren_phone", partner.getPhone(),
                        ContractField.ITEM_TYPE_TEXT));
                result.put("di_ya_quan_ren_address", new ContractField("di_ya_quan_ren_address", partner.getAddress(),
                        ContractField.ITEM_TYPE_TEXT));
                result.put("di_ya_quan_ren_addr_detail",
                        new ContractField("di_ya_quan_ren_addr_detail", partner.getAddrDetail(),
                                ContractField.ITEM_TYPE_TEXT));
                result.put("di_ya_quan_ren_email", new ContractField("di_ya_quan_ren_email", partner.getEmail(),
                        ContractField.ITEM_TYPE_TEXT));
                result.put("di_ya_quan_ren_fax", new ContractField("di_ya_quan_ren_fax", partner.getFax(),
                        ContractField.ITEM_TYPE_TEXT));
                try {
                    if (signResource != null && StringUtils.isNotBlank(signResource.getUrl())) {
                        String key = GlobalConstants.OSS_URL_HEADER
                                + signResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                        Image signImage = Image.getInstance(ossService.downloadFile(key));
                        result.put("di_ya_quan_ren_sign", new ContractField("di_ya_quan_ren_sign", signImage,
                                ContractField.ITEM_TYPE_IMAGE));
                    }
                    if (sealResource != null && StringUtils.isNotBlank(sealResource.getUrl())) {
                        String key = GlobalConstants.OSS_URL_HEADER
                                + sealResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                        Image sealImage = Image.getInstance(ossService.downloadFile(key));
                        result.put("di_ya_quan_ren_seal", new ContractField("di_ya_quan_ren_seal", sealImage,
                                ContractField.ITEM_TYPE_IMAGE));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }

        // 所属门店
        CorpDeptContractVO deptVO = corpDeptDAO.getDeptNameByBp(req.getBpId(), req.getDomain());
        result.put("ju_jian_ren_store", new ContractField("ju_jian_ren_store", deptVO != null ? deptVO.getDeptName()
                : "", ContractField.ITEM_TYPE_TEXT));

        // 签约地点
        String signAddr = "";
        if (deptVO != null && deptVO.getDeptAddr() != null) {
            signAddr = signAddr + deptVO.getDeptAddr();
        }
        if (deptVO.getDeptAddrDetail() != null) {
            if (StringUtils.isBlank(signAddr)) {
                signAddr = signAddr + deptVO.getDeptAddrDetail();
            } else {
                signAddr = signAddr + "/" + deptVO.getDeptAddrDetail();
            }
        }
        result.put("he_tong_sign_address", new ContractField("he_tong_sign_address", signAddr,
                ContractField.ITEM_TYPE_TEXT));

        // 每期还款日选择方式
        req.setFieldKey("loanofee_repay_day_type");
        String dayType = "1".equals(getValueFromBpWithOutDic(req)) ? "A" : "B";
        result.put("he_tong_hkrq_type", new ContractField("he_tong_hkrq_type", dayType, ContractField.ITEM_TYPE_TEXT));

        // 借款期限
        if (LoanRepaymentType.YCXHQ.getTypeId().equals(repayType)) {
            req.setFieldKey("loanapproval_daylyTerm");
            String loanPerid = getValueFromBp(req);
            result.put("he_tong_jkqx_start", new ContractField("he_tong_jkqx_start", DateUtils.getFullDate(new Date()),
                    ContractField.ITEM_TYPE_TEXT));
            result.put("he_tong_jkqx_end",
                    new ContractField("he_tong_jkqx_end", DateUtils.getFullDateAddDay(new Date(), loanPerid),
                            ContractField.ITEM_TYPE_TEXT));
        } else {
            req.setFieldKey("loanapproval_monthlyTerm");
            String loanPerid = getValueFromBp(req);
            result.put("he_tong_jkqx_start", new ContractField("he_tong_jkqx_start", DateUtils.getFullDate(new Date()),
                    ContractField.ITEM_TYPE_TEXT));
            result.put(
                    "he_tong_jkqx_end",
                    new ContractField("he_tong_jkqx_end", DateUtils.endDateCalculator(new Date(),
                            LoanEachTimeType.getTypeByStatus(loanPerid)), ContractField.ITEM_TYPE_TEXT));
        }
    }

    private void packageParaMapWithCalculate(Map<String, ContractField> result, String bpId, String domain) {
        if (result == null) {
            result = new HashMap<String, ContractField>();
        }

        FormQuery formQuery = new FormQuery();
        formQuery.setDomain(domain);
        formQuery.setBpId(bpId);
        BPLoan bpLoan = bpLoanDAO.selectByBp(formQuery);
        List<BPAttr> attrs = bpAttrDAO.findByBP(formQuery);
        BigDecimal approvedAmount = bpLoan.getApprovedAmount();
        LoanRepaymentType loanRepaymentType = ProductFeeCalUtil.getLoanRepaymentType(attrs);

        // 合同金额
        result.put("he_tong_contract_fee", new ContractField("he_tong_contract_fee", approvedAmount.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // 合同金额大写
        result.put("he_tong_contract_fee_caps",
                new ContractField("he_tong_contract_fee_caps", RMBUtil.hangeToBig(approvedAmount),
                        ContractField.ITEM_TYPE_TEXT));

        // 借款期数
        result.put("he_tong_loan_period", new ContractField("he_tong_loan_period", bpLoan.getApplyPeriod(),
                ContractField.ITEM_TYPE_TEXT));

        // 保证金
        BigDecimal bzjFee = ContractFieldCalculateUtil.getBzjFee(attrs, approvedAmount);
        result.put("he_tong_margin", new ContractField("he_tong_margin", bzjFee.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // 月管理费
        BigDecimal manageFee = ContractFieldCalculateUtil
                .getManageFee(attrs, approvedAmount, bzjFee, loanRepaymentType);
        result.put("he_tong_monthly_fee", new ContractField("he_tong_monthly_fee", manageFee.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // 咨询费
        BigDecimal consultFee = ContractFieldCalculateUtil.getConsulting(attrs, approvedAmount, bzjFee);
        result.put("he_tong_fee_consulting", new ContractField("he_tong_fee_consulting", consultFee.toString() + "元",
                ContractField.ITEM_TYPE_TEXT));

        // 还款分期表 V1.4期不做
        // List<List<String>> scadure = ContractFieldCalculateUtil.getRepayDetail(attrs, approvedAmount, bzjFee);
        // result.put("he_tong_repay_schedule", new ContractField("he_tong_repay_schedule", scadure,
        // ContractField.ITEM_TYPE_TABLE));

        // 提前结清违约金（违约金）
        String wyStr = getValueFromBp(new ValueSelectReq(domain, bpId, "loanapproval_wyFee"));
        if (StringUtils.isNotBlank(wyStr)) {
            BigDecimal wyRate = new BigDecimal(wyStr).divide(new BigDecimal("100"), 6, BigDecimal.ROUND_HALF_UP);
            result.put("he_tong_liquidated_damages", new ContractField("he_tong_liquidated_damages", approvedAmount
                    .add(bzjFee).multiply(wyRate).setScale(2, BigDecimal.ROUND_HALF_UP)
                    + "元", ContractField.ITEM_TYPE_TEXT));
        }

        // 罚息金额（滞纳金）
        String znStr = getValueFromBp(new ValueSelectReq(domain, bpId, "loanapproval_znjFee"));
        if (StringUtils.isNotBlank(znStr)) {
            BigDecimal znRate = new BigDecimal(znStr).divide(new BigDecimal("100"), 6, BigDecimal.ROUND_HALF_UP);
            result.put(
                    "he_tong_znj_fee",
                    new ContractField("he_tong_znj_fee", approvedAmount.add(bzjFee).multiply(znRate)
                            .setScale(2, BigDecimal.ROUND_HALF_UP)
                            + "元", ContractField.ITEM_TYPE_TEXT));
        }

        // 逾期天数
        // result.put("he_tong_over_days", new ContractField("he_tong_over_days", "", ContractField.ITEM_TYPE_TEXT));
        // 罚息金额
        // result.put("he_tong_penalty_fee", new ContractField("he_tong_penalty_fee", "",
        // ContractField.ITEM_TYPE_TEXT));
        // 未还金额
        // result.put("he_tong_unrepay_fee", new ContractField("he_tong_unrepay_fee", "",
        // ContractField.ITEM_TYPE_TEXT));
    }

    private void packageParaMapWithCurrentTime(Map<String, ContractField> result) {
        if (result == null) {
            result = new HashMap<String, ContractField>();
        }
        result.put("current_date_year", new ContractField("current_date_year", DateUtils.getCurrentYear(),
                ContractField.ITEM_TYPE_TEXT));
        result.put("current_date_month", new ContractField("current_date_month", DateUtils.getCurrentMonth(),
                ContractField.ITEM_TYPE_TEXT));
        result.put("current_date_day", new ContractField("current_date_day", DateUtils.getCurrentDay(),
                ContractField.ITEM_TYPE_TEXT));
        result.put("current_date_time", new ContractField("current_date_time", DateUtils.getCurrentTime(),
                ContractField.ITEM_TYPE_TEXT));
    }

    /**
     * 
     * @Title: packageParaMapWithPartner
     * @Description: 获取参与方字段
     * @param @param result
     * @param @param dto   
     * @return void 
     * @author RJS 2017年3月10日 
     * @throws
     */
    private void packageParaMapWithPartner(Map<String, ContractField> result, ProductIdDTO dto) {
        if (result == null) {
            result = new HashMap<String, ContractField>();
        }
        List<PartnerSigner> signers = contractPartnerDAO.querySignerByProduct(new ProductIdDTO(dto.getDomain(), dto
                .getProductId()));
        if (signers != null && signers.size() > 0) {
            for (PartnerSigner partner : signers) {
                Resources signResource = resourcesDAO.selectById(dto.getDomain(), partner.getSignResource());
                Resources sealResource = resourcesDAO.selectById(dto.getDomain(), partner.getSealResource());
                // 出借人
                if (PartnerRoleEmu.ROLE_CHU_JIE_REN.getId().equals(partner.getRoleId())) {
                    result.put("chu_jie_ren_name", new ContractField("chu_jie_ren_name", partner.getName(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("chu_jie_ren_code", new ContractField("chu_jie_ren_code", partner.getCode(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("chu_jie_ren_phone", new ContractField("chu_jie_ren_phone", partner.getPhone(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("chu_jie_ren_address", new ContractField("chu_jie_ren_address", partner.getAddress(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("chu_jie_ren_addr_detail",
                            new ContractField("chu_jie_ren_addr_detail", partner.getAddrDetail(),
                                    ContractField.ITEM_TYPE_TEXT));
                    try {
                        if (signResource != null && StringUtils.isNotBlank(signResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + signResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image signImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("chu_jie_ren_sign", new ContractField("chu_jie_ren_sign", signImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                        if (sealResource != null && StringUtils.isNotBlank(sealResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + sealResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image sealImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("chu_jie_ren_seal", new ContractField("chu_jie_ren_seal", sealImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 抵押权人 改成从流程中获取
                // if (PartnerRoleEmu.ROLE_DI_YA_QUAN_REN.getId().equals(partner.getRoleId())) {
                // result.put("di_ya_quan_ren_name", new ContractField("di_ya_quan_ren_name", partner.getName(),
                // ContractField.ITEM_TYPE_TEXT));
                // result.put("di_ya_quan_ren_code", new ContractField("di_ya_quan_ren_code", partner.getCode(),
                // ContractField.ITEM_TYPE_TEXT));
                // result.put("di_ya_quan_ren_phone", new ContractField("di_ya_quan_ren_phone", partner.getPhone(),
                // ContractField.ITEM_TYPE_TEXT));
                // result.put(
                // "di_ya_quan_ren_address",
                // new ContractField("di_ya_quan_ren_address", partner.getAddress() + "/"
                // + partner.getAddrDetail(), ContractField.ITEM_TYPE_TEXT));
                // result.put("di_ya_quan_ren_email", new ContractField("di_ya_quan_ren_email", partner.getEmail(),
                // ContractField.ITEM_TYPE_TEXT));
                // result.put("di_ya_quan_ren_fax", new ContractField("di_ya_quan_ren_fax", partner.getFax(),
                // ContractField.ITEM_TYPE_TEXT));
                // result.put("di_ya_quan_ren_sign", new ContractField("di_ya_quan_ren_sign",
                // signResource != null ? signResource.getUrl() : "", ContractField.ITEM_TYPE_IMAGE));
                // result.put("di_ya_quan_ren_seal", new ContractField("di_ya_quan_ren_seal",
                // sealResource != null ? sealResource.getUrl() : "", ContractField.ITEM_TYPE_IMAGE));
                // }
                // 担保方
                if (PartnerRoleEmu.ROLE_DAN_BAO_FANG.getId().equals(partner.getRoleId())) {
                    result.put("dan_bao_ren_name", new ContractField("dan_bao_ren_name", partner.getName(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("dan_bao_ren_code", new ContractField("dan_bao_ren_code", partner.getCode(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("dan_bao_ren_phone", new ContractField("dan_bao_ren_phone", partner.getPhone(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("dan_bao_ren_address", new ContractField("dan_bao_ren_address", partner.getAddress(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("dan_bao_ren_addr_detail",
                            new ContractField("dan_bao_ren_addr_detail", partner.getAddrDetail(),
                                    ContractField.ITEM_TYPE_TEXT));
                    result.put("dan_bao_ren_email", new ContractField("dan_bao_ren_email", partner.getEmail(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("dan_bao_ren_fax", new ContractField("dan_bao_ren_fax", partner.getFax(),
                            ContractField.ITEM_TYPE_TEXT));
                    try {
                        if (signResource != null && StringUtils.isNotBlank(signResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + signResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image signImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("dan_bao_ren_sign", new ContractField("dan_bao_ren_sign", signImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                        if (sealResource != null && StringUtils.isNotBlank(sealResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + sealResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image sealImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("dan_bao_ren_seal", new ContractField("dan_bao_ren_seal", sealImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 市场方
                if (PartnerRoleEmu.ROLE_SHI_CHANG_FANG.getId().equals(partner.getRoleId())) {
                    result.put("ju_jian_ren_name", new ContractField("ju_jian_ren_name", partner.getName(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("ju_jian_ren_code", new ContractField("ju_jian_ren_code", partner.getCode(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("ju_jian_ren_phone", new ContractField("ju_jian_ren_phone", partner.getPhone(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("ju_jian_ren_address", new ContractField("ju_jian_ren_address", partner.getAddress(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("ju_jian_ren_addr_detail",
                            new ContractField("ju_jian_ren_addr_detail", partner.getAddrDetail(),
                                    ContractField.ITEM_TYPE_TEXT));
                    result.put("ju_jian_ren_email", new ContractField("ju_jian_ren_email", partner.getEmail(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("ju_jian_ren_fax", new ContractField("ju_jian_ren_fax", partner.getFax(),
                            ContractField.ITEM_TYPE_TEXT));
                    try {
                        if (signResource != null && StringUtils.isNotBlank(signResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + signResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image signImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("ju_jian_ren_sign", new ContractField("ju_jian_ren_sign", signImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                        if (sealResource != null && StringUtils.isNotBlank(sealResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + sealResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image sealImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("ju_jian_ren_seal", new ContractField("ju_jian_ren_seal", sealImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // 授权方
                if (PartnerRoleEmu.ROLE_SHOU_QUAN_FANG.getId().equals(partner.getRoleId())) {
                    result.put("shou_quan_ren_name", new ContractField("shou_quan_ren_name", partner.getName(),
                            ContractField.ITEM_TYPE_TEXT));
                    result.put("shou_quan_ren_code", new ContractField("shou_quan_ren_code", partner.getCode(),
                            ContractField.ITEM_TYPE_TEXT));
                    try {
                        if (signResource != null && StringUtils.isNotBlank(signResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + signResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image signImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("shou_quan_ren_sign", new ContractField("shou_quan_ren_sign", signImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                        if (sealResource != null && StringUtils.isNotBlank(sealResource.getUrl())) {
                            String key = GlobalConstants.OSS_URL_HEADER
                                    + sealResource.getUrl().split(GlobalConstants.OSS_URL_HEADER)[1];
                            Image sealImage = Image.getInstance(ossService.downloadFile(key));
                            result.put("shou_quan_ren_seal", new ContractField("shou_quan_ren_seal", sealImage,
                                    ContractField.ITEM_TYPE_IMAGE));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void setContractFields() {
        // 增加合同所需字段
        fields.add(new ProductContractField("he_tong_contract_no", "合同号", "合同信息"));
        fields.add(new ProductContractField("he_tong_contract_fee", "合同金额", "合同信息"));
        fields.add(new ProductContractField("he_tong_contract_fee_caps", "合同金额大写", "合同信息"));
        fields.add(new ProductContractField("he_tong_usage", "借款用途", "合同信息"));
        fields.add(new ProductContractField("he_tong_repayment", "还款方式", "合同信息"));
        fields.add(new ProductContractField("he_tong_loan_period", "借款期数", "合同信息"));
        fields.add(new ProductContractField("he_tong_margin", "保证金", "合同信息"));
        fields.add(new ProductContractField("he_tong_margin_ratio", "保证金率", "合同信息"));
        fields.add(new ProductContractField("he_tong_fee_gps", "GPS安装费", "合同信息"));
        fields.add(new ProductContractField("he_tong_fee_gpsservice", "GPS服务费", "合同信息"));
        fields.add(new ProductContractField("he_tong_fee_park", "停车费", "合同信息"));
        fields.add(new ProductContractField("he_tong_monthly_fee", "月管理费", "合同信息"));
        fields.add(new ProductContractField("he_tong_fee_consulting", "咨询费", "合同信息"));
        fields.add(new ProductContractField("he_tong_repay_day", "还款日", "合同信息"));
        fields.add(new ProductContractField("he_tong_liquidated_damages", "违约金", "合同信息"));
        fields.add(new ProductContractField("he_tong_liquidated_ratio", "违约金率", "合同信息"));
        fields.add(new ProductContractField("he_tong_znj_fee", "滞纳金", "合同信息"));
        fields.add(new ProductContractField("he_tong_znj_ratio", "滞纳金率", "合同信息"));
        fields.add(new ProductContractField("he_tong_month_ratio", "月利率", "合同信息"));

        fields.add(new ProductContractField("he_tong_hkrq_type", "指定还款日期选择", "合同信息"));
        fields.add(new ProductContractField("he_tong_jkqx_start", "借款期限开始日期", "合同信息"));
        fields.add(new ProductContractField("he_tong_jkqx_end", "借款期限结束日期", "合同信息"));
        fields.add(new ProductContractField("he_tong_sign_address", "签约地点", "合同信息"));

        // fields.add(new ProductContractField("he_tong_repay_schedule", "还款分期表", "合同信息"));
        // fields.add(new ProductContractField("he_tong_over_days", "逾期天数", "合同信息"));
        // fields.add(new ProductContractField("he_tong_penalty_fee", "罚息金额", "合同信息"));
        // fields.add(new ProductContractField("he_tong_unrepay_fee", "未还金额", "合同信息"));
        fields.add(new ProductContractField("jie_kuan_ren_name", "姓名/公司名称", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_license_num", "身份证号/机构代码", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_mobile", "电话", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_live_address", "通讯地址", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_live_addr_detail", "详细地址", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_email", "邮箱地址", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_fax", "传真号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_license", "车牌号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_frame_number", "车架号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_drive_license", "行驶证号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_engine_number", "发动机号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_car_bms_brand", "车品牌", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_car_bms_series", "车系", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_car_bms_model", "车型号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_car_color", "车颜色", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_car_fuel", "车燃料", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_driving_position", "驾驶位置", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_loancar_seat_no", "座位数", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_collect_bank", "收款银行", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_collect_bank_name", "收款银行户名", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_collect_bank_account", "收款银行账号", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_repay_bank", "还款银行", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_repay_bank_name", "还款银行户名", "借款人信息"));
        fields.add(new ProductContractField("jie_kuan_ren_repay_bank_account", "还款银行账号", "借款人信息"));
        fields.add(new ProductContractField("chu_jie_ren_name", "姓名/公司名称", "出借人信息"));
        fields.add(new ProductContractField("chu_jie_ren_code", "身份证号/机构代码", "出借人信息"));
        fields.add(new ProductContractField("chu_jie_ren_phone", "电话", "出借人信息"));
        fields.add(new ProductContractField("chu_jie_ren_address", "通讯地址", "出借人信息"));
        fields.add(new ProductContractField("chu_jie_ren_addr_detail", "详细地址", "出借人信息"));
        // fields.add(new ProductContractField("chu_jie_ren_collect_bank", "收款银行", "出借人信息"));
        // fields.add(new ProductContractField("chu_jie_ren_collect_bakn_name", "收款银行户名", "出借人信息"));
        // fields.add(new ProductContractField("chu_jie_ren_collect_bank_account", "收款银行账号", "出借人信息"));
        // fields.add(new ProductContractField("chu_jie_ren_repay_bank", "还款银行", "出借人信息"));
        // fields.add(new ProductContractField("chu_jie_ren_repay_bank_name", "还款银行户名", "出借人信息"));
        // fields.add(new ProductContractField("chu_jie_ren_repay_bank_account", "还款银行账号", "出借人信息"));
        fields.add(new ProductContractField("chu_jie_ren_sign", "签名", "出借人信息"));
        fields.add(new ProductContractField("chu_jie_ren_seal", "公章", "出借人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_name", "姓名/公司名称", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_code", "身份证号/机构代码", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_phone", "电话", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_address", "通讯地址", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_addr_detail", "详细地址", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_email", "邮箱地址", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_fax", "传真号", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_sign", "签名", "抵押权人信息"));
        fields.add(new ProductContractField("di_ya_quan_ren_seal", "公章", "抵押权人信息"));
        fields.add(new ProductContractField("dan_bao_ren_name", "姓名/机构名称", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_code", "身份证号/机构代码", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_phone", "电话", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_address", "通讯地址", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_addr_detail", "详细地址", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_email", "邮箱地址", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_fax", "传真号", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_sign", "签名", "担保人信息"));
        fields.add(new ProductContractField("dan_bao_ren_seal", "公章", "担保人信息"));
        fields.add(new ProductContractField("ju_jian_ren_name", "姓名/公司名称", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_code", "身份证号/机构代码", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_phone", "电话", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_address", "通讯地址", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_addr_detail", "详细地址", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_store", "归属门店", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_email", "邮箱地址", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_fax", "传真号", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_sign", "签名", "居间人信息"));
        fields.add(new ProductContractField("ju_jian_ren_seal", "公章", "居间人信息"));
        fields.add(new ProductContractField("shou_quan_ren_name", "姓名/机构名称", "受权人信息"));
        fields.add(new ProductContractField("shou_quan_ren_code", "身份证号/机构代码", "受权人信息"));
        // fields.add(new ProductContractField("shou_quan_ren_data_source", "数据采集方", "受权人信息"));
        fields.add(new ProductContractField("shou_quan_ren_sign", "签名", "受权人信息"));
        fields.add(new ProductContractField("shou_quan_ren_seal", "公章", "受权人信息"));
        fields.add(new ProductContractField("current_date_year", "年", "当前信息"));
        fields.add(new ProductContractField("current_date_month", "月", "当前信息"));
        fields.add(new ProductContractField("current_date_day", "日", "当前信息"));
        fields.add(new ProductContractField("current_date_time", "时间", "当前信息"));
    }

    public void setSupportProduct(String supportProduct) {
        this.supportProduct = supportProduct;
    }
}
