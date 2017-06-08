package cn.sunfit.risk.buz.api.service.solution;

import java.util.Map;

import cn.sunfit.risk.buz.api.beans.buz.BP;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.form.FormData;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;
import cn.sunfit.risk.buz.api.vo.loan.RestartReq;

/**
 * 
 * @Title: SuperFormService.java
 * @Package cn.sunfit.risk.buz.api.service.solution
 * @Description: 主管流程中表单极其交互
 * @author XFL
 * @date 2017年3月3日 上午9:43:03
 * @version V1.0
 */
public interface SuperFormService {
    /**
     * @Title: queryNodeFormData
     * @Description: 根据参数获取表单，以及BPS的值
     * @param @param req
     * @param @return   
     * @return FormData 
     * @author XFL 2017年1月13日 
     * @throws
     */
    FormData queryNodeFormData(FormQuery req) throws ServiceException;

    /**
     * 
     * @Title: queryNodeFormData4View
     * @Description: 查询查看表单
     * @param @param req
     * @param @return   
     * @return FormData 
     * @author XFL 2017年2月8日 
     * @throws
     */
    FormData queryNodeFormData4View(FormQuery req) throws ServiceException;

    /**
     * 
     * @Title: restart
     * @Description: 启用单据
     * @param @param req   
     * @return void 
     * @author XFL 2017年2月9日 
     * @throws
     */
    void restart(RestartReq req) throws ServiceException;

    /**
     * 
     * @Title: saveDraft
     * @Description: 保存草稿
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    void saveDraft(FormQuery req, Map<String, String> formdata) throws ServiceException;

    /**
     * 
     * @Title: submit
     * @Description: 提交流程
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author XFL 2017年1月14日 
     * @throws
     */
    BP submit(FormQuery req, Map<String, String> formdata) throws ServiceException;
}
