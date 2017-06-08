package cn.sunfit.risk.buz.server.service.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import cn.sunfit.risk.buz.api.service.corp.BpService;
import cn.sunfit.risk.buz.api.service.solution.AuditService;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditDayResultVO;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryReq;
import cn.sunfit.risk.buz.api.vo.loan.LoanAuditQueryVO;
import cn.sunfit.risk.buz.server.dao.buz.BPLoanAuditDAO;
import cn.sunfit.risk.buz.server.dao.metadata.BPMetaNodeDAO;

@Service("risk.auditService")
public class AuditServiceImpl implements AuditService {

    @Autowired
    private BpService bpService;
    @Autowired
    private BPLoanAuditDAO bpLoanAuditDAO;
    @Autowired
    private BPMetaNodeDAO bpMetaNodeDAO;

    // 封装一下
    private Map<String, List<LoanAuditDayResultVO>> packageDayResult(// List<BPMetaNode> nodes,
            List<LoanAuditDayResultVO> list) {
        Map<String, List<LoanAuditDayResultVO>> map = new LinkedHashMap<String, List<LoanAuditDayResultVO>>();
        for (LoanAuditDayResultVO vo : list) {
            if (map.get(vo.getDays()) == null) {
                map.put(vo.getDays(), new ArrayList<LoanAuditDayResultVO>());
            }
            List<LoanAuditDayResultVO> tmp = map.get(vo.getDays());
            tmp.add(vo);
        }
        return map;
    }

    @Override
    public RespPage<List<LoanAuditQueryVO>> queryAllAuditList(LoanAuditQueryReq req) {
        // 获取数据全选
        List<String> userIds = bpService.getDataRole(req.getUserId(), req.getCorpId());
        // 查询手下人进入查询节点的表单
        req.setUids(userIds);
        List<LoanAuditQueryVO> list = bpLoanAuditDAO.selectAllAuditList(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int count = CountHelper.getTotalRow();
        return new RespPage<List<LoanAuditQueryVO>>(list, count);
    }

    @Override
    public RespPage<List<LoanAuditQueryVO>> queryAllHistoryAuditList(LoanAuditQueryReq req) {
        List<String> userIds = bpService.getDataRole(req.getUserId(), req.getCorpId());
        // 查询手下人进入查询节点的表单
        req.setUids(userIds);
        List<LoanAuditQueryVO> list = bpLoanAuditDAO.selectAllHistoryAuditList(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int count = CountHelper.getTotalRow();
        return new RespPage<List<LoanAuditQueryVO>>(list, count);
    }

    @Override
    public Map<String, List<LoanAuditDayResultVO>> queryAuditDayList(LoanAuditDayQueryReq req) {
        // List<BPMetaNode> nodes = bpMetaNodeDAO.selectAuditNodeByProduct(null, req.getDomain());
        List<LoanAuditDayResultVO> list = bpLoanAuditDAO.selectAuditDayList(req);
        // return packageDayResult(nodes,list);
        return packageDayResult(list);
    }

    @Override
    public RespPage<List<LoanAuditQueryVO>> queryMyAuditList(LoanAuditQueryReq req) {
        // 查询手下人进入查询节点的表单
        req.setUids(Arrays.asList(new String[] { req.getUserId() }));
        List<LoanAuditQueryVO> list = bpLoanAuditDAO.selectAllHistoryAuditList(req,
                new RowBounds(req.getOffset(), req.getLimit()));
        int count = CountHelper.getTotalRow();
        return new RespPage<List<LoanAuditQueryVO>>(list, count);
    }
}
