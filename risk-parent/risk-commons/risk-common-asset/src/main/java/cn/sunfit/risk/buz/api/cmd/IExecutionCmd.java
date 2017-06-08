package cn.sunfit.risk.buz.api.cmd;

import java.util.Map;

public interface IExecutionCmd {

    // 可增加过期时间和优先级，暂未添加

    public String getDestNodeKey();

    public Map<String, String> getFormData();

    public String getNodeKey();

    public String getOperaType();

    public String getOption();

    public String getUserId();

    public void setNodeKey(String nodeKey);
}
