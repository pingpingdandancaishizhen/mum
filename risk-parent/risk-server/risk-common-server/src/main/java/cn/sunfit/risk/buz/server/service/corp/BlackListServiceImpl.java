package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.sunfit.risk.buz.api.beans.corp.BlackList;
import cn.sunfit.risk.buz.api.beans.corp.CustOperLog;
import cn.sunfit.risk.buz.api.service.corp.BlackListService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.corp.CustomerDTO;
import cn.sunfit.risk.buz.server.dao.corp.BlackListDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustOperLogDAO;
import cn.sunfit.risk.buz.server.dao.corp.CustomerDAO;

@Service("risk.blackListService")
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    BlackListDAO blackListDAO;

    @Autowired
    CustOperLogDAO custOperLogDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(String domain, String licenseNum, String uid) {
        BlackList record = new BlackList();
        record.setDomain(domain);
        record.setId(IdUtil.geneId());
        record.setLicenseNum(licenseNum);
        blackListDAO.insert(record);

        List<CustomerDTO> list = customerDAO.queryCustomerByLicenseNum(domain, licenseNum);
        for (CustomerDTO customerDTO : list) {
            CustOperLog log = CustOperLog.createCustOperLog(uid, customerDTO.getId(), CustOperLog.ADD_BLACKLIST,
                    "添加了黑名单客户[" + customerDTO.getName() + "]");
            custOperLogDAO.insert(log);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String domain, String licenseNum, String uid) {
        blackListDAO.delete(domain, licenseNum);

        List<CustomerDTO> list = customerDAO.queryCustomerByLicenseNum(domain, licenseNum);
        for (CustomerDTO customerDTO : list) {
            CustOperLog log = CustOperLog.createCustOperLog(uid, customerDTO.getId(), CustOperLog.REMOVE_BLACKLIST,
                    "移除了黑名单客户[" + customerDTO.getName() + "]");
            custOperLogDAO.insert(log);
        }
    }

    @Override
    public boolean checkCustomerBlackList(String licenseNum, String domain) {
        return blackListDAO.selectByLicenseNum(licenseNum, domain) == null;
    }

}
