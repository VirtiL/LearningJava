package observer_pattern.v3;

/**
 * @Description:
 * @author: zhangcq
 * @Time: 2019-7-18 13:08
 * @Version 1.0
 */
public class Demo {


    public static void main(String[] args) {
        // TODO 事件委托,代写

        //发布者发布消息
        DengCommander dengCommander = new DengCommander();
        dengCommander.changeStatus();

        //委托者接收到消息并从传递出去
        //订阅者执行各自操作

    }


}