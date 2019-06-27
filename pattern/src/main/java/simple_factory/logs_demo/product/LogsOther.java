package simple_factory.logs_demo.product;

/**
 * @author zhangcq
 * @Description: Other产品
 * @Time: 2019/3/4 14:17
 * @Version 1.0
 */
public class LogsOther implements Logs {
    @Override
    public void print() {
        System.out.println("将日志输出到指定位置...");
    }
}