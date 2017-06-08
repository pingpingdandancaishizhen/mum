package cn.sunfit.risk.buz.api.service.generalinfo;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.generalinfo.GeneralInfoListBean;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.generalinfo.GeneralInfoQueryReq;

/**
 * 
 * @Title: GeneralInfoService.java
 * @Package cn.sunfit.risk.buz.api.service.generalinfo
 * @Description: TODO
 * @author RJS
 * @date 2017年4月26日 上午10:24:12
 * @version V1.0
 */
public interface GeneralInfoService {

    public RespPage<List<GeneralInfoListBean>> queryBaseList(GeneralInfoQueryReq req);

    public List<GeneralInfoListBean> queryBaseList4Export(GeneralInfoQueryReq req);

    public List<GeneralInfoListBean> queryExtralList(GeneralInfoQueryReq req);

    List<GeneralInfoListBean> queryExtralList4Export(GeneralInfoQueryReq req);
}
