package cn.sunfit.risk.buz.api.beans.p2p.order;

import java.util.Date;

import orj.worf.core.model.BaseObject;

/**
 * 
 * @Title: LoanInfo.java
 * @Package cn.sunfit.risk.buz.api.beans.p2p.order
 * @Description: TODO
 * @author RJS
 * @date 2017年5月5日 下午5:50:17
 * @version V1.0
 */
public class LoanInfoBean extends BaseObject {

    private static final long serialVersionUID = 8571615871445061547L;
    private Long id;

    /**
     * 订单ID
     */
    private String bpId;

    /**
     * 导入方式
     * 订单新增方式
     */
    private String importWay;

    /**
     * 发标平台的当前发标状态
     * 0为作废或则不启用状态，1为初始状态
     */
    private String aproveStatus = "1";

    /**
     * 订单来源
     * 标的来自于公司名
     */
    private String corporation;

    /**
     * 标的所在原始借款编号
     */
    private String thirdLoanId;

    /**
     * 标的在原始机构最新状态
     */
    private String thirdStatus;

    /**
     * 产品代码
     */
    private String productCode;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 借款用途
     */
    private String loanPurpose;

    /**
     * 借款期限
     */
    private String loanPeriod;

    /**
     * 客户类型
     * 个人，企业
     */
    private String customerType;

    /**
     * 借款金额 小数点后2位
     */
    private String loanMoney;

    /**
     * 借款日利率
     * 百分比 小数点后2位
     */
    private String loanDayRate;

    /**
     * 借款日管理费率
     * 百分比 小数点后2位
     */
    private String manageDayRate;

    /**
     * 其他费用
     * 单位元 小数点后2位
     */
    private String otherFee;

    /**
     * 实际放款金额
     * 单位元 小数点后2位
     */
    private String realFKMoney;

    /**
     * 还款方式
     */
    private String repayType;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 性别
     */
    private String gender;

    /**
     * 手机号
     */
    private String mobilePhoneOne;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 户口所在地 省
     */
    private String houseHoldProvince;

    /**
     * 户口所在地 市
     */
    private String houseHoldCity;

    /**
     * 户口所在地 区/县
     */
    private String houseHoldRegion;

    /**
     * 户口所在地详细地址
     */
    private String houseHoldDetail;

    /**
     * 婚姻状况
     */
    private String marriage;

    /**
     * 子女数
     */
    private String hasChild;

    /**
     * 毕业院校
     */
    private String graduateInstitutions;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 职业类型
     */
    private String jobType;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司地址-省
     */
    private String companyProvince;

    /**
     * 公司地址-市
     */
    private String companyCity;

    /**
     * 公司地址-区/县
     */
    private String companyRegion;

    /**
     * 公司详细地址
     */
    private String companyDetail;

    /**
     * 公司电话
     */
    private String companyTel;

    /**
     * 职位
     */
    private String jobTitle;

    /**
     * 最高学历
     */
    private String hightDegree;

    /**
     * 紧急联系人1
     */
    private String urgenOneName;

    /**
     * 紧急联系人1
     */
    private String urgenOnePhone;

    /**
     * 紧急联系人1关系
     */
    private String urgenOneRelation;

    /**
     * 紧急联系人1单位名称
     */
    private String urgenOneCompanyName;

    /**
     * 紧急联系人1是否知晓
     */
    private String urgenOneKnown;

    /**
     * 紧急联系人2姓名
     */
    private String urgenTwoName;

    /**
     * 紧急联系人2关系
     */
    private String urgenTwoRelation;

    /**
     * 紧急联系人2电话
     */
    private String urgenTwoPhone;

    /**
     * 紧急联系人2单位名称
     */
    private String urgenTwoCompanyName;

    /**
     * 紧急联系人2是否知悉
     */
    private String urgenTwoKnown;

    /**
     * 收款人姓名
     */
    private String receiversName;

    /**
     * 收款人银行账号
     */
    private String receiversBankAccount;

    /**
     * 收款银行
     */
    private String receiversBankName;

    /**
     * 收款银行省
     */
    private String receiversBankProvince;

    /**
     * 收款银行市
     */
    private String receiversBankCity;

    /**
     * 收款银行支行
     */
    private String receiversBankBranch;

    /**
     * 还款人姓名
     */
    private String repaymentName;

    /**
     * 还款人银行账号
     */
    private String repaymentBankAccount;

    /**
     * 还款银行
     */
    private String repaymentBankName;

    /**
     * 还款银行省
     */
    private String repaymentBankProvince;

    /**
     * 还款银行市
     */
    private String repaymentBankCity;

    /**
     * 还款银行支行
     */
    private String repaymentBankBranch;

    /**
     * 借款性质
     * 新增，结清再贷，展期
     */
    private String loanHandleType;

    /**
     * 录单人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 导入编号
     */
    private String importCode;

    /**
     * 是否天标
     */
    private String isDaylyTrem;

    /**
     * GPS安装费
     */
    private String gpsInstallationFee;

    /**
     * GPS服务费
     */
    private String gpsServiceFee;

