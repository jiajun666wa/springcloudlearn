package com.whj.dateutils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @description: 设置描述信息
 * @author: whj
 * @createTime: 2021-12-29 10:03
 * @version: 1.0
 */
public class DateFormatUtils {
    public static void main(String[] args) {

//        SimpleDateFormat df1 = new SimpleDateFormat("YYYY-MM-dd", Locale.CHINA);
//        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
//        SimpleDateFormat df3 = new SimpleDateFormat("yyyy-mm-dd", Locale.CHINA);
        SimpleDateFormat df5 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.CHINA);
//        SimpleDateFormat df4 = new SimpleDateFormat();

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2021);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DATE, 27);
        System.out.println("Calendar"+c);

//        System.out.println("YYYY-MM-dd = "+ df1.format(c.getTime()));
//        System.out.println("yyyy-MM-dd = "+ df2.format(c.getTime()));
//        System.out.println("yyyy-mm-dd = "+ df3.format(c.getTime()));
        System.out.println("yyyy-mm-dd = "+ df5.format(c.getTime()));
//        System.out.println(""+ df4.format(c.getTime()));
//        System.out.println("=="+df1.format(new Date()));
//        System.out.println("=="+df2.format(new Date()));
//        System.out.println("=="+df3.format(new Date()));
//        System.out.println("=="+df4.format(new Date()));
//        System.out.println(DateFormat.getInstance().format(new Date(2021, 12, 27)));
//        System.out.println(DateFormat.getInstance().format(new Date()));

    }
}
