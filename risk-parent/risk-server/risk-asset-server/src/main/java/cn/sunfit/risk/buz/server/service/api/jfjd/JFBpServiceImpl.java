package cn.sunfit.risk.buz.server.service.api.jfjd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFBPAttrValue;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCorpUserDTO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCustomerAddDTO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFIdNameVO;
import cn.sunfit.risk.buz.api.beans.api.jfjd.JFMetaDTO;
import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.constants.loan.LoanChannel;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFBpService;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCustomerService;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFProductService;
import cn.sunfit.risk.buz.api.service.solution.SuperFormService;
import cn.sunfit.risk.buz.api.vo.api.jfjd.JFBpStatusGetReq;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.solution.dyc.DycFeeConfig;
import cn.sunfit.risk.buz.api.vo.solution.dyc.RepaymentType;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFBPDAO;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFProductDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.repayment.RepaymentBaseDAO;
import cn.sunfit.risk.buz.server.util.api.jfjd.JFUtil;
import cn.sunfit.risk.buz.server.util.api.jfjd.event.BpStatusChangeEvent;

@Service("jfjd.bpService")
public class JFBpServiceImpl implements JFBpService {
    @Autowired
    private JFCustomerService jFCustomerService;
    @Autowired
    private SuperFormService superFormService;
    @Autowired
    private JFProductService jfProductService;
    @Autowired
    private JFProductDAO jFProductDAO;
    @Autowired
    private JFBPDAO jFBPDAO;
    @Autowired
    RepaymentBaseDAO repaymentBaseDAO;
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private BPDAO bpdao;

    @Override
    public long countBpById(String loanId, String domain) {
        long count = jFBPDAO.countBpById(loanId, domain);
        return count;
    }

