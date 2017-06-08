package cn.sunfit.risk.buz.api.service.corp;

import java.util.List;

import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogQueryReq;

public interface CustOperLogService {

    RespPage<List<CustOperLogDTO>> queryCustOperLogList(CustOperLogQueryReq req);

}
