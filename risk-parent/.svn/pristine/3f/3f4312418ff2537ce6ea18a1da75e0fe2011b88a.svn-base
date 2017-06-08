package cn.sunfit.risk.buz.server.util;

import java.util.Map;

import cn.sunfit.risk.buz.api.cmd.ProcessNextCmd;
import cn.sunfit.risk.buz.api.cmd.ProcessStartCmd;
import cn.sunfit.risk.buz.api.constants.OperationType;
import cn.sunfit.risk.buz.api.vo.form.FormQuery;

public class CmdUtil {

    public static ProcessNextCmd createNextCmd(FormQuery req, Map<String, String> formdata) {
        ProcessNextCmd cmd = new ProcessNextCmd();
        // cmd.setActInstId(actInstId);
        cmd.setBpDefId(req.getBpDefId());
        cmd.setBpDefKey(req.getBpDefKey());
        cmd.setBpId(req.getBpId());
        cmd.setCropId(req.getCorpId());
        cmd.setCustomerId(req.getCustomerId());
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
        cmd.setCustomerId(req.getCustomerId());
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
