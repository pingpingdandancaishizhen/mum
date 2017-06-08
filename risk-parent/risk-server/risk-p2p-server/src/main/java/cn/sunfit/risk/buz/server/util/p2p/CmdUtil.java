package cn.sunfit.risk.buz.server.util.p2p;

import java.util.Map;

import cn.sunfit.risk.buz.api.constants.form.OperationType;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.FormQuery;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.cmd.ProcessNextCmd;
import cn.sunfit.risk.buz.api.vo.p2p.activiti.cmd.ProcessStartCmd;

public class CmdUtil {

    public static ProcessNextCmd createNextCmd(FormQuery req, Map<String, String> formdata) {
        ProcessNextCmd cmd = new ProcessNextCmd();
        // cmd.setActInstId(actInstId);
        cmd.setBpDefId(req.getBpDefId());
        cmd.setBpDefKey(req.getBpDefKey());
        cmd.setBpId(req.getBpId());
        cmd.setCropId(req.getCorpId());
        // cmd.setDestNodeKey(destNodeKey);
        cmd.setDomain(req.getDomain());
        cmd.setFormData(formdata);
        // cmd.setOperaType(Oper.NORMAL.getStatus());
        // cmd.setNodeKey(nodeKey);
        // cmd.setOption(option);
        cmd.setProductId(req.getProductId());
        cmd.setUserId(req.getUserId());
        cmd.setUserName(req.getUserName());
        cmd.setTaskId(req.getTaskId());
        return cmd;
    }

    public static ProcessStartCmd createStartCmd(FormQuery req, Map<String, String> formdata) {
        ProcessStartCmd cmd = new ProcessStartCmd();
        // cmd.setActInstId(actInstId);
        cmd.setBpDefId(req.getBpDefId());
        cmd.setBpDefKey(req.getBpDefKey());
        cmd.setBpId(req.getBpId());
        cmd.setCropId(req.getCorpId());
        // cmd.setDestNodeKey(destNodeKey);
        cmd.setDomain(req.getDomain());
        cmd.setFormData(formdata);
        cmd.setOperaType(OperationType.PASS.getStatus());
        // cmd.setNodeKey(nodeKey);
        // cmd.setOption(option);
        cmd.setProductId(req.getProductId());
        cmd.setUserId(req.getUserId());
        cmd.setUserName(req.getUserName());
        return cmd;
    }
}
