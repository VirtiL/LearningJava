package com.zhangcq.www.gadget.data_count;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2019/3/20 16:01
 * @Version 1.0
 */
public class DataCount {

    /**
     * 方法1：通过Calendar类的日期比较。
     * 注意：这里需要考虑一下：日期是跨年份的，
     * 如一个是2012年，一个是2015年的年份是分闰年和平年的，各自的天数不同
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        //同一年
        if(year1 != year2)
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                //闰年
                if(i%4==0 && i%100!=0 || i%400==0)
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            return day2-day1;
        }
    }


    /**
     * 方法1：通过Calendar类的日期比较。
     * 注意：这里需要考虑一下：日期是跨年份的，
     * 如一个是2012年，一个是2015年的年份是分闰年和平年的，各自的天数不同
     * date2比date1多的天数,如果数据异常返回-1
     * @param beginData
     * @param endData
     * @param formatStr  日期格式
     * @return -1表示数据异常
     */
    public static int differentDays(String beginData,String endData,String formatStr){
        if("".equals(formatStr) || formatStr == null){
            formatStr = "yyyy-MM-dd";
        }
        try{
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            Date date = format.parse(beginData);
            Date date2 = format.parse(endData);
            return differentDays(date, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }


    /**
     * 方式二，是通过计算两个日期相差的毫秒数来计算两个日期的天数差的。
     * 一样会有一个小问题，就是当他们相差是23个小时的时候，它就不算一天了。
     * 如下面的两个日期
     * 2015-1-1 21:21:28
     * 2015-1-2 1:21:28
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1,Date date2){
        int oneDayNum = 1000*3600*24;
        int days = (int) ((date2.getTime() - date1.getTime()) / oneDayNum);
        if(days == 0 && ((date2.getTime() - date1.getTime()) % oneDayNum > 0)){
            return 1;
        }
        return days;
    }
    /**
     * 方式二，是通过计算两个日期相差的毫秒数来计算两个日期的天数差的。
     * 一样会有一个小问题，就是当他们相差是23个小时的时候，它就不算一天了。
     * 如下面的两个日期
     * 2015-1-1 21:21:28
     * 2015-1-2 1:21:28
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param beginData
     * @param endData
     * @param formatStr 日期格式
     * @return -1表示数据异常
     */
    public static int differentDaysByMillisecond(String beginData,String endData,String formatStr){
        if("".equals(formatStr) || formatStr == null){
            formatStr = "yyyy-MM-dd";
        }
        try{
            SimpleDateFormat format = new SimpleDateFormat(formatStr);
            Date date = format.parse(beginData);
            Date date2 = format.parse(endData);
            return differentDaysByMillisecond(date, date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 根据万年历得到两个日期一共经历几天
     * 比如:2019-01-02 到 2019-01-03 算2天
     * @param beginData
     * @param endData
     * @param formatStr
     * @return
     */
    public static int dayCountByCalendar(String beginData,String endData,String formatStr){
        return differentDays(beginData, endData, formatStr)+1;
    }
    /**
     * 根据时间戳得到两个日期一共经历几天
     * 比如:2019-01-02 到 2019-01-03 算2天
     * @param beginData
     * @param endData
     * @param formatStr
     * @return
     */
    public static int dayCountByMillisecond(String beginData,String endData,String formatStr){
        return differentDaysByMillisecond(beginData, endData, formatStr)+1;
    }



    public static void main(String[] args){
        String dateStr = "2015-1-1";
        String dateStr2 = "2015-1-3";
        System.out.println("两个日期的差距：" + differentDays(dateStr,dateStr2,"yyyy-MM-dd"));
        System.out.println("两个日期的差距：" + differentDaysByMillisecond(dateStr,dateStr2,"yyyy-MM-dd"));

    }

}