    private Map<String, String> getFormData(FormQuery q, JFBPAttrValue a) {
        Map<String, String> formdata = new HashMap<String, String>();
        formdata.put("loan_mort_type", a.getBuzSubType());// 抵押类型
        formdata.put("loan_usage", a.getLoanPurposes());// 借款用途
        formdata.put("loan_usage_other", a.getLoanPurposesOther());// 借款用途其他
        formdata.put("loan_apply_amount", a.getLoanMoney());// 借款金额
        formdata.put("loan_apply_repaymentTypes", a.getLoanType());// 还款方式
        formdata.put("loan_apply_monthlyTerm", a.getInstallment());// 贷款期限
        String config = jFProductDAO.selectFeeConfigById(a.getProdType());
        try {
            DycFeeConfig c = JsonUtils.parseJSON(config, DycFeeConfig.class);
            formdata.put("loan_apply_eachTimes", c.getEachTimes().get(0).getEachTime());// 期长
            for (RepaymentType t : c.getRepaymentTypes()) {
                if (StringUtils.equals(t.getRepaymentType(), a.getLoanType())) {
                    formdata.put("loan_apply_supportFirstPay", t.getSupportFirstPay().get(0).getPayType());// 首付款支付方式
                }
            }
            List<JFIdNameVO> ys = jfProductService.queryPartnerByProductId(a.getProdType(), q.getDomain(), "3");
            formdata.put("loan_mortgage_user", ys.get(0).getId());// 抵押权人
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("产品配置出错");
        }

        formdata.put("cust_type", "0");// 客户类型
        formdata.put("cust_name", a.getCardName());// 客户姓名
        formdata.put("cust_gender", a.getSex());// 客户性别
        formdata.put("cust_license_num", a.getCardNo());// 客户身份证
        formdata.put("cust_idcard_ver", a.getCardExpireDate());// 身份证有效期
        formdata.put("cust_marriage", a.getMaritalStatus());// 婚姻状况
        formdata.put("cust_child_count", null);// 子女数
        formdata.put("cust_support_num", null);// 供养人数
        formdata.put("cust_house_spending", null);// 每月家庭支出
        formdata.put("cust_education", a.getEducation());// 学历
        formdata.put("cust_mobile", a.getMobileNo());// 手机号1
        formdata.put("cust_mobile2", null);// 手机号2
        formdata.put("cust_email", a.getEmail());// 邮箱
        formdata.put("cust_qq", a.getQq());// qq
        formdata.put("cust_wechat", a.getWeixin());// WX
        formdata.put("cust_phone", a.getPhone());// 住宅电话
        formdata.put("cust_house_time", JFUtil.getDateStr(a.getSettledFrom()));// 现住址入住时间
        formdata.put("cust_house_type", a.getLivingType());// 现住址类别
        formdata.put("cust_come_time", JFUtil.getDateStr(a.getMoveToDate()));// 来本市时间
        formdata.put("cust_regist_addr", a.getCardAddr());// 户口所在地
        formdata.put("cust_regist_addr_province", JFUtil.getAddrProvince(a.getCardAddr()));// 户口所在地
        formdata.put("cust_regist_addr_city", JFUtil.getAddrCity(a.getCardAddr()));// 户口所在地
        formdata.put("cust_regist_addr_counties", JFUtil.getAddrCounties(a.getCardAddr()));// 户口所在地
        formdata.put("cust_regist_addr_detail", JFUtil.getAddrDetail(a.getCardAddr()));// 户口所在地
        formdata.put("cust_live_addr", a.getAddress());// 现住址
        formdata.put("cust_live_addr_province", JFUtil.getAddrProvince(a.getAddress()));// 现住址
        formdata.put("cust_live_addr_city", JFUtil.getAddrCity(a.getAddress()));// 现住址
        formdata.put("cust_live_addr_counties", JFUtil.getAddrCounties(a.getAddress()));// 现住址
        formdata.put("cust_live_addr_detail", JFUtil.getAddrDetail(a.getAddress()));// 现住址

        formdata.put("custimg_idcard1", a.getCardFrontRsrcIds());// 身份证正
        formdata.put("custimg_idcard2", a.getCardBackRsrcIds());// 身份证反

        formdata.put("custjob_industry", null);// 所属行业
        formdata.put("custjob_job_lvl", null);// 职位
        formdata.put("custjob_company_type", null);// 单位性质
        formdata.put("custjob_company_name", a.getCompanyName());// 单位名称
        formdata.put("custjob_dept_name", a.getCompanyDepartment());// 所在部门/科室
        formdata.put("custjob_entry_time", JFUtil.getDateStr(a.getCompanyJoinDate()));// 入职时间
        formdata.put("custjob_salary", JFUtil.getDecimalStr(a.getCompanySalary()));// 月均工资
        formdata.put("custjob_salary_date", JFUtil.getIntegerStr(a.getCompanyPayDate()));// 每月发薪日
        formdata.put("custjob_salary_type", a.getCompanyPaymentMethod());// 工资发放形式
        formdata.put("custjob_company_phone", a.getCompanyPhone());// 单位电话
        formdata.put("custjob_company_addr", a.getCompanyAddr());// 单位地址
        formdata.put("custjob_company_addr_province", JFUtil.getAddrProvince(a.getCompanyAddr()));// 单位地址
        formdata.put("custjob_company_addr_city", JFUtil.getAddrCity(a.getCompanyAddr()));// 单位地址
        formdata.put("custjob_company_addr_counties", JFUtil.getAddrCounties(a.getCompanyAddr()));// 单位地址
        formdata.put("custjob_company_addr_detail", JFUtil.getAddrDetail(a.getCompanyAddr()));// 单位地址
        formdata.put("custjob_technical_title", a.getCompanyJob());// 职称

        formdata.put("custearn_security_fund", a.getWorkProve1RsrcIds());// 社保/公积金流水
        formdata.put("custearn_bank_bill", a.getWorkProve2RsrcIds());// 银行流水
        formdata.put("custearn_credit_report", a.getCreditReportRsrcIds());// 央行征信报告

        formdata.put("custfriend_spouse_name", a.getRelativeName());// 配偶姓名
        formdata.put("custfriend_mobile", a.getRelativePhone());// 移动电话
        formdata.put("custfriend_company_name", a.getRelativeWorkUnit());// 单位名称

        formdata.put("custfriend_direct_relation", null);// 直系关系
        formdata.put("custfriend_friend_name", a.getImmediateName());// 亲属/朋友姓名
        formdata.put("custfriend_friend_mobile", a.getImmediatePhone());// 移动电话
        formdata.put("custfriend_friend_company_name", a.getImmediateWorkUnit());// 单位名称

        formdata.put("custfriend_other_relation", null);// 其他关系
        formdata.put("custfriend_other_name", null);// 亲属/朋友姓名
        formdata.put("custfriend_other_mobile", null);// 移动电话
        formdata.put("custfriend_other_company_name", null);// 单位名称
        formdata.put("custfriend_friend_know", a.getRelativeKnown());// 家人是否知晓此借款

        formdata.put("loancar_license_plate", a.getCarCardPlateNo());// 车牌号码
        formdata.put("loancar_engine_number", a.getCarCardVen());// 发动机号
        formdata.put("loancar_frame_number", a.getCarCardVin());// 车架号
        formdata.put("loancar_car_bms", a.getCarBrand() + " " + a.getCarSeries() + " " + a.getCarModel());
        formdata.put("loancar_car_bms_brand", a.getCarBrand());// 车牌
        formdata.put("loancar_car_bms_model", a.getCarModel());// 车系
        formdata.put("loancar_car_bms_series", a.getCarSeries());// 车型
        formdata.put("loancar_car_type", a.getCarCardType());// 车辆类型
        formdata.put("loancar_car_color", null);// 车身颜色
        formdata.put("loancar_car_fuel", null);// 燃料种类
        formdata.put("loancar_purchase_price", a.getCarPurchasePrice());// 购买价格
        formdata.put("loancar_purchase_date", JFUtil.getDateStr(a.getCarPurchaseDate()));// 购车日期
        formdata.put("loancar_registration_date", JFUtil.getDateStr(a.getCar1stRegDate()));// 初次登记日期
        formdata.put("loancar_approved_passenger", null);// 核定载客
        formdata.put("loancar_driving_position", null);// 驾驶位置
        formdata.put("loancar_ownership", a.getCarOwnership());// 车辆归属
        formdata.put("loancar_yearcount", a.getCarTimes());// 1年内抵押，质押和过户次数

        formdata.put("loancarimg_drive_license", a.getCarCardRsrcIds());// 行驶证主页
        formdata.put("loancarimg_drive_license_fu", a.getCarCardVicePageRsrcIds());// 行驶证副页
        formdata.put("loancarimg_vehicle_registration", a.getCarRegistrationRsrcIds());// 车辆登记证书
        formdata.put("loancarimg_compulsory_insurance", a.getCompulsoryInsuranceRsrcIds());// 交强险保单合同
        formdata.put("loancarimg_business_insurance", a.getCommercialInsuranceRsrcIds());// 商业险保单合同
        formdata.put("loancarimg_insurance_policy", null);// 车辆保险单
        formdata.put("loancarimg_front", null);// 车辆正面照
        formdata.put("loancarimg_car_owner", a.getCarPhoto1RsrcIds());// 车主与车辆合照
        formdata.put("loancarimg_front_45", a.getCarPhoto2RsrcIds());// 车前45度照
        formdata.put("loancarimg_back", a.getCarPhoto3RsrcIds());// 正后照
        formdata.put("loancarimg_inside", null);// 机仓照
        formdata.put("loancarimg_back_box", a.getCarPhoto4RsrcIds());// 后尾箱照
        formdata.put("loancarimg_main_door", a.getCarPhoto5RsrcIds());// 主驾门叶照
        formdata.put("loancarimg_main_drive_side", a.getCarPhoto6RsrcIds());// 主驾驶侧照
        formdata.put("loancarimg_main_drive", a.getCarPhoto7RsrcIds());// 主驾驶正照
        formdata.put("loancarimg_wheel_left", a.getCarPhoto8RsrcIds());// 左方向盘照
        formdata.put("loancarimg_wheel_right", a.getCarPhoto9RsrcIds());// 右方向盘照
        formdata.put("loancarimg_back_interior", a.getCarPhoto10RsrcIds());// 后内饰照
        formdata.put("loancarimg_front_glass", null);// 前挡风玻璃码照
        formdata.put("loancarimg_main_drive_glass", null);// 主驾前玻璃码照
        formdata.put("loancarimg_copilot_drive_glass", null);// 副驾后玻璃码照
        formdata.put("loancarimg_instrument_panel", a.getCarPhoto11RsrcIds());// 仪表盘照
        formdata.put("loancarimg_nameplate", a.getCarPhoto12RsrcIds());// 铭牌照
        formdata.put("loancarimg_video", null);// 车辆视频
        formdata.put("loancarimg_other", null);// 其他

        formdata.put("loanasseth_has", a.getHasHouse());// 是否有房产
        formdata.put("loanasseth_type", null);// 房产类型
        formdata.put("loanasseth_ownership", null);// 房产所有权
        formdata.put("loanasseth_valuation", null);// 房屋估值
        formdata.put("loanasseth_address", a.getHouseAddr());// 房产地址
        formdata.put("loanasseth_address_province", JFUtil.getAddrProvince(a.getHouseAddr()));// 房产地址
        formdata.put("loanasseth_address_city", JFUtil.getAddrCity(a.getHouseAddr()));// 房产地址
        formdata.put("loanasseth_address_counties", JFUtil.getAddrCounties(a.getHouseAddr()));// 房产地址
        formdata.put("loanasseth_address_detail", JFUtil.getAddrDetail(a.getHouseAddr()));// 房产地址
        formdata.put("loanasseth_status", a.getHouseStatus());// 当前房产状态

        formdata.put("loanassethimg_owner_certificate", a.getHouse1RsrcIds());// 房产证
        formdata.put("loanassethimg_purchase_contract", a.getHouse4RsrcIds());// 房屋购房合同
        formdata.put("loanassethimg_month_certificate", a.getHouse2RsrcIds());// 近一个月房产查档证明
        formdata.put("loanassethimg_mortgage_contract", a.getHouse3RsrcIds());// 抵押贷款合同
        return formdata;

    }

