package factory_method.logs_demo.factory;

import factory_method.logs_demo.product.Logs;
import factory_method.logs_demo.product.LogsDB;

/**
 * @author zhangcq
 * @Description: DB工厂
 * @Time: 2019/3/8 13:36
 * @Version 1.0
 */
public class DBLogsFactory extends LogsFactory {
    @Override
    protected Logs createLogger() {
        return new LogsDB();
    }
}