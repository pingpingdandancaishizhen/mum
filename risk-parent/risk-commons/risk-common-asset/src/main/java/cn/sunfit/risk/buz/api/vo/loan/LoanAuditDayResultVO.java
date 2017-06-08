package cn.sunfit.risk.buz.api.vo.loan;

import java.io.Serializable;

public class LoanAuditDayResultVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String days;

    private String nodeKey;

    private String nodeName;

    private Integer todo;

    private Integer done;

    private Integer pass;

    private Integer reject;

    private Integer back;

    private Double duration;

    public Integer getBack() {
        return back;
    }

    public String getDays() {
        return days;
    }

    public Integer getDone() {
        return done;
    }

    public Double getDuration() {
        return duration;
    }

    public String getNodeKey() {
        return nodeKey;
    }

    public String getNodeName() {
        return nodeName;
    }

    public Integer getPass() {
        return pass;
    }

    public Integer getReject() {
        return reject;
    }

    public Integer getTodo() {
        return todo;
    }

    public void setBack(Integer back) {
        this.back = back;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public void setDone(Integer done) {
        this.done = done;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setNodeKey(String nodeKey) {
        this.nodeKey = nodeKey;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public void setReject(Integer reject) {
        this.reject = reject;
    }

    public void setTodo(Integer todo) {
        this.todo = todo;
    }

}
