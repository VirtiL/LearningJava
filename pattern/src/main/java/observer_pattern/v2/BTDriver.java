package observer_pattern.v2;

/**
 * @Description: 本田司机
 * @author: zhangcq
 * @Time: 2019-7-18 13:04
 * @Version 1.0
 */
public class BTDriver implements Driver {

    private Commander trafficLight;


    public BTDriver(Commander trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        System.out.println(trafficLight.getStatus() + "本田司机开始直行!");
    }
}