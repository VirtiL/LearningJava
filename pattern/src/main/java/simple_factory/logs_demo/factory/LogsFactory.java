package simple_factory.logs_demo.factory;

import simple_factory.logs_demo.product.Logs;
import simple_factory.logs_demo.product.LogsDB;
import simple_factory.logs_demo.product.LogsFile;
import simple_factory.logs_demo.product.LogsOther;

/**
 * @author zhangcq
 * @Description: 工厂
 * @Time: 2019/3/4 14:04
 * @Version 1.0
 */
public class LogsFactory {

    public static Logs print(LogsType logsType){
        Logs logs = null;
        switch (logsType){
            case LOG_DB:
                logs = new LogsDB();
                break;
            case LOG_File:
                logs = new LogsFile();
                break;
            case LOG_OTHER:
                logs = new LogsOther();
                break;
            default:
                break;
        }

        return logs;

    }


}