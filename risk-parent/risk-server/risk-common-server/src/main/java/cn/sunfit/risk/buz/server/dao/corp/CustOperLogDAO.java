package cn.sunfit.risk.buz.server.dao.corp;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.corp.CustOperLog;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogDTO;
import cn.sunfit.risk.buz.api.vo.corp.CustOperLogQueryReq;

@Repository
public interface CustOperLogDAO {
    int insert(CustOperLog record);

    CustOperLog selectByPrimaryKey(String id);

    int updateByPrimaryKeyWithBLOBs(CustOperLog record);

    int updateByPrimaryKey(CustOperLog record);

    List<CustOperLogDTO> queryCustOperLogList(@Param("custLog") CustOperLogQueryReq req, RowBounds rowBounds);
}