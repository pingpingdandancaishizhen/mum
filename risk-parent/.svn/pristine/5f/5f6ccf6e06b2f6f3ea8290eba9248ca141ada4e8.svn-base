package cn.sunfit.risk.buz.api.beans.api.jfjd;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import orj.worf.core.model.BaseObject;
import cn.sunfit.risk.buz.api.constants.customer.CustomerStatus;

public class JFBPAttrValue extends BaseObject {
    private static final long serialVersionUID = 1L;

    private String loanId;

    private String userId;

    private String appVersion;

    private String platform;

    private String orgId;

    private String prodType;

    private String status;

    private String loanMoney;

    private String installment;

    private String loanType;

    private String job;

    private String loanPurposes;

    private String loanPurposesOther;

    private String buzSubType;

    private String cardName;

    private String sex;

    private String birthday;

    private String age;

    private String cardNo;

    private String cardExpireDate;

    private String cardAddr;

    // 婚姻状况
    private String maritalStatus;

    private String education;

    private String mobileNo;

    private String phone;

    private String email;

    private String qq;

    private String weixin;

    private String address;

    private Date moveToDate;

    private Date settledFrom;

    private String livingType;

    private String hasHouse;

    private String houseAddr;

    private String houseStatus;

    private String carCardPlateNo;

    private String carCardBrand;

    private Date carCardRegDate;

    private Date carCardPublishDate;

    private String carCardVin;

    private String carCardVen;

    private String carCardType;

    private String carBrand;

    private String carSeries;

    private String carModel;

    private String carOwnership;

    private Date carPurchaseDate;

    private Date car1stRegDate;

    private String carPurchasePrice;

    private String carTimes;

    private String companyName;

    private String companyAddr;

    private String companyPhone;

    private String companyJob;

    private String companyDepartment;

    private Date companyJoinDate;

    private BigDecimal companySalary;

    private Integer companyPayDate;

    private String companyPaymentMethod;

    private String enterpriseName;

    private String enterpriseAddr;

    private String enterprisePhone;

    private Date enterpriseRegDate;

    private BigDecimal enterpriseMonthlyTurnover;

    private String freelanceSource;

    private Long freelanceSalary;

    private String relativeName;

    private String relativePhone;

    private String relativeWorkUnit;

    private String relativeKnown;

    private String immediateName; // 直系亲属姓名

    private String immediatePhone;// 直系亲属电话

    private String immediateWorkUnit;// 直系亲属工作单位

    private String saasLoanId;

    private String comment;

    private BigDecimal loanQuota;

    private String loanPeriod;

    private Integer createDate;

    private Integer updateTime;

    private String cardFrontRsrcIds;// 身份证正面

    private String cardBackRsrcIds;// 身份证反面

    private String carCardRsrcIds;// 驾驶证
    private String carCardVicePageRsrcIds;// 驾驶证副业

    private String house1RsrcIds;// 房产证和近1个月物业名下的水费单/电费单/燃气费单

    private String house2RsrcIds;// 近一个月内的房产查档证明

    private String house3RsrcIds;// 抵押贷款合同和最近3个月的抵押还款流水

    private String house4RsrcIds; // 房屋购房合同和最近3个月的抵押还款流水

    private String carRegistrationRsrcIds; // 车辆登记证

    private String compulsoryInsuranceRsrcIds;// 交强险保单

    private String commercialInsuranceRsrcIds; // 商业险保单

    private String workProve1RsrcIds;// 社保/公积金近6个月缴纳明细

    private String workProve2RsrcIds;// 个人近6个月银行流水

    private String creditReportRsrcIds; // 央行征信报告

    private String saasUid;// 乐贷用户ID

    private String carPhoto1RsrcIds; // 车主与车辆合照

    private String carPhoto2RsrcIds; // 车前45度照

    private String carPhoto3RsrcIds; // 正后照

    private String carPhoto4RsrcIds; // 后尾厢照

    private String carPhoto5RsrcIds; // 主驾门叶照

    private String carPhoto6RsrcIds; // 主驾驶侧照

    private String carPhoto7RsrcIds; // 主驾驶正照

    private String carPhoto8RsrcIds; // 左方向盘照

