package cn.sunfit.risk.buz.server.service.corp;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.service.corp.CustOperLogService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogQueryReq;
import cn.sunfit.risk.buz.server.dao.corp.CustOperLogDAO;

@Service("risk.custOperLogService")
public class CustOperLogServiceImpl implements CustOperLogService {

    @Autowired
    CustOperLogDAO custOperLogDAO;

    @Override
    public RespPage<List<CustOperLogDTO>> queryCustOperLogList(CustOperLogQueryReq req) {
        List<CustOperLogDTO> data = custOperLogDAO.queryCustOperLogList(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<CustOperLogDTO>>(data, totalCount);
    }

}
