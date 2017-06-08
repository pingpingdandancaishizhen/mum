package cn.sunfit.risk.web.controller.system;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sunfit.risk.buz.api.beans.corp.CustContact;
import cn.sunfit.risk.buz.api.beans.corp.Customer;
import cn.sunfit.risk.buz.api.beans.solution.Product;
import cn.sunfit.risk.buz.api.constants.EducationType;
import cn.sunfit.risk.buz.api.constants.customer.CompanyType;
import cn.sunfit.risk.buz.api.constants.customer.CustCustomerType;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.customer.GenderType;
import cn.sunfit.risk.buz.api.constants.customer.HouseType;
import cn.sunfit.risk.buz.api.constants.customer.JobTitle;
import cn.sunfit.risk.buz.api.constants.customer.JobType;
import cn.sunfit.risk.buz.api.constants.customer.LicenseType;
import cn.sunfit.risk.buz.api.constants.customer.MaritalStatus;
import cn.sunfit.risk.buz.api.constants.customer.SalaryType;
import cn.sunfit.risk.buz.api.service.corp.BlackListService;
import cn.sunfit.risk.buz.api.service.corp.CustOperLogService;
import cn.sunfit.risk.buz.api.service.corp.CustomerService;
import cn.sunfit.risk.buz.api.service.corp.ResourcesService;
import cn.sunfit.risk.buz.api.service.solution.ProductService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.Resp;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.CustomerAddReq;
import cn.sunfit.risk.buz.api.vo.corp.CustomerDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustomerModifyReq;
import cn.sunfit.risk.buz.api.vo.corp.CustomerQueryReq;
import cn.sunfit.risk.web.controller.BaseController;

