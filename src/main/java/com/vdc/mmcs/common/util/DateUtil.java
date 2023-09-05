package com.vdc.mmcs.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    public static String getToday(String type){
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        Calendar c1 = Calendar.getInstance();

        return sdf.format(c1.getTime());
    }
    public static String getNow(String format) { //yyyyMMddHHmmss
        Calendar currentDate = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(format); //yyyy-MM-dd HH:mm:ss
        //System.out.println(df.format(currentDate.getTime()));

        return df.format(currentDate.getTime());
    }
}
