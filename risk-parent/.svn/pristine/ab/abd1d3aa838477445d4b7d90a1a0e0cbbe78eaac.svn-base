package cn.sunfit.risk.buz.server.service.corp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.beans.buz.BPOperLog;
import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.constants.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.LoanUsageType;
import cn.sunfit.risk.buz.api.constants.OperationType;
import cn.sunfit.risk.buz.api.constants.customer.CustomerType;
import cn.sunfit.risk.buz.api.constants.customer.GenderType;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.vo.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.vo.contract.ContractDTO;
import cn.sunfit.risk.buz.api.vo.contract.ContractQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryDTO;
import cn.sunfit.risk.buz.api.vo.corp.BpQueryReq;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.server.dao.buz.BPDAO;
import cn.sunfit.risk.buz.server.dao.buz.BPOperLogDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDataRoleDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaNodeDAO;

@Service("risk.bpService")
public class BpServiceImpl implements BpService {

    @Autowired
    BPDAO bpDAO;

    @Autowired
    BPMetaNodeDAO bpMetaNodeDAO;

    @Autowired
    CorpDataRoleDAO corpDataRoleDAO;

    @Autowired
    private CorpUserDAO corpUserDAO;
    @Autowired
    private BPOperLogDAO bpOperLogDAO;

    @Override
    public List<String> getDataRole(String userId, String corpId) {
        List<String> result = new ArrayList<String>();
        // 有权限的用户Id
        Set<String> userIdList = new HashSet<String>();
        // 有权限的部门Id
        List<String> deptList = new ArrayList<String>();

        // 用户数据权限角色集合
        List<CorpDataRoleDTO> dataRoleList = corpDataRoleDAO.selectUserCorpDataRole(userId, corpId);
        for (CorpDataRoleDTO corpDataRoleDTO : dataRoleList) {
            if (corpDataRoleDTO.getDepts() != null) {
                List<String> depts = Arrays.asList(corpDataRoleDTO.getDepts().split(","));
                deptList.addAll(depts);
            }
            // 若仅本人
            if (StringUtils.equals(corpDataRoleDTO.getSelfOnly(), "1")) {
                userIdList.add(userId);
            }
            // 若仅本部门
            if (StringUtils.equals(corpDataRoleDTO.getDeptOnly(), "1")) {
                CorpUser createUser = corpUserDAO.selectByPrimaryKey(userId);
                deptList.add(createUser.getDeptId());
            }
        }
        List<String> temp = corpUserDAO.selectUserByDeptId(deptList);
        userIdList.addAll(temp);
        for (String id : userIdList) {
            result.add(id);
        }
        return result;
    }

    private List<BpQueryDTO> getLoanList(BpQueryReq req) {
        List<BpQueryDTO> result = bpDAO.selectMyBorrowList(req, new RowBounds(req.getOffset(), req.getLimit()));
        for (BpQueryDTO bpQueryDTO : result) {
            GenderType genderType = GenderType.getNameByStatus(bpQueryDTO.getCustGender());
            if (genderType != null) {
                bpQueryDTO.setCustGenderStr(genderType.getName());
            }
            CustomerType customerType = CustomerType.getTypeNameByTypeId(bpQueryDTO.getCustType());
            if (customerType != null) {
                bpQueryDTO.setCustTypeStr(customerType.getTypeName());
            }
            LoanUsageType loanUsageType = LoanUsageType.getTypeNameByTypeId(bpQueryDTO.getLoanUsage());
            if (loanUsageType != null) {
                bpQueryDTO.setLoanUsageStr(loanUsageType.getTypeName());
            }
            LoanRepaymentType loanRepaymentType = LoanRepaymentType.getTypeNameByTypeId(bpQueryDTO
                    .getLoanRepaymentMethod());
            if (loanRepaymentType != null) {
                bpQueryDTO.setLoanRepaymentMethodStr(loanRepaymentType.getTypeName());
            }
            bpQueryDTO.setLoanApprovalRepaymentMethodStr(LoanRepaymentType.getTypeNameStrByTypeId(bpQueryDTO
                    .getLoanApprovalRepaymentMethod()));
            // if (!StringUtils.isBlank(bpQueryDTO.getCurrentTaskName())) {
            // String currentTaskName = bpQueryDTO.getCurrentTaskName();
            // bpQueryDTO.setCurrentTaskName(currentTaskName.substring(1, currentTaskName.length() - 1));
            // }
        }
        return result;
    }

