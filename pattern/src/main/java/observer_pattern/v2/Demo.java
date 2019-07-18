package observer_pattern.v2;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-18 13:08
 * @Version 1.0
 */
public class Demo {


    public static void main(String[] args) {
        // TODO 如果宝马想直行,本田想拐弯呢?
        Commander deng = new DengCommander();
        BMDriver bmDriver = new BMDriver(deng);
        BTDriver btDriver = new BTDriver(deng);
        deng.addDriver(bmDriver);
        deng.addDriver(btDriver);
        deng.changeStatus();
        deng.notifyDriver();


        Commander jiaojing = new JingCommander();
        BMDriver bmDriver1 = new BMDriver(jiaojing);
        BTDriver btDriver1 = new BTDriver(jiaojing);
        jiaojing.addDriver(bmDriver1);
        jiaojing.addDriver(btDriver1);
        jiaojing.changeStatus();
        jiaojing.notifyDriver();

    }


}