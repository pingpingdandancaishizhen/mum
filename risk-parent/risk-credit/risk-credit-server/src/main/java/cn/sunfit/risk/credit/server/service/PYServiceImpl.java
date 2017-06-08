package cn.sunfit.risk.credit.server.service;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import net.sf.json.JSONObject;

import org.codehaus.xfire.client.Client;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.sunfit.risk.credit.api.exception.ServiceException;
import cn.sunfit.risk.credit.api.service.PYService;
import cn.sunfit.risk.credit.server.util.XMLUtil;

/**
 * 鹏元征信接口
 * @Title: PYServiceImpl.java
 * @Package cn.sunfit.risk.credit.server.service
 * @Description: TODO
 * @author XJ
 * @date 2017年4月24日 下午2:32:12
 * @version V1.0
 */
@Path("py")
@Service("credit.PYService")
public class PYServiceImpl implements PYService {

    /**
     * 查询账户信息
     * @return
     */
    @POST
    @Path("singleQuery")
    @Override
    public String singleQuery(String req) throws ServiceException {
        JSONObject ob = null;
        try {
            ob = JSONObject.fromObject(req);
            String queryInfo = "";
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("name", ob.get("name"));
            map.put("documentNo", ob.get("documentNo").toString());
            map.put("subreportIDs", ob.get("subreportIDs").toString());
            map.put("queryReasonID", ob.get("queryReasonID").toString());
            queryInfo = XMLUtil.createXML4PYRequest(ob.get("queryType").toString(), map);

            Client client = new Client(new URL("http://120.234.16.170:4129/services/WebServiceSingleQuery?wsdl"));

            Object[] results = client.invoke("queryReport", new Object[] { "查询账户", "账户密文", queryInfo, "xml" });

            if (results[0] instanceof String) {
                System.out.println("resut:" + results[0].toString());
                return results[0].toString();
            } else if (results[0] instanceof Document) {
                Document doc = (Document) results[0];
                Element element = doc.getDocumentElement();
                NodeList children = element.getChildNodes();
                Node node = children.item(0);
                System.out.println("result content:" + node.getNodeValue());
                return node.getNodeValue();
            }
        } catch (Exception e) {
            throw new ServiceException("接口异常");
        }
        return "";
    }

}
