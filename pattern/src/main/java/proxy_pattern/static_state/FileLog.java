package proxy_pattern.static_state;

/**
 * @Description: 目标对象
 * @author: zhangcq
 * @Time: 2019/03/26 0026 16:05:58
 * @Version 1.0
 */
public class FileLog implements Log{


    @Override
    public void print() {
        System.out.println("输出日志到文件!");
    }
}