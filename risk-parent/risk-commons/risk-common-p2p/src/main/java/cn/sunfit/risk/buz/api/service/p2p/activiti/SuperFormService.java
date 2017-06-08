package cn.sunfit.risk.buz.api.service.p2p.activiti;

import java.util.Map;

import cn.sunfit.risk.buz.api.beans.p2p.activiti.BP;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormData;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;

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
     * 
     * @Title: editForm
     * @Description: 修改表单的字段值，但是不提交流程
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author DELL 2017年5月4日 
     * @throws
     */
    void editFormData(FormQuery req, Map<String, String> formdata) throws ServiceException;

    /**
     * @Title: editFormDataDraft
     * @Description: 保存草稿
     * @param @param req
     * @param @param formdata   
     * @return void 
     * @author DELL 2017年5月5日 
     * @throws
     */
    void editFormDataDraft(FormQuery req, Map<String, String> formdata);

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
     * @Title: queryNodeFormData4Edit
     * @Description: 查询编辑表单
     * @param @param req
     * @param @return   
     * @return FormData 
     * @author DELL 2017年5月4日 
     * @throws
     */
    FormData queryNodeFormData4Edit(FormQuery req);

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
