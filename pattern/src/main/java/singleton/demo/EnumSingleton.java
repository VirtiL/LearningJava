package singleton.demo;

/**
 * @Description: 枚举式(推荐)
 * @author zhangcq
 * @Time: 2019/2/18 18:02
 * @Version 1.0
 */
public enum EnumSingleton {
    /**
     * 实例
     */
    INSTANCE;

    EnumSingleton() {}

    public void print() {
        System.out.println("巴拉巴拉...");
    }
}