    @Override
    public RespPage<List<ContractDTO>> queryContractList(ContractQueryReq req) {
        List<ContractDTO> result = bpDAO.queryContractList(req, new RowBounds(req.getOffset(), req.getLimit()));
        for (ContractDTO contractDTO : result) {
            GenderType genderType = GenderType.getNameByStatus(contractDTO.getCustGender());
            if (genderType != null) {
                contractDTO.setCustGenderStr(genderType.getName());
            }
            CustomerType customerType = CustomerType.getTypeNameByTypeId(contractDTO.getCustType());
            if (customerType != null) {
                contractDTO.setCustTypeStr(customerType.getTypeName());
            }
            LoanUsageType loanUsageType = LoanUsageType.getTypeNameByTypeId(contractDTO.getLoanUsage());
            if (loanUsageType != null) {
                contractDTO.setLoanUsageStr(loanUsageType.getTypeName());
            }
            LoanRepaymentType loanRepaymentType = LoanRepaymentType.getTypeNameByTypeId(contractDTO
                    .getLoanRepaymentMethod());
            if (loanRepaymentType != null) {
                contractDTO.setLoanRepaymentMethodStr(loanRepaymentType.getTypeName());
            }
            contractDTO.setLoanApprovalRepaymentMethodStr(LoanRepaymentType.getTypeNameStrByTypeId(contractDTO
                    .getLoanApprovalRepaymentMethod()));
            // if (!StringUtils.isBlank(contractDTO.getCurrentTaskName())) {
            // String currentTaskName = contractDTO.getCurrentTaskName();
            // contractDTO.setCurrentTaskName(currentTaskName.substring(1, currentTaskName.length() - 1));
            // }
        }
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<ContractDTO>>(result, totalCount);
    }

    @Override
    public List<BPMetaNode> selectAllBPMetaNode(String domain) {
        return bpMetaNodeDAO.selectAllBPMetaNode(domain);
    }

    @Override
    public RespPage<List<BpQueryDTO>> selectAllLoanList(BpQueryReq req) {
        req.setUids(getDataRole(req.getUid(), req.getCorpId()));
        List<BpQueryDTO> list = getLoanList(req);
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<BpQueryDTO>>(list, totalCount);
    }

    @Override
    public List<BPMetaNode> selectBPMetaNodeByProduct(String domain, String product) {
        return bpMetaNodeDAO.selectBPMetaNodeByProduct(domain, product);
    }

    @Override
    public RespPage<List<BpQueryDTO>> selectMyLoanList(BpQueryReq req) {
        List<String> uids = new ArrayList<String>();
        uids.add(req.getUid());
        req.setUids(uids);
        List<BpQueryDTO> list = getLoanList(req);
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<BpQueryDTO>>(list, totalCount);
    }

    @Override
    public RespPage<List<TodoQueryDTO>> selectTodoList(TodoQueryReq req) {
        List<TodoQueryDTO> result = bpDAO.selectTodoList(req, new RowBounds(req.getOffset(), req.getLimit()));
        List<String> bpids = new ArrayList<String>();
        for (TodoQueryDTO bpQueryDTO : result) {
            bpids.add(bpQueryDTO.getBpId());
            GenderType genderType = GenderType.getNameByStatus(bpQueryDTO.getCustGender());
            if (genderType != null) {
                bpQueryDTO.setCustGenderStr(genderType.getName());
            }
            CustomerType customerType = CustomerType.getTypeNameByTypeId(bpQueryDTO.getCustType());
            if (customerType != null) {
                bpQueryDTO.setCustTypeStr(customerType.getTypeName());
            }
            LoanUsageType loanUsageType = LoanUsageType.getTypeNameByTypeId(bpQueryDTO.getLoanUsage());
            if (loanUsageType != null) {
                bpQueryDTO.setLoanUsageStr(loanUsageType.getTypeName());
            }
            LoanRepaymentType loanRepaymentType = LoanRepaymentType.getTypeNameByTypeId(bpQueryDTO
                    .getLoanRepaymentMethod());
            if (loanRepaymentType != null) {
                bpQueryDTO.setLoanRepaymentMethodStr(loanRepaymentType.getTypeName());
            }
            bpQueryDTO.setLoanApprovalRepaymentMethodStr(LoanRepaymentType.getTypeNameStrByTypeId(bpQueryDTO
                    .getLoanApprovalRepaymentMethod()));
            if (!StringUtils.isBlank(bpQueryDTO.getCurrentTaskName())) {
                String currentTaskName = bpQueryDTO.getCurrentTaskName();
                bpQueryDTO.setCurrentTaskName(currentTaskName.substring(1, currentTaskName.length() - 1));
            }
        }
        if (!bpids.isEmpty()) {
            List<BPOperLog> logs = bpOperLogDAO.selectLastestLogReview(bpids, req.getDomain());
            for (TodoQueryDTO bpQueryDTO : result) {
                for (BPOperLog log : logs) {
                    if (StringUtils.equals(log.getBpId(), bpQueryDTO.getBpId())) {
                        bpQueryDTO.setPreOper((StringUtils.isBlank(log.getHandleTaskName()) ? StringUtils.replace(
                                log.getPretask(), ",", "") : log.getHandleTaskName())
                                + '-' + OperationType.getLabelByStatus(log.getLogOperType()));
                        bpQueryDTO.setPreReason(StringUtils.abbreviate(log.getReason(), 13));
                        break;
                    }
                }
            }
        }
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<TodoQueryDTO>>(result, totalCount);
    }
}
