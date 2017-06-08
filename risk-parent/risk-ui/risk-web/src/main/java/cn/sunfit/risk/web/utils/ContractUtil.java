package cn.sunfit.risk.web.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.sunfit.risk.buz.api.beans.util.ContractField;
import cn.sunfit.risk.buz.server.util.entity.ContractFillBody;
import cn.sunfit.risk.buz.server.util.entity.ContractFillContent;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ColumnText;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfStamper;

/**
 * 
 * @Title: ContractUtil.java
 * @Package cn.sunfit.risk.buz.server.util
 * @Description: 合同模板签署方法类
 * @author RJS
 * @date 2017年2月4日 下午1:25:40
 * @version V1.0
 */
public class ContractUtil {

    private static Logger log = LoggerFactory.getLogger(ContractUtil.class);

    private static final float TD_HEIGHT = 20;

    private static final float PDF_PADDING_BOTTOM = 56;

    /* 写入PDF的值的类型 start */
    /**
     * 文本类型
     */
    private static final String VAL_TYPE_TEXT = "1";
    /**
     * 表格类型
     */
    private static final String VAL_TYPE_TAB = "2";
    /**
     * 图片类型
     */
    private static final String VAL_TYPE_IMG = "3";

    public static void contractSign(PdfStamper stamper, ContractFillContent fc, BaseFont bf) throws IOException,
            DocumentException {
        if (fc.getTextList() != null && fc.getTextList().size() > 0) {
            formWrite(stamper, fc.getTextList(), bf);
        }
        if (fc.getTableList() != null && fc.getTableList().size() > 0) {
            for (ContractFillBody body : fc.getTableList()) {
                inTabToPDF(stamper, body, new Font(bf, 8));
            }
        }
        if (fc.getImageList() != null && fc.getImageList().size() > 0) {
            for (ContractFillBody body : fc.getImageList()) {
                inImgToPDF(stamper, body);
            }
        }
    }

    /**
     * 封装填充PDF的数据对象
     * @param values    将要填充到PDF的值数据
     * @return 返回封装好的数据对象
     */
    public static List<ContractFillContent> createFillContentList(List<ContractField> values) {
        List<ContractFillContent> list = new ArrayList<ContractFillContent>();

        if (values == null || values.size() == 0) {
            return list;
        }
        ContractFillContent c = null;
        List<ContractFillBody> textList = null;
        List<ContractFillBody> tableList = null;
        List<ContractFillBody> imageList = null;
        ContractFillBody body = null;
        Object val = null;
        int addToPage = 0;

        // PDF表单写入方式-值封装
        c = new ContractFillContent();
        c.setPage(1);
        c.setWriteType(2);
        textList = new ArrayList<ContractFillBody>();
        tableList = new ArrayList<ContractFillBody>();
        imageList = new ArrayList<ContractFillBody>();
        for (ContractField item : values) {
            body = new ContractFillBody();
            val = item.getValue();
            body.setShowText(val == null ? "" : val);
            body.setValKey(item.getKey());
            body.setValType(item.getType());
            if (VAL_TYPE_TEXT.equals(item.getType())) {
                textList.add(body);
            } else if (VAL_TYPE_TAB.equals(item.getType())) {
                tableList.add(body);
            } else if (VAL_TYPE_IMG.equals(item.getType())) {
                imageList.add(body);
            }
        }
        c.setTextList(textList);
        c.setTableList(tableList);
        c.setImageList(imageList);
        list.add(c);

        list.get(0).setAddToPage(addToPage);
        return list;
    }

    /**
     * PDF表单写入
     * @param stamper
     * @param fc
     * @throws IOException
     * @throws DocumentException
     */
    private static void formWrite(PdfStamper stamper, List<ContractFillBody> textList, BaseFont bf) throws IOException,
            DocumentException {
        AcroFields af = stamper.getAcroFields();
        af.addSubstitutionFont(bf);
        for (ContractFillBody body : textList) {
            af.setField(body.getValKey(), body.getShowText().toString());
        }
        stamper.setFormFlattening(true);
    }

