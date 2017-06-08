/*******************************************************************************
 * @Title: Snippet.java
 *
 * @Copyright (c) 2017 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.web.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cn.sunfit.risk.buz.api.beans.metadata.BPMetaDTO;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaForm;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaNode;
import cn.sunfit.risk.buz.api.beans.metadata.rule.CheckRuleInfo;

/**   
 * @Title: Snippet.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2017年1月3日 下午4:43:52
 * @version V1.0   
 */
public class BPMetaUtils {

    public static List<CheckRuleInfo> parseCheckRuleAsList(String checkRuleStr) throws Exception {
        List<CheckRuleInfo> ruleList = new ArrayList<CheckRuleInfo>();
        return JsonUtil.jsonStrToObject(checkRuleStr, ruleList.getClass());
    }

    public static BPMetaNode findNode(BPMetaDTO bpMetaDTO, String nodeKey) {
        for (BPMetaNode node : bpMetaDTO.getNodes()) {
            if (StringUtils.equals(nodeKey, node.getNodeKey())) {
                return node;
            }
        }
        return null;
    }

    public static BPMetaForm findForm(BPMetaDTO bpMetaDTO, String formKey) {
        for (BPMetaForm form : bpMetaDTO.getForms()) {
            if (StringUtils.equals(formKey, form.getFormKey())) {
                return form;
            }
        }
        return null;
    }

}
