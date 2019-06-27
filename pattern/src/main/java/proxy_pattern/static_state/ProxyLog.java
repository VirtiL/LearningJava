package proxy_pattern.static_state;

/**
 * @Description: 代理对象
 * @author: zhangcq
 * @Time: 2019/03/26 0026 16:07:06
 * @Version 1.0
 */
public class ProxyLog implements Log{

    private Log log;

    public ProxyLog(Log log){
        this.log = log;
    }

    @Override
    public void print() {
        System.out.println("输出日志前开启事务!");
        log.print();
        System.out.println("输出日志后提交并关闭事务!");

    }
}