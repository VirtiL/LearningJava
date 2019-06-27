package com.zhangcq.www.gadget.vacation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
/**
 * @Description: No Description
 * @author: zhangcq
 * @Time: 2019/3/20 14:28
 * @Version 1.0
 */
public class WorkDate {

    /***************************************************************************
     * 通过给定日期和工作日计算工作日以后的日期！
     *
     * @param beginDate
     * @param workDays
     */
    public static Date getDate(Date beginDate, int workDays, List<Vacation> list) {
        Date endDate = beginDate;
        Calendar calBegin = Calendar.getInstance();
        calBegin.setTime(beginDate);
        int count = 1;
        Calendar calFile = Calendar.getInstance();
        while (count <= workDays) {
            int tempBeginWeek = calBegin.get(Calendar.DAY_OF_WEEK);
            if (tempBeginWeek < 7 && tempBeginWeek > 1) {
                // 循环它的假期的天数！
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("至少应该循环两次！！");
                    Vacation vac = (Vacation) list.get(i);
                    Date fileDate = vac.getDate();
                    calFile.setTime(fileDate);
                    int fileDay = vac.getDays();
                    int tempFileDays = calFile.get(Calendar.DAY_OF_YEAR);// 年中的第几天
                    System.out.println("该假期是年中的第几天：" + tempFileDays);
                    System.out.println("今天是周几" + tempBeginWeek);
                    for (int j = tempFileDays; j < (tempFileDays + fileDay); j++) {
                        if (calBegin.get(Calendar.DAY_OF_YEAR) == j) {
                            System.out.println("应该有10月份的值！");
                            count--;
                        }
                    }
                }
                count++;
            }
            calBegin.add(Calendar.DATE, 1);
        }
        endDate = calBegin.getTime();
        return endDate;
    }

    /***************************************************************************
     * 从文件中获取节假日，返回一个集合！
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static List<Vacation> getListVacation(File file) throws Exception {
        List<Vacation> list = new ArrayList<Vacation>();
        list = (List<Vacation>) WorkDate.getVacationDateFromFile(file);
        return list;
    }

    /***************************************************************************
     * 标准输入，从屏幕输入起始日期和工作日参数!!
     *
     * @return
     */
    public static String[] getIn() {
        System.out.println("请输入起始日期和工作日参数@！！");
        String str = "";
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        String[] array = str.split(" ");
        while (true) {
            if (array.length <= 1) {
                System.out.println("请您正确输入所需的参数！");
                str = scanner.nextLine();
                array = str.split(" ");
            } else {
                break;
            }
        }
        return array;
    }

    /***************************************************************************
     * 将字符串进行拆分，返回一个Vacation对象！
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public static Vacation divideStr(String[] array) throws ParseException {
        Vacation vac = new Vacation();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(array[0]);
        vac.setDate(date);
        int days = Integer.parseInt(array[1]);
        vac.setDays(days);
        return vac;
    }

    /***************************************************************************
     * 从文件中读取字符串到集合中，然后返回集合。
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static List<Vacation> getVacationDateFromFile(File file)
            throws Exception {
        List<Vacation> list = new ArrayList<Vacation>();
        BufferedReader breader = new BufferedReader(new FileReader(file));
        String str = "";
        while ((str = breader.readLine()) != null) {
            Vacation vac = DateToDate.divideStr(str);
            list.add(vac);
        }
        return list;
    }

    public static void main(String args[]) {
        try {
            File file = new File("F:\\jinxing.txt");
            Vacation vac = WorkDate.divideStr(WorkDate.getIn());
            List<Vacation> list = WorkDate.getListVacation(file);
            Date date = WorkDate.getDate(vac.getDate(), vac.getDays(), list);
            System.out.println("到这了吗？");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = format.format(date);
            System.out.println(vac.getDays() + "个工作日后的日期为；" + strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}