    @Override
    public void sendNoticeToJF(String corpId, String domain, String bpId) {
        BP bp = bpdao.findById(corpId, domain, bpId);
        Integer status = repaymentBaseDAO.selectStatusByBp(new JFBpStatusGetReq(bpId, domain));
        applicationContext.publishEvent(new BpStatusChangeEvent(this, domain, "1", bp.getChannel(), bpId, bp
                .getCurrentTaskName(), "", (int) bp.getBpStatus(), status, ""));
    }

    @Override
    @Transactional(rollbackFor = Exception.class, timeout = 300)
    public String submitOrder(JFCorpUserDTO user, JFBPAttrValue attrValue) throws ServiceException {
        JFCustomerAddDTO customer = attrValue.copyToAddCustDTO();
        // 查询当前用户的信息
        customer.setCorpId(user.getCorpId());
        customer.setDomain(user.getDomain());
        customer.setUid(user.getId());
        String customerid = jFCustomerService.insertCustomer(customer);
        FormQuery q = new FormQuery();
        JFMetaDTO meta = jfProductService.queryMeta(attrValue.getProdType(), user.getDomain());
        q.setBpDefId(meta.getBpDefId());
        q.setBpDefKey(meta.getBpDefKey());
        q.setBpId(attrValue.getSaasLoanId());
        q.setCorpId(user.getCorpId());
        q.setCustomerId(customerid);
        q.setDeptId(user.getDeptId());
        q.setDomain(user.getDomain());
        q.setProductId(attrValue.getProdType());
        q.setUserId(user.getId());
        q.setUserName(user.getUserName());
        q.setView(false);
        q.setChannel(LoanChannel.JFJD.getStatus());
        BP bp = superFormService.submit(q, getFormData(q, attrValue));
        if (bp != null) {
            if (StringUtils.isNotBlank(bp.getCurrentTaskName())) {
                return bp.getCurrentTaskName().substring(1, bp.getCurrentTaskName().length() - 1);
            }
        }
        return null;
    }
}
