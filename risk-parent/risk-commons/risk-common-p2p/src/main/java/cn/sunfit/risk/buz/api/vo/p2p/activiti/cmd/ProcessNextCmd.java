package cn.sunfit.risk.buz.api.vo.p2p.activiti.cmd;

public class ProcessNextCmd extends AbstractExecutionCmd {
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

}
