package cn.sunfit.risk.buz.server.service.api.jfjd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.api.jfjd.JFCustomerAddDTO;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.api.jfjd.JFCustomerService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.server.dao.api.jfjd.JFCustomerDAO;

@Service("jfjd.customerService")
public class JFCustomerServiceImpl implements JFCustomerService {

    @Autowired
    private JFCustomerDAO jFCustomerDAO;

    @Override
    public String insertCustomer(JFCustomerAddDTO dto) throws ServiceException {
        String id = jFCustomerDAO.checkCustomerExist(dto.getUid(), dto.getLicenseNum(), dto.getDomain());
        if (id != null) {
            // 客户已经存在。则不管 看看是否和名单
            long count1 = jFCustomerDAO.checkCustomerBlackList(dto.getLicenseNum(), dto.getDomain());
            if (count1 > 0) {
                throw new ServiceException("该客户属于黑名单客户");
            }
        } else {
            id = IdUtil.geneId();
            dto.setId(id);
            jFCustomerDAO.insert(dto);
        }
        return id;

    }

}
