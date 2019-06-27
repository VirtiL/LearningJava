package simple_factory.logs_demo;

import simple_factory.logs_demo.factory.LogsFactory;
import simple_factory.logs_demo.factory.LogsType;
import simple_factory.logs_demo.product.Logs;

/**
 * @author zhangcq
 * @Description: 客户端
 * @Time: 2019/3/4 14:18
 * @Version 1.0
 */
public class LogsClient {

    public static void main(String[] args) {
        Logs logs;
        logs = LogsFactory.print(LogsType.LOG_DB);
        logs.print();
        logs = LogsFactory.print(LogsType.LOG_File);
        logs.print();
        logs = LogsFactory.print(LogsType.LOG_OTHER);
        logs.print();
    }
}