@Controller
@RequestMapping(value = "/system/customer")
public class CustomerController extends BaseController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CustOperLogService custOperLogService;

    @Autowired
    BlackListService blackListService;

    @Autowired
    ProductService productService;

    @Autowired
    private ResourcesService resourcesService;

    @ResponseBody
    @RequestMapping(value = "/addBlackList", method = RequestMethod.POST)
    public Resp addBlackList(String licenseNum) {
        blackListService.insert(getCurrentUser().getDomain(), licenseNum, getCurrentUser().getId());
        return new Resp();
    }

    @RequestMapping(value = "/addCustomerPage", method = RequestMethod.GET)
    public String addCustomer(HttpServletRequest request) {
        request.setAttribute("education", EducationType.values());
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        request.setAttribute("houseTypes", HouseType.values());
        request.setAttribute("marital", MaritalStatus.values());
        request.setAttribute("license", LicenseType.values());
        request.setAttribute("salaryType", SalaryType.values());
        request.setAttribute("companyType", CompanyType.values());
        request.setAttribute("jobType", JobType.values());
        request.setAttribute("jobTitle", JobTitle.values());
        request.setAttribute("custCustomerType", CustCustomerType.values());
        return "/system/customer/addCustomer";
    }

    @ResponseBody
    @RequestMapping(value = "/checkCustomerBlackList", method = RequestMethod.POST)
    public Map<String, Object> checkCustomerBlackList(@RequestParam(required = true) String licenseNum) {
        CorpUserDTO user = getCurrentUser();
        boolean result = blackListService.checkCustomerBlackList(licenseNum, user.getDomain());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("valid", result);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/checkCustomerExist", method = RequestMethod.POST)
    public Map<String, Object> checkCustomerExist(@RequestParam(required = true) String licenseNum, String id) {
        CorpUserDTO user = getCurrentUser();
        Map<String, Object> map = new HashMap<String, Object>();
        boolean exist = customerService.checkCustomerExist(id, user.getId(), licenseNum, user.getDomain());
        if (exist) {
            boolean blackList = blackListService.checkCustomerBlackList(licenseNum, user.getDomain());
            map.put("valid", blackList);
            return map;
        } else {
            map.put("valid", exist);
            return map;
        }
    }

    @RequestMapping(value = "/customerDetailPage", method = RequestMethod.GET)
    public String customerDetailPage(HttpServletRequest request, String id, String licenseNum) {
        request.setAttribute("education", EducationType.values());
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        request.setAttribute("houseTypes", HouseType.values());
        request.setAttribute("marital", MaritalStatus.values());
        request.setAttribute("license", LicenseType.values());
        request.setAttribute("salaryType", SalaryType.values());
        request.setAttribute("companyType", CompanyType.values());
        request.setAttribute("jobType", JobType.values());
        request.setAttribute("jobTitle", JobTitle.values());
        request.setAttribute("custCustomerType", CustCustomerType.values());
        Customer customer = new Customer();
        CorpUserDTO user = getCurrentUser();
        if (StringUtils.isNotBlank(id)) {
            customer = customerService.selectByPrimaryKey(id, user.getDomain());
        } else if (StringUtils.isNotBlank(licenseNum)) {
            customer = customerService.selectByPrimaryLicenseNum(licenseNum, user.getDomain());
        }
        List<CustContact> custContacts = customerService.selectCustContactsByCustId(customer.getId(), user.getDomain());
        request.setAttribute("customer", customer);
        request.setAttribute("custContacts", custContacts);
        request.setAttribute("idCardFront",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getIdCardFront(), user.getDomain()));
        request.setAttribute("idCardBack",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getIdCardBack(), user.getDomain()));
        request.setAttribute("creditReport",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getCreditReport(), user.getDomain()));
        request.setAttribute("resource",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getResourceId(), user.getDomain()));
        return "/system/customer/customerDetailManager";
    }

    @ResponseBody
    @RequestMapping(value = "/customerLog", method = RequestMethod.POST)
    public Resp customerLog(CustOperLogQueryReq req) {
        req.setDomain(getCurrentUser().getDomain());
        if (StringUtils.isNotEmpty(req.getOperTypes())) {
            req.setOperType(Arrays.asList(req.getOperTypes().split(",")));
        }
        RespPage<List<CustOperLogDTO>> pageList = custOperLogService.queryCustOperLogList(req);
        return new Resp(pageList);
    }

    @RequestMapping(value = "/editCustomerPage", method = RequestMethod.GET)
    public String editCustomerPage(HttpServletRequest request, String id) {
        request.setAttribute("education", EducationType.values());
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        request.setAttribute("houseTypes", HouseType.values());
        request.setAttribute("marital", MaritalStatus.values());
        request.setAttribute("license", LicenseType.values());
        request.setAttribute("salaryType", SalaryType.values());
        request.setAttribute("companyType", CompanyType.values());
        request.setAttribute("jobType", JobType.values());
        request.setAttribute("jobTitle", JobTitle.values());
        request.setAttribute("custCustomerType", CustCustomerType.values());

        CorpUserDTO user = getCurrentUser();
        Customer customer = customerService.selectByPrimaryKey(id, user.getDomain());
        List<CustContact> custContacts = customerService.selectCustContactsByCustId(customer.getId(), user.getDomain());
        request.setAttribute("customer", customer);
        request.setAttribute("custContacts", custContacts);
        request.setAttribute("idCardFront",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getIdCardFront(), user.getDomain()));
        request.setAttribute("idCardBack",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getIdCardBack(), user.getDomain()));
        request.setAttribute("creditReport",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getCreditReport(), user.getDomain()));
        request.setAttribute("resource",
                resourcesService.queryResourcesById(user.getCorpId(), customer.getResourceId(), user.getDomain()));
        return "/system/customer/modifyCustomer";
    }

    /**
     * 
     * @Title: loadDeptManager
     * @Description: 加载组织机构管理初始页
     * @param @return   
     * @return String 
     * @author XJ 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/loadAllCustomerManager", method = RequestMethod.GET)
    public String loadAllCustomerManager(HttpServletRequest request) {
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        return "/system/customer/loadAllCustomerManager";
    }

    @RequestMapping(value = "/loadBlackListManager", method = RequestMethod.GET)
    public String loadBlackListManager(HttpServletRequest request) {
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        return "/system/customer/loadBlackListManager";
    }

    /**
     * 
     * @Title: loadDeptManager
     * @Description: 加载组织机构管理初始页
     * @param @return   
     * @return String 
     * @author XJ 2016年12月8日 
     * @throws
     */
    @RequestMapping(value = "/loadCustomerManager", method = RequestMethod.GET)
    public String loadCustomerManager(HttpServletRequest request) {
        request.setAttribute("types", CustomerType.values());
        request.setAttribute("genders", GenderType.values());
        List<Product> productList = productService.queryProductByCorpId(getCurrentUser().getCorpId());
        request.setAttribute("productList", productList);
        return "/system/customer/loadCustomerManager";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyCustomer", method = RequestMethod.POST)
    public Resp modifyCustomer(@Valid CustomerModifyReq customer, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        boolean blFlag = blackListService
                .checkCustomerBlackList(customer.getLicenseNum(), getCurrentUser().getDomain());
        if (!blFlag) {
            return Resp.buildErrorResponse("用户已被添加黑名单,无法修改,请刷新页面");
        }
        CorpUserDTO user = getCurrentUser();
        customer.setDomain(user.getDomain());
        customer.setCorpId(user.getCorpId());
        customer.setUid(user.getId());
        customerService
                .update(customer.toCustomerModifyDTO(), customer.getCustContacts(), getCurrentUser().getDomain());
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
    public Resp modifyCustomer(String id) {
        customerService.deleteCustomer(getCurrentUser().getDomain(), id, getCurrentUser().getId());
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/queryAllCustomer", method = RequestMethod.POST)
    public Resp queryAllCustomer(CustomerQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUid(user.getId());
        req.setCorpId(user.getCorpId());
        RespPage<List<CustomerDTO>> pageList = customerService.queryAllCustomer(req);
        for (CustomerDTO cu : pageList.getData()) {
            cu.setLicenseNum(HideInfoUtils.hideIdentificationCard(cu.getLicenseNum()));
            cu.setMobile(HideInfoUtils.hidePhoneNo(cu.getMobile()));
        }
        return new Resp(pageList);
    }

    @ResponseBody
    @RequestMapping(value = "/queryBlackList", method = RequestMethod.POST)
    public Resp queryBlackList(CustomerQueryReq req) {
        CorpUserDTO user = getCurrentUser();
        req.setDomain(user.getDomain());
        req.setUid(user.getId());
        RespPage<List<CustomerDTO>> pageList = customerService.queryBlackList(req);
        for (CustomerDTO cu : pageList.getData()) {
            cu.setLicenseNum(HideInfoUtils.hideIdentificationCard(cu.getLicenseNum()));
            cu.setMobile(HideInfoUtils.hidePhoneNo(cu.getMobile()));
        }
        return new Resp(pageList);
    }

    @ResponseBody
    @RequestMapping(value = "/queryCustomer", method = RequestMethod.POST)
    public Resp queryCustomer(CustomerQueryReq req) {
        req.setDomain(getCurrentUser().getDomain());
        if(StringUtils.isNotEmpty(req.getUid()))
        	req.setUid(req.getUid());
        else
        	req.setUid(getCurrentUser().getId());
        RespPage<List<CustomerDTO>> pageList = customerService.queryCustomerList(req);
        for (CustomerDTO cu : pageList.getData()) {
            cu.setLicenseNum(HideInfoUtils.hideIdentificationCard(cu.getLicenseNum()));
            cu.setMobile(HideInfoUtils.hidePhoneNo(cu.getMobile()));
        }
        return new Resp(pageList);
    }

    @ResponseBody
    @RequestMapping(value = "/removeBlackList", method = RequestMethod.POST)
    public Resp removeBlackList(String licenseNum) {
        blackListService.delete(getCurrentUser().getDomain(), licenseNum, getCurrentUser().getId());
        return new Resp();
    }

    @ResponseBody
    @RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
    public Resp saveCustomer(@Valid CustomerAddReq customer, BindingResult result) {
        Resp r = buildValidationFaildResponse(result);
        if (r.getStatus() == DATA_VALIDATION_ERROR) {
            return r;
        }
        CorpUserDTO user = getCurrentUser();
        if (!customerService.checkCustomerExist(null, user.getId(), customer.getLicenseNum(), user.getDomain())) {
            return Resp.buildErrorResponse("用户身份证号已经存在！");
        }
        if (!blackListService.checkCustomerBlackList(customer.getLicenseNum(), user.getDomain())) {
            return Resp.buildErrorResponse("用户身份证号已被添加黑名单！");
        }
        customer.setDomain(user.getDomain());
        customer.setCorpId(user.getCorpId());
        customer.setUid(user.getId());
        customerService.insert(customer.toCustomerAddDTO(), customer.getCustContacts(), customer.getDomain());
        return new Resp();
    }

}
