package cn.sunfit.risk.buz.server.service.generalinfo;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.generalinfo.GeneralInfoListBean;
import cn.sunfit.risk.buz.api.constants.BpStatus;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.LoanTermType;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.loan.LoanChannel;
import cn.sunfit.risk.buz.api.constants.loan.LoanStatus;
import cn.sunfit.risk.buz.api.constants.repayment.RepaymentBaseStatus;
import cn.sunfit.risk.buz.api.service.generalinfo.GeneralInfoService;
import cn.sunfit.risk.buz.api.utils.HideInfoUtils;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.generalinfo.GeneralInfoQueryReq;
import cn.sunfit.risk.buz.server.dao.generalinfo.GeneralInfoDAO;

@Service("risk.generalInfoService")
public class GeneralInfoServiceImpl implements GeneralInfoService {

    @Autowired
    private GeneralInfoDAO generalInfoDAO;

    private void fillValueByKey(List<GeneralInfoListBean> list) {
        fillValueByKey4Export(list);
        for (GeneralInfoListBean bean : list) {
            bean.setPlusIcon("<i class='fa fa-fw fa-plus-square-o' style='cursor:pointer' onclick='showMoreOrder(this,\""
                    + bean.getCustId() + "\")'></i>" + bean.getBpNo());
            // 隐藏身份证信息
            if (StringUtils.isNotBlank(bean.getCustLicenseNo())) {
                bean.setCustLicenseNo(HideInfoUtils.hideIdentificationCard(bean.getCustLicenseNo()));
            }
        }
    }

    private void fillValueByKey4Export(List<GeneralInfoListBean> list) {
        for (GeneralInfoListBean bean : list) {
            // 还款状态
            if (StringUtils.isNotBlank(bean.getRepayStatus())) {
                bean.setRepayStatus(RepaymentBaseStatus.getNameByStatus(Integer.valueOf(bean.getRepayStatus()))
                        .getStatusName());
            }
            // 客户类型
            if (StringUtils.isNotBlank(bean.getCustType())) {
                bean.setCustType(CustomerType.getTypeNameStrByTypeId(bean.getCustType()));
            }
            // 申请还款方式，期限
            if (StringUtils.isNotBlank(bean.getLoanRepaymentMethod())) {
                bean.setApplyRepaymentMethodStr(LoanRepaymentType.getTypeNameByTypeId(bean.getLoanRepaymentMethod())
                        .getTypeName());
                if (LoanRepaymentType.YCXHQ
                        .equals(LoanRepaymentType.getTypeNameByTypeId(bean.getLoanRepaymentMethod()))) {
                    // 一次性还款
                    bean.setApplyPeriodStr(bean.getLoanApplyDaylyTerm() + "天");
                } else {
                    bean.setApplyPeriodStr(LoanTermType.getLabelByStatus(bean.getLoanApplyMonthlyTerm()));
                }
            }
            // 审批还款方式，期限
            if (StringUtils.isNotBlank(bean.getLoanApprovalRepaymentTypes())) {
                bean.setApprovalRepaymentTypeStr(LoanRepaymentType.getTypeNameByTypeId(
                        bean.getLoanApprovalRepaymentTypes()).getTypeName());
                if (LoanRepaymentType.YCXHQ.equals(LoanRepaymentType.getTypeNameByTypeId(bean
                        .getLoanApprovalRepaymentTypes()))) {
                    // 一次性还款
                    bean.setApprovalPeriodStr(bean.getLoanApprovalDaylyTerm() + "天");
                } else {
                    bean.setApprovalPeriodStr(LoanTermType.getLabelByStatus(bean.getLoanApprovalMonthlyTerm()));
                }
            }
            // 合同金额，保证金
            if (bean.getLoanApprovalAmount() != null && bean.getLoanApprovalBzjFee() != null) {
                BigDecimal baozhengjin = bean.getLoanApprovalAmount().multiply(bean.getLoanApprovalBzjFee())
                        .divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
                bean.setLoanApprovalBzjAmount(baozhengjin);
                bean.setContractAmount(bean.getLoanApprovalAmount().add(baozhengjin));
            }
            // 订单状态
            if (bean.getBpStatus() != null && bean.getLoanStatus() != null) {
                if (BpStatus.LOAN_ING.equals(BpStatus.getByStatus(bean.getBpStatus()))) {
                    bean.setOrderStatus(LoanStatus.getNameByStatus(bean.getLoanStatus()).getStatusName());
                } else if (BpStatus.LOAN_AFTER.equals(BpStatus.getByStatus(bean.getBpStatus()))) {
                    bean.setOrderStatus(BpStatus.LOAN_AFTER.getLabel());
                } else if (BpStatus.LOAN_FINISH.equals(BpStatus.getByStatus(bean.getBpStatus()))) {
                    bean.setOrderStatus(BpStatus.LOAN_FINISH.getLabel());
                } else {
                    if (StringUtils.isNotBlank(bean.getCurrentTaskName())) {
                        bean.setOrderStatus(bean.getCurrentTaskName().substring(1,
                                bean.getCurrentTaskName().length() - 1));
                    }
                }
            }
            // 订单来源
            if (StringUtils.isNotBlank(bean.getOrderSource())) {
                bean.setOrderSource(LoanChannel.getNameByStatus(bean.getOrderSource()).getStatusName());
            }
        }
    }

    @Override
    public RespPage<List<GeneralInfoListBean>> queryBaseList(GeneralInfoQueryReq req) {
        List<GeneralInfoListBean> resultList = generalInfoDAO.queryBaseList(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        fillValueByKey(resultList);
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<GeneralInfoListBean>>(resultList, totalCount);
    }

    @Override
    public List<GeneralInfoListBean> queryBaseList4Export(GeneralInfoQueryReq req) {
        List<GeneralInfoListBean> resultList = generalInfoDAO.queryBaseList4Export(req);
        fillValueByKey4Export(resultList);
        return resultList;
    }

    @Override
    public List<GeneralInfoListBean> queryExtralList(GeneralInfoQueryReq req) {
        List<GeneralInfoListBean> resultList = generalInfoDAO.queryExtralList(req);
        fillValueByKey(resultList);
        return resultList;
    }

    @Override
    public List<GeneralInfoListBean> queryExtralList4Export(GeneralInfoQueryReq req) {
        List<GeneralInfoListBean> resultList = generalInfoDAO.queryExtralList(req);
        fillValueByKey4Export(resultList);
        return resultList;
    }

}
