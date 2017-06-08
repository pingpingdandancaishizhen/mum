package cn.sunfit.risk.buz.server.service.p2p.order;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import orj.worf.mybatis.util.CountHelper;
import orj.worf.util.JsonUtils;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaOperation;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoAttachment;
import cn.sunfit.risk.buz.api.beans.system.DataDic;
import cn.sunfit.risk.buz.api.constants.form.OperationType;
import cn.sunfit.risk.buz.api.constants.order.LoanHandleType;
import cn.sunfit.risk.buz.api.constants.order.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.order.OrderStatus;
import cn.sunfit.risk.buz.api.exception.ServiceException;
import cn.sunfit.risk.buz.api.service.p2p.activiti.SuperFormService;
import cn.sunfit.risk.buz.api.service.p2p.order.OrderService;
import cn.sunfit.risk.buz.api.service.p2p.product.P2PProductService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpUserDTO;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.api.vo.p2p.excel.LoanInfoQueryReq;
import cn.sunfit.risk.buz.api.vo.p2p.order.OrderListBean;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.CydFeeConfig;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaOperationDAO;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoAttachDAO;
import cn.sunfit.risk.buz.server.dao.p2p.order.LoanInfoDAO;
import cn.sunfit.risk.buz.server.dao.system.DataDicDAO;
import cn.sunfit.risk.buz.util.p2p.DateUtil;

