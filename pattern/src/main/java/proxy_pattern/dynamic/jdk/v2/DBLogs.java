package proxy_pattern.dynamic.jdk.v2;

/**
 * @Description: DB日志
 * @author: zhangcq
 * @Time: 2019/03/26 16:49:06
 * @Version 1.0
 */
public class DBLogs implements Log {


    @Override
    public void insert() {
        System.out.println("将日志插入数据库!");
    }

    @Override
    public String save(String aaa) {
        System.out.println("aaa");
        return "aaa";
    }
}