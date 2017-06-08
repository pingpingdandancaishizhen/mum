package cn.sunfit.risk.credit.api.vo;

import java.io.Serializable;

public class HitRule implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String uuid; // 规则uuid
    private String id; // 规则编号
    private String name; // 规则名称
    private String decision; // 该条规则决策结果
    private int score;

    public String getDecision() {
        return decision;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public String getUuid() {
        return uuid;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "HitRule [uuid=" + uuid + ", id=" + id + ", name=" + name + ", decision=" + decision + ", score="
                + score + "]";
    }

}