    /**
     * @throws IOException 
     * @throws MalformedURLException 
     * @throws DocumentException 
     * 
     * @Title: inImgToPDF
     * @Description: 图片插入
     * @param @param stamper
     * @param @param body
     * @return void 
     * @author RJS 2017年2月28日 
     * @throws
     */
    private static void inImgToPDF(PdfStamper stamper, ContractFillBody body) throws DocumentException,
            MalformedURLException, IOException {
        int page = 0;
        PdfContentByte content = null;
        AcroFields form = stamper.getAcroFields();
        float[] position = form.getFieldPositions(body.getValKey());
        page = (int) position[0];
        content = stamper.getOverContent(page);

        Image img = Image.getInstance(new URL(body.getShowText().toString()));
        img.setAbsolutePosition(position[1], position[2]);
        img.scalePercent(10);
        content.addImage(img);
    }

    /**
     * 
     * @Title: inTabToPDF
     * @Description: PDF表格写入
     * @param @param stamper
     * @param @param body
     * @param @param addToPage
     * @param @param font
     * @param @throws DocumentException   
     * @return void 
     * @author RJS 2017年2月27日 
     * @throws
     */
    private static void inTabToPDF(PdfStamper stamper, ContractFillBody body, Font font) throws DocumentException {
        int residueRows = 0;
        int page = 0;
        List<List<String>> vals = (List<List<String>>) body.getShowText();
        PdfContentByte content = null;
        ColumnText ct = null;
        PdfPTable table = null;
        PdfPCell cell = null;
        AcroFields form = stamper.getAcroFields();
        float[] position = form.getFieldPositions(body.getValKey());
        page = (int) position[0];
        residueRows = (int) Math.floor((position[2] - 50) / TD_HEIGHT);
        content = stamper.getOverContent(page);
        ct = new ColumnText(content);
        ct.setSimpleColumn(position[1], position[2], 500, 50);
        table = new PdfPTable(vals.get(0).size());
        for (int i = 0; i < (vals.size() > residueRows ? residueRows : vals.size()); i++) {
            for (String v : vals.get(i)) {
                cell = new PdfPCell(new Phrase(v, font));
                cell.setFixedHeight(TD_HEIGHT);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);
            }
        }
        ct.addElement(table);
        ct.go();

        if (vals.size() > residueRows) {
            int pageTotalRoles = (int) Math.floor((PageSize.A4.getHeight() - 100) / TD_HEIGHT);
            int count = 0;
            while (residueRows < vals.size()) {
                count = 0;
                page++;
                stamper.insertPage(page, PageSize.A4);
                content = stamper.getOverContent(page);
                ct = new ColumnText(content);
                ct.setSimpleColumn(position[1], PageSize.A4.getHeight() - 50, 500, 50);
                table = new PdfPTable(vals.get(0).size());
                for (int i = residueRows; i < ((vals.size() - residueRows) > pageTotalRoles ? (residueRows + pageTotalRoles)
                        : vals.size()); i++) {
                    count++;
                    for (String v : vals.get(i)) {
                        cell = new PdfPCell(new Phrase(v, font));
                        cell.setFixedHeight(TD_HEIGHT);
                        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    }
                }
                residueRows += count;
                ct.addElement(table);
                ct.go();
            }
        }
    }

    /**
     * PDF位置写入
     * @param stamper
     * @param fc
     * @param pSize
     * @param pendingValType
     * @param pendingVal
     * @param font
     * @return
     */
    private static boolean locationWrite(PdfStamper stamper, ContractFillContent fc, int pSize,
            List<String> pendingValType, Map<String, ContractFillBody> pendingVal, Font font) {
        if (fc.getPage() > pSize || fc.getPage() <= 0) {
            log.error("wrong page setting on sign contract.all pages is:" + pSize + ",but you set page:" + fc.getPage());
            return false;
        } else {
            PdfContentByte over = stamper.getOverContent(fc.getPage()); // 指定第几页
            over.beginText();
            List<ContractFillBody> bodys = fc.getTextList();
            for (int j = 0; j < bodys.size(); j++) {
                ContractFillBody body = bodys.get(j);
                if (!"1".equals(body.getValType())) {
                    body.setPage(fc.getPage());
                    pendingValType.add(body.getValType() + j);
                    pendingVal.put(body.getValType() + j, body);
                    continue;
                }
                over.setFontAndSize(font.getBaseFont(), body.getFontSize());
                // 设置字体颜色
                over.setColorFill(body.getColor());
                // 设置字体的输出位置
                over.setTextMatrix(body.getMatrixX(), body.getMatrixY());
                // 要输出的text
                over.showText(body.getShowText().toString());
            }
            over.endText();
            return true;
        }
    }
}
