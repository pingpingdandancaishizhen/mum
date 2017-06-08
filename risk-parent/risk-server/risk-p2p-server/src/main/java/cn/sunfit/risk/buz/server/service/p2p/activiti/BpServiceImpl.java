package cn.sunfit.risk.buz.server.service.p2p.activiti;

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
import cn.sunfit.risk.buz.api.beans.corp.CorpUser;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryDTO;
import cn.sunfit.risk.buz.api.beans.p2p.activiti.TodoQueryReq;
import cn.sunfit.risk.buz.api.constants.order.CustomerType;
import cn.sunfit.risk.buz.api.constants.order.GenderType;
import cn.sunfit.risk.buz.api.constants.order.LoanRepaymentType;
import cn.sunfit.risk.buz.api.constants.order.LoanUsageType;
import cn.sunfit.risk.buz.api.service.p2p.activiti.BpService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.corp.CorpDataRoleDTO;
import cn.sunfit.risk.buz.server.dao.corp.CorpDataRoleDAO;
import cn.sunfit.risk.buz.server.dao.corp.CorpUserDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPMetaNodeDAO;
import cn.sunfit.risk.buz.server.dao.p2p.activiti.BPOperLogDAO;

@Service("risk.p2p.bpService")
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
            if (StringUtils.isNotBlank(corpDataRoleDTO.getDepts())) {
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

    @Override
    public List<BPMetaNode> selectAllBPMetaNode(String domain) {
        return bpMetaNodeDAO.selectAllBPMetaNode(domain);
    }

    @Override
    public List<BPMetaNode> selectBPMetaNodeByProduct(String domain, String product) {
        return bpMetaNodeDAO.selectBPMetaNodeByProduct(domain, product);
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
            if (!StringUtils.isBlank(bpQueryDTO.getCurrentTaskName())) {
                String currentTaskName = bpQueryDTO.getCurrentTaskName();
                bpQueryDTO.setCurrentTaskName(currentTaskName.substring(1, currentTaskName.length() - 1));
            }
        }
        /*
         * if (!bpids.isEmpty()) { List<BPOperLog> logs = bpOperLogDAO.selectLastestLogReview(bpids, req.getDomain());
         * for (TodoQueryDTO bpQueryDTO : result) { for (BPOperLog log : logs) { if (StringUtils.equals(log.getBpId(),
         * bpQueryDTO.getBpId())) { bpQueryDTO.setPreOper(StringUtils.replace(log.getPretask(), ",", "") + '-' +
         * OperationType.getLabelByStatus(log.getLogOperType()));
         * bpQueryDTO.setPreReason(StringUtils.abbreviate(log.getReason(), 13)); break; } } } }
         */
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<TodoQueryDTO>>(result, totalCount);
    }
}