@Service("risk.p2p.orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private LoanInfoDAO loanInfoDAO;
    @Autowired
    private LoanInfoAttachDAO loanInfoAttachDAO;

    @Autowired
    private DataDicDAO dataDicDAO;

    private Map<String, List<DataDic>> dicMap;
    @Autowired
    private SuperFormService superFormService;
    @Autowired
    private P2PProductService p2pProductService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private BPMetaOperationDAO bpMetaOperationDAO;

    @Override
    public void batchSubmit(CorpUserDTO currentUser, Long[] ids) throws ServiceException {
        // 查询FORMREQ
        Assert.noNullElements(ids);
        // 验证是否都是新增状态活着退回状态
        String[] status = new String[] { OrderStatus.ADD.getStatus(), OrderStatus.BACK.getStatus() };
        long count = loanInfoDAO.countLoanInfoStatus(currentUser.getDomain(), ids, status);
        if (count != ids.length) {
            throw new ServiceException("数据异常");
        }
        List<FormQuery> querys = loanInfoDAO.selectFormQuery(currentUser.getDomain(), ids);
        for (FormQuery f : querys) {
            f.setCorpInfo(currentUser);
            P2PProduct product = p2pProductService.findByProductCode(f.getProductId(), f.getDomain());
            CydFeeConfig feeConfig = JsonUtils.parseJSON(product.getFeeConfig(), CydFeeConfig.class);
            Map<String, String> formdata = new HashMap<String, String>();
            formdata.put("to_node", feeConfig.getAutoTypeCheck());
            // 查询该步提交操作
            Task task = taskService.createTaskQuery().taskId(f.getTaskId()).singleResult();
            BPMetaOperation o = bpMetaOperationDAO.selectNodeOperationByType(f.getCorpId(), f.getDomain(),
                    f.getBpDefId(), task.getTaskDefinitionKey(), OperationType.PASS.getStatus());
            if (o != null)
                formdata.put("operation", o.getOperKey());
            // 貌似回退的，还需要换不同的操作
            superFormService.submit(f, formdata);
        }
    }

    @Override
    public void cancle(CorpUserDTO currentUser, Long[] ids) throws ServiceException {
        // 查询FORMREQ
        Assert.noNullElements(ids);
        // 验证是否都是新增状态活着退回状态
        String[] status = new String[] { OrderStatus.ADD.getStatus(), OrderStatus.BACK.getStatus() };
        long count = loanInfoDAO.countLoanInfoStatus(currentUser.getDomain(), ids, status);
        if (count != ids.length) {
            throw new ServiceException("数据异常");
        }
        List<FormQuery> querys = loanInfoDAO.selectFormQuery(currentUser.getDomain(), ids);
        for (FormQuery f : querys) {
            f.setCorpInfo(currentUser);
            // P2PProduct product = p2pProductService.findByProductCode(f.getProductId(), f.getDomain());
            // XydFeeConfig feeConfig = JsonUtils.parseJSON(product.getFeeConfig(), XydFeeConfig.class);
            Map<String, String> formdata = new HashMap<String, String>();
            // formdata.put("to_node", feeConfig.getAutoTypeCheck());
            // 查询该步提交操作
            Task task = taskService.createTaskQuery().taskId(f.getTaskId()).singleResult();
            BPMetaOperation o = bpMetaOperationDAO.selectNodeOperationByType(f.getCorpId(), f.getDomain(),
                    f.getBpDefId(), task.getTaskDefinitionKey(), OperationType.REJECT.getStatus());
            if (o != null)
                formdata.put("operation", o.getOperKey());
            else
                throw new ServiceException("当前任务不支持此操作");
            // 貌似回退的，还需要换不同的操作
            superFormService.submit(f, formdata);
        }
    }

    @Override
    public LoanInfoAttachment insertLoanInfoAttach(LoanInfoAttachment attach, CorpUserDTO user) {
        attach.setCreateTime(DateUtil.getDateTime(new Date()));
        attach.setCreateUser(user.getId());
        loanInfoAttachDAO.insert(attach, user.getDomain());
        return attach;
    }

    private void orderListBeanFill(OrderListBean bean, LoanInfoQueryReq req) {
        bean.setAproveStatusStr(OrderStatus.getLabelByStatus(bean.getAproveStatus()));
        bean.setLoanHandleType(LoanHandleType.getLabelByStatus(bean.getLoanHandleType()));
        LoanRepaymentType repayType = LoanRepaymentType.getTypeNameByTypeId(bean.getRepayType());
        if (repayType != null) {
            bean.setRepayType(repayType.getTypeName());
        }
        bean.setGender(valueFill(req.getCorpId(), req.getDomain(), bean.getProductCode(), "cust_license_num_gender",
                bean.getGender()));
        bean.setCustomerType(valueFill(req.getCorpId(), req.getDomain(), bean.getProductCode(), "cust_type",
                bean.getCustomerType()));
        bean.setRepayType(valueFill(req.getCorpId(), req.getDomain(), bean.getProductCode(),
                "loan_apply_repaymentTypes", bean.getRepayType()));
    }

    @Override
    public List<OrderListBean> queryCustAllLoanInfo(LoanInfoQueryReq req) {
        List<OrderListBean> list = loanInfoDAO.queryCustAllLoanInfo(req);
        for (OrderListBean imp : list) {
            orderListBeanFill(imp, req);
        }
        return list;
    }

    @Override
    public RespPage<List<OrderListBean>> queryLoanInfoList(LoanInfoQueryReq req) {
        List<OrderListBean> list = loanInfoDAO.queryLoanInfoList(req, new RowBounds(req.getOffset(), req.getLimit()));
        for (OrderListBean imp : list) {
            imp.setPlusIdIcon("need");
            orderListBeanFill(imp, req);
        }
        final int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<OrderListBean>>(list, totalCount);
    }

    @Override
    public void removeAttach(Long attachId, CorpUserDTO user) {
        loanInfoAttachDAO.backup(attachId, user.getDomain());
        loanInfoAttachDAO.delete(attachId, user.getDomain());
    }

    private String valueFill(String corpId, String domain, String productCode, String field, String key) {
        String result = key;
        if (dicMap == null) {
            dicMap = new HashMap<String, List<DataDic>>();
        }
        String provider = dataDicDAO.getFieldProvider(domain, field, productCode);
        if (StringUtils.isNotBlank(provider)) {
            if (dicMap.get(provider) == null || dicMap.get(provider).size() <= 0) {
                dicMap.put(provider, dataDicDAO.getDicByField(domain, corpId, productCode, provider));
            }
            List<DataDic> dicList = dicMap.get(provider);
            if (!dicList.isEmpty()) {
                for (DataDic dic : dicList) {
                    if (StringUtils.isNotBlank(key) && key.equals(dic.getDicKey())) {
                        result = dic.getDicValue();
                        break;
                    }
                }
            }
        }
        return result;
    }
}