    private String carPhoto9RsrcIds; // 右方向盘照

    private String carPhoto10RsrcIds; // 后内饰照

    private String carPhoto11RsrcIds; // 仪表盘照

    private String carPhoto12RsrcIds; // 铭牌照

    public JFCustomerAddDTO copyToAddCustDTO() {
        JFCustomerAddDTO dto = new JFCustomerAddDTO();
        // dto.setId(IdUtil.geneId());
        // dto.setCorpId();
        // dto.setUid();
        // dto.setType();
        dto.setName(cardName);
        dto.setGender(sex);
        dto.setLicenseNum(cardNo);
        dto.setMaritalStatus(maritalStatus);
        // dto.setChildCount();
        // dto.setSupportNum();
        // 家庭支出
        // dto.setHouseSpending();
        dto.setEducation(education);
        dto.setMobile(mobileNo);
        // dto.setMobile2();
        dto.setEmail(email);
        dto.setQq(qq);
        dto.setWechat(weixin);
        dto.setPhone(phone);
        // 入住时间
        dto.setHouseTime(settledFrom);
        // 住宅类型
        dto.setHouseType(livingType);
        dto.setComeTime(moveToDate);
        if (StringUtils.isNotBlank(cardAddr)) {
            dto.setRegistAddr(cardAddr.substring(0, cardAddr.lastIndexOf("/")));
            dto.setRegistAddrDetail(cardAddr.substring(cardAddr.lastIndexOf("/") + 1, cardAddr.length()));
        } else {
            dto.setRegistAddr("");
            dto.setRegistAddrDetail("");
        }
        if (StringUtils.isNotBlank(address)) {
            dto.setLiveAddr(address.substring(0, address.lastIndexOf("/")));
            dto.setLiveAddrDetail(address.substring(address.lastIndexOf("/") + 1, address.length()));
        } else {
            dto.setLiveAddr("");
            dto.setLiveAddrDetail("");
        }
        // 行业
        // dto.setIndustry();
        // 公司性质
        // dto.setCompanyType();
        dto.setCompanyName(companyName);
        // dto.setDeptName();
        // 职位级别
        // dto.setJob();
        dto.setEntryTime(companyJoinDate);
        dto.setSalary(companySalary);
        dto.setSalaryDate(companyPayDate);
        dto.setSalaryType(companyPaymentMethod);
        dto.setCompanyPhone(companyPhone);
        dto.setType("0");
        if (StringUtils.isNotBlank(companyAddr)) {
            dto.setCompanyAddr(companyAddr.substring(0, companyAddr.lastIndexOf("/")));
            dto.setCompanyAddrDetail(companyAddr.substring(companyAddr.lastIndexOf("/") + 1, companyAddr.length()));
        } else {
            dto.setCompanyAddr("");
            dto.setCompanyAddrDetail("");
        }
        dto.setStatus(CustomerStatus.CREATE.getStatus());
        dto.setCreateTime(new Date());
        dto.setUpdateTime(new Date());
        dto.setIdCardFront(cardFrontRsrcIds);
        dto.setIdCardBack(cardBackRsrcIds);
        return dto;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBuzSubType() {
        return buzSubType;
    }

    public Date getCar1stRegDate() {
        return car1stRegDate;
    }

    public String getCarBrand() {
        if (carBrand == null) {
            return "";
        }
        return carBrand;
    }

    public String getCarCardBrand() {
        return carCardBrand;
    }

    public String getCarCardPlateNo() {
        return carCardPlateNo;
    }

    public Date getCarCardPublishDate() {
        return carCardPublishDate;
    }

    public Date getCarCardRegDate() {
        return carCardRegDate;
    }

    public String getCarCardRsrcIds() {
        return carCardRsrcIds;
    }

    public String getCarCardType() {
        return carCardType;
    }

    public String getCarCardVen() {
        return carCardVen;
    }

    public String getCarCardVicePageRsrcIds() {
        return carCardVicePageRsrcIds;
    }

    public String getCarCardVin() {
        return carCardVin;
    }

    public String getCardAddr() {
        return cardAddr;
    }

    public String getCardBackRsrcIds() {
        return cardBackRsrcIds;
    }

    public String getCardExpireDate() {
        return cardExpireDate;
    }

    public String getCardFrontRsrcIds() {
        return cardFrontRsrcIds;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public String getCarModel() {
        if (carModel == null) {
            return "";
        }
        return carModel;
    }

    public String getCarOwnership() {
        return carOwnership;
    }

    public String getCarPhoto10RsrcIds() {
        return carPhoto10RsrcIds;
    }

    public String getCarPhoto11RsrcIds() {
        return carPhoto11RsrcIds;
    }

    public String getCarPhoto12RsrcIds() {
        return carPhoto12RsrcIds;
    }

    public String getCarPhoto1RsrcIds() {
        return carPhoto1RsrcIds;
    }

    public String getCarPhoto2RsrcIds() {
        return carPhoto2RsrcIds;
    }

    public String getCarPhoto3RsrcIds() {
        return carPhoto3RsrcIds;
    }

    public String getCarPhoto4RsrcIds() {
        return carPhoto4RsrcIds;
    }

    public String getCarPhoto5RsrcIds() {
        return carPhoto5RsrcIds;
    }

    public String getCarPhoto6RsrcIds() {
        return carPhoto6RsrcIds;
    }

    public String getCarPhoto7RsrcIds() {
        return carPhoto7RsrcIds;
    }

    public String getCarPhoto8RsrcIds() {
        return carPhoto8RsrcIds;
    }

    public String getCarPhoto9RsrcIds() {
        return carPhoto9RsrcIds;
    }

    public Date getCarPurchaseDate() {
        return carPurchaseDate;
    }

    public String getCarPurchasePrice() {
        return carPurchasePrice;
    }

    public String getCarRegistrationRsrcIds() {
        return carRegistrationRsrcIds;
    }

    public String getCarSeries() {
        if (carSeries == null) {
            return "";
        }
        return carSeries;
    }

    public String getCarTimes() {
        return carTimes;
    }

    public String getComment() {
        return comment;
    }

    public String getCommercialInsuranceRsrcIds() {
        return commercialInsuranceRsrcIds;
    }

    public String getCompanyAddr() {
        return companyAddr;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public String getCompanyJob() {
        return companyJob;
    }

    public Date getCompanyJoinDate() {
        return companyJoinDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Integer getCompanyPayDate() {
        return companyPayDate;
    }

    public String getCompanyPaymentMethod() {
        return companyPaymentMethod;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public BigDecimal getCompanySalary() {
        return companySalary;
    }

    public String getCompulsoryInsuranceRsrcIds() {
        return compulsoryInsuranceRsrcIds;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public String getCreditReportRsrcIds() {
        return creditReportRsrcIds;
    }

    public String getEducation() {
        return education;
    }

    public String getEmail() {
        return email;
    }

    public String getEnterpriseAddr() {
        return enterpriseAddr;
    }

    public BigDecimal getEnterpriseMonthlyTurnover() {
        return enterpriseMonthlyTurnover;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public Date getEnterpriseRegDate() {
        return enterpriseRegDate;
    }

    public Long getFreelanceSalary() {
        return freelanceSalary;
    }

    public String getFreelanceSource() {
        return freelanceSource;
    }

    public String getHasHouse() {
        return hasHouse;
    }

    public String getHouse1RsrcIds() {
        return house1RsrcIds;
    }

    public String getHouse2RsrcIds() {
        return house2RsrcIds;
    }

    public String getHouse3RsrcIds() {
        return house3RsrcIds;
    }

    public String getHouse4RsrcIds() {
        return house4RsrcIds;
    }

    public String getHouseAddr() {
        return houseAddr;
    }

    public String getHouseStatus() {
        return houseStatus;
    }

    public String getImmediateName() {
        return immediateName;
    }

    public String getImmediatePhone() {
        return immediatePhone;
    }

    public String getImmediateWorkUnit() {
        return immediateWorkUnit;
    }

    public String getInstallment() {
        return installment;
    }

    public String getJob() {
        return job;
    }

    public String getLivingType() {
        return livingType;
    }

    public String getLoanId() {
        return loanId;
    }

    public String getLoanMoney() {
        return loanMoney;
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public String getLoanPurposes() {
        return loanPurposes;
    }

    public String getLoanPurposesOther() {
        return loanPurposesOther;
    }

    public BigDecimal getLoanQuota() {
        return loanQuota;
    }

    public String getLoanType() {
        return loanType;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public Date getMoveToDate() {
        return moveToDate;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getPhone() {
        return phone;
    }

    public String getPlatform() {
        return platform;
    }

    public String getProdType() {
        return prodType;
    }

    public String getQq() {
        return qq;
    }

    public String getRelativeKnown() {
        return relativeKnown;
    }

    public String getRelativeName() {
        return relativeName;
    }

    public String getRelativePhone() {
        return relativePhone;
    }

    public String getRelativeWorkUnit() {
        return relativeWorkUnit;
    }

    public String getSaasLoanId() {
        return saasLoanId;
    }

    public String getSaasUid() {
        return saasUid;
    }

    public Date getSettledFrom() {
        return settledFrom;
    }

    public String getSex() {
        return sex;
    }

    public String getStatus() {
        return status;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public String getWeixin() {
        return weixin;
    }

    public String getWorkProve1RsrcIds() {
        return workProve1RsrcIds;
    }

    public String getWorkProve2RsrcIds() {
        return workProve2RsrcIds;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion == null ? null : appVersion.trim();
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public void setBuzSubType(String buzSubType) {
        this.buzSubType = buzSubType;
    }

    public void setCar1stRegDate(Date car1stRegDate) {
        this.car1stRegDate = car1stRegDate;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand == null ? null : carBrand.trim();
    }

    public void setCarCardBrand(String carCardBrand) {
        this.carCardBrand = carCardBrand == null ? null : carCardBrand.trim();
    }

    public void setCarCardPlateNo(String carCardPlateNo) {
        this.carCardPlateNo = carCardPlateNo == null ? null : carCardPlateNo.trim();
    }

    public void setCarCardPublishDate(Date carCardPublishDate) {
        this.carCardPublishDate = carCardPublishDate;
    }

    public void setCarCardRegDate(Date carCardRegDate) {
        this.carCardRegDate = carCardRegDate;
    }

    public void setCarCardRsrcIds(String carCardRsrcIds) {
        this.carCardRsrcIds = carCardRsrcIds;
    }

    public void setCarCardType(String carCardType) {
        this.carCardType = carCardType == null ? null : carCardType.trim();
    }

    public void setCarCardVen(String carCardVen) {
        this.carCardVen = carCardVen == null ? null : carCardVen.trim();
    }

    public void setCarCardVicePageRsrcIds(String carCardVicePageRsrcIds) {
        this.carCardVicePageRsrcIds = carCardVicePageRsrcIds;
    }

    public void setCarCardVin(String carCardVin) {
        this.carCardVin = carCardVin == null ? null : carCardVin.trim();
    }

    public void setCardAddr(String cardAddr) {
        this.cardAddr = cardAddr == null ? null : cardAddr.trim();
    }

    public void setCardBackRsrcIds(String cardBackRsrcIds) {
        this.cardBackRsrcIds = cardBackRsrcIds;
    }

    public void setCardExpireDate(String cardExpireDate) {
        this.cardExpireDate = cardExpireDate == null ? null : cardExpireDate.trim();
    }

    public void setCardFrontRsrcIds(String cardFrontRsrcIds) {
        this.cardFrontRsrcIds = cardFrontRsrcIds;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo == null ? null : cardNo.trim();
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel == null ? null : carModel.trim();
    }

    public void setCarOwnership(String carOwnership) {
        this.carOwnership = carOwnership;
    }

    public void setCarPhoto10RsrcIds(String carPhoto10RsrcIds) {
        this.carPhoto10RsrcIds = carPhoto10RsrcIds;
    }

    public void setCarPhoto11RsrcIds(String carPhoto11RsrcIds) {
        this.carPhoto11RsrcIds = carPhoto11RsrcIds;
    }

    public void setCarPhoto12RsrcIds(String carPhoto12RsrcIds) {
        this.carPhoto12RsrcIds = carPhoto12RsrcIds;
    }

    public void setCarPhoto1RsrcIds(String carPhoto1RsrcIds) {
        this.carPhoto1RsrcIds = carPhoto1RsrcIds;
    }

    public void setCarPhoto2RsrcIds(String carPhoto2RsrcIds) {
        this.carPhoto2RsrcIds = carPhoto2RsrcIds;
    }

    public void setCarPhoto3RsrcIds(String carPhoto3RsrcIds) {
        this.carPhoto3RsrcIds = carPhoto3RsrcIds;
    }

    public void setCarPhoto4RsrcIds(String carPhoto4RsrcIds) {
        this.carPhoto4RsrcIds = carPhoto4RsrcIds;
    }

    public void setCarPhoto5RsrcIds(String carPhoto5RsrcIds) {
        this.carPhoto5RsrcIds = carPhoto5RsrcIds;
    }

    public void setCarPhoto6RsrcIds(String carPhoto6RsrcIds) {
        this.carPhoto6RsrcIds = carPhoto6RsrcIds;
    }

    public void setCarPhoto7RsrcIds(String carPhoto7RsrcIds) {
        this.carPhoto7RsrcIds = carPhoto7RsrcIds;
    }

    public void setCarPhoto8RsrcIds(String carPhoto8RsrcIds) {
        this.carPhoto8RsrcIds = carPhoto8RsrcIds;
    }

    public void setCarPhoto9RsrcIds(String carPhoto9RsrcIds) {
        this.carPhoto9RsrcIds = carPhoto9RsrcIds;
    }

    public void setCarPurchaseDate(Date carPurchaseDate) {
        this.carPurchaseDate = carPurchaseDate;
    }

    public void setCarPurchasePrice(String carPurchasePrice) {
        this.carPurchasePrice = carPurchasePrice;
    }

    public void setCarRegistrationRsrcIds(String carRegistrationRsrcIds) {
        this.carRegistrationRsrcIds = carRegistrationRsrcIds;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries == null ? null : carSeries.trim();
    }

    public void setCarTimes(String carTimes) {
        this.carTimes = carTimes;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public void setCommercialInsuranceRsrcIds(String commercialInsuranceRsrcIds) {
        this.commercialInsuranceRsrcIds = commercialInsuranceRsrcIds;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr == null ? null : companyAddr.trim();
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment == null ? null : companyDepartment.trim();
    }

    public void setCompanyJob(String companyJob) {
        this.companyJob = companyJob;
    }

    public void setCompanyJoinDate(Date companyJoinDate) {
        this.companyJoinDate = companyJoinDate;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public void setCompanyPayDate(Integer companyPayDate) {
        this.companyPayDate = companyPayDate;
    }

    public void setCompanyPaymentMethod(String companyPaymentMethod) {
        this.companyPaymentMethod = companyPaymentMethod;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone == null ? null : companyPhone.trim();
    }

    public void setCompanySalary(BigDecimal companySalary) {
        this.companySalary = companySalary;
    }

    public void setCompulsoryInsuranceRsrcIds(String compulsoryInsuranceRsrcIds) {
        this.compulsoryInsuranceRsrcIds = compulsoryInsuranceRsrcIds;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public void setCreditReportRsrcIds(String creditReportRsrcIds) {
        this.creditReportRsrcIds = creditReportRsrcIds;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public void setEnterpriseAddr(String enterpriseAddr) {
        this.enterpriseAddr = enterpriseAddr == null ? null : enterpriseAddr.trim();
    }

    public void setEnterpriseMonthlyTurnover(BigDecimal enterpriseMonthlyTurnover) {
        this.enterpriseMonthlyTurnover = enterpriseMonthlyTurnover;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName == null ? null : enterpriseName.trim();
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone == null ? null : enterprisePhone.trim();
    }

    public void setEnterpriseRegDate(Date enterpriseRegDate) {
        this.enterpriseRegDate = enterpriseRegDate;
    }

    public void setFreelanceSalary(Long freelanceSalary) {
        this.freelanceSalary = freelanceSalary;
    }

    public void setFreelanceSource(String freelanceSource) {
        this.freelanceSource = freelanceSource == null ? null : freelanceSource.trim();
    }

    public void setHasHouse(String hasHouse) {
        this.hasHouse = hasHouse;
    }

    public void setHouse1RsrcIds(String house1RsrcIds) {
        this.house1RsrcIds = house1RsrcIds;
    }

    public void setHouse2RsrcIds(String house2RsrcIds) {
        this.house2RsrcIds = house2RsrcIds;
    }

    public void setHouse3RsrcIds(String house3RsrcIds) {
        this.house3RsrcIds = house3RsrcIds;
    }

    public void setHouse4RsrcIds(String house4RsrcIds) {
        this.house4RsrcIds = house4RsrcIds;
    }

    public void setHouseAddr(String houseAddr) {
        this.houseAddr = houseAddr == null ? null : houseAddr.trim();
    }

    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    public void setImmediateName(String immediateName) {
        this.immediateName = immediateName;
    }

    public void setImmediatePhone(String immediatePhone) {
        this.immediatePhone = immediatePhone;
    }

    public void setImmediateWorkUnit(String immediateWorkUnit) {
        this.immediateWorkUnit = immediateWorkUnit;
    }

    public void setInstallment(String installment) {
        this.installment = installment == null ? null : installment.trim();
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setLivingType(String livingType) {
        this.livingType = livingType;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId == null ? null : loanId.trim();
    }

    public void setLoanMoney(String loanMoney) {
        this.loanMoney = loanMoney;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod == null ? null : loanPeriod.trim();
    }

    public void setLoanPurposes(String loanPurposes) {
        this.loanPurposes = loanPurposes;
    }

    public void setLoanPurposesOther(String loanPurposesOther) {
        this.loanPurposesOther = loanPurposesOther == null ? null : loanPurposesOther.trim();
    }

    public void setLoanQuota(BigDecimal loanQuota) {
        this.loanQuota = loanQuota;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo == null ? null : mobileNo.trim();
    }

    public void setMoveToDate(Date moveToDate) {
        this.moveToDate = moveToDate;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public void setPlatform(String platform) {
        this.platform = platform == null ? null : platform.trim();
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public void setRelativeKnown(String relativeKnown) {
        this.relativeKnown = relativeKnown;
    }

    public void setRelativeName(String relativeName) {
        this.relativeName = relativeName == null ? null : relativeName.trim();
    }

    public void setRelativePhone(String relativePhone) {
        this.relativePhone = relativePhone == null ? null : relativePhone.trim();
    }

    public void setRelativeWorkUnit(String relativeWorkUnit) {
        this.relativeWorkUnit = relativeWorkUnit == null ? null : relativeWorkUnit.trim();
    }

    public void setSaasLoanId(String saasLoanId) {
        this.saasLoanId = saasLoanId == null ? null : saasLoanId.trim();
    }

    public void setSaasUid(String saasUid) {
        this.saasUid = saasUid;
    }

    public void setSettledFrom(Date settledFrom) {
        this.settledFrom = settledFrom;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public void setWorkProve1RsrcIds(String workProve1RsrcIds) {
        this.workProve1RsrcIds = workProve1RsrcIds;
    }

    public void setWorkProve2RsrcIds(String workProve2RsrcIds) {
        this.workProve2RsrcIds = workProve2RsrcIds;
    }

    @Override
    public String toString() {
        return "JFBPAttrValue [loanId=" + loanId + ", userId=" + userId + ", appVersion=" + appVersion + ", platform="
                + platform + ", orgId=" + orgId + ", prodType=" + prodType + ", status=" + status + ", loanMoney="
                + loanMoney + ", installment=" + installment + ", loanType=" + loanType + ", job=" + job
                + ", loanPurposes=" + loanPurposes + ", loanPurposesOther=" + loanPurposesOther + ", buzSubType="
                + buzSubType + ", cardName=" + cardName + ", sex=" + sex + ", birthday=" + birthday + ", age=" + age
                + ", cardNo=" + cardNo + ", cardExpireDate=" + cardExpireDate + ", cardAddr=" + cardAddr
                + ", maritalStatus=" + maritalStatus + ", education=" + education + ", mobileNo=" + mobileNo
                + ", phone=" + phone + ", email=" + email + ", qq=" + qq + ", weixin=" + weixin + ", address="
                + address + ", moveToDate=" + moveToDate + ", settledFrom=" + settledFrom + ", livingType="
                + livingType + ", hasHouse=" + hasHouse + ", houseAddr=" + houseAddr + ", houseStatus=" + houseStatus
                + ", carCardPlateNo=" + carCardPlateNo + ", carCardBrand=" + carCardBrand + ", carCardRegDate="
                + carCardRegDate + ", carCardPublishDate=" + carCardPublishDate + ", carCardVin=" + carCardVin
                + ", carCardVen=" + carCardVen + ", carCardType=" + carCardType + ", carBrand=" + carBrand
                + ", carSeries=" + carSeries + ", carModel=" + carModel + ", carOwnership=" + carOwnership
                + ", carPurchaseDate=" + carPurchaseDate + ", car1stRegDate=" + car1stRegDate + ", carPurchasePrice="
                + carPurchasePrice + ", carTimes=" + carTimes + ", companyName=" + companyName + ", companyAddr="
                + companyAddr + ", companyPhone=" + companyPhone + ", companyJob=" + companyJob
                + ", companyDepartment=" + companyDepartment + ", companyJoinDate=" + companyJoinDate
                + ", companySalary=" + companySalary + ", companyPayDate=" + companyPayDate + ", companyPaymentMethod="
                + companyPaymentMethod + ", enterpriseName=" + enterpriseName + ", enterpriseAddr=" + enterpriseAddr
                + ", enterprisePhone=" + enterprisePhone + ", enterpriseRegDate=" + enterpriseRegDate
                + ", enterpriseMonthlyTurnover=" + enterpriseMonthlyTurnover + ", freelanceSource=" + freelanceSource
                + ", freelanceSalary=" + freelanceSalary + ", relativeName=" + relativeName + ", relativePhone="
                + relativePhone + ", relativeWorkUnit=" + relativeWorkUnit + ", relativeKnown=" + relativeKnown
                + ", saasLoanId=" + saasLoanId + ", comment=" + comment + ", loanQuota=" + loanQuota + ", loanPeriod="
                + loanPeriod + ", createDate=" + createDate + ", updateTime=" + updateTime + ", cardFrontRsrcIds="
                + cardFrontRsrcIds + ", cardBackRsrcIds=" + cardBackRsrcIds + ", carCardRsrcIds=" + carCardRsrcIds
                + ", house1RsrcIds=" + house1RsrcIds + ", house2RsrcIds=" + house2RsrcIds + ", house3RsrcIds="
                + house3RsrcIds + ", house4RsrcIds=" + house4RsrcIds + ", carRegistrationRsrcIds="
                + carRegistrationRsrcIds + ", compulsoryInsuranceRsrcIds=" + compulsoryInsuranceRsrcIds
                + ", commercialInsuranceRsrcIds=" + commercialInsuranceRsrcIds + ", workProve1RsrcIds="
                + workProve1RsrcIds + ", workProve2RsrcIds=" + workProve2RsrcIds + ", creditReportRsrcIds="
                + creditReportRsrcIds + ", saasUid=" + saasUid + ", carPhoto1RsrcIds=" + carPhoto1RsrcIds
                + ", carPhoto2RsrcIds=" + carPhoto2RsrcIds + ", carPhoto3RsrcIds=" + carPhoto3RsrcIds
                + ", carPhoto4RsrcIds=" + carPhoto4RsrcIds + ", carPhoto5RsrcIds=" + carPhoto5RsrcIds
                + ", carPhoto6RsrcIds=" + carPhoto6RsrcIds + ", carPhoto7RsrcIds=" + carPhoto7RsrcIds
                + ", carPhoto8RsrcIds=" + carPhoto8RsrcIds + ", carPhoto9RsrcIds=" + carPhoto9RsrcIds
                + ", carPhoto10RsrcIds=" + carPhoto10RsrcIds + ", carPhoto11RsrcIds=" + carPhoto11RsrcIds
                + ", carPhoto12RsrcIds=" + carPhoto12RsrcIds + "]";
    }

}