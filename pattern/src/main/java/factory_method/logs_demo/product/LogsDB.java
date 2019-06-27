package factory_method.logs_demo.product;

/**
 * @author zhangcq
 * @Description: DB产品
 * @Time: 2019/3/4 14:16
 * @Version 1.0
 */
public class LogsDB implements Logs {
    @Override
    public void print() {
        System.out.println("将日志输出到数据库...");
    }
}