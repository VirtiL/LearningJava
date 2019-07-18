package observer_pattern.v1;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-18 13:08
 * @Version 1.0
 */
public class Demo {


    public static void main(String[] args) {
        //TODO 如果这个被观察者不干活了呢?
        Commander trafficLight = new Commander();
        BMDriver bmDriver = new BMDriver(trafficLight);
        BTDriver btDriver = new BTDriver(trafficLight);
        trafficLight.addDriver(bmDriver);
        trafficLight.addDriver(btDriver);

        trafficLight.changeStatus("可以行使了    ");
        trafficLight.notifyDriver();

    }


}