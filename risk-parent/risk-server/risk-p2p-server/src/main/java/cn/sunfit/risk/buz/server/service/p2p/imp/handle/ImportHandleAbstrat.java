package cn.sunfit.risk.buz.server.service.p2p.imp.handle;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import cn.sunfit.risk.buz.api.beans.corp.District;
import cn.sunfit.risk.buz.api.beans.p2p.P2PProduct;
import cn.sunfit.risk.buz.api.beans.p2p.order.LoanInfoBean;
import cn.sunfit.risk.buz.api.beans.system.CarBrand;
import cn.sunfit.risk.buz.api.beans.system.CarModel;
import cn.sunfit.risk.buz.api.beans.system.CarSeries;
import cn.sunfit.risk.buz.api.constants.BaseEnum;
import cn.sunfit.risk.buz.api.service.system.DistrictService;
import cn.sunfit.risk.buz.api.vo.p2p.imp.ImportError;
import cn.sunfit.risk.buz.api.vo.p2p.product.config.Term;
import cn.sunfit.risk.buz.server.dao.system.CarBrandDAO;
import cn.sunfit.risk.buz.server.dao.system.CarModelDAO;
import cn.sunfit.risk.buz.server.dao.system.CarSeriesDAO;
import cn.sunfit.risk.buz.server.service.p2p.imp.ImportHandle;
import cn.sunfit.risk.buz.server.util.p2p.DataDisposeUtil;

/**
 * 
 * @Title: ImportHandleAbstrat.java
 * @Package cn.sunfit.risk.buz.server.service.p2p.imp.handle
 * @Description: 各种类型的EXCEL导入公共代码可写在这里面
 * @author DELL
 * @date 2017年5月5日 下午1:10:49
 * @version V1.0
 */
public abstract class ImportHandleAbstrat implements ImportHandle {

    private static List<District> districts;

    Logger logger = LoggerFactory.getLogger(ImportHandleAbstrat.class);

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CarBrandDAO carBrandDAO;

    @Autowired
    private CarSeriesDAO carSeriesDAO;

    @Autowired
    private CarModelDAO carModelDAO;

    protected DataDisposeUtil dataUtil = new DataDisposeUtil<LoanInfoBean>();

