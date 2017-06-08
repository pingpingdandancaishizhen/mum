package cn.sunfit.risk.buz.server.service.p2p.excel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sunfit.risk.buz.api.beans.p2p.P2PCustOperLog;
import cn.sunfit.risk.buz.api.service.p2p.excel.OperationLogService;
import cn.sunfit.risk.buz.server.dao.p2p.excel.OperationLogDAO;

@Service("risk.operationLogService")
public class OperationLogServiceImpl implements OperationLogService {
    @Autowired
    private OperationLogDAO operationLogDAO;
    
    @Override
    public void insertOperLog(P2PCustOperLog col) {
        // TODO Auto-generated method stub
        operationLogDAO.insertOperLog(col);
    }

}
