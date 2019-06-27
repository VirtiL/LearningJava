package com.zhangcq.www.gadget.redis_queue;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-6-26 17:46
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        ShengChan shengChan = new ShengChan();
        shengChan.start();
        ShengChan shengChan2 = new ShengChan();
        shengChan2.start();
        XiaoFei xiaoFei = new XiaoFei();
        xiaoFei.start();
        XiaoFei xiaoFei2 = new XiaoFei();
        xiaoFei2.start();
        XiaoFei xiaoFei3 = new XiaoFei();
        xiaoFei3.start();
        XiaoFei xiaoFei4= new XiaoFei();
        xiaoFei4.start();
        XiaoFei xiaoFei5 = new XiaoFei();
        xiaoFei5.start();
        XiaoFei xiaoFei6 = new XiaoFei();
        xiaoFei6.start();
    }
}