package cn.sunfit.risk.buz.server.dao.generalinfo;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import cn.sunfit.risk.buz.api.beans.generalinfo.GeneralInfoListBean;
import cn.sunfit.risk.buz.api.vo.generalinfo.GeneralInfoQueryReq;

@Repository
public interface GeneralInfoDAO {

    List<GeneralInfoListBean> queryBaseList(GeneralInfoQueryReq req, RowBounds rowBounds);

    List<GeneralInfoListBean> queryBaseList4Export(GeneralInfoQueryReq req);

    List<GeneralInfoListBean> queryExtralList(GeneralInfoQueryReq req);
}
