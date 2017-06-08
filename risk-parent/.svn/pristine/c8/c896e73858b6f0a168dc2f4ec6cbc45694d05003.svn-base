package cn.sunfit.risk.credit.server.util;

import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import orj.worf.util.DateUtils;

public class IdUtil {
    public static String geneId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String generateBPContratNo(String productId) {
        String time = DateUtils.format("yyyyMMddHHmmss", new Date());
        String random = StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(999, 9999)), 4, '0');
        return productId + "-C-" + time + random;
    }

    public static String generateBPFangkuanNo(String productId) {
        String time = DateUtils.format("yyyyMMddHHmmss", new Date());
        String random = StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(999, 9999)), 4, '0');
        return productId + "-F-" + time + random;
    }

    public static String generateBPNo(String productId) {
        String time = DateUtils.format("yyyyMMddHHmmss", new Date());
        String random = StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(999, 9999)), 4, '0');
        return productId + "-" + time + random;
    }

    public static String generateBPYapinNo(String productId) {
        String time = DateUtils.format("yyyyMMddHHmmss", new Date());
        String random = StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(999, 9999)), 4, '0');
        return productId + "-Y-" + time + random;
    }

    public static String generateHKRecordNo() {
        String time = DateUtils.format("yyyyMMddHHmmss", new Date());
        String random = StringUtils.leftPad(String.valueOf(RandomUtils.nextInt(999, 9999)), 4, '0');
        return "HK-" + time + random;
    }

    public static void main(String[] args) {
        System.out.println(geneId());
    }
}
