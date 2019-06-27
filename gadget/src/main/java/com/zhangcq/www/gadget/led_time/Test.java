package com.zhangcq.www.gadget.led_time;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.in;

/**
 * @author zhangcq
 * @Description: No Description
 * @Time: 2019/2/26 15:59
 * @Version 1.0
 */
public class Test {


    public static void main(String[] args) {

        Scanner scan = new Scanner(in);
        System.out.println("输入除1外的任意字符便可开始...");
        final Date date = new Date();
        while (scan.hasNext()){
            String s = scan.next().toString();
            if("1".equals(s)){
                System.out.println("已退出！");
            }else{
                System.out.println("已开始！");
                new Thread() {
                    @Override
                    public void run() {
                        Timer timer = new Timer(true);
                        TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                //1.获取当前时间
                                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                                String format = sdf.format(Calendar.getInstance().getTime());
                                System.out.println(format);
                                //2.拼接当前时间
                                String led = Number.getLED(format);
                                //3.输出当前时间
                                System.out.println(led);
                            }
                        };
                        timer.schedule(task,date, 1000L);
                    }
                }.start();
            }

        }




    }









}