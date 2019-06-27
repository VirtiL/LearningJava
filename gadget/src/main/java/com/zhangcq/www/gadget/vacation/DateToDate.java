package com.zhangcq.www.gadget.vacation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2019/3/20 14:27
 * @Version 1.0
 */
public class DateToDate {

    /***************************************************************************
     * 在beginDate和endDate之间所包含假期的天数，若不包含则返回0； 假期和周末分别进行单独考虑！
     *
     * @param list
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getContainVacation(List list, Date beginDate, Date endDate) {
        int days = 0;
        Calendar begincal = new GregorianCalendar();
        Calendar endcal = new GregorianCalendar();
        begincal.setTime(beginDate);
        endcal.setTime(endDate);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("执行到这里了！");
            Vacation vac = (Vacation) list.get(i);
            Date tempDate = vac.getDate();
            Calendar tempcal = new GregorianCalendar();
            tempcal.setTime(tempDate);
            int tempDays = vac.getDays();
            int tempDay = tempcal.get(Calendar.DAY_OF_YEAR);
            int dd = 0;
            if ((tempDate.after(endDate)) || (tempDate.before(beginDate))) {
                System.out.println(tempDate.after(endDate));
                System.out.println("执行到这里了吗？？？！");
                continue;
            } else {
                System.out.println("应该执行到这里了！@");
                while (tempDay < endcal.get(Calendar.DAY_OF_YEAR)
                        && dd < tempDays) {
                    System.out.println("符合条件吗？？？？");
                    // tempcal.set(Calendar.DAY_OF_MONTH,tempDay);//原来是你在作怪！
                    // 节假日和周末可能有重叠的情况！
                    if ((tempcal.get(Calendar.DAY_OF_WEEK)) == 2
                            || (tempcal.get(Calendar.DAY_OF_WEEK) == 1)) {
                        System.out
                                .println((tempcal.get(Calendar.DAY_OF_WEEK)) == 2);
                        System.out
                                .println((tempcal.get(Calendar.DAY_OF_WEEK) == 1));
                        System.out.println("节假日和周末重叠的情况！"
                                + tempcal.get(Calendar.DAY_OF_WEEK));
                        days--;
                    }
                    tempcal.add(Calendar.DAY_OF_WEEK, 1);
                    dd++;// 计数器自增，不能超出法定的假期数。
                    days++;// 符合这两种条件的自增。看一下有多少天！
                    tempDay++;// 法定假日自增，不能超出endDate的日期数！
                }
            }
        }
        // 单独考虑周末的情况！不知道哪一个数字代表周六，周日！
        System.out.println("周末！");
        for (int j = begincal.get(Calendar.DAY_OF_YEAR); j <= endcal
                .get(Calendar.DAY_OF_YEAR); j++) {
            if (begincal.get(Calendar.DAY_OF_WEEK) == 7
                    || begincal.get(Calendar.DAY_OF_WEEK) == 1) {
                System.out.println("周末判断！");
                days++;
            }
            begincal.add(Calendar.DAY_OF_YEAR, 1);
        }
        return days;
    }

    /***************************************************************************
     * 从文件中读取字符串到集合中，然后返回集合。
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static List getDateFromFile(File file) throws Exception {
        List list = new ArrayList();
        BufferedReader breader = new BufferedReader(new FileReader(file));
        String str = "";
        while ((str = breader.readLine()) != null) {
            Vacation vac = DateToDate.divideStr(str);
            list.add(vac);
        }
        System.out.println(list);
        return list;
    }

    /***************************************************************************
     * 将字符串最终切割成一个假期对象！
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static Vacation divideStr(String str) throws ParseException {
        Vacation vac = new Vacation();
        String[] array = str.split(" ");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(array[0]);
        int days = Integer.parseInt(array[1]);
        vac.setDate(date);
        vac.setDays(days);
        return vac;
    }

    /***************************************************************************
     * 输入的前后两天之间的相差的天数！
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public static int getDays(Date beginDate, Date endDate) {
        long days = 0;
        try {
            if (beginDate.compareTo(endDate) > 0) {
                throw new IllegalArgumentException("日期输入不正确!");
            }
            days = (endDate.getTime() - beginDate.getTime())
                    / (1000 * 60 * 60 * 24);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return (int) days;
    }

    /***
     * 从键盘标准输入两个日期！
     *
     * @return
     */
    public static String[] getInDate() {
        System.out.println("请输入开始和结束日期！格式如下：yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] array = str.split(" ");
        return array;
    }

    public static void main(String args[]) {
        String[] str = DateToDate.getInDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date beginDate = format.parse(str[0]);
            Date endDate = format.parse(str[1]);
            File file = new File("F:\\jinxing.txt");
            List list = DateToDate.getDateFromFile(file);
            int days = DateToDate.getContainVacation(list, beginDate, endDate);
            System.out.println("总共的节假日包括周末：" + days);
            int allday = DateToDate.getDays(beginDate, endDate);
            System.out.println("总共的天数：" + allday);
            System.out.println("总共的工作日为：" + (allday - days));
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}