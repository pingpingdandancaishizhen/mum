/*******************************************************************************
 * @Title: LayoutInfo.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.api.beans.metadata.form;

import java.util.List;

import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;

/**   
 * @Title: LayoutInfo.java
 * @Description: Form的UI Layout
 * @author zouxuejun
 * @date 2016年12月28日 上午10:18:46
 * @version V1.0   
 */
public class LayoutInfo extends ComponentInfo {

    private static final long serialVersionUID = -9101429001131284677L;

    private String layout;

    private List<TabInfo> groups;

    private List<CheckRuleInfo> rules;

    private List<RelationInfo> relations;

    private List<ButtonInfo> buttons;

    private String html;

    public List<ButtonInfo> getButtons() {
        return buttons;
    }

    public List<TabInfo> getGroups() {
        return groups;
    }

    public String getHtml() {
        return html;
    }

    public String getLayout() {
        return layout;
    }

    public List<RelationInfo> getRelations() {
        return relations;
    }

    public List<CheckRuleInfo> getRules() {
        return rules;
    }

    public void setButtons(List<ButtonInfo> buttons) {
        this.buttons = buttons;
    }

    public void setGroups(List<TabInfo> groups) {
        this.groups = groups;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public void setRelations(List<RelationInfo> relations) {
        this.relations = relations;
    }

    public void setRules(List<CheckRuleInfo> rules) {
        this.rules = rules;
    }

}
