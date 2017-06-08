/*******************************************************************************
 * @Title: BPUtils.java
 *
 * @Copyright (c) 2016 深圳前海融金所互联网金融服务有限公司 版权所有. 粤ICP备13026617号
 * 注意：本内容仅限于深圳前海融金所互联网金融服务有限公司 内部传阅，禁止外泄以及用于其他商业目的!
 ******************************************************************************/
package cn.sunfit.risk.buz.server.service.buz;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import orj.worf.exception.FastRuntimeException;
import cn.sunfit.risk.buz.api.beans.metadata.BPMetaField;

/**   
 * @Title: BPUtils.java
 * @Description: TODO
 * @author zouxuejun
 * @date 2016年12月9日 上午11:13:34
 * @version V1.0   
 */
public class BPUtils {

    public static BPMetaField findField(String fieldKey, List<BPMetaField> fieldList) {
        for (BPMetaField field : fieldList) {
            if (StringUtils.equals(field.getFieldKey(), fieldKey)) {
                return field;
            }
        }
        return null;
    }

    public static String parseBpDefIdFromBuzKey(String businessKey) {
        String[] strs = StringUtils.split(businessKey, ':');
        if (strs.length != 5) {
            throw new FastRuntimeException("invalid business key");
        }
        return strs[4];
    }

    public static String parseCorpIdFromBuzKey(String businessKey) {
        String[] strs = StringUtils.split(businessKey, ':');
        if (strs.length != 5) {
            throw new FastRuntimeException("invalid business key");
        }
        return strs[0];
    }

    public static String parseDefKeyFromBuzKey(String businessKey) {
        String[] strs = StringUtils.split(businessKey, ':');
        if (strs.length != 5) {
            throw new FastRuntimeException("invalid business key");
        }
        return strs[1];
    }

    public static String parseIdFromBuzKey(String businessKey) {
        String[] strs = StringUtils.split(businessKey, ':');
        if (strs.length != 5) {
            throw new FastRuntimeException("invalid business key");
        }
        return strs[3];
    }

    public static String parseVersionFromBuzKey(String businessKey) {
        String[] strs = StringUtils.split(businessKey, ':');
        if (strs.length != 5) {
            throw new FastRuntimeException("invalid business key");
        }
        return strs[2];
    }

    public static String toBusinessKey(String corpId, String bpDefKey, String version, String bpId, String bpDefId) {
        return corpId + ":" + bpDefKey + ":" + version + ":" + bpId + ":" + bpDefId;
    }
}
