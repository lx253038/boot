package com.mybatis.boot.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author LX
 * @Date 2020/2/21 10:25
 * @Description
 */
public class StringUtils {
    private static Calendar calendar = Calendar.getInstance();

    public static String getOrderStr() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        return dateFormat.format(new Date());

    }
}
