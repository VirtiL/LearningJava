package factory_method.logs_demo;

import factory_method.logs_demo.factory.DBLogsFactory;
import factory_method.logs_demo.factory.FileLogsFactory;
import factory_method.logs_demo.factory.LogsFactory;

/**
 * @author zhangcq
 * @Description: 客户端
 * @Time: 2019/3/4 14:18
 * @Version 1.0
 */
public class LogsClient {

    public static void main(String[] args) {
        LogsFactory logsFactory;
        logsFactory = new DBLogsFactory();
        logsFactory.print();
        logsFactory = new FileLogsFactory();
        logsFactory.print();

    }
}