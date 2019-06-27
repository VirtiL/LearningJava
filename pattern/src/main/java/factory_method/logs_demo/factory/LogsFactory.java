package factory_method.logs_demo.factory;

import factory_method.logs_demo.product.Logs;

/**
 * @author zhangcq
 * @Description: 抽象工厂
 * @Time: 2019/3/4 14:04
 * @Version 1.0
 */
public abstract class LogsFactory {

    public void print() {
        Logs logger = this.createLogger();
        logger.print();

    }

    protected abstract Logs createLogger();

}