    protected boolean carBSMValidate(String key, String value, Map<String, Object> data) {
        if (StringUtils.isNotBlank(value)) {
            if (key.endsWith("Brand")) {
                List<CarBrand> brandList = carBrandDAO.selectAllCarBrand();
                for (CarBrand brand : brandList) {
                    if (brand.getBrandName().equals(value)) {
                        data.put("BrandKey", brand.getBrandId());
                        return true;
                    }
                }
                return false;
            } else if (key.endsWith("Series")) {
                List<CarSeries> seriseList = carSeriesDAO.selectAllCarSeries();
                for (CarSeries series : seriseList) {
                    if (series.getSeriesName().equals(value) && data.get("BrandKey") != null
                            && series.getBrandId().equals((int) data.get("BrandKey"))) {
                        data.put("SeriesKey", series.getSeriesId());
                        return true;
                    }
                }
                return false;
            } else if (key.endsWith("Models")) {
                List<CarModel> modelList = carModelDAO.selectAllCarModel();
                for (CarModel model : modelList) {
                    if (model.getModelName().equals(value) && data.get("SeriesKey") != null
                            && model.getSeriesId().equals((int) data.get("BrandKey"))) {
                        return true;
                    }
                }
                return false;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    protected void cellCheck(XSSFCell cell, List<String> cellNames, List<Map<String, Object>> checkTemps, int index,
            Map<String, Object> data, ImportError err, int row, List<Term> termList, P2PProduct products) {
        Map<String, Object> checkTemp = checkTemps.get(index);

        String cellValue = getCellValue(cell);
        if (StringUtils.isBlank(cellValue)) {
            if (checkTemp.get("isNotNull") != null && (boolean) checkTemp.get("isNotNull")) {
                getErrObj(cell, data, row, index, cellNames.get(index) + "不能为空", err);
            }
        } else {
            String key = checkTemp.get("key").toString();
            String parentKey = checkTemp.get("parentKey") != null ? checkTemp.get("parentKey").toString() : null;
            // 如值为空进来，那么定为非必填，如必填进来，则值必定不为空
            if (cell == null || "".equals(cellValue)) {
                data.put(key, null);
            } else {
                String value = cellValue.replace(" ", "");
                // 如果列有指定只能填写的项值，那么只需要判断值有没有匹配
                if (checkTemp.containsKey("baseEnums")) {
                    BaseEnum[] BaseEnums = (BaseEnum[]) checkTemp.get("baseEnums");
                    boolean type = false;
                    BaseEnum val = null;
                    for (BaseEnum be : BaseEnums) {
                        if (be.getEnumName().equals(value)) {
                            type = true;
                            val = be;
                            break;
                        }
                    }
                    if (!type) {
                        getErrObj(cell, data, row, index, cellNames.get(index) + "系统中不存在", err);
                    } else {
                        data.put(key, valConvertType(val.getEnumType(), checkTemp.get("type").toString()));
                    }
                } else if (checkTemp.containsKey("valItem")) {
                    List<String> valItem = (List<String>) checkTemp.get("valItem");
                    if (!valItem.contains(value)) {
                        getErrObj(cell, data, row, index, cellNames.get(index) + "系统中不存在", err);
                    } else {
                        data.put(key, valConvertType(value, checkTemp.get("type").toString()));
                    }
                } else {
                    if (!hasValType(value, checkTemp.get("checkWay").toString())
                            || !(checkTemp.containsKey("checkFun") ? checkFun(checkTemp.get("checkFun").toString(),
                                    value, key, parentKey, data, termList, products) : true)) {
                        getErrObj(cell, data, row, index, cellNames.get(index) + checkTemp.get("typeName").toString(),
                                err);
                    } else if (checkTemp.containsKey("length")
                            && value.length() > Integer.valueOf(checkTemp.get("length").toString())) {
                        getErrObj(cell, data, row, index, cellNames.get(index) + "输入长度不可超过"
                                + checkTemp.get("length").toString(), err);
                    } else if (checkTemp.containsKey("idCardDateValidate") && !idCardDateValidate(value)) {
                        getErrObj(cell, data, row, index, cellNames.get(index) + "已过期", err);
                    } else {
                        data.put(key, valConvertType(value, checkTemp.get("type").toString()));
                    }
                }
            }
        }
    }

    private boolean checkFun(String fun, String val, String key, String parentKey, Map<String, Object> data,
            List<Term> termList, P2PProduct products) {
        if ("idCarValidate".equals(fun)) {
            return idCarValidate(val);
        } else if ("districtValidate".equals(fun)) {
            return districtValidate(val, key, parentKey, data);
        } else if ("periodValidate".equals(fun)) {
            return periodValidate(val, key, parentKey, data, termList);
        } else if ("carBSMValidate".equals(fun)) {
            return carBSMValidate(key, val, data);
        } else if ("dateValidate".equals(fun)) {
            return dateValidate(val);
        } else if ("productNameValidate".equals(fun)) {
            return productNameValidate(val, products);
        } else if ("productCodeValidate".equals(fun)) {
            return productCodeValidate(val, products);
        }
        return false;
    }

    private boolean dateValidate(String val) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(val);
            return val.equals(formatter.format(date));
        } catch (Exception e) {
            formatter = new SimpleDateFormat("yyyy/MM/dd");
            try {
                Date date = formatter.parse(val);
                return val.equals(formatter.format(date));
            } catch (Exception e1) {
                return false;
            }
        }
    }

    private boolean districtValidate(String district, String key, String parentKey, Map<String, Object> data) {
        List<District> dists = getDistricts();
        District parent = null;
        if (parentKey != null)
            parent = (District) data.get(parentKey + "Dis");
        String newDistName = null;
        for (District d : dists) {
            if (parent != null) {
                newDistName = d.getDistName().endsWith("市") || d.getDistName().endsWith("区")
                        || d.getDistName().endsWith("县") ? d.getDistName().substring(0, d.getDistName().length() - 1)
                        : d.getDistName();
                if (d.getParentCode().equals(parent.getDistCode())
                        && (d.getDistName().equals(district) || newDistName.equals(district))) {
                    data.put(key + "Dis", d);
                    return true;
                }
            } else {
                newDistName = d.getDistName().replace("省", "");
                if ((d.getDistName().equals(district) || newDistName.equals(district)) && "1".equals(d.getParentCode())) {
                    data.put(key + "Dis", d);
                    return true;
                }
            }
        }
        return false;
    }

    protected List<String> getCellNames(XSSFRow row) {
        if (row == null)
            return null;
        List<String> cellNames = new ArrayList<String>();
        int totalCellNum = row.getLastCellNum();
        XSSFCell cell = null;
        for (int i = 0; i < totalCellNum; i++) {
            cell = row.getCell(i);
            if (cell != null) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                cellNames.add(cell.getStringCellValue().replace("*", ""));
            }
        }
        return cellNames;
    }