    /**
     * 停车费
     */
    private String parkFee;

    /**
     * 综合月利率
     */
    private String zhMonthlyRate;

    /**
     * 违约率
     */
    private String wyRate;

    /**
     * 滞纳金率
     */
    private String znRate;

    /**
     * 保证金率
     */
    private String bzRate;

    /**
     * 咨询费率
     */
    private String consultingRate;

    public String getAproveStatus() {
        return aproveStatus;
    }

    public String getBpId() {
        return bpId;
    }

    public String getBzRate() {
        return bzRate;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getCompanyCity() {
        return companyCity;
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyProvince() {
        return companyProvince;
    }

    public String getCompanyRegion() {
        return companyRegion;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public String getConsultingRate() {
        return consultingRate;
    }

    public String getCorporation() {
        return corporation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getGender() {
        return gender;
    }

    public String getGpsInstallationFee() {
        return gpsInstallationFee;
    }

    public String getGpsServiceFee() {
        return gpsServiceFee;
    }

    public String getGraduateInstitutions() {
        return graduateInstitutions;
    }

    public String getHasChild() {
        return hasChild;
    }

    public String getHightDegree() {
        return hightDegree;
    }

    public String getHouseHoldCity() {
        return houseHoldCity;
    }

    public String getHouseHoldDetail() {
        return houseHoldDetail;
    }

    public String getHouseHoldProvince() {
        return houseHoldProvince;
    }

    public String getHouseHoldRegion() {
        return houseHoldRegion;
    }

    public Long getId() {
        return id;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getImportCode() {
        return importCode;
    }

    public String getImportWay() {
        return importWay;
    }

    public String getIsDaylyTrem() {
        return isDaylyTrem;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getJobType() {
        return jobType;
    }

    public String getLoanDayRate() {
        return loanDayRate;
    }

    public String getLoanHandleType() {
        return loanHandleType;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public String getManageDayRate() {
        return manageDayRate;
    }

    public String getMarriage() {
        return marriage;
    }

    public String getMobilePhoneOne() {
        return mobilePhoneOne;
    }

    public String getOtherFee() {
        return otherFee;
    }

    public String getParkFee() {
        return parkFee;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public String getRealFKMoney() {
        return realFKMoney;
    }

    public String getReceiversBankAccount() {
        return receiversBankAccount;
    }

    public String getReceiversBankBranch() {
        return receiversBankBranch;
    }

    public String getReceiversBankCity() {
        return receiversBankCity;
    }

    public String getReceiversBankName() {
        return receiversBankName;
    }

    public String getReceiversBankProvince() {
        return receiversBankProvince;
    }

    public String getReceiversName() {
        return receiversName;
    }

    public String getRepaymentBankAccount() {
        return repaymentBankAccount;
    }

    public String getRepaymentBankBranch() {
        return repaymentBankBranch;
    }

    public String getRepaymentBankCity() {
        return repaymentBankCity;
    }

    public String getRepaymentBankName() {
        return repaymentBankName;
    }

    public String getRepaymentBankProvince() {
        return repaymentBankProvince;
    }

    public String getRepaymentName() {
        return repaymentName;
    }

    public String getRepayType() {
        return repayType;
    }

    public String getThirdLoanId() {
        return thirdLoanId;
    }

    public String getThirdStatus() {
        return thirdStatus;
    }

    public String getUrgenOneCompanyName() {
        return urgenOneCompanyName;
    }

    public String getUrgenOneKnown() {
        return urgenOneKnown;
    }

    public String getUrgenOneName() {
        return urgenOneName;
    }

    public String getUrgenOnePhone() {
        return urgenOnePhone;
    }

    public String getUrgenOneRelation() {
        return urgenOneRelation;
    }

    public String getUrgenTwoCompanyName() {
        return urgenTwoCompanyName;
    }

    public String getUrgenTwoKnown() {
        return urgenTwoKnown;
    }

    public String getUrgenTwoName() {
        return urgenTwoName;
    }

    public String getUrgenTwoPhone() {
        return urgenTwoPhone;
    }

    public String getUrgenTwoRelation() {
        return urgenTwoRelation;
    }

    public String getWyRate() {
        return wyRate;
    }

    public String getZhMonthlyRate() {
        return zhMonthlyRate;
    }

    public String getZnRate() {
        return znRate;
    }

    public void setAproveStatus(String aproveStatus) {
        this.aproveStatus = aproveStatus;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public void setBzRate(String bzRate) {
        this.bzRate = bzRate;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public void setCompanyCity(String companyCity) {
        this.companyCity = companyCity;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyProvince(String companyProvince) {
        this.companyProvince = companyProvince;
    }

    public void setCompanyRegion(String companyRegion) {
        this.companyRegion = companyRegion;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public void setConsultingRate(String consultingRate) {
        this.consultingRate = consultingRate;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGpsInstallationFee(String gpsInstallationFee) {
        this.gpsInstallationFee = gpsInstallationFee;
    }

    public void setGpsServiceFee(String gpsServiceFee) {
        this.gpsServiceFee = gpsServiceFee;
    }

    public void setGraduateInstitutions(String graduateInstitutions) {
        this.graduateInstitutions = graduateInstitutions;
    }

    public void setHasChild(String hasChild) {
        this.hasChild = hasChild;
    }

    public void setHightDegree(String hightDegree) {
        this.hightDegree = hightDegree;
    }

    public void setHouseHoldCity(String houseHoldCity) {
        this.houseHoldCity = houseHoldCity;
    }

    public void setHouseHoldDetail(String houseHoldDetail) {
        this.houseHoldDetail = houseHoldDetail;
    }

    public void setHouseHoldProvince(String houseHoldProvince) {
        this.houseHoldProvince = houseHoldProvince;
    }

    public void setHouseHoldRegion(String houseHoldRegion) {
        this.houseHoldRegion = houseHoldRegion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public void setImportWay(String importWay) {
        this.importWay = importWay;
    }

    public void setIsDaylyTrem(String isDaylyTrem) {
        this.isDaylyTrem = isDaylyTrem;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setLoanDayRate(String loanDayRate) {
        this.loanDayRate = loanDayRate;
    }

    public void setLoanHandleType(String loanHandleType) {
        this.loanHandleType = loanHandleType;
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    public void setLoanPurpose(String loanPurpose) {
        this.loanPurpose = loanPurpose;
    }

    public void setManageDayRate(String manageDayRate) {
        this.manageDayRate = manageDayRate;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public void setMobilePhoneOne(String mobilePhoneOne) {
        this.mobilePhoneOne = mobilePhoneOne;
    }

    public void setOtherFee(String otherFee) {
        this.otherFee = otherFee;
    }

    public void setParkFee(String parkFee) {
        this.parkFee = parkFee;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setRealFKMoney(String realFKMoney) {
        this.realFKMoney = realFKMoney;
    }

    public void setReceiversBankAccount(String receiversBankAccount) {
        this.receiversBankAccount = receiversBankAccount;
    }

    public void setReceiversBankBranch(String receiversBankBranch) {
        this.receiversBankBranch = receiversBankBranch;
    }

    public void setReceiversBankCity(String receiversBankCity) {
        this.receiversBankCity = receiversBankCity;
    }

    public void setReceiversBankName(String receiversBankName) {
        this.receiversBankName = receiversBankName;
    }

    public void setReceiversBankProvince(String receiversBankProvince) {
        this.receiversBankProvince = receiversBankProvince;
    }

    public void setReceiversName(String receiversName) {
        this.receiversName = receiversName;
    }

    public void setRepaymentBankAccount(String repaymentBankAccount) {
        this.repaymentBankAccount = repaymentBankAccount;
    }

    public void setRepaymentBankBranch(String repaymentBankBranch) {
        this.repaymentBankBranch = repaymentBankBranch;
    }

    public void setRepaymentBankCity(String repaymentBankCity) {
        this.repaymentBankCity = repaymentBankCity;
    }

    public void setRepaymentBankName(String repaymentBankName) {
        this.repaymentBankName = repaymentBankName;
    }

    public void setRepaymentBankProvince(String repaymentBankProvince) {
        this.repaymentBankProvince = repaymentBankProvince;
    }

    public void setRepaymentName(String repaymentName) {
        this.repaymentName = repaymentName;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType;
    }

    public void setThirdLoanId(String thirdLoanId) {
        this.thirdLoanId = thirdLoanId;
    }

    public void setThirdStatus(String thirdStatus) {
        this.thirdStatus = thirdStatus;
    }

    public void setUrgenOneCompanyName(String urgenOneCompanyName) {
        this.urgenOneCompanyName = urgenOneCompanyName;
    }

    public void setUrgenOneKnown(String urgenOneKnown) {
        this.urgenOneKnown = urgenOneKnown;
    }

    public void setUrgenOneName(String urgenOneName) {
        this.urgenOneName = urgenOneName;
    }

    public void setUrgenOnePhone(String urgenOnePhone) {
        this.urgenOnePhone = urgenOnePhone;
    }

    public void setUrgenOneRelation(String urgenOneRelation) {
        this.urgenOneRelation = urgenOneRelation;
    }

    public void setUrgenTwoCompanyName(String urgenTwoCompanyName) {
        this.urgenTwoCompanyName = urgenTwoCompanyName;
    }

    public void setUrgenTwoKnown(String urgenTwoKnown) {
        this.urgenTwoKnown = urgenTwoKnown;
    }

    public void setUrgenTwoName(String urgenTwoName) {
        this.urgenTwoName = urgenTwoName;
    }

    public void setUrgenTwoPhone(String urgenTwoPhone) {
        this.urgenTwoPhone = urgenTwoPhone;
    }

    public void setUrgenTwoRelation(String urgenTwoRelation) {
        this.urgenTwoRelation = urgenTwoRelation;
    }

    public void setWyRate(String wyRate) {
        this.wyRate = wyRate;
    }

    public void setZhMonthlyRate(String zhMonthlyRate) {
        this.zhMonthlyRate = zhMonthlyRate;
    }

    public void setZnRate(String znRate) {
        this.znRate = znRate;
    }

}
