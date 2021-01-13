package singleton.demo;

/**
 * @Description: 枚举式单例(最完美的线程安全单例写法)
 * @Author: virtiL
 * @Time: 2021/1/13 13:58
 */
public enum EnumSingleton {

    INSTANCE;

    private Object data;

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
