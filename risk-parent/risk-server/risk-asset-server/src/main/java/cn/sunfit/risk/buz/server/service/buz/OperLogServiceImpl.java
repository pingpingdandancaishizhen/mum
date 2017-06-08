package cn.sunfit.risk.buz.server.service.buz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orj.worf.mybatis.util.CountHelper;
import orj.worf.util.DateUtils;
import cn.sunfit.risk.buz.api.beans.buz.BPOperLog;
import cn.sunfit.risk.buz.api.constants.GlobalConstants;
import cn.sunfit.risk.buz.api.constants.OperationType;
import cn.sunfit.risk.buz.api.service.buz.OperLogService;
import cn.sunfit.risk.buz.api.utils.IdUtil;
import cn.sunfit.risk.buz.api.vo.RespPage;
import cn.sunfit.risk.buz.api.vo.buz.OperLogReq;
import cn.sunfit.risk.buz.api.vo.buz.OperLogReviewVO;
import cn.sunfit.risk.buz.api.vo.buz.OperLogSimpleVO;
import cn.sunfit.risk.buz.server.dao.buz.BPOperLogDAO;

@Service("risk.operLogService")
public class OperLogServiceImpl implements OperLogService {
    @Autowired
    private BPOperLogDAO bpOperLogDAO;

    @Override
    public void insert(BPOperLog log) {
        log.setLogTime(new Date());
        log.setLogId(IdUtil.geneId());
        bpOperLogDAO.insert(log);
    }

    @Override
    public RespPage<List<OperLogReviewVO>> queryReviewOperLog(OperLogReq req) {
        List<BPOperLog> list = bpOperLogDAO.selectBpOperLogReview(req, new RowBounds(req.getOffset(), req.getLimit()));
        List<OperLogReviewVO> volist = new ArrayList<OperLogReviewVO>();
        for (BPOperLog b : list) {
            OperLogReviewVO vo = new OperLogReviewVO();
            vo.setCurtask(b.getCurtask());
            vo.setLogOperType(OperationType.getLabelByStatus(b.getLogOperType()));
            vo.setLogTime(DateUtils.format(GlobalConstants.DATE_FORMAT_DATE_TIME, b.getLogTime()));
            vo.setOperUserName(b.getUserName());
            vo.setPretask(b.getPretask());
            vo.setReason(b.getReason());
            volist.add(vo);
        }
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<OperLogReviewVO>>(volist, totalCount);
    }

    @Override
    public RespPage<List<OperLogSimpleVO>> querySimpleOperLog(OperLogReq req) {
        List<BPOperLog> list = bpOperLogDAO.selectBpOperLog(req, new RowBounds(req.getOffset(), req.getLimit()));
        List<OperLogSimpleVO> volist = new ArrayList<OperLogSimpleVO>();
        for (BPOperLog b : list) {
            OperLogSimpleVO vo = new OperLogSimpleVO();
            vo.setContent(b.getContent());
            vo.setLogTime(DateUtils.format(GlobalConstants.DATE_FORMAT_DATE_TIME, b.getLogTime()));
            vo.setOperUserName(b.getUserName());
            volist.add(vo);
        }
        int totalCount = CountHelper.getTotalRow();
        return new RespPage<List<OperLogSimpleVO>>(volist, totalCount);
    }

}
