package observer_pattern.v2;

/**
 * @Description: 指挥者
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