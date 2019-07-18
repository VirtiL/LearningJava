package observer_pattern.v2;

/**
 * @Description: 宝马司机
 * @author: zhangcq
 * @Time: 2019-7-18 13:04
 * @Version 1.0
 */
public class BMDriver implements Driver {

    private Commander trafficLight;


    public BMDriver(Commander trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void run(){
        System.out.println(trafficLight.getStatus() + "宝马司机开始直行!");
    }

}