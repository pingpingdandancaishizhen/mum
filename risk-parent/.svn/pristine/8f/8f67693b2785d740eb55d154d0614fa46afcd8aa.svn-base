package cn.sunfit.risk.credit.server.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLUtil {

    private static final Logger logger = Logger.getLogger(XMLUtil.class);

    public static String createXML4PYRequest(String queryType, Map<String, Object> params) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("conditions");
        Element condition = root.addElement("condition");
        condition.addAttribute("queryType", queryType);

        for (Entry<String, Object> param : params.entrySet()) {
            Element item = condition.addElement("item");
            item.addElement("name").setText(param.getKey());
            item.addElement("value").setText(param.getValue().toString());
        }
        OutputFormat format = OutputFormat.createCompactFormat(); // createPrettyPrint() 层次格式化
        StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(document);
            writer.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return writer.toString();
    }

    /**
     * 获得指定节点指定属性值
     * @param element                   元素名称
     * @param attributeName             属性名称
     * @return
     */
    public static String getElementAttributeValue(Element element, String attributeName) {
        String value = "";
        try {
            value = element.attributeValue("attributeName");
        } catch (Exception ex) {
            logger.error("获得指定节点指定属性值出现异常： " + ex.getMessage());
        }
        return value;
    }

    /**
     * 获得指定元素下所有节点属性及值
     * @param element
     * @return
     */
    public static Map getNodeValues(Element element) {
        Element root = null;
        Map map = new HashMap();
        try {
            List list = element.elements();
            Element e = null;
            for (int i = 0; i < list.size(); i++) {
                e = (Element) list.get(i);
                map.put(e.getName(), e.getText());
            }
        } catch (Exception ex) {
            logger.error("获得指定元素下所有节点属性及值出现异常： " + ex.getMessage());
        }
        return map;
    }

    public static Element getRootElement(String xml) {
        Document doc = null;
        Element root = null;
        try {
            doc = DocumentHelper.parseText(xml);
            root = doc.getRootElement();
        } catch (Exception ex) {
            logger.error("解释xml文件出现异常:" + ex.getMessage());
        }
        return root;
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("corpName", "tyz");
        map.put("documentNo", "320503xxxx");
        System.out.println(createXML4PYRequest("1111", map));
    }

}
