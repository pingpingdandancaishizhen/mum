/**
 * Copyright(C) 2011-2012 Muer DS. All Rights Reserved.
 * @title ExcelUtil.java
 * @package com.leo.fecalms.util
 * @compiler JDK1.6
 * @description TODO
 * @author Leo.Chen
 * @date 2011-12-15 下午1:00:16
 * @version V1.0  
 */

package cn.sunfit.risk.credit.server.util;

import org.apache.log4j.Logger;

/**
 * @className ExcelUtil
 * @description TODO
 * @author Leo.Chen
 * @date 2011-12-15 下午1:00:16
 */

public class ExcelUtil {
    private static Logger log = Logger.getLogger(ExcelUtil.class);

    public final static String TMP_PATH = "temp";
    public final static String EXCEL_EXTENSION = ".xls";
    /** 
    * Excel 2003 
    */
    public final static String XLS = "xls";
    /** 
     * Excel 2007 
     */
    public final static String XLSX = "xlsx";
    public final static String ERR = "ERR";
    public final static String ERR_FILENAME_NVL = "ERR_FILENAME_NVL";
    public final static String TEMPLATE_DIR = "template";
    public final static String CUSTOMER_TEMPLATE_NAME = "EXPORT_CUSTOMER.xls";
    public final static String CUSTOMERDRAFTIMPORT_TEMPLATE_NAME = "EXPORT_CUSTOMERDRAFTIMPORT.xls";
    public final static String HKTX_TEMPLATE_NAME = "fhktx.xls";
    public final static String JMSP_TEMPLATE_NAME = "jmsp.xls";
    public final static String CUSTOMERINFOFORKINGDEE_TEMPLATE_NAME = "CustomerInfoForKingdee.xls";
    public final static String CUSTOMERFINANCEFORKINGDEE_TEMPLATE_NAME = "CustomerFinanceForKingdee.xls";
    public final static String VOUCHERFORKINGDEE_TEMPLATE_NAME = "VoucherForKingdee.xls";
    public final static int ROWS_READ = 1000;// 每次读取的数据条数

}
