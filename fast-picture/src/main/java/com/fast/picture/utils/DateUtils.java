package com.fast.picture.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author wanghe
 */
public class DateUtils {

    public static String getLocalMonth() {
        return new SimpleDateFormat("yyyy-MM").format(new Date());
    }

    public static String getLocalDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getLocalYear() {
        return new SimpleDateFormat("yyyy").format(new Date());
    }
}

