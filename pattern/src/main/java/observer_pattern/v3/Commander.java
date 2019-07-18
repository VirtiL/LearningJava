package observer_pattern.v3;

import observer_pattern.v2.Driver;

/**
 * @Description: 指挥者    抽象发布者
 * @author: zhangcq
 * @Time: 2019-7-18 13:05
 * @Version 1.0
 */
public interface Commander {

    void notifyDriver();

    void addDriver(Driver driver);

    void changeStatus();

    String getStatus();
}