    private String getCellValue(XSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
                case XSSFCell.CELL_TYPE_NUMERIC: {
                    short format = cell.getCellStyle().getDataFormat();
                    if (format == 14 || format == 31 || format == 57 || format == 58) { // excel中的时间格式
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil.getJavaDate(value);
                        cellvalue = sdf.format(date);
                    }
                    // 判断当前的cell是否为Date
                    else if (HSSFDateUtil.isCellDateFormatted(cell)) { // 先注释日期类型的转换，在实际测试中发现HSSFDateUtil.isCellDateFormatted(cell)只识别2014/02/02这种格式。
                        // 如果是Date类型则，取得该Cell的Date值 // 对2014-02-02格式识别不出是日期格式
                        Date date = cell.getDateCellValue();
                        DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = formater.format(date);
                    } else { // 如果是纯数字
                        // 取得当前Cell的数值
                        cellvalue = NumberToTextConverter.toText(cell.getNumericCellValue());

                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case XSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getStringCellValue().replaceAll("'", "''");
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    cellvalue = null;
                    break;
                // 默认的Cell值
                default: {
                    cellvalue = " ";
                }
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    private List<District> getDistricts() {
        if (districts == null) {
            districts = districtService.selectNodes();
        }
        return districts;
    }

    /**
     * 封装错误提示
     * @Title: getErrObj
     * @Description: TODO
     * @param @param cell
     * @param @param data
     * @param @param index
     * @param @param err
     * @param @return   
     * @return Map<String,Object> 
     * @author RJS 2017年4月12日 
     * @throws
     */
    private void getErrObj(XSSFCell cell, Map<String, Object> data, int row, int index, String err, ImportError errObj) {
        errObj.setLine(row);
        if (index == 0) {
            errObj.setLoanId(cell == null ? "无" : cell.getStringCellValue());
        } else {
            errObj.setLoanId(data.get("thirdLoanId").toString());
        }
        errObj.setErrorInfo(err);
    }

    private boolean hasValType(String val, String checkWay) {
        if (checkWay == null || "".equals(checkWay))
            return true;
        if (val.matches(checkWay))
            return true;
        return false;
    }

    private boolean idCardDateValidate(String val) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formatter.parse(val);
            Date currDate = new Date();
            if (date.before(currDate)) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 判断身份证格式
     * 
     * @param idNum
     * @return
     */
    private boolean idCarValidate(String idNum) {
        // 中国公民身份证格式：长度为15或18位，最后一位可以为字母
        Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9xX])|(\\d{17}[0-9xX])");
        // 格式验证
        if (!idNumPattern.matcher(idNum).matches())
            return false;
        // 合法性验证
        int year = 0;
        int month = 0;
        int day = 0;
        if (idNum.length() == 15) {
            // 一代身份证
            logger.debug("一代身份证：" + idNum);
            // 提取身份证上的前6位以及出生年月日
            Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{2})(\\d{2})(\\d{2}).*");
            Matcher birthDateMather = birthDatePattern.matcher(idNum);
            if (birthDateMather.find()) {
                year = Integer.valueOf("19" + birthDateMather.group(1));
                month = Integer.valueOf(birthDateMather.group(2));
                day = Integer.valueOf(birthDateMather.group(3));
            }
        } else if (idNum.length() == 18) {
            // 二代身份证
            logger.debug("二代身份证：" + idNum);
            // 提取身份证上的前6位以及出生年月日
            Pattern birthDatePattern = Pattern.compile("\\d{6}(\\d{4})(\\d{2})(\\d{2}).*");
            Matcher birthDateMather = birthDatePattern.matcher(idNum);
            if (birthDateMather.find()) {
                year = Integer.valueOf(birthDateMather.group(1));
                month = Integer.valueOf(birthDateMather.group(2));
                day = Integer.valueOf(birthDateMather.group(3));
            }
        }
        // 年份判断，100年前至今
        Calendar cal = Calendar.getInstance();
        // 当前年份
        int currentYear = cal.get(Calendar.YEAR);
        if (year <= currentYear - 100 || year > currentYear)
            return false;
        // 月份判断
        if (month < 1 || month > 12)
            return false;
        // 日期判断
        // 计算月份天数
        int dayCount = 31;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayCount = 31;
                break;
            case 2:
                // 2月份判断是否为闰年
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    dayCount = 29;
                    break;
                } else {
                    dayCount = 28;
                    break;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                dayCount = 30;
                break;
        }
        logger.debug(String.format("生日：%d年%d月%d日", year, month, day));
        logger.debug(month + "月份有：" + dayCount + "天");
        if (day < 1 || day > dayCount)
            return false;
        return true;
    }

    protected boolean isNotEmpty(XSSFRow row, int cellLength) {
        if (row == null)
            return false;
        XSSFCell cell = null;
        for (int i = 0; i < cellLength; i++) {
            cell = row.getCell(i);
            if (cell != null) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
                if (StringUtils.isNotEmpty(cell.getStringCellValue()))
                    return true;
            }
        }
        return false;
    }

    private boolean periodValidate(String period, String key, String parentKey, Map<String, Object> data,
            List<Term> termList) {
        if (!CollectionUtils.isEmpty(termList)) {
            for (Term term : termList) {
                if (term.getTermName().equals(period)) {
                    period = term.getTerm();
                    return true;
                }
            }
        }
        // String repayType = data.get(parentKey).toString();
        // List<LoanEachTimeType> letts = null;
        // if ("3".equals(repayType)) {
        // letts = LoanEachTimeType.getEnumByNameSuffix("天");
        // } else {
        // letts = LoanEachTimeType.getEnumByNameSuffix("月");
        // }
        //
        // for (LoanEachTimeType lett : letts) {
        // if (lett.getStatus().equals(period))
        // return true;
        // }

        return false;
    }

    private boolean productCodeValidate(String val, P2PProduct products) {
        if (StringUtils.isNotBlank(val) && products != null && StringUtils.isNotBlank(products.getProductCode())) {
            return products.getProductCode().equals(val);
        }
        return true;
    }

    private boolean productNameValidate(String val, P2PProduct products) {
        if (StringUtils.isNotBlank(val) && products != null && StringUtils.isNotBlank(products.getProductName())) {
            return products.getProductName().equals(val);
        }
        return true;
    }

    private Object valConvertType(String val, String type) {
        if ("Long".equals(type)) {
            return Long.valueOf(val);
        } else if ("Double".equals(type)) {
            return Double.valueOf(val);
        } else if ("BigDecimal".equals(type)) {
            return BigDecimal.valueOf(Double.valueOf(val));
        } else if ("Integer".equals(type)) {
            return Integer.valueOf(val);
        } else {
            return val;
        }
    }
}
