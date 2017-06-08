package org.risk.server.report.service;

import java.util.List;
import java.util.Map;

import org.risk.report.api.service.RepaymentOverdueService;
import org.risk.server.report.dao.RepaymentOverdueDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("risk.repaymentOverdueService")
public class RepaymentOverdueServiceImpl implements RepaymentOverdueService {

    @Autowired
    RepaymentOverdueDAO repaymentOverDAO;

    @Override
    public void insertRepaymentOverdue4Report(String domain) {
        repaymentOverDAO.insertRepaymentOverdue4Report(domain);
    }

    @Override
    public List<Map<String, String>> selectAllOverDay(String domain) {
        return repaymentOverDAO.selectAllOverDay(domain);
    }

}
