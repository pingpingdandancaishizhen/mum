package cn.sunfit.risk.buz.server.service.corp;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import orj.worf.mybatis.util.CountHelper;
import orj.worf.util.DateUtils;
import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.beans.corp.CustContact;
import cn.sunfit.risk.buz.api.beans.corp.CustOperLog;
import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.customer.CustomerStatus;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.customer.GenderType;
import cn.sunfit.risk.buz.api.constants.customer.MaritalStatus;
import cn.sunfit.risk.buz.api.service.corp.CustomerService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerAddDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CustomerDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerModifyDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.CorpDataRoleDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustContactDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustOperLogDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustomerDAO;

@Service("risk.customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    CustContactDAO custContactDAO;

    @Autowired
    CustOperLogDAO custOperLogDAO;

    @Autowired
    CorpDataRoleDAO corpDataRoleDAO;

    @Autowired
    private CorpUserDAO corpUserDAO;

    @Override
    public boolean checkCustomerExist(String id, String uid, String licenseNum, String domain) {
        return customerDAO.selectByLicenseNum(id, uid, licenseNum, domain) == null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteCustomer(String domain, String id, String uid) {
        Customer customer = customerDAO.selectByPrimaryKey(id, domain);
        customerDAO.deleteCustomer(domain, id);
        CustOperLog record = CustOperLog.createCustOperLog(uid, id, CustOperLog.DELETE_CUSTOMER,
                "删除了客户[" + customer.getName() + "]");
        custOperLogDAO.insert(record);
    }

    private List<String> getDataRole(String userId, String corpId) {
        List<String> result = new ArrayList<String>();
        // 有权限的用户Id
        Set<String> userIdList = new HashSet<String>();
        // 有权限的部门Id
        List<String> deptList = new ArrayList<String>();

        // 用户数据权限角色集合
        List<CorpDataRoleDTO> dataRoleList = corpDataRoleDAO.selectUserCorpDataRole(userId, corpId);
        for (CorpDataRoleDTO corpDataRoleDTO : dataRoleList) {
            if (StringUtils.isNotBlank(corpDataRoleDTO.getDepts())) {
                List<String> depts = Arrays.asList(corpDataRoleDTO.getDepts().split(","));
                deptList.addAll(depts);
            }
            // 若仅本人
            if (StringUtils.equals(corpDataRoleDTO.getSelfOnly(), "1")) {
                userIdList.add(userId);
            }
            // 若仅本部门
            if (StringUtils.equals(corpDataRoleDTO.getDeptOnly(), "1")) {
                CorpUser createUser = corpUserDAO.selectByPrimaryKey(userId);
                deptList.add(createUser.getDeptId());
            }
        }
        List<String> temp = corpUserDAO.selectUserByDeptId(deptList);
        userIdList.addAll(temp);
        for (String id : userIdList) {
            result.add(id);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insert(CustomerAddDTO customer, List<CustContact> custContacts, String domain) {
        customer.setId(IdUtil.geneId());
        customer.setCreateTime(new Date());
        customer.setUpdateTime(new Date());
        customer.setStatus(CustomerStatus.CREATE.getStatus());
        customerDAO.insert(customer);
        if(custContacts != null && custContacts.size() > 0){
	        for (CustContact custContact : custContacts) {
	            custContact.setId(IdUtil.geneId());
	            custContact.setCustId(customer.getId());
	        }
	        custContactDAO.insert(custContacts, domain);
        }
        CustOperLog record = CustOperLog.createCustOperLog(customer.getUid(), customer.getId(),
                CustOperLog.ADD_CUSTOMER, "创建了客户[" + customer.getName() + "]");
        custOperLogDAO.insert(record);
        return customer.getId();
    }

    @Override
    public RespPage<List<CustomerDTO>> queryAllCustomer(CustomerQueryReq req) {
        req.setUids(getDataRole(req.getUid(), req.getCorpId()));
        req.setStatus(CustomerStatus.CREATE.getStatus());
        List<CustomerDTO> list = customerDAO.queryAllCustomer(req, new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        for (CustomerDTO customerDTO : list) {
            CustomerType customerType = CustomerType.getTypeNameByTypeId(customerDTO.getType());
            if (customerType != null) {
                customerDTO.setTypeName(customerType.getTypeName());
            }
            CustomerStatus customerStatus = CustomerStatus.getNameByStatus(customerDTO.getStatus());
            if (customerStatus != null) {
                customerDTO.setStatusName(customerStatus.getStatusName());
            }
            MaritalStatus maritalStatus = MaritalStatus.getNameByType(customerDTO.getMaritalStatus());
            if (maritalStatus != null) {
                customerDTO.setMaritalStatusName(maritalStatus.getName());
            }
            GenderType genderType = GenderType.getNameByStatus(customerDTO.getGender());
            if (genderType != null) {
                customerDTO.setGenderName(genderType.getName());
            }
        }
        return new RespPage<List<CustomerDTO>>(list, totalCount);
    }

    @Override
    public RespPage<List<CustomerDTO>> queryBlackList(CustomerQueryReq req) {
        List<CustomerDTO> list = customerDAO.queryBlackList(req, new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        for (CustomerDTO customerDTO : list) {
            CustomerType customerType = CustomerType.getTypeNameByTypeId(customerDTO.getType());
            if (customerType != null) {
                customerDTO.setTypeName(customerType.getTypeName());
            }
            CustomerStatus customerStatus = CustomerStatus.getNameByStatus(customerDTO.getStatus());
            if (customerStatus != null) {
                customerDTO.setStatusName(customerStatus.getStatusName());
            }
            MaritalStatus maritalStatus = MaritalStatus.getNameByType(customerDTO.getMaritalStatus());
            if (maritalStatus != null) {
                customerDTO.setMaritalStatusName(maritalStatus.getName());
            }
            GenderType genderType = GenderType.getNameByStatus(customerDTO.getGender());
            if (genderType != null) {
                customerDTO.setGenderName(genderType.getName());
            }
        }
        return new RespPage<List<CustomerDTO>>(list, totalCount);
    }

    @Override
    public RespPage<List<CustomerDTO>> queryCustomerList(CustomerQueryReq req) {
        List<CustomerDTO> list = customerDAO.queryCustomerList(req, new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        for (CustomerDTO customerDTO : list) {
            CustomerType customerType = CustomerType.getTypeNameByTypeId(customerDTO.getType());
            if (customerType != null) {
                customerDTO.setTypeName(customerType.getTypeName());
            }
            CustomerStatus customerStatus = CustomerStatus.getNameByStatus(customerDTO.getStatus());
            if (customerStatus != null) {
                customerDTO.setStatusName(customerStatus.getStatusName());
            }
            MaritalStatus maritalStatus = MaritalStatus.getNameByType(customerDTO.getMaritalStatus());
            if (maritalStatus != null) {
                customerDTO.setMaritalStatusName(maritalStatus.getName());
            }
            GenderType genderType = GenderType.getNameByStatus(customerDTO.getGender());
            if (genderType != null) {
                customerDTO.setGenderName(genderType.getName());
            }
        }
        return new RespPage<List<CustomerDTO>>(list, totalCount);
    }

    @Override
    public Customer selectByPrimaryKey(String id, String domain) {
        return customerDAO.selectByPrimaryKey(id, domain);
    }

    @Override
    public Customer selectByPrimaryLicenseNum(String licenseNum, String domain) {
        return customerDAO.selectByPrimaryLicenseNum(licenseNum, domain);
    }

    @Override
    public List<CustContact> selectCustContactsByCustId(String custId, String domain) {
        return custContactDAO.selectCustContactsByCustId(custId, domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CustomerModifyDTO customer, List<CustContact> custContacts, String domain) {
        Customer old = customerDAO.selectByPrimaryKey(customer.getId(), customer.getDomain());
        customer.setUpdateTime(new Date());
        customerDAO.update(customer);
        custContactDAO.deleteCustContactsByCustId(customer.getId(), customer.getDomain());
        for (CustContact custContact : custContacts) {
            custContact.setId(IdUtil.geneId());
            custContact.setCustId(customer.getId());
        }
        custContactDAO.insert(custContacts, domain);
        CustOperLog record = CustOperLog.createCustOperLog(customer.getUid(), customer.getId(),
                CustOperLog.MODIFY_CUSTOMER, "修改了客户[" + old.getName() + "]" + customer.compareOldCustomer(old));
        custOperLogDAO.insert(record);
    }

	@Override
	public String autoSaveCustomer(Map<String, String> formdata,CorpUserDTO user) {
		String custLicenseNumInvalid = formdata.get("cust_license_num_invalid");
		String custLicenseNum = formdata.get("cust_license_num");
    	String custName = formdata.get("cust_name");
    	String custType = formdata.get("cust_type");
    	String custGender = formdata.get("cust_gender");
    	String custMarriage = formdata.get("cust_marriage");
    	String custMobile = formdata.get("cust_mobile");
    	String custEducation = formdata.get("cust_education");
    	String custChildCount = formdata.get("cust_child_count");
    	String custSupportNum = formdata.get("cust_support_num");
    	String custHouseSpending = formdata.get("cust_house_spending");
    	String custMobile2 = formdata.get("cust_mobile2");
    	String custEmail = formdata.get("cust_email");
    	String custQQ = formdata.get("cust_qq");
    	String custWechat = formdata.get("cust_wechat");
    	String custPhone = formdata.get("cust_phone");
    	String custHouseTimeInput = formdata.get("cust_house_time");
    	String custHouseType = formdata.get("cust_house_type");
    	String custComeTimeInput = formdata.get("cust_come_time");
    	String custRegistAddrProvince = formdata.get("cust_regist_addr_province");
    	String custRegistAddrCity = formdata.get("cust_regist_addr_city");
    	String custRegistAddrCounties = formdata.get("cust_regist_addr_counties");
    	String custRegistAddrDetail = formdata.get("cust_regist_addr_detail");
    	String custLiveAddrProvince = formdata.get("cust_live_addr_province");
    	String custLiveAddrCity = formdata.get("cust_live_addr_city");
    	String custLiveAddrCounties = formdata.get("cust_live_addr_counties");
    	String custLiveAddrDetail = formdata.get("cust_live_addr_detail");
    	String custjobIdentity = formdata.get("custjob_identity");
    	String custjobIndustry = formdata.get("custjob_industry");
    	String custjobJobLvl = formdata.get("custjob_job_lvl");
    	String custjobCompanyType = formdata.get("custjob_company_type");
    	String custjobCompanyName = formdata.get("custjob_company_name");
    	String custjobDeptName = formdata.get("custjob_dept_name");
    	String custjobTitle = formdata.get("custjob_title");
    	String custjobEntryTime = formdata.get("custjob_entry_time");
    	String custjobSalary = formdata.get("custjob_salary");
    	String custjobSalaryDate = formdata.get("custjob_salary_date");
    	String custjobSalaryType = formdata.get("custjob_salary_type");
    	String custjobCompanyPhone = formdata.get("custjob_company_phone");
    	String custjobCompanyAddrInput = formdata.get("custjob_company_addr_input");
    	String custjobCompanyAddrDetail = formdata.get("custjob_company_addr_detail");
    	String custjobIncomeSource = formdata.get("custjob_income_source");
    	String custjobIncomeMonth = formdata.get("custjob_income_month");
    	String custjobRegDate = formdata.get("custjob_reg_date");
    	String custjobTurnoverMonth = formdata.get("custjob_turnover_month");
    	String custjobCompanyAddrProvince = formdata.get("custjob_company_addr_province");
    	String custjobCompanyAddrCity = formdata.get("custjob_company_addr_city");
    	String custjobCompanyAddrCounties = formdata.get("custjob_company_addr_counties");
    	String custimgidcard1 = formdata.get("custimg_idcard1");
    	String custimgIdcard2 = formdata.get("custimg_idcard2");
    	CustomerAddReq customer = new CustomerAddReq();
    	customer.setIndustry(custjobIndustry);
    	customer.setIdCardFront(custimgidcard1);
    	customer.setIdCardBack(custimgIdcard2);
    	if(custjobIdentity != null && custjobIdentity.equals("1")){//受薪人士
        	customer.setSalaryType(custjobSalaryType);
        	customer.setCompanyPhone(custjobCompanyPhone);
        	customer.setCompanyAddr(custjobCompanyAddrProvince+"/"+custjobCompanyAddrCity+"/"+custjobCompanyAddrCounties);
        	customer.setCompanyAddrDetail(custjobCompanyAddrDetail);
        	try {
        		customer.setSalaryDate(Integer.parseInt(custjobSalaryDate));
    			customer.setEntryTime(DateUtils.parse(GlobalConstants.DATE_FORMAT_DATE, custjobEntryTime));
    			customer.setSalary(BigDecimal.valueOf(Double.parseDouble(custjobSalary)));
        	} catch (Exception e1) {
    			e1.printStackTrace();
    		}    	
        	customer.setJobTitle(custjobTitle);
        	customer.setDeptName(custjobDeptName);
        	customer.setCompanyName(custjobCompanyName);
        	customer.setCompanyType(custjobCompanyType);
        	customer.setJob(custjobJobLvl);
    	}else if(custjobIdentity != null && custjobIdentity.equals("2")){//自雇人士
    		try {
    			customer.setSalary(BigDecimal.valueOf(Double.parseDouble(custjobIncomeMonth)));
    		} catch (Exception e1) {
    			e1.printStackTrace();
    		}  
    		customer.setCompanyName(custjobIncomeSource);
    	}else if(custjobIdentity != null && custjobIdentity.equals("3")){//企业股东
    		customer.setJobTitle(custjobTitle);
    		customer.setJob(custjobJobLvl);
    		customer.setDeptName(custjobDeptName);
        	customer.setCompanyName(custjobCompanyName);
        	customer.setCompanyType(custjobCompanyType);
        	customer.setCompanyPhone(custjobCompanyPhone);
        	customer.setCompanyAddr(custjobCompanyAddrProvince+"/"+custjobCompanyAddrCity+"/"+custjobCompanyAddrCounties);
        	customer.setCompanyAddrDetail(custjobCompanyAddrDetail);
    		try {
    			customer.setSalary(BigDecimal.valueOf(Double.parseDouble(custjobTurnoverMonth)));
				customer.setEntryTime(DateUtils.parse(GlobalConstants.DATE_FORMAT_DATE, custjobRegDate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	customer.setJobType(custjobIdentity);
		customer.setDomain(user.getDomain());
		customer.setCorpId(user.getCorpId());
		customer.setUid(user.getId());
		customer.setLicenseNum(custLicenseNum);
		customer.setName(custName);
		customer.setType(custType);
		if(custGender == null){
			String sCardNum = custLicenseNum.substring(16, 17);
	        if (Integer.parseInt(sCardNum) % 2 != 0) {
	        	custGender = "1";//男
	        } else {
	        	custGender = "0";//女
	        }
		}
        Calendar cal = Calendar.getInstance();
        String year = custLicenseNum.substring(6, 10);
        int iCurrYear = cal.get(Calendar.YEAR);
        int age = iCurrYear - Integer.valueOf(year);
        customer.setAge(age);
		customer.setGender(custGender);
		customer.setMaritalStatus(custMarriage);
		customer.setMobile(custMobile);
		customer.setEducation(custEducation);
		customer.setMobile2(custMobile2);
		customer.setEmail(custEmail);
		customer.setQq(custQQ);
		customer.setWechat(custWechat);
		customer.setPhone(custPhone);
		try {
	        customer.setBirthday(DateUtils.parse("yyyyMMdd", custLicenseNum.substring(6, 14)));
			customer.setIdCardVaild(DateUtils.parse(GlobalConstants.DATE_FORMAT_DATE, custLicenseNumInvalid));
			customer.setHouseSpending(BigDecimal.valueOf(Double.parseDouble(custHouseSpending)));
			customer.setChildCount(Integer.parseInt(custChildCount));
			customer.setSupportNum(Integer.parseInt(custSupportNum));
			customer.setHouseTime(DateUtils.parse(GlobalConstants.DATE_FORMAT_DATE, custHouseTimeInput));
			customer.setComeTime(DateUtils.parse(GlobalConstants.DATE_FORMAT_DATE, custComeTimeInput));
		} catch (Exception e) {}			
		customer.setHouseType(custHouseType);
		customer.setRegistAddr(custRegistAddrProvince+"/"+custRegistAddrCity+"/"+custRegistAddrCounties);
		customer.setRegistAddrDetail(custRegistAddrDetail);
		customer.setLiveAddr(custLiveAddrProvince+"/"+custLiveAddrCity+"/"+custLiveAddrCounties);
		customer.setLiveAddrDetail(custLiveAddrDetail);
		String id = insert(customer.toCustomerAddDTO(),getCustContact(formdata), customer.getDomain());
		return id;
	}
	
	private List<CustContact> getCustContact(Map<String, String> formdata){
		List<CustContact> contactList = new ArrayList<CustContact>();
		for(int i = 0;i < 5;i++){
			String custfriendRelation =  formdata.get("custfriend_relation_"+i);
			if(StringUtils.isEmpty(custfriendRelation))
				continue;
			CustContact contact = new CustContact();
			String custfriendName =  formdata.get("custfriend_name_"+i);
			String custfriendKnow =  formdata.get("custfriend_know_"+i);
			String custfriendCompanyName =  formdata.get("custfriend_company_name_"+i);
			String custfriendPhone =  formdata.get("custfriend_phone_"+i);
			contact.setCompany(custfriendCompanyName);
			contact.setIndex(i+1);
			contact.setIsknow("1".equals(custfriendKnow) ? true:false);
			contact.setMobile(custfriendPhone);
			contact.setName(custfriendName);
			contact.setRelation(custfriendRelation);
			contactList.add(contact);
		}
		return contactList;
	}

}
