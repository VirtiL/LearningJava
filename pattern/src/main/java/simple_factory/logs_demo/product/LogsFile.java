package simple_factory.logs_demo.product;

/**
 * @author zhangcq
 * @Description: File产品
 * @Time: 2019/3/4 14:17
 * @Version 1.0
 */
public class LogsFile implements Logs {
    @Override
    public void print() {
        System.out.println("将日志输出到文件...");
    }
}