package cn.sunfit.risk.web.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.ClientAnchor.AnchorType;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelHandleUtil {

    private static <T> void createSheetFirst(HSSFWorkbook workbook, String sheetName, String[] headers,
            Collection<T> dataSet, String pattern) throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为30个字节
        sheet.setDefaultColumnWidth(30);
        // 生成标题样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 标题字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 12);
        // 把字体应用到当前的样式
        style.setFont(font);

        // 生成内容样式
        HSSFCellStyle styleC = workbook.createCellStyle();
        // 设置这些样式
        styleC.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 标题字体
        HSSFFont fontC = workbook.createFont();
        fontC.setColor(HSSFColor.BLACK.index);
        // 把字体应用到当前的样式
        styleC.setFont(fontC);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        Iterator<T> iter = dataSet.iterator();
        int index = 0;
        while (iter.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = iter.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            int cellIndex = 0;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                if ("serialVersionUID".equals(fieldName) && i == 0) {
                    cellIndex--;
                    continue;
                } else if ("serialVersionUID".equals(fieldName) && i > 0) {
                    continue;
                }
                if (cellIndex == -1) {
                    cellIndex = 0;
                }
                HSSFCell cell = row.createCell(cellIndex);
                cell.setCellStyle(styleC);
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof Double) {
                        // textValue = formatter.format(value);
                        textValue = new DecimalFormat("######0.00").format(value);
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        // row.setHeightInPoints(60);
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(cellIndex, (short) (35.7 * 200));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 1023, 255, (short) 7, index, (short) 7,
                                index);
                        anchor.setAnchorType(AnchorType.MOVE_DONT_RESIZE);
                        patriarch.createPicture(anchor, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value == null ? "" : value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (Exception e) {
                    throw e;
                } finally {
                    workbook.close();
                }
                cellIndex++;
            }
        }
    }

    private static <T> void createSheetSecond(HSSFWorkbook workbook, String sheetName, String[] headers,
            Collection<T> dataSet, String pattern, List<Map<String, String>> tiList) throws Exception {
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(sheetName);
        // 设置表格默认列宽度为30个字节
        sheet.setDefaultColumnWidth(15);
        // sheet.setDefaultRowHeightInPoints(60);
        // 生成标题样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 标题字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.BLACK.index);
        font.setFontName("宋体");
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成内容样式
        HSSFCellStyle styleC = workbook.createCellStyle();
        // 设置这些样式
        styleC.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 标题字体
        HSSFFont fontC = workbook.createFont();
        fontC.setColor(HSSFColor.BLACK.index);
        // 把字体应用到当前的样式
        styleC.setFont(fontC);
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        BufferedImage bufferImg = null;
        HSSFClientAnchor anchor;
        for (Map<String, String> map : tiList) {
            try {
                CellRangeAddress region = new CellRangeAddress(Integer.parseInt(map.get("index")), Integer.parseInt(map
                        .get("index")), 0, 4);
                sheet.addMergedRegion(region);
                URL url = new URL(map.get("pieUrl"));
                URLConnection conn = url.openConnection();
                int a = 2, b = Integer.parseInt(map.get("index")) + 1, c = 10, d = Integer.parseInt(map.get("index")) + 9;
                ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
                bufferImg = ImageIO.read(conn.getInputStream());
                ImageIO.write(bufferImg, "png", byteArrayOut);
                // anchor主要用于设置图片的属性
                // 插入图片
                anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) a, b, (short) c, d);
                patriarch.createPicture(anchor,
                        workbook.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
                // b += 20;
                // d += 20;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString("");
            cell.setCellValue(text);
        }
        // 遍历集合数据，产生数据行
        Iterator<T> iter = dataSet.iterator();
        int index = 0;
        while (iter.hasNext()) {
            index++;
            row = sheet.createRow(index);
            row.setHeightInPoints(25);
            T t = iter.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            int cellIndex = 0;
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                String fieldName = field.getName();
                if ("serialVersionUID".equals(fieldName) && i == 0) {
                    cellIndex--;
                    continue;
                } else if ("serialVersionUID".equals(fieldName) && i > 0) {
                    continue;
                }
                if (cellIndex == -1) {
                    cellIndex = 0;
                }
                HSSFCell cell = row.createCell(cellIndex);
                cell.setCellStyle(styleC);
                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName, new Class[] {});
                    Object value = getMethod.invoke(t, new Object[] {});
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else if (value instanceof Double) {
                        // textValue = formatter.format(value);
                        textValue = value + "";
                    } else if (value instanceof byte[]) {
                        // 有图片时，设置行高为60px;
                        // 设置图片所在列宽度为80px,注意这里单位的一个换算
                        sheet.setColumnWidth(cellIndex, (short) (35.7 * 200));
                        // sheet.autoSizeColumn(i);
                        byte[] bsValue = (byte[]) value;
                        HSSFClientAnchor anchor1 = new HSSFClientAnchor(0, 0, 1023, 255, (short) 7, index, (short) 7,
                                index);
                        anchor1.setAnchorType(AnchorType.MOVE_DONT_RESIZE);
                        patriarch.createPicture(anchor1, workbook.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                    } else {
                        // 其它数据类型都当作字符串简单处理
                        textValue = value == null ? "" : value.toString();
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);
                        if (matcher.matches()) {
                            // 是数字当作double处理
                            cell.setCellValue(Double.parseDouble(textValue));
                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(textValue);
                            cell.setCellValue(richString);
                        }
                    }
                } catch (Exception e) {
                    throw e;
                } finally {
                    workbook.close();
                }
                cellIndex++;
            }
        }
    }

    /**
     * 导出Excel
     * 
     * @param sheetName Sheet的名称
     * @param headers Sheet中字段标题
     * @param dataset Sheet中内容,按Java Bean中字段的顺序依次排列 e.g. List<JavaBean>
     * @param out 输出流
     * @param pattern Date类型要转换的日期格式e.g.yyyy-MM-dd hh:MM:ss
     * @return void 
     * @throws
     */
    public static <T> void exportExcel(String sheetName, String[] headers, Collection<T> dataSet, OutputStream out,
            String pattern) throws Exception {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        createSheetFirst(workbook, sheetName, headers, dataSet, pattern);
        try {
            workbook.write(out);
        } catch (IOException e) {
            throw e;
        } finally {
            workbook.close();
        }
    }

    public static <T> void exportExcelMoreSheet(String[] sheetName, String[] headers, Collection<T> dataSet,
            Collection<T> dataSet1, OutputStream out, String pattern, List<Map<String, String>> tiList)
            throws Exception {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        createSheetFirst(workbook, sheetName[0], headers, dataSet, pattern);
        createSheetSecond(workbook, sheetName[1], headers, dataSet1, pattern, tiList);
        try {
            workbook.write(out);
        } catch (IOException e) {
            throw e;
        } finally {
            workbook.close();
        }
    }

    public static void main(String[] args) {
        Pattern p = Pattern.compile("^[0-9]{8,8}-[A-Z]{1,1}|[A-Z]{8,8}-[0-9]{1,1}$");
        Matcher matcher = p.matcher("123456B8-A");
        System.out.println(matcher.matches());
    }
}
