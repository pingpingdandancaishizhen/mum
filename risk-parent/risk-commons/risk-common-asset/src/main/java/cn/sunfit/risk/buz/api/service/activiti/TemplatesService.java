package cn.sunfit.risk.buz.api.service.activiti;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.templates.MetaCategoryTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaFieldsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaFormsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaNodesTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaOperationsTemplates;
import cn.sunfit.risk.buz.api.beans.templates.MetaTemplates;
import cn.sunfit.risk.buz.api.vo.ReqBase;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.activiti.CategoryQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.FieldsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.FormsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.NodeQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.OperationsQueryReq;
import cn.sunfit.risk.buz.api.vo.activiti.UploadBpmnReq;

public interface TemplatesService {

    void addMetaCategoryTemplates(MetaCategoryTemplates t);

    void addMetaFieldsTemplates(MetaFieldsTemplates f);

    void addMetaFormsTemplates(MetaFormsTemplates f);

    void addMetaOperationsTemplates(MetaOperationsTemplates f);

    void copy(String bpDefId, String corpId, String domain);

    RespPage<List<MetaCategoryTemplates>> queryMetaCategoryTemplates(CategoryQueryReq req);

    List<MetaCategoryTemplates> queryMetaCategoryTemplatesAll(CategoryQueryReq req);

    RespPage<List<MetaFieldsTemplates>> queryMetaFieldsTemplates(FieldsQueryReq req);

    RespPage<List<MetaFormsTemplates>> queryMetaFormsTemplates(FormsQueryReq req);

    List<MetaFormsTemplates> queryMetaFormsTemplatesAll(FormsQueryReq req);

    RespPage<List<MetaNodesTemplates>> queryMetaNodesTemplates(NodeQueryReq req);

    RespPage<List<MetaOperationsTemplates>> queryMetaOperationsTemplates(OperationsQueryReq req);

    List<MetaOperationsTemplates> queryMetaOperationsTemplatesAll(OperationsQueryReq req);

    RespPage<List<MetaTemplates>> queryMetaTemplates(ReqBase req);

    void save(UploadBpmnReq req);

    void updateNodeFormKey(MetaNodesTemplates req);

    void updateNodeOperation(List<String> asList, String bpDefId, String nodeKey);
}
